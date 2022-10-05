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

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Curso;
import idat.EC1.WilliamAugustoHernandezSirlupu.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listar(){
		return new ResponseEntity<List<Curso>>(servicio.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Curso curso){
		servicio.guardar(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id){
		Curso curso = servicio.obtener(id);
		if(curso != null) {
			return new ResponseEntity<Curso>(curso, HttpStatus.OK);
		}else {
			return new ResponseEntity<Curso>(curso, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Curso curso){
		Curso c = servicio.obtener(curso.getIdCurso());
		if(c != null) {
			servicio.actualizar(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Curso curso = servicio.obtener(id);
		if(curso != null) {
			servicio.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
}
