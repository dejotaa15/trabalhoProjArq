import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FonteDeDados{
    private List<Integer> lst;
    private List<Observador> observadores = new ArrayList<>();


    public FonteDeDados(){
        lst = new LinkedList<>();
    }
    public void adicionaObservador(Observador o){
+       observadores.add(o);
+   }
+
+   public void removeObservador(Observador o){
+       observadores.remove(o);
+   }

    public void add(Integer value){
        if (value < 0) throw new IllegalArgumentException("Valor invalido");
        lst.add(value);
        for (Observador o : observadores){
+           o.notifica(value);
+       }
    }

    public int quantidade(){
        return lst.size();
    }

    public List<Integer> getValores(){
        return new ArrayList<>(lst);
    }
}