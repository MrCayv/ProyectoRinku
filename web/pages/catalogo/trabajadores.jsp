<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de trabajadores</title>
</head>
<body>
<f:view>
	<h:form>
		<h:panelGrid columns="3">
			<h:commandButton id="nuevo" value="Nuevo"/>
			<h:commandButton id="guardar" value="Guardar"/>
			<h:commandButton id="buscar" value="Buscar" />
		</h:panelGrid>
		<h:panelGrid border="1" columns="2">
			<f:facet name="header">
				<h:outputLabel value="Administración Trabajadores"></h:outputLabel>
			</f:facet>
			<h:outputText value="Nombre:"></h:outputText>
			<h:inputText id="txt_nombre" value="#{trabajadoresBean.nombre}" required="true" requiredMessage="Nombre Obligatorio"></h:inputText>
			<h:outputText value="Rol:"></h:outputText>
			<h:selectOneMenu value="#{trabajadoresBean.rol}">
				<f:selectItem itemLabel="Chofer" itemValue="1"/>
				<f:selectItem itemLabel="Cargador" itemValue="2"/>
				<f:selectItem itemLabel="Auxiliar" itemValue="3"/>
				<f:selectItems/>
			</h:selectOneMenu>
			<h:outputText value="Tipo:"></h:outputText>
			<h:selectOneMenu value="#{trabajadoresBean.tipo}">
				<f:selectItem itemLabel="Interno" itemValue="1"/>
				<f:selectItem itemLabel="Externo" itemValue="2"/>
				<f:selectItems/>
			</h:selectOneMenu>
		</h:panelGrid>
		<h:messages style="color:red"/>
		<br>
		<h:dataTable id="tabla_trabajadores" value="#{trabajadoresBean.trabajadores}" var="trabajadores">
		<f:facet name="header">
			<h:outputLabel value="Lista de Trabajadores"/>
		</f:facet>
			<h:column>
				<f:facet name="header"><h:outputLabel value="ID"></h:outputLabel></f:facet>
				<h:outputLabel value="#{trabajadores.id}"/>
			</h:column>
			<h:column>
			<f:facet name="header"><h:outputLabel value="Nombre"></h:outputLabel></f:facet>
				<h:outputLabel value="#{trabajadores.nombre}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputLabel value="Rol"></h:outputLabel></f:facet>
				<h:outputLabel value="#{trabajadores.rol}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputLabel value="Tipo"></h:outputLabel></f:facet>
				<h:outputLabel value="#{trabajadores.tipo}"/>
			</h:column>
		</h:dataTable>
	</h:form>
</f:view>
</body>
</html>