# seeders
O programa se trata de uma aplicação baseada no protótipo de alta fidelidade construído na disciplina de Projetos 3
para os Caçadores de Bons Exemplos (cliente). A ideia que foi implementada consiste em um sistema de busca por filtros
e localização de ONGs e projetos sociais, além de funcionalidades de cadastro de ONGs e usuários na plataforma, 
utilizando um sistema de armazenamento em arquivos como substituto de um baco de dados. Para a parte visual, os desenvolvedores
usaram a ferramenta WindowBuilder na IDE Eclipse, criando 3 telas diferentes:

Tela de Cadastro de Usuário: Primeiro devem ser inseridos o CPF e a senha do usuário, e clicar no botão registrar caso tal
usuário ainda não tenha se registrado. Após isso, devem ser inseridas as outras informações solicitadas na tela, como
telefone, endereço, email, etc. Ao registrar ou logar um usuário será possível prosseguir para a tela Home.

Tela de Cadastro de Projetos: Nessa tela, devem ser preenchidas as informações de cada campo necessário, servindo para guardar
os dados das ONGs que serão posteriormente gravados em um arquivo. Também vale sinalizar que é nesse cadastro que uma ONG
declara até 3 tags com que trabalha, o que será útil para a maior funcionalidade da aplicação, a busca por tags.

Tela Home: É importante sinalizar essa tela não pode ser inicializada da mesma forma que as outras (botão de rodar
na IDE de escolha). Para chegar nessa tela, é preciso logar ou registrar-se como um usuário na primeira tela sinalizada.
A tela consiste na página inicial, onde é feita a busca por tags dos projetos que foram cadastrados na tela de cadastro
de projetos, exibindo somente os projetos que possuem a(s) tags selecionadas pelo usuário, além de priorizar por ordem de
exibição dos resultados aquelas que estão mais perto do endereço cadastrado pelo usuário que está fazendo a pesquisa. Para
conseguir realizar esta funcionalidade, o grupo fez uso de uma API de geolocalização, onde se trata a string de endereço
do usuário e do projeto, as transforma em latitude e longitude e calcula a distância entre as duas.
