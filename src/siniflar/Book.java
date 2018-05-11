package siniflar;

public class Book {
	private String author;
	private int bookId;
	private String category;
	private int issueStatusId;
	private int numberOfPages;
	private  String releaseDate;
	private String title;
	private IssueStatus issueStatus;
	
	public Book(String author,int bookId,String Category,int issueStatusId,int numberOfPages,String releaseDate,String title)
	{
		this.issueStatus =new IssueStatus();
		this.author=author;
		this.bookId=bookId;
		this.category=category;
		this.numberOfPages=numberOfPages;
		this.releaseDate=releaseDate;
		this.title=title;
		issueStatus.issueStatusId(issueStatusId);
	}
	public Book()
	{
		this.author="--";
		this.bookId=0;
		this.category="--";
		this.issueStatusId=0;
		this.numberOfPages=0;
		this.releaseDate="--";
		this.title="--";
		
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	public int getBookId()
	{
		return this.bookId;
	}
	public String getCategory()
	{
		return this.category;
	}
	public int getIssueStatusId()
	{
		return this.issueStatusId;
	}
	public int getNumberOfPages()
	{
		return this.numberOfPages;
	}
	public  String getReleaseDate()
	{
		return this.releaseDate;
	}
	public String getTitle()
	{
		return this.title;
	}
}