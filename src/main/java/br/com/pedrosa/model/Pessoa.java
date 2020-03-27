package br.com.pedrosa.model;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@MongoEntity(collection = "pessoas")
public class Pessoa extends PanacheMongoEntity {
    @Schema(hidden = true)
    public ObjectId getId() {
        return id;
    }
    public String nome;
    public Integer idade;
}
