package com.bharath.passengerservice.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Service;

import com.bharath.passengerservice.model.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {

	List<Passenger> passengers = new ArrayList<>();
	private int currentId = 123;
	
	@Override
	public List<Passenger> getPassengers(int start, int size) {
		System.out.println("start = " + start);
		System.out.println("size = " + size);
		return passengers;
	}

	@Override
	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(agent);
		
		// retrieve headers
		MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		Set<String> headerKeys = allHeaders.keySet();
		headerKeys.forEach(k -> {
			System.out.println("key = " + k);
			System.out.println(headers.getHeaderString(k));
		});
		
		// recuperando las cookies, las cuales vienen en el header
		System.out.println("----------------------- Cookies ---------------------------------");
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookiesKeys = cookies.keySet();
		cookiesKeys.forEach(ck -> {
			System.out.println("cookis key = " + ck);
			System.out.println("cookie = " + cookies.get(ck).getValue());
		});
	}

}
