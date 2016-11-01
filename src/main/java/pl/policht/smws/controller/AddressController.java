package pl.policht.smws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pl.policht.smws.entity.Address;
import pl.policht.smws.service.AddressService;

@RestController
@RequestMapping("/")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Void> addAddress(@RequestBody Address address, UriComponentsBuilder ucBuilder) {
		Address found = addressService.findAddress(address.getId());
		if (found != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		addressService.saveAddress(address);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/add/{id}").buildAndExpand(address.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/getall", method = RequestMethod.GET)
	public ResponseEntity<List<Address>> getAllAddresses() {
		List<Address> findAllAddresses = addressService.findAllAddresses();
		if (findAllAddresses.isEmpty())
			return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Address>>(findAllAddresses, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddress(@PathVariable("id") int id) {
		Address findAddress = addressService.findAddress(id);
		if (findAddress == null)
			return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Address>(findAddress, HttpStatus.OK);
	}
}
