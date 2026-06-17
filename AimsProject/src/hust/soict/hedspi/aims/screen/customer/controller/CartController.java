package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class CartController {

    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private Label ohMyAlert;
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).play();

            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);

            VBox root = new VBox(15);
            root.paddingProperty().set(new Insets(20));
            root.alignmentProperty().set(Pos.CENTER);

            if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
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
            } else if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
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

                Label titleLabel = new Label("Playing: " + media.getTitle());
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costLabel.setText("$"+ String.format("%.2f",cart.totalCost()));
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try{
            final String STORE_FXML_FILE_PATH = "../view/Store.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            loader.setController(new ViewStoreController(store, cart));
            Parent root = (Parent) loader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private Button PlaceOrder;
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        // Clear the cart
        cart.kill();
        
        // Update cost label
        costLabel.setText("$0.00");

        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.initOwner(primaryStage);
        dialogStage.setTitle("Order Status");

        VBox root = new VBox(15);
        root.paddingProperty().set(new Insets(20));
        root.alignmentProperty().set(Pos.CENTER);

        Label label = new Label("Đơn hàng của bạn sẽ sớm được xử lý!");
        label.setFont(Font.font("Inter", 14));

        Button okButton = new Button("OK");
        okButton.setPrefWidth(80);
        okButton.setOnAction(e -> dialogStage.close());

        root.getChildren().addAll(label, okButton);
        Scene content = new Scene(root, 350, 150);
        dialogStage.setScene(content);
        dialogStage.show();
    }

    private Cart cart;
    private Store store;
    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        if(cart.getItemsOrdered() != null){
            tblMedia.setItems(cart.getItemsOrdered());
        }

        costLabel.setText("$"+ String.format("%.2f",cart.totalCost()));
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

    }

    private void updateButtonBar(Media media){
        if(media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }else{
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    private void showFilteredMedia(String target){
        if(target.isBlank()){
            tblMedia.setItems(cart.getItemsOrdered());
        }else{
            if(radioBtnFilterTitle.isSelected()){
                tblMedia.setItems(cart.getItemsOrdered(target));
            }else{
                ohMyAlert.setVisible(false);
                int id = 0;
                boolean found = true;
                try{
                    id = Integer.parseInt(target);
                }catch(NumberFormatException e){
                    ohMyAlert.setText("Sai định dạng số, vui lòng nhập lại (Chỉ nhận số nguyên không có khoảng trắng)");
                    ohMyAlert.setVisible(true);
                    found = false;
                }
                if(found){
                    tblMedia.setItems(cart.getItemsOrdered(id));
                }
            }
        }
    }
}
