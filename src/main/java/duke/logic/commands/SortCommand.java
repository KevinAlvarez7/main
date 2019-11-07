package duke.logic.commands;

import duke.exceptions.DukeException;
import duke.models.LockerList;
import duke.models.ObjectComparator;
import duke.storage.FileHandling;
import duke.ui.Ui;

import java.util.Collections;

import static java.util.Objects.requireNonNull;

public class SortCommand extends Command {
    private final String sortBy;
    private final int checkAscOrDes;

    public SortCommand(String sortBy, int checkAscOrDes) {
        this.sortBy = sortBy;
        this.checkAscOrDes = checkAscOrDes;
    }

    @Override
    public void execute(LockerList lockerList, Ui ui, FileHandling storage) throws DukeException {

        requireNonNull(lockerList);

        if (checkAscOrDes == 1){

            if (this.sortBy.equals("serialNumber")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.SerialNumberComparatorAsc);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("address")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.AddressComparatorAsc);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("zone")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.ZoneComparatorAsc);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("tags")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.TagComparatorAsc);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("names")){

            }

        }

        if (checkAscOrDes == 0){

            if (this.sortBy.equals("serialNumber")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.SerialNumberComparatorDes);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("address")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.AddressComparatorDes);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("zone")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.ZoneComparatorDes);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("tags")){
                Collections.sort(lockerList.getLockerList(), ObjectComparator.TagComparatorDes);
                ui.printSortedLockers(lockerList.getLockerList());
            }

            else if (this.sortBy.equals("names")){

            }

        }

    }
}
