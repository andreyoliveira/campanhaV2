package br.com.conceptmx.campanhaV2.repository;

import br.com.conceptmx.campanhaV2.model.Time;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "time", path = "times")
public interface TimeRepository extends PagingAndSortingRepository<Time, Long> {

    @Query("select t from Time t where t.id = :id")
    Time getTimePorId(@Param("id") Long id);

    @Query("select t from Time t")
    List<Time> getTodosTimes();

    @Query("select t from Time t where t.nome like :nome")
    List<Time> getPorNome(@Param("nome") String nome);

    Time save(Time time);

    void deleteById(@Param("id") Long id);

}
