$(document).ready(function(){

    //Alternar entre Adicionar e Contato
    $('#contatos-menu').click(function(){
        $('.contatos').removeClass('quiet');
        $('.add-contato-form').addClass('quiet');
    });

    $('#add-menu').click(function(){
        $('.add-contato-form').removeClass('quiet');
        $('.contatos').addClass('quiet');

    });

//--------------------ATUALIZAR---------------------- 
    $('.js-update').hide();
    $('.js-edit').click(function(){
        $(this).parent().prev().removeClass('quiet');
        $(this).parent().prev().prev().addClass('quiet');
        $(this).hide();
        $(this).siblings('.js-update').show();

        var nomeAtual = $(this).parent().prev().prev().children('h1').text();
        $(this).parent().prev().children('input[name = "nome-atual"]').val(nomeAtual);
        
        var nome = $(this).parent().prev().prev().children('h1').text();
        $(this).parent().prev().children('input[name = "nome"]').val(nome);

        var tel = $(this).parent().prev().prev().children('p.js-data-tel').text();
        $(this).parent().prev().children('input[name = "telefone"]').val(tel);

        var mail = $(this).parent().prev().prev().children('p.js-data-mail').text();
        $(this).parent().prev().children('input[name = "email"]').val(mail);

        var end = $(this).parent().prev().prev().children('p.js-data-end').text();
        $(this).parent().prev().children('input[name = "endereco"]').val(end);
    });

    $('.js-update').click(function(){
        $(this).parent().parent().attr('action', 'atualizar');
        $(this).parent().parent().attr('method', 'POST');
        
        $(this).parent().prev().addClass('quiet');
        $(this).parent().prev().prev().removeClass('quiet');

        var nome = $(this).parent().prev().children('input[name = "nome"]').val();
        $(this).parent().prev().prev().children('h1').text(nome);

        var tel = $(this).parent().prev().children('input[name = "telefone"]').val();
        $(this).parent().prev().prev().children('p.js-data-tel').text(tel);

        var mail = $(this).parent().prev().children('input[name = "email"]').val(); 
        $(this).parent().prev().prev().children('p.js-data-mail').text(mail);

        var end = $(this).parent().prev().children('input[name = "endereco"]').val();   
        $(this).parent().prev().prev().children('p.js-data-end').text(end);
        $(this).hide();
        $('.js-edit').show();
    });

//------------------------FAVORITAR--------------------------------
    
    $('input[name = "isFav"]').each(function(){
        if($(this).val() === "true"){
            var estrela = $(this).parent().prev().children().children('.fa-star');
            estrela.addClass('css-faved');
            estrela.removeClass('css-fav');
        }
    });

    $('.js-fav').click(function(){
       /* var estrela = $(this).parent().prev().prev().children().children('.fa-star');
        estrela.toggleClass('css-faved');
        estrela.toggleClass('css-fav');*/
        $(this).parent().parent().attr('action', 'favoritar');
        $(this).parent().parent().attr('method', 'POST');
        
        var nomeAtual = $(this).parent().prev().prev().children('h1').text();
        $(this).parent().prev().children('input[name = "nome-atual"]').val(nomeAtual);
        
        var fav = $(this).parent().prev().children('input[name = "isFav"]');
        var isFav = fav.val();
        if(isFav === "true"){
            fav.val('false');
        }
        else{
            fav.val('true');
        }
    });
    
    //------------------- DELETAR ----------------------------
    $('.js-del').click(function(){
        $(this).parent().parent().attr('action', 'excluir');
        $(this).parent().parent().attr('method', 'POST');
        
        var nomeAtual = $(this).parent().prev().prev().children('h1').text();
        $(this).parent().prev().children('input[name = "nome-atual"]').val(nomeAtual);
    });
});
