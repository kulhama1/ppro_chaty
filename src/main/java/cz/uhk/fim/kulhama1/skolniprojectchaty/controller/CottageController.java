package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Cottage;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Group;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.CottageService;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.GroupService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CottageController {
	
	@Autowired
	       CottageService cottageService;
        @Autowired
               GroupService groupService;
	
	@RequestMapping(value = "/getAllCottages", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCottages(Model model) {
		
		List<Cottage> listOfCottages = cottageService.getAllCottages();
		model.addAttribute("cottage", new Cottage());
		model.addAttribute("listOfCottages", listOfCottages);
                model.addAttribute("cottageGroups", this.getCottageGroupNames());
		return "cottageDetails";
	}

	@RequestMapping(value = "/getCottage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Cottage getCottageById(@PathVariable int id) {
		return cottageService.getCottage(id);
	}

	@RequestMapping(value = "/addCottage", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCottage(@ModelAttribute("cottage") Cottage cottage) {	
                Integer cottageGroupId = cottage.getForm_id_cottage_group();
                cottage.setGroup(groupService.getGroupById(cottageGroupId) );
            
		if(cottage.getId_cottage()==0)
		{
			cottageService.addCottage(cottage);
		}
		else
		{	
			cottageService.updateCottage(cottage);
		}
		
		return "redirect:/getAllCottages";
	}

	@RequestMapping(value = "/updateCottage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCottage(@PathVariable("id") int id,Model model) {
		 model.addAttribute("cottage", this.cottageService.getCottage(id));
	         model.addAttribute("listOfCottages", this.cottageService.getAllCottages());
	         return "cottageDetails";
	}

	@RequestMapping(value = "/deleteCottage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCottage(@PathVariable("id") int id) {
		cottageService.deleteCottage(id);
		 return "redirect:/getAllCottages";

	}	
        private Map<Integer, String> getCottageGroupNames() {
        List<Group> cottageGroups = groupService.getAllGroups();
        
        Map<Integer, String> cottageGroupNames = new LinkedHashMap<Integer, String>();
        for(Group cottageGroup : cottageGroups) {
            cottageGroupNames.put(cottageGroup.getId_group(), cottageGroup.getName());
        } 
        return cottageGroupNames;
    }
}
