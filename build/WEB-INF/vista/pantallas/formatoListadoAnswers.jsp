    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
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
    return confirm("¿Desea eliminar el question '" + strCiudadName + "'?")
  }
-->
</script>
    <br>
    <font size='5'><fmt:message key="formaListadoAnswers.titulo" /></font>
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
        <div class="tr" style="background:#CCCCCC">
         <div class="td" style="width:20%"><b><fmt:message key="formaListadoAnswers.etiqueta.nombre" /></b></div>
         <div class="td" style="width:20%"><b><fmt:message key="formaListadoAnswers.etiqueta.administracion" /></b></div>
        </div>
        <c:forEach var="answer" items="${formaListadoAnswers.answers}">
            <div class="tr">
                <div class="td" align="left" style="width:20%"><c:out value="${answer.text}"/></div>
                
                <div class="td" align="left" style="width:20%">
                    <a href='solicitarListarAnswers.do?id=<c:out value="${answer.id}"/>'
                      class="HipervinculoAdmon">
                        <fmt:message key="formaListadoAnswers.etiqueta.respuestas" />
                    </a>
                    <a href='solicitarModificarAnswer.do?id=<c:out value="${answer.id}"/>&title=<c:out value="${answer.text}" />'
                      class="HipervinculoAdmon">
                        <fmt:message key="formaListadoAnswers.etiqueta.modificar" />
                    </a>
                    <a href='procesarEliminarAnswer.do?id=<c:out value="${answer.id}"/>'
          					   onClick="javascript: return EliminarCiudad('<c:out value="${answer.text}"/>')"
          					   class="HipervinculoAdmon">
                        <fmt:message key="formaListadoAnswers.etiqueta.eliminar" />
                    </a>
                </div>
            </div>
        </c:forEach>
        <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href="solicitarRegistroQuestion.do" class="HipervinculoAdmon boton btn btn-primary">Agregar nueva Pregunta...</a>
            </div>
        </div>
        <div class="tr">
            <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoAnswers.contador}</div>
        </div>
    </div>
