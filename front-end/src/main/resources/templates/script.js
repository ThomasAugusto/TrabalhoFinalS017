(function () {
    const livrosIniciais = [
        { id: 1, nome: "O Senhor dos Anéis", autor: "J.R.R. Tolkien" },
        { id: 2, nome: "1984", autor: "George Orwell" },
        { id: 3, nome: "Dom Casmurro", autor: "Machado de Assis" }
    ];

    // Inicializa localStorage com livros iniciais se estiver vazio
    if (!localStorage.getItem("livros")) {
        localStorage.setItem("livros", JSON.stringify(livrosIniciais));
    }

    // Funções globais
    window.getLivros = function () {
        return JSON.parse(localStorage.getItem("livros")) || [];
    };

    window.saveLivro = function (novoLivro) {
        const livros = getLivros();
        livros.push(novoLivro);
        localStorage.setItem("livros", JSON.stringify(livros));
    };
})();
