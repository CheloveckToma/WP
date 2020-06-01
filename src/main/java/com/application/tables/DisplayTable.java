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

/**
 * Класс, отображающий таблицы
 */

public class DisplayTable {

    private TableView<Student> tableStudent;
    private TableView<Attendance> tableAttendance;
    private TableView<Parent> tableParents;
    private TableView<Performance> tablePerformance;
    private TableView<Subject> tableSubjects;
    private TableСondition tableСondition;


    public DisplayTable(TableView<Student> tableStudent, TableView<Attendance> tableAttendance, TableView<Parent> tableParents, TableView<Performance> tablePerformance, TableView<Subject> tableSubjects, TableСondition tableСondition) {
        this.tableStudent = tableStudent;
        this.tableAttendance = tableAttendance;
        this.tablePerformance = tablePerformance;
        this.tableParents = tableParents;
        this.tableSubjects = tableSubjects;
        this.tableСondition = tableСondition;
    }

    /**
     * Метод отображает таблицу студентов
     */

    public void showStudentTable() {
        tableStudent.getColumns().clear();

        tableСondition = TableСondition.STUDENT;

        StudentDao studentDao = new StudentDao();

        List<Student> students = studentDao.findAll();

        tableStudent.setItems(FXCollections.observableList(students));

        TableColumn<Student, Integer> ID = new TableColumn("ID");

        ID.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn<Student, String> address = new TableColumn("Адрес");
        address.setCellValueFactory(param -> new SimpleObjectProperty<>(
                "г. " + param.getValue().getAddress().getCity() + ", ул. " +
                        param.getValue().getAddress().getStreet() + ", дом " +
                        param.getValue().getAddress().getHouseNumber() + ", кв. " +
                        param.getValue().getAddress().getFlatNumber()
        ));

        TableColumn<Student, String> name = new TableColumn("Имя");
        name.setCellValueFactory(new PropertyValueFactory("studentFullName"));

        TableColumn<Student, String> birthDate = new TableColumn("Дата рождения");
        birthDate.setCellValueFactory(new PropertyValueFactory("birthDate"));

        TableColumn<Student, String> phoneNumber = new TableColumn("Номер телефона");
        phoneNumber.setCellValueFactory(new PropertyValueFactory("phoneNumber"));

        offVisibleTables();

        tableStudent.getColumns().addAll(ID, name, address, birthDate, phoneNumber);
    }

    /**
     * Метод отображает таблицу паспортных данных
     */

