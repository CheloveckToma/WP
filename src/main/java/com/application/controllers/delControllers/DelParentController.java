package com.application.controllers.delControllers;


import com.application.dao.ParentDao;;
import com.application.entities.Parent;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *  Контроллер для окна удаления записей о родителях
 */

public class DelParentController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        delButton.setOnAction(addEvent -> {
            ParentDao parentDao = new ParentDao();
            Parent parent = parentDao.findById(Integer.parseInt(id.getText()));
            parentDao.delete(parent);

            displayTable.showParentsTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields(){
        id.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
