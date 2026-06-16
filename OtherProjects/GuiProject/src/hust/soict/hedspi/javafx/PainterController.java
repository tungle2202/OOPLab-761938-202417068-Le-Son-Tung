package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    private Color brushColor = Color.BLACK;


    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    public void penButtonClicked(MouseEvent mouseEvent) {
        brushColor = Color.BLACK;
    }

    public void eraserButtonClicked(MouseEvent mouseEvent) {
        brushColor = Color.WHITE;
    }
}
