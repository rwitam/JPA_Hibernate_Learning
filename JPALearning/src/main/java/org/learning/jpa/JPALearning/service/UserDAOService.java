package org.learning.jpa.JPALearning.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.learning.jpa.JPALearning.entity.User;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class UserDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert (User user)
	{
		entityManager.persist(user);
		return user.getId();
	}

}
