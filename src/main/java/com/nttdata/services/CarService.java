package com.nttdata.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.nttdata.entities.Car;
import com.nttdata.repo.CarRepository;

@ApplicationScoped
public class CarService {
	
	@Inject
	private CarRepository carRepository;
	
	public Response findAllCars(){
		List<Car> cars = carRepository.findAll();
		if(cars.isEmpty()) {
			return Response.status(200, "no car found").build();
		}
		return Response.ok(cars).build();
	}
	
	public Response createCar(Car car) {
		car = carRepository.create(car);
		return Response.ok(car).build();
	}
	
	public Response findCar(Long id) {
		Car car = carRepository.findOne(id);
		if(car == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(car).build();
	}
	
	public Response updateCar(Car car) {
		car = carRepository.update(car);
		return Response.ok(car).build();
	}
	
	public Response deleteCar(Long id) {
		Car car = carRepository.findOne(id);
		if(car == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		carRepository.delete(car);
		return Response.status(Response.Status.ACCEPTED).build();
	}
}
