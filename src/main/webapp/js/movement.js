$(function() {
  $("#movementprobar")

  var countDownTime = parseInt(0); // 在这里设置每道题的答题时长
  function countDown(countDownTime) {
    var timer = setInterval(function() {
      if (countDownTime <= 1) {
        loadIndex(countDownTime);
        countDownTime++;
      } else {
        clearInterval(timer);
      }
    }, 1000);
  }
  countDown(countDownTime);
  function loadIndex(countDownTime) { // 这段是计算分和秒的具体数
    var nowValue = countDownTime * 100;
    var movementprobar = $("#movementprobar");
    movementprobar.html(nowValue);
    movementprobar.attr("aria-valuenow", nowValue);
    movementprobar.css("width", nowValue + "%");
  }

});