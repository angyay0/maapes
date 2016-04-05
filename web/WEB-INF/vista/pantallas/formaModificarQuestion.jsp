    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <font size='5'><fmt:message key="formaModificarQuestion.titulo" /></font>

    <form id="forma" action="procesarModificarQuestion.do" method="post" role="form">
        <div class="table">
            <div class="tr form-group">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr form-group">
                <div class="td" align="right">
                    <fmt:message key="formaModificarQuestion.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                	<input type='hidden' name='id' value="${formaModificarQuestion.id}" />
                	<input type='hidden' name='idSection' value="${formaModificarQuestion.idSection}" />
                    <input type="text"
                           name="text"
                           size="50"
                           maxlength="100"
                           value="${formaModificarQuestion.text}" />
                </div>
            </div>

            <div class="tr form-group">
                <div class="td" style="width:400px;" align="center">
                    <input type="submit"
                           name="submit"
                           value="Guardar cambios" class="btn btn-primary"/>
                    <input type="submit"
                           name="org.apache.struts.taglib.html.CANCEL"
                           value="cancelar"
                           onclick="bCancel=true;" class="btn btn-danger">
                </div>
            </div>
        </div>
    </form>
