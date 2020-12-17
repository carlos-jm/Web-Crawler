package upm.prof.webcrawler.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="user")
public class User {

	@Id
	private int id;
	private String user_name;
	private String password;
	

	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_web", 
      joinColumns = @JoinColumn(name = "user_id", 
      							referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "web_id", 
      									referencedColumnName = "id")
    		)
    private List<Website> websites;
		
	
	public User() {
		
	}


	public User(int id, String user_name, String password) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.password = password;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return user_name;
	}


	public void setUserName(String user_name) {
		this.user_name = user_name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public List<Website> getWebsites() {
		return websites;
	}


	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}
	
	
	
}
