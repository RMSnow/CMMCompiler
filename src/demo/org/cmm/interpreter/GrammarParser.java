// $ANTLR 3.4 D:\\��ҵ\\Grammar.g 2011-12-26 22:01:30

	package demo.org.cmm.interpreter;


import org.antlr.runtime.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class GrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FALSE", "ID", "INT", "KW_BREAK", "KW_ELSE", "KW_IF", "KW_READ", "KW_WHILE", "KW_WRITE", "OP_AND", "OP_DIVIDE", "OP_EQUAL", "OP_LESSTHAN", "OP_MINUS", "OP_MORETHAN", "OP_MULTIPLY", "OP_NON", "OP_NOTLESSTHAN", "OP_NOTMORETHAN", "OP_OR", "OP_PLUS", "OP_UNEQUAL", "REAL", "SG_ANNOTATE", "SG_ASSIGN", "SG_COLON", "SG_LEFTANNOTATE", "SG_LEFTBIGBRACKET", "SG_LEFTBRACKET", "SG_LEFTMIDBRACKET", "SG_RIGHTANNOTATE", "SG_RIGHTBIGBRACKET", "SG_RIGHTBRACKET", "SG_RIGHTMIDBRACKET", "SG_SEMICOLON", "TRUE", "TYPE", "WS"
    };

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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public GrammarParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public GrammarParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return GrammarParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\��ҵ\\Grammar.g"; }


    	public StringBuffer log = new StringBuffer();
    	public void log(String s){
        		this.log.append(s+"\n");
        	}
    	public void reportError(RecognitionException e){
    		if ( state.errorRecovery ) {
    			//System.err.print("[SPURIOUS] ");
    			return;
    		}
    		state.syntaxErrors++; // don't count spurious
    		state.errorRecovery = true;

    		String hdr = getErrorHeader(e);
    		String msg = getErrorMessage(e, this.getTokenNames());
    		emitErrorMessage(hdr+" "+msg);
    	}



    // $ANTLR start "prog"
    // D:\\��ҵ\\Grammar.g:97:1: prog : ( stat )* ;
    public final void prog() throws RecognitionException {

        int lineNum=input.LT(1).getLine();

        try {
            // D:\\��ҵ\\Grammar.g:101:2: ( ( stat )* )
            // D:\\��ҵ\\Grammar.g:101:4: ( stat )*
            {
            // D:\\��ҵ\\Grammar.g:101:4: ( stat )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==KW_BREAK||(LA1_0 >= KW_IF && LA1_0 <= KW_WRITE)||LA1_0==TYPE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:101:4: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog42);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            this.log("Grammar analysis done!");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "stat"
    // D:\\��ҵ\\Grammar.g:104:1: stat : ( sequenceStructure | ifClause | whileClause | breakClause );
    public final void stat() throws RecognitionException {

        int lineNum=input.LT(1).getLine();

        try {
            // D:\\��ҵ\\Grammar.g:108:2: ( sequenceStructure | ifClause | whileClause | breakClause )
            int alt2=4;
            switch ( input.LA(1) ) {
            case ID:
            case KW_READ:
            case KW_WRITE:
            case TYPE:
                {
                alt2=1;
                }
                break;
            case KW_IF:
                {
                alt2=2;
                }
                break;
            case KW_WHILE:
                {
                alt2=3;
                }
                break;
            case KW_BREAK:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:108:4: sequenceStructure
                    {
                    pushFollow(FOLLOW_sequenceStructure_in_stat60);
                    sequenceStructure();

                    state._fsp--;


                    this.log(lineNum + ":MATCH Sequence Structure ");

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Grammar.g:109:5: ifClause
                    {
                    pushFollow(FOLLOW_ifClause_in_stat69);
                    ifClause();

                    state._fsp--;


                    this.log(lineNum + ":MATCH If Clause ");

                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\Grammar.g:110:5: whileClause
                    {
                    pushFollow(FOLLOW_whileClause_in_stat78);
                    whileClause();

                    state._fsp--;


                    this.log(lineNum + ":MATCH While Clause ");

                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\Grammar.g:111:5: breakClause
                    {
                    pushFollow(FOLLOW_breakClause_in_stat86);
                    breakClause();

                    state._fsp--;


                    this.log(lineNum + ":MATCH Break Clause ");

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "stat"



    // $ANTLR start "bool"
    // D:\\��ҵ\\Grammar.g:114:1: bool : expr ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) expr )? ;
    public final void bool() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:114:6: ( expr ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) expr )? )
            // D:\\��ҵ\\Grammar.g:114:8: expr ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) expr )?
            {
            pushFollow(FOLLOW_expr_in_bool101);
            expr();

            state._fsp--;


            // D:\\��ҵ\\Grammar.g:114:13: ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) expr )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= OP_EQUAL && LA3_0 <= OP_LESSTHAN)||LA3_0==OP_MORETHAN||(LA3_0 >= OP_NOTLESSTHAN && LA3_0 <= OP_NOTMORETHAN)||LA3_0==OP_UNEQUAL) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:114:15: ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) expr
                    {
                    if ( (input.LA(1) >= OP_EQUAL && input.LA(1) <= OP_LESSTHAN)||input.LA(1)==OP_MORETHAN||(input.LA(1) >= OP_NOTLESSTHAN && input.LA(1) <= OP_NOTMORETHAN)||input.LA(1)==OP_UNEQUAL ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_expr_in_bool131);
                    expr();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "bool"



    // $ANTLR start "boolExpr"
    // D:\\��ҵ\\Grammar.g:120:1: boolExpr : logicOr ;
    public final void boolExpr() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:120:10: ( logicOr )
            // D:\\��ҵ\\Grammar.g:120:12: logicOr
            {
            pushFollow(FOLLOW_logicOr_in_boolExpr146);
            logicOr();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "boolExpr"



    // $ANTLR start "expr"
    // D:\\��ҵ\\Grammar.g:123:1: expr : multExpr ( ( OP_PLUS | OP_MINUS ) multExpr )* ;
    public final void expr() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:123:6: ( multExpr ( ( OP_PLUS | OP_MINUS ) multExpr )* )
            // D:\\��ҵ\\Grammar.g:123:8: multExpr ( ( OP_PLUS | OP_MINUS ) multExpr )*
            {
            pushFollow(FOLLOW_multExpr_in_expr155);
            multExpr();

            state._fsp--;


            // D:\\��ҵ\\Grammar.g:123:17: ( ( OP_PLUS | OP_MINUS ) multExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==OP_MINUS||LA4_0==OP_PLUS) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:123:19: ( OP_PLUS | OP_MINUS ) multExpr
            	    {
            	    if ( input.LA(1)==OP_MINUS||input.LA(1)==OP_PLUS ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_multExpr_in_expr169);
            	    multExpr();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "expr"



    // $ANTLR start "multExpr"
    // D:\\��ҵ\\Grammar.g:126:1: multExpr : atom ( ( OP_MULTIPLY | OP_DIVIDE ) atom )* ;
    public final void multExpr() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:126:10: ( atom ( ( OP_MULTIPLY | OP_DIVIDE ) atom )* )
            // D:\\��ҵ\\Grammar.g:126:12: atom ( ( OP_MULTIPLY | OP_DIVIDE ) atom )*
            {
            pushFollow(FOLLOW_atom_in_multExpr183);
            atom();

            state._fsp--;


            // D:\\��ҵ\\Grammar.g:126:17: ( ( OP_MULTIPLY | OP_DIVIDE ) atom )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==OP_DIVIDE||LA5_0==OP_MULTIPLY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:126:19: ( OP_MULTIPLY | OP_DIVIDE ) atom
            	    {
            	    if ( input.LA(1)==OP_DIVIDE||input.LA(1)==OP_MULTIPLY ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_atom_in_multExpr197);
            	    atom();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "multExpr"



    // $ANTLR start "atom"
    // D:\\��ҵ\\Grammar.g:129:1: atom : ( SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET | INT | REAL | ID | TRUE | FALSE | array );
    public final void atom() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:129:5: ( SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET | INT | REAL | ID | TRUE | FALSE | array )
            int alt6=7;
            switch ( input.LA(1) ) {
            case SG_LEFTBRACKET:
                {
                alt6=1;
                }
                break;
            case INT:
                {
                alt6=2;
                }
                break;
            case REAL:
                {
                alt6=3;
                }
                break;
            case ID:
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4==SG_LEFTMIDBRACKET) ) {
                    alt6=7;
                }
                else if ( (LA6_4==EOF||(LA6_4 >= OP_AND && LA6_4 <= OP_MULTIPLY)||(LA6_4 >= OP_NOTLESSTHAN && LA6_4 <= OP_UNEQUAL)||(LA6_4 >= SG_RIGHTBRACKET && LA6_4 <= SG_SEMICOLON)) ) {
                    alt6=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 4, input);

                    throw nvae;

                }
                }
                break;
            case TRUE:
                {
                alt6=5;
                }
                break;
            case FALSE:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:129:7: SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET
                    {
                    match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_atom210); 

                    pushFollow(FOLLOW_boolExpr_in_atom212);
                    boolExpr();

                    state._fsp--;


                    match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_atom214); 

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Grammar.g:130:4: INT
                    {
                    match(input,INT,FOLLOW_INT_in_atom220); 

                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\Grammar.g:131:4: REAL
                    {
                    match(input,REAL,FOLLOW_REAL_in_atom226); 

                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\Grammar.g:132:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_atom231); 

                    }
                    break;
                case 5 :
                    // D:\\��ҵ\\Grammar.g:133:4: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_atom237); 

                    }
                    break;
                case 6 :
                    // D:\\��ҵ\\Grammar.g:134:4: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_atom242); 

                    }
                    break;
                case 7 :
                    // D:\\��ҵ\\Grammar.g:135:4: array
                    {
                    pushFollow(FOLLOW_array_in_atom247);
                    array();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "atom"



    // $ANTLR start "logicOr"
    // D:\\��ҵ\\Grammar.g:138:1: logicOr : logicAnd ( OP_OR logicAnd )* ;
    public final void logicOr() throws RecognitionException {

        int lineNum=input.LT(1).getLine();

        try {
            // D:\\��ҵ\\Grammar.g:142:2: ( logicAnd ( OP_OR logicAnd )* )
            // D:\\��ҵ\\Grammar.g:142:4: logicAnd ( OP_OR logicAnd )*
            {
            pushFollow(FOLLOW_logicAnd_in_logicOr262);
            logicAnd();

            state._fsp--;


            // D:\\��ҵ\\Grammar.g:142:13: ( OP_OR logicAnd )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==OP_OR) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:142:15: OP_OR logicAnd
            	    {
            	    match(input,OP_OR,FOLLOW_OP_OR_in_logicOr266); 

            	    pushFollow(FOLLOW_logicAnd_in_logicOr268);
            	    logicAnd();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            this.log(lineNum + ":MATCH Logic Expression Or ");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logicOr"



    // $ANTLR start "logicAnd"
    // D:\\��ҵ\\Grammar.g:145:1: logicAnd : logicAtom ( OP_AND logicAtom )* ;
    public final void logicAnd() throws RecognitionException {

        int lineNum=input.LT(1).getLine();

        try {
            // D:\\��ҵ\\Grammar.g:149:2: ( logicAtom ( OP_AND logicAtom )* )
            // D:\\��ҵ\\Grammar.g:149:4: logicAtom ( OP_AND logicAtom )*
            {
            pushFollow(FOLLOW_logicAtom_in_logicAnd287);
            logicAtom();

            state._fsp--;


            // D:\\��ҵ\\Grammar.g:149:14: ( OP_AND logicAtom )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==OP_AND) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:149:16: OP_AND logicAtom
            	    {
            	    match(input,OP_AND,FOLLOW_OP_AND_in_logicAnd291); 

            	    pushFollow(FOLLOW_logicAtom_in_logicAnd293);
            	    logicAtom();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            this.log(lineNum + ":MATCH Logic Expression And ");

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logicAnd"



    // $ANTLR start "logicAtom"
    // D:\\��ҵ\\Grammar.g:155:1: logicAtom : ( bool | OP_NON bool );
    public final void logicAtom() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:155:11: ( bool | OP_NON bool )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0 >= FALSE && LA9_0 <= INT)||LA9_0==REAL||LA9_0==SG_LEFTBRACKET||LA9_0==TRUE) ) {
                alt9=1;
            }
            else if ( (LA9_0==OP_NON) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:155:13: bool
                    {
                    pushFollow(FOLLOW_bool_in_logicAtom311);
                    bool();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Grammar.g:156:4: OP_NON bool
                    {
                    match(input,OP_NON,FOLLOW_OP_NON_in_logicAtom316); 

                    pushFollow(FOLLOW_bool_in_logicAtom318);
                    bool();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "logicAtom"



    // $ANTLR start "nonExpr"
    // D:\\��ҵ\\Grammar.g:159:1: nonExpr : OP_NON expr ;
    public final void nonExpr() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:159:9: ( OP_NON expr )
            // D:\\��ҵ\\Grammar.g:159:11: OP_NON expr
            {
            match(input,OP_NON,FOLLOW_OP_NON_in_nonExpr327); 

            pushFollow(FOLLOW_expr_in_nonExpr329);
            expr();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "nonExpr"



    // $ANTLR start "notes"
    // D:\\��ҵ\\Grammar.g:163:1: notes : SG_LEFTANNOTATE ( stat )* SG_RIGHTANNOTATE ;
    public final void notes() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:163:7: ( SG_LEFTANNOTATE ( stat )* SG_RIGHTANNOTATE )
            // D:\\��ҵ\\Grammar.g:163:9: SG_LEFTANNOTATE ( stat )* SG_RIGHTANNOTATE
            {
            match(input,SG_LEFTANNOTATE,FOLLOW_SG_LEFTANNOTATE_in_notes342); 

            // D:\\��ҵ\\Grammar.g:163:25: ( stat )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ID||LA10_0==KW_BREAK||(LA10_0 >= KW_IF && LA10_0 <= KW_WRITE)||LA10_0==TYPE) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:163:25: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_notes344);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input,SG_RIGHTANNOTATE,FOLLOW_SG_RIGHTANNOTATE_in_notes347); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "notes"



    // $ANTLR start "sequenceStructure"
    // D:\\��ҵ\\Grammar.g:166:1: sequenceStructure : ( defineVariable | initiateVariable | defineArray | initiateArray | read | write );
    public final void sequenceStructure() throws RecognitionException {

        int lineNum=input.LT(1).getLine();

        try {
            // D:\\��ҵ\\Grammar.g:170:2: ( defineVariable | initiateVariable | defineArray | initiateArray | read | write )
            int alt11=6;
            switch ( input.LA(1) ) {
            case TYPE:
                {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==ID) ) {
                    int LA11_5 = input.LA(3);

                    if ( (LA11_5==SG_LEFTMIDBRACKET) ) {
                        alt11=3;
                    }
                    else if ( (LA11_5==SG_ASSIGN||LA11_5==SG_SEMICOLON) ) {
                        alt11=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 5, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA11_2 = input.LA(2);

                if ( (LA11_2==SG_ASSIGN) ) {
                    alt11=2;
                }
                else if ( (LA11_2==SG_LEFTMIDBRACKET) ) {
                    alt11=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;

                }
                }
                break;
            case KW_READ:
                {
                alt11=5;
                }
                break;
            case KW_WRITE:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:170:4: defineVariable
                    {
                    pushFollow(FOLLOW_defineVariable_in_sequenceStructure363);
                    defineVariable();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Grammar.g:171:5: initiateVariable
                    {
                    pushFollow(FOLLOW_initiateVariable_in_sequenceStructure369);
                    initiateVariable();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\Grammar.g:172:5: defineArray
                    {
                    pushFollow(FOLLOW_defineArray_in_sequenceStructure375);
                    defineArray();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\Grammar.g:173:5: initiateArray
                    {
                    pushFollow(FOLLOW_initiateArray_in_sequenceStructure383);
                    initiateArray();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\��ҵ\\Grammar.g:174:5: read
                    {
                    pushFollow(FOLLOW_read_in_sequenceStructure389);
                    read();

                    state._fsp--;


                    this.log(lineNum + ":MATCH Read Statement");

                    }
                    break;
                case 6 :
                    // D:\\��ҵ\\Grammar.g:175:5: write
                    {
                    pushFollow(FOLLOW_write_in_sequenceStructure397);
                    write();

                    state._fsp--;


                    this.log(lineNum + ":MATCH Write Statement");

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "sequenceStructure"



    // $ANTLR start "defineVariable"
    // D:\\��ҵ\\Grammar.g:178:1: defineVariable : TYPE ID ( SG_ASSIGN boolExpr )? SG_SEMICOLON ;
    public final void defineVariable() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:178:16: ( TYPE ID ( SG_ASSIGN boolExpr )? SG_SEMICOLON )
            // D:\\��ҵ\\Grammar.g:178:18: TYPE ID ( SG_ASSIGN boolExpr )? SG_SEMICOLON
            {
            match(input,TYPE,FOLLOW_TYPE_in_defineVariable408); 

            match(input,ID,FOLLOW_ID_in_defineVariable410); 

            // D:\\��ҵ\\Grammar.g:178:26: ( SG_ASSIGN boolExpr )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==SG_ASSIGN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:178:28: SG_ASSIGN boolExpr
                    {
                    match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_defineVariable414); 

                    pushFollow(FOLLOW_boolExpr_in_defineVariable416);
                    boolExpr();

                    state._fsp--;


                    }
                    break;

            }


            match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_defineVariable421); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defineVariable"



    // $ANTLR start "initiateVariable"
    // D:\\��ҵ\\Grammar.g:181:1: initiateVariable : ID SG_ASSIGN boolExpr SG_SEMICOLON ;
    public final void initiateVariable() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:181:18: ( ID SG_ASSIGN boolExpr SG_SEMICOLON )
            // D:\\��ҵ\\Grammar.g:181:20: ID SG_ASSIGN boolExpr SG_SEMICOLON
            {
            match(input,ID,FOLLOW_ID_in_initiateVariable430); 

            match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_initiateVariable432); 

            pushFollow(FOLLOW_boolExpr_in_initiateVariable434);
            boolExpr();

            state._fsp--;


            match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_initiateVariable436); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "initiateVariable"



    // $ANTLR start "defineArray"
    // D:\\��ҵ\\Grammar.g:184:1: defineArray : TYPE ID SG_LEFTMIDBRACKET INT SG_RIGHTMIDBRACKET SG_SEMICOLON ;
    public final void defineArray() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:184:13: ( TYPE ID SG_LEFTMIDBRACKET INT SG_RIGHTMIDBRACKET SG_SEMICOLON )
            // D:\\��ҵ\\Grammar.g:184:15: TYPE ID SG_LEFTMIDBRACKET INT SG_RIGHTMIDBRACKET SG_SEMICOLON
            {
            match(input,TYPE,FOLLOW_TYPE_in_defineArray445); 

            match(input,ID,FOLLOW_ID_in_defineArray447); 

            match(input,SG_LEFTMIDBRACKET,FOLLOW_SG_LEFTMIDBRACKET_in_defineArray449); 

            match(input,INT,FOLLOW_INT_in_defineArray451); 

            match(input,SG_RIGHTMIDBRACKET,FOLLOW_SG_RIGHTMIDBRACKET_in_defineArray453); 

            match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_defineArray455); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "defineArray"



    // $ANTLR start "initiateArray"
    // D:\\��ҵ\\Grammar.g:187:1: initiateArray : array SG_ASSIGN boolExpr SG_SEMICOLON ;
    public final void initiateArray() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:187:15: ( array SG_ASSIGN boolExpr SG_SEMICOLON )
            // D:\\��ҵ\\Grammar.g:187:17: array SG_ASSIGN boolExpr SG_SEMICOLON
            {
            pushFollow(FOLLOW_array_in_initiateArray466);
            array();

            state._fsp--;


            match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_initiateArray468); 

            pushFollow(FOLLOW_boolExpr_in_initiateArray470);
            boolExpr();

            state._fsp--;


            match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_initiateArray472); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "initiateArray"



    // $ANTLR start "ifClause"
    // D:\\��ҵ\\Grammar.g:193:1: ifClause : KW_IF SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET ( KW_ELSE SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET )? ;
    public final void ifClause() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:193:10: ( KW_IF SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET ( KW_ELSE SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET )? )
            // D:\\��ҵ\\Grammar.g:193:12: KW_IF SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET ( KW_ELSE SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET )?
            {
            match(input,KW_IF,FOLLOW_KW_IF_in_ifClause486); 

            match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_ifClause488); 

            pushFollow(FOLLOW_boolExpr_in_ifClause490);
            boolExpr();

            state._fsp--;


            match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_ifClause492); 

            match(input,SG_LEFTBIGBRACKET,FOLLOW_SG_LEFTBIGBRACKET_in_ifClause494); 

            // D:\\��ҵ\\Grammar.g:193:76: ( stat )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==ID||LA13_0==KW_BREAK||(LA13_0 >= KW_IF && LA13_0 <= KW_WRITE)||LA13_0==TYPE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:193:77: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_ifClause497);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            match(input,SG_RIGHTBIGBRACKET,FOLLOW_SG_RIGHTBIGBRACKET_in_ifClause501); 

            // D:\\��ҵ\\Grammar.g:193:103: ( KW_ELSE SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==KW_ELSE) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:193:105: KW_ELSE SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET
                    {
                    match(input,KW_ELSE,FOLLOW_KW_ELSE_in_ifClause505); 

                    match(input,SG_LEFTBIGBRACKET,FOLLOW_SG_LEFTBIGBRACKET_in_ifClause507); 

                    // D:\\��ҵ\\Grammar.g:193:131: ( stat )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==ID||LA14_0==KW_BREAK||(LA14_0 >= KW_IF && LA14_0 <= KW_WRITE)||LA14_0==TYPE) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // D:\\��ҵ\\Grammar.g:193:132: stat
                    	    {
                    	    pushFollow(FOLLOW_stat_in_ifClause510);
                    	    stat();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    match(input,SG_RIGHTBIGBRACKET,FOLLOW_SG_RIGHTBIGBRACKET_in_ifClause514); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ifClause"



    // $ANTLR start "whileClause"
    // D:\\��ҵ\\Grammar.g:197:1: whileClause : KW_WHILE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET ;
    public final void whileClause() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:197:13: ( KW_WHILE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET )
            // D:\\��ҵ\\Grammar.g:197:15: KW_WHILE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET
            {
            match(input,KW_WHILE,FOLLOW_KW_WHILE_in_whileClause529); 

            match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_whileClause531); 

            pushFollow(FOLLOW_boolExpr_in_whileClause533);
            boolExpr();

            state._fsp--;


            match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_whileClause535); 

            match(input,SG_LEFTBIGBRACKET,FOLLOW_SG_LEFTBIGBRACKET_in_whileClause537); 

            // D:\\��ҵ\\Grammar.g:197:82: ( stat )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ID||LA16_0==KW_BREAK||(LA16_0 >= KW_IF && LA16_0 <= KW_WRITE)||LA16_0==TYPE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // D:\\��ҵ\\Grammar.g:197:83: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_whileClause540);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            match(input,SG_RIGHTBIGBRACKET,FOLLOW_SG_RIGHTBIGBRACKET_in_whileClause544); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "whileClause"



    // $ANTLR start "breakClause"
    // D:\\��ҵ\\Grammar.g:200:1: breakClause : KW_BREAK SG_SEMICOLON ;
    public final void breakClause() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:200:13: ( KW_BREAK SG_SEMICOLON )
            // D:\\��ҵ\\Grammar.g:200:15: KW_BREAK SG_SEMICOLON
            {
            match(input,KW_BREAK,FOLLOW_KW_BREAK_in_breakClause553); 

            match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_breakClause555); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "breakClause"



    // $ANTLR start "array"
    // D:\\��ҵ\\Grammar.g:204:1: array : ID SG_LEFTMIDBRACKET boolExpr SG_RIGHTMIDBRACKET ;
    public final void array() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:204:7: ( ID SG_LEFTMIDBRACKET boolExpr SG_RIGHTMIDBRACKET )
            // D:\\��ҵ\\Grammar.g:204:9: ID SG_LEFTMIDBRACKET boolExpr SG_RIGHTMIDBRACKET
            {
            match(input,ID,FOLLOW_ID_in_array567); 

            match(input,SG_LEFTMIDBRACKET,FOLLOW_SG_LEFTMIDBRACKET_in_array569); 

            pushFollow(FOLLOW_boolExpr_in_array571);
            boolExpr();

            state._fsp--;


            match(input,SG_RIGHTMIDBRACKET,FOLLOW_SG_RIGHTMIDBRACKET_in_array573); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "array"



    // $ANTLR start "read"
    // D:\\��ҵ\\Grammar.g:208:1: read : ( KW_READ SG_LEFTBRACKET ID SG_RIGHTBRACKET SG_SEMICOLON | KW_READ SG_LEFTBRACKET array SG_RIGHTBRACKET SG_SEMICOLON );
    public final void read() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:208:6: ( KW_READ SG_LEFTBRACKET ID SG_RIGHTBRACKET SG_SEMICOLON | KW_READ SG_LEFTBRACKET array SG_RIGHTBRACKET SG_SEMICOLON )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==KW_READ) ) {
                int LA17_1 = input.LA(2);

                if ( (LA17_1==SG_LEFTBRACKET) ) {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==ID) ) {
                        int LA17_3 = input.LA(4);

                        if ( (LA17_3==SG_RIGHTBRACKET) ) {
                            alt17=1;
                        }
                        else if ( (LA17_3==SG_LEFTMIDBRACKET) ) {
                            alt17=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // D:\\��ҵ\\Grammar.g:208:8: KW_READ SG_LEFTBRACKET ID SG_RIGHTBRACKET SG_SEMICOLON
                    {
                    match(input,KW_READ,FOLLOW_KW_READ_in_read584); 

                    match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_read586); 

                    match(input,ID,FOLLOW_ID_in_read588); 

                    match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_read590); 

                    match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_read593); 

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Grammar.g:209:6: KW_READ SG_LEFTBRACKET array SG_RIGHTBRACKET SG_SEMICOLON
                    {
                    match(input,KW_READ,FOLLOW_KW_READ_in_read600); 

                    match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_read602); 

                    pushFollow(FOLLOW_array_in_read604);
                    array();

                    state._fsp--;


                    match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_read606); 

                    match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_read608); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "read"



    // $ANTLR start "write"
    // D:\\��ҵ\\Grammar.g:213:1: write : KW_WRITE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_SEMICOLON ;
    public final void write() throws RecognitionException {
        try {
            // D:\\��ҵ\\Grammar.g:213:7: ( KW_WRITE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_SEMICOLON )
            // D:\\��ҵ\\Grammar.g:213:9: KW_WRITE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_SEMICOLON
            {
            match(input,KW_WRITE,FOLLOW_KW_WRITE_in_write620); 

            match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_write622); 

            pushFollow(FOLLOW_boolExpr_in_write624);
            boolExpr();

            state._fsp--;


            match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_write626); 

            match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_write628); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "write"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog42 = new BitSet(new long[]{0x0000010000001EA2L});
    public static final BitSet FOLLOW_sequenceStructure_in_stat60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifClause_in_stat69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileClause_in_stat78 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakClause_in_stat86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_bool101 = new BitSet(new long[]{0x0000000002658002L});
    public static final BitSet FOLLOW_set_in_bool105 = new BitSet(new long[]{0x0000008104000070L});
    public static final BitSet FOLLOW_expr_in_bool131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicOr_in_boolExpr146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr155 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_set_in_expr159 = new BitSet(new long[]{0x0000008104000070L});
    public static final BitSet FOLLOW_multExpr_in_expr169 = new BitSet(new long[]{0x0000000001020002L});
    public static final BitSet FOLLOW_atom_in_multExpr183 = new BitSet(new long[]{0x0000000000084002L});
    public static final BitSet FOLLOW_set_in_multExpr187 = new BitSet(new long[]{0x0000008104000070L});
    public static final BitSet FOLLOW_atom_in_multExpr197 = new BitSet(new long[]{0x0000000000084002L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_atom210 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_atom212 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_atom214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_atom226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_atom237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_atom242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_atom247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicAnd_in_logicOr262 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_OP_OR_in_logicOr266 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_logicAnd_in_logicOr268 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_logicAtom_in_logicAnd287 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_OP_AND_in_logicAnd291 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_logicAtom_in_logicAnd293 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_bool_in_logicAtom311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OP_NON_in_logicAtom316 = new BitSet(new long[]{0x0000008104000070L});
    public static final BitSet FOLLOW_bool_in_logicAtom318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OP_NON_in_nonExpr327 = new BitSet(new long[]{0x0000008104000070L});
    public static final BitSet FOLLOW_expr_in_nonExpr329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SG_LEFTANNOTATE_in_notes342 = new BitSet(new long[]{0x0000010400001EA0L});
    public static final BitSet FOLLOW_stat_in_notes344 = new BitSet(new long[]{0x0000010400001EA0L});
    public static final BitSet FOLLOW_SG_RIGHTANNOTATE_in_notes347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineVariable_in_sequenceStructure363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initiateVariable_in_sequenceStructure369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineArray_in_sequenceStructure375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initiateArray_in_sequenceStructure383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_sequenceStructure389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_in_sequenceStructure397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_defineVariable408 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_defineVariable410 = new BitSet(new long[]{0x0000004010000000L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_defineVariable414 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_defineVariable416 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_defineVariable421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_initiateVariable430 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_initiateVariable432 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_initiateVariable434 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_initiateVariable436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_defineArray445 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_defineArray447 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_SG_LEFTMIDBRACKET_in_defineArray449 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INT_in_defineArray451 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SG_RIGHTMIDBRACKET_in_defineArray453 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_defineArray455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_initiateArray466 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_initiateArray468 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_initiateArray470 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_initiateArray472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_IF_in_ifClause486 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_ifClause488 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_ifClause490 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_ifClause492 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SG_LEFTBIGBRACKET_in_ifClause494 = new BitSet(new long[]{0x0000010800001EA0L});
    public static final BitSet FOLLOW_stat_in_ifClause497 = new BitSet(new long[]{0x0000010800001EA0L});
    public static final BitSet FOLLOW_SG_RIGHTBIGBRACKET_in_ifClause501 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_KW_ELSE_in_ifClause505 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SG_LEFTBIGBRACKET_in_ifClause507 = new BitSet(new long[]{0x0000010800001EA0L});
    public static final BitSet FOLLOW_stat_in_ifClause510 = new BitSet(new long[]{0x0000010800001EA0L});
    public static final BitSet FOLLOW_SG_RIGHTBIGBRACKET_in_ifClause514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_WHILE_in_whileClause529 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_whileClause531 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_whileClause533 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_whileClause535 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_SG_LEFTBIGBRACKET_in_whileClause537 = new BitSet(new long[]{0x0000010800001EA0L});
    public static final BitSet FOLLOW_stat_in_whileClause540 = new BitSet(new long[]{0x0000010800001EA0L});
    public static final BitSet FOLLOW_SG_RIGHTBIGBRACKET_in_whileClause544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_BREAK_in_breakClause553 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_breakClause555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_array567 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_SG_LEFTMIDBRACKET_in_array569 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_array571 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_SG_RIGHTMIDBRACKET_in_array573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_READ_in_read584 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_read586 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_read588 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_read590 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_read593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_READ_in_read600 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_read602 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_array_in_read604 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_read606 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_read608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_WRITE_in_write620 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_write622 = new BitSet(new long[]{0x0000008104100070L});
    public static final BitSet FOLLOW_boolExpr_in_write624 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_write626 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_write628 = new BitSet(new long[]{0x0000000000000002L});

}