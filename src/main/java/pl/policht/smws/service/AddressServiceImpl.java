package pl.policht.smws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.policht.smws.entity.Address;
import pl.policht.smws.repository.AddressDao;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressDao dao;
	
	@Override
	public void saveAddress(Address address) {
		dao.saveAddress(address);
	}

	@Override
	public List<Address> findAllAddresses() {
		return dao.findAllAddresses();
	}

}
