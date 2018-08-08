package br.com.conceptmx.campanhaV2.service;

import br.com.conceptmx.campanhaV2.model.Campanha;
import br.com.conceptmx.campanhaV2.model.Cliente;
import br.com.conceptmx.campanhaV2.repository.ClienteRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serviceCliente")
public class ClienteService {

    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/excluir",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void excluir(@RequestBody Long id){
        try{
            this.clienteRepository.deleteById(id);
        } catch (Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/incluir",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Cliente salvar(@RequestBody Cliente cliente){
        try {
            return this.clienteRepository.save(cliente);
        } catch (Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/getPorId",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Cliente getClientePorId(@RequestBody Long id){
        return this.clienteRepository.getClientePorId(id);
    }

    @RequestMapping(value = "/getPorEmail",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Cliente getClientePorEmail(@RequestBody String email){
        return this.clienteRepository.getClientePorEmail(email);
    }

    @RequestMapping(value = "/getCampanhasPorCliente",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Campanha> getCampanhasPorCliente(@RequestBody String email){
        return this.clienteRepository.getCampanhasPorCliente(email);
    }

    @RequestMapping(value = "/getTodosClientes",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Cliente> getTodosClientes(){
        return this.clienteRepository.getTodosClientes();
    }
}
