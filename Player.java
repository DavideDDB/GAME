import java.util.ArrayList;
import java.util.List;

//costruttore player
public class Player {

        private String nome;
        private String colore;
        private boolean status;
        private int id;
        private Carta[] carteMano;
        private Carta[] carteUsate;
    
        public Player(String nome, String colore, boolean status, int id){
            this.nome = nome;
            this.colore = colore;
            this.status = status;
            this.id = id;
            this.carteMano = new Carta[5]; //inizialmente ha 5 carte in mano
            this.carteUsate = new Carta[5]; //inizialmente ci sono 5 spazi vuoti di carte usate

            /////copio array per evitare aliasing
            ///this.carteMano = new int[carteMano.length];
            ///System.arraycopy(carteMano, 0, this.carteMano, 0, carteMano.length);
            ///
            ///this.carteUsate = new int[carteUsate.length];
            ///System.arraycopy(carteUsate, 0, this.carteUsate, 0, carteUsate.length);
            /////this.carteUsate = new int[5];
        }
        
        // Costruttore senza parametri per carteMano e carteUsate
        //Player(String nome, String colore, boolean status, int id) {
        //    this(nome, colore, status, id, new int[]{1, 2, 3, 4, 5}, new int[5]);    
        //}

        //Metodo getter per ottenere gli attributi privati
        public String getNome(){
            return nome;
        }

        public String getColore(){
            return colore;
        }

        public boolean getStatus(){
            return status;
        }

        public int getId(){
            return id;
        }

        public void setCarteMano(Carta[] carteMano){
            this.carteMano = carteMano;
        }

        public void getCarteUsate(Carta[] carteUsate){
            this.carteUsate = carteUsate;
        }

        public Carta[] getCarteMano(){
            return carteMano;
        }

        public Carta[] getCarteUsate(){
            return carteUsate;
        }

        public void printInfoPlayer(){
            System.out.println();
            System.out.println("Nome: " + nome);
            System.out.println("Colore: " + colore);
            System.out.println("Status: "+ status);
            System.out.println("id: "+ id);
            
            System.out.println("Carte in mano: ");
            for (Carta carta : carteMano) {
                if (carta !=null){
                System.out.println(carta + " ");
                }
            }
            System.out.println();

            System.out.println("Carte gia usate: ");
            for (Carta carta : carteUsate) {
                if (carta !=null){
                    System.out.println(carta + " ");
                    }
            }
            System.out.println();


            //System.out.println("Carte in mano: ");
            //for (int carta : carteMano){
            //    System.out.println(carta + " ");
            //}
            //System.out.println();
            //
            //System.out.println("Carte già usate: ");
            //for (int carta : carteUsate){
            //    System.out.println(carta + " ");
            //}
            //System.out.println();


        }
}
