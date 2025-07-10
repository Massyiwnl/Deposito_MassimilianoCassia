abstract class Animal {

  public abstract void animalSound(); }


class Pig extends Animal {

  public void animalSound() {

    System.out.println("The pig says: wee wee");

  }
}

class Dog extends Animal {

  public void animalSound() {

    System.out.println("The dog says: bow wow");

  }
}

public class ProvaAstrazione  {
    public static void main(String[] args) {
        // Animal myAnimal = new Animal();  // ERRORE! Classe astratta, non si può istanziare
        // Puoi solo istanziare oggetti di classi concrete che estendono Animal, cioè Pig e Dog:

        Animal myPig = new Pig(); 
        Animal myDog = new Dog();  

        myPig.animalSound();
        myDog.animalSound();
    }
}
