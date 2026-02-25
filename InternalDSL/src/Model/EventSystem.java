package Model;

import java.util.ArrayList;
import java.util.List;

public class EventSystem {
    protected List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getEvent(String name) {
        for(Event e : events) {
            if (e.name.equals(name))
                return e;
        }
        //We could cast an exception here, as this would most likely happen if a developer has misspelled an event name.
        return null;
    }

    public Event getEvent(int index) {
        return events.get(index);
    }

}
