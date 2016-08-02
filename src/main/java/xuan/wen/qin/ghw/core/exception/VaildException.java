package xuan.wen.qin.ghw.core.exception;

/**
 * VaildException
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午9:11:16
 * @version 1.0
 */
public class VaildException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VaildException() {
		super();
	}

	public VaildException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VaildException(String message, Throwable cause) {
		super(message, cause);
	}

	public VaildException(String message) {
		super(message);
	}

	public VaildException(Throwable cause) {
		super(cause);
	}

}
