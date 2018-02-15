package ua.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author")
@Data
public class Author extends AbstractEntityId{

	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy = "author")
	private List<Book> books = new ArrayList<>();
}
