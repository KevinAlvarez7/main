package duke.models.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import duke.exceptions.DukeException;

import static java.util.Objects.requireNonNull;

public class Name {

    public static final String ERROR_MESSAGE = " Name should contain only alpha numeric characters"
            + " and should not be blank.";

    public static final String CHECK_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    public String name;

    /**
     * This constructor instantiates the name of the student.
     * @param name stores the name of the student
     * @throws DukeException when the name is in invalid format
     */
    @JsonCreator
    public Name(@JsonProperty("name") String name) throws DukeException {
        requireNonNull(name);
        if (!checkIsValidName(name)) {
            throw new DukeException(ERROR_MESSAGE);
        }
        this.name = name;
    }

    public static boolean checkIsValidName(String name) {
        return name.matches(CHECK_REGEX);
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    /* We need to override functions equals and hashCode in order to account for
           user defined checks for equality while using streams.
         */
    @Override
    public boolean equals(Object other) {
        return other == this //checks whether the two objects are the same and short circuit
                || (other instanceof Name //checks for null references and other irrelevant cases
                && name.trim().equalsIgnoreCase(((Name) other).name.trim())); //checks for the equality
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
