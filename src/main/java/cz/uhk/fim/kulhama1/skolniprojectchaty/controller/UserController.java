package cz.uhk.fim.kulhama1.skolniprojectchaty.controller;

import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Address;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.User;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.UserAccount;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.AddressService;
import cz.uhk.fim.kulhama1.skolniprojectchaty.service.UserService;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
        @Autowired
	       UserService userService;
        @Autowired
	       AddressService addressService;
        @Autowired
               SmartValidator validator;
        
        private static final org.jboss.logging.Logger logger = LoggerFactory.logger(UserController.class);
        
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllUsers(Model model) {
            List<User> listOfUsers = userService.getAllUsers();
            UserAccount userAccount = new UserAccount(new User(), new Address());
            model.addAttribute("userAccount", userAccount);
            model.addAttribute("listOfUsers", listOfUsers);
            return "/administrace/userDetails";

	}

	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable int id) {
		return userService.getUser(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(Model model, @ModelAttribute("userAccount") UserAccount userAccount, BindingResult result) {
	try {
            Address address = userAccount.getAddress();
            User user = userAccount.getUser();

            /* Sets password only if the two passwords are set */
            if( (!user.getPassword().isEmpty()) && (user.getPassword().equals(userAccount.getPassword_check())) ) {
                /* Create custom password_check error */
                String salt = user.generateHashToken(true);
                user.setSalt(salt);
                String password = user.hashPassword(user.getPassword(), salt);
                user.setPassword(password);
            } else {
                // TODO: Return error
            }
            user.setToken(user.generateHashToken(false));
            
            /* Check for errors in form */
            Boolean addressSave = false;    // Address is not required
            if( (!address.getAddress().isEmpty()) || (!address.getCity().isEmpty()) || (!address.getPostal_code().isEmpty()) ) {
                result.pushNestedPath("address");
                validator.validate(address, result);
                result.popNestedPath();
                addressSave = true;
            } 

            result.pushNestedPath("user");
            validator.validate(user, result);
            result.popNestedPath();
            
            /* Return with errors */
            if(result.hasErrors()) { 
                logger.error(result.getAllErrors());
                model.addAttribute("userAccount", userAccount);
                return "/administrace/userDetails";
            }
            
            /* Saves address and user */
            if(addressSave) { 
                addressService.addAddress(address); 
                user.setId_address(address.getId_address());
            } else {
                user.setId_address(null);
            }
            userService.addUser(user);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "redirect:/getAllUsers";
        }

	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateUser(@PathVariable("id") int id,Model model) {
                       
            User user = userService.getUser(id);
            Address address = addressService.getAddress(user.getId_address());

            UserAccount userAccount = new UserAccount(); // change to use user and address
                userAccount.setUser(user);
                userAccount.setAddress(address);
                
                model.addAttribute("userAccount", userAccount);
                return "/administrace/userDetailsUpdate";
	}
        
        @RequestMapping(value = "/addUpdateUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUpdateUser(Model model, @ModelAttribute("userAccount")UserAccount userAccount, BindingResult result) throws NoSuchAlgorithmException, InvalidKeySpecException {
            
            User user = userAccount.getUser();
            Address address = userAccount.getAddress();
            
            /* Sets password only if the two passwords are set */
            if( (!userAccount.getPassword().isEmpty()) && (userAccount.getPassword().equals(userAccount.getPassword_check())) ) {
                /* Create custom password_check error */
                String salt = user.generateHashToken(true);
                user.setSalt(salt);
                String password = user.hashPassword(userAccount.getPassword(), salt);
                user.setPassword(password);
            }
            
            /* Check for errors in form */
            Boolean addressSave = false;    // Address is not required
            if( (!address.getAddress().isEmpty()) || (!address.getCity().isEmpty()) || (!address.getPostal_code().isEmpty()) ) {
                result.pushNestedPath("address");
                validator.validate(address, result);
                result.popNestedPath();
                addressSave = true;
            } 

            result.pushNestedPath("user");
            validator.validate(user, result);
            result.popNestedPath();
            
            /* Return with errors */
            if(result.hasErrors()) { 
                logger.error(result.getAllErrors());
                model.addAttribute("userAccount", userAccount);
                return "/administrace/userDetailsUpdate";
            }
            
            /* Saves address and user */
           // if(addressSave) { 
           //     addressService.updateAddress(address); 
           // }
            userService.updateUser(user);
            
        return "redirect:/getAllUsers";
    }

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteUser(@PathVariable("id") int id) {               
            
            User user = userService.getUser(id);
            if(user.getId_address() != null) {
                addressService.deleteAddress(user.getId_address());
            }
            userService.deleteUser(id);

        return "redirect:/getAllUsers";
	}
}