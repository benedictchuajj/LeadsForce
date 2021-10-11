package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
<<<<<<< HEAD
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CURRENTPLAN;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_LASTMET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
=======
import static seedu.address.logic.parser.CliSyntax.*;
>>>>>>> clientInfo/branch-add-clientinfo

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
<<<<<<< HEAD
import seedu.address.model.person.Address;
import seedu.address.model.person.CurrentPlan;
import seedu.address.model.person.Email;
import seedu.address.model.person.LastMet;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
=======
import seedu.address.model.Model;
import seedu.address.model.person.*;
>>>>>>> clientInfo/branch-add-clientinfo
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    private Model model;

    public AddCommandParser(Model model) {
        this.model = model;

    }

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
<<<<<<< HEAD
                    PREFIX_LASTMET, PREFIX_CURRENTPLAN, PREFIX_TAG);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL,
            PREFIX_CURRENTPLAN, PREFIX_LASTMET) || !argMultimap.getPreamble().isEmpty()) {
=======
                    PREFIX_RISKAPPETITE, PREFIX_DISPOSABLEINCOME ,PREFIX_TAG);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_EMAIL)
                || !argMultimap.getPreamble().isEmpty()) {
>>>>>>> clientInfo/branch-add-clientinfo
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        String clientCounter;

        if (this.model == null) {
            clientCounter = "0";
        } else {
            clientCounter = this.model.getAddressBook().getClientCounter() == null ? "0"
                    : this.model.getAddressBook().getClientCounter();
        }

        ClientId clientId = new ClientId(clientCounter);
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
<<<<<<< HEAD
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));
        Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());


        LastMet lastMet = ParserUtil.parseLastMet(argMultimap.getValue(PREFIX_LASTMET).get());

        CurrentPlan currentPlan = ParserUtil.parseCurrentPlan(argMultimap.getValue(PREFIX_CURRENTPLAN).get());


        Person person = new Person(name, phone, email, address, currentPlan, lastMet, tagList);
=======
        Email email = ParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE));
        Address address = ParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS));
        RiskAppetite riskAppetite = ParserUtil.parseRiskAppetite(argMultimap
            .getValue(PREFIX_RISKAPPETITE));
        DisposableIncome disposableIncome = ParserUtil.parseDisposableIncome(argMultimap
            .getValue(PREFIX_DISPOSABLEINCOME));
        Set<Tag> tagList = ParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));

        Person person = new Person(clientId, name, phone, email, address, riskAppetite, disposableIncome, tagList);

        int tempClientCounter = Integer.parseInt(clientCounter);
        String newClientCounter = Integer.toString(tempClientCounter + 1);
        this.model.getAddressBook().setClientCounter(newClientCounter);
>>>>>>> clientInfo/branch-add-clientinfo

        return new AddCommand(person);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
