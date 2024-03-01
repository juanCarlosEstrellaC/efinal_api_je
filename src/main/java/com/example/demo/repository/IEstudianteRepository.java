package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertar(Estudiante estudiante);

	public Estudiante seleccionar(Integer id); // Buscar por ID

	public List<Estudiante> seleccionarTodos(String genero);

	public List<Estudiante> seleccionarTodosSinFiltro();

}
