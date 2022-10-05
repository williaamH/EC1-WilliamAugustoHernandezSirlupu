package idat.EC1.WilliamAugustoHernandezSirlupu.service;

import java.util.List;

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Universidad;

public interface UniversidadService {

	void guardar(Universidad universidad);
	void actualizar(Universidad universidad);
	void eliminar(Integer id);
	List<Universidad> listar();
	Universidad obtener(Integer id);
}
