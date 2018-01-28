package com.bharath.passengerservice.metier;

import java.util.ArrayList;
import java.util.List;

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
	public Passenger getPassgner(Passenger passenger) {
		passenger.setId(currentId++);
		passengers.add(passenger);
		return passenger;
	}

}
