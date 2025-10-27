$(document).ready(function () {
    // Salva o nome do cliente em cookie
    $("form").submit(function () {
        const nome = $("input[name='nomeCliente']").val();
        document.cookie = "cliente=" + nome + "; path=/;";
    });

    // L� cookie se j� existe
    const cookies = document.cookie.split("; ");
    cookies.forEach(c => {
        if (c.startsWith("cliente=")) {
            const nome = c.split("=")[1];
            $("input[name='nomeCliente']").val(nome);
        }
    });
});