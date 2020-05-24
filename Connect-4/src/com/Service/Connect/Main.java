package com.Service.Connect;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane root = loader.load();

		controller = loader.getController();
		controller.createPlayground();

		MenuBar menuBar = createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		Pane menuPane = (Pane) root.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect Four");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private MenuBar createMenu() {

		// File Menu
		Menu fileMenu = new Menu("File");

		MenuItem newGame = new MenuItem("New game");
		newGame.setOnAction(event -> controller.resetGame());

		MenuItem resetGame = new MenuItem("Reset game");
		resetGame.setOnAction(event -> controller.resetGame());

		SeparatorMenuItem sep = new SeparatorMenuItem();
		MenuItem exitGame = new MenuItem("Exit game");
		exitGame.setOnAction(event -> exitGame());

		fileMenu.getItems().addAll(newGame,resetGame,sep,exitGame);

		// Help Menu
		Menu helpMenu = new Menu("Help");

		MenuItem aboutGame = new MenuItem("About Connect4");
		aboutGame.setOnAction(event -> aboutConnect4());

		SeparatorMenuItem se = new SeparatorMenuItem();
		MenuItem about1 = new MenuItem("About Developer");
		about1.setOnAction(event -> aboutDev());

		helpMenu.getItems().addAll(aboutGame,se,about1);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutDev() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Developer");
		alert.setHeaderText("Junior MNR");
		alert.setContentText("I love to play around with code and create games. Connect 4 is one of them.");
        ButtonType ba=new ButtonType("Back");
        alert.getButtonTypes().setAll(ba);
        Optional<ButtonType> click =alert.showAndWait();

	}

	private void aboutConnect4() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play?");
		alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid.The pieces fall straight down, occupying the next available space within the column.The objective of the game is to be the first to form a horizontal, vertical,or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        ButtonType back=new ButtonType("Back");
        alert.getButtonTypes().setAll(back);
		Optional<ButtonType> click=alert.showAndWait();
	}

	private void exitGame() {

		Platform.exit();
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
