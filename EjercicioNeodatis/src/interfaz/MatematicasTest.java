package interfaz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatematicasTest {

	@Test
	void testMayor() {
		double valor1 = 11.0;
	    double valor2 = 2.0;
	    double resultadoEsperado = 7.0;

	    double resultadoObtenido = Matematicas.mayor(valor1, valor2);

	    assertEquals(resultadoEsperado, resultadoObtenido, 0.0001);
	}

}
