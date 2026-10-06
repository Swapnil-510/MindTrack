package com.MindTrack.repository;

import com.MindTrack.model.Mood;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MoodRepository extends MongoRepository<Mood,String>{

    List<Mood> findByUserEmail(String userEmail);

}
