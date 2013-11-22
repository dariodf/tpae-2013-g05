<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<head>
</head>

<body>
<f:view>

	<f:loadBundle basename="mensajes" var="msgs" />
	<h1><h:outputText value="#{msgs['index.titulo']}" /></h1>
	<h:messages errorStyle="color: red;" />

	<h:form>
		<h:panelGrid columns="2">
			
			<h:outputLabel for="nroFact" value="#{msgs['index.factura.numero']}" />
			<h:inputText id="nroFact" value="#{facturaBean.factura.numero}" required="true" label="#{msgs['index.factura.numero']}" />
			
			<h:outputLabel for="fechaFact" value="#{msgs['index.factura.fecha']}" />
			<h:inputText id="fechaFact" value="#{facturaBean.factura.fecha}" required="true" label="#{msgs['index.factura.fecha']}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:inputText>
			
			<h:outputLabel for="nombreCliente" value="#{msgs['index.factura.nombreCliente']}" />
			<h:inputText id="nombreCliente" value="#{facturaBean.factura.nombreCliente}" required="true" label="#{msgs['index.factura.nombreCliente']}" />
			
			<h:outputLabel for="cuitCliente" value="#{msgs['index.factura.cuitCliente']}" />
			<h:inputText id="cuitCliente" value="#{facturaBean.factura.cuitCliente}" required="true" label="#{msgs['index.factura.cuitCliente']}" />
			
			<h:outputLabel for="precioTotal" value="#{msgs['index.factura.precioTotal']}" />
			<h:inputText id="precioTotal" value="#{facturaBean.factura.precioTotal}" required="true" label="#{msgs['index.factura.precioTotal']}">
				<f:convertNumber maxFractionDigits="2" />
			</h:inputText>
			
			<h:panelGroup>
				<h:commandButton id="btnGuardar" value="#{msgs['boton.guardar']}" action="#{facturaBean.guardar}" />
				<h:commandButton id="btnBuscar" value="#{msgs['boton.buscar']}" action="navigateToListaFacturas" immediate="true" />
			</h:panelGroup>
		</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>