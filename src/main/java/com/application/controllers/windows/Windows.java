package com.application.controllers.windows;

import com.application.controllers.addControllers.AddAttendanceController;
import com.application.controllers.addControllers.AddParentsController;
import com.application.controllers.addControllers.AddPerformanceController;
import com.application.controllers.addControllers.AddStudentController;
import com.application.controllers.delControllers.DelAttendanceController;
import com.application.controllers.delControllers.DelParentController;
import com.application.controllers.delControllers.DelPerformanceController;
import com.application.controllers.delControllers.DelStudentController;
import com.application.controllers.editControllers.EditAttendanceController;
import com.application.controllers.editControllers.EditParentsController;
import com.application.controllers.editControllers.EditPerformanceController;
import com.application.controllers.editControllers.EditStudentController;
import com.application.tables.Table;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Windows {

    public static void openAddStudentWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addStudent.fxml"));

        AddStudentController addStudentController = new AddStudentController();
        addStudentController.setTable(table);

        fxmlLoader.setController(addStudentController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Добавление студента");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void openAddParentWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addParent.fxml"));

        AddParentsController addParentController = new AddParentsController();
        addParentController.setTable(table);

        fxmlLoader.setController(addParentController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Добавление родителя");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void openAddPerformanceWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addPerformance.fxml"));

        AddPerformanceController addPerformanceController = new AddPerformanceController();
        addPerformanceController.setTable(table);

        fxmlLoader.setController(addPerformanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Добавление успеваемости");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }


    public static void openAddAttendanceWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addAttendance.fxml"));

        AddAttendanceController addAttendanceController = new AddAttendanceController();
        addAttendanceController.setTable(table);

        fxmlLoader.setController(addAttendanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Добавление посещаемости");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void openEditStudentWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editStudent.fxml"));

        EditStudentController editStudentController = new EditStudentController();
        editStudentController.setTable(table);

        fxmlLoader.setController(editStudentController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных студента");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void openEditParentWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editParent.fxml"));

        EditParentsController editParentsController = new EditParentsController();
        editParentsController.setTable(table);

        fxmlLoader.setController(editParentsController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных родителя");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void openEditAttendanceWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editAttendance.fxml"));

        EditAttendanceController editAttendanceController = new EditAttendanceController();
        editAttendanceController.setTable(table);

        fxmlLoader.setController(editAttendanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных посещаемости");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void openEditPerformanceWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editPerformance.fxml"));

        EditPerformanceController editPerformanceController = new EditPerformanceController();
        editPerformanceController.setTable(table);

        fxmlLoader.setController(editPerformanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных успеваемости");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }


    public static void openDelPerformanceWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delPerformance.fxml"));

        DelPerformanceController delPerformanceController = new DelPerformanceController();
        delPerformanceController.setTable(table);

        fxmlLoader.setController(delPerformanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Удаление записи");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    public static void openDelAttendanceWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delAttendance.fxml"));

        DelAttendanceController delAttendanceController = new DelAttendanceController();
        delAttendanceController.setTable(table);

        fxmlLoader.setController(delAttendanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Удаление записи");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();


    }

    public static void openDelStudentWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delStudent.fxml"));

        DelStudentController delStudentController = new DelStudentController();
        delStudentController.setTable(table);

        fxmlLoader.setController(delStudentController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Удаление записи");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();


    }
    public static void openDelParentWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delParent.fxml"));

        DelParentController delParentController = new DelParentController();
        delParentController.setTable(table);

        fxmlLoader.setController(delParentController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Удаление записи");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();


    }

    public static void openEditPassportWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editPassportData.fxml"));

        EditPerformanceController editPerformanceController = new EditPerformanceController();
        editPerformanceController.setTable(table);

        fxmlLoader.setController(editPerformanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных паспорта");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }
    public static void openEditBirthCertWindow(Table table) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editBirthCert.fxml"));

        EditPerformanceController editPerformanceController = new EditPerformanceController();
        editPerformanceController.setTable(table);

        fxmlLoader.setController(editPerformanceController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных свидетельства о рождении");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

}
