package duke.parser;

import duke.logic.commands.Command;
import duke.logic.commands.ListCommand;

public class FindCommandParser {
    public Command parse() {
        return new ListCommand();
    }
}
