    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <font size='5'><fmt:message key="formaModificarGente.titulo" /></font>

    <form id="forma" action="procesarModificarGente.do" method="post">
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarGente.etiqueta.nombres" />
                </div>
                <div class="td" align="left">
                <input type='hidden' name='id' value='${formaModificarGente.id}' />
                    <input type="text" 
                           name="nombres" 
                           size="50" 
                           maxlength="100" 
                           value="${formaModificarGente.nombres}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarGente.etiqueta.apellidos" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="apellidos" 
                           size="50" 
                           maxlength="100" 
                           value="${formaModificarGente.apellidos}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarGente.etiqueta.direccion" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="direccion" 
                           size="50" 
                           maxlength="100" 
                           value="${formaModificarGente.direccion}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarGente.etiqueta.telefono" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="telefono" 
                           size="50" 
                           maxlength="100" 
                           value="${formaModificarGente.telefono}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarGente.etiqueta.ciudad" />
                </div>
                <div class="td" align="left" style="position:relative">
                   <input type="text" 
                           id ="ciudadBuscar" autocomplete="off" value="${formaNuevoGente.idCiudad}" />                  
                    <select name="idCiudad" id="idCiudad">
                    </select>
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarGente.etiqueta.estado" />
                </div>
                <div class="td" align="left" style="position:relative">
                    <div id="estadoNombre"></div>
                </div>
            </div>
            <div class="tr">
                <div class="td" style="width:400px;" align="center">
                    <input type="submit" 
                           name="submit"
                           value="Modificar y terminar" class="btn btn-primary"/>
                    <input type="submit" 
                           name="submit"
                           value="Modificar y volver"
                           onclick="forma.action='procesarModificarGente.do?volver=si'" class="btn btn-primary"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarModificarGente.do'" class="btn btn-primary"/>
                    <input type="submit" 
                           name="org.apache.struts.taglib.html.CANCEL" 
                           value="cancelar" 
                           onclick="bCancel=true;" class="btn btn-danger">    
                </div>
            </div>
        </div>
    </form>
