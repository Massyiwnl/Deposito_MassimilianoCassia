// Interfaccia Strategy
interface Strategy {
    void execute();
}

// Strategie Concrete
class ConcreteStrategyA implements Strategy {
    public void execute() {
        System.out.println("Strategia A eseguita.");
    }
}

class ConcreteStrategyB implements Strategy {
    public void execute() {
        System.out.println("Strategia B eseguita.");
    }
}

// Context
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask() {
        strategy.execute();
    }
}



public class ProvaStrategy {
    public static void main(String[] args) {
        // Uso da parte del Client
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.performTask(); // Output: Strategia A eseguita.
        context.setStrategy(new ConcreteStrategyB());
        context.performTask(); // Output: Strategia B eseguita.
    }
}
