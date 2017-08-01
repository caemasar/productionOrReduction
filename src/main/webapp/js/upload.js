function delivery() {
  var options = {
    type: 'post',
    url: 'upload.action',
    success: function(data) {
      console.log(data);
      fuckTheLabel();
    },
    error: function(XmlHttpRequest, textStatus, errorThrown) {
      console.log(XmlHttpRequest);
      console.log(textStatus);
      console.log(errorThrown);
    }
  }
  $("#uploadForm").ajaxSubmit(options);
  $('#uploadModal').modal('hide');
}
function fuckTheLabel() {
  var uploadBox = $("#uploadBox");
  $.ajax({
    url: "upload!findAll.action",
    async: false,
    dataType: "json",
    success: function(data) {
      $.each(data, function(index, content) {
        console.log("index: " + index + ",and content.up_filename"
                + content.up_filename);
      });
    },
    error: function(XmlHttpRequest, textStatus, errorThrown) {
      console.log(XmlHttpRequest);
      console.log(textStatus);
      console.log(errorThrown);
    }
  });
}
//$(function() {
//  fuckTheLabel();
//});