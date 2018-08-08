package br.com.conceptmx.campanhaV2.repository;

import br.com.conceptmx.campanhaV2.model.Campanha;
import br.com.conceptmx.campanhaV2.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.id = :id")
    Cliente getClientePorId(@Param("id") Long id);

    @Query("select c from Cliente c where c.email = :email")
    Cliente getClientePorEmail(@Param("email") String email);

    @Query("select c.campanhas from Cliente c where c.email = :emailCliente")
    List<Campanha> getCampanhasPorCliente(@Param("emailCliente") String emailCliente);

    @Query("select c from Cliente c")
    List<Cliente> getTodosClientes();

    Cliente save(Cliente cliente);

    void deleteById(@Param("id") Long id);
}
