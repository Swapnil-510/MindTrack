package com.MindTrack.repository;

import com.MindTrack.model.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<Journal,String>{

}