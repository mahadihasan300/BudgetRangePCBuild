/**
 * Custom JS from TechnoVista
 */

setTimeout(
function() {
	var message_panel = document
	.getElementById('idMessagePanel');
	if(message_panel) {
		message_panel.style.display = 'none';	
	}
}, 5000);

// Image Upload and Preview.

$('.image-field').each(function () {
    var this_image_field     = $(this);
    var this_image_holder    = this_image_field.parents('.image-form-group');
    var this_image_preview   = this_image_holder.find('.image-preview');
    var existing_image_field = this_image_holder.find('.image-existing');
    var btn_close            = this_image_holder.find('.btn-close-preview');

    this_image_field.on('change', function() {
        var img_url = URL.createObjectURL(this_image_field[0].files[0]);
        this_image_holder.addClass('has-image');
        this_image_preview.attr('src', img_url);

        this_image_preview[0].onload = function () {
            URL.revokeObjectURL(img_url) // free memory
        }
    });


    btn_close.on('click', function() {
        this_image_holder.removeClass('has-image');
        this_image_preview.attr('src', '');
        this_image_field.val('');

        // Empty existing field.
        existing_image_field.val('');
    });
});

$('.file-field').each(function () {
    var this_file_field     = $(this);
    var this_file_holder    = this_file_field.parents('.file-form-group');
    var file_name           = this_file_holder.find('.file-name');
    var existing_file_field = this_file_holder.find('.file-existing');
    var btn_close           = this_file_holder.find('.btn-close-file');

    this_file_field.on('change', function () {
        var filename = this_file_field[0].files[0].name;
        this_file_holder.addClass('has-file');
        file_name.text(filename);
    });


    btn_close.on('click', function () {
        this_file_holder.removeClass('has-file');
        file_name.text('');
        this_file_field.val('');

        // Empty existing field.
        existing_file_field.val('');
    });
});

$('form').validator().on('submit', function (e) {
    $('.file-field').each(function (index) {
        var attachment_file = $(this);
        console.log(attachment_file);
        var attachment_btn = attachment_file.parent('.btn-file');
        if (attachment_file.is(':invalid')) {
            attachment_btn.addClass('border-danger').removeClass('border-success');
            attachment_btn.siblings('.label.label-danger').remove(); // remove previously appended labels.
            attachment_btn.after('<span class="label label-danger ml-2">Required</span>');
        } else {
            attachment_btn.removeClass('border-danger').addClass('border-success');
            attachment_btn.siblings('.label.label-danger').remove();
        }
    });
});

/**
 * Search Reset Button's conditional appearance.
 * ------------------------------------
 */
var _reset_btn = $('.reset-btn');

var _search_field = $('.search-field');

if (_search_field.length > 0) {
  var _conditional_reset = function _conditional_reset() {
    if (_search_field.val().length > 0) {
      _reset_btn.fadeTo(200, 1);
    } else {
      _reset_btn.fadeTo(200, 0);
    }
  };

  _conditional_reset();

  _search_field.on('load keyup change', function () {
    _conditional_reset();
  });
}
