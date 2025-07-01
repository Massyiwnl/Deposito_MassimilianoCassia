class Person{
    private String name;

    public String getName(){
        return name; // Restituisce il nome della persona
    }

    public void setName(String newName){
        this.name = newName; // Imposta il nome della persona
    }
}

public class ProvaIncapsulamento {
    public static void main(String[] args) {
        Person person = new Person(); // Crea un nuovo oggetto Person
        person.setName("Massimiliano"); // Imposta il nome della persona
        System.out.println("Il nome della persona è: " + person.getName()); // Stampa il nome della persona
        
    }
}
