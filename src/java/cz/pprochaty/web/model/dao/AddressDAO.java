package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.Address;

public interface AddressDAO {
    Address getAddressById(int id);
    void addAddress(Address address);
    void updateAddress(Address address);
    void deleteAddress(Integer address_id);
}
