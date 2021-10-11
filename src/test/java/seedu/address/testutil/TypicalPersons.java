package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

import static seedu.address.logic.commands.CommandTestUtil.*;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withClientId("0").withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
<<<<<<< HEAD
            .withPhone("94351253").withCurrentPlan("Prudential PRUShield")
            .withLastMet("07-10-2021").withTags("friends").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withPhone("98765432")
            .withCurrentPlan("Prudential PRUShield")
            .withLastMet("07-10-2021")
            .withTags("owesMoney", "friends")
            .build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").build();
=======
            .withPhone("94351253").withRiskAppetite("3").withDisposableIncome("300")
            .withTags("friends").build();
    public static final Person BENSON = new PersonBuilder().withClientId("1").withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25").withEmail("johnd@example.com").withPhone("98765432")
            .withRiskAppetite("3").withDisposableIncome("300").withTags("owesMoney", "friends").build();
    public static final Person CARL = new PersonBuilder().withClientId("2").withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withAddress("wall street").withRiskAppetite("3")
            .withDisposableIncome("300").build();
    public static final Person DANIEL = new PersonBuilder().withClientId("3").withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withAddress("10th street").withRiskAppetite("3")
            .withDisposableIncome("300").withTags("friends").build();
    public static final Person ELLE = new PersonBuilder().withClientId("4").withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withAddress("michegan ave").withRiskAppetite("3")
            .withDisposableIncome("300").build();
    public static final Person FIONA = new PersonBuilder().withClientId("5").withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withAddress("little tokyo").withRiskAppetite("3")
            .withDisposableIncome("300").build();
    public static final Person GEORGE = new PersonBuilder().withClientId("6").withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withAddress("4th street").withRiskAppetite("3").withDisposableIncome("300")
            .build();
>>>>>>> clientInfo/branch-add-clientinfo

    // Manually added
    public static final Person HOON = new PersonBuilder().withClientId("7").withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").withRiskAppetite("3")
            .withDisposableIncome("300").build();
    public static final Person IDA = new PersonBuilder().withClientId("8").withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").withRiskAppetite("3")
            .withDisposableIncome("300").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withClientId("9").withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withRiskAppetite(VALID_RISKAPPETITE_AMY)
            .withDisposableIncome(VALID_DISPOSABLEINCOME_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Person BOB = new PersonBuilder().withClientId("10").withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withRiskAppetite(VALID_RISKAPPETITE_BOB)
            .withDisposableIncome(VALID_DISPOSABLEINCOME_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
