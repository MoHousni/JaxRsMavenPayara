package com.nttdata.repo;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nttdata.entities.Car;

@ApplicationScoped
public class CarRepository {

	@PersistenceContext(name = "EjbProjet")
	private EntityManager entityManager;
	
	public List<Car> findAll(){
		return entityManager.createQuery("select c from Car c").getResultList();
	}
	
	public Car create(Car car) {
		entityManager.persist(car);
		return car;
	}
	
	public Car findOne(Long id) {
		return entityManager.find(Car.class, id);
	}
	
	public Car update(Car car) {
		entityManager.merge(car);
		return car;
	}
	
	public void delete(Car car) {
		entityManager.remove(car);
	}
}
