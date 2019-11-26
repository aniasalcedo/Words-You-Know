package org.launchcode.WordsYouKnow.Models.Data;

import org.launchcode.WordsYouKnow.Models.WordBank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface WordBankDao extends CrudRepository<WordBank, Integer> {
}
