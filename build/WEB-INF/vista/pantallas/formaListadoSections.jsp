<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html; charset=UTF-8" %>

    <br>
    <font size='5'><fmt:message key="formaListadoSections.titulo" /></font>
    <div class="table" style="width:100%" >

        <div class="tr">
            <div class="td" colspan="4">
               <html:errors />
            </div>
        </div>

        <c:forEach var="section" items="${formaListadoSections.sections}">
            <div class="tr">
                <div class="td" align="left" style="width:20%"><c:out value="${section.title}"/></div>
                <div class="td" align="left" style="width:20%">
                	<a href='solicitarListarQuestions.do?idSection=<c:out value="${section.id}"/>'
					   class="btn btn-default btn-xs">
                        <fmt:message key="formaListadoSections.etiqueta.preguntas" />
                    </a>
                    <a href='solicitarModificarSection.do?id=<c:out value="${section.id}"/>&title=<c:out value="${section.title}" />'
					   class="btn btn-warning btn-xs">
                        <fmt:message key="formaListadoSections.etiqueta.modificar" />
                    </a>
                    <a href='procesarEliminarSection.do?id=<c:out value="${section.id}"/>'
					   onClick="javascript: return EliminarEstado('<c:out value="${section.title}"/>')"
					   class="btn btn-danger btn-xs">
                        <fmt:message key="formaListadoSections.etiqueta.eliminar" />
                    </a>
                </div>
            </div>
        </c:forEach>
        <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href="solicitarRegistroSection.do" class="HipervinculoAdmon boton btn btn-primary"><fmt:message key="formaListadoSections.etiqueta.agregar" /></a>
            </div>
        </div>
        <div class="tr">
            <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoSections.contador}</div>
        </div>
    </div>
