    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <font size='5'><fmt:message key="formaNuevoSection.titulo" /></font>

    <form id="forma" action="procesarRegistroSection.do" method="post">
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="left">
                    <fmt:message key="formaNuevoSection.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="title"
                           value="${formaNuevoSection.title}" />
                </div>
            </div>
            <div class="tr">
                <div class="td"  style="width:400px;" align="left">
                    <input type="submit" 
                           name="submit"
                           value="Agregar" class="btn btn-primary"/>
                    <input type="submit" 
                           name="org.apache.struts.taglib.html.CANCEL" 
                           value="Cancelar" 
                           onclick="bCancel=true;" class="btn btn-danger">    
                </div>
            </div>
        </div>
    </form>
