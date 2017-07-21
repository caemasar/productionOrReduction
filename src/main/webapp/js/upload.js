function delivery() {
  var options = {
    type: 'post',
    url: 'upload.action',
    success: function(data) {
      console.log(data);
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