package main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;import java.util.HashMap;import java.util.List;import pack.MyNewGrammar;import pt.up.fe.specs.spoon.SpoonASTLauncher;
import parser.*;public class PAT {
	/**	 * The main method.	 *	 * @param args the first argument must be pattern file	 * @throws IOException Signals that an I/O exception has occurred.	 */	public static void main(String args[]) throws IOException {		/*Loads the file with the patterns*/		String content = new String(Files.readAllBytes(Paths.get(args[0])));		/*Creates a MyNewGrammar based on the file loaded*/		MyNewGrammar.createjjt(content);		/*Loads Java code and parsers it with SpoonASTLauncher*/
		String testJson = SpoonASTLauncher.java2json(Paths.get("Test.java").toString(), null, false);		/*Loads Java code generated by the MyNewGrammar class (MyPattern.java) and parsers it with SpoonASTLauncher*/
		String patternsJson = SpoonASTLauncher.java2json(Paths.get("MyPattern.java").toString(), null, false);				/*Starts the comparison between the two trees and finds the patterns in common*/		Parser parser = new Parser();		Root rootTest = parser.parse(testJson);		Root rootPatterns = parser.parse(patternsJson);				ExtractPatterns extract = new ExtractPatterns();				extract.visit(rootPatterns);		HashMap<String, List<Pattern>> patternsToFind = extract.getPatterns();				FindPattern findPatterns = new FindPattern(patternsToFind);				findPatterns.visit(rootTest);		findPatterns.awaitTermination();		
	}
}