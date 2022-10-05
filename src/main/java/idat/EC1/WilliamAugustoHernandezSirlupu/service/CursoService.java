package idat.EC1.WilliamAugustoHernandezSirlupu.service;

import java.util.List;

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Curso;

public interface CursoService {

	void guardar(Curso curso);
	void actualizar(Curso curso);
	void eliminar(Integer id);
	List<Curso> listar();
	Curso obtener(Integer id);
}
