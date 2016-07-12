/**
 * 
 */
package com.project.pattern.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Ramakrishna
 *
 */
public class AbstractSpecification<T> implements Specification<T>{

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaBuilder cb) {
		
		return null;
	}
	
	
	
	
}
