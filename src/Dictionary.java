import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Aceasta clasa reprezinta rezolvarea taskurilor temei.
 * @author Cristian Calina
 *
 */
public class Dictionary {

	protected MyHashMap<String, ArrayList<String>> hashMap;
	protected DisjointSets<String> disJointSets;
	
	/**
	 * Este necesar un vector de Stringuri pentru valori.
	 * @param size
	 */
	public Dictionary(int size){
		hashMap = new MyHashMapImpl<String, ArrayList<String>>(size);
		disJointSets = new DisjointSets<String>(size);
	}

	/**
	 * Pentru adaugarea unui cuvant cu definitia sa , verific
	 * daca cuvantul exista in hashMap , iar daca acesta exista
	 * verific daca si daca definitia exista deja (in caz afirmativ nu fac nimic
	 * iar in caz negativ adaug valoarea in vectorul de valori).
	 * Daca cuvantul nu exista , adaug in hashMap cuvantul si definitia.
	 * De asemenea adaug si in disjointsets cuvantul.
	 * @param key
	 * @param value
	 */
	public void addWord(String key, String value) {

		if (hashMap.get(key) != null){
			if (!hashMap.get(key).contains(value)){
				hashMap.get(key).add(value);
			}
		}
		else {
			ArrayList<String> valueList = new ArrayList<String>();
			valueList.add(value);
			hashMap.put(key, valueList);
		}
		disJointSets.addElement(key);
	}

	/**
	 * Daca cele doua cuvinte nu sunt identice, apelez metoda
	 * mergeSetsOf pentru a le face sinonime intre ele.
	 * @param word1
	 * @param word2
	 */
	public void addSynonyms(String word1, String word2) {
		if (!word1.equals(word2)){
			disJointSets.mergeSetsOf(word1, word2);
		}
	}
	
	/**
	 * @param queryWord
	 * @return prima definitie a cuvantului
	 */
	private String getDefinition(String queryWord) {
		return hashMap.get(queryWord).get(0);
	}
	
	/**
	 * 
	 * @param queryWord
	 * @return numarul de definitii al cuvantului
	 */
	private int getDefinitionsNo(String queryWord){
		return hashMap.get(queryWord).size();
	}

	/**
	 * In aceasta functie deschid fisierul de cuvinte si
	 * parcurg fiecare linie luand cuvintele si adaugandu-le
	 * in hash  alaturi de definitiile sale. Cuvintele le adaug si in
	 * DisJointSets.
	 * De asemenea , creez si legaturile intre sinonime folosind 
	 * functia addSynonyms.
	 * @param inputFile
	 */
	public void inputFile(String inputFile) {
		try {
			String line;
			Scanner sc = new Scanner(new File(inputFile));
			int N;
			int M;
			String[] lineComponents;
			lineComponents = sc.nextLine().toString().split(" ");
			N = Integer.parseInt(lineComponents[0]);
			M = Integer.parseInt(lineComponents[1]);
			for (int i = 0 ; i < N ; i ++){
				line = sc.nextLine();
				String key = line.toString();
				line = sc.nextLine();
				String value = line.toString();
				this.addWord(key,value);
			}
			for (int i = 0 ; i < M ; i ++){
				line = sc.nextLine();
				String[] synonyms = line.split(" ");
				String word1 = synonyms[0];
				String word2 = synonyms[1];
				this.addSynonyms(word1,word2);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Aceasta functie rezolva taskul temei , primind ca parametrii
	 * fisierul de interogari si fisierul de output. 
	 * Din fisierul de interogari citesc numarul de interogari si 
	 * printr-un switch-case rezolv fiecare tip de interogare pentru
	 * cuvintele respective , scriindu-le in fisierul de output.
	 * @param queryFile
	 * @param outputFile
	 */
	public void resolveTask(String queryFile,String outputFile) {
		try {
			String line;
			PrintWriter writer;
			try {
				writer = new PrintWriter(outputFile, "UTF-8");
				Scanner sc = new Scanner(new File(queryFile));
				int Q = Integer.parseInt(sc.nextLine());
				for (int i = 0 ; i < Q ; i ++){
					line = sc.nextLine();
					String [] lineComponents = line.split(" ");
					String queryType = lineComponents[0];
					String queryWord = lineComponents[1]; 
					switch (queryType){
					case "0" :
						writer.println(this.getDefinition(queryWord));
						break;
					case "1" :
						writer.println(this.getDefinitionsNo(queryWord));
						break;
					case "2" :
						ArrayList<String> synonyms =disJointSets.setOf(queryWord);
						Collections.sort(synonyms);
						for (String synonym : synonyms){
							writer.print(synonym + " ");
						}
						writer.println();
						break;
					}
				}
				sc.close();
				writer.close();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
