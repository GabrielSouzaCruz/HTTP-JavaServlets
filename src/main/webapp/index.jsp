<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - API & MVC</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .card-atividade {
            margin-bottom: 20px; padding: 25px 15px; border-radius: 4px;
            border: 1px solid #ddd; background-color: #fff;
            box-shadow: 0 1px 3px rgba(0,0,0,0.05); text-align: center;
        }
        .header-title {
            margin-bottom: 40px; padding-bottom: 20px;
            border-bottom: 2px solid #337ab7; text-align: center;
        }
    </style>
</head>
<body style="background-color: #f9f9f9;">

    <div class="container" style="margin-top: 30px; margin-bottom: 50px;">
        <div class="row">
            <div class="col-xs-12 header-title">
                <h2 class="text-primary" style="margin-top: 0;">Arquitetura Profissional: JSON API & MVC</h2>
                <p class="text-muted">Servlets estruturados como no mundo real.</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div class="card-atividade">
                    <h4 class="text-primary" style="margin-top: 0; margin-bottom: 20px;"><b>1. Cabeçalhos (API JSON)</b></h4>
                    <a href="api/headers" target="_blank" class="btn btn-primary">GET /api/headers</a>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card-atividade">
                    <h4 class="text-success" style="margin-top: 0; margin-bottom: 20px;"><b>2. Corpo (POST + MVC)</b></h4>
                    <a href="form-http.html" class="btn btn-success">Abrir Formulário</a>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card-atividade">
                    <h4 class="text-info" style="margin-top: 0; margin-bottom: 20px;"><b>3. Sessão (MVC)</b></h4>
                    <a href="app/session" target="_blank" class="btn btn-info">GET /app/session</a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="card-atividade">
                    <h4 class="text-danger" style="margin-top: 0; margin-bottom: 20px;"><b>4. Status HTTP</b></h4>
                    <div class="btn-group" role="group" style="margin-bottom: 15px;">
                        <a href="status?code=200" target="_blank" class="btn btn-default text-success"><b>200</b></a>
                        <a href="status?code=404" target="_blank" class="btn btn-default text-warning"><b>404</b></a>
                        <a href="status?code=500" target="_blank" class="btn btn-default text-danger"><b>500</b></a>
                    </div>
                    <form action="status" method="GET" target="_blank" class="form-inline" style="display: flex; justify-content: center;">
                        <div class="form-group">
                            <input type="number" class="form-control" name="code" placeholder="Ex: 403" style="width: 140px; margin-right: 5px;" required>
                        </div>
                        <button type="submit" class="btn btn-danger">Injetar Status</button>
                    </form>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card-atividade">
                    <h4 class="text-warning" style="margin-top: 0; margin-bottom: 20px;"><b>5. Métodos (OPTIONS)</b></h4>
                    <p class="text-muted" style="font-size: 13px;">
                        Disponível em: <code>/methods</code> ou <code>/api/*</code><br>
                        <em>Teste enviando um pedido OPTIONS via terminal, cURL ou Postman.</em>
                    </p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>