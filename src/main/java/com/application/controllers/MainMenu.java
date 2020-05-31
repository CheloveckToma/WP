package com.application.controllers;


import com.application.main.HibernateUtil;
import com.application.tables.TableСondition;

import com.application.controllers.windows.Windows;
import com.application.tables.Table;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import com.application.entities.*;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;


public class MainMenu {

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
    private TableView<Student> table;

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
    private ImageView subButton;

    @FXML
    private ImageView editButton;
    private TableСondition tableСondition;
    private Table displayTable;

    @FXML
    void initialize() {
        HibernateUtil.buildSessionFactory();

        tableСondition = TableСondition.NOTHING;

        displayTable = new Table(table, tableAttendance, tableParents, tablePerformance, tableSubjects);


        EventHandler<MouseEvent> openStudentTableEvent = e -> {
            tableСondition = TableСondition.STUDENT;
            displayTable.showStudentTable();
            showNoteEditButtons();
            subButton.setVisible(false);
        };

        EventHandler<MouseEvent> openPassportTableEvent = e -> {
            tableСondition = TableСondition.PASSPORT;
            displayTable.showPassportDataTable();
            hideNoteEditButtons();
            editButton.setVisible(true);
            subButton.setVisible(false);

        };

        EventHandler<MouseEvent> opentPerformanceTableEvent = e -> {
            tableСondition = TableСondition.PERFORMANCE;
            displayTable.showPerformanceTable();
            showNoteEditButtons();
            subButton.setVisible(true);
        };

        EventHandler<MouseEvent> openAttendanceTableEvent = e -> {
            tableСondition = TableСondition.ATTENDANCE;
            displayTable.showAttendanceTable();
            showNoteEditButtons();
            subButton.setVisible(false);
        };

        EventHandler<MouseEvent> openBirthCertificateTableEvent = e -> {
            tableСondition = TableСondition.BIRTH_CERTIFICATE;
            displayTable.showBirthCertificateTable();
            hideNoteEditButtons();
            editButton.setVisible(true);
            subButton.setVisible(false);
        };

        EventHandler<MouseEvent> openParentsTableEvent = e -> {
            tableСondition = TableСondition.PARENTS;
            displayTable.showParentsTable();
            showNoteEditButtons();
            subButton.setVisible(false);
        };

        EventHandler<MouseEvent> openSubjectTableEvent = e -> {
            tableСondition = TableСondition.SUBJECT;
            displayTable.showSubjectTable();
            subButton.setVisible(false);
        };

        EventHandler<MouseEvent> addNoteEvent = e -> {
            try {
                switch (tableСondition) {
                    case NOTHING:
                        break;
                    case PARENTS:
                        Windows.openAddParentWindow(displayTable);
                        break;
                    case STUDENT:
                        Windows.openAddStudentWindow(displayTable);
                        break;
                    case PASSPORT:
                        break;
                    case ATTENDANCE:
                        Windows.openAddAttendanceWindow(displayTable);
                        break;
                    case PERFORMANCE:
                        Windows.openAddPerformanceWindow(displayTable);
                        break;
                    case BIRTH_CERTIFICATE:
                        break;
                    case SUBJECT:
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
                        Windows.openDelParentWindow(displayTable);
                        break;
                    case STUDENT:
                        Windows.openDelStudentWindow(displayTable);
                        break;
                    case PASSPORT:
                        break;
                    case ATTENDANCE:
                        Windows.openDelAttendanceWindow(displayTable);
                        break;
                    case PERFORMANCE:
                        Windows.openDelPerformanceWindow(displayTable);
                        break;
                    case BIRTH_CERTIFICATE:
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
                        Windows.openEditParentWindow(displayTable);
                        break;
                    case STUDENT:
                        Windows.openEditStudentWindow(displayTable);
                        break;
                    case PASSPORT:
                        Windows.openEditPassportWindow(displayTable);
                        break;
                    case ATTENDANCE:
                        Windows.openEditAttendanceWindow(displayTable);
                        break;
                    case PERFORMANCE:
                        Windows.openEditPerformanceWindow(displayTable);
                        break;
                    case BIRTH_CERTIFICATE:
                        Windows.openEditBirthCertWindow(displayTable);
                        break;
                }

            } catch (IOException b) {
                b.printStackTrace();
            }
        };

        studentsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openStudentTableEvent);
        passportDataButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openPassportTableEvent);
        performanceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, opentPerformanceTableEvent);
        attendanceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openAttendanceTableEvent);
        birthCertificateButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openBirthCertificateTableEvent);
        parentsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, openParentsTableEvent);

        addButton.addEventFilter(MouseEvent.MOUSE_CLICKED, addNoteEvent);
        delButton.addEventFilter(MouseEvent.MOUSE_CLICKED, delNoteEvent);
        editButton.addEventFilter(MouseEvent.MOUSE_CLICKED, editNoteEvent);
        subButton.addEventFilter(MouseEvent.MOUSE_CLICKED, openSubjectTableEvent);

    }

    private void hideNoteEditButtons() {
        addButton.setVisible(false);
        delButton.setVisible(false);
        editButton.setVisible(false);
    }

    private void showNoteEditButtons() {
        addButton.setVisible(true);
        delButton.setVisible(true);
        editButton.setVisible(true);
    }
}
