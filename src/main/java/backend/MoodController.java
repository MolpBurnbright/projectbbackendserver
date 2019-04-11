package backend;

import backend.repositories.MoodsRepository;
import backend.models.Mood;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mood")
public class MoodController {
	@Autowired
	private MoodsRepository repository;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Mood> getAllMoods() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Mood getMoodById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
    }
    
//    @CrossOrigin(origins = "http://localhost:9000")
    @CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyMoodById(@PathVariable("id") ObjectId id, @Valid @RequestBody Mood mood) {
	mood.set_id(id);
		repository.save(mood);
	}

    @CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Mood createMood(@Valid @RequestBody Mood mood) {
		mood.set_id(ObjectId.get());
		repository.save(mood);
		return mood;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMood(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}