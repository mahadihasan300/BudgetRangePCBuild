/**
 * @Author Shipon Hossain
 * @Project Inline Page
 * @Version 1.0
 * @Date 2019.10.14
 *
 */
$(document).ready(function(){
    //for delete user
	$('.btn-delete').on('click', function(e) {
		e.preventDefault();
		var href = $(this).attr('href');
		$('#delModal #btnDelteYes').attr('href', href);
		$('#delModal').modal();
	});
	
	$('.table .delBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#delModal #btnDelteYes').attr('href', href);
        $('#delModal').modal();
    });
	
});