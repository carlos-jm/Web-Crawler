
package upm.prof.webcrawler.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="website")
public class Website {

	@Id
	private int id;
	private String url;
	private String last_update;
	
	@ManyToOne
    @JoinColumn(name="category")
    private Category category;
	
	@ManyToOne
    @JoinColumn(name="type")
	private Type type;
	
	@ManyToMany(mappedBy = "websites")
	private List<User> users;
	
	public Website() {
		
	}


	public Website(int id, String url, String last_update, Category category, Type type) {
		super();
		this.id = id;
		this.url = url;
		this.last_update = last_update;
		this.category = category;
		this.type = type;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getLast_update() {
		return last_update;
	}


	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}

}
