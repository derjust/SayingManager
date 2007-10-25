package de.zeeman.sayingManager.data;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;


@Entity
@Table(name="Sayings")
public class Saying implements Serializable {
	private static final long serialVersionUID = -7006156488832763372L;
	private Long id;
	private String saying;
	private Author author;

	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSaying() {
		return saying;
	}
	public void setSaying(String saying) {
		this.saying = saying;
	}
	@OneToMany
	@PrimaryKeyJoinColumn
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}	
}
