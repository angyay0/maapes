    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html; charset=UTF-8" %>
<style>
  .HipervinculoAdmon{
    color:#000000;
	text-decoration:none;
  }

  .HipervinculoAdmon:hover{
    color:#006666;
	text-decoration:underline;
  }
</style>
<script language="javascript" type="text/javascript">
<!--
  function EliminarCiudad(strCiudadName){
    return confirm("Desea eliminar el question '" + strCiudadName + "'?")
  }
-->
</script>
    <br>
    <font size='5'><fmt:message key="formaListadoQuestions.titulo" /></font>
    <div class="table" style="width:100%" >
    <!--    <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href="solicitarRegistroCiudad.do" class="HipervinculoAdmon boton btn btn-primary">Agregar nueva pregunta...</a>
            </div>
        </div> -->
        <div class="tr">
            <div class="td" colspan="4">
               <html:errors />
            </div>
        </div>

        <c:forEach var="question" items="${formaListadoQuestions.questions}">
            <div class="tr">
                <div class="td" align="left" style="width:20%"><c:out value="${question.text}"/></div>

                <div class="td" align="left" style="width:30%">
                    <a href='solicitarListarAnswers.do?idQuestion=<c:out value="${question.id}"/>'
                      class="btn btn-default btn-xs">
                        <fmt:message key="formaListadoQuestions.etiqueta.respuestas" />
                    </a>
                    <a href='solicitarModificarQuestion.do?id=<c:out value="${question.id}"/>&text=<c:out value="${question.text}" />&idSection=<c:out value="${question.idSection}" />'
                      class="btn btn-warning btn-xs">
                        <fmt:message key="formaListadoQuestions.etiqueta.modificar" />
                    </a>
                    <a href='procesarEliminarQuestion.do?id=<c:out value="${question.id}"/>'
          					   onClick="javascript: return EliminarCiudad('<c:out value='${question.text}'/>')"
          					   class="btn btn-danger btn-xs">
                        <fmt:message key="formaListadoQuestions.etiqueta.eliminar" />
                    </a>
                </div>
            </div>
        </c:forEach>
        <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href='solicitarRegistroQuestion.do?idSection=<c:out value="${formaListadoQuestions.idSection}"/>' class="HipervinculoAdmon boton btn btn-primary"><fmt:message key="formaListadoQuestions.etiqueta.agregar" /></a>
            </div>
        </div>
        <div class="tr">
            <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoQuestions.contador}</div>
        </div>
    </div>
