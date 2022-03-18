<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



 <html>
     <body>
       <c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso.
       </c:if>
       <c:if test="${empty empresa}">
        Empresa não cadastrada.
       </c:if>
     </body>
 </html>

</body>
</html>