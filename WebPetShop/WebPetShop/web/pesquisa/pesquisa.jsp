<%-- 
    Document   : pesquisa
    Created on : 30 de out. de 2024, 19:42:37
    Author     : julia carolina e larissa sato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pet"%>
<%@page import="model.dao.PetDAO"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pesquisa</h1>
        <%
            //Entrada
            String nome = request.getParameter("nome");            
            String raca = request.getParameter("raca");
            String nomeDono = request.getParameter("nomedono");
            String telefone = request.getParameter("telefone");
            int r1 = Integer.parseInt( request.getParameter("r1") );
            int r2 = Integer.parseInt( request.getParameter("r2") );
            int r3 = Integer.parseInt( request.getParameter("r3") );
            int r4 = Integer.parseInt( request.getParameter("r4") ); 

            // Instância do objeto e atrib. de dados
            Pet pet = new Pet();
            pet.setNome(nome);
            pet.setRaca(raca);
            pet.setNomeDono(nomeDono);
            pet.setTelefone(telefone);
            pet.setQ1(r1);
            pet.setQ2(r2);
            pet.setQ3(r3);
            pet.setQ4(r4);            

            pet.setDt_pesq(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())); //Data atual , de Date para String
            
            PetDAO petDAO = new PetDAO();
            
            if (petDAO.incPet(pet)){    // Insere e retorna o resultado (true / false).
                //Acesso Permitido
                out.println("Pesquisa inserida com sucesso!!!");
            }else{
                //Acesso Negado
                out.println("Não inserida!!!");
            }          
        %>
    </body>
</html>