    public void showPassportDataTable() {
        tableStudent.getColumns().clear();

        tableСondition = TableСondition.PASSPORT;

        StudentDao studentDao = new StudentDao();

        List<Student> students = studentDao.findAll();

        tableStudent.setItems(FXCollections.observableList(students));

        TableColumn<Student, Integer> ID = new TableColumn("ID");
        ID.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getId()
        ));

        TableColumn<Student, String> name = new TableColumn("Имя");
        name.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getStudentFullName()
        ));

        TableColumn<Student, Date> birhtDate = new TableColumn("Дата рождения");
        birhtDate.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getBirthDate()
        ));

        TableColumn<Student, Date> issueDate = new TableColumn("Дата выдачи");
        issueDate.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getDateIssue()
        ));

        TableColumn<Student, String> issuedBy = new TableColumn("Кем выдан");
        issuedBy.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getIssuedBy()
        ));

        TableColumn<Student, Integer> departmentCode = new TableColumn("Код департамента");
        departmentCode.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getDepartmentCode()
        ));

        TableColumn<Student, Integer> number = new TableColumn("Номер");
        number.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getNumber()
        ));

        TableColumn<Student, Integer> series = new TableColumn("Серия");
        series.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getSeries()
        ));

        TableColumn<Student, String> placeBirth = new TableColumn("Место рождения");
        placeBirth.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getPlaceBirth()
        ));

        TableColumn<Student, Long> snilsNumber = new TableColumn("Номер СНИЛС");
        snilsNumber.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getSnilsNumber()
        ));

        TableColumn<Student, Long> tin = new TableColumn("ИНН");
        tin.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getPassportData().getTin()
        ));

        offVisibleTables();

        tableStudent.getColumns().addAll(ID, name, birhtDate, issueDate, issuedBy, departmentCode, number, series, placeBirth, snilsNumber, tin);
    }

    /**
     * Метод отображает таблицу предметов
     */

    public void showSubjectTable() {
        tableSubjects.getColumns().clear();

        tableСondition = TableСondition.PARENTS;

        SubjectDao subjectDao = new SubjectDao();

        tableSubjects.setItems(FXCollections.observableList(subjectDao.findAll()));

        TableColumn<Subject, Integer> numberDiscipline = new TableColumn<>("ID");
        numberDiscipline.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Subject, String> nameDiscipline = new TableColumn<>("ID предмета");
        nameDiscipline.setCellValueFactory(new PropertyValueFactory<>("subjectName"));

        TableColumn<Subject, String> fullNameTeacher = new TableColumn<>("Учитель");
        fullNameTeacher.setCellValueFactory(new PropertyValueFactory<>("teacherName"));

        tableSubjects.getColumns().addAll(numberDiscipline, nameDiscipline, fullNameTeacher);

        tableSubjects.setVisible(true);
    }

    /**
     * Метод отображает таблицу успеваемости
     */

    public void showPerformanceTable() {
        tablePerformance.getColumns().clear();

        tableСondition = TableСondition.PERFORMANCE;

        PerformanceDao performanceDao = new PerformanceDao();

        tablePerformance.setItems(FXCollections.observableList(performanceDao.findAll()));

        TableColumn<Performance, Integer> numberPerformance = new TableColumn<>("ID");
        numberPerformance.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Performance, String> fullNameStudent = new TableColumn<>("Студент");
        fullNameStudent.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getStudent().getStudentFullName()
        ));

        TableColumn<Performance, Integer> mark = new TableColumn<>("Оценка");
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));

        TableColumn<Performance, String> discipline = new TableColumn<>("Предмет");
        discipline.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getSubject().getSubjectName()
        ));

        TableColumn<Performance, String> teacher = new TableColumn<>("Учитель");
        teacher.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getSubject().getTeacherName()
        ));

        tablePerformance.getColumns().addAll(numberPerformance, fullNameStudent, mark, discipline, teacher);

        offVisibleTables();

        tablePerformance.setVisible(true);
    }

    /**
     * Метод отображает таблицу посещаемости
     */

    public void showAttendanceTable() {
        tableAttendance.getColumns().clear();

        tableСondition = TableСondition.ATTENDANCE;

        AttendanceDao attendanceDao = new AttendanceDao();

        tableAttendance.setItems(FXCollections.observableList(attendanceDao.findAll()));

        TableColumn<Attendance, Integer> numberAttendance = new TableColumn<>("ID");
        numberAttendance.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Attendance, String> fullNameStudent = new TableColumn<>("Студент");
        fullNameStudent.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getStudent().getStudentFullName()
        ));

        TableColumn<Attendance, Integer> numberHours = new TableColumn<>("Часы отсутствия");
        numberHours.setCellValueFactory(new PropertyValueFactory<>("hours"));

        TableColumn<Attendance, Date> date = new TableColumn<>("Дата посещения");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableAttendance.getColumns().addAll(numberAttendance, fullNameStudent, numberHours, date);

        offVisibleTables();

        tableAttendance.setVisible(true);
    }

    /**
     * Метод отображает таблицу свидетельства о рождении
     */

    public void showBirthCertificateTable() {
        tableStudent.getColumns().clear();

        tableСondition = TableСondition.BIRTH_CERTIFICATE;

        StudentDao studentDao = new StudentDao();

        List<Student> students = studentDao.findAll();

        tableStudent.setItems(FXCollections.observableList(students));

        TableColumn<Student, Integer> ID = new TableColumn("ID");
        ID.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getId()
        ));

        TableColumn<Student, String> student = new TableColumn("Студент");
        student.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getStudent().getStudentFullName()
        ));

        TableColumn<Student, Integer> number = new TableColumn("Номер");
        number.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getNumber()
        ));

        TableColumn<Student, Integer> series = new TableColumn("Серия");
        series.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getSeries()
        ));

        TableColumn<Student, String> issuedBy = new TableColumn("Кем выдан");
        issuedBy.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getIssuedBy()
        ));

        TableColumn<Student, Date> dateIssue = new TableColumn("Дата выдачи");
        dateIssue.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getBirthCertificate().getDateIssue()
        ));

        offVisibleTables();

        tableStudent.getColumns().addAll(ID, student, number, series, issuedBy, dateIssue);
    }

    /**
     * Метод отображает таблицу родителей
     */

    public void showParentsTable() {
        tableParents.getColumns().clear();

        tableСondition = TableСondition.PARENTS;

        ParentDao parentDao = new ParentDao();

        tableParents.setItems(FXCollections.observableList(parentDao.findAll()));

        TableColumn<Parent, Integer> numberParent = new TableColumn<>("ID");
        numberParent.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Parent, String> fullNameStudent = new TableColumn<>("Студент");
        fullNameStudent.setCellValueFactory(param -> new SimpleObjectProperty<>(
                param.getValue().getStudent().getStudentFullName()
        ));

        TableColumn<Parent, String> fullName = new TableColumn<>("Родитель");
        fullName.setCellValueFactory(new PropertyValueFactory<>("parentFullName"));

        TableColumn<Parent, String> familyStatus = new TableColumn<>("Статус");
        familyStatus.setCellValueFactory(new PropertyValueFactory<>("familyStatus"));

        TableColumn<Parent, Integer> numberChildren = new TableColumn<>("Кол-во детей");
        numberChildren.setCellValueFactory(new PropertyValueFactory<>("numberChildren"));

        TableColumn<Parent, Long> phoneNumber = new TableColumn<>("Номер телефона");
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Parent, String> placeWork = new TableColumn<>("Место работы");
        placeWork.setCellValueFactory(new PropertyValueFactory<>("placeWork"));

        TableColumn<Parent, String> address = new TableColumn<>("Место прописки");
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

    public TableСondition getTableСondition() {
        return tableСondition;
    }
}

