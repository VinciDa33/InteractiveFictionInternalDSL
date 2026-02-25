package Model;

public class InformationEvent extends Event {

    private Transition transition;

    public InformationEvent(String name, String text) {
        super(name, text);
    }

    @Override
    public void run(EventSystem system) {
        System.out.println(text + "\n");

        //If an information event has no transition, it is considered a terminal event
        if (transition != null)
            transition.run(system);
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }
}
