    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <font size='5'><fmt:message key="formaNuevoEstado.titulo" /></font>

    <form id="forma" action="procesarRegistroEstado.do" method="post">
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevoEstado.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="nombre" 
                           size="50" 
                           maxlength="100" 
                           title="Solo se permiten letras"
                           pattern="^[a-zA-Z\s]*"
                           required
                           value="${formaNuevoEstado.nombre}" />
                </div>
            </div>
            <div class="tr">
                <div class="td"  style="width:400px;" align="center">
                    <input type="submit" 
                           name="submit"
                           value="Agregar y terminar" class="btn btn-primary"/>
                    <input type="submit" 
                           name="submit"
                           value="Agregar y volver"
                           onclick="forma.action='procesarRegistroEstado.do?volver=si'" class="btn btn-primary"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarRegistroEstado.do'" class="btn btn-primary"/>
                    <input type="submit" 
                           name="org.apache.struts.taglib.html.CANCEL" 
                           value="cancelar" 
                           onclick="bCancel=true;" class="btn btn-danger">    
                </div>
            </div>
        </div>
    </form>
