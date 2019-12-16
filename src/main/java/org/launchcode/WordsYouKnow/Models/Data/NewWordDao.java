package org.launchcode.WordsYouKnow.Models.Data;

import org.launchcode.WordsYouKnow.Models.NewWord;
import org.launchcode.WordsYouKnow.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NewWordDao extends CrudRepository<NewWord, Integer> {
//    NewWord findById(Integer newWordId);

}