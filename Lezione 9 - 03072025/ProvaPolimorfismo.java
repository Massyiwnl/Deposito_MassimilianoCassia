
import java.util.ArrayList;

class Animale {
    public void faiVerso() {
        System.out.println("Verso generico di animale.");
    }
}

class Cane extends Animale {
    @Override
    public void faiVerso() {
        System.out.println("Bau!");
    }
}

class Gatto extends Animale {
    @Override
    public void faiVerso() {
        System.out.println("Miao!");
    }
}

public class ProvaPolimorfismo {
    public static void main(String[] args) {
        // Crea una lista di tipo Animale
        ArrayList<Animale> animali = new ArrayList<>();

        // Aggiunge vari tipi di animali (polimorfismo)
        animali.add(new Animale());
        animali.add(new Cane());
        animali.add(new Gatto());

        // Ciclo sulla lista: polimorfismo in azione
        for (Animale a : animali) {
            a.faiVerso(); // Chiama il metodo corretto in base all’oggetto reale
        }
    }
}
