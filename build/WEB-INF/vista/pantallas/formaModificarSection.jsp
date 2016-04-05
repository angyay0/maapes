    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <br>
    <h3><strong><fmt:message key="formaModificarSection.titulo" /></strong></h3>

    <form id="forma" action="procesarModificarSection.do" method="post"><!-- -->
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarSection.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                  <input type='hidden' name='id' value="${formaModificarSection.id}" />
                  <input type="text"
                         name="title"
                         size="50"
                         maxlength="100"
                         value="${formaModificarSection.title}"/>
                </div>
            </div>
            <h3>Preguntas</h3>
            <br>
            <c:forEach var="question" items="${formaModificarSection.questions}">
                <div class="tr">
                    <div class="td" align="left" style="width:20%"><c:out value="${question.text}"/></div>
                    <div class="td" align="left" style="width:20%">
                      <!--<a href='solicitarListarQuestions.do'
                 class="HipervinculoAdmon">
                            <fmt:message key="formaModificarSection.etiqueta.preguntas" />
                        </a>-->
                        <a href='solicitarModificarQuestion.do?id=<c:out value="${question.id}"/>&text=<c:out value="${question.text}" />&idSection=<c:out value="${question.idSection}" />'
                          class="btn btn-warning btn-xs">
                            <fmt:message key="formaListadoQuestions.etiqueta.modificar" />
                        </a>
                        <a href='procesarEliminarSection.do?id=<c:out value="${question.id}"/>'
                 onClick="javascript: return EliminarEstado('<c:out value="${question.text}"/>')"
                 class="btn btn-danger btn-xs">
                            <fmt:message key="formaModificarSection.etiqueta.eliminarq" />
                        </a>
                    </div>
                </div>
            </c:forEach>

            <br><br>
            <div class="tr">
                <div class="td"  style="width:400px;" align="left">
                    <input type="submit"
                           name="submit"
                           value="Guardar cambios"
                           class="btn btn-primary"/>
                    <input type="submit"
                           name="org.apache.struts.taglib.html.CANCEL"
                           value="Cancelar"
                           onclick="bCancel=true;" class="btn btn-danger">
                </div>
            </div>
        </div>
    </form>
