package controller.exception;

public class NotFinishGameException extends Exception {
           
	private static final long serialVersionUID = 1L;

	public NotFinishGameException(){
    	   super("GAME IS NOT FINISHED YET");
     }
}
