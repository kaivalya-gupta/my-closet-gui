# A Simple Clothes App, my-closet-gui

## Description
My Closet GUI is a JavaFX application designed to help visualize and manage your wardrobe. The project was initiated to explore and expand my software development skills by creating a practical but simple solution for organizing clothing items and demonstrate my continuous curiosity and intermediate proficiency in Java. Using IntelliJ encouraged me to explore FXML and handle event handling and GUI design differently.

## Skills Demonstrated
- **Object-Oriented Programming (OOP)**: Understanding of OOP principles, including inheritance, polymorphism, encapsulation, and abstraction.
- **Java Development**: Used core data structures such as arrays and ArrayLists, and comfortable with IntelliJ IDEA for project setup, debugging, and version control integration.
- **GUI Development**: Developed graphical user interfaces using JavaFX and FXML, with hands-on experience in event handling and layout management.
- **Leveraged Coursework**: Applied skills from first-year Java coursework, including OOP, JavaFX, GUI design, event handling, and hierarchy.
- **Continuous Curiosity**: Demonstrating the ability to build upon existing knowledge and tackle new challenges by continuously expanding skills and exploring new frameworks.

## Code 
- [SimpleClothesApp.java](SimpleClothesApp.java): Main application class
  
```java
package com.example.simpleclothesapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SimpleClothesApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SimpleClothesApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 800);
        stage.setTitle("Simple Closet Browser!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```

- [SimpleClothesController.java](SimpleClothesController.java) Application logic, event action class

```java
package com.example.simpleclothesapp;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.ArrayList;

public class SimpleClothesController {
    private final String basePath = "src/main/resources/Clothes/";
    private final String[] categories = {"hat", "top", "bottom", "shoes", "bracelet", "sunglasses"};
    private final ArrayList<Image>[] images = new ArrayList[categories.length];
    private final int[] currentIndex = new int[categories.length];

    @FXML private ImageView hatImageView;
    @FXML private ImageView topImageView;
    @FXML private ImageView bottomImageView;
    @FXML private ImageView shoesImageView;
    @FXML private ImageView braceletImageView;
    @FXML private ImageView sunglassesImageView;

    @FXML
    public void initialize() {
        for (int i = 0; i < categories.length; i++) {
            images[i] = loadImages(categories[i]);
            currentIndex[i] = 0;
        }
        updateImageViews();
    }

    private ArrayList<Image> loadImages(String category) {
        ArrayList<Image> imageList = new ArrayList<>();
        File dir = new File(basePath + category);
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".png"))) {
                    System.out.println("Loading image: " + file.toURI().toString());
                    imageList.add(new Image(file.toURI().toString()));
                }
            }
        }
        return imageList;
    }

    private void updateImageViews() {
        if (!images[0].isEmpty()) hatImageView.setImage(images[0].get(currentIndex[0]));
        if (!images[1].isEmpty()) topImageView.setImage(images[1].get(currentIndex[1]));
        if (!images[2].isEmpty()) bottomImageView.setImage(images[2].get(currentIndex[2]));
        if (!images[3].isEmpty()) shoesImageView.setImage(images[3].get(currentIndex[3]));
        if (!images[4].isEmpty()) braceletImageView.setImage(images[4].get(currentIndex[4]));
        if (!images[5].isEmpty()) sunglassesImageView.setImage(images[5].get(currentIndex[5]));
    }

    @FXML
    protected void onNextHatClick() {
        currentIndex[0] = (currentIndex[0] + 1) % images[0].size();
        hatImageView.setImage(images[0].get(currentIndex[0]));
    }

    @FXML
    protected void onNextTopClick() {
        currentIndex[1] = (currentIndex[1] + 1) % images[1].size();
        topImageView.setImage(images[1].get(currentIndex[1]));
    }

    @FXML
    protected void onNextBottomClick() {
        currentIndex[2] = (currentIndex[2] + 1) % images[2].size();
        bottomImageView.setImage(images[2].get(currentIndex[2]));
    }

    @FXML
    protected void onNextShoesClick() {
        currentIndex[3] = (currentIndex[3] + 1) % images[3].size();
        shoesImageView.setImage(images[3].get(currentIndex[3]));
    }

    @FXML
    protected void onNextBraceletClick() {
        currentIndex[4] = (currentIndex[4] + 1) % images[4].size();
        braceletImageView.setImage(images[4].get(currentIndex[4]));
    }

    @FXML
    protected void onNextSunglassesClick() {
        currentIndex[5] = (currentIndex[5] + 1) % images[5].size();
        sunglassesImageView.setImage(images[5].get(currentIndex[5]));
    }
}
```

