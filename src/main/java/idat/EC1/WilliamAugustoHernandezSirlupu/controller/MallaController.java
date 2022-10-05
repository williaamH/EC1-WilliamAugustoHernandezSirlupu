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

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Malla;
import idat.EC1.WilliamAugustoHernandezSirlupu.service.MallaService;

@Controller
@RequestMapping("/malla")
public class MallaController {

	@Autowired
	private MallaService servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Malla>> listar(){
		return new ResponseEntity<List<Malla>>(servicio.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Malla malla){
		servicio.guardar(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Malla> obtenerPorId(@PathVariable Integer id){
		Malla malla = servicio.obtener(id);
		if(malla != null) {
			return new ResponseEntity<Malla>(malla, HttpStatus.OK);
		}else {
			return new ResponseEntity<Malla>(malla, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Malla malla){
		Malla m = servicio.obtener(malla.getIdMalla());
		if(m != null) {
			servicio.actualizar(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Malla malla = servicio.obtener(id);
		if(malla != null) {
			servicio.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
