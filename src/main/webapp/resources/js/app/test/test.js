$(function() {
	testFn.editMod();
});
var testFn = {
	saveMod : function() {
		var url = '/test/save.jspx';
		var param = {
			'remark' : '这是备注',
			'description' : '这是描述'
		};
		if (param) {
			$.post(url, param, function(data) {
				var code = data.code;
				console.debug(data.message);
			});
		} else {
			return false;
		}
	},
	editMod : function() {
		var url = '/test/edit.jspx';
		var param = {
			'id' : 5,
			'remark' : '这是测试备注',
			'description' : '这是测试描述'
		};
		if (param) {
			$.post(url, param, function(data) {
				var code = data.code;
				console.debug(data.message);
			});
		} else {
			return false;
		}
	},
	getListMod : function() {
		var url = '/test/get/list.jspx';
		$.get(url, function(data) {
			var code = data.code;
			console.debug('code :' + code);
		});
	},
};
