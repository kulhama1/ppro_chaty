package cz.uhk.fim.kulhama1.skolniprojectchaty.service;

import cz.uhk.fim.kulhama1.skolniprojectchaty.dao.GalleryDAO;
import cz.uhk.fim.kulhama1.skolniprojectchaty.dao.ImageDAO;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Gallery;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("galleryService")
public class GalleryService {

	@Autowired
	       GalleryDAO galleryDAO;
	
	@Transactional
	public List<Gallery> getAllGalleries() {
		return galleryDAO.getAllGalleries();
	}

	@Transactional
	public Gallery getGallery(int id) {
		return galleryDAO.getGallery(id);
	}

	@Transactional
	public void addGallery(Gallery gallery) {
		galleryDAO.addGallery(gallery);
	}

	@Transactional
	public void updateGallery(Gallery gallery) {
		galleryDAO.updateGallery(gallery);

	}

	@Transactional
	public void deleteGallery(int id) {
		galleryDAO.deleteGallery(id);
	}
}
