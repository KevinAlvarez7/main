package duke.logic.commands;

import java.util.List;
import java.util.stream.*;

import duke.models.FindLocker;
import duke.models.LockerList;
import duke.models.locker.Address;
import duke.models.locker.Locker;
import duke.models.locker.SerialNumber;
import duke.models.locker.Zone;
import duke.storage.FileHandling;
import duke.ui.Ui;

public class FindCommand extends Command {
    private final FindLocker findLocker;


    public FindCommand(FindLocker findLocker) {
        this.findLocker = findLocker;
    }

    @Override
    public void execute(LockerList lockerList, Ui ui, FileHandling storage){

        List<Locker> containsMatchedLocker = lockerList.getLockerList().stream().filter(s->s.compare(this.findLocker)).
                collect(Collectors.toList());

        ui.printFoundLockers(containsMatchedLocker);
    }
}

