package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Cottage;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Group;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.ImageService;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
@Controller
public class ImageController {
	
	@Autowired
	ImageService imageService;
        ImageIcon i;
        
        private static final org.jboss.logging.Logger logger = LoggerFactory.logger(ImageController.class);
        
    public ImageController() {
        
    }
       
	@RequestMapping(value = "/getAllImages", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getImages(Model model) {
		
		List<Image> listOfImages = imageService.getAllImages();
		model.addAttribute("image", new Image());
		model.addAttribute("listOfImages", listOfImages);
		return "/administrace/imageDetails";
	}

	@RequestMapping(value = "/getImage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Image getImageById(@PathVariable int id) {
            return imageService.getImage(id);
                
	}
        @RequestMapping(value = "/addUpdateImage", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUpdateImage(@ModelAttribute("image") Image image) {
            imageService.updateImage(image);
            return "redirect:/getAllImages";
                
	}

	@RequestMapping(value = "/addImage", method = RequestMethod.POST, headers = "Accept=application/json")
	public String add_image(Model model, @Valid @RequestParam("file") MultipartFile file, @ModelAttribute("image")Image image, HttpServletRequest request, BindingResult result) throws IOException {
			i = new ImageIcon(file.getOriginalFilename());
        ServletContext context = request.getServletContext();
        String rootPath = "C:\\server/";
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Create the file on server
                File serverFile = new File(rootPath+ "uploads/" +i);
                System.out.println(rootPath);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                
                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());
                // tvoreni miniatury
                ImageIcon ii = new ImageIcon(rootPath+ "uploads/" +i);
                double deleni;
                double height = ii.getIconHeight();
                double width = ii.getIconWidth();
                
                deleni = width/250;
                
                height = (height / deleni);
                width = (width/deleni);
                
                BufferedImage bi = new BufferedImage((int)width, (int)height, BufferedImage.TYPE_INT_RGB);
                        Graphics2D g2d = (Graphics2D)bi.createGraphics();
                        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                                RenderingHints.VALUE_RENDER_QUALITY));
                        boolean b = g2d.drawImage(ii.getImage(), 0, 0, (int)width, (int)height, null);
                        System.out.println(b);
                        ImageIO.write(bi, "jpg", new File(rootPath+ "uploads/thumbnail/"+i));
                       
                
                       
            } catch (Exception e) {
               e.printStackTrace();
            }
            
        } 
        else {
            return "You failed to upload "
                    + " because the file was empty.";
        }
        image.setImage_src(rootPath + "uploads/" +i);
        image.setThumbnail_src(rootPath + "uploads/thumbnail/" +i);
        imageService.addImage(image);
		
		
		return "redirect:/getAllImages";
    }
        
        @RequestMapping(value = "/updateImage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateImage(@PathVariable("id") int id, Model model) {
                model.addAttribute("image", this.imageService.getImage(id));
                return "/administrace/imageDetailsUpdate";
	}

	@RequestMapping(value = "/deleteImage/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String delete_image(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        
        ServletContext context = request.getServletContext();
        String rootPath = "C:\\server/";
            
        Image image = imageService.getImagesById(id);
        image.getImage_src();
        File file = new File(rootPath + image.getThumbnail_src());
        file.delete();
        File file1 = new File(rootPath + image.getImage_src());
        file1.delete();
        
        imageService.deleteImage(id);
        return "redirect:/getAllImages";
    }	
}
