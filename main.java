import datetime
import json

# Dicionários para armazenar dados
livros = {}
usuarios = {}
emprestimos = []

# Funções CRUD para livros
def adicionar_livro(codigo, titulo, autor, quantidade):
    livros[codigo] = {"titulo": titulo, "autor": autor, "quantidade": quantidade}

def editar_livro(codigo, titulo=None, autor=None, quantidade=None):
    if codigo in livros:
        if titulo:
            livros[codigo]["titulo"] = titulo
        if autor:
            livros[codigo]["autor"] = autor
        if quantidade is not None:
            livros[codigo]["quantidade"] = quantidade

def deletar_livro(codigo):
    if codigo in livros:
        del livros[codigo]

def listar_livros():
    return livros

# Funções CRUD para usuários
def adicionar_usuario(codigo, nome):
    usuarios[codigo] = {"nome": nome}

def editar_usuario(codigo, nome=None):
    if codigo in usuarios and nome:
        usuarios[codigo]["nome"] = nome

def deletar_usuario(codigo):
    if codigo in usuarios:
        del usuarios[codigo]

def listar_usuarios():
    return usuarios

# Funções para empréstimos
def registrar_emprestimo(codigo_usuario, codigo_livro):
    if codigo_usuario in usuarios and codigo_livro in livros and livros[codigo_livro]["quantidade"] > 0:
        data_emprestimo = datetime.date.today()
        prazo_devolucao = data_emprestimo + datetime.timedelta(days=14)
        emprestimos.append({
            "usuario": codigo_usuario,
            "livro": codigo_livro,
            "data_emprestimo": str(data_emprestimo),
            "prazo_devolucao": str(prazo_devolucao)
        })
        livros[codigo_livro]["quantidade"] -= 1
    else:
        print("Empréstimo não pode ser realizado.")

def listar_emprestimos():
    return emprestimos

# Relatórios
def livros_mais_emprestados():
    contagem = {}
    for emprestimo in emprestimos:
        livro = emprestimo["livro"]
        contagem[livro] = contagem.get(livro, 0) + 1
    return sorted(contagem.items(), key=lambda x: x[1], reverse=True)

# Funções auxiliares para salvar e carregar dados
def salvar_dados():
    with open("biblioteca.json", "w") as f:
        json.dump({"livros": livros, "usuarios": usuarios, "emprestimos": emprestimos}, f)

def carregar_dados():
    global livros, usuarios, emprestimos
    try:
        with open("biblioteca.json", "r") as f:
            data = json.load(f)
            livros = data.get("livros", {})
            usuarios = data.get("usuarios", {})
            emprestimos = data.get("emprestimos", [])
    except FileNotFoundError:
        print("Arquivo de dados não encontrado, iniciando com dados vazios.")

# Exemplo de uso
if __name__ == "__main__":
    carregar_dados()

    # Adicionar alguns dados
    adicionar_livro("001", "Python para Iniciantes", "Autor A", 5)
    adicionar_livro("002", "Data Science com Python", "Autor B", 3)

    adicionar_usuario("U001", "João")
    adicionar_usuario("U002", "Maria")

    # Registrar empréstimo
    registrar_emprestimo("U001", "001")

    # Exibir relatórios
    print("Livros mais emprestados:", livros_mais_emprestados())

    # Salvar dados
    salvar_dados()
