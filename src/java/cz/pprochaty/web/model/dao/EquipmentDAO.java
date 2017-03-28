
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Equipment;
import java.util.List;


public interface EquipmentDAO {
    Equipment getEquipmentById(int id);
    void addEquipment(Equipment equipment);
    void deleteEquipment(Equipment equipment);
    void updateEquipment(Equipment equipment_id);
    List<Equipment> getAllEquipments();
}
