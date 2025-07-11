import java.util.ArrayList;
import java.util.Scanner;


// Interfaccia prodotto (User) per il Factory Method
interface User {
    String getUsername();      // Restituisce il nome utente
    String getType();          // Restituisce il tipo di utente (Admin/Guest)
    boolean isAdmin();         // True se admin, false altrimenti
}


// Implementazioni concrete di User: AdminUser e GuestUser
// Rappresenta un utente amministratore
class AdminUser implements User {
    private String username;
    public AdminUser(String username) { this.username = username; }
    public String getUsername() { return username; }
    public String getType() { return "Admin"; }
    public boolean isAdmin() { return true; }
}

// Rappresenta un utente guest (normale)
class GuestUser implements User {
    private String username;
    public GuestUser(String username) { this.username = username; }
    public String getUsername() { return username; }
    public String getType() { return "Guest"; }
    public boolean isAdmin() { return false; }
}


// Factory Method per la creazione di utenti
abstract class UserFactory {
    public abstract User createUser(String username);
}

class AdminFactory extends UserFactory {
    public User createUser(String username) { return new AdminUser(username); }
}

class GuestFactory extends UserFactory {
    public User createUser(String username) { return new GuestUser(username); }
}


// Strategy pattern: per la ricerca utenti
interface SearchStrategy {
    boolean search(ArrayList<User> users, String username);
}

// Strategia di ricerca Case Sensitive (rispetta maiuscole/minuscole)
class CaseSensitiveSearch implements SearchStrategy {
    public boolean search(ArrayList<User> users, String username) {
        for (User u : users) if (u.getUsername().equals(username)) return true;
        return false;
    }
}

// Strategia di ricerca Case Insensitive (non rispetta maiuscole/minuscole)
class CaseInsensitiveSearch implements SearchStrategy {
    public boolean search(ArrayList<User> users, String username) {
        for (User u : users) if (u.getUsername().equalsIgnoreCase(username)) return true;
        return false;
    }
}


// Sistema legacy di gestione utenti (usa User e Strategy)
class LegacyUserSystem {
    private ArrayList<User> legacyUsers = new ArrayList<>();         // Lista utenti registrati
    private SearchStrategy strategy = new CaseSensitiveSearch();     // Strategia di ricerca predefinita

    // Permette di cambiare strategia di ricerca a runtime
    public void setSearchStrategy(SearchStrategy strategy) { this.strategy = strategy; }

    // Aggiunge un utente (di qualsiasi tipo)
    public void addUser(User user) {
        legacyUsers.add(user);
        System.out.println("LegacySystem: Utente aggiunto: " + user.getUsername() + " [" + user.getType() + "]");
    }

    // Elimina un utente SOLO SE chi esegue è admin (controllo sul tipo di User passato come executor)
    public boolean removeUser(String username, User executor) {
        if (!executor.isAdmin()) {
            System.out.println("Operazione negata: solo un admin può eliminare utenti!");
            return false;
        }
        for (int i = 0; i < legacyUsers.size(); i++) {
            if (legacyUsers.get(i).getUsername().equals(username)) {
                System.out.println("LegacySystem: Utente rimosso: " + username + " [" + legacyUsers.get(i).getType() + "]");
                legacyUsers.remove(i);
                return true;
            }
        }
        System.out.println("LegacySystem: Utente non trovato: " + username);
        return false;
    }

    // Cerca un utente secondo la strategia corrente (case sensitive o insensitive)
    public boolean searchUser(String username) {
        return strategy.search(legacyUsers, username);
    }

    // Mostra tutti gli utenti registrati
    public void showAll() {
        System.out.println("== UTENTI REGISTRATI ==");
        for (User u : legacyUsers)
            System.out.println(u.getUsername());
        if (legacyUsers.isEmpty()) System.out.println("[nessun utente]");
    }

    // Autenticazione semplice: restituisce l'utente admin se trovato, null altrimenti
    public User authenticateAdmin(String username) {
        for (User u : legacyUsers) {
            if (u.getUsername().equals(username) && u.isAdmin()) {
                return u;
            }
        }
        return null;
    }
}


// Adapter: espone la nuova interfaccia e "traduce" verso il sistema legacy
interface UserManagement {
    void createUser(String username, String type); // Crea user con tipo (admin/guest)
    void deleteUser(String username, String adminUsername); // Elimina solo se admin
    String findUser(String username);
    void showAll();
    void setSearchStrategy(SearchStrategy strategy);
}

