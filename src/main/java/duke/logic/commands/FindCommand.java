package duke.logic.commands;

import duke.models.LockerList;
import duke.models.locker.Locker;
import duke.storage.FileHandling;
import duke.ui.Ui;

public class FindCommand extends Command {
    private final Locker findLocker;

    public FindCommand(Locker findLocker) {
        this.findLocker = findLocker;
    }

    @Override
    public void execute(LockerList lockerList, Ui ui, FileHandling storage){

        LockerList containsMatchedLocker = new LockerList();
        for (int i = 0; i < lockerList.numLockers(); i++) {
            if (lockerList.getLocker(i).matchLockerNumber(findLocker.getSerialNumber().getSerialNumberForLocker())) {
                containsMatchedLocker.addLocker(lockerList.getLocker(i));
            }
            else if (lockerList.getLocker(i).matchLockerAddress(findLocker.getAddress().getAddress())) {
                containsMatchedLocker.addLocker(lockerList.getLocker(i));
            }
            else if (lockerList.getLocker(i).matchLockerZone(findLocker.getZone().getZone())) {
                containsMatchedLocker.addLocker(lockerList.getLocker(i));
            }
        }

        ui.printFoundLockers(containsMatchedLocker.getAllLockers());
    }
}

