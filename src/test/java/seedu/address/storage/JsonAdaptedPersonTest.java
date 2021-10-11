package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
<<<<<<< HEAD
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.LastMet;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
=======
import seedu.address.model.person.*;
>>>>>>> clientInfo/branch-add-clientinfo

public class JsonAdaptedPersonTest {
    private static final String INVALID_CLIENTID = "SEWQOJEWOQ";
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_RISKAPPETITE = "7";
    private static final String INVALID_DISPOSABLEINCOME = "-329";
    private static final String INVALID_TAG = "#friend";
    private static final String INVALID_LASTMET = "40-01-1999";
    private static final String EXAMPLE_CURRENT_PLAN = "Prudential PRUShield";

    private static final String VALID_CLIENTID = "10";
    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
<<<<<<< HEAD
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final String VALID_LASTMET = BENSON.getLastMet().toString();
=======
    private static final String VALID_PHONE = BENSON.getPhone().get().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().get().toString();
    private static final String VALID_RISKAPPETITE = BENSON.getRiskAppetite().get().toString();
    private static final String VALID_DISPOSABLEINCOME = BENSON.getDisposableIncome().get().toString();
>>>>>>> clientInfo/branch-add-clientinfo

    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedPerson person =
<<<<<<< HEAD
                new JsonAdaptedPerson(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_LASTMET,
                    EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
                new JsonAdaptedPerson(VALID_CLIENTID, INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                    VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME ,VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
<<<<<<< HEAD
        JsonAdaptedPerson person = new JsonAdaptedPerson(null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
            VALID_LASTMET, EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_CLIENTID,null, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
            VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person =
<<<<<<< HEAD
                new JsonAdaptedPerson(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_LASTMET,
                    EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
                new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ADDRESS, VALID_RISKAPPETITE,
                    VALID_DISPOSABLEINCOME, VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
<<<<<<< HEAD
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, null, VALID_EMAIL, VALID_ADDRESS,
            VALID_LASTMET, EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, null, VALID_EMAIL,
            VALID_ADDRESS, VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedPerson person =
<<<<<<< HEAD
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS, VALID_LASTMET,
                    EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
                new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ADDRESS,
                    VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
<<<<<<< HEAD
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, null, VALID_ADDRESS,
            VALID_LASTMET, EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, null,
            VALID_ADDRESS, VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedPerson person =
<<<<<<< HEAD
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS, VALID_LASTMET,
                    EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
                new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ADDRESS,
                    VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
<<<<<<< HEAD
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
            VALID_LASTMET, EXAMPLE_CURRENT_PLAN, VALID_TAGS);
=======
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
            VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, VALID_TAGS);
>>>>>>> clientInfo/branch-add-clientinfo
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
<<<<<<< HEAD
    public void toModelType_invalidLastMet_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, INVALID_LASTMET,
                    EXAMPLE_CURRENT_PLAN, VALID_TAGS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
=======
    public void toModelType_invalidRiskAppetite_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                    INVALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, VALID_TAGS);
        String expectedMessage = RiskAppetite.MESSAGE_CONSTRAINTS;
>>>>>>> clientInfo/branch-add-clientinfo
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
<<<<<<< HEAD
    public void toModelType_nullLastMet_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
            null, EXAMPLE_CURRENT_PLAN, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, LastMet.class.getSimpleName());
=======
    public void toModelType_nullRiskAppetite_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, null, VALID_DISPOSABLEINCOME, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, RiskAppetite.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidDisposableIncome_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                    VALID_RISKAPPETITE, INVALID_DISPOSABLEINCOME, VALID_TAGS);
        String expectedMessage = DisposableIncome.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullDisposableIncome_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, VALID_EMAIL,
                VALID_ADDRESS, VALID_RISKAPPETITE, null, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, DisposableIncome.class.getSimpleName());
>>>>>>> clientInfo/branch-add-clientinfo
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedPerson person =
<<<<<<< HEAD
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS, EXAMPLE_CURRENT_PLAN,
                    VALID_LASTMET, invalidTags);
=======
                new JsonAdaptedPerson(VALID_CLIENTID, VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ADDRESS,
                    VALID_RISKAPPETITE, VALID_DISPOSABLEINCOME, invalidTags);
>>>>>>> clientInfo/branch-add-clientinfo
        assertThrows(IllegalValueException.class, person::toModelType);
    }

}
