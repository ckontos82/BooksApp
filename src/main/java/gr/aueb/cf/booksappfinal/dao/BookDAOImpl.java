package gr.aueb.cf.booksappfinal.dao;

import gr.aueb.cf.booksappfinal.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    private EntityManager em;

    public BookDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> findByTitleContaining(String title) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE LOWER(b.title) LIKE lower(:title)", Book.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Book book) {
        em.persist(book);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        em.remove(em.find(Book.class, id));
    }

    @Override
    @Transactional
    public void update(Book book) {
        em.merge(book);
    }
}
