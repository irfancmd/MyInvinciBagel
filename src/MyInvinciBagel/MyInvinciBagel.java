package MyInvinciBagel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyInvinciBagel extends Application {
    static final int WIDTH = 640, HEIGHT = 400;
    boolean up, down, left, right;
    static Scene scene;
    static StackPane root;
    static Image splashScreenImage, instructionLayerImage, legalLayerImage, scoresLayerImage;
    static ImageView splashScreenBackground, splashScreenTextArea;
    static Button gameButton, helpButton, scoreButton, legalButton;
    static HBox buttonContainer;
    static Insets buttonContainerPadding;

    GamePlayLoop gamePlayLoop;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Creating and adding nodes(components) to the scene
        createSplashScreenNodes();
        addNotesToStackPane();

        // Setting up the stage(window)
        primaryStage.setTitle("MyInvinciBagel");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Attaching event handlers to the buttons
        gameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                splashScreenBackground.setVisible(false);
                splashScreenTextArea.setVisible(false);
            }
        });
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                splashScreenBackground.setVisible(true);
                splashScreenTextArea.setVisible(true);
                splashScreenTextArea.setImage(instructionLayerImage);
            }
        });
        scoreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                splashScreenBackground.setVisible(true);
                splashScreenTextArea.setVisible(true);
                splashScreenTextArea.setImage(scoresLayerImage);
            }
        });
        legalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                splashScreenBackground.setVisible(true);
                splashScreenTextArea.setVisible(true);

                splashScreenTextArea.setImage(legalLayerImage);
            }
        });

        // Setup the game loop
        gamePlayLoop = new GamePlayLoop();
        gamePlayLoop.start();
    }

    public void createSplashScreenNodes() {
        root = new StackPane();
        scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        up = true;
                        break;
                    case DOWN:
                        down = true;
                        break;
                    case LEFT:
                        left = true;
                        break;
                    case RIGHT:
                        right = true;
                        break;
                    case W:
                        up = true;
                        break;
                    case S:
                        down = true;
                        break;
                    case A:
                        left = true;
                        break;
                    case D:
                        right = true;
                        break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        up = false;
                        break;
                    case DOWN:
                        down = false;
                        break;
                    case LEFT:
                        left = false;
                        break;
                    case RIGHT:
                        right = false;
                        break;
                    case W:
                        up = false;
                        break;
                    case S:
                        down = false;
                        break;
                    case A:
                        left = false;
                        break;
                    case D:
                        right = false;
                        break;
                }
            }
        });

        buttonContainer = new HBox(12);
        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        buttonContainerPadding = new Insets(0, 0, 10, 16);
        buttonContainer.setPadding(buttonContainerPadding);

        gameButton = new Button("Play Game");
        helpButton = new Button("Instructions");
        scoreButton = new Button("High Scores");
        legalButton = new Button("Legal & Credits");

        buttonContainer.getChildren().addAll(gameButton, helpButton, scoreButton, legalButton);

        splashScreenImage = new Image("/invincibagelsplash.png", 640, 400, true, false, true);
        splashScreenBackground = new ImageView();
        splashScreenBackground.setImage(splashScreenImage);

        instructionLayerImage = new Image("/invincibagelinstruct.png", 640, 400, true, false, true);
        splashScreenTextArea = new ImageView();
        splashScreenTextArea.setImage(instructionLayerImage);

        legalLayerImage = new Image("/invincibagelcreds.png", 640, 400, true, false, true);
        scoresLayerImage = new Image("/invincibagelscores.png", 640, 400, true, false, true);
    }

    public void addNotesToStackPane() {
        root.getChildren().add(splashScreenBackground);
        root.getChildren().add(splashScreenTextArea);
        root.getChildren().add(buttonContainer);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
