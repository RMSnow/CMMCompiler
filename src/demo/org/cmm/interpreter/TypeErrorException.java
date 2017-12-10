package demo.org.cmm.interpreter;

public class TypeErrorException extends RuntimeException {
    private String message;
    
    public TypeErrorException(String expecting, String encoutered) {
		super();
		message = "���ʹ���" + encoutered + " ���� "
				+ expecting ;
	}
    
    public String toString(){
    	
    	return message;
    }
}
