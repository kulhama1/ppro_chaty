package cz.uhk.fim.kulhama1.skolniprojectchaty.service;

import cz.uhk.fim.kulhama1.skolniprojectchaty.dao.ImageDAO;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("imageService")
public class ImageService {

	@Autowired
	       ImageDAO imageDao;
	
	@Transactional
	public List<Image> getAllImages() {
		return imageDao.getAllImages();
	}

	@Transactional
	public Image getImage(int id) {
		return imageDao.getImage(id);
	}

	@Transactional
	public void addImage(Image image) {
		imageDao.addImage(image);
	}

	@Transactional
	public void updateImage(Image image) {
		imageDao.updateImage(image);

	}

	@Transactional
	public void deleteImage(int id) {
		imageDao.deleteImage(id);
	}
        
        @Transactional
        public Image getImagesById(int id){
                return imageDao.getImagesById(id);
        }
}
