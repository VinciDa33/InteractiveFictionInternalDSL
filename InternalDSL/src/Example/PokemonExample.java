package Example;

import dsl.TextSystemBuilder;

public class PokemonExample extends TextSystemBuilder {
    @Override
    public void build() {
        informationEvent("NewBattle", "Youngster Joe wants to battle!").
            transition("sentOutPokemon").

        informationEvent("sentOutPokemon", "Youngster Joe sent out Pidgey!\nYou sent out Pikachu").
            transition("yourTurn").

        choiceEvent("yourTurn", "What will you do?").
            option("Battle").
                transition("battle").
            option("Bag").
                transition("bag").
            option("Switch").
                transition("switch").
            option("Run").
                transition("run").

        choiceEvent("battle", "Choose your move!").
            option("Thunder").
                transition("thunderUsed").
            option("Quick Attack").
                transition("quickAttackUsed").

        informationEvent("bag", "You are broke, and your backpack is empty!").
            transition("yourTurn").

        informationEvent("switch", "You have no other pokemon!").
            transition("yourTurn").

        informationEvent("run", "You ran away!\nYou left Pikachu behind...").

        informationEvent("thunderUsed", "Pikachu used Thunder. It was super effective!").
            transition("victory").

        informationEvent("quickAttackUsed", "Pikachu used Quick Attack. It was a critical hit!").
            transition("victory").

        informationEvent("victory", "Pidgey Fainted!\nYoungster Joe was defeated!");
    }
}
