package br.com.conceptmx.campanhaV2.service;

import br.com.conceptmx.campanhaV2.model.Campanha;
import br.com.conceptmx.campanhaV2.model.Cliente;
import br.com.conceptmx.campanhaV2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceCliente")
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/excluir/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity excluir(@RequestBody Long id){
        try{

            HttpHeaders header = new HttpHeaders();
            header.add("cliente", "cliente");

            this.clienteRepository.deleteById(id);

            return ResponseEntity.status(204).headers(header).body(new Cliente());
        } catch (Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/incluir",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        try {

            HttpHeaders header = new HttpHeaders();
            header.add("cliente", "cliente");

            Cliente c = this.clienteRepository.save(cliente);

            return ResponseEntity.status(201).headers(header).body(c);
        } catch (Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/alterar",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente){
        try {

            HttpHeaders header = new HttpHeaders();
            header.add("cliente", "cliente");

            Cliente c = this.clienteRepository.save(cliente);

            return ResponseEntity.status(201).headers(header).body(c);
        } catch (Exception ex){
            return ResponseEntity.status(500).body(null);
        }
    }

    @RequestMapping(value = "/getPorId/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Cliente> getClientePorId(@PathVariable Long id){

        HttpHeaders header = new HttpHeaders();
        header.add("cliente", "cliente");

        Cliente c = this.clienteRepository.getClientePorId(id);

        return ResponseEntity.status(201).headers(header).body(c);
    }

    @RequestMapping(value = "/getPorEmail/{email}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Cliente> getClientePorEmail(@PathVariable String email){

        HttpHeaders header = new HttpHeaders();
        header.add("cliente", "cliente");

        Cliente c = this.clienteRepository.getClientePorEmail(email);

        return ResponseEntity.status(200).headers(header).body(c);
    }

    @RequestMapping(value = "/getCampanhasPorCliente/{email}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Campanha>> getCampanhasPorCliente(@PathVariable String email){

        HttpHeaders header = new HttpHeaders();
        header.add("cliente", "cliente");

        List<Campanha> campanhas = this.clienteRepository.getCampanhasPorCliente(email);

        return ResponseEntity.status(201).headers(header).body(campanhas);
    }

    @RequestMapping(value = "/getTodosClientes",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Cliente>> getTodosClientes(){

        HttpHeaders header = new HttpHeaders();
        header.add("cliente", "cliente");

        List<Cliente> clientes = this.clienteRepository.getTodosClientes();

        return ResponseEntity.status(201).headers(header).body(clientes);
    }
}
