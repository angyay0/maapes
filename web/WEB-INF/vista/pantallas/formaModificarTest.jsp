    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <br>
    <h3><strong><fmt:message key="formaModificarTest.titulo" /></strong></h3>

    <html:form styleId="forma" action="procesarModificarTest.do" method="post"><!-- -->
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaModificarTest.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                  <input type='hidden' name='id' value="${formaModificarTest.id}" />
                  <input type="text" 
                         name="title" 
                         size="50" 
                         maxlength="100" 
                         value="${formaModificarTest.title}"/>
                </div>
            </div>
            <div class="tr">
              <div class="td" align="left">
                  <h4><fmt:message key="formaModificarTest.etiqueta.subtitulo" /></h4>
              </div>
            </div>
            <div class="tr">
              	<div class="td" aligh="right">
		      			<c:forEach var="section" items="${formaModificarTest.sections}">
		           			<label>
		           				<c:if test='${section.getKey().split("-")[0].equals("1")}' >
	           						<input type="checkbox" name="selected" value="${section.getValue().id}" checked/> <c:out value="${section.getValue().title}" />
	           					</c:if>
	           					<c:if test='${section.getKey().split("-")[0].equals("0")}' >
	           						<input type="checkbox" name="selected" value="${section.getValue().id}" /> <c:out value="${section.getValue().title}" />
	           					</c:if>
		       				</label><br>
           				</c:forEach>
              </div>
            </div>
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
    </html:form>