- [hello-view.fxml](hello-view.fxml): FXML UI layout

```java
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.Insets?>
<?import javafx.scene.control.Button?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.GridPane?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.control.Label?>

<GridPane alignment="CENTER" hgap="10" vgap="10" xmlns:fx="http://javafx.com/fxml" xmlns="http://javafx.com/javafx"
          fx:controller="com.example.simpleclothesapp.SimpleClothesController">

    <padding>
        <Insets top="20" right="20" bottom="20" left="20"/>
    </padding>

    <!--hat-->
    <VBox alignment="CENTER" GridPane.rowIndex="0" GridPane.columnIndex="0">
        <ImageView fx:id="hatImageView" fitWidth="200" fitHeight="200" preserveRatio="true"/>
        <Button text="Different Hat" onAction="#onNextHatClick" />
    </VBox>

    <!--sunglasses-->
    <VBox alignment="CENTER" GridPane.rowIndex="0" GridPane.columnIndex="1">
        <ImageView fx:id="sunglassesImageView" fitWidth="200" fitHeight="200" preserveRatio="true"/>
        <Button text="Different Sunglasses" onAction="#onNextSunglassesClick" />
    </VBox>

    <!--top-->
    <VBox alignment="CENTER" GridPane.rowIndex="1" GridPane.columnIndex="0">
        <ImageView fx:id="topImageView" fitWidth="200" fitHeight="200" preserveRatio="true"/>
        <Button text="Different Top" onAction="#onNextTopClick" />
    </VBox>

    <!--bracelet-->
    <VBox alignment="CENTER" GridPane.rowIndex="1" GridPane.columnIndex="1">
        <ImageView fx:id="braceletImageView" fitWidth="200" fitHeight="200" preserveRatio="true"/>
        <Button text="Different Bracelet" onAction="#onNextBraceletClick" />
    </VBox>

    <!--bottom-->
    <VBox alignment="CENTER" GridPane.rowIndex="2" GridPane.columnIndex="0">
        <ImageView fx:id="bottomImageView" fitWidth="200" fitHeight="200" preserveRatio="true"/>
        <Button text="Different Bottom" onAction="#onNextBottomClick" />
    </VBox>

    <!--shoes-->
    <VBox alignment="CENTER" GridPane.rowIndex="3" GridPane.columnIndex="0">
        <ImageView fx:id="shoesImageView" fitWidth="200" fitHeight="200" preserveRatio="true"/>
        <Button text="Different Shoes" onAction="#onNextShoesClick" />
    </VBox>
</GridPane>
```

- [pom.xml](pom.xml): Maven configuration

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>SimpleClothesApp</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>SimpleClothesApp</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.9.2</junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>21-ea+24</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>21-ea+24</version>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <executions>
                    <execution>
                        <!-- Default configuration for running with: mvn clean javafx:run -->
                        <id>default-cli</id>
                        <configuration>
                            <mainClass>com.example.simpleclothesapp/com.example.simpleclothesapp.SimpleClothesApp
                            </mainClass>
                            <launcher>app</launcher>
                            <jlinkZipName>app</jlinkZipName>
                            <jlinkImageName>app</jlinkImageName>
                            <noManPages>true</noManPages>
                            <stripDebug>true</stripDebug>
                            <noHeaderFiles>true</noHeaderFiles>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```
