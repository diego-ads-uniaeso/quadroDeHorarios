package br.edu.uniaeso.quadrodehorarios.repositories;

import


		lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Getter
public abstract class AbstractRepository<T, PK extends Serializable> {

	@SuppressWarnings("unchecked")
	private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	@PersistenceContext
	private EntityManager entityManager;

	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	public void update(T entity) {

		entityManager.merge(entity);
	}

	public void delete(PK id) {

		entityManager.remove(entityManager.getReference(entityClass, id));
	}

	public T findById(PK id) {

		return entityManager.find(entityClass, id);
	}

	public List<T> findAll() {

		return entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();
	}

	protected List<T> createQuery(String jpql, Object... params) {
		TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.getResultList();
	}
}
