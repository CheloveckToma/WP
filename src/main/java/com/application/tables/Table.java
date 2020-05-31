package com.application.tables;

import com.application.dao.*;
import com.application.entities.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;
import java.util.List;


public class Table {

    private TableView<Student> tableView;
    private TableView<Attendance> tableAttendance;
    private TableView<Parent> tableParents;
    private TableView<Performance> tablePerformance;
    private TableView<Subject> tableSubjects;


    public Table(TableView<Student> tableView, TableView<Attendance> tableAttendance, TableView<Parent> tableParents, TableView<Performance> tablePerformance, TableView<Subject> tableSubjects) {
        this.tableView = tableView;
        this.tableAttendance = tableAttendance;
        this.tablePerformance = tablePerformance;
        this.tableParents = tableParents;
        this.tableSubjects = tableSubjects;
    }

    public void showStudentTable() {
        tableView.getColumns().clear();

        offVisibleTables();

        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.findAll();
        tableView.setItems(FXCollections.observableList(students));

        TableColumn<Student, Integer> ID = new TableColumn("ID");
        ID.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn<Student, String> address = new TableColumn("address");
        address.setCellValueFactory(param -> new SimpleObjectProperty<>(
                "г. " + param.getValue().getAddress().getCity() + ", ул. " +
                        param.getValue().getAddress().getStreet() + ", дом " +
                        param.getValue().getAddress().getHouseNumber() + ", кв. " +
                        param.getValue().getAddress().getFlatNumber()
        ));

        TableColumn<Student, String> name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory("studentFullName"));

        TableColumn<Student, String> birthDate = new TableColumn("birth date");
        birthDate.setCellValueFactory(new PropertyValueFactory("birthDate"));

        TableColumn<Student, String> phoneNumber = new TableColumn("phone number");
        phoneNumber.setCellValueFactory(new PropertyValueFactory("phoneNumber"));


