package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.Aluno;
import vetorArrayList.Vetor;

public class VetorTest {
	
	Vetor lista;
	Aluno a1;
	Aluno a2;
	
	
	@Before
	public void inicia() {
		lista = new Vetor();
		a1 = new Aluno();
		a2 = new Aluno();
		a1.setNome("Rafael");
		a2.setNome("Paulo");
	}
	
	public void manutencao() {
		lista.adiciona(0, a1);
		lista.adiciona(1, a2);
	}
	
	@Test
	public void testAdicionaObject() {
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		assertEquals("[Rafael, Paulo]", lista.toString());
		
	}

	@Test
	public void testAdicionaIntObject() {
		Aluno a3 = new Aluno();
		a3.setNome("Ana");

		lista.adiciona(a1);
		lista.adiciona(0, a2);
		lista.adiciona(1, a3);
		
		assertEquals("[Paulo, Ana, Rafael]", lista.toString());
	}

	@Test
	public void testPega() {
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		assertEquals(a1, lista.pega(0));	// retorna o objeto
		assertEquals(a2, lista.pega(1));
	}

	@Test
	public void testRemove() {
		lista.adiciona(a1);
		lista.adiciona(a2);
		
		assertEquals("[Rafael, Paulo]", lista.toString());
		lista.remove(0);
		assertEquals("[Paulo]", lista.toString());
	}
		
	@Test
	public void testContem() {
		lista.adiciona(a1);
		lista.adiciona(a2);
		assertTrue(lista.contem(a1));
		assertTrue(lista.contem(a2));
	}

	@Test
	public void testContem1() {
		Aluno aluno = new Aluno();
		aluno.setNome("Ana");
		assertFalse(lista.contem(aluno));
	}
	
	@Test
	public void testTamanho() {
		assertEquals(0, lista.tamanho());
		lista.adiciona(a1);
		assertEquals(1, lista.tamanho());
		lista.adiciona(a2);
		assertEquals(2, lista.tamanho());
	}

	@Test
	public void testToString() {
		lista.adiciona(a1);
		lista.adiciona(a2);
		assertEquals("[Rafael, Paulo]", lista.toString());
		lista.remove(0);
		lista.remove(1);
		assertEquals("[]", lista.toString());
	}

}
