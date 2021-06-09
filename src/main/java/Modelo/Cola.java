package Modelo;

import java.util.TimerTask;
import java.util.Timer;
import Vista.Lista;
import javax.swing.JOptionPane;

public class Cola {
    private Nodo primero;
    private Nodo ultimo;
    private Nodo1 first;
    private Nodo1 last;
    int tama;
    int a,t1, t2,t3;
    
    
    Lista lform;
    
    public Cola(){
        primero = null;
        ultimo = null;
        first=null;
        last=null;
    }
    
    public boolean colaVacia(){
        boolean n;
        n=false;
        if(primero == null){
            n = true;
        }
        return n;
    }
    
    public void insertar(int n, int c, int d, String nom, int e, int tr){
        Nodo nuevo;
        nuevo = new Nodo(n, c, d, nom, e, tr);
        if(primero==null){
            primero = nuevo;
            ultimo = nuevo;
        }else{
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
            tama++;
        }
    }
    public void insertar1(int n, int c, int d, String nom, int e, int tr){
        Nodo1 nuevo;
        nuevo = new Nodo1(n, c, d, nom, e, tr);
        if(first==null){
            first = nuevo;
            last = nuevo;
        }else{
            last.siguiente = nuevo;
            last = nuevo;
            tama++;
        }
    }

 
    public Cola insertarInicio(int n,int c,int d, String nom,int e,int  tr){
        Nodo nuevo;
        nuevo = new Nodo(n,c,d,nom,e,tr);
        nuevo.siguiente = primero;
        primero = nuevo;
        return this;
    }
    public Cola insertarInicio1(int n,int c,int d, String nom,int e,int  tr){
        Nodo1 nuevo;
        nuevo = new Nodo1(n,c,d,nom,e,tr);
        nuevo.siguiente = first;
        first = nuevo;
        return this;
    }
 
    
    public int quitar(){
        int aux = primero.dpi;
        primero = primero.siguiente;
        tama--;
        return aux;
    }
    public double inicio(){
      return primero.co;
       
    }
    public String mostrar() {
        Nodo aux;
        aux = primero;
        String cadena;
        cadena="";
        while (aux != null) {
               cadena = cadena+aux.n1+"        GM-"+aux.co+"      "+aux.dpi + "      " + aux.nombre + "       "+ aux.edad+"       "+ aux.tiempo + "\n";
            aux = aux.siguiente;
        }
        return cadena;
    }
    private void delay(long milis){
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    public void  timer1(int s, String c){
        Timer timer = new Timer();
                TimerTask tarea = new TimerTask(){
                    int n;
                    
                    @Override
                    public void run() {
                        if(n == s){
                            lform.taCaja1.setText("");
                            cancel();
                        }else{
                            t1++;
                            lform.taCaja1.setText(c + t1);
                            n++;
                        }
                    }
                };
                timer.scheduleAtFixedRate(tarea, 0, 1000);    
    }
    public void  timer2(int s, String c){
        Timer timer = new Timer();
                TimerTask tarea = new TimerTask(){
                    int n;
                    @Override
                    public void run() {
                        if(n == s){
                            lform.taCaja2.setText("");
                            cancel();
                        }else{
                            t2++;
                            lform.taCaja2.setText(c + t2);
                            n++;
                        }
                    }
                };
                timer.scheduleAtFixedRate(tarea, 0, 1000);    
    }
    public void  timer3(int s, String c){
        
        Timer timer = new Timer();
                TimerTask tarea = new TimerTask(){
                    int n;
                    
                    @Override
                    public void run() {
                        if(n == s){
                            lform.taCaja3.setText("");
                            cancel();
                        }else{
                            t3++;
                            lform.taCaja3.setText(c + t3);
                            n++;
                        }
                    }
                };
                timer.scheduleAtFixedRate(tarea, 0, 1000);    
    }
    public void recorrerMayor(int n){
        Nodo1 aux;
        int s = 0;
        aux = first;
        while (aux != null) {
            s = aux.tiempo;
            if(s >= n){
                a = s;
            }else{
                a = n;
            }
            aux = aux.siguiente;
        }
        
    }
    public void recorrer(){
        Nodo1 aux;
        int s = 0,t;
        double p;
        aux = first;
        while (aux != null) {
            
            aux = aux.siguiente;
            s++;
        }
        t= t1+t2+t3;
        p = t/s;
        JOptionPane.showMessageDialog(null, "Numero mas grande " + a);
        JOptionPane.showMessageDialog(null, "Personas atendidas " + s);
        JOptionPane.showMessageDialog(null, "Promedio de espera" + p);
    }
    
    public void recorrer2(){
        Nodo aux;
        aux = primero;
        String cadena="";
        if(Lista.taCaja1.getText().length() == 0){
            cadena = "GM- " + aux.co + " " + aux.nombre;
            //lform.taCaja1.setText(cadena);
            timer1(aux.tiempo, cadena);
            quitar();
        }else if(Lista.taCaja2.getText().length() == 0){
            cadena = "GM- " + aux.co + " " + aux.nombre;
            //lform.taCaja2.setText(cadena);
            timer2(aux.tiempo, cadena);
            quitar();
        }else if(Lista.taCaja3.getText().length() == 0){
            cadena = "GM- " + aux.co + " " + aux.nombre;
            //lform.taCaja3.setText(cadena);
            timer3(aux.tiempo, cadena);
            quitar();
        }else if(Lista.taCaja1.getText().length() != 0 && Lista.taCaja1.getText().length() != 0 && Lista.taCaja1.getText().length() != 0){
            JOptionPane.showMessageDialog(null, "Cajas llenas");
        }
    }
}