        tableView.getColumns().addAll(ID, name, address, birthDate, phoneNumber);
    }

    public void showPassportDataTable() {
        tableView.getColumns().clear();
        offVisibleTables();
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.findAll();
        tableView.setItems(FXCollections.observableList(students));

        TableColumn<Student, Integer> ID = new TableColumn("ID");
        ID.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getId()
        ));

        TableColumn<Student, String> name = new TableColumn("name");
        name.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getStudentFullName()
        ));

        TableColumn<Student, Date> birhtDate = new TableColumn("birht date");
        birhtDate.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getBirthDate()
        ));

        TableColumn<Student, Date> issueDate = new TableColumn("issue date");
        issueDate.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getDateIssue()
        ));

        TableColumn<Student, String> issuedBy = new TableColumn("issued by");
        issuedBy.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getIssuedBy()
        ));

        TableColumn<Student, Integer> departmentCode = new TableColumn("department code");
        departmentCode.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getDepartmentCode()
        ));

        TableColumn<Student, Integer> number = new TableColumn("number");
        number.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getNumber()
        ));

        TableColumn<Student, Integer> series = new TableColumn("series");
        series.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getSeries()
        ));

        TableColumn<Student, String> placeBirth = new TableColumn("place birth");
        placeBirth.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getPlaceBirth()
        ));

        TableColumn<Student, Long> snilsNumber = new TableColumn("snils number");
        snilsNumber.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getSnilsNumber()
        ));

        TableColumn<Student, Long> tin = new TableColumn("tin");
        tin.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getTin()
        ));

        tableView.getColumns().addAll(ID, name, birhtDate, issueDate, issuedBy, departmentCode, number, series, placeBirth, snilsNumber, tin);
    }


    public void showSubjectTable() {
        tableSubjects.getColumns().clear();

        SubjectDao subjectDao = new SubjectDao();

        tableSubjects.setItems(FXCollections.observableList(subjectDao.findAll()));

        TableColumn<Subject, Integer> numberDiscipline = new TableColumn<>("ID");
        numberDiscipline.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Subject, String> nameDiscipline = new TableColumn<>("subject ID");
        nameDiscipline.setCellValueFactory(new PropertyValueFactory<>("subjectName"));

        TableColumn<Subject, String> fullNameTeacher = new TableColumn<>("teacher");
        fullNameTeacher.setCellValueFactory(new PropertyValueFactory<>("teacherName"));

        tableSubjects.getColumns().addAll(numberDiscipline, nameDiscipline, fullNameTeacher);

        tableSubjects.setVisible(true);
    }

    public void showPerformanceTable() {
        tablePerformance.getColumns().clear();

        tablePerformance.getColumns().clear();

        PerformanceDao performanceDao = new PerformanceDao();

        tablePerformance.setItems(FXCollections.observableList(performanceDao.findAll()));

        TableColumn<Performance, Integer> numberPerformance = new TableColumn<>("ID");
        numberPerformance.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Performance, String> fullNameStudent = new TableColumn<>("student");
        fullNameStudent.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getStudent().getStudentFullName()
        ));

        TableColumn<Performance, Integer> mark = new TableColumn<>("mark");
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));

        TableColumn<Performance, String> discipline = new TableColumn<>("subject");
        discipline.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getSubject().getSubjectName()
        ));

        TableColumn<Performance, String> teacher = new TableColumn<>("teacher");
        teacher.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getSubject().getTeacherName()
        ));

        tablePerformance.getColumns().addAll(numberPerformance, fullNameStudent, mark, discipline, teacher);

        offVisibleTables();

        tablePerformance.setVisible(true);
    }

    public void showAttendanceTable() {
        tableAttendance.getColumns().clear();

        tableAttendance.getColumns().clear();

        AttendanceDao attendanceDao = new AttendanceDao();

        tableAttendance.setItems(FXCollections.observableList(attendanceDao.findAll()));

        TableColumn<Attendance, Integer> numberAttendance = new TableColumn<>("ID");
        numberAttendance.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Attendance, String> fullNameStudent = new TableColumn<>("student");
        fullNameStudent.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getStudent().getStudentFullName()
        ));

        TableColumn<Attendance, Integer> numberHours = new TableColumn<>("hours");
        numberHours.setCellValueFactory(new PropertyValueFactory<>("hours"));

        TableColumn<Attendance, Date> date = new TableColumn<>("date");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableAttendance.getColumns().addAll(numberAttendance, fullNameStudent, numberHours, date);

        offVisibleTables();

        tableAttendance.setVisible(true);
    }

    public void showBirthCertificateTable() {
        tableView.getColumns().clear();
        offVisibleTables();
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.findAll();
        tableView.setItems(FXCollections.observableList(students));

        TableColumn<Student, Integer> ID = new TableColumn("ID");
        ID.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getId()
        ));

        TableColumn<Student, String> student = new TableColumn("student");
        student.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getStudent().getStudentFullName()
        ));

        TableColumn<Student, Integer> number = new TableColumn("number");
        number.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getNumber()
        ));

        TableColumn<Student, Integer> series = new TableColumn("series");
        series.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getSeries()
        ));

        TableColumn<Student, String> issuedBy = new TableColumn("issued by");
        issuedBy.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getIssuedBy()
        ));

        TableColumn<Student, Date> dateIssue = new TableColumn("date issue");
        dateIssue.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getDateIssue()
        ));

        tableView.getColumns().addAll(ID, student, number, series, issuedBy, dateIssue);
    }

    public void showParentsTable() {
        tableParents.getColumns().clear();
        tableParents.getColumns().clear();

        ParentDao parentDao = new ParentDao();

        tableParents.setItems(FXCollections.observableList(parentDao.findAll()));

        TableColumn<Parent, Integer> numberParent = new TableColumn<>("ID");
        numberParent.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Parent, String> fullNameStudent = new TableColumn<>("student");
        fullNameStudent.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getStudent().getStudentFullName()
        ));

        TableColumn<Parent, String> fullName = new TableColumn<>("parent");
        fullName.setCellValueFactory(new PropertyValueFactory<>("parentFullName"));

        TableColumn<Parent, String> familyStatus = new TableColumn<>("status");
        familyStatus.setCellValueFactory(new PropertyValueFactory<>("familyStatus"));

        TableColumn<Parent, Integer> numberChildren = new TableColumn<>("children number");
        numberChildren.setCellValueFactory(new PropertyValueFactory<>("numberChildren"));

        TableColumn<Parent, Long> phoneNumber = new TableColumn<>("phone number");
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Parent, String> placeWork = new TableColumn<>("work place");
        placeWork.setCellValueFactory(new PropertyValueFactory<>("placeWork"));

        TableColumn<Parent, String> address = new TableColumn<>("residence address");
        address.setCellValueFactory(param -> new SimpleObjectProperty<>(
                "г. " + param.getValue().getAddress().getCity() + ", ул. " +
                        param.getValue().getAddress().getStreet() + ", дом " +
                        param.getValue().getAddress().getHouseNumber() + ", кв. " +
                        param.getValue().getAddress().getFlatNumber()
        ));

        tableParents.getColumns().addAll(numberParent, fullNameStudent, fullName, familyStatus, numberChildren, phoneNumber, placeWork, address);

        offVisibleTables();

        tableParents.setVisible(true);

    }

    private void offVisibleTables() {
        tablePerformance.setVisible(false);
        tableAttendance.setVisible(false);
        tableParents.setVisible(false);
        tableSubjects.setVisible(false);
    }
}

