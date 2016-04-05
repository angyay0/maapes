    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <font size='5'><fmt:message key="formaModificarCiudad.titulo" /></font>

    <form id="forma" action="procesarModificarCiudad.do" method="post" role="form">
        <div class="table">
            <div class="tr form-group">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr form-group">
                <div class="td" align="right">
                    <fmt:message key="formaModificarCiudad.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                	<input type='hidden' name='id' value="${formaModificarCiudad.id}" />
                    <input type="text" 
                           name="nombre" 
                           size="50" 
                           maxlength="100" 
                           value="${formaModificarCiudad.nombre}" />
                </div>
            </div>
            <div class="tr form-group">
                <div class="td" align="right">
                    <fmt:message key="formaModificarCiudad.etiqueta.estado" />
                </div>
                <div class="td" align="left">
                    <select name="idEstado" value="${formaModificarCiudad.idEstado}">
                      <c:forEach var="estado" items="${formaModificarCiudad.estados}">
                        <option value='<c:out value="${estado.id}" />'><c:out value="${estado.nombre}" /></option>
                      </c:forEach>
                    </select>
                </div>
            </div>
                  
            <div class="tr form-group">
                <div class="td" style="width:400px;" align="center">
                    <input type="submit" 
                           name="submit"
                           value="Modificar y terminar" class="btn btn-primary"/>
                    <input type="submit" 
                           name="submit"
                           value="Modificar y volver"
                           onclick="forma.action='procesarModificarCiudad.do?volver=si'" class="btn btn-primary"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarModificarCiudad.do'" class="btn btn-primary"/>
                    <input type="submit" 
                           name="org.apache.struts.taglib.html.CANCEL" 
                           value="cancelar" 
                           onclick="bCancel=true;" class="btn btn-danger">    
                </div>
            </div>
        </div>
    </form>
