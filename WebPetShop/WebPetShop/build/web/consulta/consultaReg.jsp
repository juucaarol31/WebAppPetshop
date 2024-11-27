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
        String nome = request.getParameter("nome");
            
        // Instância e atrib de valor
        Pet pet = new Pet();
        pet.setNome(nome);
        
         //Select
        PetDAO petDAO = new PetDAO();
        pet = petDAO.consPetReg(pet);
        
        if(pet != null){
                out.println("<br> <b>Pesquisa de Satisfação</b> <br>");
                out.println("<br> Data: " + pet.getDt_pesq());
                out.println("<br> Nome: " + pet.getNome());
                out.println("<br> Raça: " + pet.getRaca());
                out.println("<br> Nome Dono: " + pet.getNomeDono());
                out.println("<br> Telefone: " + pet.getTelefone());
                out.println("<br> Questão 1: " + pet.getQ1());
                out.println("<br> Questão 2: " + pet.getQ2());
                out.println("<br> Questão 3: " + pet.getQ3());
                out.println("<br> Questão 4: " + pet.getQ4());                             
                out.println("<br><br> <b> Legenda:</b> <br> <img src='../imagens/escala.jpg' alt=''/>");                             
        }else{
               out.println("Registro não encontrado!!!");
        }

        
        %>
    </body>
</html>
