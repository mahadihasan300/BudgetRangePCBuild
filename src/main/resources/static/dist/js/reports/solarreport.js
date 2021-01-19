/**
 * 
 */
$(function() {
	var container = $('.report-rows');
	var viewer = $('.report-view');
	var reports = {};
	var reportForm = $('.report-form form');
	var reportFr = $('#report-form');
	var report;
	var pdf = $('#btn-pdf');
	// var reportViewport = $('#report-viewport');
	var progressLoader = $('#loadingmessage');

	$('.report-trigger')
			.on(
					'click',
					function(e) {
						e.preventDefault();
						var this_trigger = $(this);
						var mode = this_trigger.val();
						var type = "PDF";

						var htmlViewer = document
								.getElementById("report-viewport");

						var pdfViewer = document.getElementById('myIframe');

						var base_url = window.location.origin;

						if ('pdf' === this_trigger.val()) {

							htmlViewer.style.display = "none";

							pdfViewer.style.display = "block";

							var values = reportFr.serialize();

							// Set mode value on-the-fly instead of a hidden
							// field.
							values = values;
							// console.log(values);
							var trackingNo = $("#trackingNo").val();
							var applicantName = $("#applicantName").val();

							if (trackingNo.length == 0
									&& applicantName.length == 0) {
								alert("Please provide atleast one parameter.");
							} else {
								viewer.find('.content').html("");

								$.ajax({
									type : 'POST',
									url : reportFr.attr('action') + "/" + mode, // grab
									// URL
									// from
									// the
									// form's
									// action
									// attribute
									data : values,
									beforeSend : function() {
										progressLoader.show(); // show
									},
									success : function(response) {
										progressLoader.hide(); // hide
										pdfViewer.src = base_url
												+ reportFr.attr('action') + "?"
												+ values;
									},
									error : function(jqXHR, textStatus,
											errorThrown) {
										console.error(textStatus, errorThrown);
									}
								});
							}

							// $.post(reportFr.attr('action') + "/" + mode,
							// values,
							// function(res) {
							// pdfViewer.src = base_url +
							// reportFr.attr('action') + "?"
							// + values;
							// // pdfViewer.src =
							// 'http://localhost:8080/report/rpt_employee_all?p_name=Mayeenul+Islam&p_email='+
							// "&output=embed";
							// });
						} else if ('html' === this_trigger.val()) {

							htmlViewer.style.display = "block";

							pdfViewer.style.display = "none";

							var values = reportFr.serialize();

							// Set mode value on-the-fly instead of a hidden
							// field.
							values = values;
							// console.log(values);

							var trackingNo = $("#trackingNo").val();
							var applicantName = $("#applicantName").val();

							if (trackingNo.length == 0
									&& applicantName.length == 0) {
								alert("Please provide atleast one parameter.");
							} else {

								viewer.find('.content').html("");

								$
										.ajax({
											type : 'POST',
											url : reportFr.attr('action') + "/"
													+ mode, // grab URL
											// from the
											// form's
											// action
											// attribute
											data : values,
											beforeSend : function() {
												progressLoader.show(); // show
											},
											success : function(res) {
												progressLoader.hide(); // hide
												$(res)
														.each(
																function(i,
																		item) {
																	if (item.nodeName === 'STYLE') {
																		$(
																				'head')
																				.append(
																						item);
																	} else if (item.nodeName === 'TABLE') {
																		item.classList
																				.add(
																						'table',
																						'table-bordered',
																						'table-striped',
																						'table-backgraound-white');
																		item.style.width = "auto";
																		viewer
																				.find(
																						'.content')
																				.append(
																						item);
																	}
																})
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.error(textStatus,
														errorThrown);
											}
										});
							}

							// $.post(reportFr.attr('action') + "/" + mode,
							// values,
							// function(res) {
							// $(res).each(function(i, item) {
							// if (item.nodeName === 'STYLE') {
							// $('head').append(item);
							// } else if (item.nodeName === 'TABLE') {
							// item.classList.add('table',
							// 'table-bordered','table-striped','table-backgraound-white');
							// item.style.width = "auto";
							// viewer.find('.content').append(item);
							// }
							// })
							//            		
							// });
						} else {
							reportFr.submit();
						}
					});

})