package io.github.sealor.prototype.flyway.eclipselink.h2.glassfish;

import io.github.sealor.prototype.flyway.eclipselink.h2.glassfish.model.Book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/books", loadOnStartup = 1)
public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = -6551113277043970436L;

	@Inject
	private BookService bookService;

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException,
			IOException {
		PrintWriter writer = resp.getWriter();

		List<Book> books = this.bookService.findAll();
		for (Book book : books) {
			writer.append(book.getTitle());
			writer.append("\n");
		}
	}
}
