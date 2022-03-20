package br.com.alura.mvc.mudi.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Filme;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	
//	
//	List<Filme> findByGeneroAndSubgeneroAnd(String genero, String subgenero, Sort sort);



//	@Query("select p from Pedido p join p.user u where u.username = :username")
//	List<Pedido> findAllByUsuario(@Param("username")String username);
//
//	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
//	List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);

//	@Query("select f from Filme f where f.genero = :genero and f.subgenero = :subgenero and f.releaseDate BETWEEN :dataInicial AND :dataFinal")
//	List<Filme> buscaPorGeneroSubgeneroEData(@Param("genero")String genero, @Param("subgenero")String subgenero, @Param("dataInicial")LocalDate dataInicial, @Param("dataFinal")LocalDate dataFinal, Sort sort);

}
