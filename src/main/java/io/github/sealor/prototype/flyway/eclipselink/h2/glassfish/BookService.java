package io.github.sealor.prototype.flyway.eclipselink.h2.glassfish;

import io.github.sealor.prototype.flyway.eclipselink.h2.glassfish.model.Book;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookService {

	@PersistenceContext(unitName = "testPU")
	private EntityManager entityManager;

	public List<Book> findAll() {
		return this.entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}
}
