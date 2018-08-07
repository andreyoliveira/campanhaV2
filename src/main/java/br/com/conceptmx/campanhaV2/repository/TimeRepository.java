package br.com.conceptmx.campanhaV2.repository;

import br.com.conceptmx.campanhaV2.model.Time;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "time", path = "times")
public interface TimeRepository extends PagingAndSortingRepository<Time, Long> {

    @ApiOperation(value = "Buscar Time por id", response = Time.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um Time válido", response = Time.class)
    })
    @Query("select t from Time t where t.id = :id")
    Time getTimePorId(@Param("id") Long id);

    @ApiOperation(value = "Buscar todos os Times", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de Times", response = List.class)
    })
    @Query("select t from Time t")
    List<Time> getTodosTimes();

    @ApiOperation(value = "Buscar Time por nome", response = Time.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um Time válido", response = Time.class)
    })
    @Query("select t from Time t where t.nome = :nome")
    List<Time> getPorNome(@Param("nome") String nome);

    @ApiOperation(value = "Salvar um Time", response = Time.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Salva um Time e retorna o Time salvo", response = Time.class)
    })
    Time save(Time time);

    @ApiOperation(value = "Excluir Time por id", response = Time.class)
    void deleteById(@Param("id") Long id);

}
