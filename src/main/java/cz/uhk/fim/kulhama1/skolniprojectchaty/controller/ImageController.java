package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@RequestMapping(value = "/getAllImages", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getImages(Model model) {
		
		List<Image> listOfImages = imageService.getAllImages();
		model.addAttribute("image", new Image());
		model.addAttribute("listOfImages", listOfImages);
		return "imageDetails";
	}

	@RequestMapping(value = "/getImage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Image getImageById(@PathVariable int id) {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/addImage", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addImage(@ModelAttribute("image") Image image) {	
		if(image.getId()==0)
		{
			imageService.addImage(image);
		}
		else
		{	
			imageService.updateImage(image);
		}
		
		return "redirect:/getAllImages";
	}

	@RequestMapping(value = "/updateImage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateImage(@PathVariable("id") int id,Model model) {
		 model.addAttribute("image", this.imageService.getImage(id));
	        model.addAttribute("listOfImages", this.imageService.getAllImages());
	        return "imageDetails";
	}

	@RequestMapping(value = "/deleteImage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteImage(@PathVariable("id") int id) {
		imageService.deleteImage(id);
		 return "redirect:/getAllImages";

	}	
}
