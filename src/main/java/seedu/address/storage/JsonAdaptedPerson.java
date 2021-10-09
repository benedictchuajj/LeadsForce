package seedu.address.storage;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String clientId;
    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final String riskAppetite;
    private final String disposableIncome;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("clientId") String clientId, @JsonProperty("name") String name,
            @JsonProperty("phone") String phone, @JsonProperty("email") String email,
            @JsonProperty("address") String address, @JsonProperty("riskAppetite") String riskAppetite,
            @JsonProperty("disposabeIncome") String disposableIncome,
            @JsonProperty("tagged") List<JsonAdaptedTag> tagged) {

        this.clientId = clientId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.riskAppetite = riskAppetite;
        this.disposableIncome = disposableIncome;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        clientId = source.getClientId().value;
        name = source.getName().fullName;
        email = source.getEmail().value;
        Optional<Phone> checkPhoneNumber = source.getPhone();
        phone = checkPhoneNumber.isEmpty() ? "" : checkPhoneNumber.get().value;
        Optional<Address> checkAddress = source.getAddress();
        address = checkAddress.isEmpty() ? "" : checkAddress.get().value;
        Optional<RiskAppetite> checkRiskAppetite = source.getRiskAppetite();
        riskAppetite = checkRiskAppetite.isEmpty() ? "" : checkRiskAppetite.get().value;
        Optional<DisposableIncome> checkDisposableIncome = source.getDisposableIncome();
        disposableIncome = checkDisposableIncome.isEmpty() ? "" : checkDisposableIncome.get().value;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }

        if (clientId == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }

        final ClientId modelClientId = new ClientId(clientId);

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        final Phone modelPhone;

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        } else if (phone.isEmpty()) {
            modelPhone = null;
        } else if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        } else {
            modelPhone = new Phone(phone);
        }

        final Address modelAddress;

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        } else if (address.isEmpty()) {
            modelAddress = null;
        } else if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        } else {
            modelAddress = new Address(address);
        }

        final RiskAppetite modelRiskAppetite;
        if (riskAppetite == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT
                , RiskAppetite.class.getSimpleName()));
        } else if (riskAppetite.isEmpty()) {
            modelRiskAppetite = null;
        } else if (!RiskAppetite.isValidRiskAppetite(riskAppetite)) {
            throw new IllegalValueException(RiskAppetite.MESSAGE_CONSTRAINTS);
        } else {
            modelRiskAppetite = new RiskAppetite(riskAppetite);
        }

        final DisposableIncome modelDisposableIncome;

        if (disposableIncome == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, DisposableIncome.class.getSimpleName()));
        } else if (disposableIncome.isEmpty()) {
            modelDisposableIncome = null;
        } else if (!DisposableIncome.isValidDisposableIncome(disposableIncome)) {
            throw new IllegalValueException(DisposableIncome.MESSAGE_CONSTRAINTS);
        } else {
            modelDisposableIncome = new DisposableIncome(disposableIncome);
        }

        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new Person(modelClientId, modelName, modelPhone, modelEmail, modelAddress, modelRiskAppetite,
            modelDisposableIncome, modelTags);
    }

}
