package bookshop.repositories.api;

import bookshop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query(value = "SELECT authors.author_id, authors.first_name, authors.last_name\n" +
            "  FROM (SELECT a.author_id, a.first_name, a.last_name, count(b.book_id) AS count\n" +
            "        FROM book_shop_system.authors AS a\n" +
            "          INNER JOIN book_shop_system.books AS b\n" +
            "            ON a.author_id = b.author_id\n" +
            "        GROUP BY a.author_id, a.first_name, a.last_name) AS authors\n" +
            "ORDER BY authors.count DESC;", nativeQuery = true)
    List<Author> findAuthorsByOrOrderByBooksDesc();

    @Query(value = "SELECT authors.author_id, authors.first_name, authors.last_name\n" +
            "  FROM (SELECT a.author_id, a.first_name, a.last_name, count(b.book_id) AS count\n" +
            "        FROM book_shop_system.authors AS a\n" +
            "          INNER JOIN book_shop_system.books AS b\n" +
            "            ON a.author_id = b.author_id\n" +
            "           AND year(b.release_date) < 1990\n" +
            "        GROUP BY a.author_id, a.first_name, a.last_name\n" +
            "       HAVING count(b.book_id) > 0) AS authors\n" +
            "ORDER BY authors.count DESC;\n", nativeQuery = true)
    List<Author> findAuthorsByBooksReleaseDateBefore1990();
}