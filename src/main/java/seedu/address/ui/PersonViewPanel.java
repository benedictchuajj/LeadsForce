package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.person.Person;

/**
 * Panel that displays the full information of a {@code Person}.
 */
public class PersonViewPanel extends UiPart<Region> {

    private static final String FXML = "PersonViewPanel.fxml";

    @FXML
    private VBox clientInfoContainer;

    @FXML
    private Label clientName;

    @FXML
    private Label clientId;

    @FXML
    private Label clientCreationDate;

    @FXML
    private Label clientCreatedAt;

    @FXML
    private Label clientLastMet;

    @FXML
    private Label clientRiskAppetite;

    @FXML
    private Label clientCurrentPlans;

    @FXML
    private Label clientDisposableIncome;

    @FXML
    private Label nextMeeting;

    @FXML
    private VBox contactInfoContainer;

    @FXML
    private Label clientEmail;

    @FXML
    private Label clientPhoneNumber;

    public PersonViewPanel(ObservableList<Person> personToView) {
        super(FXML);

        if (personToView.size() == 1 && personToView.get(0) != null) {
            Person person = personToView.get(0);
            clientName.setText(person.getName().toString());
            clientId.setText("-");
            clientCurrentPlans.setText("-");
            clientLastMet.setText(person.getLastMet().toString());
            clientRiskAppetite.setText("-");
            clientCurrentPlans.setText(person.getCurrentPlan().toString());
            clientDisposableIncome.setText("-");
            nextMeeting.setText("-");
            clientEmail.setText(person.getEmail().toString());
            clientPhoneNumber.setText(person.getPhone().toString());
        }
    }
}

