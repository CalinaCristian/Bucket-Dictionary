/**
 * In clasa aceasta am trimis argumentele catre clasa
 * dictionary in scopul rezolvarii modularizate a temei.
 * 
 * @author Cristian Calina
 *
 */
public class Main {
	
	public static void main(String[] args) {
		int bucketSize = Integer.parseInt(args[0]);
		Dictionary dictionary = new Dictionary(bucketSize);
		dictionary.inputFile(args[1]);
		dictionary.resolveTask(args[2],args[3]);

	}
}