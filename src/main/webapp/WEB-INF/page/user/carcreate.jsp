<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp"%>


<div class="container">
	<div class="row">
		<div class=col-md-3>brand</div>
		<div class=col-md-2>model</div>
	</div>
</div>

<form class="create-catalog" action="MainServlet?action=car_create" method=POST>
	<div class="row">
		<div class=col-md-1 hidden=true>
			<input id="id" class="form-control input-md" name="id" value="0" />
		</div>
		<div class=col-md-3>
			<input id="brand" class="form-control input-md" name="brand" />
		</div>
		<div class=col-md-2>
			<input id="model" class="form-control input-md" name="model" />
		</div>
		<button id="Create" value="Create" name="Create"
			class="btn btn-success">Create</button>
	</div>
</form>

<%@ include file="include/end-html.jsp"%>