<%@ page contentType="text/html; charset=UTF-8" %>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="images/TitleNLogo.png" /></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse ">
                <ul class="nav navbar-nav center-block">
                    <li><a href="irInicio.do">Inicio</a></li>
                    <li><a href="solicitarListarRoles.do">Roles</a></li>
                    <li><a href="solicitarListarEstados.do">Estados</a></li>
                    <li><a href="solicitarListarCiudades.do">Ciudades</a></li>
                    <li><a href="solicitarListarGentes.do">Personas</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Gestión de tests<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="solicitarListarTests.do">Tests</a></li>
                            <li><a href="solicitarListarSections.do">Secciones</a></li>
                        </ul>
                    </li>
                    <li><a href="irAyuda.do">Ayuda</a></li>
                    <li><a href="deleteRegistroLogin.do">Cerrar sesión</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
