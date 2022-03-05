

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="cabecalho.jsp"></jsp:include>
<%@ page import="model.Cliente"%>
<%@ page import="java.io.PrintWriter"%>
<div class="container">
	<%
		String mensagem = (String) request.getAttribute("msg");
	
		Cliente cliente = (Cliente) request.getAttribute("cliente");
		
		PrintWriter print = response.getWriter();
	%>	
	<form action="Formulario" method="POST">
		<input type="hidden" id="id" name="id" value="<%=(cliente != null) ? cliente.getId() : 0%>">
		<div class="card mt-3">
			<div class="card-header bg-white text-center"> 
				<h1 class="text-info">Cadastro De Clientes</h1>
				<% if(mensagem != null){ %>
					<div class="alert alert-info" role="alert"><%=mensagem %></div>
				<%} %>
			</div>
			<div class="card-body">
				<div class="mb-3">
					<label for="nome" class="form-label">Nome </label> <input
						type="text" class="form-control" id="nome" name="nome"
						placeholder="insira seu nome." value="<%= (cliente != null) ? cliente.getNome() : "" %>">
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email </label> <input
						type="email" class="form-control" id="email" name="email" placeholder="Insirir email" value="<%= (cliente != null) ? cliente.getEmail() : ""%>">
				</div>
				<div class="mb-3">
					<label for="telefone" class="form-label">Telefone </label> <input
						type="text" class="form-control" id="telefone" name="numero" placeholder="Insirir telefone" value="<%= (cliente != null) ? cliente.getTelefone() : ""%>">
				</div>
			</div>
			<div class="card-footer bg-white">
				<button type="submit" class="btn btn-primary"><%= (cliente != null) ? "Atualizar" : "Cadastrar"%></button>
				<a href="Index" class="btn btn-outline-secondary">Voltar</a>
			</div>
		</div>


	</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>