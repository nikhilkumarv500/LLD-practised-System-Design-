import java.util.*;

import Board.Board;
import Enum.Color;
import Match.Match;
import Model.Position;
import Model.User;
import Piece.Piece;


class client {


    void run(Scanner sc) {

        User u1 = new User("AAA");
        User u2 = new User("BBB");
    
        Match match = new Match(u1, u2);

        while(true==true) {

            System.out.println("-------------------------------------");
            match.printBoard();
            System.out.println("-------------------------------------");
            System.out.println();

            User curUser = match.checkWhichUsersTurn();
            Color curColor = match.getCurUserTurnColor();

            System.out.println("Its user turn = " + curUser.getName() + " [color= " + curColor + "]");

            System.out.println("Enter from and to row-col = ");
            int fromRow, fromCol, toRow, toCol;

            fromRow = Integer.parseInt(sc.next());
            fromCol = Integer.parseInt(sc.next());
            toRow = Integer.parseInt(sc.next());
            toCol = Integer.parseInt(sc.next());
            System.out.println("Entered coordinates");
            System.out.println(fromRow + " " + fromCol + " " + toRow + " " + toCol);


            if(match.makeMove(new Position(fromRow, fromCol), new Position(toRow, toCol)) == false) {
                System.out.println();
                System.out.println("retry inputs or giveUp");
                System.out.println();
                System.out.println("----------------------------");
                System.out.println();
                continue;
            }

            if(match.checkMateFromCurPlayer() || match.staleMateFromCurPlayer()) {
                System.out.println(curUser.getName() + "   wins ++++++++++++++++++++++++++++++++++++++++++");
                break;
            }

            match.changeUserTurn();

        }


    }
}

public class Code {
    public static void main(String[] args) {
        // TimeoutHelper.startTimeout(5000);

        Scanner sc = new Scanner(System.in);

        client obj = new client();
        obj.run(sc);

        // TimeoutHelper.cancelTimeout();

    }
}
