    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <font size='5'><fmt:message key="formaNuevoTest.titulo" /></font>

    <html:form styleId="forma" action="procesarRegistroTest.do" method="post">
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="left">
                    <fmt:message key="formaNuevoTest.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="title"
                           value="${formaNuevoTest.title}" />
                </div>
            </div>

			<div class="tr">
              <div class="td" align="left">
                  <h4><fmt:message key="formaNuevoTest.etiqueta.subtitulo" /></h4>
              </div>
            </div>
            <div class="tr">
              	<div class="td" aligh="right">
		      		<c:forEach var="section" items="${formaNuevoTest.sections}">
            		
               			<label>
               				<input type="checkbox" name="selected" value="${section.id}" /> <c:out value="${section.title}" />
           				</label><br>
               
            	
        		</c:forEach>
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
    </html:form>
