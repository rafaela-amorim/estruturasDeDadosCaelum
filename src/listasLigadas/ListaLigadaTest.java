package listasLigadas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.Aluno;

public class ListaLigadaTest {
	
	ListaLigada lista;
	Aluno a1;
	Aluno a2;
	Aluno a3;
	
	@Before
	public void inicia() {
		lista = new ListaLigada();
		a1 = new Aluno();
		a2 = new Aluno();
		a3 = new Aluno();
		
		a1.setNome("rafa");
		a2.setNome("theus");
		a3.setNome("heitor");
		
		lista.adiciona(a1);
		lista.adiciona(a2);
	}
	
	@Test
	public void testAdicionaNoComeco() {
		assertEquals("[rafa, theus]", lista.toString());
		lista.adicionaNoComeco(a3);
		assertEquals("[heitor, rafa, theus]", lista.toString());
	}

	@Test
	public void testAdicionaObject() {
		lista.adiciona(a3);
		assertEquals("[rafa, theus, heitor]", lista.toString());
	}

	@Test
	public void testAdicionaIntObject() {
		lista.adiciona(1, a3);
		assertEquals("[rafa, heitor, theus]", lista.toString());
		Aluno temp = new Aluno();
		temp.setNome("oioeoei");
		lista.adiciona(2, temp);
		assertEquals("[rafa, heitor, oioeoei, theus]", lista.toString());
	}

	@Test
	public void testPega() {
		lista.adicionaNoComeco(a3);
		Aluno temp = new Aluno();
		temp.setNome("naega jae jal naga biiitch");
		lista.adiciona(temp);
		
		assertEquals(temp, lista.pega(3));
		assertEquals(a1, lista.pega(1));
		assertEquals(a3, lista.pega(0));
	}

	@Test
	public void testTamanho() {
		assertEquals(2, lista.tamanho());
		
		lista.adicionaNoComeco(a3);
		Aluno temp = new Aluno();
		temp.setNome("naega jae jal naga biiitch");
		lista.adiciona(temp);
		assertEquals(4, lista.tamanho());
	}

	@Test
	public void testContem() {
		assertTrue(lista.contem(a1));
		assertFalse(lista.contem(a3));
	}

	@Test
	public void testRemoveDoComeco() {
		lista.removeDoComeco();
		assertEquals("[theus]", lista.toString());
	}

	@Test
	public void testRemove() {
		lista.adiciona(a3);
		lista.remove(1);
		assertEquals("[rafa, heitor]", lista.toString());
	}

	@Test
	public void testRemoveDoFim() {
		lista.removeDoFim();
		assertEquals("[rafa]", lista.toString());
	}

	@Test
	public void testToString() {
		lista.adiciona(a3);
		assertEquals("[rafa, theus, heitor]", lista.toString());
	}

}
