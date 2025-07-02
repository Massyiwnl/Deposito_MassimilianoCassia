class Veicolo{ 

  //Creazione di una classe genitore. definire un metodo 

  void run(){System.out.println( "Il veicolo è in marcia" );} 

} 


class Bike2 extends Veicolo{ 

  void run(){System.out.println( "La bici sta correndo in sicurezza" );} //metodo della classe genitore 

} 


public class ProvaEreditarieta2 {
     public static void main(String args[]){ 

         Bike2 obj = new Bike2(); //crea oggetto 

        obj.run(); 

    } 
}
