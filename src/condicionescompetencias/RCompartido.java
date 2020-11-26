
package condicionescompetencias;
import java.util.ArrayList;

public class RCompartido {
    private String datoCompartido;
    private ArrayList<Interrupcion> interrupciones;
    
    RCompartido(){
        this.datoCompartido = "";
        this.interrupciones = new ArrayList<Interrupcion>();
        for(int i = 0; i < 10; i++){
            interrupciones.add(new Interrupcion());
        }
    }
    
    public String getDatoCompartido() {
        /*String aux = "En espera..";
        if(isEntra()){
            bloquea();
            aux = datoCompartido;
            desbloquea();
        }
        return(aux);*/
        return datoCompartido;
    }
  
    public void setDatoCompartido(String datoCompartido) {
     //   for(Interrupcion i: interrupciones)
       //     if(i.isInter())
                this.datoCompartido = datoCompartido;
    }

    public ArrayList<Interrupcion> getInterrupciones() {
        return interrupciones;
    }

    public void setInterrupciones(ArrayList<Interrupcion> interrupciones) {
        this.interrupciones = interrupciones;
    }
    
    public void bloquea(int n){
        for(Interrupcion i: interrupciones){
            i.setInter(false);
        }
//        interrupciones.get(n -1).setInter(true);
    }
    
    public void desbloquea(){
        for(Interrupcion i: interrupciones){
            i.setInter(true);
        }
    }
    
    public boolean isEntra(){
        boolean ban = false;
        for(Interrupcion i : interrupciones)
            if(i.isInter())
                ban = true;
            else
                return false;
        return ban;
    }
}
