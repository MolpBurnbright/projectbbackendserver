package backend.repositories;

import backend.models.Mood;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoodsRepository extends MongoRepository<Mood, String> {
    Mood findBy_id(ObjectId _id);
}