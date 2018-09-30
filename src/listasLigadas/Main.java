package listasLigadas;

import java.util.LinkedList;

import util.Aluno;

public class Main {
	public static void main(String[] args) {
		Aluno rafa = new Aluno();
		rafa.setNome("Rafaela");
		Aluno math = new Aluno();
		math.setNome("Matheus");
		Aluno het = new Aluno();
		het.setNome("Heitor");
		
		LinkedList<Aluno> listaLigada = new LinkedList<>();
		
		listaLigada.add(rafa);
		listaLigada.add(math);
		listaLigada.add(1, het);
		
		for (int i = 0; i < listaLigada.size(); i++) 
			System.out.println(listaLigada.get(i));
		
		System.out.println(listaLigada.toString());
	}
}
