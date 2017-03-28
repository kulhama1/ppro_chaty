
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Equipment;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class EquipmentDaoImplement implements EquipmentDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Equipment getEquipmentById(int id) {
        return (Equipment) sessionFactory.getCurrentSession().load(Equipment.class, id);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.sessionFactory.getCurrentSession().save(equipment);
    }

    @Override
    public void deleteEquipment(Equipment equipment_id) {
        Equipment equipment = (Equipment)sessionFactory.getCurrentSession().load(Equipment.class, equipment_id);
        if(null != equipment){
            this.sessionFactory.getCurrentSession().delete(equipment);
        }
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        this.sessionFactory.getCurrentSession().update(equipment);
    }

    @Override
    public List<Equipment> getAllEquipments() {
        return this.sessionFactory.getCurrentSession().createCriteria(Equipment.class).list();
    }
    
}
