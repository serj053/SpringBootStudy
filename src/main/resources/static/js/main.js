$(function () {
  const addBook = function (data) {
    var code = '<div class="get-book" data-id="'
      + data.id + '">' + data.name + '</div>';
    $('.books').append(code);
  }

  $.get('/books/', function (result) {
    for (i in result) {
      addBook(result[i]);
    }
  });

  $(document).on('click','.get-book',function () {
    alert("In get-book");
    var link = $(this);
    var id = link.data('id');
    $.get('/books/' + id, function (result) {
      $(this).after('<div>' + result.year + '</div>');
    })
  });

  //сохранить на сервере
  $('.save').click(function () {
    var data = $('.form form').serialize();
    $.ajax({
      method: "POST",
      url: '/books/',
      data: data,
      success: function (result) {
        //  for(i in result) {
        //   addBook(result[i]);
        //  }
      },
      error: function (jqXHR, textStatus, errorThrown) {
        alert("Error: " + errorThrown);
      }
    })
    //return false; // если добавить то страница не будет пергружаться после функции ajax
  });

});