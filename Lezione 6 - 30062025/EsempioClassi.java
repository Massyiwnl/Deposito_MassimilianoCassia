class Auto{
    String marca;
    int anno;
    double prezzo;

    void mostraInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("Anno: " + anno);
        System.out.println("Prezzo: " + prezzo);
    }
}



public class EsempioClassi {
    public static void main(String[] args) {
        Auto auto1 = new Auto(); // Creazione di un oggetto Auto
        auto1.marca = "Fiat"; // Assegnazione del valore alla proprietà marca
        auto1.anno = 2020; // Assegnazione del valore alla proprietà anno
        auto1.prezzo = 15000.0; // Assegnazione del valore alla proprietà prezzo

        auto1.mostraInfo(); // Chiamata al metodo mostraInfo per visualizzare le informazioni dell'auto

        Auto auto2 = new Auto(); // Creazione di un altro oggetto Auto
        auto2.marca = "Toyota"; // Assegnazione del valore alla proprietà marca
        auto2.anno = 2021; // Assegnazione del valore alla proprietà anno
        auto2.prezzo = 20000.0; // Assegnazione del valore alla proprietà prezzo

        auto2.mostraInfo(); // Chiamata al metodo mostraInfo per visualizzare le informazioni della seconda auto
    }
}
