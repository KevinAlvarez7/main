package duke.logic.commands;

import java.util.List;
import java.util.Optional;
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
        this.findLocker = new FindLocker(findLocker);
    }

    @Override
    public void execute(LockerList lockerList, Ui ui, FileHandling storage){

        List<Locker> containsMatchedLocker = lockerList.getLockerList().stream().
                filter(s->s.compare(this.findLocker.getSerialNumber(),
                this.findLocker.getAddress(), this.findLocker.getZone())).
                collect(Collectors.toList());

        ui.printFoundLockers(containsMatchedLocker);
    }


    public static class FindLocker {

        private SerialNumber serialNumber;
        private Address address;
        private Zone zone;

        public FindLocker() {

        }

        public FindLocker(FindLocker findLocker) {
            setSerialNumber(findLocker.serialNumber);
            setAddress(findLocker.address);
            setZone(findLocker.zone);
        }

        public void setSerialNumber(SerialNumber serialNumber) {
            this.serialNumber = serialNumber;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public void setZone(Zone zone) {
            this.zone = zone;
        }

        public boolean missingFields() {
            return (serialNumber != null || address != null
                    || zone != null);

        }

        public SerialNumber getSerialNumber() {
            return serialNumber;
        }

        public Address getAddress() {
            return address;
        }

        public Zone getZone() {
            return zone;
        }
    }
}



