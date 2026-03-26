package Model;

public class Player {
    static int id=0;
    int playerId;
    String name;
    Symbol symbol;

    public Player(String name, String symbol) {
        this.name=name;
        this.symbol=new Symbol(symbol);
        this.playerId=id++;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

}
