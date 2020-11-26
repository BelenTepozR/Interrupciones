
package condicionescompetencias;
import javax.swing.JTextArea;

public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean pausado = false;   
    private boolean corriendo = true;   
    private int numHilo;
    private Interrupcion[] inter;
    private final static int ini = 100;
    private final static int fin = 200;
    
    Hilo(JTextArea area, RCompartido rc, int n, Interrupcion[] inter){
        this.area = area;
        this.rc = rc;
        this.setName("Perrito" + n);
        this.numHilo = n;
        this.inter = inter;
    }
   
    @Override
    public void run(){
        try{
            while(true){
                    if(rc.isEntra()){
                        rc.bloquea(numHilo);
                        rc.setDatoCompartido(this.getName());
                        area.append(rc.getDatoCompartido() + "\n");                        
                        rc.desbloquea();
                    }else
                        area.append("En espera" + "\n");
                Thread.sleep((int)(ini + Math.random()*fin));
                synchronized(this){
                    if(pausado)
                        wait();
                    if(!corriendo)
                        join();
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
    
    public void pausar(){
        this.pausado = true;
    }
    
    public void continuar(){
        synchronized(this){
            pausado = false;
            notifyAll();
        }
    }
    
    public void parar(){
        this.corriendo = false;
    }

    public void exit (int t) throws InterruptedException{
       sleep(100);
    }
}
