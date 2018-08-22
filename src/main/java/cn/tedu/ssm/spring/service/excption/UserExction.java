package cn.tedu.ssm.spring.service.excption;



public class UserExction extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7614981845072409177L;

	public UserExction() {
		super();
		
	}

	public UserExction(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserExction(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserExction(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserExction(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
