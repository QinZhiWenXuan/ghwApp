package xuan.wen.qin.ghw.core.exception;

/**
 * AppException
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午9:09:41
 * @version 1.0
 */
public class AppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

}
