import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[]args){

        List<Player> playersUsers = Player.createPlayer();

        for (Player playerUser : playersUsers){
            playerUser.printInfoPlayer();
        }
 
    }  
    
    //FASI PARTITA:
    /*
     * 1. numero giocatori FATTO
     * 2. registrazione giorcatori FATTO
     * 3. creazione mazzo giocatori FATTO
     * 4. iniziare gioco
     */

    
}
