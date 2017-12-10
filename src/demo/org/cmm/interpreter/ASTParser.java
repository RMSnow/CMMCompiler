// $ANTLR 3.4 D:\\��ҵ\\AST.g 2011-12-26 21:23:40

package demo.org.cmm.interpreter;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ASTParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY", "ATOM", "BODY", "BoolExpr", "CONDITION", "DF_ARR", "DF_VAR", "ELSE", "FALSE", "ID", "IF", "INT", "KW_BREAK", "KW_ELSE", "KW_IF", "KW_READ", "KW_WHILE", "KW_WRITE", "OP_AND", "OP_DIVIDE", "OP_EQUAL", "OP_LESSTHAN", "OP_MINUS", "OP_MORETHAN", "OP_MULTIPLY", "OP_NON", "OP_NOTLESSTHAN", "OP_NOTMORETHAN", "OP_OR", "OP_PLUS", "OP_UNEQUAL", "PROG", "READ", "REAL", "SEQU", "SG_ANNOTATE", "SG_ASSIGN", "SG_COLON", "SG_LEFTANNOTATE", "SG_LEFTBIGBRACKET", "SG_LEFTBRACKET", "SG_LEFTMIDBRACKET", "SG_RIGHTANNOTATE", "SG_RIGHTBIGBRACKET", "SG_RIGHTBRACKET", "SG_RIGHTMIDBRACKET", "SG_SEMICOLON", "STAT", "TP_INT", "TP_REAL", "TRUE", "WHILE", "WRITE", "WS"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public ASTParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ASTParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return ASTParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\��ҵ\\AST.g"; }


    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prog"
    // D:\\��ҵ\\AST.g:13:1: prog : ( stat )* -> ^( PROG ( stat )* ) ;
    public final ASTParser.prog_return prog() throws RecognitionException {
        ASTParser.prog_return retval = new ASTParser.prog_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ASTParser.stat_return stat1 =null;


        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        try {
            // D:\\��ҵ\\AST.g:13:6: ( ( stat )* -> ^( PROG ( stat )* ) )
            // D:\\��ҵ\\AST.g:13:8: ( stat )*
            {
            // D:\\��ҵ\\AST.g:13:8: ( stat )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==KW_BREAK||(LA1_0 >= KW_IF && LA1_0 <= KW_WRITE)||(LA1_0 >= TP_INT && LA1_0 <= TP_REAL)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:13:8: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog69);
            	    stat1=stat();

            	    state._fsp--;

            	    stream_stat.add(stat1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // AST REWRITE
            // elements: stat
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 13:14: -> ^( PROG ( stat )* )
            {
                // D:\\��ҵ\\AST.g:13:17: ^( PROG ( stat )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(PROG, "PROG")
                , root_1);

                // D:\\��ҵ\\AST.g:13:25: ( stat )*
                while ( stream_stat.hasNext() ) {
                    adaptor.addChild(root_1, stream_stat.nextTree());

                }
                stream_stat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prog"


    public static class stat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stat"
    // D:\\��ҵ\\AST.g:16:1: stat : ( sequenceStructure -> ^( STAT sequenceStructure ) | ifClause -> ^( STAT ifClause ) | whileClause -> ^( STAT whileClause ) | breakClause -> ^( STAT breakClause ) );
    public final ASTParser.stat_return stat() throws RecognitionException {
        ASTParser.stat_return retval = new ASTParser.stat_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ASTParser.sequenceStructure_return sequenceStructure2 =null;

        ASTParser.ifClause_return ifClause3 =null;

        ASTParser.whileClause_return whileClause4 =null;

        ASTParser.breakClause_return breakClause5 =null;


        RewriteRuleSubtreeStream stream_sequenceStructure=new RewriteRuleSubtreeStream(adaptor,"rule sequenceStructure");
        RewriteRuleSubtreeStream stream_whileClause=new RewriteRuleSubtreeStream(adaptor,"rule whileClause");
        RewriteRuleSubtreeStream stream_breakClause=new RewriteRuleSubtreeStream(adaptor,"rule breakClause");
        RewriteRuleSubtreeStream stream_ifClause=new RewriteRuleSubtreeStream(adaptor,"rule ifClause");
        try {
            // D:\\��ҵ\\AST.g:16:6: ( sequenceStructure -> ^( STAT sequenceStructure ) | ifClause -> ^( STAT ifClause ) | whileClause -> ^( STAT whileClause ) | breakClause -> ^( STAT breakClause ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case ID:
            case KW_READ:
            case KW_WRITE:
            case TP_INT:
            case TP_REAL:
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
                    // D:\\��ҵ\\AST.g:16:8: sequenceStructure
                    {
                    pushFollow(FOLLOW_sequenceStructure_in_stat91);
                    sequenceStructure2=sequenceStructure();

                    state._fsp--;

                    stream_sequenceStructure.add(sequenceStructure2.getTree());

                    // AST REWRITE
                    // elements: sequenceStructure
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 16:26: -> ^( STAT sequenceStructure )
                    {
                        // D:\\��ҵ\\AST.g:16:29: ^( STAT sequenceStructure )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(STAT, "STAT")
                        , root_1);

                        adaptor.addChild(root_1, stream_sequenceStructure.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\AST.g:17:4: ifClause
                    {
                    pushFollow(FOLLOW_ifClause_in_stat106);
                    ifClause3=ifClause();

                    state._fsp--;

                    stream_ifClause.add(ifClause3.getTree());

                    // AST REWRITE
                    // elements: ifClause
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 17:13: -> ^( STAT ifClause )
                    {
                        // D:\\��ҵ\\AST.g:17:16: ^( STAT ifClause )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(STAT, "STAT")
                        , root_1);

                        adaptor.addChild(root_1, stream_ifClause.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\AST.g:18:4: whileClause
                    {
                    pushFollow(FOLLOW_whileClause_in_stat121);
                    whileClause4=whileClause();

                    state._fsp--;

                    stream_whileClause.add(whileClause4.getTree());

                    // AST REWRITE
                    // elements: whileClause
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 18:16: -> ^( STAT whileClause )
                    {
                        // D:\\��ҵ\\AST.g:18:19: ^( STAT whileClause )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(STAT, "STAT")
                        , root_1);

                        adaptor.addChild(root_1, stream_whileClause.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\AST.g:19:4: breakClause
                    {
                    pushFollow(FOLLOW_breakClause_in_stat136);
                    breakClause5=breakClause();

                    state._fsp--;

                    stream_breakClause.add(breakClause5.getTree());

                    // AST REWRITE
                    // elements: breakClause
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 19:16: -> ^( STAT breakClause )
                    {
                        // D:\\��ҵ\\AST.g:19:19: ^( STAT breakClause )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(STAT, "STAT")
                        , root_1);

                        adaptor.addChild(root_1, stream_breakClause.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stat"


    public static class bool_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bool"
    // D:\\��ҵ\\AST.g:22:1: bool : expr ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) ^ expr )? ;
    public final ASTParser.bool_return bool() throws RecognitionException {
        ASTParser.bool_return retval = new ASTParser.bool_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set7=null;
        ASTParser.expr_return expr6 =null;

        ASTParser.expr_return expr8 =null;


        CommonTree set7_tree=null;

        try {
            // D:\\��ҵ\\AST.g:22:6: ( expr ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) ^ expr )? )
            // D:\\��ҵ\\AST.g:22:8: expr ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) ^ expr )?
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_bool158);
            expr6=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr6.getTree());

            // D:\\��ҵ\\AST.g:22:13: ( ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) ^ expr )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= OP_EQUAL && LA3_0 <= OP_LESSTHAN)||LA3_0==OP_MORETHAN||(LA3_0 >= OP_NOTLESSTHAN && LA3_0 <= OP_NOTMORETHAN)||LA3_0==OP_UNEQUAL) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // D:\\��ҵ\\AST.g:22:15: ( OP_LESSTHAN | OP_UNEQUAL | OP_MORETHAN | OP_EQUAL | OP_NOTMORETHAN | OP_NOTLESSTHAN ) ^ expr
                    {
                    set7=(Token)input.LT(1);

                    set7=(Token)input.LT(1);

                    if ( (input.LA(1) >= OP_EQUAL && input.LA(1) <= OP_LESSTHAN)||input.LA(1)==OP_MORETHAN||(input.LA(1) >= OP_NOTLESSTHAN && input.LA(1) <= OP_NOTMORETHAN)||input.LA(1)==OP_UNEQUAL ) {
                        input.consume();
                        root_0 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(set7)
                        , root_0);
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    pushFollow(FOLLOW_expr_in_bool189);
                    expr8=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr8.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bool"


    public static class boolExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolExpr"
    // D:\\��ҵ\\AST.g:28:1: boolExpr : logicOr -> ^( BoolExpr logicOr ) ;
    public final ASTParser.boolExpr_return boolExpr() throws RecognitionException {
        ASTParser.boolExpr_return retval = new ASTParser.boolExpr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ASTParser.logicOr_return logicOr9 =null;


        RewriteRuleSubtreeStream stream_logicOr=new RewriteRuleSubtreeStream(adaptor,"rule logicOr");
        try {
            // D:\\��ҵ\\AST.g:28:10: ( logicOr -> ^( BoolExpr logicOr ) )
            // D:\\��ҵ\\AST.g:28:12: logicOr
            {
            pushFollow(FOLLOW_logicOr_in_boolExpr204);
            logicOr9=logicOr();

            state._fsp--;

            stream_logicOr.add(logicOr9.getTree());

            // AST REWRITE
            // elements: logicOr
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 28:20: -> ^( BoolExpr logicOr )
            {
                // D:\\��ҵ\\AST.g:28:23: ^( BoolExpr logicOr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BoolExpr, "BoolExpr")
                , root_1);

                adaptor.addChild(root_1, stream_logicOr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "boolExpr"


    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // D:\\��ҵ\\AST.g:31:1: expr : multExpr ( ( OP_PLUS | OP_MINUS ) ^ multExpr )* ;
    public final ASTParser.expr_return expr() throws RecognitionException {
        ASTParser.expr_return retval = new ASTParser.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set11=null;
        ASTParser.multExpr_return multExpr10 =null;

        ASTParser.multExpr_return multExpr12 =null;


        CommonTree set11_tree=null;

        try {
            // D:\\��ҵ\\AST.g:31:6: ( multExpr ( ( OP_PLUS | OP_MINUS ) ^ multExpr )* )
            // D:\\��ҵ\\AST.g:31:8: multExpr ( ( OP_PLUS | OP_MINUS ) ^ multExpr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_multExpr_in_expr223);
            multExpr10=multExpr();

            state._fsp--;

            adaptor.addChild(root_0, multExpr10.getTree());

            // D:\\��ҵ\\AST.g:31:17: ( ( OP_PLUS | OP_MINUS ) ^ multExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==OP_MINUS||LA4_0==OP_PLUS) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:31:19: ( OP_PLUS | OP_MINUS ) ^ multExpr
            	    {
            	    set11=(Token)input.LT(1);

            	    set11=(Token)input.LT(1);

            	    if ( input.LA(1)==OP_MINUS||input.LA(1)==OP_PLUS ) {
            	        input.consume();
            	        root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set11)
            	        , root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_multExpr_in_expr238);
            	    multExpr12=multExpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multExpr12.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class multExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multExpr"
    // D:\\��ҵ\\AST.g:34:1: multExpr : atom ( ( OP_MULTIPLY | OP_DIVIDE ) ^ atom )* ;
    public final ASTParser.multExpr_return multExpr() throws RecognitionException {
        ASTParser.multExpr_return retval = new ASTParser.multExpr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set14=null;
        ASTParser.atom_return atom13 =null;

        ASTParser.atom_return atom15 =null;


        CommonTree set14_tree=null;

        try {
            // D:\\��ҵ\\AST.g:34:10: ( atom ( ( OP_MULTIPLY | OP_DIVIDE ) ^ atom )* )
            // D:\\��ҵ\\AST.g:34:12: atom ( ( OP_MULTIPLY | OP_DIVIDE ) ^ atom )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_atom_in_multExpr252);
            atom13=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom13.getTree());

            // D:\\��ҵ\\AST.g:34:17: ( ( OP_MULTIPLY | OP_DIVIDE ) ^ atom )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==OP_DIVIDE||LA5_0==OP_MULTIPLY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:34:19: ( OP_MULTIPLY | OP_DIVIDE ) ^ atom
            	    {
            	    set14=(Token)input.LT(1);

            	    set14=(Token)input.LT(1);

            	    if ( input.LA(1)==OP_DIVIDE||input.LA(1)==OP_MULTIPLY ) {
            	        input.consume();
            	        root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set14)
            	        , root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_atom_in_multExpr267);
            	    atom15=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom15.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "multExpr"


    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // D:\\��ҵ\\AST.g:37:1: atom : ( SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET -> ^( ATOM boolExpr ) | INT | REAL | ID | TRUE | FALSE | array );
    public final ASTParser.atom_return atom() throws RecognitionException {
        ASTParser.atom_return retval = new ASTParser.atom_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SG_LEFTBRACKET16=null;
        Token SG_RIGHTBRACKET18=null;
        Token INT19=null;
        Token REAL20=null;
        Token ID21=null;
        Token TRUE22=null;
        Token FALSE23=null;
        ASTParser.boolExpr_return boolExpr17 =null;

        ASTParser.array_return array24 =null;


        CommonTree SG_LEFTBRACKET16_tree=null;
        CommonTree SG_RIGHTBRACKET18_tree=null;
        CommonTree INT19_tree=null;
        CommonTree REAL20_tree=null;
        CommonTree ID21_tree=null;
        CommonTree TRUE22_tree=null;
        CommonTree FALSE23_tree=null;
        RewriteRuleTokenStream stream_SG_LEFTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTBRACKET");
        RewriteRuleTokenStream stream_SG_RIGHTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTBRACKET");
        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        try {
            // D:\\��ҵ\\AST.g:37:5: ( SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET -> ^( ATOM boolExpr ) | INT | REAL | ID | TRUE | FALSE | array )
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
                    // D:\\��ҵ\\AST.g:37:7: SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET
                    {
                    SG_LEFTBRACKET16=(Token)match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_atom280);
                    stream_SG_LEFTBRACKET.add(SG_LEFTBRACKET16);


                    pushFollow(FOLLOW_boolExpr_in_atom282);
                    boolExpr17=boolExpr();

                    state._fsp--;

                    stream_boolExpr.add(boolExpr17.getTree());

                    SG_RIGHTBRACKET18=(Token)match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_atom284);
                    stream_SG_RIGHTBRACKET.add(SG_RIGHTBRACKET18);


                    // AST REWRITE
                    // elements: boolExpr
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 37:47: -> ^( ATOM boolExpr )
                    {
                        // D:\\��ҵ\\AST.g:37:50: ^( ATOM boolExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATOM, "ATOM")
                        , root_1);

                        adaptor.addChild(root_1, stream_boolExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\AST.g:38:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    INT19=(Token)match(input,INT,FOLLOW_INT_in_atom300);
                    INT19_tree =
                    (CommonTree)adaptor.create(INT19)
                    ;
                    adaptor.addChild(root_0, INT19_tree);


                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\AST.g:39:4: REAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    REAL20=(Token)match(input,REAL,FOLLOW_REAL_in_atom306);
                    REAL20_tree =
                    (CommonTree)adaptor.create(REAL20)
                    ;
                    adaptor.addChild(root_0, REAL20_tree);


                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\AST.g:40:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    ID21=(Token)match(input,ID,FOLLOW_ID_in_atom311);
                    ID21_tree =
                    (CommonTree)adaptor.create(ID21)
                    ;
                    adaptor.addChild(root_0, ID21_tree);


                    }
                    break;
                case 5 :
                    // D:\\��ҵ\\AST.g:41:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    TRUE22=(Token)match(input,TRUE,FOLLOW_TRUE_in_atom317);
                    TRUE22_tree =
                    (CommonTree)adaptor.create(TRUE22)
                    ;
                    adaptor.addChild(root_0, TRUE22_tree);


                    }
                    break;
                case 6 :
                    // D:\\��ҵ\\AST.g:42:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    FALSE23=(Token)match(input,FALSE,FOLLOW_FALSE_in_atom322);
                    FALSE23_tree =
                    (CommonTree)adaptor.create(FALSE23)
                    ;
                    adaptor.addChild(root_0, FALSE23_tree);


                    }
                    break;
                case 7 :
                    // D:\\��ҵ\\AST.g:43:4: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_array_in_atom328);
                    array24=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array24.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"


    public static class logicOr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "logicOr"
    // D:\\��ҵ\\AST.g:46:1: logicOr : logicAnd ( OP_OR ^ logicAnd )* ;
    public final ASTParser.logicOr_return logicOr() throws RecognitionException {
        ASTParser.logicOr_return retval = new ASTParser.logicOr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token OP_OR26=null;
        ASTParser.logicAnd_return logicAnd25 =null;

        ASTParser.logicAnd_return logicAnd27 =null;


        CommonTree OP_OR26_tree=null;

        try {
            // D:\\��ҵ\\AST.g:46:9: ( logicAnd ( OP_OR ^ logicAnd )* )
            // D:\\��ҵ\\AST.g:46:11: logicAnd ( OP_OR ^ logicAnd )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_logicAnd_in_logicOr338);
            logicAnd25=logicAnd();

            state._fsp--;

            adaptor.addChild(root_0, logicAnd25.getTree());

            // D:\\��ҵ\\AST.g:46:20: ( OP_OR ^ logicAnd )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==OP_OR) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:46:22: OP_OR ^ logicAnd
            	    {
            	    OP_OR26=(Token)match(input,OP_OR,FOLLOW_OP_OR_in_logicOr342);
            	    OP_OR26_tree =
            	    (CommonTree)adaptor.create(OP_OR26)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(OP_OR26_tree, root_0);


            	    pushFollow(FOLLOW_logicAnd_in_logicOr345);
            	    logicAnd27=logicAnd();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicAnd27.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "logicOr"


    public static class logicAnd_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "logicAnd"
    // D:\\��ҵ\\AST.g:49:1: logicAnd : logicAtom ( OP_AND ^ logicAtom )* ;
    public final ASTParser.logicAnd_return logicAnd() throws RecognitionException {
        ASTParser.logicAnd_return retval = new ASTParser.logicAnd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token OP_AND29=null;
        ASTParser.logicAtom_return logicAtom28 =null;

        ASTParser.logicAtom_return logicAtom30 =null;


        CommonTree OP_AND29_tree=null;

        try {
            // D:\\��ҵ\\AST.g:49:10: ( logicAtom ( OP_AND ^ logicAtom )* )
            // D:\\��ҵ\\AST.g:49:12: logicAtom ( OP_AND ^ logicAtom )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_logicAtom_in_logicAnd358);
            logicAtom28=logicAtom();

            state._fsp--;

            adaptor.addChild(root_0, logicAtom28.getTree());

            // D:\\��ҵ\\AST.g:49:22: ( OP_AND ^ logicAtom )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==OP_AND) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:49:24: OP_AND ^ logicAtom
            	    {
            	    OP_AND29=(Token)match(input,OP_AND,FOLLOW_OP_AND_in_logicAnd362);
            	    OP_AND29_tree =
            	    (CommonTree)adaptor.create(OP_AND29)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(OP_AND29_tree, root_0);


            	    pushFollow(FOLLOW_logicAtom_in_logicAnd365);
            	    logicAtom30=logicAtom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, logicAtom30.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "logicAnd"


    public static class logicAtom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "logicAtom"
    // D:\\��ҵ\\AST.g:55:1: logicAtom : ( bool | OP_NON bool -> ^( OP_NON bool ) );
    public final ASTParser.logicAtom_return logicAtom() throws RecognitionException {
        ASTParser.logicAtom_return retval = new ASTParser.logicAtom_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token OP_NON32=null;
        ASTParser.bool_return bool31 =null;

        ASTParser.bool_return bool33 =null;


        CommonTree OP_NON32_tree=null;
        RewriteRuleTokenStream stream_OP_NON=new RewriteRuleTokenStream(adaptor,"token OP_NON");
        RewriteRuleSubtreeStream stream_bool=new RewriteRuleSubtreeStream(adaptor,"rule bool");
        try {
            // D:\\��ҵ\\AST.g:55:11: ( bool | OP_NON bool -> ^( OP_NON bool ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0 >= FALSE && LA9_0 <= ID)||LA9_0==INT||LA9_0==REAL||LA9_0==SG_LEFTBRACKET||LA9_0==TRUE) ) {
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
                    // D:\\��ҵ\\AST.g:55:13: bool
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_bool_in_logicAtom382);
                    bool31=bool();

                    state._fsp--;

                    adaptor.addChild(root_0, bool31.getTree());

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\AST.g:56:4: OP_NON bool
                    {
                    OP_NON32=(Token)match(input,OP_NON,FOLLOW_OP_NON_in_logicAtom387);
                    stream_OP_NON.add(OP_NON32);


                    pushFollow(FOLLOW_bool_in_logicAtom389);
                    bool33=bool();

                    state._fsp--;

                    stream_bool.add(bool33.getTree());

                    // AST REWRITE
                    // elements: bool, OP_NON
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 56:16: -> ^( OP_NON bool )
                    {
                        // D:\\��ҵ\\AST.g:56:19: ^( OP_NON bool )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_OP_NON.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_bool.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "logicAtom"


    public static class nonExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nonExpr"
    // D:\\��ҵ\\AST.g:59:1: nonExpr : OP_NON expr ;
    public final ASTParser.nonExpr_return nonExpr() throws RecognitionException {
        ASTParser.nonExpr_return retval = new ASTParser.nonExpr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token OP_NON34=null;
        ASTParser.expr_return expr35 =null;


        CommonTree OP_NON34_tree=null;

        try {
            // D:\\��ҵ\\AST.g:59:9: ( OP_NON expr )
            // D:\\��ҵ\\AST.g:59:11: OP_NON expr
            {
            root_0 = (CommonTree)adaptor.nil();


            OP_NON34=(Token)match(input,OP_NON,FOLLOW_OP_NON_in_nonExpr408);
            OP_NON34_tree =
            (CommonTree)adaptor.create(OP_NON34)
            ;
            adaptor.addChild(root_0, OP_NON34_tree);


            pushFollow(FOLLOW_expr_in_nonExpr410);
            expr35=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr35.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nonExpr"


    public static class notes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "notes"
    // D:\\��ҵ\\AST.g:63:1: notes : SG_LEFTANNOTATE ( stat )* SG_RIGHTANNOTATE ;
    public final ASTParser.notes_return notes() throws RecognitionException {
        ASTParser.notes_return retval = new ASTParser.notes_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SG_LEFTANNOTATE36=null;
        Token SG_RIGHTANNOTATE38=null;
        ASTParser.stat_return stat37 =null;


        CommonTree SG_LEFTANNOTATE36_tree=null;
        CommonTree SG_RIGHTANNOTATE38_tree=null;

        try {
            // D:\\��ҵ\\AST.g:63:7: ( SG_LEFTANNOTATE ( stat )* SG_RIGHTANNOTATE )
            // D:\\��ҵ\\AST.g:63:9: SG_LEFTANNOTATE ( stat )* SG_RIGHTANNOTATE
            {
            root_0 = (CommonTree)adaptor.nil();


            SG_LEFTANNOTATE36=(Token)match(input,SG_LEFTANNOTATE,FOLLOW_SG_LEFTANNOTATE_in_notes424);
            SG_LEFTANNOTATE36_tree =
            (CommonTree)adaptor.create(SG_LEFTANNOTATE36)
            ;
            adaptor.addChild(root_0, SG_LEFTANNOTATE36_tree);


            // D:\\��ҵ\\AST.g:63:25: ( stat )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ID||LA10_0==KW_BREAK||(LA10_0 >= KW_IF && LA10_0 <= KW_WRITE)||(LA10_0 >= TP_INT && LA10_0 <= TP_REAL)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:63:25: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_notes426);
            	    stat37=stat();

            	    state._fsp--;

            	    adaptor.addChild(root_0, stat37.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            SG_RIGHTANNOTATE38=(Token)match(input,SG_RIGHTANNOTATE,FOLLOW_SG_RIGHTANNOTATE_in_notes429);
            SG_RIGHTANNOTATE38_tree =
            (CommonTree)adaptor.create(SG_RIGHTANNOTATE38)
            ;
            adaptor.addChild(root_0, SG_RIGHTANNOTATE38_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "notes"


    public static class condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condition"
    // D:\\��ҵ\\AST.g:65:1: condition : boolExpr -> ^( CONDITION boolExpr ) ;
    public final ASTParser.condition_return condition() throws RecognitionException {
        ASTParser.condition_return retval = new ASTParser.condition_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ASTParser.boolExpr_return boolExpr39 =null;


        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        try {
            // D:\\��ҵ\\AST.g:65:11: ( boolExpr -> ^( CONDITION boolExpr ) )
            // D:\\��ҵ\\AST.g:65:13: boolExpr
            {
            pushFollow(FOLLOW_boolExpr_in_condition437);
            boolExpr39=boolExpr();

            state._fsp--;

            stream_boolExpr.add(boolExpr39.getTree());

            // AST REWRITE
            // elements: boolExpr
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 65:21: -> ^( CONDITION boolExpr )
            {
                // D:\\��ҵ\\AST.g:65:23: ^( CONDITION boolExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(CONDITION, "CONDITION")
                , root_1);

                adaptor.addChild(root_1, stream_boolExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "condition"


    public static class body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "body"
    // D:\\��ҵ\\AST.g:67:1: body : SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET -> ^( BODY ( stat )* ) ;
    public final ASTParser.body_return body() throws RecognitionException {
        ASTParser.body_return retval = new ASTParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SG_LEFTBIGBRACKET40=null;
        Token SG_RIGHTBIGBRACKET42=null;
        ASTParser.stat_return stat41 =null;


        CommonTree SG_LEFTBIGBRACKET40_tree=null;
        CommonTree SG_RIGHTBIGBRACKET42_tree=null;
        RewriteRuleTokenStream stream_SG_LEFTBIGBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTBIGBRACKET");
        RewriteRuleTokenStream stream_SG_RIGHTBIGBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTBIGBRACKET");
        RewriteRuleSubtreeStream stream_stat=new RewriteRuleSubtreeStream(adaptor,"rule stat");
        try {
            // D:\\��ҵ\\AST.g:67:6: ( SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET -> ^( BODY ( stat )* ) )
            // D:\\��ҵ\\AST.g:67:8: SG_LEFTBIGBRACKET ( stat )* SG_RIGHTBIGBRACKET
            {
            SG_LEFTBIGBRACKET40=(Token)match(input,SG_LEFTBIGBRACKET,FOLLOW_SG_LEFTBIGBRACKET_in_body451);
            stream_SG_LEFTBIGBRACKET.add(SG_LEFTBIGBRACKET40);


            // D:\\��ҵ\\AST.g:67:26: ( stat )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ID||LA11_0==KW_BREAK||(LA11_0 >= KW_IF && LA11_0 <= KW_WRITE)||(LA11_0 >= TP_INT && LA11_0 <= TP_REAL)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\��ҵ\\AST.g:67:27: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_body454);
            	    stat41=stat();

            	    state._fsp--;

            	    stream_stat.add(stat41.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            SG_RIGHTBIGBRACKET42=(Token)match(input,SG_RIGHTBIGBRACKET,FOLLOW_SG_RIGHTBIGBRACKET_in_body458);
            stream_SG_RIGHTBIGBRACKET.add(SG_RIGHTBIGBRACKET42);


            // AST REWRITE
            // elements: stat
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 67:53: -> ^( BODY ( stat )* )
            {
                // D:\\��ҵ\\AST.g:67:56: ^( BODY ( stat )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BODY, "BODY")
                , root_1);

                // D:\\��ҵ\\AST.g:67:63: ( stat )*
                while ( stream_stat.hasNext() ) {
                    adaptor.addChild(root_1, stream_stat.nextTree());

                }
                stream_stat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "body"


    public static class sequenceStructure_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sequenceStructure"
    // D:\\��ҵ\\AST.g:71:1: sequenceStructure : ( defineVariable -> ^( SEQU defineVariable ) | initiateVariable -> ^( SEQU initiateVariable ) | defineArray -> ^( SEQU defineArray ) | initiateArray -> ^( SEQU initiateArray ) | read -> ^( SEQU read ) | write -> ^( SEQU write ) );
    public final ASTParser.sequenceStructure_return sequenceStructure() throws RecognitionException {
        ASTParser.sequenceStructure_return retval = new ASTParser.sequenceStructure_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ASTParser.defineVariable_return defineVariable43 =null;

        ASTParser.initiateVariable_return initiateVariable44 =null;

        ASTParser.defineArray_return defineArray45 =null;

        ASTParser.initiateArray_return initiateArray46 =null;

        ASTParser.read_return read47 =null;

        ASTParser.write_return write48 =null;


        RewriteRuleSubtreeStream stream_defineArray=new RewriteRuleSubtreeStream(adaptor,"rule defineArray");
        RewriteRuleSubtreeStream stream_write=new RewriteRuleSubtreeStream(adaptor,"rule write");
        RewriteRuleSubtreeStream stream_defineVariable=new RewriteRuleSubtreeStream(adaptor,"rule defineVariable");
        RewriteRuleSubtreeStream stream_read=new RewriteRuleSubtreeStream(adaptor,"rule read");
        RewriteRuleSubtreeStream stream_initiateArray=new RewriteRuleSubtreeStream(adaptor,"rule initiateArray");
        RewriteRuleSubtreeStream stream_initiateVariable=new RewriteRuleSubtreeStream(adaptor,"rule initiateVariable");
        try {
            // D:\\��ҵ\\AST.g:71:19: ( defineVariable -> ^( SEQU defineVariable ) | initiateVariable -> ^( SEQU initiateVariable ) | defineArray -> ^( SEQU defineArray ) | initiateArray -> ^( SEQU initiateArray ) | read -> ^( SEQU read ) | write -> ^( SEQU write ) )
            int alt12=6;
            switch ( input.LA(1) ) {
            case TP_INT:
            case TP_REAL:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==ID) ) {
                    int LA12_5 = input.LA(3);

                    if ( (LA12_5==SG_LEFTMIDBRACKET) ) {
                        alt12=3;
                    }
                    else if ( (LA12_5==SG_ASSIGN||LA12_5==SG_SEMICOLON) ) {
                        alt12=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 5, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==SG_ASSIGN) ) {
                    alt12=2;
                }
                else if ( (LA12_2==SG_LEFTMIDBRACKET) ) {
                    alt12=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;

                }
                }
                break;
            case KW_READ:
                {
                alt12=5;
                }
                break;
            case KW_WRITE:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // D:\\��ҵ\\AST.g:71:21: defineVariable
                    {
                    pushFollow(FOLLOW_defineVariable_in_sequenceStructure481);
                    defineVariable43=defineVariable();

                    state._fsp--;

                    stream_defineVariable.add(defineVariable43.getTree());

                    // AST REWRITE
                    // elements: defineVariable
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 71:36: -> ^( SEQU defineVariable )
                    {
                        // D:\\��ҵ\\AST.g:71:39: ^( SEQU defineVariable )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(SEQU, "SEQU")
                        , root_1);

                        adaptor.addChild(root_1, stream_defineVariable.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\AST.g:72:5: initiateVariable
                    {
                    pushFollow(FOLLOW_initiateVariable_in_sequenceStructure497);
                    initiateVariable44=initiateVariable();

                    state._fsp--;

                    stream_initiateVariable.add(initiateVariable44.getTree());

                    // AST REWRITE
                    // elements: initiateVariable
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 72:22: -> ^( SEQU initiateVariable )
                    {
                        // D:\\��ҵ\\AST.g:72:25: ^( SEQU initiateVariable )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(SEQU, "SEQU")
                        , root_1);

                        adaptor.addChild(root_1, stream_initiateVariable.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\AST.g:73:5: defineArray
                    {
                    pushFollow(FOLLOW_defineArray_in_sequenceStructure513);
                    defineArray45=defineArray();

                    state._fsp--;

                    stream_defineArray.add(defineArray45.getTree());

                    // AST REWRITE
                    // elements: defineArray
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 73:17: -> ^( SEQU defineArray )
                    {
                        // D:\\��ҵ\\AST.g:73:20: ^( SEQU defineArray )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(SEQU, "SEQU")
                        , root_1);

                        adaptor.addChild(root_1, stream_defineArray.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\AST.g:74:5: initiateArray
                    {
                    pushFollow(FOLLOW_initiateArray_in_sequenceStructure530);
                    initiateArray46=initiateArray();

                    state._fsp--;

                    stream_initiateArray.add(initiateArray46.getTree());

                    // AST REWRITE
                    // elements: initiateArray
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 74:19: -> ^( SEQU initiateArray )
                    {
                        // D:\\��ҵ\\AST.g:74:22: ^( SEQU initiateArray )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(SEQU, "SEQU")
                        , root_1);

                        adaptor.addChild(root_1, stream_initiateArray.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 5 :
                    // D:\\��ҵ\\AST.g:75:5: read
                    {
                    pushFollow(FOLLOW_read_in_sequenceStructure546);
                    read47=read();

                    state._fsp--;

                    stream_read.add(read47.getTree());

                    // AST REWRITE
                    // elements: read
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 75:10: -> ^( SEQU read )
                    {
                        // D:\\��ҵ\\AST.g:75:13: ^( SEQU read )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(SEQU, "SEQU")
                        , root_1);

                        adaptor.addChild(root_1, stream_read.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 6 :
                    // D:\\��ҵ\\AST.g:76:5: write
                    {
                    pushFollow(FOLLOW_write_in_sequenceStructure562);
                    write48=write();

                    state._fsp--;

                    stream_write.add(write48.getTree());

                    // AST REWRITE
                    // elements: write
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 76:11: -> ^( SEQU write )
                    {
                        // D:\\��ҵ\\AST.g:76:14: ^( SEQU write )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(SEQU, "SEQU")
                        , root_1);

                        adaptor.addChild(root_1, stream_write.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sequenceStructure"


    public static class defineVariable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "defineVariable"
    // D:\\��ҵ\\AST.g:79:1: defineVariable : type ID ( SG_ASSIGN boolExpr )? SG_SEMICOLON -> ^( DF_VAR type ID ( boolExpr )? ) ;
    public final ASTParser.defineVariable_return defineVariable() throws RecognitionException {
        ASTParser.defineVariable_return retval = new ASTParser.defineVariable_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID50=null;
        Token SG_ASSIGN51=null;
        Token SG_SEMICOLON53=null;
        ASTParser.type_return type49 =null;

        ASTParser.boolExpr_return boolExpr52 =null;


        CommonTree ID50_tree=null;
        CommonTree SG_ASSIGN51_tree=null;
        CommonTree SG_SEMICOLON53_tree=null;
        RewriteRuleTokenStream stream_SG_ASSIGN=new RewriteRuleTokenStream(adaptor,"token SG_ASSIGN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_SG_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SG_SEMICOLON");
        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // D:\\��ҵ\\AST.g:79:16: ( type ID ( SG_ASSIGN boolExpr )? SG_SEMICOLON -> ^( DF_VAR type ID ( boolExpr )? ) )
            // D:\\��ҵ\\AST.g:79:18: type ID ( SG_ASSIGN boolExpr )? SG_SEMICOLON
            {
            pushFollow(FOLLOW_type_in_defineVariable581);
            type49=type();

            state._fsp--;

            stream_type.add(type49.getTree());

            ID50=(Token)match(input,ID,FOLLOW_ID_in_defineVariable583);
            stream_ID.add(ID50);


            // D:\\��ҵ\\AST.g:79:26: ( SG_ASSIGN boolExpr )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==SG_ASSIGN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // D:\\��ҵ\\AST.g:79:28: SG_ASSIGN boolExpr
                    {
                    SG_ASSIGN51=(Token)match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_defineVariable587);
                    stream_SG_ASSIGN.add(SG_ASSIGN51);


                    pushFollow(FOLLOW_boolExpr_in_defineVariable589);
                    boolExpr52=boolExpr();

                    state._fsp--;

                    stream_boolExpr.add(boolExpr52.getTree());

                    }
                    break;

            }


            SG_SEMICOLON53=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_defineVariable594);
            stream_SG_SEMICOLON.add(SG_SEMICOLON53);


            // AST REWRITE
            // elements: boolExpr, ID, type
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 79:63: -> ^( DF_VAR type ID ( boolExpr )? )
            {
                // D:\\��ҵ\\AST.g:79:66: ^( DF_VAR type ID ( boolExpr )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DF_VAR, "DF_VAR")
                , root_1);

                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_1,
                stream_ID.nextNode()
                );

                // D:\\��ҵ\\AST.g:79:84: ( boolExpr )?
                if ( stream_boolExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_boolExpr.nextTree());

                }
                stream_boolExpr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "defineVariable"


    public static class initiateVariable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "initiateVariable"
    // D:\\��ҵ\\AST.g:82:1: initiateVariable : ID SG_ASSIGN boolExpr SG_SEMICOLON -> ^( SG_ASSIGN ID boolExpr ) ;
    public final ASTParser.initiateVariable_return initiateVariable() throws RecognitionException {
        ASTParser.initiateVariable_return retval = new ASTParser.initiateVariable_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID54=null;
        Token SG_ASSIGN55=null;
        Token SG_SEMICOLON57=null;
        ASTParser.boolExpr_return boolExpr56 =null;


        CommonTree ID54_tree=null;
        CommonTree SG_ASSIGN55_tree=null;
        CommonTree SG_SEMICOLON57_tree=null;
        RewriteRuleTokenStream stream_SG_ASSIGN=new RewriteRuleTokenStream(adaptor,"token SG_ASSIGN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_SG_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SG_SEMICOLON");
        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        try {
            // D:\\��ҵ\\AST.g:82:18: ( ID SG_ASSIGN boolExpr SG_SEMICOLON -> ^( SG_ASSIGN ID boolExpr ) )
            // D:\\��ҵ\\AST.g:82:20: ID SG_ASSIGN boolExpr SG_SEMICOLON
            {
            ID54=(Token)match(input,ID,FOLLOW_ID_in_initiateVariable618);
            stream_ID.add(ID54);


            SG_ASSIGN55=(Token)match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_initiateVariable620);
            stream_SG_ASSIGN.add(SG_ASSIGN55);


            pushFollow(FOLLOW_boolExpr_in_initiateVariable622);
            boolExpr56=boolExpr();

            state._fsp--;

            stream_boolExpr.add(boolExpr56.getTree());

            SG_SEMICOLON57=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_initiateVariable624);
            stream_SG_SEMICOLON.add(SG_SEMICOLON57);


            // AST REWRITE
            // elements: SG_ASSIGN, boolExpr, ID
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 82:56: -> ^( SG_ASSIGN ID boolExpr )
            {
                // D:\\��ҵ\\AST.g:82:59: ^( SG_ASSIGN ID boolExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_SG_ASSIGN.nextNode()
                , root_1);

                adaptor.addChild(root_1,
                stream_ID.nextNode()
                );

                adaptor.addChild(root_1, stream_boolExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "initiateVariable"


    public static class defineArray_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "defineArray"
    // D:\\��ҵ\\AST.g:85:1: defineArray : type ID SG_LEFTMIDBRACKET INT SG_RIGHTMIDBRACKET SG_SEMICOLON -> ^( DF_ARR type ID INT ) ;
    public final ASTParser.defineArray_return defineArray() throws RecognitionException {
        ASTParser.defineArray_return retval = new ASTParser.defineArray_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID59=null;
        Token SG_LEFTMIDBRACKET60=null;
        Token INT61=null;
        Token SG_RIGHTMIDBRACKET62=null;
        Token SG_SEMICOLON63=null;
        ASTParser.type_return type58 =null;


        CommonTree ID59_tree=null;
        CommonTree SG_LEFTMIDBRACKET60_tree=null;
        CommonTree INT61_tree=null;
        CommonTree SG_RIGHTMIDBRACKET62_tree=null;
        CommonTree SG_SEMICOLON63_tree=null;
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_SG_RIGHTMIDBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTMIDBRACKET");
        RewriteRuleTokenStream stream_SG_LEFTMIDBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTMIDBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_SG_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SG_SEMICOLON");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // D:\\��ҵ\\AST.g:85:13: ( type ID SG_LEFTMIDBRACKET INT SG_RIGHTMIDBRACKET SG_SEMICOLON -> ^( DF_ARR type ID INT ) )
            // D:\\��ҵ\\AST.g:85:15: type ID SG_LEFTMIDBRACKET INT SG_RIGHTMIDBRACKET SG_SEMICOLON
            {
            pushFollow(FOLLOW_type_in_defineArray646);
            type58=type();

            state._fsp--;

            stream_type.add(type58.getTree());

            ID59=(Token)match(input,ID,FOLLOW_ID_in_defineArray648);
            stream_ID.add(ID59);


            SG_LEFTMIDBRACKET60=(Token)match(input,SG_LEFTMIDBRACKET,FOLLOW_SG_LEFTMIDBRACKET_in_defineArray650);
            stream_SG_LEFTMIDBRACKET.add(SG_LEFTMIDBRACKET60);


            INT61=(Token)match(input,INT,FOLLOW_INT_in_defineArray652);
            stream_INT.add(INT61);


            SG_RIGHTMIDBRACKET62=(Token)match(input,SG_RIGHTMIDBRACKET,FOLLOW_SG_RIGHTMIDBRACKET_in_defineArray654);
            stream_SG_RIGHTMIDBRACKET.add(SG_RIGHTMIDBRACKET62);


            SG_SEMICOLON63=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_defineArray656);
            stream_SG_SEMICOLON.add(SG_SEMICOLON63);


            // AST REWRITE
            // elements: type, INT, ID
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 85:77: -> ^( DF_ARR type ID INT )
            {
                // D:\\��ҵ\\AST.g:85:80: ^( DF_ARR type ID INT )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DF_ARR, "DF_ARR")
                , root_1);

                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_1,
                stream_ID.nextNode()
                );

                adaptor.addChild(root_1,
                stream_INT.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "defineArray"


    public static class initiateArray_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "initiateArray"
    // D:\\��ҵ\\AST.g:88:1: initiateArray : array SG_ASSIGN boolExpr SG_SEMICOLON -> ^( SG_ASSIGN array boolExpr ) ;
    public final ASTParser.initiateArray_return initiateArray() throws RecognitionException {
        ASTParser.initiateArray_return retval = new ASTParser.initiateArray_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SG_ASSIGN65=null;
        Token SG_SEMICOLON67=null;
        ASTParser.array_return array64 =null;

        ASTParser.boolExpr_return boolExpr66 =null;


        CommonTree SG_ASSIGN65_tree=null;
        CommonTree SG_SEMICOLON67_tree=null;
        RewriteRuleTokenStream stream_SG_ASSIGN=new RewriteRuleTokenStream(adaptor,"token SG_ASSIGN");
        RewriteRuleTokenStream stream_SG_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SG_SEMICOLON");
        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        RewriteRuleSubtreeStream stream_array=new RewriteRuleSubtreeStream(adaptor,"rule array");
        try {
            // D:\\��ҵ\\AST.g:88:15: ( array SG_ASSIGN boolExpr SG_SEMICOLON -> ^( SG_ASSIGN array boolExpr ) )
            // D:\\��ҵ\\AST.g:88:17: array SG_ASSIGN boolExpr SG_SEMICOLON
            {
            pushFollow(FOLLOW_array_in_initiateArray681);
            array64=array();

            state._fsp--;

            stream_array.add(array64.getTree());

            SG_ASSIGN65=(Token)match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_initiateArray683);
            stream_SG_ASSIGN.add(SG_ASSIGN65);


            pushFollow(FOLLOW_boolExpr_in_initiateArray685);
            boolExpr66=boolExpr();

            state._fsp--;

            stream_boolExpr.add(boolExpr66.getTree());

            SG_SEMICOLON67=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_initiateArray687);
            stream_SG_SEMICOLON.add(SG_SEMICOLON67);


            // AST REWRITE
            // elements: SG_ASSIGN, array, boolExpr
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 88:55: -> ^( SG_ASSIGN array boolExpr )
            {
                // D:\\��ҵ\\AST.g:88:58: ^( SG_ASSIGN array boolExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_SG_ASSIGN.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_array.nextTree());

                adaptor.addChild(root_1, stream_boolExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "initiateArray"


    public static class ifClause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifClause"
    // D:\\��ҵ\\AST.g:94:1: ifClause : KW_IF SG_LEFTBRACKET condition SG_RIGHTBRACKET body ( elseClause )? -> ^( IF condition body ( elseClause )? ) ;
    public final ASTParser.ifClause_return ifClause() throws RecognitionException {
        ASTParser.ifClause_return retval = new ASTParser.ifClause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token KW_IF68=null;
        Token SG_LEFTBRACKET69=null;
        Token SG_RIGHTBRACKET71=null;
        ASTParser.condition_return condition70 =null;

        ASTParser.body_return body72 =null;

        ASTParser.elseClause_return elseClause73 =null;


        CommonTree KW_IF68_tree=null;
        CommonTree SG_LEFTBRACKET69_tree=null;
        CommonTree SG_RIGHTBRACKET71_tree=null;
        RewriteRuleTokenStream stream_KW_IF=new RewriteRuleTokenStream(adaptor,"token KW_IF");
        RewriteRuleTokenStream stream_SG_LEFTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTBRACKET");
        RewriteRuleTokenStream stream_SG_RIGHTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTBRACKET");
        RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"rule body");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        RewriteRuleSubtreeStream stream_elseClause=new RewriteRuleSubtreeStream(adaptor,"rule elseClause");
        try {
            // D:\\��ҵ\\AST.g:94:10: ( KW_IF SG_LEFTBRACKET condition SG_RIGHTBRACKET body ( elseClause )? -> ^( IF condition body ( elseClause )? ) )
            // D:\\��ҵ\\AST.g:94:12: KW_IF SG_LEFTBRACKET condition SG_RIGHTBRACKET body ( elseClause )?
            {
            KW_IF68=(Token)match(input,KW_IF,FOLLOW_KW_IF_in_ifClause715);
            stream_KW_IF.add(KW_IF68);


            SG_LEFTBRACKET69=(Token)match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_ifClause717);
            stream_SG_LEFTBRACKET.add(SG_LEFTBRACKET69);


            pushFollow(FOLLOW_condition_in_ifClause719);
            condition70=condition();

            state._fsp--;

            stream_condition.add(condition70.getTree());

            SG_RIGHTBRACKET71=(Token)match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_ifClause721);
            stream_SG_RIGHTBRACKET.add(SG_RIGHTBRACKET71);


            pushFollow(FOLLOW_body_in_ifClause723);
            body72=body();

            state._fsp--;

            stream_body.add(body72.getTree());

            // D:\\��ҵ\\AST.g:94:64: ( elseClause )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==KW_ELSE) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // D:\\��ҵ\\AST.g:94:65: elseClause
                    {
                    pushFollow(FOLLOW_elseClause_in_ifClause726);
                    elseClause73=elseClause();

                    state._fsp--;

                    stream_elseClause.add(elseClause73.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: elseClause, body, condition
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 94:78: -> ^( IF condition body ( elseClause )? )
            {
                // D:\\��ҵ\\AST.g:94:81: ^( IF condition body ( elseClause )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IF, "IF")
                , root_1);

                adaptor.addChild(root_1, stream_condition.nextTree());

                adaptor.addChild(root_1, stream_body.nextTree());

                // D:\\��ҵ\\AST.g:94:101: ( elseClause )?
                if ( stream_elseClause.hasNext() ) {
                    adaptor.addChild(root_1, stream_elseClause.nextTree());

                }
                stream_elseClause.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ifClause"


    public static class elseClause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elseClause"
    // D:\\��ҵ\\AST.g:97:1: elseClause : ( ( KW_ELSE ifClause ) -> ^( ELSE ifClause ) | ( KW_ELSE body ) -> ^( ELSE body ) );
    public final ASTParser.elseClause_return elseClause() throws RecognitionException {
        ASTParser.elseClause_return retval = new ASTParser.elseClause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token KW_ELSE74=null;
        Token KW_ELSE76=null;
        ASTParser.ifClause_return ifClause75 =null;

        ASTParser.body_return body77 =null;


        CommonTree KW_ELSE74_tree=null;
        CommonTree KW_ELSE76_tree=null;
        RewriteRuleTokenStream stream_KW_ELSE=new RewriteRuleTokenStream(adaptor,"token KW_ELSE");
        RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"rule body");
        RewriteRuleSubtreeStream stream_ifClause=new RewriteRuleSubtreeStream(adaptor,"rule ifClause");
        try {
            // D:\\��ҵ\\AST.g:97:12: ( ( KW_ELSE ifClause ) -> ^( ELSE ifClause ) | ( KW_ELSE body ) -> ^( ELSE body ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==KW_ELSE) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==KW_IF) ) {
                    alt15=1;
                }
                else if ( (LA15_1==SG_LEFTBIGBRACKET) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // D:\\��ҵ\\AST.g:97:14: ( KW_ELSE ifClause )
                    {
                    // D:\\��ҵ\\AST.g:97:14: ( KW_ELSE ifClause )
                    // D:\\��ҵ\\AST.g:97:15: KW_ELSE ifClause
                    {
                    KW_ELSE74=(Token)match(input,KW_ELSE,FOLLOW_KW_ELSE_in_elseClause751);
                    stream_KW_ELSE.add(KW_ELSE74);


                    pushFollow(FOLLOW_ifClause_in_elseClause753);
                    ifClause75=ifClause();

                    state._fsp--;

                    stream_ifClause.add(ifClause75.getTree());

                    }


                    // AST REWRITE
                    // elements: ifClause
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 97:32: -> ^( ELSE ifClause )
                    {
                        // D:\\��ҵ\\AST.g:97:34: ^( ELSE ifClause )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ELSE, "ELSE")
                        , root_1);

                        adaptor.addChild(root_1, stream_ifClause.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\AST.g:98:5: ( KW_ELSE body )
                    {
                    // D:\\��ҵ\\AST.g:98:5: ( KW_ELSE body )
                    // D:\\��ҵ\\AST.g:98:6: KW_ELSE body
                    {
                    KW_ELSE76=(Token)match(input,KW_ELSE,FOLLOW_KW_ELSE_in_elseClause767);
                    stream_KW_ELSE.add(KW_ELSE76);


                    pushFollow(FOLLOW_body_in_elseClause769);
                    body77=body();

                    state._fsp--;

                    stream_body.add(body77.getTree());

                    }


                    // AST REWRITE
                    // elements: body
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 98:19: -> ^( ELSE body )
                    {
                        // D:\\��ҵ\\AST.g:98:21: ^( ELSE body )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ELSE, "ELSE")
                        , root_1);

                        adaptor.addChild(root_1, stream_body.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elseClause"


    public static class whileClause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whileClause"
    // D:\\��ҵ\\AST.g:104:1: whileClause : KW_WHILE SG_LEFTBRACKET condition SG_RIGHTBRACKET body -> ^( WHILE condition body ) ;
    public final ASTParser.whileClause_return whileClause() throws RecognitionException {
        ASTParser.whileClause_return retval = new ASTParser.whileClause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token KW_WHILE78=null;
        Token SG_LEFTBRACKET79=null;
        Token SG_RIGHTBRACKET81=null;
        ASTParser.condition_return condition80 =null;

        ASTParser.body_return body82 =null;


        CommonTree KW_WHILE78_tree=null;
        CommonTree SG_LEFTBRACKET79_tree=null;
        CommonTree SG_RIGHTBRACKET81_tree=null;
        RewriteRuleTokenStream stream_SG_LEFTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTBRACKET");
        RewriteRuleTokenStream stream_SG_RIGHTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTBRACKET");
        RewriteRuleTokenStream stream_KW_WHILE=new RewriteRuleTokenStream(adaptor,"token KW_WHILE");
        RewriteRuleSubtreeStream stream_body=new RewriteRuleSubtreeStream(adaptor,"rule body");
        RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
        try {
            // D:\\��ҵ\\AST.g:104:13: ( KW_WHILE SG_LEFTBRACKET condition SG_RIGHTBRACKET body -> ^( WHILE condition body ) )
            // D:\\��ҵ\\AST.g:104:15: KW_WHILE SG_LEFTBRACKET condition SG_RIGHTBRACKET body
            {
            KW_WHILE78=(Token)match(input,KW_WHILE,FOLLOW_KW_WHILE_in_whileClause790);
            stream_KW_WHILE.add(KW_WHILE78);


            SG_LEFTBRACKET79=(Token)match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_whileClause792);
            stream_SG_LEFTBRACKET.add(SG_LEFTBRACKET79);


            pushFollow(FOLLOW_condition_in_whileClause794);
            condition80=condition();

            state._fsp--;

            stream_condition.add(condition80.getTree());

            SG_RIGHTBRACKET81=(Token)match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_whileClause796);
            stream_SG_RIGHTBRACKET.add(SG_RIGHTBRACKET81);


            pushFollow(FOLLOW_body_in_whileClause798);
            body82=body();

            state._fsp--;

            stream_body.add(body82.getTree());

            // AST REWRITE
            // elements: body, condition
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 104:70: -> ^( WHILE condition body )
            {
                // D:\\��ҵ\\AST.g:104:73: ^( WHILE condition body )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(WHILE, "WHILE")
                , root_1);

                adaptor.addChild(root_1, stream_condition.nextTree());

                adaptor.addChild(root_1, stream_body.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whileClause"


    public static class breakClause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "breakClause"
    // D:\\��ҵ\\AST.g:107:1: breakClause : KW_BREAK SG_SEMICOLON -> ^( KW_BREAK ) ;
    public final ASTParser.breakClause_return breakClause() throws RecognitionException {
        ASTParser.breakClause_return retval = new ASTParser.breakClause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token KW_BREAK83=null;
        Token SG_SEMICOLON84=null;

        CommonTree KW_BREAK83_tree=null;
        CommonTree SG_SEMICOLON84_tree=null;
        RewriteRuleTokenStream stream_KW_BREAK=new RewriteRuleTokenStream(adaptor,"token KW_BREAK");
        RewriteRuleTokenStream stream_SG_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SG_SEMICOLON");

        try {
            // D:\\��ҵ\\AST.g:107:13: ( KW_BREAK SG_SEMICOLON -> ^( KW_BREAK ) )
            // D:\\��ҵ\\AST.g:107:15: KW_BREAK SG_SEMICOLON
            {
            KW_BREAK83=(Token)match(input,KW_BREAK,FOLLOW_KW_BREAK_in_breakClause817);
            stream_KW_BREAK.add(KW_BREAK83);


            SG_SEMICOLON84=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_breakClause819);
            stream_SG_SEMICOLON.add(SG_SEMICOLON84);


            // AST REWRITE
            // elements: KW_BREAK
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 107:37: -> ^( KW_BREAK )
            {
                // D:\\��ҵ\\AST.g:107:40: ^( KW_BREAK )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_KW_BREAK.nextNode()
                , root_1);

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "breakClause"


    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array"
    // D:\\��ҵ\\AST.g:110:1: array : ID SG_LEFTMIDBRACKET boolExpr SG_RIGHTMIDBRACKET -> ^( ARRAY ID boolExpr ) ;
    public final ASTParser.array_return array() throws RecognitionException {
        ASTParser.array_return retval = new ASTParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID85=null;
        Token SG_LEFTMIDBRACKET86=null;
        Token SG_RIGHTMIDBRACKET88=null;
        ASTParser.boolExpr_return boolExpr87 =null;


        CommonTree ID85_tree=null;
        CommonTree SG_LEFTMIDBRACKET86_tree=null;
        CommonTree SG_RIGHTMIDBRACKET88_tree=null;
        RewriteRuleTokenStream stream_SG_RIGHTMIDBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTMIDBRACKET");
        RewriteRuleTokenStream stream_SG_LEFTMIDBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTMIDBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        try {
            // D:\\��ҵ\\AST.g:110:7: ( ID SG_LEFTMIDBRACKET boolExpr SG_RIGHTMIDBRACKET -> ^( ARRAY ID boolExpr ) )
            // D:\\��ҵ\\AST.g:110:9: ID SG_LEFTMIDBRACKET boolExpr SG_RIGHTMIDBRACKET
            {
            ID85=(Token)match(input,ID,FOLLOW_ID_in_array838);
            stream_ID.add(ID85);


            SG_LEFTMIDBRACKET86=(Token)match(input,SG_LEFTMIDBRACKET,FOLLOW_SG_LEFTMIDBRACKET_in_array840);
            stream_SG_LEFTMIDBRACKET.add(SG_LEFTMIDBRACKET86);


            pushFollow(FOLLOW_boolExpr_in_array842);
            boolExpr87=boolExpr();

            state._fsp--;

            stream_boolExpr.add(boolExpr87.getTree());

            SG_RIGHTMIDBRACKET88=(Token)match(input,SG_RIGHTMIDBRACKET,FOLLOW_SG_RIGHTMIDBRACKET_in_array844);
            stream_SG_RIGHTMIDBRACKET.add(SG_RIGHTMIDBRACKET88);


            // AST REWRITE
            // elements: ID, boolExpr
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 110:58: -> ^( ARRAY ID boolExpr )
            {
                // D:\\��ҵ\\AST.g:110:61: ^( ARRAY ID boolExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ARRAY, "ARRAY")
                , root_1);

                adaptor.addChild(root_1,
                stream_ID.nextNode()
                );

                adaptor.addChild(root_1, stream_boolExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "array"


    public static class read_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "read"
    // D:\\��ҵ\\AST.g:114:1: read : ( KW_READ SG_LEFTBRACKET ID SG_RIGHTBRACKET SG_SEMICOLON -> ^( READ ID ) | KW_READ SG_LEFTBRACKET array SG_RIGHTBRACKET SG_SEMICOLON -> ^( READ array ) );
    public final ASTParser.read_return read() throws RecognitionException {
        ASTParser.read_return retval = new ASTParser.read_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token KW_READ89=null;
        Token SG_LEFTBRACKET90=null;
        Token ID91=null;
        Token SG_RIGHTBRACKET92=null;
        Token SG_SEMICOLON93=null;
        Token KW_READ94=null;
        Token SG_LEFTBRACKET95=null;
        Token SG_RIGHTBRACKET97=null;
        Token SG_SEMICOLON98=null;
        ASTParser.array_return array96 =null;


        CommonTree KW_READ89_tree=null;
        CommonTree SG_LEFTBRACKET90_tree=null;
        CommonTree ID91_tree=null;
        CommonTree SG_RIGHTBRACKET92_tree=null;
        CommonTree SG_SEMICOLON93_tree=null;
        CommonTree KW_READ94_tree=null;
        CommonTree SG_LEFTBRACKET95_tree=null;
        CommonTree SG_RIGHTBRACKET97_tree=null;
        CommonTree SG_SEMICOLON98_tree=null;
        RewriteRuleTokenStream stream_KW_READ=new RewriteRuleTokenStream(adaptor,"token KW_READ");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_SG_LEFTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTBRACKET");
        RewriteRuleTokenStream stream_SG_RIGHTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTBRACKET");
        RewriteRuleTokenStream stream_SG_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SG_SEMICOLON");
        RewriteRuleSubtreeStream stream_array=new RewriteRuleSubtreeStream(adaptor,"rule array");
        try {
            // D:\\��ҵ\\AST.g:114:6: ( KW_READ SG_LEFTBRACKET ID SG_RIGHTBRACKET SG_SEMICOLON -> ^( READ ID ) | KW_READ SG_LEFTBRACKET array SG_RIGHTBRACKET SG_SEMICOLON -> ^( READ array ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==KW_READ) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==SG_LEFTBRACKET) ) {
                    int LA16_2 = input.LA(3);

                    if ( (LA16_2==ID) ) {
                        int LA16_3 = input.LA(4);

                        if ( (LA16_3==SG_RIGHTBRACKET) ) {
                            alt16=1;
                        }
                        else if ( (LA16_3==SG_LEFTMIDBRACKET) ) {
                            alt16=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }
            switch (alt16) {
                case 1 :
                    // D:\\��ҵ\\AST.g:114:8: KW_READ SG_LEFTBRACKET ID SG_RIGHTBRACKET SG_SEMICOLON
                    {
                    KW_READ89=(Token)match(input,KW_READ,FOLLOW_KW_READ_in_read867);
                    stream_KW_READ.add(KW_READ89);


                    SG_LEFTBRACKET90=(Token)match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_read869);
                    stream_SG_LEFTBRACKET.add(SG_LEFTBRACKET90);


                    ID91=(Token)match(input,ID,FOLLOW_ID_in_read871);
                    stream_ID.add(ID91);


                    SG_RIGHTBRACKET92=(Token)match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_read873);
                    stream_SG_RIGHTBRACKET.add(SG_RIGHTBRACKET92);


                    SG_SEMICOLON93=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_read875);
                    stream_SG_SEMICOLON.add(SG_SEMICOLON93);


                    // AST REWRITE
                    // elements: ID
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 114:63: -> ^( READ ID )
                    {
                        // D:\\��ҵ\\AST.g:114:66: ^( READ ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(READ, "READ")
                        , root_1);

                        adaptor.addChild(root_1,
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\AST.g:115:5: KW_READ SG_LEFTBRACKET array SG_RIGHTBRACKET SG_SEMICOLON
                    {
                    KW_READ94=(Token)match(input,KW_READ,FOLLOW_KW_READ_in_read891);
                    stream_KW_READ.add(KW_READ94);


                    SG_LEFTBRACKET95=(Token)match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_read893);
                    stream_SG_LEFTBRACKET.add(SG_LEFTBRACKET95);


                    pushFollow(FOLLOW_array_in_read895);
                    array96=array();

                    state._fsp--;

                    stream_array.add(array96.getTree());

                    SG_RIGHTBRACKET97=(Token)match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_read897);
                    stream_SG_RIGHTBRACKET.add(SG_RIGHTBRACKET97);


                    SG_SEMICOLON98=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_read899);
                    stream_SG_SEMICOLON.add(SG_SEMICOLON98);


                    // AST REWRITE
                    // elements: array
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 115:63: -> ^( READ array )
                    {
                        // D:\\��ҵ\\AST.g:115:66: ^( READ array )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(READ, "READ")
                        , root_1);

                        adaptor.addChild(root_1, stream_array.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "read"


    public static class write_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "write"
    // D:\\��ҵ\\AST.g:119:1: write : KW_WRITE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_SEMICOLON -> ^( WRITE boolExpr ) ;
    public final ASTParser.write_return write() throws RecognitionException {
        ASTParser.write_return retval = new ASTParser.write_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token KW_WRITE99=null;
        Token SG_LEFTBRACKET100=null;
        Token SG_RIGHTBRACKET102=null;
        Token SG_SEMICOLON103=null;
        ASTParser.boolExpr_return boolExpr101 =null;


        CommonTree KW_WRITE99_tree=null;
        CommonTree SG_LEFTBRACKET100_tree=null;
        CommonTree SG_RIGHTBRACKET102_tree=null;
        CommonTree SG_SEMICOLON103_tree=null;
        RewriteRuleTokenStream stream_KW_WRITE=new RewriteRuleTokenStream(adaptor,"token KW_WRITE");
        RewriteRuleTokenStream stream_SG_LEFTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_LEFTBRACKET");
        RewriteRuleTokenStream stream_SG_RIGHTBRACKET=new RewriteRuleTokenStream(adaptor,"token SG_RIGHTBRACKET");
        RewriteRuleTokenStream stream_SG_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SG_SEMICOLON");
        RewriteRuleSubtreeStream stream_boolExpr=new RewriteRuleSubtreeStream(adaptor,"rule boolExpr");
        try {
            // D:\\��ҵ\\AST.g:119:7: ( KW_WRITE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_SEMICOLON -> ^( WRITE boolExpr ) )
            // D:\\��ҵ\\AST.g:119:9: KW_WRITE SG_LEFTBRACKET boolExpr SG_RIGHTBRACKET SG_SEMICOLON
            {
            KW_WRITE99=(Token)match(input,KW_WRITE,FOLLOW_KW_WRITE_in_write920);
            stream_KW_WRITE.add(KW_WRITE99);


            SG_LEFTBRACKET100=(Token)match(input,SG_LEFTBRACKET,FOLLOW_SG_LEFTBRACKET_in_write922);
            stream_SG_LEFTBRACKET.add(SG_LEFTBRACKET100);


            pushFollow(FOLLOW_boolExpr_in_write924);
            boolExpr101=boolExpr();

            state._fsp--;

            stream_boolExpr.add(boolExpr101.getTree());

            SG_RIGHTBRACKET102=(Token)match(input,SG_RIGHTBRACKET,FOLLOW_SG_RIGHTBRACKET_in_write926);
            stream_SG_RIGHTBRACKET.add(SG_RIGHTBRACKET102);


            SG_SEMICOLON103=(Token)match(input,SG_SEMICOLON,FOLLOW_SG_SEMICOLON_in_write928);
            stream_SG_SEMICOLON.add(SG_SEMICOLON103);


            // AST REWRITE
            // elements: boolExpr
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 119:71: -> ^( WRITE boolExpr )
            {
                // D:\\��ҵ\\AST.g:119:74: ^( WRITE boolExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(WRITE, "WRITE")
                , root_1);

                adaptor.addChild(root_1, stream_boolExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "write"


    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // D:\\��ҵ\\AST.g:123:1: type : ( TP_INT | TP_REAL );
    public final ASTParser.type_return type() throws RecognitionException {
        ASTParser.type_return retval = new ASTParser.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set104=null;

        CommonTree set104_tree=null;

        try {
            // D:\\��ҵ\\AST.g:123:6: ( TP_INT | TP_REAL )
            // D:\\��ҵ\\AST.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set104=(Token)input.LT(1);

            if ( (input.LA(1) >= TP_INT && input.LA(1) <= TP_REAL) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set104)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog69 = new BitSet(new long[]{0x00300000003D2002L});
    public static final BitSet FOLLOW_sequenceStructure_in_stat91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifClause_in_stat106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileClause_in_stat121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakClause_in_stat136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_bool158 = new BitSet(new long[]{0x00000004CB000002L});
    public static final BitSet FOLLOW_set_in_bool162 = new BitSet(new long[]{0x004010200000B000L});
    public static final BitSet FOLLOW_expr_in_bool189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicOr_in_boolExpr204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multExpr_in_expr223 = new BitSet(new long[]{0x0000000204000002L});
    public static final BitSet FOLLOW_set_in_expr227 = new BitSet(new long[]{0x004010200000B000L});
    public static final BitSet FOLLOW_multExpr_in_expr238 = new BitSet(new long[]{0x0000000204000002L});
    public static final BitSet FOLLOW_atom_in_multExpr252 = new BitSet(new long[]{0x0000000010800002L});
    public static final BitSet FOLLOW_set_in_multExpr256 = new BitSet(new long[]{0x004010200000B000L});
    public static final BitSet FOLLOW_atom_in_multExpr267 = new BitSet(new long[]{0x0000000010800002L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_atom280 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_boolExpr_in_atom282 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_atom284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_atom306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_atom317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_atom322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_atom328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicAnd_in_logicOr338 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_OP_OR_in_logicOr342 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_logicAnd_in_logicOr345 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_logicAtom_in_logicAnd358 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_OP_AND_in_logicAnd362 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_logicAtom_in_logicAnd365 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_bool_in_logicAtom382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OP_NON_in_logicAtom387 = new BitSet(new long[]{0x004010200000B000L});
    public static final BitSet FOLLOW_bool_in_logicAtom389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OP_NON_in_nonExpr408 = new BitSet(new long[]{0x004010200000B000L});
    public static final BitSet FOLLOW_expr_in_nonExpr410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SG_LEFTANNOTATE_in_notes424 = new BitSet(new long[]{0x00304000003D2000L});
    public static final BitSet FOLLOW_stat_in_notes426 = new BitSet(new long[]{0x00304000003D2000L});
    public static final BitSet FOLLOW_SG_RIGHTANNOTATE_in_notes429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolExpr_in_condition437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SG_LEFTBIGBRACKET_in_body451 = new BitSet(new long[]{0x00308000003D2000L});
    public static final BitSet FOLLOW_stat_in_body454 = new BitSet(new long[]{0x00308000003D2000L});
    public static final BitSet FOLLOW_SG_RIGHTBIGBRACKET_in_body458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineVariable_in_sequenceStructure481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initiateVariable_in_sequenceStructure497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineArray_in_sequenceStructure513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initiateArray_in_sequenceStructure530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_in_sequenceStructure546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_in_sequenceStructure562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_defineVariable581 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_defineVariable583 = new BitSet(new long[]{0x0004010000000000L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_defineVariable587 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_boolExpr_in_defineVariable589 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_defineVariable594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_initiateVariable618 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_initiateVariable620 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_boolExpr_in_initiateVariable622 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_initiateVariable624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_defineArray646 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_defineArray648 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_SG_LEFTMIDBRACKET_in_defineArray650 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INT_in_defineArray652 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTMIDBRACKET_in_defineArray654 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_defineArray656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_initiateArray681 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_initiateArray683 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_boolExpr_in_initiateArray685 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_initiateArray687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_IF_in_ifClause715 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_ifClause717 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_condition_in_ifClause719 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_ifClause721 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_body_in_ifClause723 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_elseClause_in_ifClause726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_ELSE_in_elseClause751 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ifClause_in_elseClause753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_ELSE_in_elseClause767 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_body_in_elseClause769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_WHILE_in_whileClause790 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_whileClause792 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_condition_in_whileClause794 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_whileClause796 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_body_in_whileClause798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_BREAK_in_breakClause817 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_breakClause819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_array838 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_SG_LEFTMIDBRACKET_in_array840 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_boolExpr_in_array842 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTMIDBRACKET_in_array844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_READ_in_read867 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_read869 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_read871 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_read873 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_read875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_READ_in_read891 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_read893 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_array_in_read895 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_read897 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_read899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KW_WRITE_in_write920 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SG_LEFTBRACKET_in_write922 = new BitSet(new long[]{0x004010202000B000L});
    public static final BitSet FOLLOW_boolExpr_in_write924 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_SG_RIGHTBRACKET_in_write926 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SG_SEMICOLON_in_write928 = new BitSet(new long[]{0x0000000000000002L});

}