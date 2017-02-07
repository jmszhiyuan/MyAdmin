function userContextMenu(e, rowIndex, rowData) {
	if (rowData.id) {
		e.preventDefault();
		$(this).datagrid("selectRow", rowIndex);
		$('#user-menu').menu('show', {
			left : e.pageX,
			top : e.pageY
		});
	}
}

function pagerFilter(data) {
	if (typeof data.length == 'number' && typeof data.splice == 'function') {
		data = {
			total : data.length,
			rows : data
		}
	}
	var datagrid = $(this);
	var options = datagrid.datagrid('options');
	var pager = datagrid.datagrid('getPager');
	pager.pagination({
		onSelectPage : function(pageNum, pageSize) {
			options.pageNumber = pageNum;
			options.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber : pageNum,
				pageSize : pageSize
			});
			datagrid.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (options.pageNumber - 1) * parseInt(options.pageSize);
	var end = start + parseInt(options.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
}
