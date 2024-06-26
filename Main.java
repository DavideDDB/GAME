import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    //Lista dinamica di colori disponibili
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

        // ciclo per creare player
        for (int i = 0; i < numeroPlayer; i++) {
            //Utilizzo funzione per chiedere il NOME (codice pulito)
            String nomePlayer = chiediNome();
            //Utilizzo una funzione per chiedere il COLORE
            String colorePlayer = chiediColore();
            
            // Creare il Player usando la funzione creazionePlayer
            Player player = creazionePlayer("Giocatore " + (i + 1) + ": " + nomePlayer, "Colore: " + colorePlayer, true, i + 1);
            player.printInfoPlayer();
        }

        ////Creare il Player
        ////Player player1 = new Player("Davide", "Giallo", true, 1);//   
        ////
        ////player1.printInfoPlayer();

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

}
