/* Тестовый клас который в последствии следует удалить
* новый класс ApparatusDAO
*  */

package ua.lis.mvc4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lis.mvc4.models.OldApparatusModel;

@Component
public class WordDAO {

    OldApparatusModel oldApparatusModel;

    @Autowired
    public WordDAO(OldApparatusModel oldApparatusModel) {
        this.oldApparatusModel = oldApparatusModel;
    }

    public String getSentence(){
        return oldApparatusModel.getSentence();
    }
}
