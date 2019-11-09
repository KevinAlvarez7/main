package duke.logic.commands;

import duke.exceptions.DukeException;
import duke.models.LockerList;

import duke.models.locker.Address;
import duke.models.locker.Locker;
import duke.models.locker.SerialNumber;
import duke.models.locker.Zone;
import duke.models.tag.Tag;
import duke.storage.FileHandling;

import duke.storage.Storage;

import duke.ui.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class RemindersCommand extends Command {

    public RemindersCommand() {

    }

    @Override
    public void execute(LockerList lockerList, Ui ui, Storage storage) throws DukeException {


        LocalDate now = LocalDate.now();
        String dateNow = now.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        LocalDate localDateNow = LocalDate.parse(dateNow,formatter);

        FindCommand.FindLocker unauthorisedLocker = new FindCommand.FindLocker();
        FindCommand.FindLocker brokenLocker = new FindCommand.FindLocker();
        FindCommand.FindStudent findStudent = new FindCommand.FindStudent();

        Tag unauthorized = new Tag("unauthorized");
        Tag broken = new Tag("broken");

        unauthorisedLocker.setTag(unauthorized);
        brokenLocker.setTag(broken);

        List<Locker> containsExpiringLockers = lockerList.getLockerList().stream()
                .filter(s -> s.findExpiryDate(localDateNow))
                .collect(Collectors.toList());

        List<Locker> containsUnauthorizedLockers = lockerList.getLockerList().stream()
                .filter(s -> s.compare(unauthorisedLocker, findStudent))
                .collect(Collectors.toList());

        List<Locker> containsBrokenLockers = lockerList.getLockerList().stream()
                .filter(s -> s.compare(brokenLocker, findStudent))
                .collect(Collectors.toList());

        ui.printReminders(containsExpiringLockers, containsUnauthorizedLockers, containsBrokenLockers);
    }

}
