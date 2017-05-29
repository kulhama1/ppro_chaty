package cz.uhk.fim.kulhama1.skolniprojectchaty.dao;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    public List<Image> getAllImages() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Image> imageList = session.createQuery("from Image").list();
        return imageList;
    }
    
    public Image getImage(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Image image = (Image) session.get(Image.class, new Integer(id));
		return image;
	}
    public Image addImage(Image image) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(image);
		return image;
	}

    public void updateImage(Image image) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(image);
	}

    
    public void deleteImage(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Image i = (Image) session.load(Image.class, new Integer(id));
		if (null != i) {
			session.delete(i);
		}
	}
    
}
