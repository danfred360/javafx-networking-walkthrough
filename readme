# Networking Example 1
This project is intended to walk somebody through Exercise 1 in our Networking assignment. I sort of do things the hard way, but you'll get an understanding of what Netbeans is doing for you so you can seperate crappy Netbeans stuff from Java.

*Note: If you just copy my code the Professor will be able to tell. This project is intended to get you to a starting point for more complex projects.*

# Before you start
## Programs you need
- Integrated Development Environment (IDE) - [Visual Studio Code](https://code.visualstudio.com/download) is fast and easy to use. It comes with Git integration and support for a variety of different terminals and development workflows. You can customize VS Code with different plugins to add language specific linting (code correction) and support for language specific development requirements by installing extensions through the embedded extension browser.
- Java Development Kit (JDK) - Make sure [Java](https://www.oracle.com/java/technologies/downloads/) is installed and configured correctly in your `PATH`.
- [Maven](https://maven.apache.org/install.html) is a project managment tool that can manage a project's build, reporting and documentation based on the contents of the project object model outlined `pom.xml`.
- You will also need a terminal. You have a lot of options here. I mainly use [Windows Subsystem for Linux](https://docs.microsoft.com/en-us/windows/wsl/install) (WSL) which, put simply, let's you use a Linux terminal in a Windows environment. That's not necessary for this project; you can get by with Command prompt or Powershell.

**Make sure Java and Maven are both in your PATH**
Run `java --version` and `mvn --version` to confirm.

[Stack Overflow thread: How to add Maven to the Path variable?](https://stackoverflow.com/questions/45119595/how-to-add-maven-to-the-path-variable)

# Initializing project

Open your terminal and `cd` into the directory where you want your project directory to live.

Run this command to generate a project folder `[-DartifactId]` in you current working directory.

```bash
mvn archetype:generate \
    -DarchetypeGroupId=org.openjfx \
    -DarchetypeArtifactId=javafx-archetype-simple \
    -DarchetypeVersion=0.0.3 \
    -DgroupId=psu.edu \
    -DartifactId=netEx1 \
    -Dversion=1.0.0 \
    -Djavafx-version=17.0.1
```

This generates a project from a template that OpenJFX provides to get started.

Run `code .` to open VS Code in your current working directory to look at what you generated.

Run `mvn clean javafx:run` from inside your project directory to run the project and be greeted by the sample Hello World program. (You may need to us `cd` in the terminal to change directory.)

The `mvn archetype:generate` command is similar to what Netbeans does when you start a project. It generates all the files you need in the correct structure, so it saves you a lot of headaches.

**Note:**It's best to make sure your project runs at this point, that way you have a baseline for when you start adding your own code that could have errors.

# Adding NetWorker class
Create a file called `NetWorker.java` in the same directory as `App.java` with the following contents:

```java
package psu.edu;

import java.net.InetAddress;

public class NetWorker {
    public NetWorker() {
        // constructor
    }

    public static String get_ip_from_hostname(String hostname) {
        // method that takes in a hostname (string) and returns and ip address (string)
    }

    public static String get_hostname_from_ip(String hostname) {
        // method that takes in a hostname (string) and returns and ip address (string)
    }
}
```

Here we're creating a class that will do internet related work for our program. Encapsulation is one of the Object Oriented Programming concepts that we learn about in class; basically we can create classes that combine the data we need with the methods we use to obtain the data. This makes not only makes your program easier to read and debugg, but allows you to keep your programs `dry`. (*Don't repeat yourself.*)

Next we'll add the logic to our get methods.

```java
public static String get_ip_from_hostname(String hostname) {
        try {
            InetAddress address = InetAddress.getByName(hostname);
            return(address.getHostAddress());
        } catch (Exception unknown_host_error) {
            
            return("unknown_host_error");
        }
    }

public static String get_hostname_from_ip(String ip) {
    try {
        InetAddress address = InetAddress.getByName(ip);
        return(address.getHostName());
    }
    catch (Exception unknown_host_error) {
        return("unknown_host_error");
    }
}
```

**Add tests**

# Modifying App class
The `App.java` class that Maven initialized for you should look like this:

```java
package psu.edu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
```

We're going to modify that to look like this: 

```java
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
```

Here's a quick breakdown of we're doing here:
1. Initializing `GridPane` to organize our gui and apply some styling.
2. Initializing the `Scene` that will hold our grid. Tis is what's rendered on the JavaFX "stage" when we're ready to run.
3. Next we're add a `Text` title to our scene and position it on the grid.
4. After the title we can add the `Label` and the `TextField` for the user to enter a hostname or ip address. 
5. Next we'll add a `Text` action target that we'll update with the results of whichever method the user ends up requesting.
6. Now we add an `EventHandler` for when the user pushes enter for each field. This ask the networker to convert the input and reflect the response on our action target. We also clear the fields so the user can use the program again without closing it.
7. Finally, we set the stage with our scene, and show our stage. These are methods that we can use because our App inherits methods from JavaFX's `Application` class.
8. Our main method will launch the application.

It's not pretty, but it'll do.

# Run your application
If you did everything right you should be able to run `mvn clean javafx:run` from the root of your project directory (where your POM is) to run the project.

For more info on how to use the Maven cli tool click [here](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).