<%-- 
    Document   : consultaLista
    Created on : 30 de out. de 2024, 21:45:24
    Author     : julia carolina e larissa sato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pet"%>
<%@page import="model.dao.PetDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            th, td {
                text-align: center; /* Alinha os dados no centro das células */
            }
            /* Estilo para a logo */
            img {
                width: 200px;  /* Define a largura fixa da imagem */
                height: 200px; /* Define a altura fixa da imagem */
            }
            imgage-container {
                width: 200px;  /* Define a largura fixa da imagem */
                height: 200px; /* Define a altura fixa da imagem */
            }
         </style>   
    </head>
    <body>
        <%        
            //Select "Lista"
            PetDAO petDAO = new PetDAO();
            
            List<Pet> lista = new ArrayList<>();
            lista = petDAO.consPetLista();
            
            int n_reg = 0 ;
            out.println("<br><br> <img src='../imagens/logo.jpeg' alt=''/>");
            out.println("<br> <b>Pesquisa de Satisfação - Registros</b>");
         %>   
         <!-- HTML -->
         <table border="1">
                 <tr>
                     <th>#</th>
                     <th>Id.</th>
                     <th>Data</th>
                     <th>Nome</th>
                     <th>Raça</th>
                     <th>Nome Dono</th>
                     <th>Telefone</th>
                     <th>Resp. 1</th>
                     <th>Resp. 2</th>
                     <th>Resp. 3</th>
                     <th>Resp. 4</th>
                 </tr>            
         <%
            for( int i = 0; i <= lista.size()-1; i++){  
         %>                                                        
                 <tr>
                     <td><%= i+1%></td>
                     <td><%= lista.get(i).getId() %></td>
                     <td><%= lista.get(i).getDt_pesq()%></td>
                     <td><%= lista.get(i).getNome()%></td>
                     <td><%= lista.get(i).getRaca()%></td>
                     <td><%= lista.get(i).getNomeDono()%></td>
                     <td><%= lista.get(i).getTelefone()%></td>
                     <td><%= lista.get(i).getQ1()%></td>
                     <td><%= lista.get(i).getQ2()%></td>
                     <td><%= lista.get(i).getQ3()%></td>
                     <td><%= lista.get(i).getQ4()%></td>
                 </tr>                
         <%
                n_reg++;                           
            }
         %>
         </table>
         <%
            out.println("<br><br> <b>Registros: </b>" + n_reg + "<br>");
            out.println("<br><br> <b> Legenda:</b> <br> <img src='../imagens/escala.jpg' alt=''/>");        
        %>
    </body>
</html>
