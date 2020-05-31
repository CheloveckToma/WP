package com.application.controllers;


import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import com.application.tables.TableСondition;

import com.application.controllers.windows.Windows;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import com.application.entities.*;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Контроллер главного окна
 */

public class MainWindowController {

    @FXML
    private HBox studentsButton;

    @FXML
    private HBox passportDataButton;

    @FXML
    private HBox performanceButton;

    @FXML
    private HBox attendanceButton;

    @FXML
    private HBox birthCertificateButton;

    @FXML
    private HBox parentsButton;

    @FXML
    private TableView<Student> displayTable;

    @FXML
    private TableView<Attendance> tableAttendance;

    @FXML
    private TableView<com.application.entities.Parent> tableParents;

    @FXML
    private TableView<Performance> tablePerformance;

    @FXML
    private TableView<Subject> tableSubjects;

    @FXML
    private ImageView addButton;

    @FXML
    private ImageView delButton;

    @FXML
    private ImageView subjectButton;

    @FXML
    private ImageView editButton;
    private TableСondition tableСondition;
    private DisplayTable tableDisplay;

    @FXML
    void initialize() {
        HibernateUtil.buildSessionFactory();

        tableСondition = TableСondition.NOTHING;

        tableDisplay = new DisplayTable(displayTable, tableAttendance, tableParents, tablePerformance, tableSubjects, tableСondition);

        EventHandler<MouseEvent> openStudentTableEvent = e -> {
            tableDisplay.showStudentTable();
            showNoteEditButtons();
            offSubButton();
        };

        EventHandler<MouseEvent> openPassportTableEvent = e -> {
            tableDisplay.showPassportDataTable();
            hideNoteEditButtons();
            onEditButton();
            offSubButton();

        };

        EventHandler<MouseEvent> openPerformanceTableEvent = e -> {
            tableDisplay.showPerformanceTable();
            showNoteEditButtons();
            onSubButton();
        };

        EventHandler<MouseEvent> openAttendanceTableEvent = e -> {
            tableDisplay.showAttendanceTable();
            showNoteEditButtons();
            offSubButton();
        };

        EventHandler<MouseEvent> openBirthCertificateTableEvent = e -> {
            tableDisplay.showBirthCertificateTable();
            hideNoteEditButtons();
            onEditButton();
            offSubButton();
        };

        EventHandler<MouseEvent> openParentsTableEvent = e -> {
            tableDisplay.showParentsTable();
            showNoteEditButtons();
            offSubButton();
        };

        EventHandler<MouseEvent> openSubjectTableEvent = e -> {
            tableDisplay.showSubjectTable();
            offSubButton();
        };

        EventHandler<MouseEvent> addNoteEvent = e -> {
            try {
                switch (tableСondition) {
                    case NOTHING:
                        break;
                    case PARENTS:
                        Windows.openAddParentWindow(tableDisplay);
                        break;
                    case STUDENT:
                        Windows.openAddStudentWindow(tableDisplay);
                        break;
                    case PASSPORT:
                        break;
                    case ATTENDANCE:
                        Windows.openAddAttendanceWindow(tableDisplay);
                        break;
                    case PERFORMANCE:
                        Windows.openAddPerformanceWindow(tableDisplay);
                        break;
                    case BIRTH_CERTIFICATE:
                        break;
                    case SUBJECT:
                        Windows.openAddSubjectWindow(tableDisplay);
                        break;
                }
            } catch (IOException b) {
                b.printStackTrace();
            }
        };

        EventHandler<MouseEvent> delNoteEvent = e -> {
            try {
                switch (tableСondition) {
                    case NOTHING:
                        break;
                    case PARENTS:
                        Windows.openDelParentWindow(tableDisplay);
                        break;
                    case STUDENT:
                        Windows.openDelStudentWindow(tableDisplay);
                        break;
                    case PASSPORT:
                        break;
                    case ATTENDANCE:
                        Windows.openDelAttendanceWindow(tableDisplay);
                        break;
                    case PERFORMANCE:
                        Windows.openDelPerformanceWindow(tableDisplay);
                        break;
                    case BIRTH_CERTIFICATE:
                        break;
                    case SUBJECT:
                        Windows.openDelSubjectWindow(tableDisplay);
                        break;
                }

            } catch (IOException b) {
                b.printStackTrace();
            }
        };

        EventHandler<MouseEvent> editNoteEvent = e -> {
            try {
                switch (tableСondition) {
                    case NOTHING:
                        break;
                    case PARENTS:
                        Windows.openEditParentWindow(tableDisplay);
                        break;
                    case STUDENT:
                        Windows.openEditStudentWindow(tableDisplay);
                        break;
                    case PASSPORT:
                        Windows.openEditPassportWindow(tableDisplay);
                        break;
                    case ATTENDANCE:
                        Windows.openEditAttendanceWindow(tableDisplay);
                        break;
                    case PERFORMANCE:
                        Windows.openEditPerformanceWindow(tableDisplay);
                        break;
                    case BIRTH_CERTIFICATE:
                        Windows.openEditBirthCertWindow(tableDisplay);
                        break;
                    case SUBJECT:
                        E:
                        Windows.openEditSubjectWindow(tableDisplay);
                        break;
                }

            } catch (IOException b) {
                b.printStackTrace();
            }
        };

        studentsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openStudentTableEvent);
        passportDataButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openPassportTableEvent);
        performanceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openPerformanceTableEvent);
        attendanceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openAttendanceTableEvent);
        birthCertificateButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openBirthCertificateTableEvent);
        parentsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openParentsTableEvent);

        addButton.addEventFilter(MouseEvent.MOUSE_CLICKED, addNoteEvent);
        delButton.addEventFilter(MouseEvent.MOUSE_CLICKED, delNoteEvent);
        editButton.addEventFilter(MouseEvent.MOUSE_CLICKED, editNoteEvent);
        subjectButton.addEventFilter(MouseEvent.MOUSE_CLICKED, openSubjectTableEvent);

    }

    /**
     * Метод невидмириует кнопки
     */

    private void hideNoteEditButtons() {
        addButton.setVisible(false);
        delButton.setVisible(false);
        editButton.setVisible(false);
    }

    /**
     * Метод включает отображение кнопок
     */

    private void showNoteEditButtons() {
        addButton.setVisible(true);
        delButton.setVisible(true);
        editButton.setVisible(true);
    }

    /**
     * Метод выключает оторажение кнопки вызова отображения таблицы предметов
     */

    private void offSubButton() {
        subjectButton.setVisible(false);
    }

    /**
     * Метод включает оторажение кнопки вызова отображения таблицы предметов
     */

    private void onSubButton() {
        subjectButton.setVisible(true);
    }

    /**
     * Метод включает оторажение кнопки вызова отображения таблицы предметов
     */

    private void onEditButton() {
        editButton.setVisible(true);
    }
}
