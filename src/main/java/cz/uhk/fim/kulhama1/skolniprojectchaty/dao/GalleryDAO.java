
package cz.uhk.fim.kulhama1.skolniprojectchaty.dao;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Gallery;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
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
        Session session = this.sessionFactory.getCurrentSession();
        List<Gallery> galleryList = session.createQuery("from Gallery").list();
        return galleryList;
    }
    
    public Gallery getGallery(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Gallery gallery = (Gallery) session.get(Gallery.class, new Integer(id));
		return gallery;
	}
    public Gallery addGallery(Gallery gallery) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(gallery);
		return gallery;
	}

    public void updateGallery(Gallery gallery) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(gallery);
	}

    
    public void deleteGallery(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Gallery g = (Gallery) session.load(Gallery.class, new Integer(id));
		if (null != g) {
			session.delete(g);
		}
	}
    
}
