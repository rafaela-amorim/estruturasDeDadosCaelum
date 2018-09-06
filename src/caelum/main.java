package caelum;

public class main {
	
	public static void main(String[] args) {
		Vetor v = new Vetor();
		
		Aluno a = new Aluno();
		Aluno b = new Aluno();
		
		v.adiciona(a);
		v.adiciona(b);
		
		a.setNome("eune");
		b.setNome("ota");
		System.out.println(v.toString());
		
		v.remove(0);
		System.out.println(v.toString());
	}
}
