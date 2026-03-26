import java.util.*;

import Engine.Game;
import Enum.RuleType;
import Model.Player;
import Observers.ConsoleObserver;

class client {


    void run(Scanner sc) {
    
        Game game = new Game(3, sc, RuleType.STANDARD);
        Player player1 = new Player("Player-AAA", "X");
        Player player2 = new Player("Player-BBB", "O");
        game.addPlayers(player1);
        game.addPlayers(player2);
        game.addObservers(new ConsoleObserver());
        game.play();

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
