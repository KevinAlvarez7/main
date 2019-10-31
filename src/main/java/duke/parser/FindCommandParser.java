package duke.parser;

import duke.exceptions.DukeException;
import duke.logic.commands.Command;
import duke.logic.commands.FindCommand;
import duke.models.FindLocker;
import duke.models.locker.Address;
import duke.models.locker.Locker;
import duke.models.locker.SerialNumber;
import duke.models.locker.Zone;
import duke.models.tag.Tag;
import duke.parser.utilities.MapTokensToArguments;
import duke.parser.utilities.ParserTokenizer;
import duke.parser.utilities.Token;

import java.util.stream.Stream;

import static duke.parser.utilities.Syntax.*;

public class FindCommandParser {

    /**
     * This function is used to parse the user input for finding a locker to the list.
     * Later it will include all checks for validating the user input
     * @param userInput stores the user input
     * @return reference to the class FindCommand
     * @throws DukeException when the command format is invalid
     */

    public Command parse(String userInput) throws DukeException {

        MapTokensToArguments mapTokensToArguments =
                ParserTokenizer.tokenize(userInput, TOKEN_SERIAL, TOKEN_ADDRESS, TOKEN_ZONE);
        if (!checkTokenPresent(mapTokensToArguments,
                TOKEN_SERIAL)
                || !checkTokenPresent(mapTokensToArguments,
                TOKEN_ADDRESS)
                || !checkTokenPresent(mapTokensToArguments,
                TOKEN_ZONE)
                || !mapTokensToArguments.getTextBeforeFirstToken().isEmpty()) {
            throw new DukeException(" Invalid command format");
        }

            SerialNumber serialNumber = ParserCheck.parseSerialNumber(
                    mapTokensToArguments.getValue(TOKEN_SERIAL).get());

            Address address = ParserCheck.parseAddress(
                    mapTokensToArguments.getValue(TOKEN_ADDRESS).get());

            Zone zone = ParserCheck.parseZone(
                    mapTokensToArguments.getValue(TOKEN_ZONE).get());

            FindLocker findLocker = new FindLocker(serialNumber, address, zone);

        return new FindCommand(findLocker);
    }

    private static boolean checkTokenPresent(MapTokensToArguments mapTokensToArguments,
                                                 Token tokens) {

        return mapTokensToArguments.getValue(tokens).isPresent();

    }

}

