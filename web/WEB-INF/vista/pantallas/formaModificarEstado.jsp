    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <br>
    <font size='5'><fmt:message key="formaModificarEstado.titulo" /></font>

    <form id="forma" action="procesarModificarEstado.do" method="post"><!-- -->
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarEstado.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                <input type='hidden' name='id' value="${formaModificarEstado.id}" />
                    <input type="text" 
                           name="nombre" 
                           size="50" 
                           maxlength="100" 
                           value="${formaModificarEstado.nombre}" />
                </div>
            </div>
            <div class="tr">
                <div class="td"  style="width:400px;" align="center">
                    <input type="submit" 
                           name="submit"
                           value="Modificar y terminar" class="btn btn-primary"/>
                    <input type="submit" 
                           name="submit"
                           value="Modificar y volver"
                           onclick="forma.action='procesarModificarEstado.do?volver=si'" class="btn btn-primary"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarModificarEstado.do'" class="btn btn-primary"/>
                    <input type="submit" 
                           name="org.apache.struts.taglib.html.CANCEL" 
                           value="cancelar" 
                           onclick="bCancel=true;" class="btn btn-danger">    
                </div>
            </div>
        </div>
    </form>
