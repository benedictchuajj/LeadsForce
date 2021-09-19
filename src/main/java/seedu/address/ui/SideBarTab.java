package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

public class SideBarTab extends UiPart<Region> {

    private static final String FXML = "SideBarTab.fxml";

    @FXML
    private ImageView sideBarTabIcon;

    @FXML
    private Label sideBarTabName;

    public SideBarTab(Image image, String name) {
        super(FXML);

        sideBarTabIcon.setImage(image);
        sideBarTabName.setText(name);
    }
}

