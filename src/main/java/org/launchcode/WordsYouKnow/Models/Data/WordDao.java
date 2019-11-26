package org.launchcode.WordsYouKnow.Models.Data;

import org.launchcode.WordsYouKnow.Models.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WordDao extends CrudRepository<Word, Integer> {
}
