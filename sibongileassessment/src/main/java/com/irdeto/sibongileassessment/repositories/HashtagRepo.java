package com.irdeto.sibongileassessment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irdeto.sibongileassessment.model.Hashtag;

@Repository
public interface HashtagRepo extends JpaRepository<Hashtag, Long> {
    Hashtag findByTag(String tag);
   


}
