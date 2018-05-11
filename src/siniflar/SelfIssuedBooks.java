package siniflar;

import java.util.Date;

public class SelfIssuedBooks extends Book
{
    public SelfIssuedBooks(String author, int bookId, String category, int issueStatusId, int numberOfPages,
			Date releaseDate, String title) {
		super(author, bookId, category, issueStatusId, numberOfPages, releaseDate, title);
		// TODO Auto-generated constructor stub
	}

	private String TCNo;
}
