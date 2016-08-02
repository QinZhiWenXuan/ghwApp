package xuan.wen.qin.ghw.model.entity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Test
 * 
 * @remark test 数据传输对象
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月6日 下午9:54:28
 * @version 1.0
 */
@Data
public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;
	private String remark ;
	private String description  ;
	private boolean deleted ;
	private Date createDate ;
	private Date editDate ;

}
