package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
<<<<<<< HEAD
import seedu.address.model.person.Address;
import seedu.address.model.person.CurrentPlan;
import seedu.address.model.person.Email;
import seedu.address.model.person.LastMet;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
=======
import seedu.address.model.person.*;
>>>>>>> clientInfo/branch-add-clientinfo
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(Optional<String> phone) throws ParseException {
        if (phone.isEmpty()) {
            return null;
        } else {
            String phoneNumber = phone.get();
            requireNonNull(phoneNumber);
            String trimmedPhone = phoneNumber.trim();
            if (!Phone.isValidPhone(trimmedPhone)) {
                throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
            }
            return new Phone(trimmedPhone);
        }
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(Optional<String> address) throws ParseException {
        if (address.isEmpty()) {
            return null;
        } else {
            String addressString = address.get();
            requireNonNull(addressString);
            String trimmedAddress = addressString.trim();
            if (!Address.isValidAddress(trimmedAddress)) {
                throw new ParseException(Address.MESSAGE_CONSTRAINTS);
            }
            return new Address(trimmedAddress);
        }
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
<<<<<<< HEAD
     * Parses a {@code String current plan} into an {@code CurrentPlan}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code currentPlan} is invalid.
     */
    public static CurrentPlan parseCurrentPlan(String currentPlan) throws ParseException {
        requireNonNull(currentPlan);
        String trimmedCurrentPlan = currentPlan.trim();

        return new CurrentPlan(trimmedCurrentPlan);
    }

    /**
     * Parses a {@code String LastMet} into an {@code LastMet}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code LastMet} is invalid.
     */
    public static LastMet parseLastMet(String lastMet) throws ParseException {
        requireNonNull(lastMet);
        String trimmedLastMet = lastMet.trim();
        return new LastMet(trimmedLastMet);
=======
     * Parses a {@code String RiskAppetite} into an {@code RiskAppetite}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code RiskAppetite} is invalid.
     */
    public static RiskAppetite parseRiskAppetite(Optional<String> riskAppetite) throws ParseException {
        if (riskAppetite.isEmpty()) {
            return null;
        } else {
            String riskAppetiteString = riskAppetite.get();
            requireNonNull(riskAppetiteString);
            String trimmedRiskAppetite = riskAppetiteString.trim();
            if (!RiskAppetite.isValidRiskAppetite(trimmedRiskAppetite)) {
                throw new ParseException(RiskAppetite.MESSAGE_CONSTRAINTS);
            }
            return new RiskAppetite(trimmedRiskAppetite);
        }
    }

    /**
     * Parses a {@code String disposableIncome} into an {@code disposableIncome}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code DisposableIncome} is invalid.
     */
    public static DisposableIncome parseDisposableIncome(Optional<String> disposableIncome) throws ParseException {
        if (disposableIncome.isEmpty()) {
            return null;
        } else {
            String disposableIncomeString = disposableIncome.get();
            requireNonNull(disposableIncomeString);
            String trimmedDisposableIncome = disposableIncomeString.trim();
            if (!DisposableIncome.isValidDisposableIncome(trimmedDisposableIncome)) {
                throw new ParseException(DisposableIncome.MESSAGE_CONSTRAINTS);
            }
            return new DisposableIncome(trimmedDisposableIncome);
        }
>>>>>>> clientInfo/branch-add-clientinfo
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
