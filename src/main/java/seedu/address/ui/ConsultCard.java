package seedu.address.ui;

import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.event.consult.Consult;
import seedu.address.storage.StorageManager;

/**
 * An UI component that displays information of a {@code Consult}.
 */
public class ConsultCard extends UiPart<Region> {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);

    private static final String FXML = "ConsultListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on StudentTAble level 4</a>
     */

    public final Consult consult;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label studentName;
    @FXML
    private Label beginDateTime;
    @FXML
    private Label endDateTime;
    @FXML
    private Label eventLocation;

    public ConsultCard(Consult consult) {
        super(FXML);
        this.consult = consult;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MMM-YY");
        beginDateTime.setText("Start: " + consult.getBeginDateTime().format(formatter));
        endDateTime.setText("End: " + consult.getEndDateTime().format(formatter));
        eventLocation.setText("Location: " + consult.getLocation().toString());
        studentName.setText(consult.getStudentName().toString());
        logger.fine(consult.getLocation().toString());
        logger.fine(consult.getStudentName().toString());

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
        return consult.equals(card.consult);
    }
}
