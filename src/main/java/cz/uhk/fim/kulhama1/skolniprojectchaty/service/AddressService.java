/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.uhk.fim.kulhama1.skolniprojectchaty.service;

import cz.uhk.fim.kulhama1.skolniprojectchaty.dao.AddressDAO;
import cz.uhk.fim.kulhama1.skolniprojectchaty.model.Address;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("addressService")
public class AddressService {

	@Autowired
	       AddressDAO addressDAO;
	
	@Transactional
	public List<Address> getAllAddresses() {
		return addressDAO.getAllAddresses();
	}

	@Transactional
	public Address getAddress(int id) {
		return addressDAO.getAddress(id);
	}

	@Transactional
	public void addAddress(Address address) {
		addressDAO.addAddress(address);
	}

	@Transactional
	public void updateAddress(Address address) {
		addressDAO.updateAddress(address);

	}

	@Transactional
	public void deleteAddress(int id) {
		addressDAO.deleteAddress(id);
	}
}