
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Cottage;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CottageDaoimplement implements CottageDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCottage(Cottage cottage) {
        this.sessionFactory.getCurrentSession().save(cottage);
    }

    @Override
    public void deleteCottage(Integer cottage_id) {
        Cottage cottage = (Cottage) sessionFactory.getCurrentSession().load(Cottage.class, cottage_id);
        if(null != cottage){
            this.sessionFactory.getCurrentSession().delete(cottage);
        }
    }

    @Override
    public void updateCottage(Cottage cottage) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(cottage);
    }
    @Override
    public Cottage getCottageById(int id) {
        return (Cottage) sessionFactory.getCurrentSession().get(Cottage.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cottage> getAllCottages() {
        return this.sessionFactory.getCurrentSession().createCriteria(Cottage.class).list();
    }
    
}
