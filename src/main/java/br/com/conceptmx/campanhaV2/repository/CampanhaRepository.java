package br.com.conceptmx.campanhaV2.repository;

import br.com.conceptmx.campanhaV2.model.Campanha;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "campanha", path = "campanhas")
public interface CampanhaRepository extends PagingAndSortingRepository<Campanha, Long> {

    @Query("select c from Campanha c where c.id = :id")
    Campanha getCampanhaPorId(@Param("id") Long id);

    @Query("select c from Campanha c")
    List<Campanha> getTodasCampanhas();

    Campanha save(Campanha campanha);

    void deleteById(@Param("id") Long id);

}
