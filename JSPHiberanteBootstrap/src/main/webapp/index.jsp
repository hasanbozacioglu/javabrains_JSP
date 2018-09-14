<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
         pageEncoding="ISO-8859-9" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-9">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Employe - CRUD</title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="resources/template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="resources/template/vendor/datatables-plugins/dataTables.bootstrap.css"
          rel="stylesheet">
    <!-- DataTables Responsive CSS -->
    <link href="resources/template/vendor/datatables-responsive/dataTables.responsive.css"
          rel="stylesheet">
    <!-- Custom CSS -->
    <link href="resources/template/dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="resources/template/vendor/font-awesome/css/font-awesome.min.css"
          rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div id="wrapper">
    <h3 class="page-header col-lg-6 col-lg-offset-3">Employe CRUD</h3>
    <div class="col-lg-6 col-lg-offset-3 ">
        <form role="form" action="/JSPHiberanteBootstrap/employeController" method="post">
            <div class="form-group">
                <input class="form-control" placeholder="Name" name="name">
            </div>
            <div class="form-group">
                <input class="form-control" placeholder="Last Name" name="surname">
            </div>
            <div class="form-group">
                <input class="form-control" placeholder="Salary" name="salary">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success col-lg-12" style="margin-bottom: 20px">Submit Data</button>
            </div>
        </form>
    </div>
    <!-- /.col-lg-6 -->
    <div class="col-lg-6 col-lg-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                Employe List
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Last Name</th>
                            <th>Salary</th>
                            <th width="100">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${allEmployes}" var="employe">
                            <tr>
                                <td><c:out value="${employe.name}"/></td>
                                <td><c:out value="${employe.surname}"/></td>
                                <td><c:out value="${employe.salary}"/></td>
                                <td><a href="/JSPHiberanteBootstrap/employeController?employeId=${employe.id}"
                                       class="btn btn-danger" type="button">Delete</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="resources/template/vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="resources/template/vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="resources/template/vendor/metisMenu/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script src="resources/template/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="resources/template/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="resources/template/vendor/datatables-responsive/dataTables.responsive.js"></script>
<!-- Custom Theme JavaScript -->
<script src="resources/template/dist/js/sb-admin-2.js"></script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>
</body>
</html>
