package Engine;

import java.util.*;

import Enum.RuleType;
import Model.Player;
import Observers.IObservers;
import Rules.IRules;
import Rules.RuleFactory;

// also Obeservers
public class Game {
    Board board;
    Queue<Player> playersQueue;
    List<IObservers> observersList;
    boolean gameOver = false;
    Scanner sc;
    IRules rule;

    public Game(int boardSize, Scanner sc, RuleType ruleType) {
        board = new Board(boardSize);
        this.sc = sc;
        rule = RuleFactory.getInsatance().generateRuleFactory(ruleType);
        playersQueue = new LinkedList<>();
        observersList = new ArrayList<>();
    }

    public void addPlayers(Player player) {
        playersQueue.add(player);
    }

    public void addObservers(IObservers iObservers) {
        observersList.add(iObservers);
    }

    public void notify(String msg) {
        for(IObservers x: observersList) {
            x.update(msg);
        }
    }

    public void play() {

        while (!gameOver) {
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println();

            board.printBoard();

            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println();

            Player curPlayer = playersQueue.peek();

            notify("Its player = \"" + curPlayer.getName() + "\" turn (symbol = "+ curPlayer.getSymbol().getSymbol() +")");

            System.out.println( "\nEnter row and col = ");
            
            int row,col;
            row = Integer.parseInt(sc.next());
            col = Integer.parseInt(sc.next());

            if(!board.getCellEmptyCheck(row, col)) {
                System.out.println("your input = " + 
                "\nrow = " + row +
                "\ncol = " + col +
                "\nInvalid move | try again");
                continue;
            }

            board.placeMarkOnBoard(row, col, curPlayer.getSymbol());

            // check win
            if(rule.checkWin(board, row, col, curPlayer.getSymbol())) {
                System.out.println();
                System.out.println("--------------------------------------");
                System.out.println();
                notify("Player \"" + curPlayer.getName() + "\" Won");

                board.printBoard();
                gameOver = true;
                continue;
            }

            //check draw
            if(rule.checkDraw(board, row, col,curPlayer.getSymbol())) {
                System.out.println();
                System.out.println("--------------------------------------");
                System.out.println();
                notify("Its a draw :)");

                board.printBoard();
                gameOver = true;
                continue;
            }

            playersQueue.remove();
            playersQueue.add(curPlayer);
            
        }

    }


}
