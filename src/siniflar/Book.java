package siniflar;

import java.util.Date;

public class Book {
	private String author;
	private int bookId;
	private String category;
	private int issueStatusId;
	private int numberOfPages;
	private  Date releaseDate;
	private String title;
	private IssueStatus issueStatus;
	
	public Book(String author,int bookId,String category,int issueStatusId,int numberOfPages,Date releaseDate,String title)
	{
	
		this.author=author;
		this.bookId=bookId;
		this.category=category;
		this.numberOfPages=numberOfPages;
		this.releaseDate=releaseDate;
		this.title=title;
		this.issueStatus.setIssueStatusId(issueStatusId);
		
	}

	
	public String getAuthor()
	{
		return this.author;
	}
	public void setAuthor(String author)
	{
		
	}
	public int getBookId()
	{
		return this.bookId;
	}
	public void setBookId(int bookId)
	{
		
	}
	public String getCategory()
	{
		return this.category;
	}
	public void setCategory(String category)
	{
		
	}
	public int getIssueStatusId()
	{
		return this.issueStatusId;
	}
	public void setIssueStatusId(int issueStatusId)
	{
		
	}
	public int getNumberOfPages()
	{
		return this.numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages)
	{
	
	}
	public  Date getReleaseDate()
	{
		return this.releaseDate;
	}
	public  void setReleaseDate(String releaseDate)
	{
	
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setTitle(String title)
	{
		
	}
}