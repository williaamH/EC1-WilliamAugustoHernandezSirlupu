package idat.EC1.WilliamAugustoHernandezSirlupu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Curso;
import idat.EC1.WilliamAugustoHernandezSirlupu.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService {

	@Autowired
	private CursoRepository repositorio;
	
	@Override
	public void guardar(Curso curso) {
		repositorio.save(curso);
	}

	@Override
	public void actualizar(Curso curso) {
		repositorio.saveAndFlush(curso);
	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public List<Curso> listar() {
		return repositorio.findAll();
	}

	@Override
	public Curso obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

}
