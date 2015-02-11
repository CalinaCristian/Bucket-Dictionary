
import java.util.ArrayList;

/**
 * Clasa generica ce implementeaza conform
 * algoritmilor DisjointSets.
 * @author Cristian Calina
 *
 * @param <T>
 */
public class DisjointSets<T> {
	private ArrayList<Entry<T>> elements;
	private MyHashMap<T, Integer> indexes; 
	
	
	public DisjointSets(int size) {
		indexes = new MyHashMapImpl<T, Integer>(size);
		elements = new ArrayList<Entry<T>>();
	}
	
	/**
	 * Warningul face parte din scheletul codului.
	 * @author Cristian Calina
	 *
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	private class Entry<T> {
		public T element;
		public int setIndex;
		public  Entry(T element) {
			this.element = element;
			setIndex = elements.size();
		}
 	}
	
	/**
	 * Adaug un element in vectorul elementelor si 
	 * il adaug si in hashmap-ul de indecsi.
	 * @param elem
	 */
	public void addElement(T elem) {
		Entry<T> newelement = new Entry<T>(elem);
		elements.add(newelement);
		indexes.put(newelement.element, newelement.setIndex);
	}
	
	/**
	 * Respecta algoritmul din cerinta.
	 * @param e1
	 * @param e2
	 */
	public void mergeSetsOf(T e1, T e2) {
		int idx1 = indexes.get(e1);
		int idx2 = indexes.get(e2);
		for (Entry<T> elemIt : elements){
			if (indexes.get(elemIt.element) == Math.max(idx1, idx2)){
				elemIt.setIndex = Math.min(idx1, idx2);
				indexes.put(elemIt.element, elemIt.setIndex);
			}
		}
	}
	
	/**
	 * Respecta algoritmul din cerinta.
	 * De asemenea , nu adauga elementul daca acesta este
	 * cel dat ca parametru.
	 * 
	 * @param elem
	 * @return
	 */
	public ArrayList<T> setOf(T elem) {
		int idx = indexes.get(elem);
		ArrayList<T> elemlist = new ArrayList<T>();
		for (Entry<T> elemIt : elements){
			if (elemIt.setIndex == idx && !elemIt.element.equals(elem)){
				if (!elemlist.contains(elemIt.element)){
					elemlist.add(elemIt.element);
				}
			}
		}
		return elemlist;
	}

}