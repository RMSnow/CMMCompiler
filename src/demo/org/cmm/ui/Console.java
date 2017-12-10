package demo.org.cmm.ui;

import demo.org.cmm.interpreter.Interpreter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Console extends JTextArea implements KeyListener,DocumentListener,MouseListener,ActionListener{
	private GUIPrintStream os;
	private int inOffset;
	private boolean isKeyEvtAcc;
	private JPopupMenu pm;
	private JMenuItem clear;

	public Console(){
		pm = new JPopupMenu();
		clear = new JMenuItem("Clear");
		clear.addActionListener(this);
		pm.add(clear);
		this.add(pm);
		this.addMouseListener(this);
		
		
		setOffset();
		isKeyEvtAcc = false;
		os = new GUIPrintStream(System.out, this);
		System.setErr(os);
		System.setOut(os);
		this.addKeyListener(this);
		this.getDocument().addDocumentListener(this);
		this.setEditable(true);
	}
	@Override
	public void keyPressed(KeyEvent evt) {
		//offsetû��-1����Ҫ���ɾ��������������������backspaceɾ���������Ķ���
		if(!(this.isKeyEvtAcc&&this.getCaretPosition()>inOffset&&this.getSelectionStart()>inOffset)){
			evt.consume();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent evt) {
		if(!(this.isKeyEvtAcc&&this.getCaretPosition()>inOffset-1&&this.getSelectionStart()>inOffset-1)){
			evt.consume();
		}else if(evt.getKeyChar() == '\n'&&this.getText().length()>inOffset+1){
			String in = this.getText().substring(inOffset,this.getText().length()-1);
			this.isKeyEvtAcc = false;
			setOffset();
			Interpreter.readString = in;
			//System.out.print("in:"+in+" end_in");
		}
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(!this.isKeyEvtAcc)setOffset();
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		
	}
	
	public void inputAcc(){
		if(!this.getText().endsWith("\n")&&this.getText().length()!=0)this.append("\n");
		this.setCaretPosition(inOffset);
		this.isKeyEvtAcc = true;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == MouseEvent.BUTTON3){
			pm.show(this, e.getX(), e.getY());
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getActionCommand().equals(clear.getActionCommand())){
			clear();
		}
	}
	
	public void clear(){
		try {
			this.getDocument().remove(0, this.getText().length());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		os.reset();
		inOffset = 0;
	}
	
	public void setOffset(){
		this.inOffset = this.getText().length();
	}

}
