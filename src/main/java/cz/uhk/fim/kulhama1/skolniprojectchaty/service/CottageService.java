package cz.uhk.fim.kulhama1.skolniprojectchaty.service;

import cz.uhk.fim.kulhama1.skolniprojectchaty.dao.CottageDAO;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Cottage;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cottageService")
public class CottageService {

	@Autowired
	       CottageDAO cottageDAO;
	
	@Transactional
	public List<Cottage> getAllCottages() {
		return cottageDAO.getAllCottages();
	}

	@Transactional
	public Cottage getCottage(int id) {
		return cottageDAO.getCottage(id);
	}

	@Transactional
	public void addCottage(Cottage cottage) {
		cottageDAO.addCottage(cottage);
	}

	@Transactional
	public void updateCottage(Cottage cottage) {
		cottageDAO.updateCottage(cottage);

	}

	@Transactional
	public void deleteCottage(int id) {
		cottageDAO.deleteCottage(id);
	}
}

