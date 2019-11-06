package duke.logic.commands;

import duke.exceptions.DukeException;
import duke.models.LockerList;
import duke.storage.FileHandling;
import duke.ui.Ui;

public class HelpCommand extends Command {

    @Override
    public void execute(LockerList lockerList, Ui ui, FileHandling storage) throws DukeException {
        ui.printHelp();
    }
}
