package com.application.controllers.editControllers;


import com.application.dao.BirthCertificateDao;
import com.application.date.Date;
import com.application.entities.BirthCertificate;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Контроллер для окна редактирования записей об свидетельстве о рождении
 */

public class EditBirthCertController {

    @FXML
    private TextField id;

    @FXML
    private TextField issuedDate;

    @FXML
    private TextField issuedBy;

    @FXML
    private TextField number;

    @FXML
    private TextField series;

    @FXML
    private Button editButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(addEvent -> {
            BirthCertificateDao birthCertificateDao = new BirthCertificateDao();

            BirthCertificate birthCertificate = birthCertificateDao.findById(Integer.parseInt(id.getText()));
            birthCertificate.setDateIssue(Date.createObjectDate(issuedDate.getText()));
            birthCertificate.setIssuedBy(issuedBy.getText());
            birthCertificate.setNumber(Integer.parseInt(number.getText()));
            birthCertificate.setSeries(Integer.parseInt(series.getText()));

            birthCertificateDao.update(birthCertificate);

            displayTable.showBirthCertificateTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields(){
        id.clear();
        issuedDate.clear();
        issuedBy.clear();
        number.clear();
        series.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
