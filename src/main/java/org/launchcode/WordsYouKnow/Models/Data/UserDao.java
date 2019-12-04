package org.launchcode.WordsYouKnow.Models.Data;

import org.launchcode.WordsYouKnow.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
//    public User findByName(String name);
}
