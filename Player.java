//costruttore player
public class Player {

        private String nome;
        private String colore;
        private boolean status;
        private int id;
        private int[] carteMano = { 1, 2, 3, 4, 5};
        private int[] carteUsate = {};
    
        Player(String nome, String colore, boolean status, int id, int[] carteMano, int[] carteUsate){
            this.nome = nome;
            this.colore = colore;
            this.status = status;
            this.id = id;

            //copio array per evitare aliasing
            this.carteMano = new int[carteMano.length];
            System.arraycopy(carteMano, 0, this.carteMano, 0, carteMano.length);
            
            this.carteUsate = new int[carteUsate.length];
            System.arraycopy(carteUsate, 0, this.carteUsate, 0, carteUsate.length);
            //this.carteUsate = new int[5];
        }
        
        // Costruttore senza parametri per carteMano e carteUsate
        Player(String nome, String colore, boolean status, int id) {
            this(nome, colore, status, id, new int[]{1, 2, 3, 4, 5}, new int[5]);    
        }

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

        public int[] getCarteMano(){
            return carteMano;
        }

        public int[] getCarteUsate(){
            return carteUsate;
        }

        public void printInfoPlayer(){
            System.out.println( nome);
            System.out.println(colore);
            System.out.println("Status: "+ status);
            System.out.println("id: "+ id);
            
            System.out.println("Carte in mano: ");
            for (int carta : carteMano){
                System.out.println(carta + " ");
            }
            System.out.println();
            
            System.out.println("Carte già usate: ");
            for (int carta : carteUsate){
                System.out.println(carta + " ");
            }
            System.out.println();

        }
}
