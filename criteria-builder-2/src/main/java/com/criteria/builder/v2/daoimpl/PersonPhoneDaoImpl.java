package com.criteria.builder.v2.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonPhoneDaoImpl {

	@Autowired
	EntityManager em;

	public void joinWithOutMapping() {
		@SuppressWarnings("unchecked")
		List<Object[]> results = em.createQuery(
				                                "SELECT p.firstName, "
				                                + "p.lastName, "
				                                + "n.phoneNumber FROM Person p, "
				                                + "PhoneBook n WHERE "
				                                + "p.firstName = n.firstName AND p.lastName = n.lastName"
				                               ).getResultList();

		for (Object[] result : results) {
			System.out.println(result[0] + " " + result[1] + " - " + result[2]);
		}
	}
}
