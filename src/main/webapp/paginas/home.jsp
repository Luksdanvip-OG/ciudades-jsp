<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>

        <div class="container-fluid">
            <h1 class="text-center">Listado de ciudades</h1>
            <div class="container">
                <p>Aqúi vamos a dejar el listado de ciudades almacenadas:</p>

                <!<!-- Tabla con el listado, requerirá de una petición para poder traer los datos -->


                <c:choose>
                    <c:when test="${ciudades != null}">
                        <h1 class="mt-2">Lista de Ciudades</h1>
                        <span class="badge bg-dark w-10 fs-5">Datos encontrados:</span>
                        <table class="table mt-4 text-center table-striped">
                            <thead class=" table-dark">
                                <tr>
                                    <th scope="col"># id</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Distrito</th>
                                    <th scope="col">Población</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${ciudades}" var="ciudad">
                                    <tr>
                                        <th scope="row">${ciudad.id}</th>
                                        <td>${ciudad.nombre}</td>
                                        <td>${ciudad.codigoPais}</td>
                                        <td>${ciudad.distrito}</td>
                                        <td>${ciudad.poblacion}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </c:when>

                    <c:when test="${ciudades == null}">
                        <h1 class="mt-2 alert alert-danger">Error al obtener lista de
                            autores.</h1>
                        </c:when>
                    </c:choose>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
