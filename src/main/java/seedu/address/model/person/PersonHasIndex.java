package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.core.index.Index;

/**
 * Tests that a {@code Person}'s attributes matches any of the keywords given.
 */
public class PersonHasIndex implements Predicate<Person> {
    private final Index clientId;

    public PersonHasIndex(ClientId clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean test(Person person) {
        return Person.getClientId().equals(clientId);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonHasIndex // instanceof handles nulls
                && clientId.equals(((PersonHasIndex) other).clientId)); // state check
    }

}
