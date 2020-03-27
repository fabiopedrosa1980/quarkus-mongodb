package br.com.pedrosa.resource;

import br.com.pedrosa.model.Pessoa;
import br.com.pedrosa.repository.PessoaRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.Response.created;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {

    @Context
    UriInfo uriInfo;

    @Inject
    PessoaRepository pessoaRepository;

    @POST
    public Response add(Pessoa pessoa) {
        pessoaRepository.persist(pessoa);
        URI location = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", pessoa.getId())
                .build();
        return created(location).entity(pessoa).build();
    }

    @GET
    public List<Pessoa> list() {
        return pessoaRepository.listAll();
    }

    @GET
    @Path("maiores")
    public List<Pessoa> maiores() {
        return pessoaRepository.maiores();
    }

}