<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html; charset=UTF-8" %>

    <!--<section>
      <div class="col-md-8 card_style top-space center-block no-float">
        <h1><fmt:message key="formaNuevoSesion.etiqueta.titulo" /></h1>
        <form id="forma" action="procesarLogin.do" method="post">
          <div>
            <html:errors />
          </div>
          <div class="form-login">
            <input type="text"
                   placeholder="Nombre"
                   name= "nombrePrefijo"
                   maxlength="100"
                   autocomplete="off"
                   value="${formaNuevaSesion.nombre}" />
            <input type="password"
                   placeholder="Password"
                   name= "claveAcceso"
                   maxlength="100"
                   autocomplete="off"
                   value="${formaNuevaSesion.claveAcceso}" />
          </div>
          <div>
            <input type="submit"
              name="submit"
              class="btn btn-primary"
              value="Auntentificar"/>
          </div>
      </form>
      </div>
  </section>-->

    <section class="container">
            <div class="row vertical-offset-100">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row-fluid user-row">
                                <img src="images/logoUPCH.png" class="img-responsive">
                            </div>
                        </div>
                        <div class="panel-body">
                            <form id="forma" action="procesarLogin.do" method="post">
                                <fieldset>
                                    <div>
                                      <html:errors />
                                    </div>
                                    <input class="form-control"
                                            type="text"
                                            placeholder="Nombre"
                                            name= "nombrePrefijo"
                                            maxlength="100"
                                            autocomplete="off"
                                            value="${formaNuevaSesion.nombre}" />
                                    <input class="form-control"
                                        type="password"
                                           placeholder="Password"
                                           name= "claveAcceso"
                                           maxlength="100"
                                           autocomplete="off"
                                           value="${formaNuevaSesion.claveAcceso}" />

                                   <input class="btn btn-lg btn-success btn-block"
                                        type="submit"
                                         name="submit"
                                         class="btn btn-primary"
                                         value="Ingresar >>"/>

                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
