import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lexer {

    private static StringBuilder data = new StringBuilder();

    static private void readFile(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for (String line; (line = br.readLine()) != null; ) {
                data.append(line + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Read Error");
        }
    }

    public static void main(String[] args) {

        readFile("src/input.txt");

        Tokenizer lexer = new Tokenizer();
        lexer.setInputData(data);

        System.out.println("STOOL LEXER \n");

        while (!lexer.isComplete()){
            lexer.findTokens();
            }
        lexer.printTable();

        if (lexer.isComplete()){
            System.out.println("Ok! :D");
        } else {
            System.out.println("Unable to finish lexing");
        }
        }

    }


