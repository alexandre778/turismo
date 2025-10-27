$(document).ready(function () {
    // Salva o nome do cliente em cookie
    $("form").submit(function () {
        const nome = $("input[name='nomeCliente']").val();
        document.cookie = "cliente=" + nome + "; path=/;";
    });

    // Lê cookie se já existe
    const cookies = document.cookie.split("; ");
    cookies.forEach(c => {
        if (c.startsWith("cliente=")) {
            const nome = c.split("=")[1];
            $("input[name='nomeCliente']").val(nome);
        }
    });
});