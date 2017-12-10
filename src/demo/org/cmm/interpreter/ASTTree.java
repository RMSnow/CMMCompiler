package demo.org.cmm.interpreter;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import javax.swing.*;
import java.io.StringBufferInputStream;


public class ASTTree {
	
	public static CommonTree t;
	
    public static JTree main1(String str,JTextArea jta) throws Exception {

    	//����ض���
//    	System.setOut(new GUIPrintStream(System.out,lex));    	
    	
    	ANTLRInputStream input = new ANTLRInputStream(new StringBufferInputStream(str));
        ASTLexer lexer = new ASTLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ASTParser parser = new ASTParser(tokens);
        
        ASTParser.prog_return r = parser.prog();
        
        t = (CommonTree)r.getTree();
       
		JTree tempTree=CMMTree.outTree(t);
		//
		//System.out.println(tempTree.toString());
		//System.setOut(new ParserPrintStream(System.err,jta,0));
		//System.setErr(new ParserPrintStream(System.err,jta,1));
        //CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
//        Eval walker = new Eval(0,nodes);
//       walker.prog();
		System.out.println("******��������******");
		return tempTree;
		//walker.clear();
		//System.exit(0);
		//STable.clear();
    }

}