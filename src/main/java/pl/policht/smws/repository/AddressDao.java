package pl.policht.smws.repository;

import java.util.List;

import pl.policht.smws.entity.Address;

public interface AddressDao {
	void saveAddress(Address address);
	List<Address> findAllAddresses();
	Address findAddress(int id);
}
