
public class Card {
    private int playerId;
    private int value;

    public Card(int playerUser, int value){
        this.playerId = playerUser;
        this.value = value + 1;
    }

    public int getPlayerId(){
        return playerId;
    }

    public void setIdGiocatore(int id){
        this.playerId = playerId;
    }
    
    public int getValue(){
        return value;
    }

    public String getAnimal(){
        switch (value) {
            case 1:
                return "Orso";
            case 2:
                return "Lupo";
            case 3:
                return "Lince";
            case 4:
                return "Gufo";
            case 5:
                return "Topo";
            default:
                return "Nessun animale";
        }
    }
    public int getValue(String animal){
        switch (animal) {
            case "Orso":
                return 1;
            case "Lupo":
                return 2;
            case "Lince":
                return 3;
            case "Gufo":
                return 4;
            case "Topo":
                return 5;
            default:
                return 0;
        }
    }


@Override
public String toString(){
    return "Card{" +
            "playerId = " + playerId +
            ", animal = '"  + this.getAnimal() + '\''+
            ", value = " + value +
            '}';

            //ti serve una funzione che richiami il nome del playerUser in base al suo id. 
            //passerai, id carta e id giocare (la carta completa.)
}

}
