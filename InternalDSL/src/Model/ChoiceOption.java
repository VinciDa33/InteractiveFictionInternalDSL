package Model;

public class ChoiceOption {
    public String text;
    private Transition transition;

    public ChoiceOption(String text) {
        this.text = text;
    }

    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    public void run(EventSystem system) {
        transition.run(system);
    }
}
