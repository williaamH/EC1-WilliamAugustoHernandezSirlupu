package idat.EC1.WilliamAugustoHernandezSirlupu.service;

import java.util.List;

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Profesor;;

public interface ProfesorService {

	void guardar(Profesor profesor);
	void actualizar(Profesor profesor);
	void eliminar(Integer id);
	List<Profesor> listar();
	Profesor obtener(Integer id);
}
