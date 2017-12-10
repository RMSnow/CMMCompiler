// $ANTLR 3.4 D:\\��ҵ\\Interpreter.g 2011-12-26 21:22:10

package demo.org.cmm.interpreter;

import demo.org.cmm.ui.Editor;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* import org.cmm.interpreter.FunctionMap.Param; */

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Interpreter extends TreeParser {
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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public Interpreter(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public Interpreter(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected StringTemplateGroup templateLib =
  new StringTemplateGroup("InterpreterTemplates", AngleBracketTemplateLexer.class);

public void setTemplateLib(StringTemplateGroup templateLib) {
  this.templateLib = templateLib;
}
public StringTemplateGroup getTemplateLib() {
  return templateLib;
}
/** allows convenient multi-value initialization:
 *  "new STAttrMap().put(...).put(...)"
 */
public static class STAttrMap extends HashMap {
  public STAttrMap put(String attrName, Object value) {
    super.put(attrName, value);
    return this;
  }
  public STAttrMap put(String attrName, int value) {
    super.put(attrName, new Integer(value));
    return this;
  }
}
    public String[] getTokenNames() { return Interpreter.tokenNames; }
    public String getGrammarFileName() { return "D:\\��ҵ\\Interpreter.g"; }


    private Editor ui;
    public VarMap GlobalVarMap = new VarMap();
    public Stack<VarMap> LocalVarStack = new Stack<VarMap>();
    public Map<String,String> arrayMap = new HashMap<String,String>();
    public int level = 0;
    private int arrayCount = 0;
    public Stack<Boolean> skipStack = new Stack<Boolean>();
    public Stack<Integer> breakStack = new Stack<Integer>();
    public Stack<RTTemp> returnStack = new Stack<RTTemp>();
    public Stack<ArrayList<String[]>> loopTempVarStack= new Stack<ArrayList<String[]>>();
    public static String readString = "";


    String tempClazz="";
    String tempValue="";
    boolean breaked;
    boolean matched;



    private static final String bool = "boolean";
    private static final String inte = "int";
    private static final String real = "real";
    private static final String string = "string";
    private static final String arr = "array";

    public Interpreter(TreeNodeStream nodes,Editor ui){
    	this(nodes);
    	this.ui=ui;
    }

    private void checkType(String expected, String actual){
            if(expected.equals(real)&&actual.equals(inte)) actual=real;
            if(!expected.equals(actual)) throw new TypeErrorException(expected, actual);
    }

    private void checkTwoType(String a1, String a2){
            if((a1.equals(real)&&a2.equals(inte))||(a1.equals(inte)&&a2.equals(real)))  {a1=real;a2=real;}
            if(!a1.equals(a2)) throw new TypeErrorException(a1, a2);
    }

    private void checkIntType(String actual){
            
            if(!actual.equals(inte)) throw new TypeErrorException(inte, actual);
    }
    private boolean isInt(String st){
    	return !st.contains(".");
    }

    private boolean isMultiDefined(String name){
    	boolean b=false;
    	for(String[] a:loopTempVarStack.peek()){
    		if(a[0].equals(name)) b=true;
    	}
    	return b;
    }
    private boolean isDigit(String readString){
    	boolean b=true;
    	try{
    		Double.parseDouble(readString);
    	}catch (NumberFormatException nfe){
    		b=false;
    	}finally{
    		return b;
    	}
    	
    }

    public VarMap findVarMap(String name){
        	if(level!=0&&LocalVarStack.peek().contains(name))return LocalVarStack.peek();
        	else if(GlobalVarMap.contains(name))return GlobalVarMap;
        	else{
        		throw new RuntimeException("����������"+name);
        	}
    }

    public void loopIn(){
    	if(!skip())skipStack.push(false);
    	else skipStack.push(true);
    	loopTempVarStack.push(new ArrayList<String[]>());
    	trackSkipStack();
    }
    public void loopOut(){
    	skipStack.pop();
    	removeLoopTemp();
    }
    public boolean skip(){
    	for(boolean b:skipStack)if(b)return true;
    	return false;
    }
    public boolean skipOnlyThis(){
    	boolean thisSkip = skipStack.pop();
    	boolean hasSkip = false;
    	for(boolean b:skipStack)if(b)hasSkip = true;
    	skipStack.push(thisSkip);
    	//System.out.println("skipOnlyThis:"+thisSkip&&!hasSkip);
    	return thisSkip&&!hasSkip;
    }
    public void setSkip(boolean b){
        	skipStack.pop();
        	skipStack.push(b);
    }
    public void setSkip(int i,boolean b){
        	skipStack.set(i,b);
    }

    public void recordLoopTemp(String name,String clazz,String value,String operation){
        	boolean recorded=false;
        	for(String[] l:loopTempVarStack.peek())recorded=l[0].equals(name)?true:recorded;
                if(!recorded){
                	loopTempVarStack.peek().add(new String[]{name,clazz,value,operation});
                	//System.out.println("Record:"+name+"  "+clazz+"  "+value+"  "+operation);
            }
    }
    public void removeLoopTemp(){
            for(String[] lt:loopTempVarStack.peek()){
            	VarMap m =findVarMap(lt[0]);
                	m.remove(lt[0]);
                	//System.out.println(GlobalVarMap.contains("b")+"dasd");
                	//String s = m.equals(GlobalVarMap)?"Global":"Local";
                	if(lt[3].equals("recover")){
                		m.put(lt[0],lt[1],lt[2]);
                		//System.out.println("recover:"+"to "+s+" "+lt[0]+"="+GlobalVarMap.getValue(lt[0]));
                	}
                	//System.out.println(GlobalVarMap.contains("b")+GlobalVarMap.getValue(ft.name));
            }
            loopTempVarStack.pop();
            trackSkipStack();
    }
    public boolean isCovered(String name){
    	VarMap m;
    	if(level==0)m=GlobalVarMap;
    	else m=LocalVarStack.peek();
    	return m.contains(name);
    }

    public class RTTemp{
    	int skip;
    	String clazz = "";
    	String value = "";
    	public RTTemp(int skip){this.skip=skip;}
    	public void setRT(String c,String v){
    		clazz=c;
    		value=v;
    	}
    }

    public void trackSkipStack(){
    //for(boolean b:skipStack)System.out.print(b+"  ");
      //  	System.out.println();
    }
    public void trackSkipStack(String s){
    //System.out.print(s);
    //for(boolean b:skipStack)System.out.print(b+"  ");
     //   	System.out.println();
    }
    public void setUI(Editor ui){
    	this.ui=ui;
    }


    public static class prog_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "prog"
    // D:\\��ҵ\\Interpreter.g:179:1: prog : ^( PROG ( stat )* ) ;
    public final Interpreter.prog_return prog() throws RecognitionException {
        Interpreter.prog_return retval = new Interpreter.prog_return();
        retval.start = input.LT(1);


        skipStack.push(false);
        try {
            // D:\\��ҵ\\Interpreter.g:182:3: ( ^( PROG ( stat )* ) )
            // D:\\��ҵ\\Interpreter.g:182:5: ^( PROG ( stat )* )
            {
            match(input,PROG,FOLLOW_PROG_in_prog61);

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null);
                // D:\\��ҵ\\Interpreter.g:182:13: ( stat )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==STAT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // D:\\��ҵ\\Interpreter.g:182:13: stat
                	    {
                	    pushFollow(FOLLOW_stat_in_prog63);
                	    stat();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null);
            }


            }

            skipStack.pop();
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prog"


    public static class stat_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "stat"
    // D:\\��ҵ\\Interpreter.g:185:1: stat : ( ^( STAT sequenceStucture ) | ^( STAT ifClause ) | ^( STAT whileClause ) | ^( STAT breakClause ) );
    public final Interpreter.stat_return stat() throws RecognitionException {
        Interpreter.stat_return retval = new Interpreter.stat_return();
        retval.start = input.LT(1);


        try {
            // D:\\��ҵ\\Interpreter.g:186:2: ( ^( STAT sequenceStucture ) | ^( STAT ifClause ) | ^( STAT whileClause ) | ^( STAT breakClause ) )
            int alt2=4;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==STAT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case SEQU:
                        {
                        alt2=1;
                        }
                        break;
                    case IF:
                        {
                        alt2=2;
                        }
                        break;
                    case WHILE:
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
                            new NoViableAltException("", 2, 2, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:186:4: ^( STAT sequenceStucture )
                    {
                    match(input,STAT,FOLLOW_STAT_in_stat80);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_sequenceStucture_in_stat82);
                    sequenceStucture();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Interpreter.g:187:5: ^( STAT ifClause )
                    {
                    match(input,STAT,FOLLOW_STAT_in_stat90);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_ifClause_in_stat92);
                    ifClause();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\Interpreter.g:188:5: ^( STAT whileClause )
                    {
                    match(input,STAT,FOLLOW_STAT_in_stat100);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_whileClause_in_stat102);
                    whileClause();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\Interpreter.g:189:5: ^( STAT breakClause )
                    {
                    match(input,STAT,FOLLOW_STAT_in_stat110);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_breakClause_in_stat112);
                    breakClause();

                    state._fsp--;


                    match(input, Token.UP, null);


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
        return retval;
    }
    // $ANTLR end "stat"


    public static class boolExpr_return extends TreeRuleReturnScope {
        public String clazz;
        public String value;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "boolExpr"
    // D:\\��ҵ\\Interpreter.g:194:1: boolExpr returns [String clazz,String value] : ^( BoolExpr e= logicOr ) ;
    public final Interpreter.boolExpr_return boolExpr() throws RecognitionException {
        Interpreter.boolExpr_return retval = new Interpreter.boolExpr_return();
        retval.start = input.LT(1);


        Interpreter.logicOr_return e =null;


        try {
            // D:\\��ҵ\\Interpreter.g:195:2: ( ^( BoolExpr e= logicOr ) )
            // D:\\��ҵ\\Interpreter.g:195:5: ^( BoolExpr e= logicOr )
            {
            match(input,BoolExpr,FOLLOW_BoolExpr_in_boolExpr131);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_logicOr_in_boolExpr135);
            e=logicOr();

            state._fsp--;


            match(input, Token.UP, null);


            if(!skip()){retval.value =e.value;retval.clazz =e.clazz;}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "boolExpr"


    public static class logicOr_return extends TreeRuleReturnScope {
        public String clazz;
        public String value;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "logicOr"
    // D:\\��ҵ\\Interpreter.g:198:1: logicOr returns [String clazz,String value] : ( ^( OP_PLUS e1= logicOr e2= logicOr ) | ^( OP_MINUS e1= logicOr e2= logicOr ) | ^( OP_MULTIPLY e1= logicOr e2= logicOr ) | ^( OP_DIVIDE e1= logicOr e2= logicOr ) | ^( OP_MORETHAN e1= logicOr e2= logicOr ) | ^( OP_LESSTHAN e1= logicOr e2= logicOr ) | ^( OP_EQUAL e1= logicOr e2= logicOr ) | ^( OP_NOTLESSTHAN e1= logicOr e2= logicOr ) | ^( OP_NOTMORETHAN e1= logicOr e2= logicOr ) | ^( OP_UNEQUAL e1= logicOr e2= logicOr ) | ^( OP_AND e1= logicOr e2= logicOr ) | ^( OP_OR e1= logicOr e2= logicOr ) | ^( OP_NON e= logicOr ) |a= atom );
    public final Interpreter.logicOr_return logicOr() throws RecognitionException {
        Interpreter.logicOr_return retval = new Interpreter.logicOr_return();
        retval.start = input.LT(1);


        Interpreter.logicOr_return e1 =null;

        Interpreter.logicOr_return e2 =null;

        Interpreter.logicOr_return e =null;

        Interpreter.atom_return a =null;


        try {
            // D:\\��ҵ\\Interpreter.g:199:2: ( ^( OP_PLUS e1= logicOr e2= logicOr ) | ^( OP_MINUS e1= logicOr e2= logicOr ) | ^( OP_MULTIPLY e1= logicOr e2= logicOr ) | ^( OP_DIVIDE e1= logicOr e2= logicOr ) | ^( OP_MORETHAN e1= logicOr e2= logicOr ) | ^( OP_LESSTHAN e1= logicOr e2= logicOr ) | ^( OP_EQUAL e1= logicOr e2= logicOr ) | ^( OP_NOTLESSTHAN e1= logicOr e2= logicOr ) | ^( OP_NOTMORETHAN e1= logicOr e2= logicOr ) | ^( OP_UNEQUAL e1= logicOr e2= logicOr ) | ^( OP_AND e1= logicOr e2= logicOr ) | ^( OP_OR e1= logicOr e2= logicOr ) | ^( OP_NON e= logicOr ) |a= atom )
            int alt3=14;
            switch ( input.LA(1) ) {
            case OP_PLUS:
                {
                alt3=1;
                }
                break;
            case OP_MINUS:
                {
                alt3=2;
                }
                break;
            case OP_MULTIPLY:
                {
                alt3=3;
                }
                break;
            case OP_DIVIDE:
                {
                alt3=4;
                }
                break;
            case OP_MORETHAN:
                {
                alt3=5;
                }
                break;
            case OP_LESSTHAN:
                {
                alt3=6;
                }
                break;
            case OP_EQUAL:
                {
                alt3=7;
                }
                break;
            case OP_NOTLESSTHAN:
                {
                alt3=8;
                }
                break;
            case OP_NOTMORETHAN:
                {
                alt3=9;
                }
                break;
            case OP_UNEQUAL:
                {
                alt3=10;
                }
                break;
            case OP_AND:
                {
                alt3=11;
                }
                break;
            case OP_OR:
                {
                alt3=12;
                }
                break;
            case OP_NON:
                {
                alt3=13;
                }
                break;
            case ARRAY:
            case ATOM:
            case FALSE:
            case ID:
            case INT:
            case REAL:
            case TRUE:
                {
                alt3=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:199:5: ^( OP_PLUS e1= logicOr e2= logicOr )
                    {
                    match(input,OP_PLUS,FOLLOW_OP_PLUS_in_logicOr154);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr158);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr162);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    	                    if(e1.clazz.equals("string")||e2.clazz.equals("string")){
                    	                    	String s1="",s2="";
                    	                    	if(e1.clazz.equals("int"))s1=(int)Double.parseDouble(e1.value)+"";
                    	                    	else s1=e1.value;
                    	                    	if(e2.clazz.equals("int"))s2=(int)Double.parseDouble(e2.value)+"";
                    	                    	else s2=e2.value;
                    				retval.clazz =string;retval.value =s1+s2;}
                    	                    else {
                    	                    	checkType(real, e1.clazz);checkType(real, e2.clazz);
                    	                    	if(e1.clazz.equals(inte)&&e2.clazz.equals(inte)){retval.clazz = inte;} else {retval.clazz =real;};
                    	                    	retval.value =Double.parseDouble(e1.value)+Double.parseDouble(e2.value)+"";}
                    	                    }


                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Interpreter.g:214:6: ^( OP_MINUS e1= logicOr e2= logicOr )
                    {
                    match(input,OP_MINUS,FOLLOW_OP_MINUS_in_logicOr176);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr180);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr184);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz ); checkType(real, e2.clazz ); if(e1.clazz.equals(inte)&&e2.clazz.equals(inte)){retval.clazz = inte;} else {retval.clazz =real;};
                    			    retval.value =Double.parseDouble(e1.value)-Double.parseDouble(e2.value)+"";}

                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\Interpreter.g:217:6: ^( OP_MULTIPLY e1= logicOr e2= logicOr )
                    {
                    match(input,OP_MULTIPLY,FOLLOW_OP_MULTIPLY_in_logicOr194);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr198);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr202);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz ); checkType(real, e2.clazz ); if(e1.clazz.equals(inte)&&e2.clazz.equals(inte)){retval.clazz = inte;} else {retval.clazz =real;};
                    			    retval.value =Double.parseDouble(e1.value)*Double.parseDouble(e2.value)+"";}

                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\Interpreter.g:220:6: ^( OP_DIVIDE e1= logicOr e2= logicOr )
                    {
                    match(input,OP_DIVIDE,FOLLOW_OP_DIVIDE_in_logicOr212);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr216);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr220);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz); checkType(real, e2.clazz); if(e1.clazz.equals(inte)&&e2.clazz.equals(inte)){retval.clazz = inte;} else {retval.clazz =real;};
                    			    retval.value =Double.parseDouble(e1.value)/Double.parseDouble(e2.value)+"";}

                    }
                    break;
                case 5 :
                    // D:\\��ҵ\\Interpreter.g:223:6: ^( OP_MORETHAN e1= logicOr e2= logicOr )
                    {
                    match(input,OP_MORETHAN,FOLLOW_OP_MORETHAN_in_logicOr230);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr234);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr238);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz); checkType(real, e2.clazz); retval.clazz = bool;
                    			    retval.value =Double.parseDouble(e1.value)>Double.parseDouble(e2.value)?"true":"false";}

                    }
                    break;
                case 6 :
                    // D:\\��ҵ\\Interpreter.g:226:6: ^( OP_LESSTHAN e1= logicOr e2= logicOr )
                    {
                    match(input,OP_LESSTHAN,FOLLOW_OP_LESSTHAN_in_logicOr248);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr252);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr256);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz); checkType(real, e2.clazz); retval.clazz = bool;
                    			    retval.value =Double.parseDouble(e1.value)<Double.parseDouble(e2.value)?"true":"false";}

                    }
                    break;
                case 7 :
                    // D:\\��ҵ\\Interpreter.g:229:6: ^( OP_EQUAL e1= logicOr e2= logicOr )
                    {
                    match(input,OP_EQUAL,FOLLOW_OP_EQUAL_in_logicOr266);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr270);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr274);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz); checkType(real, e2.clazz); retval.clazz = bool;
                    			    retval.value =Double.parseDouble(e1.value)==Double.parseDouble(e2.value)?"true":"false";}

                    }
                    break;
                case 8 :
                    // D:\\��ҵ\\Interpreter.g:232:6: ^( OP_NOTLESSTHAN e1= logicOr e2= logicOr )
                    {
                    match(input,OP_NOTLESSTHAN,FOLLOW_OP_NOTLESSTHAN_in_logicOr284);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr288);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr292);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz); checkType(real, e2.clazz); retval.clazz = bool;
                    			    retval.value =Double.parseDouble(e1.value)>=Double.parseDouble(e2.value)?"true":"false";}

                    }
                    break;
                case 9 :
                    // D:\\��ҵ\\Interpreter.g:235:6: ^( OP_NOTMORETHAN e1= logicOr e2= logicOr )
                    {
                    match(input,OP_NOTMORETHAN,FOLLOW_OP_NOTMORETHAN_in_logicOr302);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr306);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr310);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz); checkType(real, e2.clazz); retval.clazz = bool;
                    			    retval.value =Double.parseDouble(e1.value)<=Double.parseDouble(e2.value)?"true":"false";}

                    }
                    break;
                case 10 :
                    // D:\\��ҵ\\Interpreter.g:238:6: ^( OP_UNEQUAL e1= logicOr e2= logicOr )
                    {
                    match(input,OP_UNEQUAL,FOLLOW_OP_UNEQUAL_in_logicOr320);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr324);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr328);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(real, e1.clazz); checkType(real, e2.clazz); retval.clazz =bool;
                    			    retval.value =Double.parseDouble(e1.value)!=Double.parseDouble(e2.value)?"true":"false";}

                    }
                    break;
                case 11 :
                    // D:\\��ҵ\\Interpreter.g:241:6: ^( OP_AND e1= logicOr e2= logicOr )
                    {
                    match(input,OP_AND,FOLLOW_OP_AND_in_logicOr338);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr342);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr346);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(bool, e1.clazz); checkType(bool, e2.clazz); retval.clazz = bool;
                    			    retval.value =Boolean.parseBoolean(e1.value)&&Boolean.parseBoolean(e2.value)?"true":"false";}

                    }
                    break;
                case 12 :
                    // D:\\��ҵ\\Interpreter.g:244:6: ^( OP_OR e1= logicOr e2= logicOr )
                    {
                    match(input,OP_OR,FOLLOW_OP_OR_in_logicOr356);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr360);
                    e1=logicOr();

                    state._fsp--;


                    pushFollow(FOLLOW_logicOr_in_logicOr364);
                    e2=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(bool, e1.clazz); checkType(bool, e2.clazz); retval.clazz = bool;
                    			    retval.value =Boolean.parseBoolean(e1.value)||Boolean.parseBoolean(e2.value)?"true":"false";}

                    }
                    break;
                case 13 :
                    // D:\\��ҵ\\Interpreter.g:247:6: ^( OP_NON e= logicOr )
                    {
                    match(input,OP_NON,FOLLOW_OP_NON_in_logicOr374);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_logicOr_in_logicOr378);
                    e=logicOr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			    checkType(bool, e.clazz);retval.clazz = bool;
                    			    retval.value =Boolean.parseBoolean(e.value)?"false":"true";}

                    }
                    break;
                case 14 :
                    // D:\\��ҵ\\Interpreter.g:250:6: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_logicOr389);
                    a=atom();

                    state._fsp--;


                    if(!skip()){
                    			    retval.clazz = a.clazz;
                    			    retval.value =a.value;}

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
        return retval;
    }
    // $ANTLR end "logicOr"


    public static class atom_return extends TreeRuleReturnScope {
        public String clazz;
        public String value;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "atom"
    // D:\\��ҵ\\Interpreter.g:255:1: atom returns [String clazz,String value] : ( ^( ATOM v= boolExpr ) |e= ID |e= INT |e= REAL | TRUE | FALSE |arr= array );
    public final Interpreter.atom_return atom() throws RecognitionException {
        Interpreter.atom_return retval = new Interpreter.atom_return();
        retval.start = input.LT(1);


        CommonTree e=null;
        Interpreter.boolExpr_return v =null;

        Interpreter.array_return arr =null;


        try {
            // D:\\��ҵ\\Interpreter.g:256:2: ( ^( ATOM v= boolExpr ) |e= ID |e= INT |e= REAL | TRUE | FALSE |arr= array )
            int alt4=7;
            switch ( input.LA(1) ) {
            case ATOM:
                {
                alt4=1;
                }
                break;
            case ID:
                {
                alt4=2;
                }
                break;
            case INT:
                {
                alt4=3;
                }
                break;
            case REAL:
                {
                alt4=4;
                }
                break;
            case TRUE:
                {
                alt4=5;
                }
                break;
            case FALSE:
                {
                alt4=6;
                }
                break;
            case ARRAY:
                {
                alt4=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:256:9: ^( ATOM v= boolExpr )
                    {
                    match(input,ATOM,FOLLOW_ATOM_in_atom414);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_boolExpr_in_atom418);
                    v=boolExpr();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){retval.clazz =v.clazz;retval.value =v.value;}

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Interpreter.g:257:7: e= ID
                    {
                    e=(CommonTree)match(input,ID,FOLLOW_ID_in_atom431);

                    if(!skip()){
                    				    retval.clazz =findVarMap(e.getText()).getType(e.getText());
                    				    if(level!=0&&LocalVarStack.peek().contains(e.getText())){retval.value =LocalVarStack.peek().getValue(e.getText());}else{retval.value =GlobalVarMap.getValue(e.getText());}}

                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\Interpreter.g:260:14: e= INT
                    {
                    e=(CommonTree)match(input,INT,FOLLOW_INT_in_atom449);

                    if(!skip()){retval.clazz =inte;retval.value =e.getText();}

                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\Interpreter.g:261:7: e= REAL
                    {
                    e=(CommonTree)match(input,REAL,FOLLOW_REAL_in_atom460);

                    if(!skip()){retval.clazz =real;retval.value =e.getText();}

                    }
                    break;
                case 5 :
                    // D:\\��ҵ\\Interpreter.g:262:7: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_atom469);

                    if(!skip()){retval.clazz =bool;retval.value ="true";}

                    }
                    break;
                case 6 :
                    // D:\\��ҵ\\Interpreter.g:263:14: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_atom485);

                    if(!skip()){retval.clazz =bool;retval.value ="false";}

                    }
                    break;
                case 7 :
                    // D:\\��ҵ\\Interpreter.g:264:7: arr= array
                    {
                    pushFollow(FOLLOW_array_in_atom496);
                    arr=array();

                    state._fsp--;


                    if(!skip()){retval.clazz =arr.clazz;retval.value =arr.value;}

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
        return retval;
    }
    // $ANTLR end "atom"


    public static class array_return extends TreeRuleReturnScope {
        public String clazz;
        public String value;
        public String name;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "array"
    // D:\\��ҵ\\Interpreter.g:267:1: array returns [String clazz,String value,String name] : ^( ARRAY n= ID e= boolExpr ) ;
    public final Interpreter.array_return array() throws RecognitionException {
        Interpreter.array_return retval = new Interpreter.array_return();
        retval.start = input.LT(1);


        CommonTree n=null;
        Interpreter.boolExpr_return e =null;


        try {
            // D:\\��ҵ\\Interpreter.g:268:2: ( ^( ARRAY n= ID e= boolExpr ) )
            // D:\\��ҵ\\Interpreter.g:268:4: ^( ARRAY n= ID e= boolExpr )
            {
            match(input,ARRAY,FOLLOW_ARRAY_in_array512);

            match(input, Token.DOWN, null);
            n=(CommonTree)match(input,ID,FOLLOW_ID_in_array516);

            pushFollow(FOLLOW_boolExpr_in_array520);
            e=boolExpr();

            state._fsp--;


            match(input, Token.UP, null);



            			if(!skip()){
            				if(!e.clazz.equals("int")) throw new TypeErrorException(inte,e.value);
            				if(!arrayMap.containsKey(findVarMap(n.getText()).getValue(n.getText())+"_"+(int)Double.parseDouble(e.value))){
            					throw new RuntimeException("�±�Խ�����������ڣ�");
            				}
            				retval.name =findVarMap(n.getText()).getValue(n.getText())+"_"+(int)Double.parseDouble(e.value);
            				retval.clazz =findVarMap(n.getText()).getType(n.getText());retval.value =arrayMap.get(retval.name);
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
        return retval;
    }
    // $ANTLR end "array"


    public static class sequenceStucture_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "sequenceStucture"
    // D:\\��ҵ\\Interpreter.g:280:1: sequenceStucture : ( ^( SEQU defineVariable ) | ^( SEQU initiateVariable ) | ^( SEQU defineArray ) | ^( SEQU initiateArray ) | ^( SEQU read ) | ^( SEQU write ) );
    public final Interpreter.sequenceStucture_return sequenceStucture() throws RecognitionException {
        Interpreter.sequenceStucture_return retval = new Interpreter.sequenceStucture_return();
        retval.start = input.LT(1);


        try {
            // D:\\��ҵ\\Interpreter.g:281:2: ( ^( SEQU defineVariable ) | ^( SEQU initiateVariable ) | ^( SEQU defineArray ) | ^( SEQU initiateArray ) | ^( SEQU read ) | ^( SEQU write ) )
            int alt5=6;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==SEQU) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==DOWN) ) {
                    switch ( input.LA(3) ) {
                    case DF_VAR:
                        {
                        alt5=1;
                        }
                        break;
                    case SG_ASSIGN:
                        {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4==DOWN) ) {
                            int LA5_8 = input.LA(5);

                            if ( (LA5_8==ID) ) {
                                alt5=2;
                            }
                            else if ( (LA5_8==ARRAY) ) {
                                alt5=4;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 8, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;

                        }
                        }
                        break;
                    case DF_ARR:
                        {
                        alt5=3;
                        }
                        break;
                    case READ:
                        {
                        alt5=5;
                        }
                        break;
                    case WRITE:
                        {
                        alt5=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:281:5: ^( SEQU defineVariable )
                    {
                    match(input,SEQU,FOLLOW_SEQU_in_sequenceStucture537);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_defineVariable_in_sequenceStucture539);
                    defineVariable();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Interpreter.g:282:5: ^( SEQU initiateVariable )
                    {
                    match(input,SEQU,FOLLOW_SEQU_in_sequenceStucture549);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_initiateVariable_in_sequenceStucture551);
                    initiateVariable();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 3 :
                    // D:\\��ҵ\\Interpreter.g:283:5: ^( SEQU defineArray )
                    {
                    match(input,SEQU,FOLLOW_SEQU_in_sequenceStucture561);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_defineArray_in_sequenceStucture563);
                    defineArray();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 4 :
                    // D:\\��ҵ\\Interpreter.g:284:5: ^( SEQU initiateArray )
                    {
                    match(input,SEQU,FOLLOW_SEQU_in_sequenceStucture574);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_initiateArray_in_sequenceStucture576);
                    initiateArray();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 5 :
                    // D:\\��ҵ\\Interpreter.g:285:5: ^( SEQU read )
                    {
                    match(input,SEQU,FOLLOW_SEQU_in_sequenceStucture586);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_read_in_sequenceStucture588);
                    read();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 6 :
                    // D:\\��ҵ\\Interpreter.g:286:5: ^( SEQU write )
                    {
                    match(input,SEQU,FOLLOW_SEQU_in_sequenceStucture598);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_write_in_sequenceStucture600);
                    write();

                    state._fsp--;


                    match(input, Token.UP, null);


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
        return retval;
    }
    // $ANTLR end "sequenceStucture"


    public static class defineVariable_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "defineVariable"
    // D:\\��ҵ\\Interpreter.g:290:1: defineVariable : ^( DF_VAR e1= type e2= ID (e3= boolExpr )? ) ;
    public final Interpreter.defineVariable_return defineVariable() throws RecognitionException {
        Interpreter.defineVariable_return retval = new Interpreter.defineVariable_return();
        retval.start = input.LT(1);


        CommonTree e2=null;
        Interpreter.type_return e1 =null;

        Interpreter.boolExpr_return e3 =null;


        String v = "";
        try {
            // D:\\��ҵ\\Interpreter.g:292:2: ( ^( DF_VAR e1= type e2= ID (e3= boolExpr )? ) )
            // D:\\��ҵ\\Interpreter.g:292:4: ^( DF_VAR e1= type e2= ID (e3= boolExpr )? )
            {
            match(input,DF_VAR,FOLLOW_DF_VAR_in_defineVariable622);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_type_in_defineVariable626);
            e1=type();

            state._fsp--;


            e2=(CommonTree)match(input,ID,FOLLOW_ID_in_defineVariable630);

            // D:\\��ҵ\\Interpreter.g:292:27: (e3= boolExpr )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==BoolExpr) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:292:28: e3= boolExpr
                    {
                    pushFollow(FOLLOW_boolExpr_in_defineVariable635);
                    e3=boolExpr();

                    state._fsp--;



                    			if(!skip()){checkTwoType(e1.value,e3.clazz);v=e1.value.equals("int")?((int)Double.parseDouble(e3.value)+""):e3.value;}

                    }
                    break;

            }


            match(input, Token.UP, null);



                                    if(!skip()){
                                    	if(!loopTempVarStack.empty()){
                                    		if(isMultiDefined(e2.getText())) throw new RuntimeException("�����ض���:"+e2.getText());
                                    		recordLoopTemp(e2.getText(),e1.value,v,isCovered(e2.getText())?"recover":"delete");
                                    	}
                                    	if(level==0){
                                    		if(GlobalVarMap.contains(e2.getText())) throw new RuntimeException("�����ض���:"+e2.getText());
                                    		GlobalVarMap.put(e2.getText(),e1.value,v);
                                    	}
                                    	else{
                                    		if(LocalVarStack.peek().contains(e2.getText())) throw new RuntimeException("�����ض���:"+e2.getText());
                                    		LocalVarStack.peek().put(e2.getText(),e1.value,v);
                                    	}
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
        return retval;
    }
    // $ANTLR end "defineVariable"


    public static class initiateVariable_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "initiateVariable"
    // D:\\��ҵ\\Interpreter.g:312:1: initiateVariable : ^( SG_ASSIGN name= ID value= boolExpr ) ;
    public final Interpreter.initiateVariable_return initiateVariable() throws RecognitionException {
        Interpreter.initiateVariable_return retval = new Interpreter.initiateVariable_return();
        retval.start = input.LT(1);


        CommonTree name=null;
        Interpreter.boolExpr_return value =null;


        try {
            // D:\\��ҵ\\Interpreter.g:313:2: ( ^( SG_ASSIGN name= ID value= boolExpr ) )
            // D:\\��ҵ\\Interpreter.g:313:4: ^( SG_ASSIGN name= ID value= boolExpr )
            {
            match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_initiateVariable655);

            match(input, Token.DOWN, null);
            name=(CommonTree)match(input,ID,FOLLOW_ID_in_initiateVariable659);

            pushFollow(FOLLOW_boolExpr_in_initiateVariable663);
            value=boolExpr();

            state._fsp--;


            match(input, Token.UP, null);


            if(!skip()){
            			checkTwoType(findVarMap(name.getText()).getType(name.getText()), value.clazz);
            			if(level!=0&&LocalVarStack.peek().contains(name.getText()))
            				LocalVarStack.peek().setValue(name.getText(),LocalVarStack.peek().getType(name.getText()).equals("int")?((int)Double.parseDouble(value.value)+""):value.value);
            			else
            				GlobalVarMap.setValue(name.getText(),GlobalVarMap.getType(name.getText()).equals("int")?((int)Double.parseDouble(value.value)+""):value.value);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "initiateVariable"


    public static class initiateArray_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "initiateArray"
    // D:\\��ҵ\\Interpreter.g:323:1: initiateArray : ^( SG_ASSIGN a= array e= boolExpr ) ;
    public final Interpreter.initiateArray_return initiateArray() throws RecognitionException {
        Interpreter.initiateArray_return retval = new Interpreter.initiateArray_return();
        retval.start = input.LT(1);


        Interpreter.array_return a =null;

        Interpreter.boolExpr_return e =null;


        try {
            // D:\\��ҵ\\Interpreter.g:324:2: ( ^( SG_ASSIGN a= array e= boolExpr ) )
            // D:\\��ҵ\\Interpreter.g:324:4: ^( SG_ASSIGN a= array e= boolExpr )
            {
            match(input,SG_ASSIGN,FOLLOW_SG_ASSIGN_in_initiateArray682);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_array_in_initiateArray686);
            a=array();

            state._fsp--;


            pushFollow(FOLLOW_boolExpr_in_initiateArray690);
            e=boolExpr();

            state._fsp--;


            match(input, Token.UP, null);


            if(!skip()){
            			checkTwoType(a.clazz, e.clazz);
            			String val="";
            			if(a.clazz.equals("string"))val=e.value;
            			else if(a.clazz.equals("int"))val=(int)Double.parseDouble(e.value)+"";
            			else if(a.clazz.equals("real"))val=Double.parseDouble(e.value)+"";
            			else if(a.clazz.equals("boolean"))val=e.value;
            			arrayMap.remove(a.name);arrayMap.put(a.name,val);
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
        return retval;
    }
    // $ANTLR end "initiateArray"


    public static class defineArray_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "defineArray"
    // D:\\��ҵ\\Interpreter.g:336:1: defineArray : ^( DF_ARR t= type i= ID d= INT ) ;
    public final Interpreter.defineArray_return defineArray() throws RecognitionException {
        Interpreter.defineArray_return retval = new Interpreter.defineArray_return();
        retval.start = input.LT(1);


        CommonTree i=null;
        CommonTree d=null;
        Interpreter.type_return t =null;


        try {
            // D:\\��ҵ\\Interpreter.g:337:2: ( ^( DF_ARR t= type i= ID d= INT ) )
            // D:\\��ҵ\\Interpreter.g:337:4: ^( DF_ARR t= type i= ID d= INT )
            {
            match(input,DF_ARR,FOLLOW_DF_ARR_in_defineArray707);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_type_in_defineArray711);
            t=type();

            state._fsp--;


            i=(CommonTree)match(input,ID,FOLLOW_ID_in_defineArray715);

            d=(CommonTree)match(input,INT,FOLLOW_INT_in_defineArray719);

            match(input, Token.UP, null);


            if(!skip()){
            			if(!isInt(d.getText())) throw new TypeErrorException(inte,d.getText());
            			if(Integer.parseInt(d.getText())<0) throw new RuntimeException("�����±�Ӧ������0��");
            			if(!loopTempVarStack.empty())
            				recordLoopTemp(i.getText(),t.value,"array_"+arrayCount++,isCovered(i.getText())?"recover":"delete");
            			if(level==0)
            				GlobalVarMap.put(i.getText(),t.value,"array_"+arrayCount++);
            			else
            				LocalVarStack.peek().put(i.getText(),t.value,"array_"+arrayCount++);
            			for(int k=0;k<(int)Double.parseDouble(d.getText());k++){
            				arrayMap.put(findVarMap(i.getText()).getValue(i.getText())+"_"+k,t.value.equals("int")||t.value.equals("real")?"0":"");
            			}
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
        return retval;
    }
    // $ANTLR end "defineArray"


    public static class whileClause_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "whileClause"
    // D:\\��ҵ\\Interpreter.g:354:1: whileClause : ^( WHILE cond= condition body ) ;
    public final Interpreter.whileClause_return whileClause() throws RecognitionException {
        Interpreter.whileClause_return retval = new Interpreter.whileClause_return();
        retval.start = input.LT(1);


        Interpreter.condition_return cond =null;



        loopIn();
        int wh = input.index();
        if(!skip()){breaked=false;breakStack.push(skipStack.size()-1);}

        try {
            // D:\\��ҵ\\Interpreter.g:361:2: ( ^( WHILE cond= condition body ) )
            // D:\\��ҵ\\Interpreter.g:361:4: ^( WHILE cond= condition body )
            {
            match(input,WHILE,FOLLOW_WHILE_in_whileClause747);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_condition_in_whileClause751);
            cond=condition();

            state._fsp--;


            if(!skip()){if(!cond.value)setSkip(true);}

            pushFollow(FOLLOW_body_in_whileClause754);
            body();

            state._fsp--;


            match(input, Token.UP, null);


            if(!skip()){
            		if(cond.value){
            			((BufferedTreeNodeStream)input).push(wh);
            			whileClause();
            			((BufferedTreeNodeStream)input).pop();
            		}
            	}

            }

            loopOut();if(!skip())breakStack.pop();
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whileClause"


    public static class ifClause_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "ifClause"
    // D:\\��ҵ\\Interpreter.g:370:1: ifClause : ^( IF cond= condition body ( elseClause )? ) ;
    public final Interpreter.ifClause_return ifClause() throws RecognitionException {
        Interpreter.ifClause_return retval = new Interpreter.ifClause_return();
        retval.start = input.LT(1);


        Interpreter.condition_return cond =null;


        loopIn();trackSkipStack("before if:");
        try {
            // D:\\��ҵ\\Interpreter.g:373:2: ( ^( IF cond= condition body ( elseClause )? ) )
            // D:\\��ҵ\\Interpreter.g:373:4: ^( IF cond= condition body ( elseClause )? )
            {
            match(input,IF,FOLLOW_IF_in_ifClause777);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_condition_in_ifClause781);
            cond=condition();

            state._fsp--;


            if(!skip()){if(!cond.value)setSkip(true);}

            pushFollow(FOLLOW_body_in_ifClause784);
            body();

            state._fsp--;


            if(!skip()){setSkip(true);}else if(skipOnlyThis())setSkip(false);

            // D:\\��ҵ\\Interpreter.g:373:140: ( elseClause )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ELSE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:373:140: elseClause
                    {
                    pushFollow(FOLLOW_elseClause_in_ifClause787);
                    elseClause();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null);


            }

            loopOut();trackSkipStack("after if:");
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ifClause"


    public static class elseClause_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "elseClause"
    // D:\\��ҵ\\Interpreter.g:376:1: elseClause : ( ^( ELSE ifClause ) | ^( ELSE body ) );
    public final Interpreter.elseClause_return elseClause() throws RecognitionException {
        Interpreter.elseClause_return retval = new Interpreter.elseClause_return();
        retval.start = input.LT(1);


        try {
            // D:\\��ҵ\\Interpreter.g:376:12: ( ^( ELSE ifClause ) | ^( ELSE body ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ELSE) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==DOWN) ) {
                    int LA8_2 = input.LA(3);

                    if ( (LA8_2==IF) ) {
                        alt8=1;
                    }
                    else if ( (LA8_2==BODY) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:376:14: ^( ELSE ifClause )
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_elseClause799);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_ifClause_in_elseClause801);
                    ifClause();

                    state._fsp--;


                    match(input, Token.UP, null);


                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Interpreter.g:377:6: ^( ELSE body )
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_elseClause810);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_body_in_elseClause812);
                    body();

                    state._fsp--;


                    match(input, Token.UP, null);


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
        return retval;
    }
    // $ANTLR end "elseClause"


    public static class breakClause_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "breakClause"
    // D:\\��ҵ\\Interpreter.g:380:1: breakClause : KW_BREAK ;
    public final Interpreter.breakClause_return breakClause() throws RecognitionException {
        Interpreter.breakClause_return retval = new Interpreter.breakClause_return();
        retval.start = input.LT(1);


        try {
            // D:\\��ҵ\\Interpreter.g:380:13: ( KW_BREAK )
            // D:\\��ҵ\\Interpreter.g:380:15: KW_BREAK
            {
            match(input,KW_BREAK,FOLLOW_KW_BREAK_in_breakClause823);

            if(!skip()){if(!breakStack.empty()){breaked=true;setSkip(breakStack.peek(),true);}else throw new RuntimeException("û�п���break�ĳ���飡");}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "breakClause"


    public static class condition_return extends TreeRuleReturnScope {
        public boolean value;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "condition"
    // D:\\��ҵ\\Interpreter.g:383:1: condition returns [boolean value] : ^( CONDITION e= boolExpr ) ;
    public final Interpreter.condition_return condition() throws RecognitionException {
        Interpreter.condition_return retval = new Interpreter.condition_return();
        retval.start = input.LT(1);


        Interpreter.boolExpr_return e =null;


        try {
            // D:\\��ҵ\\Interpreter.g:384:2: ( ^( CONDITION e= boolExpr ) )
            // D:\\��ҵ\\Interpreter.g:384:4: ^( CONDITION e= boolExpr )
            {
            match(input,CONDITION,FOLLOW_CONDITION_in_condition839);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_boolExpr_in_condition843);
            e=boolExpr();

            state._fsp--;


            match(input, Token.UP, null);


            if(!skip()){if(e.clazz.equals("boolean"))retval.value =Boolean.parseBoolean(e.value);else if(e.clazz.equals("int")||e.clazz.equals("real"))retval.value =Double.parseDouble(e.value)>0?true:false;else throw new RuntimeException("����������boolean,int,real����");}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "condition"


    public static class body_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "body"
    // D:\\��ҵ\\Interpreter.g:387:1: body : ^( BODY ( stat )* ) ;
    public final Interpreter.body_return body() throws RecognitionException {
        Interpreter.body_return retval = new Interpreter.body_return();
        retval.start = input.LT(1);


        trackSkipStack("before body...");loopTempVarStack.push(new ArrayList<String[]>());
        try {
            // D:\\��ҵ\\Interpreter.g:389:59: ( ^( BODY ( stat )* ) )
            // D:\\��ҵ\\Interpreter.g:389:61: ^( BODY ( stat )* )
            {
            match(input,BODY,FOLLOW_BODY_in_body863);

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null);
                // D:\\��ҵ\\Interpreter.g:389:68: ( stat )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==STAT) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // D:\\��ҵ\\Interpreter.g:389:68: stat
                	    {
                	    pushFollow(FOLLOW_stat_in_body865);
                	    stat();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop9;
                    }
                } while (true);


                match(input, Token.UP, null);
            }


            }

            removeLoopTemp();trackSkipStack("after body...");
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "body"


    public static class read_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "read"
    // D:\\��ҵ\\Interpreter.g:393:1: read : ( ^( READ i= ID ) | ^( READ a= array ) );
    public final Interpreter.read_return read() throws RecognitionException {
        Interpreter.read_return retval = new Interpreter.read_return();
        retval.start = input.LT(1);


        CommonTree i=null;
        Interpreter.array_return a =null;


        try {
            // D:\\��ҵ\\Interpreter.g:393:6: ( ^( READ i= ID ) | ^( READ a= array ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==READ) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==DOWN) ) {
                    int LA10_2 = input.LA(3);

                    if ( (LA10_2==ID) ) {
                        alt10=1;
                    }
                    else if ( (LA10_2==ARRAY) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:393:8: ^( READ i= ID )
                    {
                    match(input,READ,FOLLOW_READ_in_read882);

                    match(input, Token.DOWN, null);
                    i=(CommonTree)match(input,ID,FOLLOW_ID_in_read886);

                    match(input, Token.UP, null);


                    if(!skip()){
                    			ui.read();
                    			while(readString.equals("")){}
                    			if(findVarMap(i.getText()).getType(i.getText()).equals(real)||findVarMap(i.getText()).getType(i.getText()).equals(inte)){
                    				if(!isDigit(readString)) {readString = ""; throw new RuntimeException("���벻ƥ�䣡");}
                    			}else if(findVarMap(i.getText()).getType(i.getText()).equals(bool)){
                    				if(!(readString.equals("true")||readString.equals("false"))){readString="";throw new RuntimeException("���벻ƥ�䣡");}
                    			}
                    			findVarMap(i.getText()).setValue(i.getText(),readString);
                    			readString = "";
                    		}

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Interpreter.g:404:4: ^( READ a= array )
                    {
                    match(input,READ,FOLLOW_READ_in_read894);

                    match(input, Token.DOWN, null);
                    pushFollow(FOLLOW_array_in_read898);
                    a=array();

                    state._fsp--;


                    match(input, Token.UP, null);


                    if(!skip()){
                    			ui.read();
                    			while(readString.equals("")){}
                    			if(a.clazz.equals(real)||a.clazz.equals(inte)){
                    				if(!isDigit(readString)) {readString=""; throw new RuntimeException("���벻ƥ�䣡");}
                    			}else if(a.clazz.equals(bool)){
                    				if(!(readString.equals("true")||readString.equals("false"))){readString="";throw new RuntimeException("���벻ƥ�䣡");}
                    			}
                    			arrayMap.remove(a.name);
                    			arrayMap.put(a.name,readString);
                    			readString = "";
                    		}

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
        return retval;
    }
    // $ANTLR end "read"


    public static class write_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "write"
    // D:\\��ҵ\\Interpreter.g:418:1: write : ^( WRITE e= boolExpr ) ;
    public final Interpreter.write_return write() throws RecognitionException {
        Interpreter.write_return retval = new Interpreter.write_return();
        retval.start = input.LT(1);


        Interpreter.boolExpr_return e =null;


        trackSkipStack();
        try {
            // D:\\��ҵ\\Interpreter.g:420:2: ( ^( WRITE e= boolExpr ) )
            // D:\\��ҵ\\Interpreter.g:420:4: ^( WRITE e= boolExpr )
            {
            match(input,WRITE,FOLLOW_WRITE_in_write916);

            match(input, Token.DOWN, null);
            pushFollow(FOLLOW_boolExpr_in_write920);
            e=boolExpr();

            state._fsp--;


            match(input, Token.UP, null);


            if(!skip())
            					{if(e.clazz.equals("int"))
            						System.out.println((int)Double.parseDouble(e.value));
            					else if(e.clazz.equals("double"))
            						System.out.println(Double.parseDouble(e.value));
            					else
            						System.out.println(e.value);}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "write"


    public static class type_return extends TreeRuleReturnScope {
        public String value;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };


    // $ANTLR start "type"
    // D:\\��ҵ\\Interpreter.g:429:1: type returns [String value] : ( TP_INT | TP_REAL );
    public final Interpreter.type_return type() throws RecognitionException {
        Interpreter.type_return retval = new Interpreter.type_return();
        retval.start = input.LT(1);


        try {
            // D:\\��ҵ\\Interpreter.g:430:2: ( TP_INT | TP_REAL )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==TP_INT) ) {
                alt11=1;
            }
            else if ( (LA11_0==TP_REAL) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // D:\\��ҵ\\Interpreter.g:430:4: TP_INT
                    {
                    match(input,TP_INT,FOLLOW_TP_INT_in_type937); 

                    retval.value = inte;

                    }
                    break;
                case 2 :
                    // D:\\��ҵ\\Interpreter.g:431:4: TP_REAL
                    {
                    match(input,TP_REAL,FOLLOW_TP_REAL_in_type943); 

                    retval.value = real;

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
        return retval;
    }
    // $ANTLR end "type"

    // Delegated rules


 

    public static final BitSet FOLLOW_PROG_in_prog61 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stat_in_prog63 = new BitSet(new long[]{0x0008000000000008L});
    public static final BitSet FOLLOW_STAT_in_stat80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_sequenceStucture_in_stat82 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAT_in_stat90 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifClause_in_stat92 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAT_in_stat100 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_whileClause_in_stat102 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAT_in_stat110 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_breakClause_in_stat112 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BoolExpr_in_boolExpr131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_boolExpr135 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_PLUS_in_logicOr154 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr158 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_MINUS_in_logicOr176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr180 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_MULTIPLY_in_logicOr194 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr198 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_DIVIDE_in_logicOr212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr216 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_MORETHAN_in_logicOr230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr234 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr238 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_LESSTHAN_in_logicOr248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr252 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr256 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_EQUAL_in_logicOr266 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr270 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr274 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_NOTLESSTHAN_in_logicOr284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr288 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr292 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_NOTMORETHAN_in_logicOr302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr306 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr310 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_UNEQUAL_in_logicOr320 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr324 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_AND_in_logicOr338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr342 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr346 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_OR_in_logicOr356 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr360 = new BitSet(new long[]{0x00400027FFC0B030L});
    public static final BitSet FOLLOW_logicOr_in_logicOr364 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OP_NON_in_logicOr374 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_logicOr_in_logicOr378 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_logicOr389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATOM_in_atom414 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolExpr_in_atom418 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_atom431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_atom460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_atom469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_atom485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_atom496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_array512 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_array516 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_boolExpr_in_array520 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQU_in_sequenceStucture537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_defineVariable_in_sequenceStucture539 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQU_in_sequenceStucture549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_initiateVariable_in_sequenceStucture551 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQU_in_sequenceStucture561 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_defineArray_in_sequenceStucture563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQU_in_sequenceStucture574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_initiateArray_in_sequenceStucture576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQU_in_sequenceStucture586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_read_in_sequenceStucture588 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEQU_in_sequenceStucture598 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_write_in_sequenceStucture600 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DF_VAR_in_defineVariable622 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_defineVariable626 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_defineVariable630 = new BitSet(new long[]{0x0000000000000088L});
    public static final BitSet FOLLOW_boolExpr_in_defineVariable635 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_initiateVariable655 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_initiateVariable659 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_boolExpr_in_initiateVariable663 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SG_ASSIGN_in_initiateArray682 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_array_in_initiateArray686 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_boolExpr_in_initiateArray690 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DF_ARR_in_defineArray707 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_defineArray711 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_defineArray715 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_INT_in_defineArray719 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WHILE_in_whileClause747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_condition_in_whileClause751 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_body_in_whileClause754 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IF_in_ifClause777 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_condition_in_ifClause781 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_body_in_ifClause784 = new BitSet(new long[]{0x0000000000000808L});
    public static final BitSet FOLLOW_elseClause_in_ifClause787 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseClause799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ifClause_in_elseClause801 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELSE_in_elseClause810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_body_in_elseClause812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_KW_BREAK_in_breakClause823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONDITION_in_condition839 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolExpr_in_condition843 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BODY_in_body863 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stat_in_body865 = new BitSet(new long[]{0x0008000000000008L});
    public static final BitSet FOLLOW_READ_in_read882 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_read886 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_READ_in_read894 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_array_in_read898 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WRITE_in_write916 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_boolExpr_in_write920 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TP_INT_in_type937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TP_REAL_in_type943 = new BitSet(new long[]{0x0000000000000002L});

}