package demo.org.cmm.ui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import java.io.OutputStream;
import java.io.PrintStream;

public class GUIPrintStream extends PrintStream {
	private JTextComponent component;
	//private StringBuffer sb = new StringBuffer();

	public GUIPrintStream(OutputStream out, JTextComponent component) {
		super(out);
		this.component = component;
	}
	
	public void reset(){
		//sb = new StringBuffer();
	}

	public void write(byte[] buf, int off, int len) {
		final String message = new String(buf, off, len);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//sb.append(message);
				try {
					component.getDocument().insertString(component.getText().length(), message, null);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//component.setText(sb.toString());
				((Console)component).setOffset();
			}
		});
	}
}
