// Sottosistema: Luce della Camera
class LuceCamera {
    public void accendi() {
        System.out.println("Luce della camera accesa.");
    }
}

// Sottosistema: Luce della Cucina
class LuceCucina {
    public void accendi() {
        System.out.println("Luce della cucina accesa.");
    }
}
// Facade: Gestisce l'accensione di tutte le luci
class GestioneLuciFacade {
    private LuceCamera luceCamera;
    private LuceCucina luceCucina;

    public GestioneLuciFacade() {
        this.luceCamera = new LuceCamera();
        this.luceCucina = new LuceCucina();
    }

    public void accendiTutte() {
        luceCamera.accendi();
        luceCucina.accendi();
    }
}
public class EsercizioFacade {
    public static void main(String[] args) {
        GestioneLuciFacade facade = new GestioneLuciFacade();
        facade.accendiTutte(); // Accende tutte le luci con un solo comando. magia del facade
    }
}
