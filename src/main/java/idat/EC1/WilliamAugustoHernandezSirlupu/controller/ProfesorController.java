package idat.EC1.WilliamAugustoHernandezSirlupu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Profesor;
import idat.EC1.WilliamAugustoHernandezSirlupu.service.ProfesorService;

@Controller
@RequestMapping("/profesor")
public class ProfesorController {

	@Autowired
	private ProfesorService servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listar(){
		return new ResponseEntity<List<Profesor>>(servicio.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
		servicio.guardar(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtenerPorId(@PathVariable Integer id){
		Profesor profesor = servicio.obtener(id);
		if(profesor != null) {
			return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);
		}else {
			return new ResponseEntity<Profesor>(profesor, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
		Profesor p = servicio.obtener(profesor.getIdProfesor());
		if(p != null) {
			servicio.actualizar(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor profesor = servicio.obtener(id);
		if(profesor != null) {
			servicio.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
