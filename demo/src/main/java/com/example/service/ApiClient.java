package com.example.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.example.dto.UsuarioDTO;
//import com.google.gson.Gson;

public class ApiClient {
 private static final String BASE_URL = "http://localhost:8080/api";// colocar o codifo do local host aquii
 private static final HttpClient httpClient = HttpClient.newBuilder()
   .connectTimeout(Duration.ofSeconds(10))
   .build();
 private static final Gson gson = new Gson();

 // GET - Buscar todos os usuários
 public static String getAllUsuarios() throws Exception {
  HttpRequest request = HttpRequest.newBuilder()
    .GET()
    .uri(URI.create(BASE_URL + "/usuarios"))
    .build();

  HttpResponse<String> response = httpClient.send(
    request,
    HttpResponse.BodyHandlers.ofString());

  return response.body();
 }

 // POST - Criar um usuário
 /**
  * @param usuario
  * @return
  * @throws Exception
  */
 public static String createUsuario(UsuarioDTO usuario) throws Exception {
  final String jsonBody = gson.toJson(usuario);
  
  HttpRequest request = HttpRequest.newBuilder()
    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
    .uri(URI.create(BASE_URL + "/usuarios"))
    .header("Content-Type", "application/json")
    .build();

  HttpResponse<String> response = httpClient.send(
    request,
    HttpResponse.BodyHandlers.ofString());

  return response.body();
 }

 // PUT - Atualizar um usuário
 public static String updateUsuario(Long id, UsuarioDTO usuario) throws Exception {
  String jsonBody = gson.toJson(usuario);

  HttpRequest request = HttpRequest.newBuilder()
    .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
    .uri(URI.create(BASE_URL + "/usuarios/" + id))
    .header("Content-Type", "application/json")
    .build();

  HttpResponse<String> response = httpClient.send(
    request,
    HttpResponse.BodyHandlers.ofString());

  return response.body();
 }

 // DELETE - Remover um usuário
 public static String deleteUsuario(Long id) throws Exception {
  HttpRequest request = HttpRequest.newBuilder()
    .DELETE()
    .uri(URI.create(BASE_URL + "/usuarios/" + id))
    .build();

  HttpResponse<String> response = httpClient.send(
    request,
    HttpResponse.BodyHandlers.ofString());

  return response.body();
 }

}
