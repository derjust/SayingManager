package de.zeeman.sayingManager.data;

import java.util.List;


public interface DataListener {
	
	/**
	 * @param searchDummy
	 * @return
	 */
	public List<Saying> search(Saying searchDummy);
	
	/**
	 * @return
	 */
	public Saying getRandomSaying();
	
	/**
	 * @param newSaying
	 */
	public void addSaying(Saying newSaying);
	
	/**
	 * @param newAuthor
	 */
	public void addAuthor(Author newAuthor);
}
