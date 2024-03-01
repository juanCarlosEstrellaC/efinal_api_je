package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	private EstudianteTO convertir(Estudiante est) {
		EstudianteTO estuTO = new EstudianteTO();
		estuTO.setId(est.getId());
		estuTO.setNombre(est.getNombre());
		estuTO.setApellido(est.getApellido());
		estuTO.setCedula(est.getCedula());

		return estuTO;
	}

	private Estudiante convertirTOaEstudiante(EstudianteTO estuTO) {
		Estudiante estu = new Estudiante();
		estu.setId(estuTO.getId());
		estu.setNombre(estuTO.getNombre());
		estu.setApellido(estuTO.getApellido());
		estu.setCedula(estuTO.getCedula());

		return estu;
	}

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public void guardar(EstudianteTO estudianteTO) {
		Estudiante e = this.convertirTOaEstudiante(estudianteTO);
		System.out.println(e);
		this.estudianteRepository.insertar(e);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	public List<Estudiante> seleccionarTodos(String Cedula) {
		return this.estudianteRepository.seleccionarTodos(Cedula);
	}

	@Override
	public List<EstudianteTO> buscarTodosTO() {
		// List<Estudiante> lista = this.estudianteRepository.seleccionarTodos("M");

		List<Estudiante> lista = this.estudianteRepository.seleccionarTodosSinFiltro();
		List<EstudianteTO> listaFinal = new ArrayList<>();
		for (Estudiante est : lista) {
			listaFinal.add(this.convertir(est));
		}
		return listaFinal;
	}

	@Override
	public EstudianteTO buscarTO(Integer id) {
		return this.convertir(this.estudianteRepository.seleccionar(id));
	}

}
