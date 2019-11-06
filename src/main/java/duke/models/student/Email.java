package duke.models.student;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import duke.exceptions.DukeException;

import static java.util.Objects.requireNonNull;

public class Email {

    public static final String ERROR_MESSAGE = " Email ID consists of two parts local-part@domain"
            + " and should satisfy the following constraints:"
            + "\n\n      1. The local-part and the domain name are separated by '@'"
            + "\n      2. The local-part should contain only aplhanumeric characters and special symbols"
            + " like (!#$%&'*+/=?`{|}~^.-)"
            + "\n      3. The domain name should contain at least two characters and start and end with "
            + "alphanumeric characters"
            + "\n      4. The domain name should consists of only alphanumeric characters, a '.' "
            + "or a '-' in the middle (optional)";
    public static final String VALID_REGEX = "^[\\w" + "!#$%&'*+/=?`{|}~^.-" + "]+" + "@"
            + "[^\\W_]" +  "[a-zA-Z0-9.-]*" + "[^\\W_]$";

    public String email;

    /**
     * This constructor instantiates the email id of a student.
     * @param email stores the email id of a student
     * @throws DukeException when the user enters invalid email id
     */
    public Email(String email) throws DukeException {
        requireNonNull(email);
        if (!checkIsValidEmail(email)) {
            throw new DukeException(ERROR_MESSAGE);
        }
        this.email = email;
    }

    public Email() {

    }

    public static boolean checkIsValidEmail(String email) {
        return email.matches(VALID_REGEX);
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /* We need to override functions equals and hashCode() in order to account
               user defined checks for equality while using streams.
             */
    @Override
    public boolean equals(Object other) {
        return this == other //short circuit if both objects are the same
                || (other instanceof Email // checks for all null values and irrelevant instances
                && this.email.equals(((Email) other).email)); //checks for equality
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