class UserManagementAdapter implements UserManagement {
    private LegacyUserSystem legacySystem;
    private UserFactory adminFactory = new AdminFactory();
    private UserFactory guestFactory = new GuestFactory();

    public UserManagementAdapter(LegacyUserSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    // Usa il Factory Method per creare il tipo giusto di utente (admin o guest)
    public void createUser(String username, String type) {
        User user = "admin".equalsIgnoreCase(type)
            ? adminFactory.createUser(username)
            : guestFactory.createUser(username);
        legacySystem.addUser(user);
    }

    // Elimina utente SOLO se l'adminUsername corrisponde a un admin valido registrato
    public void deleteUser(String username, String adminUsername) {
        User admin = legacySystem.authenticateAdmin(adminUsername);
        if (admin == null) {
            System.out.println("Autenticazione fallita: non sei un admin o non esisti.");
            return;
        }
        legacySystem.removeUser(username, admin);
    }

    // Cerca utente tramite la strategia impostata
    public String findUser(String username) {
        boolean found = legacySystem.searchUser(username);
        return found ? username : null;
    }
    public void showAll() { legacySystem.showAll(); }
    public void setSearchStrategy(SearchStrategy strategy) {
        legacySystem.setSearchStrategy(strategy);
    }
}


// menù interattivo per testare tutti i pattern insieme
public class Esercizio2Adapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LegacyUserSystem legacySystem = new LegacyUserSystem();
        UserManagement userManager = new UserManagementAdapter(legacySystem);

        // Imposta di default la ricerca case sensitive
        userManager.setSearchStrategy(new CaseSensitiveSearch());

        // Ciclo del menù
        while (true) {
            System.out.println("\n--- MENU GESTIONE UTENTI ---");
            System.out.println("1. Crea utente");
            System.out.println("2. Cerca utente");
            System.out.println("3. Elimina utente (solo admin)");
            System.out.println("4. Mostra utenti");
            System.out.println("5. Cambia strategia di ricerca");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");
            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1":
                    System.out.print("Inserisci nome utente da creare: ");
                    String nuovo = scanner.nextLine();

                    // Ciclo per chiedere il tipo di utente finché non è valido
                    String tipo;
                    while (true) {
                        System.out.print("Tipo utente (admin/guest): ");
                        tipo = scanner.nextLine().toLowerCase();
                        if ("admin".equals(tipo) || "guest".equals(tipo)) {
                            break;
                        } else {
                            System.out.println("Tipo non valido. Scrivi solo 'admin' o 'guest'.");
                        }
                    }
                    userManager.createUser(nuovo, tipo);
                    break;
                case "2":
                    // Cerca utente
                    System.out.print("Inserisci nome utente da cercare: ");
                    String cerca = scanner.nextLine();
                    String trovato = userManager.findUser(cerca);
                    if (trovato != null) {
                        System.out.println("Utente trovato: " + trovato);
                    } else {
                        System.out.println("Utente non trovato.");
                    }
                    break;
                case "3":
                    // Elimina utente (solo admin)
                    System.out.print("Inserisci nome utente da eliminare: ");
                    String elimina = scanner.nextLine();
                    System.out.print("Inserisci il tuo username admin: ");
                    String admin = scanner.nextLine();
                    userManager.deleteUser(elimina, admin);
                    break;
                case "4":
                    // Mostra tutti gli utenti
                    userManager.showAll();
                    break;
                case "5":
                    // Cambia la strategia di ricerca
                    System.out.println("1. Ricerca Case Sensitive");
                    System.out.println("2. Ricerca Case Insensitive");
                    System.out.print("Scelta: ");
                    String strat = scanner.nextLine();
                    if ("1".equals(strat)) {
                        userManager.setSearchStrategy(new CaseSensitiveSearch());
                        System.out.println("Strategia: Case Sensitive");
                    } else if ("2".equals(strat)) {
                        userManager.setSearchStrategy(new CaseInsensitiveSearch());
                        System.out.println("Strategia: Case Insensitive");
                    } else {
                        System.out.println("Scelta non valida!");
                    }
                    break;
                case "6":
                    // Esci dal programma
                    System.out.println("Chiusura programma.");
                    scanner.close();
                    return;
                default:
                    // Opzione non valida
                    System.out.println("Scelta non valida!");
            }
        }
    }
}
