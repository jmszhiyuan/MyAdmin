/* 上下文菜单 */
function menuContextMenu(e, row) {
	if (row.id) {
		e.preventDefault();
		$(this).treegrid('select', row.id);
		$('#menu-menu').menu('show', {
			left : e.pageX,
			top : e.pageY
		});
	}
}
function collapse() {
	var node = $('#menu-treegrid').treegrid('getSelected');
	if (node) {
		$('#menu-treegrid').treegrid('collapse', node.id);
	}
}
function expand() {
	var node = $('#menu-treegrid').treegrid('getSelected');
	if (node) {
		$('#menu-treegrid').treegrid('expand', node.id);
	}
}