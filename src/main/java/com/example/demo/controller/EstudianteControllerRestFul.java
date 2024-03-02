package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IEstudianteService;
import com.example.demo.service.to.EstudianteTO;

@CrossOrigin
@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// http://localhost:8089/API/v1.0/Inscripcion/estudiantes/{id} GET
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<EstudianteTO> consultar(@PathVariable Integer id) {
		EstudianteTO estu = this.estudianteService.buscarTO(id);
		Link link2 = linkTo(methodOn(EstudianteControllerRestFul.class).consultar(estu.getId())).withSelfRel();
		estu.add(link2);
		return ResponseEntity.status(HttpStatus.OK).body(estu);
	}

	// http://localhost:8089/API/v1.0/Inscripcion/estudiantes GET
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> consultarTodosHATEOAS() {
		List<EstudianteTO> lista = this.estudianteService.buscarTodosTO();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	// http://localhost:8089/API/v1.0/Inscripcion/estudiantes POST
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardar(@RequestBody EstudianteTO estudianteTO) {
		this.estudianteService.guardar(estudianteTO);
	}

}
