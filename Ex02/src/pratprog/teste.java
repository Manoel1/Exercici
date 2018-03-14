package pratprog;

import static org.junit.Assert.assertEquals;
import testes.pais;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

public class teste {
	pais pais, copia;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new pais(id, 'Argentina', '450 000 000', '8 736 196' );
		copia = new pais(id, 'Argentina', '450 000 000', '8 736 194' );
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		pais fixture = new pais(1, "Russia', '470 000 000', '8 515 857,000'", 0, 0 );
		pais novo = new pais(1, null, null, null);
		novo.carregar();
		assertEquals("inclusao", novo, fixture);
	}

	@Test
	public void testCriar() {
		System.out.println("criar");
		pais.criar();
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals("criacao", pais, copia);
	}

	@Test
	public void testAtualizar() {
		System.out.println("atualizar");
		pais.setPopulacao("666666");
		copia.setPopulacao("666666");		
		pais.atualizar();
		pais.carregar();
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void testExcluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(null);
		copia.setArea(null);
		pais.excluir();
		pais.carregar();
		assertEquals("exclusao", pais, copia);
	}
}

