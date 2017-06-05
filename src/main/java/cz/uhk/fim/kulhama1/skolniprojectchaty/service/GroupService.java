package cz.uhk.fim.kulhama1.skolniprojectchaty.service;

import cz.uhk.fim.kulhama1.skolniprojectchaty.dao.GroupDAO;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Group;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("groupService")
public class GroupService {

	@Autowired
	       GroupDAO groupDAO;
	
	@Transactional
	public List<Group> getAllGroups() {
		return groupDAO.getAllGroups();
	}

	@Transactional
	public Group getGroup(int id) {
		return groupDAO.getGroup(id);
	}
        @Transactional
	public Group getGroupById(int id) {
		return groupDAO.getGroupById(id);
	}

	@Transactional
	public void addGroup(Group group) {
		groupDAO.addGroup(group);
	}

	@Transactional
	public void updateGroup(Group group) {
		groupDAO.updateGroup(group);

	}

	@Transactional
	public void deleteGroup(int id) {
		groupDAO.deleteGroup(id);
	}
}
