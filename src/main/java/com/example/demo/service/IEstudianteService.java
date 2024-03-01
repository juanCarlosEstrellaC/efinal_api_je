package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {

	public void guardar(EstudianteTO estudianteTO);

	public Estudiante buscar(Integer id); // Buscar por ID

	public EstudianteTO buscarTO(Integer id); // Buscar por ID

	public List<EstudianteTO> buscarTodosTO();

	public List<Estudiante> seleccionarTodos(String genero);

}
