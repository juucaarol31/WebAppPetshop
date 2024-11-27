/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.Pet;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import util.ConectaDB;

/**
 *
 * @author User
 */
public class PetDAO {
    //Atributos
    // Sem atributos
    
    //Métodos
    public boolean incPet(Pet p_pet) throws ClassNotFoundException {
        //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();
                        //INSERT INTO pet(dt_pesq, nome, raca, nomeDono, telefone, q1, q2, q3, q4) VALUES ('2024-11-17', 'Belinha','vira-lata', 'Larissa', '11 93006-5026', 2, 1, 5, 3);           
                        
            String sql = "INSERT INTO pet(dt_pesq, nome, raca, nomeDono, telefone, q1, q2, q3, q4) VALUES ('" + p_pet.getDt_pesq()+
                                                                                    "','" + p_pet.getNome()+
                                                                                    "', '" + p_pet.getRaca() +
                                                                                    "', '" + p_pet.getNomeDono() +
                                                                                    "', '" + p_pet.getTelefone() +
                                                                                    "'," + p_pet.getQ1()+ 
                                                                                    "," + p_pet.getQ2()+ 
                                                                                    "," + p_pet.getQ3()+ 
                                                                                    "," + p_pet.getQ4() + ")";
                         
            stmt.executeUpdate(sql); // Executa o SQL: Insert / Delete ou Update
                        
            conexao.close();
            return true;
        }catch(SQLException ex){
            System.out.println(" Exception: " + ex.toString());
            return false;
        }                 
    }  
    
   public Pet consPetReg(Pet pet) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from pet where nome = '" + pet.getNome() + "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select

            int n_reg = 0;
            while (rs.next()) {   
                pet.setId(rs.getInt("id"));  
                pet.setNome(rs.getString("nome"));  
                pet.setRaca(rs.getString("raca"));   
                pet.setNomeDono(rs.getString("nomeDono")); 
                pet.setTelefone(rs.getString("telefone"));
                pet.setQ1(rs.getInt("q1"));                
                pet.setQ2(rs.getInt("q2"));                
                pet.setQ3(rs.getInt("q3"));                
                pet.setQ4(rs.getInt("q4")); 
                pet.setDt_pesq(rs.getString("dt_pesq"));  
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return pet;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    }   
   
    public Pet consPetRegTel(Pet pet) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from pet where telefone = '" + pet.getTelefone()+ "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                pet.setId(Integer.parseInt(rs.getString("id")));  
                pet.setNome(rs.getString("nome"));  
                pet.setRaca(rs.getString("raca")); 
                pet.setNomeDono(rs.getString("nomedono")); 
                pet.setTelefone(rs.getString("telefone"));
                pet.setQ1( Integer.parseInt(rs.getString("q1")));                
                pet.setQ2( Integer.parseInt(rs.getString("q2")));                
                pet.setQ3( Integer.parseInt(rs.getString("q3")));                
                pet.setQ4( Integer.parseInt(rs.getString("q4"))); 
                pet.setDt_pesq(rs.getString("dt_pesq"));  
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return pet;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    } 

   public Pet consPetRegId(Pet pet) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from pet where id = '" + pet.getId()+ "'";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                pet.setId(Integer.parseInt(rs.getString("id")));  
                pet.setNome(rs.getString("nome"));  
                pet.setRaca(rs.getString("raca"));
                pet.setNomeDono(rs.getString("nomeDono")); 
                pet.setTelefone(rs.getString("telefone"));
                pet.setQ1( Integer.parseInt(rs.getString("q1")));                
                pet.setQ2( Integer.parseInt(rs.getString("q2")));                
                pet.setQ3( Integer.parseInt(rs.getString("q3")));                
                pet.setQ4( Integer.parseInt(rs.getString("q4"))); 
                pet.setDt_pesq(rs.getString("dt_pesq"));  
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return pet;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    } 
  
   public List consPetLista() throws ClassNotFoundException{
    //Connectar
        List lista = new ArrayList(); // Minha Lista
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "SELECT * from pet";
            ResultSet rs = stmt.executeQuery(sql); //GO - Executar - Select
            
            int n_reg = 0;
            while (rs.next()) {                 
                Pet pet = new Pet();
                pet.setId(Integer.parseInt(rs.getString("id")));  
                pet.setNome(rs.getString("nome"));  
                pet.setRaca(rs.getString("raca"));
                pet.setNomeDono(rs.getString("nomeDono")); 
                pet.setTelefone(rs.getString("telefone"));
                pet.setQ1( Integer.parseInt(rs.getString("q1")));                
                pet.setQ2( Integer.parseInt(rs.getString("q2")));                
                pet.setQ3( Integer.parseInt(rs.getString("q3")));                
                pet.setQ4( Integer.parseInt(rs.getString("q4"))); 
                pet.setDt_pesq(rs.getString("dt_pesq")); 
                lista.add(pet);
                n_reg++;
            }
            conexao.close();
            
            if (n_reg==0){
                return null;
            }else{
                return lista;
            }
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return null;
        }
    }   
   
   public boolean exclPetId(Pet pet) throws ClassNotFoundException{
    //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();                                   
                        
            String sql = "DELETE from pet where id = " + pet.getId();
            stmt.executeUpdate(sql);            
            conexao.close();            
            return true;
            
        }catch(SQLException ex){
            System.out.println("Erro:" + ex);
            return false;
        }
    } 
   
   public boolean altPet(Pet p_pet) throws ClassNotFoundException {
        //Connectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); // Abre a conexão
            Statement stmt = conexao.createStatement();
                        //UPDATE pet SET dt_pesq='2024-11-13', nome='Bidu', raca='shitzu', nomedono='Agatha', '11 99630-6895', q1=5, q2=5, q3=5, q4=5 WHERE pkid = 7                      
            String sql = "UPDATE pet SET dt_pesq='" + p_pet.getDt_pesq()+ "'" +
                                                    ", nome='" + p_pet.getNome()+ "'" +
                                                    ", raca='" + p_pet.getRaca() + "'" +
                                                    ", nomedono='" + p_pet.getNomeDono() + "'" +
                                                    ", telefone='" + p_pet.getTelefone() + "'" +
                                                    ", q1=" + p_pet.getQ1()+ 
                                                    ", q2=" + p_pet.getQ2()+ 
                                                    ", q3=" + p_pet.getQ3()+ 
                                                    ", q4=" + p_pet.getQ4() + " WHERE id = " + p_pet.getId();
                         
            stmt.executeUpdate(sql); // Executa o SQL: Insert / Delete ou Update
                        
            conexao.close();
            return true;
        }catch(SQLException ex){
            System.out.println(" Exception: " + ex.toString());
            return false;
        }                 
    } 
}
