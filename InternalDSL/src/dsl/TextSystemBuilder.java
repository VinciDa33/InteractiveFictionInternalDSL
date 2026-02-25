package dsl;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class TextSystemBuilder {

    protected EventSystem system;
    protected Event currentEvent;
    protected ChoiceOption currentChoiceOption;


    public TextSystemBuilder() {
        system = new EventSystem();
        this.build();
        //We assume the first event added is the starting event!
        system.getEvent(0).run(system);
    }

    protected abstract void build();

    public TextSystemBuilder choiceEvent(String name, String text) {
        currentEvent = new ChoiceEvent(name, text);
        system.addEvent(currentEvent);
        return this;
    }

    public TextSystemBuilder informationEvent(String name, String text) {
        currentEvent = new InformationEvent(name, text);
        system.addEvent(currentEvent);
        return this;
    }

    public TextSystemBuilder option(String text) {
        currentChoiceOption = new ChoiceOption(text);
        ((ChoiceEvent)currentEvent).addOptions(currentChoiceOption);
        return this;
    }

    public TextSystemBuilder transition(String nextEvent) {
        if (currentEvent instanceof InformationEvent) {
            ((InformationEvent)currentEvent).setTransition(new Transition(nextEvent));
            return this;
        }
        currentChoiceOption.setTransition(new Transition(nextEvent));
        return this;
    }
}
