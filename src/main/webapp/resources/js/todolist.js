$(".txtb").on("keyup",function(e){
    //13  means enter button
    if(e.keyCode == 13 && $(".txtb").val() != "") {
      $.ajax({
          url: '/notes',
          type: 'POST',
          dataType: 'json',
          contentType: 'application/json',
          cache: false,
          data: JSON.stringify({description: $(".txtb").val(), status: "OPEN"}),
      });

      var task = $("<div class='task'></div>").text($(".txtb").val());
      var del = $("<i class='fas fa-trash-alt'></i>").click(function(){
        var p = $(this).parent();
        p.fadeOut(function(){
          p.remove();
        });
      });

      var check = $("<i class='fas fa-check'></i>").click(function(){
        var p = $(this).parent();
        p.fadeOut(function(){
          $(".comp").append(p);
          p.fadeIn();
        });
        $(this).remove();
      });

      task.append(del,check);
      $(".notcomp").append(task);
        //to clear the input
      $(".txtb").val("");
    }
});

$(".fas.fa-trash-alt").click(function(){
    $.ajax({
        url: '/notes/' + this.id,
        type: 'DELETE'
    });

    var p = $(this).parent();
    p.fadeOut(function(){
      p.remove();
    });
});

$(".fas.fa-check").click(function(){
    $.ajax({
        url: '/notes/' + this.id,
        type: 'PUT'
    });

    var p = $(this).parent();
    p.fadeOut(function(){
      $(".comp").append(p);
      p.fadeIn();
    });
    $(this).remove();
});