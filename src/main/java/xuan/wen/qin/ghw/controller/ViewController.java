package xuan.wen.qin.ghw.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xuan.wen.qin.ghw.core.controller.BasiceController;
import xuan.wen.qin.ghw.model.ViewParameter;

/**
 * ViewController
 * 
 * @remark 视图跳转控制器
 * @author xuan
 * @email 1194941255@qq.com
 * @date 2016年7月5日 下午9:23:15
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/{module}/", method = { RequestMethod.GET }, produces = MediaType.TEXT_HTML_VALUE)
public class ViewController extends BasiceController {
	/** 文件分隔符 **/
	private static final String SPLIT = "/";
	/** logger **/
	private static final Logger logger = LoggerFactory
			.getLogger(ViewController.class);

	/***
	 * 跳转到页面
	 * 
	 * @remark 页面目录通过url拼成,在映射到对应目录 as test/index
	 * 
	 * @param module
	 *            模块 as test
	 * @param operation
	 *            操作 as index
	 * @param model
	 *            model
	 * @param param
	 *            参数
	 * @return 页面
	 */
	@RequestMapping(value = "t_v/{operation}")
	public String toView(@PathVariable(value = "module") String module,
			@PathVariable(value = "operation") String operation, Model model,
			ViewParameter param , HttpServletRequest request) {
		StringBuilder view = new StringBuilder(module).append(SPLIT).append(
				operation);
		model.addAttribute("param", param).addAttribute("ctx" , request.getContextPath());
		logger.debug("page request target : {}", view.toString());
		return view.toString();

	}

	/***
	 * 跳转到页面
	 * 
	 * @remark 页面目录通过url拼成,在映射到对应目录 as role/permission/index
	 * 
	 * @param module
	 *            模块 as role
	 * @param function
	 *            功能 as permission
	 * @param operation
	 *            操作 as index
	 * @param model
	 *            model
	 * @param param
	 *            参数
	 * @return 页面
	 */
	@RequestMapping(value = "{function}/t_v/{operation}")
	public String toView(@PathVariable(value = "module") String module,
			@PathVariable(value = "function") String function,
			@PathVariable(value = "operation") String operation, Model model,
			ViewParameter param, HttpServletRequest request) {
		StringBuilder view = new StringBuilder(module).append(SPLIT)
				.append(function).append(SPLIT).append(operation);
		model.addAttribute("param", param).addAttribute("ctx" , request.getContextPath());
		logger.debug("page request target : {}", view.toString());
		return view.toString();

	}

}
