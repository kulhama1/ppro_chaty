package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Group;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.GroupService;
import java.util.List;
import javax.validation.Valid;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GroupController {
        @Autowired
	       GroupService groupService;
        
        private static final org.jboss.logging.Logger logger = LoggerFactory.logger(GroupController.class);
	
	@RequestMapping(value = "/getAllGroups", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getGroups(Model model) {
		
		List<Group> listOfGroups = groupService.getAllGroups();
		model.addAttribute("group", new Group());
		model.addAttribute("listOfGroups", listOfGroups);
		return "/administrace/groupDetails";
	}

	@RequestMapping(value = "/getGroup/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Group getGroupById(@PathVariable int id) {
		return groupService.getGroup(id);
	}

	@RequestMapping(value = "/addGroup", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addGroup(Model model, @Valid @ModelAttribute("group") Group group, BindingResult result) {	
            if(group.getId_group()==0)
		{
            try {
            /* Return with errors */
            if(result.hasErrors()) { 
                logger.error(result.getAllErrors());   
                List<Group> listOfGroups = groupService.getAllGroups();
        
                model.addAttribute("group", group);
                model.addAttribute("listOfGroups", listOfGroups);
                return "/administrace/groupDetails";
            }
                groupService.addGroup(group);
        } catch(Exception e) {
            e.printStackTrace();
        }
		}
		else
		{	
			groupService.updateGroup(group);
		}
		
		return "redirect:/getAllGroups";
	}

	@RequestMapping(value = "/updateGroup/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateGroup(@PathVariable("id") int id,Model model) {
		model.addAttribute("group", this.groupService.getGroup(id));
	        model.addAttribute("listOfGroups", this.groupService.getAllGroups());
	        return "/administrace/groupDetails";
	}

	@RequestMapping(value = "/deleteGroup/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteGroup(@PathVariable("id") int id) {
		groupService.deleteGroup(id);
		 return "redirect:/getAllGroups";
	}	
}
