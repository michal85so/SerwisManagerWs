package pl.policht.smws.service;

import java.util.List;

import pl.policht.smws.entity.Address;

public interface AddressService {
	void saveAddress(Address address);
	List<Address> findAllAddresses();
}
