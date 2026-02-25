package Model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChoiceEvent extends Event{

    public List<ChoiceOption> options = new ArrayList<>();

    public ChoiceEvent(String name, String text) {
        super(name, text);
    }

    @Override
    public void run(EventSystem system) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(text + "\n");
        for(int i = 0; i < options.size(); i++)
            System.out.println("[" + (i+1) + "]: " + options.get(i).text);

        //It ain't pretty, but it's honest work!
        while (true) {
            String str = scanner.nextLine();
            try {
                int index = Integer.parseInt(str);
                index--;
                ChoiceOption option = options.get(index);
                option.run(system);
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Input a number!");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Input a valid number!");
            }
        }
    }

    public void addOptions(ChoiceOption option) {
        options.add(option);
    }
}
