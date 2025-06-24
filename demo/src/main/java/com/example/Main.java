
package com.example;

import javax.swing.JOptionPane;

import com.example.dto.UsuarioDTO;
import com.example.service.ApiClient;

public class Main {
 public static void main(String[] args) {
  try {
   // 1. Criar um usuário
   UsuarioDTO newUsuario = new UsuarioDTO(
     "João Silva",
     "52998224725");
   String createResponse = ApiClient.createUsuario(newUsuario);
   System.out.println("Usuário criado: " + createResponse);

   // 2. Listar todos os usuários
   String usuarios = ApiClient.getAllUsuarios();
   System.out.println("Lista de usuários: " + usuarios);

   // 3. Atualizar um usuário (supondo ID existente)
   UsuarioDTO updatedUsuario = new UsuarioDTO(
     "João Silva Atualizado",
     "52998224725");
   Long idu = Long.parseLong(JOptionPane.showInputDialog("digite o id para atualizar"));
   String updateResponse = ApiClient.updateUsuario(idu, updatedUsuario);
   System.out.println("Usuário atualizado: " + updateResponse);

   // 4. Deletar um usuário (supondo ID existente)
   Long idd = Long.parseLong(JOptionPane.showInputDialog("digite o id para excluir"));
   String deleteResponse = ApiClient.deleteUsuario(idd);
   System.out.println("Usuário deletado: " + deleteResponse);

  } catch (Exception e) {
   System.err.println("Erro: " + e.getMessage());
  }
 }

}

