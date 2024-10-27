var redirectToPedido = function(){
    window.location = "order";
}

$(window).on('load', function(){
    $(".js-novo-pedido").bind( "click", redirectToPedido);
});


$('.js-novo-usuario').on('click', function () {
    window.location = "/AcademiaHybris_war/user";
});