$.extend($.fn.validatebox.defaults.rules, {
	num: {
		validator: function(value) {
			return !/\D/i.test(value);
		},
		message: '只能够输入数字'
	}
});