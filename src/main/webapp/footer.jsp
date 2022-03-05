

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<div class="container mt-5 text-center">
		<%
		String dataAtual = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
		%>
	<p>
		Desenvolvido por <span class="text-info">Rodrigo Lopes</span> | &copy <%=dataAtual.toString() %>
	
	</p>
</div>
</body>
</html>