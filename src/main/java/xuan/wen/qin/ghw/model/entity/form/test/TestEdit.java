package xuan.wen.qin.ghw.model.entity.form.test;

import lombok.Data;

/**
 * TestEdit
 * 
 * @remark 用于接收编辑参数
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月7日 下午9:17:48
 * @version 1.0
 */
@Data
public class TestEdit {
	private Integer id;
	private String remark;
	private String description;
	private boolean deleted = false;
}
