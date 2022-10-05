package idat.EC1.WilliamAugustoHernandezSirlupu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.EC1.WilliamAugustoHernandezSirlupu.model.Universidad;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Integer>{

}
