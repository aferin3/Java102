package com.example;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private static final int TABLE_WIDTH = 800;
    private static final int TABLE_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Verileri oluşturun
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Ahmet", "Yılmaz", "ahmet.yilmaz@gmail.com", "123-456-7890"));
        personList.add(new Person("Ayşe", "Öztürk", "ayse.oztrk@hotmail.com", "987-654-3210"));
        personList.add(new Person("Mehmet", "Çelik", "mehmet.celik@yahoo.com", "456-789-0123"));

        // ObservableList oluşturun
        ObservableList<Person> observablePersonList = FXCollections.observableList(personList);
        
        // Tabloyu oluşturun
        TableView<Person> tableView = new TableView<>(observablePersonList);
        tableView.setPrefSize(TABLE_WIDTH, TABLE_HEIGHT);

        // Sütunları oluşturun
        TableColumn<Person, String> nameCol = new TableColumn<>("Ad");
        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        nameCol.setMinWidth(100);

        TableColumn<Person, String> surnameCol = new TableColumn<>("Soyad");
        surnameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSurname()));
        surnameCol.setMinWidth(100);

        TableColumn<Person, String> emailCol = new TableColumn<>("E-posta");
        emailCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        emailCol.setMinWidth(150);

        TableColumn<Person, String> phoneCol = new TableColumn<>("Telefon Numarası");
        phoneCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNumber()));
        phoneCol.setMinWidth(150);

        tableView.getColumns().addAll(nameCol, surnameCol, emailCol, phoneCol);

        

        // ScrollView oluşturun
        ScrollPane scrollView = new ScrollPane();
        scrollView.setContent(tableView);
        scrollView.setFitToWidth(true);

        // Ana pencereyi oluşturun
        AnchorPane rootPane = new AnchorPane();
        rootPane.getChildren().add(scrollView);

        Scene scene = new Scene(rootPane, TABLE_WIDTH, TABLE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Excel Tarzı Tablo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Person {
        private final String name;
        private final String surname;
        private final String email;
        private final String phoneNumber;

        public Person(String name, String surname, String email, String phoneNumber) {
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}
