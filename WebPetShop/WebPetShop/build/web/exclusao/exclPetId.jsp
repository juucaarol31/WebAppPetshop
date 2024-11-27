<%-- 
    Document   : consultaReg
    Created on : 30 de out. de 2024, 21:25:47
    Author     : julia carolina e larissa sato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pet"%>
<%@page import="model.dao.PetDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        //Entrada/Receber
        int id = Integer.parseInt( request.getParameter("id") );
            
        // Instância e atrib de valor
        Pet pet = new Pet();
        pet.setId(id);
        
         //Select
        PetDAO petDAO = new PetDAO();
        if(petDAO.exclPetId(pet)){
            out.println("<br> <b>Registro excluído com sucesso!</b> <br>");
        }else{
            out.println("Registro não excluído!!!");
        }

        
        %>
    </body>
</html>
