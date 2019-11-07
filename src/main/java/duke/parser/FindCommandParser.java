package duke.parser;

import duke.exceptions.DukeException;
import duke.logic.commands.Command;
import duke.logic.commands.FindCommand;
import duke.models.locker.Address;
import duke.models.locker.SerialNumber;
import duke.models.locker.Zone;
import duke.parser.utilities.MapTokensToArguments;
import duke.parser.utilities.ParserTokenizer;
import duke.parser.utilities.Token;

import static duke.parser.utilities.Syntax.*;

public class FindCommandParser {

    /**
     * This function is used to parse the user input for finding a locker to the list.
     * Later it will include all checks for validating the user input
     * @param userInput stores the user input
     * @throws DukeException when the command format is invalid
     * @return reference to the class FindCommand
     */

    public Command parse(String userInput) throws DukeException {

        MapTokensToArguments mapTokensToArguments =
                ParserTokenizer.tokenize(userInput, TOKEN_SERIAL, TOKEN_ADDRESS, TOKEN_ZONE);

        FindCommand.FindLocker findLocker = new FindCommand.FindLocker();

        if (checkTokenPresent(mapTokensToArguments,
                TOKEN_SERIAL)){
            SerialNumber serialNumber = ParserCheck.parseSerialNumber(
                    mapTokensToArguments.getValue(TOKEN_SERIAL).get());

            findLocker.setSerialNumber(serialNumber);
        }
        if (checkTokenPresent(mapTokensToArguments,
                TOKEN_ADDRESS)){
            Address address = ParserCheck.parseAddress(
                    mapTokensToArguments.getValue(TOKEN_ADDRESS).get());

            findLocker.setAddress(address);
        }
        if (checkTokenPresent(mapTokensToArguments,
                TOKEN_ZONE)) {

            Zone zone = ParserCheck.parseZone(
                    mapTokensToArguments.getValue(TOKEN_ZONE).get());

            findLocker.setZone(zone);

        }

        if (!findLocker.missingFields()) {
            throw new DukeException(" Invalid command format");
        }

        return new FindCommand(findLocker);
    }

    private static boolean checkTokenPresent(MapTokensToArguments mapTokensToArguments,
                                                 Token tokens) {

        return mapTokensToArguments.getValue(tokens).isPresent();

    }

}

