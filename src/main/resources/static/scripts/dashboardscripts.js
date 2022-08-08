/**
 * 
 */
 $(".nav").click(function () {
      $("#mySidenav").css('width', '0px');
      $("#main").css('margin-left', '0px');

      $(".icon-a").css('visibility', 'hidden');
      $(".icon-b").css('visibility', 'hidden');
      $(".icons").css('visibility', 'visible');
      $(".icons").css('margin-left', '-8px');
      $(".nav").css('display', 'none');
      $(".nav2").css('display', 'block');
    });

    $(".nav2").click(function () {
      $("#mySidenav").css('width', '300px');
      $("#main").css('margin-left', '300px');

      $(".icon-a").css('visibility', 'visible');
      $(".icon-b").css('visibility', 'visible');
      $(".icons").css('visibility', 'visible');
      $(".nav").css('display', 'block');
      $(".nav2").css('display', 'none');
    });

    
    function reveal1() {
      var x = document.querySelector(".toggle1").style;
      if (x.display == 'none' || x.display == '') {
        x.display = 'block';
      } else {
        x.display = 'none';
      }
    }

  
   


