package com.application.controllers.windows;

import com.application.controllers.addControllers.*;
import com.application.controllers.delControllers.*;
import com.application.controllers.editControllers.*;
import com.application.tables.DisplayTable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class Windows {

    /**
     * Метод открывает окно добавления студентов
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */

    public static void openAddStudentWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addStudent.fxml"));

        AddStudentController addStudentController = new AddStudentController();
        addStudentController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно добавления родителей
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openAddParentWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addParent.fxml"));

        AddParentsController addParentController = new AddParentsController();
        addParentController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно добавления успеваемости
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openAddPerformanceWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addPerformance.fxml"));

        AddPerformanceController addPerformanceController = new AddPerformanceController();
        addPerformanceController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно добавления посещаемости
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openAddAttendanceWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addAttendance.fxml"));

        AddAttendanceController addAttendanceController = new AddAttendanceController();
        addAttendanceController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно добавления предметов
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openAddSubjectWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addSubject.fxml"));

        AddSubjectController addSubjectController = new AddSubjectController();
        addSubjectController.setDisplayTable(displayTable);

        fxmlLoader.setController(addSubjectController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Добавление предмета");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    /**
     * Метод открывает окно редактирования редактирования записей студентов
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openEditStudentWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editStudent.fxml"));

        EditStudentController editStudentController = new EditStudentController();
        editStudentController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно редактирования записей родителей
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openEditParentWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editParent.fxml"));

        EditParentsController editParentsController = new EditParentsController();
        editParentsController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно редактирования записей посещаемости
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openEditAttendanceWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editAttendance.fxml"));

        EditAttendanceController editAttendanceController = new EditAttendanceController();
        editAttendanceController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно редактирования записей успеваемости
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openEditPerformanceWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editPerformance.fxml"));

        EditPerformanceController editPerformanceController = new EditPerformanceController();
        editPerformanceController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно редактирования записей паспортных данных
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openEditPassportWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editPassportData.fxml"));

        EditPassportDataController editPassportDataController = new EditPassportDataController();
        editPassportDataController.setDisplayTable(displayTable);

        fxmlLoader.setController(editPassportDataController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных паспорта");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    /**
     * Метод открывает окно редактирования записей свидетельства о рождении
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openEditBirthCertWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editBirthCert.fxml"));

        EditBirthCertController editBirthCertController = new  EditBirthCertController();
        editBirthCertController.setDisplayTable(displayTable);

        fxmlLoader.setController(editBirthCertController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных свидетельства о рождении");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    /**
     * Метод открывает окно редактирования записей предметов
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openEditSubjectWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editSubject.fxml"));

        EditSubjectController editSubjectController = new EditSubjectController();
        editSubjectController.setDisplayTable(displayTable);

        fxmlLoader.setController(editSubjectController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Изменение данных о предметах");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();
    }

    /**
     * Метод открывает окно удаления успеваемости
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openDelPerformanceWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delPerformance.fxml"));

        DelPerformanceController delPerformanceController = new DelPerformanceController();
        delPerformanceController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно удаления посещаемости
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openDelAttendanceWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delAttendance.fxml"));

        DelAttendanceController delAttendanceController = new DelAttendanceController();
        delAttendanceController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно удаления стуентов
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openDelStudentWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delStudent.fxml"));

        DelStudentController delStudentController = new DelStudentController();
        delStudentController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно удаления родителей
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openDelParentWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delParent.fxml"));

        DelParentController delParentController = new DelParentController();
        delParentController.setDisplayTable(displayTable);

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

    /**
     * Метод открывает окно удаления предметов
     * @param displayTable - объект класса для отображения таблиц
     * @throws IOException - ошибка ввода и вывода
     */


    public static void openDelSubjectWindow(DisplayTable displayTable) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delSubject.fxml"));

        DelSubjectController delSubjectController = new DelSubjectController();
        delSubjectController.setDisplayTable(displayTable);

        fxmlLoader.setController(delSubjectController);
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setTitle("Удаление записи");
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/images/icon.png"));
        stage.show();


    }



}
