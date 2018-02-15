package ua.entity;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
@Data
public class Book extends AbstractEntityId{

	private String photoUrl;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Genre genre;
	
	private int avalibleCounter;
	
	private LocalDate releaseDate;
	
	private String fullDesc;
}
