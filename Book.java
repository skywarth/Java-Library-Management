

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
		this.bookId="--";
		this.category="--";
		this.issueStatusId="--";
		this.numberOfPages="--";
		this.releaseDate="--";
		this.title="--";
		
	}
	
	public String getauthor()
	{
		return this.author;
	}
	public int getbookId()
	{
		return this.bookId;
	}
	public String getcategory()
	{
		return this.category;
	}
	public int getissueStatusId()
	{
		return this.issueStatusId;
	}
	public int getnumberOfPages()
	{
		return this.numberOfPages;
	}
	public  String getreleaseDate()
	{
		return this.releaseDate;
	}
	public String gettitle()
	{
		return.title;
	}
}