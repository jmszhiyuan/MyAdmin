$(function() {
	/** ********退出系统************ */
	$("#btnExit").click(function() {
		if (window.confirm("确认要退出系统吗？")) {
			window.location.href = 'logout';
		}
	});
	/** ********个人信息************ */
	$("#btnUser").click(function() {
		$.messager.alert("提示", "个人信息！", "info");
	});
});

function loadhtml(title, icon, url) {
	if ($('#maincenter').panel('options').href != url) {
		$('#maincenter').panel({
			title : title,
			iconCls : icon,
			href : url
		});
	}
}

function openwindow(url) {
	$('#modalwindow').panel({
		href : url
	});
	$('#modalwindow').window('open');
}