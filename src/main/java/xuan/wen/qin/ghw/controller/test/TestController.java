package xuan.wen.qin.ghw.controller.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xuan.wen.qin.ghw.core.controller.BasiceController;
import xuan.wen.qin.ghw.model.entity.dto.Test;
import xuan.wen.qin.ghw.model.entity.form.test.TestEdit;
import xuan.wen.qin.ghw.model.entity.form.test.TestSave;

/**
 * TestController
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午10:13:37
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/test/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController extends BasiceController {

	/***
	 * 获取所有的数据
	 * 
	 * @return json数组
	 */
	@RequestMapping(value = "query", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> query() {
		List<Map<String, Object>> result = testService.query();
		if (null != result && result.size() > 0) {
			jsonMap.put(CODE, SUCCESS_CODE);
			jsonMap.put(MESSAGE, SUCCESS_MESSAGE);
			jsonMap.put(INFO, result);
		}
		return jsonMap;
	}

	/***
	 * 根据主键获取数据
	 * 
	 * @param id
	 *            主键ID
	 * @return 结果
	 */
	@RequestMapping(value = "query/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> query(@PathVariable(value = "id") int id) {
		Test result = testService.queryById(id);
		if (null != result) {
			jsonMap.put(CODE, SUCCESS_CODE);
			jsonMap.put(MESSAGE, SUCCESS_MESSAGE);
			jsonMap.put(INFO, result);
		}
		return jsonMap;

	}

	/***
	 * 保存
	 * 
	 * @param form
	 *            保存参数
	 * @return 结果
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(TestSave form) {
		testService.save(form);
		if (null != form && form.getId() > 0) {
			jsonMap.put(CODE, SUCCESS_CODE);
			jsonMap.put(MESSAGE, SUCCESS_MESSAGE);
			jsonMap.put(INFO, form.getId());
		}
		return jsonMap;
	}

	/***
	 * 删除
	 * 
	 * @param id
	 *            主键ID
	 * @return 结果
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> delete(@PathVariable(value = "id") int id) {
		boolean status = testService.delete(id);
		if (status) {
			jsonMap.put(CODE, SUCCESS_CODE);
			jsonMap.put(MESSAGE, SUCCESS_MESSAGE);
		}
		return jsonMap;

	}

	/***
	 * 编辑
	 * 
	 * @param form
	 *            编辑参数
	 * @return 结果
	 */
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> edit(TestEdit form) {
		boolean status = testService.edit(form);
		if (status) {
			jsonMap.put(CODE, SUCCESS_CODE);
			jsonMap.put(MESSAGE, SUCCESS_MESSAGE);
		}
		return jsonMap;

	}

	/***
	 * 接收日期参数
	 * 
	 * @param date
	 *            日期
	 */
	@RequestMapping(value = "date", method = RequestMethod.GET)
	@ResponseBody
	public void date(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
		System.err.println("data : " + date);
	}
}
