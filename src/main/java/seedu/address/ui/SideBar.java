package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class SideBar extends UiPart<Region> {

    private static final String FXML = "SideBar.fxml";

    private SideBarTab contactBookButton;
    private SideBarTab calenderButton;
    private Image leadsForceLogo = new Image(this.getClass().getResourceAsStream("/images/placeholderLogo.png"));
    private Image contactIcon = new Image(this.getClass().getResourceAsStream("/images/address_book_32.png"));
    private Image calendarIcon = new Image(this.getClass().getResourceAsStream("/images/calendar.png"));

    @FXML
    private ImageView logo;

    @FXML
    private HBox sideBarHeader;

    @FXML
    private StackPane contactBookPlaceholder;

    @FXML
    private StackPane calendarPlaceholder;

    public SideBar() {
        super(FXML);

        logo.setImage(leadsForceLogo);

        contactBookButton = new SideBarTab(contactIcon, "Contacts");
        contactBookPlaceholder.getChildren().add(contactBookButton.getRoot());

        calenderButton = new SideBarTab(calendarIcon, "Calender");
        calendarPlaceholder.getChildren().add(calenderButton.getRoot());
    }
}