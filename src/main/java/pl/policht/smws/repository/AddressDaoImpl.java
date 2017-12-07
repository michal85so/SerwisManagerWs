package pl.policht.smws.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.policht.smws.entity.Address;

@Repository("addressDao")
public class AddressDaoImpl extends AbstractDao implements AddressDao{

	@Override
	public void saveAddress(Address address) {
		save(address);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> findAllAddresses() {
		Criteria criteria = getSession().createCriteria(Address.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public Address findAddress(int id) {
		Criteria criteria = getSession().createCriteria(Address.class);
		List<Address> list = criteria.add(Restrictions.idEq(id)).list();
		return list.isEmpty() ? null : list.get(0);
	}

}
