import java.util.ArrayList;
import java.util.List;

/**
 * Clasa ce implementeaza interfata MyHashMap
 * @author Cristian Calina
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMapImpl<K, V> implements MyHashMap<K, V>{
	
	protected ArrayList<Bucket<K, V>> buckets;
	
	/**
	 * Setez buckets ca avand size-ul args[0](primit ca parametru)
	 * si ii initializez pe fiecare (pentru ca vectorul sa aiba dimensiunea
	 * args[0] si nu 0).
	 * @param size
	 */
	public MyHashMapImpl(int size){
		buckets = new ArrayList<Bucket<K, V>>(size);
		for (int i = 0 ; i < size ; i ++){
			buckets.add(new MyBucket<K, V>());
		}
	}
	
	/**
	 * Functia de translatare conform cerintei.
	 * @param hash
	 * @return indicele pentru bucket.
	 */
	public int translate (int hash){
		return Math.abs(hash) % buckets.size();
	}

	/**
	 * @return null sau valoarea de la acea cheie.
	 */
	@Override
	public V get(K key) {
		if (buckets.get(translate(key.hashCode())).getEntry(key) != null) {
			return buckets.get(translate(key.hashCode())).getEntry(key).getValue();
		}
		return null;
	}
	
	/**
	 * Adauga la bucketul cheii un entry cu cheia si valoarea din parametrii
	 * @return null sau valoarea ce era anterior la acea cheie.
	 */
	@Override
	public V put(K key, V value) {
		return buckets.get(translate(key.hashCode())).addEntry(key, value);
	}

	/**
	 * Sterge din bucket-ul cheii entry-ul.
	 * @return valoarea cheii sterse.
	 */
	@Override
	public V remove(K key) {
		return buckets.get(translate(key.hashCode())).removeEntry(key);
	}

	/**
	 * @return Dimensiunea vectorului de bucket-uri.
	 */
	@Override
	public int size() {
		return buckets.size();
	}

	/**
	 * @return Vectorul de bucketuri.
	 */
	@Override
	public List<? extends MyHashMap.Bucket<K, V>> getBuckets() {
		return buckets;
	}

}
