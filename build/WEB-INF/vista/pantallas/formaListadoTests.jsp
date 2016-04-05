<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html; charset=UTF-8" %>
    <br>
    <font size='5'><fmt:message key="formaListadoTests.titulo" /></font>
    <div class="table" style="width:100%" >

        <div class="tr">
            <div class="td" colspan="4">
               <html:errors />
            </div>
        </div>

        <c:forEach var="test" items="${formaListadoTests.tests}">
            <div class="tr">
                <div class="td" align="left" style="width:20%"><c:out value="${test.title}"/></div>
                <div class="td" align="left" style="width:20%">
                    <c:if test="${sessionScope.user.getIdRol() == 2}">
    					<a href='solicitarTest.do?id=<c:out value="${test.id}"/>&title=<c:out value="${test.title}" />'
    					               class="btn btn-default btn-xs">
                            <fmt:message key="formaListadoTests.etiqueta.hacer" />
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.user.getIdRol() == 1}">
                        <a href='solicitarModificarTest.do?id=<c:out value="${test.id}"/>&title=<c:out value="${test.title}" />'
    					               class="btn btn-warning btn-xs">
                            <fmt:message key="formaListadoTests.etiqueta.modificar" />
                        </a>
                        <a href='procesarEliminarTest.do?id=<c:out value="${test.id}"/>'
    					   onClick="javascript: return EliminarEstado('<c:out value="${test.title}"/>')"
    					   class="btn btn-danger btn-xs">
                            <fmt:message key="formaListadoTests.etiqueta.eliminar" />
                        </a>
                    </c:if>
                </div>
            </div>
        </c:forEach>
        <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <c:if test="${sessionScope.user.getIdRol() == 1}">
                    <a href="solicitarRegistroTest.do" class="HipervinculoAdmon boton btn btn-primary"><fmt:message key="formaListadoTests.etiqueta.agregar" /></a>
                </c:if>
            </div>
        </div>
        <div class="tr">
            <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoTests.contador}</div>
        </div>
    </div>
