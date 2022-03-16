package psu.edu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

import psu.edu.NetWorker;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        NetWorker NetWorker = new NetWorker();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 600, 300);
        
        Text sceneTitle = new Text("Networking Exercise 1");
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        Label hostnameLabel = new Label("Hostname:");
        grid.add(hostnameLabel, 0, 1);
        TextField hostnameTextField = new TextField();
        grid.add(hostnameTextField, 1, 1);
        
        Label ipLabel = new Label("IP Address:");
        grid.add(ipLabel, 0, 2);
        TextField ipTextField = new TextField();
        grid.add(ipTextField, 1, 2);
        
        final Text actiontarget = new Text("Press enter to submit.");
        grid.add(actiontarget, 1, 6);
        
        
        hostnameTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String response;
                actiontarget.setText("");
                try {
                    String hostname = hostnameTextField.getText().trim();
                    response = NetWorker.get_ip_from_hostname(hostname);
                    
                    if (response != "unknown_host_error") {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("IP Address is: " + response);
                        hostnameTextField.setText("");
                        ipTextField.setText("");
                    } else {
                        actiontarget.setFill(Color.RED);
                        actiontarget.setText("Unknown host exception");
                        hostnameTextField.setText("");
                        ipTextField.setText("");
                    }
                } catch (Exception exception) {}
            }
        });
        
        ipTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String response;
                actiontarget.setText("");
                try {
                    String ip = ipTextField.getText().trim();
                    response = NetWorker.get_hostname_from_ip(ip);
                    
                    if (response != "unknown_host_error") {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("Hostname is: " + response);
                        hostnameTextField.setText("");
                        ipTextField.setText("");
                    } else {
                        actiontarget.setFill(Color.RED);
                        actiontarget.setText("Unknown host exception");
                        hostnameTextField.setText("");
                        ipTextField.setText("");
                    }
                } catch (Exception exception) {}
            }
        });
        
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}