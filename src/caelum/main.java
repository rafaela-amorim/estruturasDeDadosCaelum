package caelum;

import java.util.ArrayList;

public class main {
	
	public static void main(String[] args) {
		//ArrayList vetor = new ArrayList();
		Vetor vetor = new Vetor();
		Aluno aluno = new Aluno();
		aluno.setNome("eukkkk");
		
		System.out.println(vetor.tamanho());
		
		for (int i = 1; i <= 1000; i++) 
			vetor.adiciona(aluno);
		
		System.out.println(vetor.tamanho());
		
		ArrayList<Aluno> lista = new ArrayList<>();
		System.out.println(lista.size());
		
		for (int i = 0; i < 1000; i++) 
			lista.add((Aluno) vetor.pega(i));
		
		System.out.println(lista.size());
	}
}
