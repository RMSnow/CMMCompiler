// $ANTLR 3.4 D:\\��ҵ\\AST.g 2011-12-26 21:23:40

package demo.org.cmm.interpreter;


import org.antlr.runtime.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ASTLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ARRAY=4;
    public static final int ATOM=5;
    public static final int BODY=6;
    public static final int BoolExpr=7;
    public static final int CONDITION=8;
    public static final int DF_ARR=9;
    public static final int DF_VAR=10;
    public static final int ELSE=11;
    public static final int FALSE=12;
    public static final int ID=13;
    public static final int IF=14;
    public static final int INT=15;
    public static final int KW_BREAK=16;
    public static final int KW_ELSE=17;
    public static final int KW_IF=18;
    public static final int KW_READ=19;
    public static final int KW_WHILE=20;
    public static final int KW_WRITE=21;
    public static final int OP_AND=22;
    public static final int OP_DIVIDE=23;
    public static final int OP_EQUAL=24;
    public static final int OP_LESSTHAN=25;
    public static final int OP_MINUS=26;
    public static final int OP_MORETHAN=27;
    public static final int OP_MULTIPLY=28;
    public static final int OP_NON=29;
    public static final int OP_NOTLESSTHAN=30;
    public static final int OP_NOTMORETHAN=31;
    public static final int OP_OR=32;
    public static final int OP_PLUS=33;
    public static final int OP_UNEQUAL=34;
    public static final int PROG=35;
    public static final int READ=36;
    public static final int REAL=37;
    public static final int SEQU=38;
    public static final int SG_ANNOTATE=39;
    public static final int SG_ASSIGN=40;
    public static final int SG_COLON=41;
    public static final int SG_LEFTANNOTATE=42;
    public static final int SG_LEFTBIGBRACKET=43;
    public static final int SG_LEFTBRACKET=44;
    public static final int SG_LEFTMIDBRACKET=45;
    public static final int SG_RIGHTANNOTATE=46;
    public static final int SG_RIGHTBIGBRACKET=47;
    public static final int SG_RIGHTBRACKET=48;
    public static final int SG_RIGHTMIDBRACKET=49;
    public static final int SG_SEMICOLON=50;
    public static final int STAT=51;
    public static final int TP_INT=52;
    public static final int TP_REAL=53;
    public static final int TRUE=54;
    public static final int WHILE=55;
    public static final int WRITE=56;
    public static final int WS=57;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ASTLexer() {} 
    public ASTLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ASTLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\��ҵ\\AST.g"; }

    // $ANTLR start "KW_IF"
    public final void mKW_IF() throws RecognitionException {
        try {
            int _type = KW_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\AST.g:127:7: ( 'if' )
            // D:\\��ҵ\\AST.g:127:9: 'if'
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
            // D:\\��ҵ\\AST.g:129:9: ( 'else' )
            // D:\\��ҵ\\AST.g:129:11: 'else'
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
            // D:\\��ҵ\\AST.g:131:10: ( 'while' )
            // D:\\��ҵ\\AST.g:131:12: 'while'
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
            // D:\\��ҵ\\AST.g:133:10: ( 'break' )
            // D:\\��ҵ\\AST.g:133:12: 'break'
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
            // D:\\��ҵ\\AST.g:135:9: ( 'read' )
            // D:\\��ҵ\\AST.g:135:11: 'read'
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
            // D:\\��ҵ\\AST.g:137:10: ( 'write' )
            // D:\\��ҵ\\AST.g:137:12: 'write'
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
            // D:\\��ҵ\\AST.g:139:6: ( 'true' )
            // D:\\��ҵ\\AST.g:139:8: 'true'
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
            // D:\\��ҵ\\AST.g:141:7: ( 'false' )
            // D:\\��ҵ\\AST.g:141:9: 'false'
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
            // D:\\��ҵ\\AST.g:145:9: ( '+' )
            // D:\\��ҵ\\AST.g:145:11: '+'
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
            // D:\\��ҵ\\AST.g:147:10: ( '-' )
            // D:\\��ҵ\\AST.g:147:12: '-'
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
            // D:\\��ҵ\\AST.g:149:13: ( '*' )
            // D:\\��ҵ\\AST.g:149:15: '*'
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
            // D:\\��ҵ\\AST.g:151:11: ( '/' )
            // D:\\��ҵ\\AST.g:151:13: '/'
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
            // D:\\��ҵ\\AST.g:155:13: ( '>' )
            // D:\\��ҵ\\AST.g:155:15: '>'
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
            // D:\\��ҵ\\AST.g:157:13: ( '<' )
            // D:\\��ҵ\\AST.g:157:15: '<'
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
            // D:\\��ҵ\\AST.g:159:12: ( '<>' )
            // D:\\��ҵ\\AST.g:159:14: '<>'
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
            // D:\\��ҵ\\AST.g:161:10: ( '==' )
            // D:\\��ҵ\\AST.g:161:12: '=='
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
            // D:\\��ҵ\\AST.g:163:16: ( '<=' )
            // D:\\��ҵ\\AST.g:163:18: '<='
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
            // D:\\��ҵ\\AST.g:165:16: ( '>=' )
            // D:\\��ҵ\\AST.g:165:18: '>='
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
            // D:\\��ҵ\\AST.g:169:8: ( '&&' )
            // D:\\��ҵ\\AST.g:169:10: '&&'
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
            // D:\\��ҵ\\AST.g:171:7: ( '||' )
            // D:\\��ҵ\\AST.g:171:9: '||'
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
            // D:\\��ҵ\\AST.g:173:9: ( '!' )
            // D:\\��ҵ\\AST.g:173:11: '!'
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
            // D:\\��ҵ\\AST.g:177:10: ( ':' )
            // D:\\��ҵ\\AST.g:177:12: ':'
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
            // D:\\��ҵ\\AST.g:179:14: ( ';' )
            // D:\\��ҵ\\AST.g:179:16: ';'
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
            // D:\\��ҵ\\AST.g:181:16: ( '(' )
            // D:\\��ҵ\\AST.g:181:18: '('
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
            // D:\\��ҵ\\AST.g:183:17: ( ')' )
            // D:\\��ҵ\\AST.g:183:19: ')'
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
            // D:\\��ҵ\\AST.g:185:19: ( '[' )
            // D:\\��ҵ\\AST.g:185:21: '['
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
            // D:\\��ҵ\\AST.g:187:20: ( ']' )
            // D:\\��ҵ\\AST.g:187:22: ']'
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
            // D:\\��ҵ\\AST.g:189:19: ( '{' )
            // D:\\��ҵ\\AST.g:189:21: '{'
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
            // D:\\��ҵ\\AST.g:191:20: ( '}' )
            // D:\\��ҵ\\AST.g:191:22: '}'
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
            // D:\\��ҵ\\AST.g:193:13: ( '//' )
            // D:\\��ҵ\\AST.g:193:15: '//'
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
            // D:\\��ҵ\\AST.g:195:17: ( '/*' )
            // D:\\��ҵ\\AST.g:195:19: '/*'
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
            // D:\\��ҵ\\AST.g:197:18: ( '*/' )
            // D:\\��ҵ\\AST.g:197:20: '*/'
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
            // D:\\��ҵ\\AST.g:199:11: ( '=' )
            // D:\\��ҵ\\AST.g:199:13: '='
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

    // $ANTLR start "TP_INT"
    public final void mTP_INT() throws RecognitionException {
        try {
            int _type = TP_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\AST.g:202:8: ( 'int' )
            // D:\\��ҵ\\AST.g:202:10: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TP_INT"

    // $ANTLR start "TP_REAL"
    public final void mTP_REAL() throws RecognitionException {
        try {
            int _type = TP_REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\AST.g:204:9: ( 'real' )
            // D:\\��ҵ\\AST.g:204:11: 'real'
            {
            match("real"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TP_REAL"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\AST.g:206:5: ( ( '0' .. '9' )+ )
            // D:\\��ҵ\\AST.g:206:7: ( '0' .. '9' )+
            {
            // D:\\��ҵ\\AST.g:206:7: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:
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
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
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
            // D:\\��ҵ\\AST.g:208:6: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
            // D:\\��ҵ\\AST.g:208:8: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
            {
            // D:\\��ҵ\\AST.g:208:8: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            // D:\\��ҵ\\AST.g:208:21: ( '.' ( '0' .. '9' )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // D:\\��ҵ\\AST.g:208:22: '.' ( '0' .. '9' )+
                    {
                    match('.'); 

                    // D:\\��ҵ\\AST.g:208:25: ( '0' .. '9' )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\��ҵ\\AST.g:
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
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
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
            // D:\\��ҵ\\AST.g:210:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // D:\\��ҵ\\AST.g:210:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // D:\\��ҵ\\AST.g:210:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\��ҵ\\AST.g:212:4: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) | ( 'a' .. 'z' | 'A' .. 'Z' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0 >= 'A' && LA7_0 <= 'Z')||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                int LA7_1 = input.LA(2);

                if ( ((LA7_1 >= '0' && LA7_1 <= '9')||(LA7_1 >= 'A' && LA7_1 <= 'Z')||LA7_1=='_'||(LA7_1 >= 'a' && LA7_1 <= 'z')) ) {
                    alt7=1;
                }
                else {
                    alt7=2;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // D:\\��ҵ\\AST.g:212:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
                    {
                    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // D:\\��ҵ\\AST.g:212:30: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                            int LA6_1 = input.LA(2);

                            if ( ((LA6_1 >= '0' && LA6_1 <= '9')||(LA6_1 >= 'A' && LA6_1 <= 'Z')||LA6_1=='_'||(LA6_1 >= 'a' && LA6_1 <= 'z')) ) {
                                alt6=1;
                            }


                        }
                        else if ( (LA6_0=='_') ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\��ҵ\\AST.g:
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
                    	    break loop6;
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
                    // D:\\��ҵ\\AST.g:212:109: ( 'a' .. 'z' | 'A' .. 'Z' )
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

    public void mTokens() throws RecognitionException {
        // D:\\��ҵ\\AST.g:1:8: ( KW_IF | KW_ELSE | KW_WHILE | KW_BREAK | KW_READ | KW_WRITE | TRUE | FALSE | OP_PLUS | OP_MINUS | OP_MULTIPLY | OP_DIVIDE | OP_MORETHAN | OP_LESSTHAN | OP_UNEQUAL | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN | OP_AND | OP_OR | OP_NON | SG_COLON | SG_SEMICOLON | SG_LEFTBRACKET | SG_RIGHTBRACKET | SG_LEFTMIDBRACKET | SG_RIGHTMIDBRACKET | SG_LEFTBIGBRACKET | SG_RIGHTBIGBRACKET | SG_ANNOTATE | SG_LEFTANNOTATE | SG_RIGHTANNOTATE | SG_ASSIGN | TP_INT | TP_REAL | INT | REAL | WS | ID )
        int alt8=39;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // D:\\��ҵ\\AST.g:1:10: KW_IF
                {
                mKW_IF(); 


                }
                break;
            case 2 :
                // D:\\��ҵ\\AST.g:1:16: KW_ELSE
                {
                mKW_ELSE(); 


                }
                break;
            case 3 :
                // D:\\��ҵ\\AST.g:1:24: KW_WHILE
                {
                mKW_WHILE(); 


                }
                break;
            case 4 :
                // D:\\��ҵ\\AST.g:1:33: KW_BREAK
                {
                mKW_BREAK(); 


                }
                break;
            case 5 :
                // D:\\��ҵ\\AST.g:1:42: KW_READ
                {
                mKW_READ(); 


                }
                break;
            case 6 :
                // D:\\��ҵ\\AST.g:1:50: KW_WRITE
                {
                mKW_WRITE(); 


                }
                break;
            case 7 :
                // D:\\��ҵ\\AST.g:1:59: TRUE
                {
                mTRUE(); 


                }
                break;
            case 8 :
                // D:\\��ҵ\\AST.g:1:64: FALSE
                {
                mFALSE(); 


                }
                break;
            case 9 :
                // D:\\��ҵ\\AST.g:1:70: OP_PLUS
                {
                mOP_PLUS(); 


                }
                break;
            case 10 :
                // D:\\��ҵ\\AST.g:1:78: OP_MINUS
                {
                mOP_MINUS(); 


                }
                break;
            case 11 :
                // D:\\��ҵ\\AST.g:1:87: OP_MULTIPLY
                {
                mOP_MULTIPLY(); 


                }
                break;
            case 12 :
                // D:\\��ҵ\\AST.g:1:99: OP_DIVIDE
                {
                mOP_DIVIDE(); 


                }
                break;
            case 13 :
                // D:\\��ҵ\\AST.g:1:109: OP_MORETHAN
                {
                mOP_MORETHAN(); 


                }
                break;
            case 14 :
                // D:\\��ҵ\\AST.g:1:121: OP_LESSTHAN
                {
                mOP_LESSTHAN(); 


                }
                break;
            case 15 :
                // D:\\��ҵ\\AST.g:1:133: OP_UNEQUAL
                {
                mOP_UNEQUAL(); 


                }
                break;
            case 16 :
                // D:\\��ҵ\\AST.g:1:144: OP_EQUAL
                {
                mOP_EQUAL(); 


                }
                break;
            case 17 :
                // D:\\��ҵ\\AST.g:1:153: OP_NOTMORETHAN
                {
                mOP_NOTMORETHAN(); 


                }
                break;
            case 18 :
                // D:\\��ҵ\\AST.g:1:168: OP_NOTLESSTHAN
                {
                mOP_NOTLESSTHAN(); 


                }
                break;
            case 19 :
                // D:\\��ҵ\\AST.g:1:183: OP_AND
                {
                mOP_AND(); 


                }
                break;
            case 20 :
                // D:\\��ҵ\\AST.g:1:190: OP_OR
                {
                mOP_OR(); 


                }
                break;
            case 21 :
                // D:\\��ҵ\\AST.g:1:196: OP_NON
                {
                mOP_NON(); 


                }
                break;
            case 22 :
                // D:\\��ҵ\\AST.g:1:203: SG_COLON
                {
                mSG_COLON(); 


                }
                break;
            case 23 :
                // D:\\��ҵ\\AST.g:1:212: SG_SEMICOLON
                {
                mSG_SEMICOLON(); 


                }
                break;
            case 24 :
                // D:\\��ҵ\\AST.g:1:225: SG_LEFTBRACKET
                {
                mSG_LEFTBRACKET(); 


                }
                break;
            case 25 :
                // D:\\��ҵ\\AST.g:1:240: SG_RIGHTBRACKET
                {
                mSG_RIGHTBRACKET(); 


                }
                break;
            case 26 :
                // D:\\��ҵ\\AST.g:1:256: SG_LEFTMIDBRACKET
                {
                mSG_LEFTMIDBRACKET(); 


                }
                break;
            case 27 :
                // D:\\��ҵ\\AST.g:1:274: SG_RIGHTMIDBRACKET
                {
                mSG_RIGHTMIDBRACKET(); 


                }
                break;
            case 28 :
                // D:\\��ҵ\\AST.g:1:293: SG_LEFTBIGBRACKET
                {
                mSG_LEFTBIGBRACKET(); 


                }
                break;
            case 29 :
                // D:\\��ҵ\\AST.g:1:311: SG_RIGHTBIGBRACKET
                {
                mSG_RIGHTBIGBRACKET(); 


                }
                break;
            case 30 :
                // D:\\��ҵ\\AST.g:1:330: SG_ANNOTATE
                {
                mSG_ANNOTATE(); 


                }
                break;
            case 31 :
                // D:\\��ҵ\\AST.g:1:342: SG_LEFTANNOTATE
                {
                mSG_LEFTANNOTATE(); 


                }
                break;
            case 32 :
                // D:\\��ҵ\\AST.g:1:358: SG_RIGHTANNOTATE
                {
                mSG_RIGHTANNOTATE(); 


                }
                break;
            case 33 :
                // D:\\��ҵ\\AST.g:1:375: SG_ASSIGN
                {
                mSG_ASSIGN(); 


                }
                break;
            case 34 :
                // D:\\��ҵ\\AST.g:1:385: TP_INT
                {
                mTP_INT(); 


                }
                break;
            case 35 :
                // D:\\��ҵ\\AST.g:1:392: TP_REAL
                {
                mTP_REAL(); 


                }
                break;
            case 36 :
                // D:\\��ҵ\\AST.g:1:400: INT
                {
                mINT(); 


                }
                break;
            case 37 :
                // D:\\��ҵ\\AST.g:1:404: REAL
                {
                mREAL(); 


                }
                break;
            case 38 :
                // D:\\��ҵ\\AST.g:1:409: WS
                {
                mWS(); 


                }
                break;
            case 39 :
                // D:\\��ҵ\\AST.g:1:412: ID
                {
                mID(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\7\34\2\uffff\1\47\1\52\1\54\1\57\1\61\13\uffff\1\62\2\uffff"+
        "\1\64\10\34\17\uffff\1\75\7\34\1\uffff\1\106\3\34\1\112\1\113\1"+
        "\114\1\34\1\uffff\1\116\1\117\1\120\3\uffff\1\121\4\uffff";
    static final String DFA8_eofS =
        "\122\uffff";
    static final String DFA8_minS =
        "\1\11\1\146\1\154\1\150\1\162\1\145\1\162\1\141\2\uffff\1\57\1\52"+
        "\3\75\13\uffff\1\56\2\uffff\1\60\1\164\1\163\2\151\1\145\1\141\1"+
        "\165\1\154\17\uffff\1\60\1\145\1\154\1\164\1\141\1\144\1\145\1\163"+
        "\1\uffff\1\60\2\145\1\153\3\60\1\145\1\uffff\3\60\3\uffff\1\60\4"+
        "\uffff";
    static final String DFA8_maxS =
        "\1\175\1\156\1\154\2\162\1\145\1\162\1\141\2\uffff\2\57\1\75\1\76"+
        "\1\75\13\uffff\1\71\2\uffff\1\172\1\164\1\163\2\151\1\145\1\141"+
        "\1\165\1\154\17\uffff\1\172\1\145\1\154\1\164\1\141\1\154\1\145"+
        "\1\163\1\uffff\1\172\2\145\1\153\3\172\1\145\1\uffff\3\172\3\uffff"+
        "\1\172\4\uffff";
    static final String DFA8_acceptS =
        "\10\uffff\1\11\1\12\5\uffff\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1"+
        "\32\1\33\1\34\1\35\1\uffff\1\46\1\47\11\uffff\1\40\1\13\1\36\1\37"+
        "\1\14\1\22\1\15\1\17\1\21\1\16\1\20\1\41\1\44\1\45\1\1\10\uffff"+
        "\1\42\10\uffff\1\2\3\uffff\1\5\1\43\1\7\1\uffff\1\3\1\6\1\4\1\10";
    static final String DFA8_specialS =
        "\122\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\33\2\uffff\1\33\22\uffff\1\33\1\21\4\uffff\1\17\1\uffff\1"+
            "\24\1\25\1\12\1\10\1\uffff\1\11\1\uffff\1\13\12\32\1\22\1\23"+
            "\1\15\1\16\1\14\2\uffff\32\34\1\26\1\uffff\1\27\3\uffff\1\34"+
            "\1\4\2\34\1\2\1\7\2\34\1\1\10\34\1\5\1\34\1\6\2\34\1\3\3\34"+
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
            "\1\63\1\uffff\12\32",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
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
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102\7\uffff\1\103",
            "\1\104",
            "\1\105",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\107",
            "\1\110",
            "\1\111",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\1\115",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            "\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( KW_IF | KW_ELSE | KW_WHILE | KW_BREAK | KW_READ | KW_WRITE | TRUE | FALSE | OP_PLUS | OP_MINUS | OP_MULTIPLY | OP_DIVIDE | OP_MORETHAN | OP_LESSTHAN | OP_UNEQUAL | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN | OP_AND | OP_OR | OP_NON | SG_COLON | SG_SEMICOLON | SG_LEFTBRACKET | SG_RIGHTBRACKET | SG_LEFTMIDBRACKET | SG_RIGHTMIDBRACKET | SG_LEFTBIGBRACKET | SG_RIGHTBIGBRACKET | SG_ANNOTATE | SG_LEFTANNOTATE | SG_RIGHTANNOTATE | SG_ASSIGN | TP_INT | TP_REAL | INT | REAL | WS | ID );";
        }
    }
 

}