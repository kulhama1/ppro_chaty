package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Gallery;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.GalleryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {
	
	@Autowired
	       GalleryService galleryService;
	
	@RequestMapping(value = "/getAllGalleries", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getGalleries(Model model) {
		
		List<Gallery> listOfGalleries = galleryService.getAllGalleries();
		model.addAttribute("gallery", new Gallery());
		model.addAttribute("listOfGalleries", listOfGalleries);
		return "galleryDetails";
	}

	@RequestMapping(value = "/getGallery/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Gallery getGalleryById(@PathVariable int id) {
		return galleryService.getGallery(id);
	}

	@RequestMapping(value = "/addGallery", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addGallery(@ModelAttribute("gallery") Gallery gallery) {	
		if(gallery.getId_gallery()==0)
		{
			galleryService.addGallery(gallery);
		}
		else
		{	
			galleryService.updateGallery(gallery);
		}
		
		return "redirect:/getAllGalleries";
	}

	@RequestMapping(value = "/updateGallery/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateGallery(@PathVariable("id") int id,Model model) {
		 model.addAttribute("gallery", this.galleryService.getGallery(id));
	        model.addAttribute("listOfGalleries", this.galleryService.getAllGalleries());
	        return "galleryDetails";
	}

	@RequestMapping(value = "/deleteGallery/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteGallery(@PathVariable("id") int id) {
		galleryService.deleteGallery(id);
		 return "redirect:/getAllGalleries";

	}	
}