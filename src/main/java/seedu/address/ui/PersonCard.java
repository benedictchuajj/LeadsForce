package seedu.address.ui;

import java.util.Comparator;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.*;

/**
 * An UI component that displays the important information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label clientId;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private Label lastMet;
    @FXML
    private Label currentPlan;
    @FXML
    private Label riskAppetite;
    @FXML
    private Label disposableIncome;
    @FXML
    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        clientId.setText(person.getClientId().value);
        name.setText(person.getName().fullName);
        email.setText(person.getEmail().value);
        lastMet.setText(person.getLastMet().toString());
        Optional<Phone> phoneNumber = (Optional<Phone>) person.getPhone();
        phone.setText(phoneNumber.isEmpty() ? "No phone number stored yet" : phoneNumber.get().value);
        Optional<Address> addressString = (Optional<Address>) person.getAddress();
        address.setText(addressString.isEmpty() ? "No address stored yet" : addressString.get().value);
        Optional<RiskAppetite> riskAppetiteString = (Optional<RiskAppetite>) person.getRiskAppetite();
        riskAppetite.setText(riskAppetiteString.isEmpty() ? "No risk appetite stored yet"
            : riskAppetiteString.get().value);
        Optional<DisposableIncome> disposableIncomeString = (Optional<DisposableIncome>) person.getDisposableIncome();
        disposableIncome.setText(disposableIncomeString.isEmpty() ? "No disposable income stored yet" :
                disposableIncomeString.get().value);
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
