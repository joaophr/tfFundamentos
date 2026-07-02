------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Sistema de Monitoramento Pedagógico do Uso de IA em Programação
PURPOSE OF PROJECT: Auxiliar o professor na gestão de seus alunos sobre o uso de Inteligência Articial durante aulas e atividades relacionadas a programação
VERSION or DATE: 02/07/2026
HOW TO START THIS PROJECT: Apenas inicializar o arquivo que o sistema começa de forma automática.
AUTHORS: Luigi Dall'Agnol Roxo - 26104015, João Pedro Hessel da Rosa - 26103503

// falta explicar o calculo do risco, botar mais dificuldades e como foram superadas e sobre o uso da IA

Ao longo do desenvolvimento do projeto, foi criado um sistema que permite o cadastro de alunos, sendo eles bolsistas ou não, além de possibilitar a modificação de algum atributo caso tenha sido informado errado no momento do cadastro. O sistema também disponibiliza funcionalidades como a listagem dos alunos e bolsistas, identificação do nome mais longo, contagem de vogais presentes nos nomes cadastrados, cálculo do percentual de alunos por curso (considerando apenas os cursos do 32 para serem atendidos pelo sistema), média de idade dos alunos e geração da lista de chamada em ordem alfabética.

Para estruturar o funcionamento do sistema, o projeto foi dividido em seis classes, cada uma com uma responsabilidade específica. A classe Main ficou responsável por conter o menu, coletando os dados que servem de parâmetro para chamar as funções e tratando eventuais erros. A classe Turma concentra as arrays de pessoas, alunos, bolsistas e acompanhamento IA, além de armazenar todos os métodos de manipulação e retorno das opções presentes no menu. Já as classes Pessoa, Aluno e AlunoBolsistaIC possuem a função de criar seus respectivos objetos e disponibilizar seus Gets/Sets.

Em relação à estrutura entre as classes, foi utilizada composição em praticamente todo o sistema. A única classe que não utiliza composição é a classe Pessoa, por ser a classe base para que todas as outras funcionem. Dessa forma, cada classe possui um atributo da classe anterior: BolsistaIC possui um atributo da classe Aluno e Aluno possui um atributo da classe Pessoa. Além disso, a classe AcompanhamentoIA possui um atributo da classe Aluno, fazendo com que cada objeto dessa classe esteja vinculado a um aluno.

Durante o desenvolvimento, as principais fontes de consulta utilizadas foram as aulas da Profª Lucia Giraffa e os conselhos do Pedro Wagner. Como ferramenta de IA, foi utilizado o Claude.

Como aprendizado obtido com o trabalho, foi possível perceber que, devido à complexidade do sistema, realizar alterações em uma parte gera impacto global dentro da aplicação em função da dependência entre os itens do código.

Uma das principais dificuldades encontradas foi definir onde guardar as informações cadastradas dentro do sistema. Essa dificuldade foi superada por meio de perguntas feitas para a professora e debates entre os colegas.

Quanto à divisão de tarefas entre os integrantes do grupo, não houve uma separação rígida de responsabilidades. O trabalho foi sendo realizado conforme a demanda e a disponibilidade de cada integrante, sempre com discussões e decisões em conjunto para buscar a melhor solução.
