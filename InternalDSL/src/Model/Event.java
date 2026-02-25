package Model;

public abstract class Event {
    public String name;
    public String text;

    public Event(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public abstract void run(EventSystem system);
}
