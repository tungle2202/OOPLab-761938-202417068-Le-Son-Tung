package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ItemController {
    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.initOwner(primaryStage);

        VBox root = new VBox(15);
        root.paddingProperty().set(new Insets(20));
        root.alignmentProperty().set(Pos.CENTER);

        Label label;
        try {
            label = new Label(cart.addMedia(m));
        } catch (hust.soict.hedspi.aims.exception.LimitExceededException e) {
            label = new Label("Error: " + e.getMessage());
            label.setTextFill(javafx.scene.paint.Color.RED);
        }
        label.setFont(Font.font("Inter", 14));

        Button okButton = new Button("OK");
        okButton.setPrefWidth(80);
        okButton.setOnAction(e -> dialogStage.close());

        root.getChildren().addAll(label, okButton);
        Scene content = new Scene(root, 350, 150);
        dialogStage.setScene(content);
        dialogStage.show();
    }

    @FXML
    void btnPlayClicked(ActionEvent event){
        if (m instanceof Playable) {
            try {
                ((Playable) m).play();
            } catch (hust.soict.hedspi.aims.exception.PlayerException e) {
                Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.APPLICATION_MODAL);
                dialogStage.initOwner(primaryStage);
                dialogStage.setTitle("Player Error");

                VBox root = new VBox(15);
                root.paddingProperty().set(new Insets(20));
                root.alignmentProperty().set(Pos.CENTER);

                Label titleLabel = new Label("Player Error");
                titleLabel.setFont(Font.font("Inter", FontWeight.BOLD, 16));
                titleLabel.setTextFill(javafx.scene.paint.Color.RED);

                Label detailsLabel = new Label("Could not play media: " + e.getMessage());
                detailsLabel.setFont(Font.font("Inter", 14));

                Button okButton = new Button("OK");
                okButton.setPrefWidth(80);
                okButton.setOnAction(ev -> dialogStage.close());

                root.getChildren().addAll(titleLabel, detailsLabel, okButton);
                Scene content = new Scene(root, 380, 180);
                dialogStage.setScene(content);
                dialogStage.show();
                return;
            }

            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);

            VBox root = new VBox(15);
            root.paddingProperty().set(new Insets(20));
            root.alignmentProperty().set(Pos.CENTER);

            if (m instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) m;
                ArrayList<Track> trackList = cd.getTracks();
                dialogStage.setTitle("Playing CD");

                Label titleLabel = new Label("Playing CD: " + cd.getTitle());
                titleLabel.setFont(Font.font("Inter", FontWeight.BOLD, 16));

                Label artistLabel = new Label("Artist: " + cd.getArtist() + " | Total Length: " + cd.getLength() + "s");
                artistLabel.setFont(Font.font("Inter", 13));

                VBox trackBox = new VBox(10);
                trackBox.alignmentProperty().set(Pos.CENTER);
                trackBox.setStyle("-fx-border-color: #cccccc; -fx-border-radius: 5; -fx-padding: 15; -fx-background-color: #f9f9f9;");

                Label trackTitleLabel = new Label();
                trackTitleLabel.setFont(Font.font("Inter", FontWeight.BOLD, 14));
                
                Label trackLengthLabel = new Label();
                trackLengthLabel.setFont(Font.font("Inter", 13));

                Label trackIndicatorLabel = new Label();
                trackIndicatorLabel.setFont(Font.font("Inter", 12));
                trackIndicatorLabel.setTextFill(javafx.scene.paint.Color.GRAY);

                HBox navButtons = new HBox(20);
                navButtons.alignmentProperty().set(Pos.CENTER);
                
                Button btnPrev = new Button("Previous Track");
                Button btnNext = new Button("Next Track");

                final int[] currentTrackIdx = {0};

                Runnable updateTrackView = () -> {
                    if (trackList == null || trackList.isEmpty()) {
                        trackTitleLabel.setText("No tracks available in this CD");
                        trackLengthLabel.setText("");
                        trackIndicatorLabel.setText("0 of 0");
                        btnPrev.setDisable(true);
                        btnNext.setDisable(true);
                    } else {
                        Track currentTrack = trackList.get(currentTrackIdx[0]);
                        trackTitleLabel.setText("Playing Track: " + currentTrack.getTitle());
                        trackLengthLabel.setText("Track Length: " + currentTrack.getLength() + " seconds");
                        trackIndicatorLabel.setText("Track " + (currentTrackIdx[0] + 1) + " of " + trackList.size());
                        btnPrev.setDisable(false);
                        btnNext.setDisable(false);
                    }
                };

                btnPrev.setOnAction(e -> {
                    if (trackList != null && !trackList.isEmpty()) {
                        currentTrackIdx[0] = (currentTrackIdx[0] - 1 + trackList.size()) % trackList.size();
                        updateTrackView.run();
                    }
                });

                btnNext.setOnAction(e -> {
                    if (trackList != null && !trackList.isEmpty()) {
                        currentTrackIdx[0] = (currentTrackIdx[0] + 1) % trackList.size();
                        updateTrackView.run();
                    }
                });

                updateTrackView.run();

                navButtons.getChildren().addAll(btnPrev, btnNext);
                trackBox.getChildren().addAll(trackTitleLabel, trackLengthLabel, trackIndicatorLabel);

                Button okButton = new Button("OK");
                okButton.setPrefWidth(80);
                okButton.setOnAction(e -> dialogStage.close());

                root.getChildren().addAll(titleLabel, artistLabel, trackBox, navButtons, okButton);
                Scene content = new Scene(root, 400, 320);
                dialogStage.setScene(content);
            } else if (m instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) m;
                dialogStage.setTitle("Playing DVD");

                Label titleLabel = new Label("Playing DVD: " + dvd.getTitle());
                titleLabel.setFont(Font.font("Inter", FontWeight.BOLD, 16));
                
                Label detailsLabel = new Label("DVD Length: " + dvd.getLength() + " minutes");
                detailsLabel.setFont(Font.font("Inter", 14));

                Button okButton = new Button("OK");
                okButton.setPrefWidth(80);
                okButton.setOnAction(e -> dialogStage.close());

                root.getChildren().addAll(titleLabel, detailsLabel, okButton);
                Scene content = new Scene(root, 380, 200);
                dialogStage.setScene(content);
            } else {
                dialogStage.setTitle("Playing Media");

                Label titleLabel = new Label("Playing: " + m.getTitle());
                titleLabel.setFont(Font.font("Inter", FontWeight.BOLD, 16));

                Button okButton = new Button("OK");
                okButton.setPrefWidth(80);
                okButton.setOnAction(e -> dialogStage.close());

                root.getChildren().addAll(titleLabel, okButton);
                Scene content = new Scene(root, 350, 150);
                dialogStage.setScene(content);
            }

            dialogStage.show();
        }
    }
    private final Cart cart;
    private Media m;
    public ItemController(Cart cart){
        this.cart = cart;
    }

    public void setData(Media media) {
        lblTitle.setText(media.getTitle());
        lblCost.setText("$" + media.getCost());
        btnPlay.setManaged(media instanceof Playable);
        m = media;
    }
}