import com.google.common.base.Joiner;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class Tokenizer{

    private static Table<Integer, Token, String> tokenTable = TreeBasedTable.create();
    private StringBuilder data = new StringBuilder();
    private boolean finish = false;
    private int tokenIndex = 0;

    public void setInputData(StringBuilder inputData) {
        data = inputData;
    }

    //iterate through string data and tokenize lexeme terms
    public boolean nextToken() {

        for (Token token : Token.values()) {

            int end = token.CountChars(data.toString());

            if (end != -1) {
                String lexeme = data.substring(0, end);
                tokenTable.put(tokenIndex+=1,token,lexeme);
                data.delete(0, end);

                return true;
            }
        }

        return false;
    }

    private void printTable(Table inputTable) {

        Joiner.MapJoiner mapJoiner = Joiner.on("\n").withKeyValueSeparator("        "); //Let's a Guava Joiner to illustrate that
        inputTable.rowKeySet().forEach(r -> {
            System.out.println(r + "        " + mapJoiner.join(inputTable.row(r)));
        });
    }

    public void printTable(){
        printTable(tokenTable);
    }

    public boolean isComplete() {
        return finish;
    }

    public void findTokens() {
        if (finish) {
            return;
        }

        if (nextToken()){
            return;
        }
        finish = true;
    }
}
