/* ::::::::::::::::::: Review Question Container width :::::::::::::::::::::*/
$("#mcq-reviewtab").click(function () {
    //$("#mcq-review-questions").css("width", "90%");
    $("#mcq-review-questions").animate({width: '90%'});
    $(".mcq-review-alert").css("display", "block");
    $("body").css("overflow", "hidden");
});

$(".mcq-review-alert").click(function () {
    $("#mcq-review-questions").animate({width: '0'});
    $(".mcq-review-alert").css("display", "none");
    $("body").css("overflow", "initial");
}); 


/* ::::::::::::::::::: Review Question Container height :::::::::::::::::::::*/

function mcqReviewSetHeight() { 
    var totalMainHeight = $(window).outerHeight() - $(".pageHeader").outerHeight() - $("aside").find("header").outerHeight(true);
    $("#mcq-review-info").css("max-height", totalMainHeight);
  
}
/*::::::::::::: Resize function :::::::::::::::::::*/
$(window).resize(function() {
    mcqReviewSetHeight(); 

});