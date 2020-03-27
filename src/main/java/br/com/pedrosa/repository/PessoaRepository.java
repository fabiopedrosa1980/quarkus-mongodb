package br.com.pedrosa.repository;

import br.com.pedrosa.model.Pessoa;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PessoaRepository implements PanacheMongoRepository<Pessoa> {
    public List<Pessoa> maiores(){
        return list("idade > ?1",18);
    }
}
