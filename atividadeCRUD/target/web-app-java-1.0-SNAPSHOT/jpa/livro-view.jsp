<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="dw.jpa.Livro"%>
<html>

  <head>
    <title>Livros</title>
  </head>

  <body>
    <h1>Livros</h1>
    <form>
      <table>
        <tr>
          <td>Editora</td>
          <td><input name="editora"></td>
        </tr>
        <tr>
          <td>Nome:</td>
          <td><input name="título"></td>
        </tr>
      </table>
      <button name="operacao" value="incluir">Incluir</button>
      <button name="operacao" value="excluir">Excluir</button>
      <button name="operacao" value="alterar">Alterar</button>
    </form>
    <b>${msg}</b>
    <hr>
    <table border="1">
      <tr>
        <th>Editora</th>
        <th>Título</th>
        <th>Opções</th>
      </tr>
      <%
      ArrayList<Livro> livros =
        (ArrayList<Livro>) request.getAttribute("livros");
      for (Livro livro : livros) {
      %>
      <tr>
        <td><%=livro.getEditora()%></td>
        <td><%=livro.getTitulo()%></td>
        <td><a href="professores?operacao=excluir&matricula=<%=livro.getEditora()%>">Excluir</a></td>
      </tr>
      <%}%>
    </table>
  </body>

</html>