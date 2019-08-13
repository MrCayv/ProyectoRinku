<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de usuarios</title>
</head>
<body>
<f:view>
	<h:form>
		<h:panelGrid columns="3">
			<h:commandButton id="nuevo" value="Nuevo"/>
			<h:commandButton id="guardar" value="Guardar" action=""/>
			<h:commandButton id="buscar" value="Buscar" />
		</h:panelGrid>
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputLabel value="Administración Usuarios"></h:outputLabel>
			</f:facet>
			<h:outputText value="Nombre:"></h:outputText>
			<h:inputText id="txt_nombre" value="#{usuariosBean.nombre}" required="true" requiredMessage="Nombre Obligatorio"></h:inputText>
			<h:outputText value="Usuario:"></h:outputText>
			<h:inputText id="txt_usuario" value="#{usuariosBean.usuario}" required="true" requiredMessage="Usuario Obligatorio"></h:inputText>
			<h:outputText value="Contraseña:"></h:outputText>
			<h:inputText id="txt_pass" value="#{usuariosBean.password}" required="true" requiredMessage="Contraseña Obligatoria"></h:inputText>
		</h:panelGrid>
		<h:messages style="color:red"/>
		<br>
		<h:dataTable value="#{usuariosBean.usuarios}" var="usuarios">
			<f:facet name="header">
				<h:outputLabel value="Lista de Usuarios"/>
			</f:facet>
			<h:column>
				<f:facet name="header"><h:outputLabel value="ID"></h:outputLabel></f:facet>
				<h:outputLabel value="#{usuarios.id}"/>
			</h:column>
			<h:column>
			<f:facet name="header"><h:outputLabel value="Nombre"></h:outputLabel></f:facet>
				<h:outputLabel value="#{usuarios.nombre}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputLabel value="Usuario"></h:outputLabel></f:facet>
				<h:outputLabel value="#{usuarios.usuario}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputLabel value="Contraseña"></h:outputLabel></f:facet>
				<h:outputLabel value="#{usuarios.password}"/>
			</h:column>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>