<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="cabecalho.jsp"></jsp:include>
<%@ page import="model.Cliente"%>
<%@ page import="java.util.*"%>

<%
 
	List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");

%>
	<div class="container">
		<h1>Todos os clientes</h1>
		
		
		<table class="table">
  <thead>
    <tr>
      
      <th scope="col">Nome</th>
      <th scope="col">Email</th>
      <th scope="col">Telefone</th>
      <th scope="col">Ações</th>
    </tr>
  </thead>
  <tbody>
  <% for(Cliente c : clientes) { %>
    <tr>
      <td><%=c.getId() %></th>
      <td><%=c.getNome() %></td>
      <td><%=c.getEmail() %></td>
      <td><%=c.getTelefone() %></td>
      <td>
      	<a  href="Editar?editar=<%=c.getId() %>" class="btn btn-primary">Editar</button>
		<a  href="Excluir?excluir=<%=c.getId() %>" class="btn btn-outline-secondary">Excluir</button>
      </td>
    </tr>
    <%} %>
  </tbody>
</table>
	</div>

<jsp:include page="footer.jsp"></jsp:include>