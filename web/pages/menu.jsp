<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menú Principal</title>
</head>
<body>
<f:view>
	<h:form>
		<h:panelGrid columns="4">
			<f:facet name="header">
				<h:outputLabel value="Menú Principal"></h:outputLabel>
			</f:facet>
			<h:commandLink action="home" value="HOME" />
			<h:commandLink action="usuarios" value="Usuarios" />
			<h:commandLink action="trabajadores" value="Trabajadores" />
			<h:commandLink action="salir" value="Salir" />
		</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>