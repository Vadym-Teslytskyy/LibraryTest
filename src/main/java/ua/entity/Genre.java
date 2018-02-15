package ua.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genre")
@Data
public class Genre extends AbstractEntityId{
	
	private String genreName;
	
	@OneToMany(mappedBy = "genre")
	private List<Book> books = new ArrayList<>();

	public static void main(String[] args) {
		Genre g = new Genre();
		g.getId();
	}
}
