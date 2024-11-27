<%-- 
    Document   : consultaReg
    Created on : 30 de out. de 2024, 21:25:47
    Author     : julia carolina e larissa sato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pet"%>
<%@page import="model.dao.PetDAO"%>
<%@page import="java.text.*"%>
<%@page import="java.util.Date"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar (Consulta)</title>
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
        if(petDAO.consPetRegId(pet) != null){
                out.println("<h2>Pesquisa de Satisfação</h2> <br>");
        %>                          
        <form name="frmPet" method="post" action="updatePet.jsp">
            Identificador: <input type="text" name="id" value="<%= pet.getId()%>" readonly="true"> <p>
            Nome: <input type="text" name="nome" value="<%= pet.getNome() %>" minlength="3" maxlength="10"> <p>
            Raça <input type="text" name="raca" value="<%= pet.getRaca() %>" minlength="3" maxlength="10"> <p> 
            Nome Dono: <input type="text" name="nomeDono" value="<%= pet.getNomeDono() %>" minlength="3" maxlength="10"> <p>
            Telefone: <input type="text" name="telefone" value="<%= pet.getTelefone() %>" minlength="3" maxlength="15"> <p>
            1. O cuidado e atenção dados ao seu pet foram satisfatórios? 
            <input type="text" name="r1" value="<%= pet.getQ1()%>"><p>
            2. Como você avalia a qualidade do serviço realizado? 
            <input type="text" name="r2" value="<%= pet.getQ2()%>"><p>             
            3. O tempo de espera foi adequado?
            <input type="text" name="r3" value="<%= pet.getQ3()%>"><p>                         
            4. De forma geral, como você avalia sua experiência conosco?
            <input type="text" name="r4" value="<%= pet.getQ4()%>"><p> 
            Data da Pesquisa: 
            <input type="date" name="dt_pesq" value="<%= pet.getDt_pesq() %>"><p> 
            <input type="submit" value="Salvar">
        </form>                 
        <%        
                out.println("<br><br> <b> Legenda:</b> <br> <img src='../imagens/escala.jpg' alt=''/>");                             
        }else{
               out.println("Registro não encontrado!!!");
        }        
        %>
    </body>
</html>
