package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CLIENTID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.ClientId;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonContainsKeywordsPredicate;
import seedu.address.model.person.PersonHasEmail;
import seedu.address.model.person.PersonHasId;
import seedu.address.model.person.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_CLIENTID, PREFIX_EMAIL);

        if (((!arePrefixesPresent(argMultimap, PREFIX_CLIENTID)) && (!arePrefixesPresent(argMultimap, PREFIX_EMAIL)))
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
        }

        ArrayList<Predicate> predicatesToDelete = new ArrayList<>();
        String clientIdString = argMultimap.getValue(PREFIX_CLIENTID).orElse("");
        if (!clientIdString.isEmpty()) {
            ClientId clientId = ParserUtil.parseClientId(clientIdString);
            predicatesToDelete.add(new PersonHasId(clientId));
        }

        String emailString = argMultimap.getValue(PREFIX_EMAIL).orElse("");
        if (!emailString.isEmpty()) {
            Email email = ParserUtil.parseEmail(emailString);
            predicatesToDelete.add(new PersonHasEmail(email));
        }

        return new DeleteCommand(predicatesToDelete);

    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
