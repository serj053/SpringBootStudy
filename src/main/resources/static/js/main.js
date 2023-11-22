$(function () {
  const addBook = function (data) {
    var code = '<div>' + data.name + '</div>' +
      '<div>' + data.year + '</div>';
    $('.books').append(code);
  }

  $.get('GET', function (result) {
    addBook(result);
  })
  //сохранить на сервере
  $('.save').click(function () {
    var data = $('.form form').serialize();
    $.ajax({
      method: "POST",
      url: '/books/',
      data: data,
      success: function (result) {
       for(i in result) {
        addBook(result[i]);
       }
      },
      error: function (jqXHR, textStatus, errorThrown) {
        alert("Error: " + errorThrown);
      }
    })
  })

});