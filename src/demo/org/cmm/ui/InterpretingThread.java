package demo.org.cmm.ui;

import demo.org.cmm.interpreter.ASTLexer;
import demo.org.cmm.interpreter.ASTParser;
import demo.org.cmm.interpreter.InputStream;
import demo.org.cmm.interpreter.Interpreter;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.BufferedTreeNodeStream;

public class InterpretingThread extends Thread {
	private Editor editor;
	
	public InterpretingThread(Editor editor){
		this.editor = editor;
	}

	public void run(){
		try {
			ASTLexer lex = new ASTLexer(
					new ANTLRStringStream(new InputStream(
							editor.editPane.getText())
							.convertToCodeStream()));
			CommonTokenStream tokens = new CommonTokenStream(
					lex);

			ASTParser parser = new ASTParser(tokens);
			ASTParser.prog_return r;
			r = parser.prog();
			BufferedTreeNodeStream nodes = new BufferedTreeNodeStream(
					r.getTree());

			Interpreter walker = new Interpreter(nodes,editor);
			walker.prog();
		} catch (RecognitionException e1) {
			e1.printStackTrace();
		}

	}
	public void Sleep(int t){
		try {
			this.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
