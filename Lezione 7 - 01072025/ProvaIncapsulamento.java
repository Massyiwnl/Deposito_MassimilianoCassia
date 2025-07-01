class Person{
    private String name;
    private int eta;


    // Costruttore della classe Person
    public Person(String name, int eta) {
        this.name = name; // Inizializza il nome della persona
        this.eta = eta; // Inizializza l'età della persona
    }

    private boolean verificaMaggiorenne() {
        return this.eta >= 18; // Verifica se la persona è maggiorenne
    }

    public void stampaStatus() {
        if (verificaMaggiorenne()) {
            System.out.println(this.name + " è maggiorenne.");
        } else {
            System.out.println(this.name + " non è maggiorenne.");
        }
    }

    public String getName(){
        return name; // Restituisce il nome della persona
    }

    public void setName(String newName){
        this.name = newName; // Imposta il nome della persona
    }
}

public class ProvaIncapsulamento {
    public static void main(String[] args) {
        Person person = new Person("Massimiliano", 25); // Crea un oggetto Person con nome e età
        person.stampaStatus(); // Stampa se la persona è maggiorenne o meno
        person.setName("Massimiliano"); // Imposta il nome della persona
        System.out.println("Il nome della persona è: " + person.getName()); // Stampa il nome della persona
        
    }
}
