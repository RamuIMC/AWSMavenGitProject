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
public interface Specification<T> {
	
	Predicate toPredicate(Root<T> root, CriteriaBuilder cb);

}
