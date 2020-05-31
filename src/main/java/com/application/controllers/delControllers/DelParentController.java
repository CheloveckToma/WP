package com.application.controllers.delControllers;


import com.application.dao.ParentDao;
import com.application.dao.StudentDao;
import com.application.entities.Parent;
import com.application.entities.Student;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DelParentController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;

    private Table table;

    @FXML
    void initialize() {

        delButton.setOnAction(addEvent -> {
            ParentDao parentDao = new ParentDao();
            Parent parent = parentDao.findById(Integer.parseInt(id.getText()));
            parentDao.delete(parent);

            table.showParentsTable();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
