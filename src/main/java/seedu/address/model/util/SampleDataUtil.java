package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
<<<<<<< HEAD
import seedu.address.model.person.Address;
import seedu.address.model.person.CurrentPlan;
import seedu.address.model.person.Email;
import seedu.address.model.person.LastMet;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
=======
import seedu.address.model.person.*;
>>>>>>> clientInfo/branch-add-clientinfo
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
<<<<<<< HEAD
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                new CurrentPlan("Prudential PRUwealth, AIA PLAN ABC, SUPER DUPER LONGLONGNGGNLONG PLAN NAMEEEEEE"),
                new LastMet("2021-01-24"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                new CurrentPlan("Prudential PRUwealth, AIA PLAN ABC, LONG PLAN NAMEEEEEE"),
                new LastMet("2021-01-24"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                new CurrentPlan("Prudential PRUwealth"), new LastMet("2021-01-24"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                new CurrentPlan("Prudential PRUwealth"), new LastMet("2021-01-24"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                new CurrentPlan("Prudential PRUwealth"), new LastMet("2021-01-24"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                new CurrentPlan("Prudential PRUwealth"), new LastMet("2021-01-24"),
                getTagSet("colleagues"))
=======
            new Person(new ClientId("0"), new Name("Alex Yeoh"), new Phone("87438807"),
                new Email("alexyeoh@example.com"), new Address("Blk 30 Geylang Street 29, #06-40"),
                new RiskAppetite("1"), new DisposableIncome("500"), getTagSet("friends")),
            new Person(new ClientId("1"), new Name("Bernice Yu"), new Phone("99272758"),
                new Email("berniceyu@example.com"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                new RiskAppetite("1"), new DisposableIncome("500"), getTagSet("colleagues", "friends")),
            new Person(new ClientId("2"), new Name("Charlotte Oliveiro"), new Phone("93210283"),
                new Email("charlotte@example.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                new RiskAppetite("1"), new DisposableIncome("500"), getTagSet("neighbours")),
            new Person(new ClientId("3"), new Name("David Li"), new Phone("91031282"),
                new Email("lidavid@example.com"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                new RiskAppetite("1"), new DisposableIncome("500"), getTagSet("family")),
            new Person(new ClientId("4"), new Name("Irfan Ibrahim"), new Phone("92492021"),
                new Email("irfan@example.com"), new Address("Blk 47 Tampines Street 20, #17-35"),
                new RiskAppetite("1"), new DisposableIncome("500"), getTagSet("classmates")),
            new Person(new ClientId("5"), new Name("Roy Balakrishnan"), new Phone("92624417"),
                new Email("royb@example.com"), new Address("Blk 45 Aljunied Street 85, #11-31"), new RiskAppetite("1"),
                new DisposableIncome("500"), getTagSet("colleagues"))
>>>>>>> clientInfo/branch-add-clientinfo
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        sampleAb.setClientCounter("6");
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
