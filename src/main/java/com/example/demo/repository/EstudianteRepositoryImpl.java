package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public Estudiante seleccionar(Integer id) { // Buscar por ID
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> seleccionarTodos(String genero) {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :variable ", Estudiante.class);
		myQuery.setParameter("variable", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> seleccionarTodosSinFiltro() {
		Query q = this.entityManager.createQuery("SELECT e FROM Estudiante e");
		return q.getResultList();
	}

}
