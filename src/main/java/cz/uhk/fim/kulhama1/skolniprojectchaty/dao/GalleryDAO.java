
package cz.uhk.fim.kulhama1.skolniprojectchaty.dao;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Gallery;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GalleryDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public List<Gallery> getAllGalleries() {
        return this.sessionFactory.getCurrentSession().createCriteria(Gallery.class).list();
    }
    
    public Gallery getGallery(int id) {
		 return (Gallery) sessionFactory.getCurrentSession().get(Gallery.class, id);
	}
    public void addGallery(Gallery gallery) {
		this.sessionFactory.getCurrentSession().save(gallery);
	}

    public void updateGallery(Gallery gallery) {
		this.sessionFactory.getCurrentSession().update(gallery);
	}

    
    public void deleteGallery(Integer id) {
		Gallery gallery = (Gallery) sessionFactory.getCurrentSession().load(Gallery.class, id);
                if (null != gallery) {
                    gallery.setImages(null);
                    this.sessionFactory.getCurrentSession().delete(gallery);
                }
	}
    
}
