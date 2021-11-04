package com.nttdata.controllers;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.nttdata.entities.Car;
import com.nttdata.services.CarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/")
@Stateless
@Api(value = "/", description = "Operations about cars")
public class Controller {
	public static final Logger logger = LogManager.getLogger(Controller.class);

	@Inject
	private CarService carService;
	
	@Path("/cars")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "/cars", httpMethod = "GET", notes = "Get all cars from DB")
	public Response getCars() {
		logger.info("get request");
		return carService.findAllCars();
	}
	
	@Path("/car")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car) {
		return carService.createCar(car);
	}
	
	/*getCar(carId)
	createCar(Car car)
	updateCar(Car car)
	deleteCar(carId)*/
	
	@Path("/cars/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCar(@PathParam(value = "id") Long idCar) {
		return carService.findCar(idCar);
	}
	
	@Path("/car/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCar(Car car) {
		return carService.updateCar(car);
	}
	
	@Path("/car/{id}/delete")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCar(@PathParam(value = "id")Long idCar) {
		return carService.deleteCar(idCar);
	}

}
