
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Gallery;
import cz.pprochaty.web.model.Image;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ImageDaoImplement implements ImageDAO{

    SessionFactory sessionFactory;
    
    @Override
    public Image getImageById(int id) {
        return (Image) sessionFactory.getCurrentSession().get(Image.class, id);
    }

    @Override
    public void addImage(Image image) {
        this.sessionFactory.getCurrentSession().save(image);
    }

    @Override
    public void updateImage(Image image) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(image);
    }

    @Override
    public void deleteImage(Integer image_id) {
       Image image = (Image) sessionFactory.getCurrentSession().load(Image.class, image_id);
       if(null != image){
           this.sessionFactory.getCurrentSession().delete(image);
       }
    }

    @Override
    public List<Image> getAllImages() {
        return this.sessionFactory.getCurrentSession().createCriteria(Image.class).list();
    }

    @Override
    public List<Image> getImagesByRow(String row, String operand, String stringArray) {
        return this.sessionFactory.getCurrentSession().createCriteria(Image.class).add(Restrictions.sqlRestriction(row + " " + operand + " " + stringArray)).list();
    }

    @Override
    public void updateMultipleImage(List<Image> images) {
        try {
            for(Image image : images) { 
                this.sessionFactory.getCurrentSession().update(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
