package condicionescompetencias;

public class Interrupcion {
    private boolean inter;

    Interrupcion(){
        this.inter = true; //Activa la interrupción 
    }
    public boolean isInter() {
        return inter;
    }

    public void setInter(boolean inter) {
        this.inter = inter;
    }
}
