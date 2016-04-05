    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
    <%@ page contentType="text/html; charset=UTF-8" %>

    <br>
    <font size='5'><fmt:message key="formaModificarAnswer.titulo" /></font>

    <form id="forma" action="procesarModificarAnswer.do" method="post" role="form">
        <div class="table">
            <div class="tr form-group">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr form-group">
                <div class="td" align="right">
                    <fmt:message key="formaModificarAnswer.etiqueta.nombre" />
                </div>
                <div class="td" align="left">
                	<input type='hidden' name='id' value="${formaModificarAnswer.id}" />
                	<input type='hidden' name='idQuestion' value="${formaModificarAnswer.idQuestion}" />
                    <input type="text"
                           name="text"
                           size="50"
                           maxlength="100"
                           value="${formaModificarAnswer.text}" />
               </div>
           </div>
           <div class="tr form-group">
               <div class="td" align="right">
                    <fmt:message key="formaModificarAnswer.etiqueta.subtitulo" />
                </div>
                <div class="td" align="left">
                           <c:choose>
                                  <c:when test="${formaModificarAnswer.rgt == 1}">
                                      <input type="radio"
                                             name="rgt"
                                             value="${formaModificarAnswer.rgt}" checked/>Sí
                                     <br>
                                     <input type="radio"
                                            name="rgt"
                                            value="0"/>No

                                  </c:when>

                                  <c:otherwise>
                                      <input type="radio"
                                             name="rgt"
                                             value="1"/>Sí
                                      <br>
                                      <input type="radio"
                                             name="rgt"
                                             value="${formaModificarAnswer.rgt}" checked/>No
                                  </c:otherwise>
                            </c:choose>
            </div>
        </div>
        <div class="tr form-group">
            <div class="td" style="width:400px;" align="center">
                <input type="submit"
                       name="submit"
                       value="Guardar cambios" class="btn btn-primary"/>
                <input type="submit"
                       name="org.apache.struts.taglib.html.CANCEL"
                       value="cancelar"
                       onclick="bCancel=true;" class="btn btn-danger">
            </div>
        </div>
    </form>
