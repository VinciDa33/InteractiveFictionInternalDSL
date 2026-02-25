package Model;

public class Transition {
    public String nextEvent;

    public Transition(String nextEvent) {
        this.nextEvent = nextEvent;
    }

    public void run(EventSystem system) {
        system.getEvent(nextEvent).run(system);
    }
}
