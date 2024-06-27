import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    //Lista dinamica di colori disponibili(per far si che vengano tolti i colori già scelti)
    private static List<String> coloriDisponibili = new ArrayList<>();

    static {
        //Inizzializzo i colori disponibili
        coloriDisponibili.add("Giallo");
        coloriDisponibili.add("Verde");
        coloriDisponibili.add("Rosso");
        coloriDisponibili.add("Viola");
        coloriDisponibili.add("Blu");
    }

    ////Array con colori disponibili
    //private static final String [] coloriDisponibili = {"Giallo", "Verde", "Blu", "Rosso","Viola"};
    

    public static void main(String[]args){

        ////Creazione array mano(sposto in player)
        ////int[] carteMano = {1, 2, 3, 4, 5};
        ////int[] carteUsate = {};

        //chiedere numero giocatori
        int numeroPlayer = getNumPlayer();

        //Lista di giocatori
        List<Player> giocatori = new ArrayList<>();

        //1//creare lista giocatori
        //1//Player[] giocatori = new Player[numeroPlayer];

        // ciclo per creare player
        for (int i = 0; i < numeroPlayer; i++) {
            //Utilizzo funzione per chiedere il NOME (codice pulito)
            String nomePlayer = chiediNome();
            //Utilizzo una funzione per chiedere il COLORE
            String colorePlayer = chiediColore();

            Player giocatore = creazionePlayer(nomePlayer, colorePlayer, true, i + 1);
            
            //Creazione mazzo di carte per ogni giocatore
            List<Carta> carteAssegnate = new ArrayList<>();
            carteAssegnate.add(new Carta("Orso", 1));
            carteAssegnate.add(new Carta("Lupo", 2));
            carteAssegnate.add(new Carta("Lince", 3));
            carteAssegnate.add(new Carta("Gufo", 4));
            carteAssegnate.add(new Carta("Topo", 5));

            //collego l'id del giocatore all'id delle carte
            for (Carta carta : carteAssegnate){
                carta.setIdCarta(giocatore.getId());
            }

            //impostare carte in mano per giocatore
            giocatore.setCarteMano(carteAssegnate.toArray(new Carta[0]));

            giocatori.add(giocatore);
            giocatore.printInfoPlayer();
            // Creare il Player usando la funzione creazionePlayer
            
            //Player player = creazionePlayer("Giocatore " + (i + 1) + ": " + nomePlayer, "Colore: " + colorePlayer, true, i + 1);
            //player.printInfoPlayer();

            //2//giocatori[i] = creazionePlayer(nomePlayer, colorePlayer, true, i+1);
            //2//giocatori[i].printInfoPlayer();
        }

        ////Creare il Player
        ////Player player1 = new Player("Davide", "Giallo", true, 1);//   
        ////
        ////player1.printInfoPlayer();

        //Creazione mazzo di carte
        //List<Carta> mazzo = creaMazzo();

        //Assegnare le carte ai giocaotri
        //assegnaCarteGiocatori(mazzo, giocatori);
        //
        //stampa carte dei giocatori
        //for (Player giocatore : giocatori) {
        //    System.out.println("Carte del" + giocatore.getNome() + ":" );
        //    for (Carta carta : giocatore.getCarteMano()) {
        //        System.out.println(carta);
        //        
        //    }
        //    
        //}

    }
    //FASI PARTITA:
    /*
     * 1. numero giocatori FATTO
     * 2. registrazione giorcatori FATTO
     * 3. creazione mazzo giocatori
     * 4. iniziare gioco
     */

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

    //metodo per creare il giocatore
    public static Player creazionePlayer(String nome, String colore, boolean status, int id) {
        return new Player(nome, colore, status, id);
    }
    
    //metodo chiedere il nome
    public static String chiediNome(){
        System.out.println("Inserisci nome player: ");
        Scanner sc = new Scanner(System.in);
        String nomePlayer = sc.next();
            return capitalizzaNome(nomePlayer);
    }

    /////metodo per lettera maiuscola nome (non necessario)
    public static String capitalizzaNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            return nome;
        }
        return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }
    /////

    //metodo per chiedere colore
    public static String chiediColore(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Scegli un colore tra " + coloriDisponibili.toString());
            String coloreScelto = sc.next();

            //verifica che il colore sia valido (tra quelli disponibili)
            for (String colore : coloriDisponibili) {
                if (colore.equalsIgnoreCase(coloreScelto)) {
                    //Rimuovo il colore scelto dalla lista (cosicche non sia più disponibile per gli altri player)
                    coloriDisponibili.remove(colore);
                    return colore; //ritorna il colore scelto
                }
            }

            System.out.println("Il colore scelto non è tra quelli proposti, riprova.");
            
            //for (String colore : coloriDisponibili) {
            //    if (colore.equalsIgnoreCase(coloreScelto)) {
            //        return colore; //restituiscei il colore controllato
            //    }
            //}
            //System.out.println("Il colore scelto non è tra quelli proposti, riprova.");
        }

    }



    //metodo per creare il mazzo
    //public static List<Carta> creaMazzo(){
    //    List<Carta> mazzo = new ArrayList<>();
    //    String[] animali = {"Orso", "Lupo", "Lince", "Gufo", "Topo"};
    //    int[] valori = {1,2,3,4,5};
//
    //    for (int i = 0; i < animali.length; i++){
    //        mazzo.add(new Carta(animali[i], valori[i]));
    //    }
    //    return mazzo;
    //}

    //metodo per assegnare le carte ai giocatori
    //public static void assegnaCarteGiocatori(List<Carta> mazzo, Player[] giocatori){
    //    for (Player giocatore : giocatori) {
    //        List<Carta> carteAssegnate = new ArrayList<>();
    //        for (Carta carta : mazzo) {
    //            if (carta.getIdGiocatore()== 0 ) { //se la carta non è ancora assegnata
    //                carta.setIdGiocatore(giocatore.getId());
    //                carteAssegnate.add(carta);
    //            }
//
    //        }
    //        giocatore.setCarteMano(carteAssegnate.toArray(new Carta[0]));
    //    }
    //}

}
