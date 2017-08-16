package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Gallery;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.GalleryService;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.ImageService;
import java.beans.PropertyEditorSupport;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
public class GalleryController {
	
	@Autowired
	GalleryService galleryService;
        
        @Autowired       
        ImageService imageService;
        
               List<Image> images;
               Map<String, Image> imageMap;
	
	@RequestMapping(value = "/getAllGalleries", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getGalleries(Model model) {
            
            images = imageService.getImagesByRow("id_gallery", "is", "NULL");
            this.getImagesMap();
		
		List<Gallery> listOfGalleries = galleryService.getAllGalleries();
		model.addAttribute("gallery", new Gallery());
		model.addAttribute("listOfGalleries", listOfGalleries);
                model.addAttribute("images", images);
		return "/administrace/galleryDetails";
	}

	@RequestMapping(value = "/getGallery/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Gallery getGalleryById(Model model, @PathVariable int id) {
                
		return galleryService.getGallery(id);
	}

	@RequestMapping(value = "/addGallery", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addGallery(@ModelAttribute("gallery") Gallery gallery) {	
			galleryService.addGallery(gallery);
		return "redirect:/getAllGalleries";
	}
        
        @RequestMapping(value = "/addUpdateGallery", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUpdateGallery(@ModelAttribute("gallery") Gallery gallery) {
            galleryService.updateGallery(gallery);
            return "redirect:/getAllGalleries";
                
	}
        

	@RequestMapping(value = "/updateGallery/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateGallery(@PathVariable("id") int id, Model model) {
            
                Gallery gallery = galleryService.getGallery(id);
                images = imageService.getImagesByRow("id_gallery", "is", "NULL");
                images.addAll(gallery.getImages());
                this.getImagesMap();
                
                model.addAttribute("gallery", gallery);
                model.addAttribute("images", images);
	        return "/administrace/galleryDetailsUpdate";
           
	}

	@RequestMapping(value = "/deleteGallery/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteGallery(@PathVariable("id") int id) {
		galleryService.deleteGallery(id);
		 return "redirect:/getAllGalleries";

	}
            /* Non-mapping functions */
    private Map<String, Image> getImagesMap() {        
        imageMap = new LinkedHashMap<String, Image>();
        for(Image img : images) {
            imageMap.put((img.getId().toString()), img);
        } 
        return imageMap;
    }
     @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Image.class, "images", new PropertyEditorSupport() {
            @Override
            public void setAsText(String id_images) {
                Image image = imageMap.get(id_images);
                setValue((id_images.equals(""))?null:image);
            }
        });
    }
}