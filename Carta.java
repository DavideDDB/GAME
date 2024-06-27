
public class Carta {
    private int idCarta;
    private String animale;
    private int valore;

    public Carta(String animale, int valore){
        this.valore = valore;
        this.animale = animale;
    }

    public int getIdCarta(){
        return idCarta;
    }

    public void setIdCarta(int idCarta){
        this.idCarta = idCarta;
    }
    
    public int getValore(){
        return valore;
    }

    public String getAniamle(){
        return animale;
    }


@Override
public String toString(){
    return "Carta{" +
            "idCarta = " + idCarta +
            ", animale = '" + animale + '\''+
            ", valore = " + valore +
            '}';
}

}
//Carta[] mazzo = new Carta[5]; //array con le 5 carte
//
//mazzo[0] = new Carta(, 1, "Bear");