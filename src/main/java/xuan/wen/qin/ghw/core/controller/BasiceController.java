package xuan.wen.qin.ghw.core.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import xuan.wen.qin.ghw.service.test.TestService;

/**
 * BasiceController
 * 
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午9:12:34
 * @version 1.0
 */
@Controller
public abstract class BasiceController {
	protected static final String CODE = "code";
	protected static final String INFO = "info";
	protected static final String MESSAGE = "message";
	protected static final String FAIL_CODE = "400";
	protected static final String SUCCESS_CODE = "200";
	protected static final String FAIL_MESSAGE = "execute fail";
	protected static final String SUCCESS_MESSAGE = "execute success";
	protected Map<String, Object> jsonMap;
	@Autowired(required = true)
	@Qualifier(value = "testService")
	protected TestService testService;

	@ModelAttribute
	protected void init() {
		jsonMap = new HashMap<String, Object>(4);
		jsonMap.put(CODE, FAIL_CODE);
		jsonMap.put(MESSAGE, FAIL_MESSAGE);
	}
}
