package idat.EC1.WilliamAugustoHernandezSirlupu.service;

import java.util.List;

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Malla;

public interface MallaService {

	void guardar(Malla malla);
	void actualizar(Malla malla);
	void eliminar(Integer id);
	List<Malla> listar();
	Malla obtener(Integer id);
}
