/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Cottage;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Gallery;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Group;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Image;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.CottageService;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.GroupService;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.ImageService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Hibernate;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class AdminController {
    
    @Autowired
    private CottageService cottageService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private GroupService groupService;
    
     List<Cottage> cottages;
     List<Image> images;
     List<Group> groups;

    private static final org.jboss.logging.Logger logger = LoggerFactory.logger(AdminController.class);
    
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String indexAdministrace(Model model) {
        return "administrace/index";
    }
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model){
        groups = groupService.getAllGroups();
        cottages = cottageService.getAllCottages();
        
         for( Cottage c : cottages ) {
            Hibernate.initialize(c.getGallery());
            Hibernate.initialize(c.getGroup());
             Gallery gal = c.getGallery();
            if( gal != null ) {
                Integer id_thumbnail_gallery = gal.getId_thumbnail_gallery();
                c.setThumbnail(imageService.getImagesById(id_thumbnail_gallery));
            }
        }
        model.addAttribute("groups", groups);
        model.addAttribute("cottages", cottages);
         
        return "index";
    }

    
    @RequestMapping(value = {"/cottages_detail/{id}"}, method = RequestMethod.GET)
    public String cottages_detail(Model model, HttpServletRequest request, @PathVariable("id") int id){
       try{               
            Cottage cottage = cottageService.getCottage(id);
            images = null;
            Image thumbnail = null;
            Gallery gal = cottage.getGallery();
            if(gal != null) { 
                Hibernate.initialize(gal.getImages());
                images = gal.getImages(); 
                thumbnail = imageService.getImage(gal.getId_thumbnail_gallery());
            }
            Group group = cottage.getGroup();
            
            model.addAttribute("group", group);
            model.addAttribute("cottage", cottage);
            model.addAttribute("thumbnail", thumbnail);
            model.addAttribute("images", images);            
            return "chata_detail";
            } catch(Exception e) {
            e.printStackTrace();
        }
       return "redirect:/index";
    }
    
    @RequestMapping(value = {"/kontakt"}, method = RequestMethod.GET)
    public String kontakt(Model model){
        return "kontakt";
    }
    @RequestMapping(value = {"/info"}, method = RequestMethod.GET)
    public String info(Model model){
        return "info";
    }
    @RequestMapping(value = {"/filtr/{id}"}, method = RequestMethod.GET)
    public String filtr(@PathVariable("id") int id,Model model){
        cottages = null;
        groups = groupService.getAllGroups();
        cottages = cottageService.getCottagesByRow("id_group", "is", "NULL");
        
        for( Cottage c : cottages ) {
            Hibernate.initialize(c.getGallery());
            Hibernate.initialize(c.getGroup());
             Gallery gal = c.getGallery();
            if( gal != null ) {
                Integer id_thumbnail_gallery = gal.getId_thumbnail_gallery();
                c.setThumbnail(imageService.getImagesById(id_thumbnail_gallery));
            }
        }

        model.addAttribute("groups", groups);
        model.addAttribute("cottages", cottages);
        return "index";
    }
    
}
