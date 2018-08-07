package br.com.conceptmx.campanhaV2.repository;

import br.com.conceptmx.campanhaV2.model.Campanha;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "campanha", path = "campanhas")
public interface CampanhaRepository extends PagingAndSortingRepository<Campanha, Long> {

    @ApiOperation(value = "Buscar Campanha por id", response = Campanha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um Time válido", response = Campanha.class)
    })
    @Query("select c from Campanha c where c.id = :id")
    Campanha getCampanhaPorId(@Param("id") Long id);

    @ApiOperation(value = "Buscar todas as Campanhas", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de Campanhas", response = List.class)
    })
    @Query("select c from Campanha c")
    List<Campanha> getTodasCampanhas();

    @ApiOperation(value = "Buscar todas as Campanhasde um Time", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de Campanhas do Time", response = List.class)
    })
    @Query("select c from Campanha c where c.time.id = :idTime")
    List<Campanha> getCampanhasPorTime(@Param("idTime") Long idTime);

    @ApiOperation(value = "Salvar uma Campanha", response = Campanha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Salva uma Campanha e retorna a Campanha salva", response = Campanha.class)
    })
    Campanha save(Campanha campanha);

    @ApiOperation(value = "Excluir Campanha por id", response = Campanha.class)
    void deleteById(@Param("id") Long id);

}
