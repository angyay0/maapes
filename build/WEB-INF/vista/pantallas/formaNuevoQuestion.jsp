    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html; charset=UTF-8" %>


    <br>
    <font size='5'><fmt:message key="formaNuevoQuestion.titulo" /></font>

    <form id="forma" action="procesarRegistroQuestion.do" method="post">
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="left">
                    <fmt:message key="formaNuevoQuestion.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                    <input type='hidden' name='idSection' value="${formaNuevoQuestion.idSection}" />
                    <input type="text"
                           name="text"
                           value="${formaNuevoQuestion.text}" />
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
