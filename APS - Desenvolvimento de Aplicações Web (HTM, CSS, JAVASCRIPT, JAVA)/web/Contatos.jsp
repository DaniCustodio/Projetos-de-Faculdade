<%-- 
    Document   : Contatos
    Created on : 22/05/2018, 15:49:57
    Author     : Danielle Custodio
--%>

<%@page import="aps.desenvolvimentoweb.Controller.LoginController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aps.desenvolvimentoweb.appcontatos.Contato"%>
<%@page import="java.util.List"%>
<%@page import="aps.desenvolvimentoweb.appcontatos.Usuario"%>
<%@page import="aps.desenvolvimentoweb.DAO.UsuarioMock"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/estilo_contacts.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
    integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
    crossorigin="anonymous">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/js_contacts.js"></script>
    <script>
        var map;
        function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {
                center: new google.maps.LatLng(-22.9035, -43.2096),
                zoom: 10
            });

            var geocoder = new google.maps.Geocoder();
            function getCoordinates(address, callback){
                var coordinates;
                geocoder.geocode({address: address}, function(results, status){
                coordinates = results[0].geometry.location;
                callback(coordinates);
                });
            }
            
            function createMarker(location, html) {
                var newmarker = new google.maps.Marker({
                position: location,
                map: map,
                title: html
                });
    
                newmarker['infowindow'] = new google.maps.InfoWindow({
                    content: '<h1>' + html + '</h1>'
                });
            
                google.maps.event.addListener(newmarker, 'click', function() {
                    this['infowindow'].open(map, this);
                });
            }
            
            $(".js-show-contatos").each(function(){
                var end = $(this).children('.js-data-end').text();
                var nome = $(this).children("[name='show-name']").text();
                getCoordinates(end, function(coords){
                    createMarker(coords, nome);
                });
            });     
        }
    </script>
    <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDKH7LTfhwtWP5x7yZtX79HfE6DO0q9fuA&callback=initMap">
    </script>
    <title>Contatos</title>
</head>
<body>
 <%
    if(request.getSession().getAttribute("usuarioLogado") != null) {
 %>
        <div class="page">
            <!--HEADER-->
            <header class="flex">
                <div class="header-footer-contents">
                    <p class="logo">UNICARIOCA</p>
                    <p id="title">Contatos</p>
                    <p id="user">Olá, <%=session.getAttribute("usuarioLogado")%></p>
                </div>
            </header>

           <!--CONTATOS-->
            <div class="sidebar">
                <div class="panel">
                    <div class="panel-header"><a href="#contatos" id="contatos-menu">Contatos</a> <a href="#" id="add-menu">Adicionar</a></div>
                    <div class="panel-body">
                        <div class="contatos">
                            <ul class="lista-contatos">
                                <%
                                    List<Usuario> listaUsuarios = (ArrayList<Usuario>)request.getSession().getAttribute("listaUsuarios");
                                %>
                                <%for(Usuario usuario: listaUsuarios){%>
                                    <%if(session.getAttribute("usuarioLogado").equals(usuario.getNomeUsuario())){%>
                                        <%List<Contato> listaContatos = usuario.getListaContatos();%>
                                        <%for(Contato contato: listaContatos){%>
                                            <li class="item-lista">
                                                <form class="css-form-contatos">
                                                    <div class="js-show-contatos">
                                                        <h1 name= "show-name"><%= contato.getNomeContato()%><span class="fas fa-star css-fav"></span></h1>
                                                        <p class="css-campo">Telefone:</p>
                                                        <p class="js-data-tel css-data"><%=contato.getTelefone()%></p>
                                                        <p class="css-campo">Email:</p>
                                                        <p class="js-data-mail css-data"><%=contato.getEmail()%></p>
                                                        <p class="css-campo">Endereco:</p>
                                                        <p class="js-data-end css-data"><%=contato.getEndereco()%></p>
                                                    </div>
                                                    <div class="js-form-inputs quiet">
                                                        <input type="text" name="nome" placeholder="Nome">
                                                        <input type="text" name="telefone" placeholder="Telefone">
                                                        <input type="text" name="email" placeholder="Email">
                                                        <input type="text" name="endereco" placeholder="Endereço">
                                                        <input name="nome-atual" type="hidden">
                                                        <input name="isFav" type="hidden" value = "<%=contato.getIsFav()%>">
                                                    </div>
                                                    <div class="css-form-icons">
                                                        <input class="js-fav js-buttons" type="submit" value="Favoritar" >
                                                        <span class="js-edit js-buttons">Editar</span>
                                                        <input class="js-update js-buttons" type="submit" value="Atualizar" >
                                                        <input class="js-del js-buttons" type="submit" value="Deletar" >
                                                    </div>
                                                </form>                              
                                            </li>
                                        <%}%>
                                    <%}%>
                                <%}%>
                            </ul>
                        </div>
                            <form class="add-contato-form quiet" action="addcontato" method="POST">
                                <h1>Adicionar Contato</h1>
                                <input class="css-add-contato-campo" type="text" name="add-nomeContato" placeholder="Nome">
                                <input class="css-add-contato-campo" type="text" name="add-telefone" placeholder="Telefone">
                                <input class="css-add-contato-campo" type="text" name="add-email" placeholder="Email">
                                <input class="css-add-contato-campo" type="text" name="add-endereco" placeholder="Endereço">
                                <input class="css-add-contato-campo css-add-btn" type="submit" value="Adicionar">
                            </form>
                    </div>
                </div>
            </div>

            <!--MAPA-->
            <div class="main">
                <div class="panel">
                    <div class="panel-header">Map</div>
                    <div class="panel-body">
                            <div id="map">

                            </div>
                    </div>
                </div>
            </div>

            <!--FOOTER-->
            <footer class="flex">
                <div class="header-footer-contents">
                    <p class="logo">UNICARIOCA</p>
                </div>
            </footer>
        </div>
    <%}%>
</body>
</html>
