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
</style><!--
<script language="javascript" type="text/javascript">

  function EliminarGente(strGenteName){
    return confirm("¿Desea eliminar la persona '" + strGenteName + "'?")
  }

</script>-->
    <br>
    <font size='5'><fmt:message key="formaReporte.titulo" /></font>
   
      <table class="table" style="width:100%"  id="tablecontent">
      <thead>
          <tr class="tr">
              <td class="td" colspan="4">
                 <html:errors />
              </td>
          </tr>
          <tr class="tr enlaces" style="background:#CCCCCC">
           <td class="td" style="width:16%"><b id="nombres"><fmt:message key="formaReporte.etiqueta.nombres" /></b></td>
           <td class="td" style="width:16%"><b id="apellidos"><fmt:message key="formaReporte.etiqueta.apellidos" /></b></td>
           <td class="td" style="width:16%"><b id="direccion"><fmt:message key="formaReporte.etiqueta.direccion" /></b></td>
           <td class="td" style="width:16%"><b id="telefono"><fmt:message key="formaReporte.etiqueta.telefono" /></b></td>
           <td class="td" style="width:16%"><b id="ciudad"><fmt:message key="formaReporte.etiqueta.ciudad" /></b></td>
           
           <!--<td class="td"  style="width:16%"><b><fmt:message key="formaReporte.etiqueta.administracion" /></b></td>-->
          </tr>
          </thead>
          <tbody>
          <c:forEach var="gente" items="${formaReporte.gentes}">
              <tr class="tr">
                  <td class="td" align="left" style="width:16%"><c:out value="${gente.nombres}"/></td>
                  <td class="td" align="left" style="width:16%"><c:out value="${gente.apellidos}"/></td>
                  <td class="td" align="left" style="width:16%"><c:out value="${gente.direccion}"/></td>
                  <td class="td" align="left" style="width:16%"><c:out value="${gente.telefono}"/></td>
                  <td class="td" align="left" style="width:16%">
                    <c:forEach var="ciudad" items="${formaReporte.ciudades}">
                      <c:if test="${ciudad.id == gente.idCiudad}">
                        <c:out value="${ciudad.nombre}"/>
                      </c:if>
                    </c:forEach>
                    
                  </td>
              </tr>
          </c:forEach>
          <!--
          <tr class="tr">
              <td class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaReporte.contador}</td>
          </tr>-->
          </tbody>
      </table>
      
