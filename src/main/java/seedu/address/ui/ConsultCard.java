package seedu.address.ui;

import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.event.consult.Consult;

/**
 * An UI component that displays information of a {@code Consult}.
 */
public class ConsultCard extends UiPart<Region> {

    private static final String FXML = "ConsultListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Consult consult;

    @javafx.fxml.FXML
    private HBox cardPane;
    @javafx.fxml.FXML
    private Label id;
    @FXML
    private Label beginDateTime;
    @FXML
    private Label endDateTime;
    @FXML
    private Label eventLocation;

    public ConsultCard(Consult consult, int displayedIndex) {
        super(FXML);
        this.consult = consult;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MMM-YY");
        id.setText(displayedIndex + ". ");
        beginDateTime.setText("Start: " + consult.getBeginDateTime().format(formatter));
        endDateTime.setText("End: " + consult.getEndDateTime().format(formatter));
        eventLocation.setText("Location: " + consult.getLocation().getEventLocation());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ConsultCard)) {
            return false;
        }

        // state check
        ConsultCard card = (ConsultCard) other;
        return id.getText().equals(card.id.getText())
                && consult.equals(card.consult);
    }
}