package com.rss.ReligionClient.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReligionClientApplication extends Application {

	private ConfigurableApplicationContext sprintContext;
	private Parent rootNode;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		sprintContext = SpringApplication.run(ReligionClientApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
		fxmlLoader.setControllerFactory(sprintContext::getBean);
		rootNode = fxmlLoader.load();
		super.init();
	}

	@Override
	public void stop() throws Exception {
		sprintContext.close();
		super.stop();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(rootNode));
		primaryStage.show();
	}
}
