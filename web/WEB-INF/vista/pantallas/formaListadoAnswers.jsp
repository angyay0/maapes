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
    <font size='5'><fmt:message key="formaListadoAnswers.titulo" /></font>
    <div class="table" style="width:100%" >
    	
        <div class="tr">
            <div class="td" colspan="4">
               <html:errors />
            </div>
        </div>

        <c:forEach var="answer" items="${formaListadoAnswers.answers}">
            <div class="tr">
                <div class="td" align="left" style="width:20%"><c:out value="${answer.text}"/></div>
                <c:if test="${answer.rgt == 1}">
					         <div class="td" align="left" style="width:20%"><input type="checkbox" checked disabled /></div>
   				      </c:if>
         				<c:if test="${answer.rgt == 0}">
      					   <div class="td" align="left" style="width:20%"><input type="checkbox"  disabled /></div>
         				</c:if>
				<div class="td" align="left" style="width:30%">
                    <a href='solicitarModificarAnswer.do?id=<c:out value="${answer.id}"/>&text=<c:out value="${answer.text}" />&idQuestion=<c:out value="${answer.idQuestion}" />&rgt=<c:out value="${answer.rgt}" />'
                      class="btn btn-warning btn-xs">
                        <fmt:message key="formaListadoAnswers.etiqueta.modificar" />
                    </a>
                    <a href='procesarEliminarAnswer.do?id=<c:out value="${answer.id}"/>'
          					   class="btn btn-danger btn-xs">
                        <fmt:message key="formaListadoAnswers.etiqueta.eliminar" />
                    </a>
                </div>
            </div>
        </c:forEach>
        <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href='solicitarRegistroAnswer.do?idQuestion=<c:out value="${formaListadoAnswers.idQuestion}"/>' class="HipervinculoAdmon boton btn btn-primary"><fmt:message key="formaListadoAnswers.etiqueta.agregar" /></a>
            </div>
        </div>
        <div class="tr">
            <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoAnswers.contador}</div>
        </div>
    </div>
