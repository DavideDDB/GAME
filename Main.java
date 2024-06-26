import java.util.Scanner;

public class Main {
    
    private static final String [] coloriDisponibili = {"Giallo", "Verde", "Blu", "Rosso","Viola"};
    
    public static void main(String[]args){

        /////Creazione array mano(sposto in player)
        /////int[] carteMano = {1, 2, 3, 4, 5};
        /////int[] carteUsate = {};

        //Array colori predefiniti

        //chiedere numero giocatori
        int numeroPlayer = getNumPlayer();

        // ciclo per creare player
        for (int i = 0; i < numeroPlayer; i++) {
            // Creare il Player usando la funzione creazionePlayer
            //utilizzo funzione per chiedere il NOME (codice pulito)
            String nomePlayer = chiediNome();
            //utilizzo una funzione per chiedere il COLORE
            String colorePlayer = chiediColore();
            
            Player player = creazionePlayer((i + 1) + ": " + nomePlayer, "Colore " + (i + 1) + ": " + colorePlayer, true, i + 1);
            player.printInfoPlayer();
        }

        //Creare il Player
        //Player player1 = new Player("Davide", "Giallo", true, 1);//   
        //
        //player1.printInfoPlayer();

    }
    //FASI PARTITA:
    /*
     * 1. numero giocatori FATTO
     * 2. registrazione giorcatori
     * 3. iniziare gioco
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

    public static Player creazionePlayer(String nome, String colore, boolean status, int id) {
        return new Player(nome, colore, status, id);
    }

    public static String chiediNome(){
        System.out.println("Inserisci nome player: ");
        Scanner sc = new Scanner(System.in);
        String nomePlayer = sc.next();
            return nomePlayer;
    }

    public static String chiediColore(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Scegli un colore tra rosso, blu, verde, giallo, viola");
            String coloreScelto = sc.next();

            //verifica che il colore sia valido
            for (String colore : coloriDisponibili) {
                if (colore.equalsIgnoreCase(coloreScelto)) {
                    return colore; //restituiscei il colore controllato
                }
            }

            System.out.println("Il colore scelto non è tra quelli proposti, riprova.");
        }

    }

}
