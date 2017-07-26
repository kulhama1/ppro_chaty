/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Martin
 */
@Controller
public class AdminController {
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }
}
