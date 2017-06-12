package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Cottage;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Gallery;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Group;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.CottageService;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.GalleryService;
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
        @Autowired
               GalleryService galleryService;
	
	@RequestMapping(value = "/getAllCottages", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getCottages(Model model) {
		
		List<Cottage> listOfCottages = cottageService.getAllCottages();
		model.addAttribute("cottage", new Cottage());
		model.addAttribute("listOfCottages", listOfCottages);
                model.addAttribute("cottageGroups", this.getCottageGroupNames());
                model.addAttribute("cottageGalleries", this.getCottageGalleriesNames());
		return "cottageDetails";
	}

	@RequestMapping(value = "/getCottage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Cottage getCottageById(@PathVariable int id) {
		return cottageService.getCottage(id);
	}

	@RequestMapping(value = "/addCottage", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCottage(@ModelAttribute("cottage") Cottage cottage) {	
                Integer cottageGroupId = cottage.getForm_id_cottage_group();
                Integer cottageGalleryId = cottage.getForm_id_cottage_gallery();
                cottage.setGroup(groupService.getGroupById(cottageGroupId));
                cottage.setGallery(galleryService.getGallery(cottageGalleryId));
            
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
                 Cottage cottage = cottageService.getCottage(id);
		 model.addAttribute("cottage", cottage);
                 
                 if( cottage.getGroup()!= null ) {
                    cottage.setForm_id_cottage_group(cottage.getGroup().getId_group());
            }
                 if( cottage.getGallery()!= null ) {
                    cottage.setForm_id_cottage_gallery(cottage.getGallery().getId_gallery());
            }
                 
                 model.addAttribute("cottageGroups", this.getCottageGroupNames());
                 model.addAttribute("cottageGalleries", this.getCottageGalleriesNames());
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
        private Map<Integer, String> getCottageGalleriesNames() {
        List<Gallery> cottageGalleries = galleryService.getAllGalleries();
        
        Map<Integer, String> cottageGalleryNames = new LinkedHashMap<Integer, String>();
        for(Gallery cottageGallery : cottageGalleries) {
            cottageGalleryNames.put(cottageGallery.getId_gallery(), cottageGallery.getName());
        } 
        return cottageGalleryNames;
    }
}
