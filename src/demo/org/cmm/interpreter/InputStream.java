package demo.org.cmm.interpreter;

public class InputStream {
	private String data;
	
	public InputStream(){}
	public InputStream(String s){
		this.data = s;
	}
	
	//convert to code stream, so that it can be used by Lexer,Parser and Interpreter
	public String convertToCodeStream(){
		String codeStream = "";
		codeStream = data;
		//codeStream = codeStream.replaceAll("//[^\n]*\n", "\n");
		//codeStream = codeStream.replaceAll("/\\*([^*/]*|\\*[^/]|(^\\*)/)*\\*/", "");
		for(int start = 0;true;){
			start = codeStream.indexOf("//");
			if(start<0)break;
			boolean isInString = false;
			for(int i=start;i>=0;i--){
				if(codeStream.charAt(i)=='\n')break;
				else if(codeStream.charAt(i)=='"')isInString = isInString?false:true;
			}
			if(isInString)break;
			codeStream = codeStream.substring(0,start)+codeStream.substring(codeStream.indexOf('\n',start));
		}
		for (int start = 0,end = 0;true;) {
			start = codeStream.indexOf("/*");
			end = codeStream.indexOf("*/", start);
			if (start<0||end<=start)
				break;
			boolean isInString = false;
			for(int i=start;i>=0;i--){
				if(codeStream.charAt(i)=='\n')break;
				else if(codeStream.charAt(i)=='"')isInString = isInString?false:true;
			}
			if(isInString)break;
			String s = codeStream.substring(start, end + 2);
			String ss = "";
			for(int i = 0;i<s.length();i++){
				if(s.charAt(i) == '\n')ss=ss+"\n";
			}
			codeStream = codeStream.substring(0, start)+ss+codeStream.substring(end+2);
		}
		//System.out.println(codeStream);
		return codeStream;
	}
	
	public static void main(String[] args){
		System.out.println(new InputStream("we/*q2131\nwe*/eqw").convertToCodeStream());
	}
}
