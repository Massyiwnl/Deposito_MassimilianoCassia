/*
 * Esercizio:
Creare una classe Persona(nome nel costruttore) che ha un
metodo Saluta() con un saluto. Creare due oggetti che
salutano nel main.

Creare una classe Pirata che eredita Persona Modificando il
Saluto dichiarando di essere un pirata. Quindi creare un
oggetto di pirata e farlo salutare.
 */


class Persona {
    protected String name;
    protected int eta;

    Persona(String name, int eta) {
        this.name = name;
        this.eta = eta;
    }

    public void saluta() {
        System.out.println("Ciao, sono " + name + " e ho " + eta + " anni!");
    }
}

class Pirata extends Persona {
    Pirata(String name, int eta) {
        super(name, eta);
    }

    @Override
    public void saluta() {
        System.out.println("AAAAAAAAAAAAAAARGH! Sono un pirata e il mio nome è " + name + "!");
    }
}

public class EsercizioPolimorfismo {
    public static void main(String[] args) {
        Persona p1 = new Persona("Anna", 25);
        Persona p2 = new Persona("Luca", 30);

        p1.saluta();
        p2.saluta();

        Pirata pirata1 = new Pirata("Jack", 40);
        pirata1.saluta();
    }
}
