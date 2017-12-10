package demo.org.cmm.ui;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;


public class ParserPrintStream extends PrintStream{
    
    private JTextArea component;
    private StringBuffer sb = new StringBuffer();
    private int choice;
    
    public ParserPrintStream(OutputStream out, JTextArea component,int choice){
        super(out);
        this.component = component;
        this.choice=choice;

    }
    
    /**
     * ��дwrite()�������������Ϣ��䵽GUI�����
     * @param buf
     * @param off
     * @param len
     */
    @Override
    public void write(byte[] buf, int off, int len) {
        final String message = new String(buf, off, len);
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                //sb.append(message);
            	/*����buffer�����ʱ������⣬��Ϊbuffer�����Զ��������������������
            	 * ֱ������JTextArea��append��������������ÿһappend��ʱ����һ�δ����ֵ�����
            	 * ������Ͳ�������ظ��Ķ���*/
            	
            	
            	if(choice==1)	component.setForeground(Color.red);
            	component.append(message);
                
            }
        });
        component.setForeground(Color.black);
    }
    
}