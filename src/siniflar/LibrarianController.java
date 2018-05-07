
public interface LibrarianController {

	void addBook();
	void addBookFromFile();
	void chargeFine();
	void getBooks();
	void getBooks(int issueStatusId);
	void getOutDatedBooks();
	void issueBook();
	void returnBook();
}
