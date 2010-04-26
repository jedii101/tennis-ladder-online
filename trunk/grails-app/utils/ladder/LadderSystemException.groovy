package ladder
class LadderSystemException extends RuntimeException{
	LadderSystemException(String _message){
		this.message=_message
	}
	String message	
}