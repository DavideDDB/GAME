import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//costruttore player
public class Player {

        private String name;
        private String color;
        private boolean status;
        private int id;
        private Card[] handCards;
        private Card[] usedCards;
    
        public Player(String name, String color, int id){
            this.name = name;
            this.color = color;
            this.status = true;
            this.id = id + 1;
            this.handCards = new Card[5]; //inizialmente ha 5 carte in mano
            this.usedCards = new Card[5]; //inizialmente ci sono 5 spazi vuoti di carte usate

            for (int i = 0; i < 5; i++){
                this.handCards[i] = new Card(this.id, i);
            }
            
        }
        
        //Metodo getter per ottenere gli attributi privati
        public String getName(){
            return name;
        }

        public String getColor(){
            return color;
        }

        public boolean getStatus(){
            return status;
        }

        public int getId(){
            return id;
        }

        public void setCarteMano(Card[] handCards){
            this.handCards = handCards;
        }

        public void setUsedCards(Card[] usedCards){
            this.usedCards = usedCards;
        }

        public Card[] getHandCards(){
            return handCards;
        }

        public Card[] getUsedCards(){
            return usedCards;
        }

        public void printInfoPlayer(){
            System.out.println();
            System.out.println("Nome: " + name);
            System.out.println("Colore: " + color);
            System.out.println("Status: "+ status);
            System.out.println("id: "+ id);
            
            System.out.println("Carte in mano: ");
            for (Card card : handCards) {
                if (card !=null){
                System.out.println(card + " ");
                }
            }
            System.out.println();

            System.out.println("Carte gia usate: ");
            for (Card card : usedCards) {
                if (card !=null){
                    System.out.println(card + " ");
                    }
            }
            System.out.println();

        }



        //METHODS

        //Method to obtain number of player
        public static int getNumPlayer(){
            System.out.println("Inserire un numero da 2 a 5");
            Scanner sc = new Scanner(System.in);
            String numeroUtenti = sc.next();
            int result = Integer.valueOf(numeroUtenti);
            if (result > 1 && result < 6) {
                return result;  
            }else{
                System.out.println("Numero inserito non valido.");
                return getNumPlayer();

            }
        }  

        //Method to obtain player's NAME
        public static String askName(){
            System.out.println("Inserisci name player: ");
            Scanner sc = new Scanner(System.in);
            String namePlayer = sc.next();
                return capitalizzaNome(namePlayer);
        }

        //Method to CAPITALIZE player's name
        public static String capitalizzaNome(String name) {
            if (name == null || name.isEmpty()) {
                return name;
            }
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }

        //Method to obtain player's COLOR
        public static String askColor(){
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Scegli un colore tra " + avaiableColors.toString());
                String chosenColor = sc.next();

                //verifica che il color sia valido (tra quelli disponibili)
                for (String color : avaiableColors) {
                    if (color.equalsIgnoreCase(chosenColor)) {
                        //Rimuovo il color scelto dalla lista (cosicche non sia più disponibile per gli altri player)
                        avaiableColors.remove(color);
                        return color; //ritorna il color scelto
                    }
                }

                System.out.println("Il color scelto non è tra quelli proposti, riprova.");
            }
        }
   
    //Dynamic list of avaiable colors 
    private static List<String> avaiableColors = new ArrayList<>();

    static {
        //Initialize avaiable colors
        avaiableColors.add("Giallo");
        avaiableColors.add("Verde");
        avaiableColors.add("Rosso");
        avaiableColors.add("Viola");
        avaiableColors.add("Blu");
    }

    public static List<Player> createPlayer(){
        int playerNumber = getNumPlayer();

        List<Player> playersUsers = new ArrayList<>();

        for (int i = 0; i < playerNumber; i++) {
            String namePlayer = askName();
            String colorPlayer = askColor();
             Player playerUser = new Player(namePlayer, colorPlayer, i);

            playersUsers.add(playerUser);
            playerUser.printInfoPlayer();

        }

        return playersUsers;
    }
}



