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

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Universidad;
import idat.EC1.WilliamAugustoHernandezSirlupu.service.UniversidadService;

@Controller
@RequestMapping("/universidad")
public class UniversidadController {
	
	@Autowired
	private UniversidadService servicio;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listar(){
		return new ResponseEntity<List<Universidad>>(servicio.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad){
		servicio.guardar(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Universidad> obtenerPorId(@PathVariable Integer id){
		Universidad universidad = servicio.obtener(id);
		if(universidad != null) {
			return new ResponseEntity<Universidad>(universidad, HttpStatus.OK);
		}else {
			return new ResponseEntity<Universidad>(universidad, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Universidad universidad){
		Universidad u = servicio.obtener(universidad.getIdUniversidad());
		if(u != null) {
			servicio.actualizar(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Universidad universidad = servicio.obtener(id);
		if(universidad != null) {
			servicio.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
