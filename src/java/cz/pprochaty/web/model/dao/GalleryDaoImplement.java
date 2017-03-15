package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Gallery;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public class GalleryDaoImplement implements GalleryDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Gallery getGalleryById(int id) {
        return (Gallery) this.sessionFactory.getCurrentSession().get(Gallery.class, id);
    }

    @Override
    public void addGallery(Gallery gallery) {
        this.sessionFactory.getCurrentSession().save(gallery);
    }

    @Override
    public void updateGallery(Gallery gallery) {
        this.sessionFactory.getCurrentSession().update(gallery);
    }

    @Override
    public void deleteGallery(Integer gallery_id) {
        Gallery gallery = (Gallery) this.sessionFactory.getCurrentSession().load(Gallery.class, gallery_id);
        if(null != gallery){
            gallery.setImages(null);
            this.sessionFactory.getCurrentSession().delete(gallery);
        }
    }

    @Override
    public List<Gallery> getAllGalleries() {
        return this.sessionFactory.getCurrentSession().createCriteria(Gallery.class).list();
    }
    
}
