import java.util.regex.Matcher;
import java.util.regex.Pattern;

//enum class classifies unique lexeme tokens using regular expression pattern matching library
public enum Token {

    //grouping and operator symbols
    TOKEN_L_PAREN ("\\("),
    TOKEN_R_PAREN ("\\)"),
    TOKEN_L_BRACKET ("\\{"),
    TOKEN_R_BRACKET ("\\}"),
    TOKEN_OP_MUL ("\\*"),
    TOKEN_OP_DIV ("/"),
    TOKEN_OP_PLUS ("\\+"),
    TOKEN_OP_MINUS ("-"),
    TOKEN_AND ("&"),
    TOKEN_OR ("\\|"),
    TOKEN_SEMI (";"),
    TOKEN_COMMA (","),
    TOKEN_LTEQ ("<="),
    TOKEN_GTEQ (">="),
    TOKEN_LT ("<"),
    TOKEN_GT (">"),
    TOKEN_EQ ("\\A=="),
    TOKEN_ASSIGN ("="),

//    TOKEN_ASSIGN1("^\\={3,}+"),  ^(?!/.{0,4}$).*$   [(==)]+  /^\d+$/ //^(?:(?!\berror\b).)*$ \b(?!cat\b)\w+

    //reserved keyword tokens [^==+]
    TOKEN_KEY_CLASS ("\\bclass\\b"),
    TOKEN_KEY_METHOD ("\\bmethod\\b"),
    TOKEN_KEY_DEFINE ("\\bdefine\\b"),
    TOKEN_KEY_THIS ("\\bthis\\b"),
    TOKEN_KEY_NULL ("\\bnull\\b"),
    TOKEN_KEY_FOR ("\\bfor\\b"),
    TOKEN_KEY_WHILE ("\\bwhile\\b"),
    TOKEN_KEY_IF ("\\bif\\b"),
    TOKEN_KEY_ELSE ("\\belse\\b"),
    TOKEN_KEY_ELSEIF ("\\belseif\\b"),
    TOKEN_KEY_BOOL ("\\bboolean\\b"),
    TOKEN_KEY_TRUE ("\\btrue\\b"),
    TOKEN_KEY_FALSE ("\\bfalse\\b"),
    TOKEN_KEY_RETURN ("\\breturn\\b"),
    TOKEN_KEY_VOID ("\\bvoid\\b"),
    TOKEN_KEY_PUBLIC ("\\bpublic\\b"),
    TOKEN_KEY_PRIVATE ("\\bprivate\\b"),
    TOKEN_KEY_PROTECTED ("\\bprotected\\b"),
    TOKEN_KEY_SUPER ("\\bsuper\\b"),
    TOKEN_KEY_EXTENDS ("\\bextends\\b"),
    TOKEN_KEY_STRING ("\\bstring\\b"),
    TOKEN_KEY_INT ("\\bint\\b"),

    //regular expression rules for pattern match strings, numbers, and variables
    TOKEN_STRING ("\"[^\"]+\""),
    TOKEN_INT("\\b\\d+\\b"),
    TOKEN_IDENTIFIER ("\\b[a-z|A-Z]+\\w+\\b"),

    //merges all forms of emptyspace between non-whitespace lexeme into one token
    TOKEN_WHITESPACE("[(\\s)]+");

    // compiles the given regular expressions into pattern /+=/
    private final Pattern pattern;
    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
//        index
    }

    //returns number of chars in token
    int CountChars(String s) {

        Matcher tokenMatch = pattern.matcher(s);
        //Attempts to find the next subsequence of the input sequence that matches the pattern
        if (tokenMatch.find()){
            return tokenMatch.end();
        }
          return -1;
    }
}