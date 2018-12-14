#!/bin/bash
condicao=1
while [ "$condicao"="1" ];
 do
	echo "escolha uma opcao abaixo."
	echo "1 - Cadastro de livros e usuarios"
	echo "2 - Gerenciar Emprestimos"
	echo "3 - Relatorios"
	echo "4 - Limpar dados"
	echo "5 - Sair"
read opt
case $opt in
"1")
   java Cadastro
;;
"2")
   java ControleEmprestimo
;;
"3")
   java Relatorio
;;
"4")
   java Manutencao
;;
"5")
  condicao="2"
break
;;
esac
done
#java Cadastro
#java Emprestimo
#java Relatorio
