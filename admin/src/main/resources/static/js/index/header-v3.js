$(function(){
  $(".nav-header-v1 .dropdown").each(function(){
    $(this).prepend("<a class='dropdown-btn' href='javascript:;'></a>")
  })
  $("#navbar").on("show.bs.collapse",function () {
    var self = $(this)
    $("body").append("<div class='navbar-backdrop-close'></div>")
    setTimeout(function(){
      self.addClass("navbar-open")
      $(".navbar-backdrop-close").addClass("open")
    },1)
    $("body").addClass("modal-open")
  })
  $("#navbar").on("hide.bs.collapse",function () {
    $(this).removeClass("navbar-open")
    $(".navbar-backdrop-close").removeClass("open")
  })
  $("#navbar").on("hidden.bs.collapse",function () {
    $("body").removeClass("modal-open")
    $(".navbar-backdrop-close").remove()
  })
  $(document).on("click",".navbar-backdrop-close", function(){
    $("#navbar").collapse("hide")
    $('.nav-header-v1 .dropdown-btn').removeClass('active')
  })
  $(document).on("click",".dropdown-btn", function(){
    $(this).toggleClass("active")
  })
})
$(window).on("scroll", function(){
  var t = $(window).scrollTop()
  if( t > 100 ){
    $(".header-v1").addClass("header-active")
  }else{
    $(".header-v1").removeClass("header-active")
  }
})
$('.dd-toggle .navbar-toggle').on('click', function () {
  if ($('.dd-toggle .navbar-toggle').hasClass('collapsed') == false) {
    $('.nav-header-v1 .dropdown-btn').removeClass('active')
  }
})