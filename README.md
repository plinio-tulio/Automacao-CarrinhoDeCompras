# Projeto Automação Carrinho de Compra Americanas

- Projeto para automação de testes no site da americanas. Utilizada a linguagem de programação Java com escrita de cenários de teste utilizando a linguagem Gherkin e a abordagem BDD com framework Cucumber. Utilizado o Selenium WebDriver. 

### Pré-requisito para execução dos testes

1- Possuir o jdk instalado. Pode conferir a instalação acessando o prompt de comando e executando o comando "java -version".

2- Baixar o projeto e importar na ide de sua preferência. Deve configurar para utilizar a versão mais atual do jre instalado na sua máquina.

Para configurar no eclipse siga os passos abaixo:
  - Clique com botão direito sobre o projeto e clique em "Properties".
  - Selecione no menu lateral esquerdo a opção "Java Build Path" e depois a aba "Libraries".
  - Em seguida verifique se a versão jre já é a mais atual, caso não seja(se por exemplo estiver a versão 1.5) selecione e remova.
  - Caso tenha removido, clique em "Add Library" e com a opção "JRE System Library" marcada clique em "Next".
  - Com a opção "Workspace default JRE (jre1......) selecionada clique em "Finish".
  - Para finalizar clique em "OK".

3- Alterando o Encoding do projeto
  O enconding file do Projeto deve ser o UTF-8. 
 
 Para configurar o encoding no eclipse siga os passos abaixo:
 - Clique com botão direito sobre o projeto e clique em "Properties".
 - No menu lateral esquerdo selecione a opção "Resource".
 - Em seguida dentro de "Text file encoding" selecione a opção "Other" selecionando para ela o valor "UTF-8" e clique em "OK".

4- Verificar a versão do seu navegador Chrome. A versão utilizada no projeto foi a 81. Caso esteja usando outra versão do navegador deve substituir o driver no diretório do projeto resources/drivers.
Você pode estar baixando o driver referente a versão do navegador chrome utilizado em https://chromedriver.chromium.org/downloads.

### Executando os testes
Os testes devem ser executados a partir das classes que estão dentro do pacote runners que está no diretório do projeto src/teste/java/br.com.automacao.runners.

### Geração de relatório de execução de teste 
Após a execução dos testes serão gerados dois tipos de relatório, um em html e o segundo em json. Eles ficam armazenados no diretório do projeto target > reports.

### Geração de screenshots 
Após a execução de cada cenário de teste uma foto da tela é capturada e armazenada
no diretório do projeto target > screenshots.
