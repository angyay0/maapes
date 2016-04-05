    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <br>
    <h1><fmt:message key="formaVerTest.titulo" /></h1>

   	  <h2><c:out value="${formaVerTest.title}" /></h2>
      <p><strong>INSTRUCCIONES:</strong> Selecciona la respuesta correcta.
      </p>
      <html:form styleId="forma" action="procesarRespuestas.do" method="post">
        <input type="hidden" name="idTest" value="${formaVerTest.id}">
          <c:forEach var="section" items="${formaVerTest.sections}">
          		<fieldset class="sectionTest">
          			<legend><strong>Sección: </strong><c:out value="${section.getKey().title}" /></legend>

      		  		<c:forEach var="question" items="${section.getValue()}" >
      		  			<h4><strong><c:out value="${question.getKey().text}" /></strong></h4>

						<c:forEach var="answer" items="${question.getValue()}" >
							<input type="radio" value="${answer.id}" name="selected[${question.getKey().id}].line" /><c:out value="${answer.text}" />
              			</c:forEach>
              			<br/><br/>

              		</c:forEach>
              	</fieldset>
                <br/><br/>
          </c:forEach>

        <div class="tr">
        	<div class="td"  style="width:400px;" align="left">
            	<input type="submit"
                       name="submit"
                       value="Enviar" class="btn btn-primary"/>
                <input type="submit"
                       name="org.apache.struts.taglib.html.CANCEL"
                       value="Cancelar"
                       onclick="bCancel=true;" class="btn btn-danger">
            </div>
        </div>
      </html:form>
