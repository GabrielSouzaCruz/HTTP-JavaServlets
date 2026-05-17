<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <title>Resultado da Requisição POST</title>
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
</head>
<body style="background-color: #f9f9f9; padding-top: 50px;">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">Dados Processados via POST (Padrão MVC)</h3>
                    </div>
                    <div class="panel-body">
                        <p><strong>Nome:</strong> ${nome}</p>
                        <p><strong>E-mail:</strong> ${email}</p>
                        <p><strong>Mensagem:</strong> ${mensagem}</p>
                    </div>
                    <div class="panel-footer text-center">
                        <a href="../index.jsp" class="btn btn-default">Voltar ao Dashboard</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>