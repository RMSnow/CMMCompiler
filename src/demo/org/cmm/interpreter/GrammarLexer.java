// $ANTLR 3.4 D:\\��ҵ\\Grammar.g 2011-12-26 22:01:30
package demo.org.cmm.interpreter;

import org.antlr.runtime.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GrammarLexer extends Lexer {
    public static final int EOF=-1;
    public static final int FALSE=4;
    public static final int ID=5;
    public static final int INT=6;
    public static final int KW_BREAK=7;
    public static final int KW_ELSE=8;
    public static final int KW_IF=9;
    public static final int KW_READ=10;
    public static final int KW_WHILE=11;
    public static final int KW_WRITE=12;
    public static final int OP_AND=13;
    public static final int OP_DIVIDE=14;
    public static final int OP_EQUAL=15;
    public static final int OP_LESSTHAN=16;
    public static final int OP_MINUS=17;
    public static final int OP_MORETHAN=18;
    public static final int OP_MULTIPLY=19;
    public static final int OP_NON=20;
    public static final int OP_NOTLESSTHAN=21;
    public static final int OP_NOTMORETHAN=22;
    public static final int OP_OR=23;
    public static final int OP_PLUS=24;
    public static final int OP_UNEQUAL=25;
    public static final int REAL=26;
    public static final int SG_ANNOTATE=27;
    public static final int SG_ASSIGN=28;
    public static final int SG_COLON=29;
    public static final int SG_LEFTANNOTATE=30;
    public static final int SG_LEFTBIGBRACKET=31;
    public static final int SG_LEFTBRACKET=32;
    public static final int SG_LEFTMIDBRACKET=33;
    public static final int SG_RIGHTANNOTATE=34;
    public static final int SG_RIGHTBIGBRACKET=35;
    public static final int SG_RIGHTBRACKET=36;
    public static final int SG_RIGHTMIDBRACKET=37;
    public static final int SG_SEMICOLON=38;
    public static final int TRUE=39;
    public static final int TYPE=40;
    public static final int WS=41;

    	public String TypePredict(String s){
                	int alt10;
                	try {
            		alt10 = dfa9.predict(new ANTLRStringStream(s));
            	} catch (RecognitionException e) {
            			alt10 = 31;
           		}
           		String type="";
           		switch(alt10){
           		case 1:;
           		case 2:;
           		case 3:;
           		case 4:;
           		case 5:; 
           		case 6:;
           		case 7:;
           		case 8:
           			type = "KeyWord";
           			break;
           		case 9:;
           		case 10:;
           		case 11:;
           		case 12:
           			type = "AlgorithmOP";
           			break;
           		case 13:;
           		case 14:;
           		case 15:;
           		case 16:;
           		case 17:;
           		case 18:
           			type = "RelationOP";
           			break;
           		case 19:;
           		case 20:;
           		case 21:
           			type = "LogicOP";
           			break;
           		case 22:;
           		case 23:;
           		case 24:;
           		case 25:;
           		case 26:;
           		case 27:;
           		case 28:;
           		case 29:;
           		case 30:;
           		case 31:;
           		case 32:;
           		case 33:
           			type = "Symbol";
           			break;
           		case 34:
           			type = "Type";
           			break;
           		case 35:
           			type = "Identity";
           			break;
           		case 36:;
           		case 37:
           			type = "Number";
           			break;
           		case 38:;
           		default:
           			type = "Other";
           		}
               	return type;
               }
     

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public GrammarLexer() {} 
    public GrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public GrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\��ҵ\\Grammar.g"; }

    // $ANTLR start "KW_IF"
    public final void mKW_IF() throws RecognitionException {
        try {
            int _type = KW_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:217:7: ( 'if' )
            // D:\\��ҵ\\Grammar.g:217:9: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KW_IF"

    // $ANTLR start "KW_ELSE"
    public final void mKW_ELSE() throws RecognitionException {
        try {
            int _type = KW_ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:219:9: ( 'else' )
            // D:\\��ҵ\\Grammar.g:219:11: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KW_ELSE"

    // $ANTLR start "KW_WHILE"
    public final void mKW_WHILE() throws RecognitionException {
        try {
            int _type = KW_WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:221:10: ( 'while' )
            // D:\\��ҵ\\Grammar.g:221:12: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KW_WHILE"

    // $ANTLR start "KW_BREAK"
    public final void mKW_BREAK() throws RecognitionException {
        try {
            int _type = KW_BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:223:10: ( 'break' )
            // D:\\��ҵ\\Grammar.g:223:12: 'break'
            {
            match("break"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KW_BREAK"

    // $ANTLR start "KW_READ"
    public final void mKW_READ() throws RecognitionException {
        try {
            int _type = KW_READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:225:9: ( 'read' )
            // D:\\��ҵ\\Grammar.g:225:11: 'read'
            {
            match("read"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KW_READ"

    // $ANTLR start "KW_WRITE"
    public final void mKW_WRITE() throws RecognitionException {
        try {
            int _type = KW_WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:227:10: ( 'write' )
            // D:\\��ҵ\\Grammar.g:227:12: 'write'
            {
            match("write"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KW_WRITE"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:229:6: ( 'true' )
            // D:\\��ҵ\\Grammar.g:229:8: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:231:7: ( 'false' )
            // D:\\��ҵ\\Grammar.g:231:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "OP_PLUS"
    public final void mOP_PLUS() throws RecognitionException {
        try {
            int _type = OP_PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:235:9: ( '+' )
            // D:\\��ҵ\\Grammar.g:235:11: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_PLUS"

    // $ANTLR start "OP_MINUS"
    public final void mOP_MINUS() throws RecognitionException {
        try {
            int _type = OP_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:237:10: ( '-' )
            // D:\\��ҵ\\Grammar.g:237:12: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_MINUS"

    // $ANTLR start "OP_MULTIPLY"
    public final void mOP_MULTIPLY() throws RecognitionException {
        try {
            int _type = OP_MULTIPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:239:13: ( '*' )
            // D:\\��ҵ\\Grammar.g:239:15: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_MULTIPLY"

    // $ANTLR start "OP_DIVIDE"
    public final void mOP_DIVIDE() throws RecognitionException {
        try {
            int _type = OP_DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:241:11: ( '/' )
            // D:\\��ҵ\\Grammar.g:241:13: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_DIVIDE"

    // $ANTLR start "OP_MORETHAN"
    public final void mOP_MORETHAN() throws RecognitionException {
        try {
            int _type = OP_MORETHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:245:13: ( '>' )
            // D:\\��ҵ\\Grammar.g:245:15: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_MORETHAN"

    // $ANTLR start "OP_LESSTHAN"
    public final void mOP_LESSTHAN() throws RecognitionException {
        try {
            int _type = OP_LESSTHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:247:13: ( '<' )
            // D:\\��ҵ\\Grammar.g:247:15: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_LESSTHAN"

    // $ANTLR start "OP_UNEQUAL"
    public final void mOP_UNEQUAL() throws RecognitionException {
        try {
            int _type = OP_UNEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:249:12: ( '<>' )
            // D:\\��ҵ\\Grammar.g:249:14: '<>'
            {
            match("<>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_UNEQUAL"

    // $ANTLR start "OP_EQUAL"
    public final void mOP_EQUAL() throws RecognitionException {
        try {
            int _type = OP_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:251:10: ( '==' )
            // D:\\��ҵ\\Grammar.g:251:12: '=='
            {
            match("=="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_EQUAL"

    // $ANTLR start "OP_NOTMORETHAN"
    public final void mOP_NOTMORETHAN() throws RecognitionException {
        try {
            int _type = OP_NOTMORETHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:253:16: ( '<=' )
            // D:\\��ҵ\\Grammar.g:253:18: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_NOTMORETHAN"

    // $ANTLR start "OP_NOTLESSTHAN"
    public final void mOP_NOTLESSTHAN() throws RecognitionException {
        try {
            int _type = OP_NOTLESSTHAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:255:16: ( '>=' )
            // D:\\��ҵ\\Grammar.g:255:18: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_NOTLESSTHAN"

    // $ANTLR start "OP_AND"
    public final void mOP_AND() throws RecognitionException {
        try {
            int _type = OP_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:259:8: ( '&&' )
            // D:\\��ҵ\\Grammar.g:259:10: '&&'
            {
            match("&&"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_AND"

    // $ANTLR start "OP_OR"
    public final void mOP_OR() throws RecognitionException {
        try {
            int _type = OP_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:261:7: ( '||' )
            // D:\\��ҵ\\Grammar.g:261:9: '||'
            {
            match("||"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_OR"

    // $ANTLR start "OP_NON"
    public final void mOP_NON() throws RecognitionException {
        try {
            int _type = OP_NON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:263:9: ( '!' )
            // D:\\��ҵ\\Grammar.g:263:11: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OP_NON"

    // $ANTLR start "SG_COLON"
    public final void mSG_COLON() throws RecognitionException {
        try {
            int _type = SG_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:267:10: ( ':' )
            // D:\\��ҵ\\Grammar.g:267:12: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_COLON"

    // $ANTLR start "SG_SEMICOLON"
    public final void mSG_SEMICOLON() throws RecognitionException {
        try {
            int _type = SG_SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:269:14: ( ';' )
            // D:\\��ҵ\\Grammar.g:269:16: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_SEMICOLON"

    // $ANTLR start "SG_LEFTBRACKET"
    public final void mSG_LEFTBRACKET() throws RecognitionException {
        try {
            int _type = SG_LEFTBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:271:16: ( '(' )
            // D:\\��ҵ\\Grammar.g:271:18: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_LEFTBRACKET"

    // $ANTLR start "SG_RIGHTBRACKET"
    public final void mSG_RIGHTBRACKET() throws RecognitionException {
        try {
            int _type = SG_RIGHTBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:273:17: ( ')' )
            // D:\\��ҵ\\Grammar.g:273:19: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_RIGHTBRACKET"

    // $ANTLR start "SG_LEFTMIDBRACKET"
    public final void mSG_LEFTMIDBRACKET() throws RecognitionException {
        try {
            int _type = SG_LEFTMIDBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:275:19: ( '[' )
            // D:\\��ҵ\\Grammar.g:275:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_LEFTMIDBRACKET"

    // $ANTLR start "SG_RIGHTMIDBRACKET"
    public final void mSG_RIGHTMIDBRACKET() throws RecognitionException {
        try {
            int _type = SG_RIGHTMIDBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:277:20: ( ']' )
            // D:\\��ҵ\\Grammar.g:277:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_RIGHTMIDBRACKET"

    // $ANTLR start "SG_LEFTBIGBRACKET"
    public final void mSG_LEFTBIGBRACKET() throws RecognitionException {
        try {
            int _type = SG_LEFTBIGBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:279:19: ( '{' )
            // D:\\��ҵ\\Grammar.g:279:21: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_LEFTBIGBRACKET"

    // $ANTLR start "SG_RIGHTBIGBRACKET"
    public final void mSG_RIGHTBIGBRACKET() throws RecognitionException {
        try {
            int _type = SG_RIGHTBIGBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:281:20: ( '}' )
            // D:\\��ҵ\\Grammar.g:281:22: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_RIGHTBIGBRACKET"

    // $ANTLR start "SG_ANNOTATE"
    public final void mSG_ANNOTATE() throws RecognitionException {
        try {
            int _type = SG_ANNOTATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:283:13: ( '//' )
            // D:\\��ҵ\\Grammar.g:283:15: '//'
            {
            match("//"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_ANNOTATE"

    // $ANTLR start "SG_LEFTANNOTATE"
    public final void mSG_LEFTANNOTATE() throws RecognitionException {
        try {
            int _type = SG_LEFTANNOTATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:285:17: ( '/*' )
            // D:\\��ҵ\\Grammar.g:285:19: '/*'
            {
            match("/*"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_LEFTANNOTATE"

    // $ANTLR start "SG_RIGHTANNOTATE"
    public final void mSG_RIGHTANNOTATE() throws RecognitionException {
        try {
            int _type = SG_RIGHTANNOTATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:287:18: ( '*/' )
            // D:\\��ҵ\\Grammar.g:287:20: '*/'
            {
            match("*/"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_RIGHTANNOTATE"

    // $ANTLR start "SG_ASSIGN"
    public final void mSG_ASSIGN() throws RecognitionException {
        try {
            int _type = SG_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:289:11: ( '=' )
            // D:\\��ҵ\\Grammar.g:289:13: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SG_ASSIGN"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:292:6: ( 'int' | 'real' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='i') ) {
                alt1=1;
            }
            else if ( (LA1_0=='r') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:292:8: 'int'
                    {
                    match("int"); 



                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Grammar.g:292:16: 'real'
                    {
                    match("real"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:294:4: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) | ( 'a' .. 'z' | 'A' .. 'Z' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                int LA3_1 = input.LA(2);

                if ( ((LA3_1 >= '0' && LA3_1 <= '9')||(LA3_1 >= 'A' && LA3_1 <= 'Z')||LA3_1=='_'||(LA3_1 >= 'a' && LA3_1 <= 'z')) ) {
                    alt3=1;
                }
                else {
                    alt3=2;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:294:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
                    {
                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // D:\\��ҵ\\Grammar.g:294:30: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                            int LA2_1 = input.LA(2);

                            if ( ((LA2_1 >= '0' && LA2_1 <= '9')||(LA2_1 >= 'A' && LA2_1 <= 'Z')||LA2_1=='_'||(LA2_1 >= 'a' && LA2_1 <= 'z')) ) {
                                alt2=1;
                            }


                        }
                        else if ( (LA2_0=='_') ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // D:\\��ҵ\\Grammar.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Grammar.g:294:109: ( 'a' .. 'z' | 'A' .. 'Z' )
                    {
                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:296:5: ( ( '0' .. '9' )+ )
            // D:\\��ҵ\\Grammar.g:296:7: ( '0' .. '9' )+
            {
            // D:\\��ҵ\\Grammar.g:296:7: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:298:6: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // D:\\��ҵ\\Grammar.g:298:8: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // D:\\��ҵ\\Grammar.g:298:8: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            // D:\\��ҵ\\Grammar.g:298:21: ( '.' ( '0' .. '9' )+ )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='.') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:298:22: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // D:\\��ҵ\\Grammar.g:298:25: ( '0' .. '9' )+
                    int cnt6=0;
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\��ҵ\\Grammar.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt6 >= 1 ) break loop6;
                                EarlyExitException eee =
                                    new EarlyExitException(6, input);
                                throw eee;
                        }
                        cnt6++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\Grammar.g:301:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // D:\\��ҵ\\Grammar.g:301:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // D:\\��ҵ\\Grammar.g:301:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||LA8_0=='\r'||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // D:\\��ҵ\\Grammar.g:1:8: ( KW_IF | KW_ELSE | KW_WHILE | KW_BREAK | KW_READ | KW_WRITE | TRUE | FALSE | OP_PLUS | OP_MINUS | OP_MULTIPLY | OP_DIVIDE | OP_MORETHAN | OP_LESSTHAN | OP_UNEQUAL | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN | OP_AND | OP_OR | OP_NON | SG_COLON | SG_SEMICOLON | SG_LEFTBRACKET | SG_RIGHTBRACKET | SG_LEFTMIDBRACKET | SG_RIGHTMIDBRACKET | SG_LEFTBIGBRACKET | SG_RIGHTBIGBRACKET | SG_ANNOTATE | SG_LEFTANNOTATE | SG_RIGHTANNOTATE | SG_ASSIGN | TYPE | ID | INT | REAL | WS )
        int alt9=38;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // D:\\��ҵ\\Grammar.g:1:10: KW_IF
                {
                mKW_IF(); 


                }
                break;
            case 2 :
                // D:\\��ҵ\\Grammar.g:1:16: KW_ELSE
                {
                mKW_ELSE(); 


                }
                break;
            case 3 :
                // D:\\��ҵ\\Grammar.g:1:24: KW_WHILE
                {
                mKW_WHILE(); 


                }
                break;
            case 4 :
                // D:\\��ҵ\\Grammar.g:1:33: KW_BREAK
                {
                mKW_BREAK(); 


                }
                break;
            case 5 :
                // D:\\��ҵ\\Grammar.g:1:42: KW_READ
                {
                mKW_READ(); 


                }
                break;
            case 6 :
                // D:\\��ҵ\\Grammar.g:1:50: KW_WRITE
                {
                mKW_WRITE(); 


                }
                break;
            case 7 :
                // D:\\��ҵ\\Grammar.g:1:59: TRUE
                {
                mTRUE(); 


                }
                break;
            case 8 :
                // D:\\��ҵ\\Grammar.g:1:64: FALSE
                {
                mFALSE(); 


                }
                break;
            case 9 :
                // D:\\��ҵ\\Grammar.g:1:70: OP_PLUS
                {
                mOP_PLUS(); 


                }
                break;
            case 10 :
                // D:\\��ҵ\\Grammar.g:1:78: OP_MINUS
                {
                mOP_MINUS(); 


                }
                break;
            case 11 :
                // D:\\��ҵ\\Grammar.g:1:87: OP_MULTIPLY
                {
                mOP_MULTIPLY(); 


                }
                break;
            case 12 :
                // D:\\��ҵ\\Grammar.g:1:99: OP_DIVIDE
                {
                mOP_DIVIDE(); 


                }
                break;
            case 13 :
                // D:\\��ҵ\\Grammar.g:1:109: OP_MORETHAN
                {
                mOP_MORETHAN(); 


                }
                break;
            case 14 :
                // D:\\��ҵ\\Grammar.g:1:121: OP_LESSTHAN
                {
                mOP_LESSTHAN(); 


                }
                break;
            case 15 :
                // D:\\��ҵ\\Grammar.g:1:133: OP_UNEQUAL
                {
                mOP_UNEQUAL(); 


                }
                break;
            case 16 :
                // D:\\��ҵ\\Grammar.g:1:144: OP_EQUAL
                {
                mOP_EQUAL(); 


                }
                break;
            case 17 :
                // D:\\��ҵ\\Grammar.g:1:153: OP_NOTMORETHAN
                {
                mOP_NOTMORETHAN(); 


                }
                break;
            case 18 :
                // D:\\��ҵ\\Grammar.g:1:168: OP_NOTLESSTHAN
                {
                mOP_NOTLESSTHAN(); 


                }
                break;
            case 19 :
                // D:\\��ҵ\\Grammar.g:1:183: OP_AND
                {
                mOP_AND(); 


                }
                break;
            case 20 :
                // D:\\��ҵ\\Grammar.g:1:190: OP_OR
                {
                mOP_OR(); 


                }
                break;
            case 21 :
                // D:\\��ҵ\\Grammar.g:1:196: OP_NON
                {
                mOP_NON(); 


                }
                break;
            case 22 :
                // D:\\��ҵ\\Grammar.g:1:203: SG_COLON
                {
                mSG_COLON(); 


                }
                break;
            case 23 :
                // D:\\��ҵ\\Grammar.g:1:212: SG_SEMICOLON
                {
                mSG_SEMICOLON(); 


                }
                break;
            case 24 :
                // D:\\��ҵ\\Grammar.g:1:225: SG_LEFTBRACKET
                {
                mSG_LEFTBRACKET(); 


                }
                break;
            case 25 :
                // D:\\��ҵ\\Grammar.g:1:240: SG_RIGHTBRACKET
                {
                mSG_RIGHTBRACKET(); 


                }
                break;
            case 26 :
                // D:\\��ҵ\\Grammar.g:1:256: SG_LEFTMIDBRACKET
                {
                mSG_LEFTMIDBRACKET(); 


                }
                break;
            case 27 :
                // D:\\��ҵ\\Grammar.g:1:274: SG_RIGHTMIDBRACKET
                {
                mSG_RIGHTMIDBRACKET(); 


                }
                break;
            case 28 :
                // D:\\��ҵ\\Grammar.g:1:293: SG_LEFTBIGBRACKET
                {
                mSG_LEFTBIGBRACKET(); 


                }
                break;
            case 29 :
                // D:\\��ҵ\\Grammar.g:1:311: SG_RIGHTBIGBRACKET
                {
                mSG_RIGHTBIGBRACKET(); 


                }
                break;
            case 30 :
                // D:\\��ҵ\\Grammar.g:1:330: SG_ANNOTATE
                {
                mSG_ANNOTATE(); 


                }
                break;
            case 31 :
                // D:\\��ҵ\\Grammar.g:1:342: SG_LEFTANNOTATE
                {
                mSG_LEFTANNOTATE(); 


                }
                break;
            case 32 :
                // D:\\��ҵ\\Grammar.g:1:358: SG_RIGHTANNOTATE
                {
                mSG_RIGHTANNOTATE(); 


                }
                break;
            case 33 :
                // D:\\��ҵ\\Grammar.g:1:375: SG_ASSIGN
                {
                mSG_ASSIGN(); 


                }
                break;
            case 34 :
                // D:\\��ҵ\\Grammar.g:1:385: TYPE
                {
                mTYPE(); 


                }
                break;
            case 35 :
                // D:\\��ҵ\\Grammar.g:1:390: ID
                {
                mID(); 


                }
                break;
            case 36 :
                // D:\\��ҵ\\Grammar.g:1:393: INT
                {
                mINT(); 


                }
                break;
            case 37 :
                // D:\\��ҵ\\Grammar.g:1:397: REAL
                {
                mREAL(); 


                }
                break;
            case 38 :
                // D:\\��ҵ\\Grammar.g:1:402: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\7\32\2\uffff\1\47\1\52\1\54\1\57\1\61\14\uffff\1\62\1\uffff"+
        "\1\64\10\32\17\uffff\1\75\7\32\1\uffff\1\106\3\32\1\112\1\75\1\113"+
        "\1\32\1\uffff\1\115\1\116\1\117\2\uffff\1\120\4\uffff";
    static final String DFA9_eofS =
        "\121\uffff";
    static final String DFA9_minS =
        "\1\11\1\146\1\154\1\150\1\162\1\145\1\162\1\141\2\uffff\1\57\1\52"+
        "\3\75\14\uffff\1\56\1\uffff\1\60\1\164\1\163\2\151\1\145\1\141\1"+
        "\165\1\154\17\uffff\1\60\1\145\1\154\1\164\1\141\1\144\1\145\1\163"+
        "\1\uffff\1\60\2\145\1\153\3\60\1\145\1\uffff\3\60\2\uffff\1\60\4"+
        "\uffff";
    static final String DFA9_maxS =
        "\1\175\1\156\1\154\2\162\1\145\1\162\1\141\2\uffff\2\57\1\75\1\76"+
        "\1\75\14\uffff\1\71\1\uffff\1\172\1\164\1\163\2\151\1\145\1\141"+
        "\1\165\1\154\17\uffff\1\172\1\145\1\154\1\164\1\141\1\154\1\145"+
        "\1\163\1\uffff\1\172\2\145\1\153\3\172\1\145\1\uffff\3\172\2\uffff"+
        "\1\172\4\uffff";
    static final String DFA9_acceptS =
        "\10\uffff\1\11\1\12\5\uffff\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
        "\32\1\33\1\34\1\35\1\43\1\uffff\1\46\11\uffff\1\40\1\13\1\36\1\37"+
        "\1\14\1\22\1\15\1\17\1\21\1\16\1\20\1\41\1\44\1\45\1\1\10\uffff"+
        "\1\42\10\uffff\1\2\3\uffff\1\5\1\7\1\uffff\1\3\1\6\1\4\1\10";
    static final String DFA9_specialS =
        "\121\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\34\2\uffff\1\34\22\uffff\1\34\1\21\4\uffff\1\17\1\uffff\1"+
            "\24\1\25\1\12\1\10\1\uffff\1\11\1\uffff\1\13\12\33\1\22\1\23"+
            "\1\15\1\16\1\14\2\uffff\32\32\1\26\1\uffff\1\27\3\uffff\1\32"+
            "\1\4\2\32\1\2\1\7\2\32\1\1\10\32\1\5\1\32\1\6\2\32\1\3\3\32"+
            "\1\30\1\20\1\31",
            "\1\35\7\uffff\1\36",
            "\1\37",
            "\1\40\11\uffff\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "",
            "",
            "\1\46",
            "\1\51\4\uffff\1\50",
            "\1\53",
            "\1\56\1\55",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\63\1\uffff\12\33",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102\7\uffff\1\103",
            "\1\104",
            "\1\105",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\107",
            "\1\110",
            "\1\111",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\114",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KW_IF | KW_ELSE | KW_WHILE | KW_BREAK | KW_READ | KW_WRITE | TRUE | FALSE | OP_PLUS | OP_MINUS | OP_MULTIPLY | OP_DIVIDE | OP_MORETHAN | OP_LESSTHAN | OP_UNEQUAL | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN | OP_AND | OP_OR | OP_NON | SG_COLON | SG_SEMICOLON | SG_LEFTBRACKET | SG_RIGHTBRACKET | SG_LEFTMIDBRACKET | SG_RIGHTMIDBRACKET | SG_LEFTBIGBRACKET | SG_RIGHTBIGBRACKET | SG_ANNOTATE | SG_LEFTANNOTATE | SG_RIGHTANNOTATE | SG_ASSIGN | TYPE | ID | INT | REAL | WS );";
        }
    }
 

}