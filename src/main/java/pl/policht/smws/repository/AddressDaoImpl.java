package pl.policht.smws.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import pl.policht.smws.entity.Address;

@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao implements AddressDao{

	@Override
	public void saveAddress(Address address) {
		persist(address);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAllAddresses() {
		Criteria criteria = getSession().createCriteria(Address.class);
		return criteria.list();
	}

}
