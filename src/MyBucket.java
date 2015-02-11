import java.util.ArrayList;
import java.util.List;

/**
 * Implementarea interfetei Bucket din scheletul de cod.
 * @author Cristian Calina
 *
 * @param <K>
 * @param <V>
 */
public class MyBucket<K, V> implements MyHashMap.Bucket<K, V> {
	
	public ArrayList<MyHashMap.Entry<K, V>> entries; 
	
	public MyBucket(){
		entries = new ArrayList<MyHashMap.Entry<K, V>>();
	}

	@Override
	public List<? extends MyHashMap.Entry<K, V>> getEntries() {
		return entries;
	}

	/**
	 * Returneaza entry-ul asociat cheii.
	 */
	@Override
	public MyHashMap.Entry<K, V> getEntry(K key) {
		for (MyHashMap.Entry<K, V> entry : entries){
			if (entry.getKey().equals(key)){
				return entry;
			}
		}
		return null;
	}
	
	/**
	 * Creez un nou entry cu cheia si valoarea si iau o variabila pentru a imi da seama
	 * daca cheia deja exista in lista de entry-uri. Daca aceasta exista , returnez valoarea
	 * curenta si o inlocuiesc cu cea noua. Daca nu exista , adaug entry-ul in lista.
	 * 
	 * @return valoarea precedenta cheii sau null daca nu exista.
	 */
	@Override
	public V addEntry(K key , V value){
		MyEntry<K, V> entry = new MyEntry<K, V>(key,value);
		boolean found = false;
		V retval = null;
		for (MyHashMap.Entry<K, V> entryIt : entries){
			if (entryIt.getKey().equals(key)){
				found = true;
				retval = entryIt.getValue();
				entryIt.updateValue(value);
			}
		}
		if (found == false){
			entries.add(entry);		
		}
		return retval;
	}

	
	/**
	 * @return Valoarea precedenta stergerii cheii sau null.
	 */
	@Override
	public V removeEntry(K key) {
		for (MyHashMap.Entry<K, V> entry : entries){
			if (entry.getKey().equals(key)){
				V val = entry.getValue();
				entries.remove(entry);
				return val;
			}
		}
		return null;
	}

}
