<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <title>Client</title>
</head>
<body>
    <div class="container">
        <header>
            <h1>Cadastrar usuario</h1>
            <li>ADM</li>
        </header>
        <div class="sections">
            <ul>
                <div class="section">
                    <a href="../product/product.html">Produto</a>
                    <a href="../supplier/supplier.html">Fornecedor</a>
                </div>
                <a id="home" href="../index.html">Home</a>
            </ul>
        </div>
        <form action="ClientController" method="post">
            <input name="name" type="text" placeholder="Nome" required>
            <input name="email" type="email" placeholder="Email" required>
            <input name="phone" type="tel" placeholder="Telefone" required>
            <input type="submit" value="Cadastrar">
        </form>
    </div>
</body>
</html>