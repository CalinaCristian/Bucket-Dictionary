
/**
 * Implementez Entry-ul din interfata MyHashTable.
 * @author Cristian Calina
 *
 * @param <K>
 * @param <V>
 */
public class MyEntry<K, V> implements MyHashMap.Entry<K, V> {
	
	protected K key;
	protected V value;
	
	public MyEntry(K key, V value){
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		if (!this.equals(null)){
			return this.key;
		}
		return null;
	}

	@Override
	public V getValue() {
		if (!this.equals(null)){
			return this.value;
		}
		return null;
	}

	/**
	 * Functie adaugata pentru a suprascrie valoarea
	 * de la o anumita cheie.
	 */
	@Override
	public void updateValue(V value) {
		this.value = value;
	}

}
