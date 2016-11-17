package br.com.unisinos.clinica.abc.model.usuario.cadastro.endereco;

import org.junit.Assert;
import org.junit.Test;

public class EstadoTest {

	@Test
	public void fromSigla() throws Exception {
		Assert.assertEquals(Estado.ACRE, Estado.fromSigla("ac"));
		Assert.assertEquals(Estado.ACRE, Estado.fromSigla("AC"));
		Assert.assertEquals(Estado.ALAGOAS, Estado.fromSigla("AL"));
		Assert.assertEquals(Estado.ALAGOAS, Estado.fromSigla("al"));
		Assert.assertEquals(Estado.AMAPA, Estado.fromSigla("AP"));
		Assert.assertEquals(Estado.AMAPA, Estado.fromSigla("ap"));
		Assert.assertEquals(Estado.AMAZONAS, Estado.fromSigla("AM"));
		Assert.assertEquals(Estado.AMAZONAS, Estado.fromSigla("am"));
		Assert.assertEquals(Estado.BAHIA, Estado.fromSigla("BA"));
		Assert.assertEquals(Estado.BAHIA, Estado.fromSigla("ba"));
		Assert.assertEquals(Estado.CEARA, Estado.fromSigla("CE"));
		Assert.assertEquals(Estado.CEARA, Estado.fromSigla("ce"));
		Assert.assertEquals(Estado.DISTRITO_FEDERAL, Estado.fromSigla("DF"));
		Assert.assertEquals(Estado.DISTRITO_FEDERAL, Estado.fromSigla("df"));
		Assert.assertEquals(Estado.GOIAS, Estado.fromSigla("GO"));
		Assert.assertEquals(Estado.GOIAS, Estado.fromSigla("go"));
		Assert.assertEquals(Estado.MARANHAO, Estado.fromSigla("MA"));
		Assert.assertEquals(Estado.MARANHAO, Estado.fromSigla("ma"));
		Assert.assertEquals(Estado.MATO_GROSSO, Estado.fromSigla("MT"));
		Assert.assertEquals(Estado.MATO_GROSSO, Estado.fromSigla("mt"));
		Assert.assertEquals(Estado.MATO_GROSSO_DO_SUL, Estado.fromSigla("MS"));
		Assert.assertEquals(Estado.MATO_GROSSO_DO_SUL, Estado.fromSigla("ms"));
		Assert.assertEquals(Estado.MINAS_GERAIS, Estado.fromSigla("MG"));
		Assert.assertEquals(Estado.MINAS_GERAIS, Estado.fromSigla("mg"));
		Assert.assertEquals(Estado.PARA, Estado.fromSigla("PA"));
		Assert.assertEquals(Estado.PARA, Estado.fromSigla("pa"));
		Assert.assertEquals(Estado.PARAIBA, Estado.fromSigla("PB"));
		Assert.assertEquals(Estado.PARAIBA, Estado.fromSigla("pb"));
		Assert.assertEquals(Estado.PARANA, Estado.fromSigla("PR"));
		Assert.assertEquals(Estado.PARANA, Estado.fromSigla("pr"));
		Assert.assertEquals(Estado.PERNAMBUCO, Estado.fromSigla("PE"));
		Assert.assertEquals(Estado.PERNAMBUCO, Estado.fromSigla("pe"));
		Assert.assertEquals(Estado.PIAUI, Estado.fromSigla("PI"));
		Assert.assertEquals(Estado.PIAUI, Estado.fromSigla("pi"));
		Assert.assertEquals(Estado.RIO_DE_JANEIRO, Estado.fromSigla("RJ"));
		Assert.assertEquals(Estado.RIO_DE_JANEIRO, Estado.fromSigla("rj"));
		Assert.assertEquals(Estado.RIO_GRANDE_DO_NORTE, Estado.fromSigla("RN"));
		Assert.assertEquals(Estado.RIO_GRANDE_DO_NORTE, Estado.fromSigla("rn"));
		Assert.assertEquals(Estado.RIO_GRANDE_DO_SUL, Estado.fromSigla("RS"));
		Assert.assertEquals(Estado.RIO_GRANDE_DO_SUL, Estado.fromSigla("rs"));
		Assert.assertEquals(Estado.RONDONIA, Estado.fromSigla("RO"));
		Assert.assertEquals(Estado.RONDONIA, Estado.fromSigla("ro"));
		Assert.assertEquals(Estado.RORAIMA, Estado.fromSigla("RR"));
		Assert.assertEquals(Estado.RORAIMA, Estado.fromSigla("rr"));
		Assert.assertEquals(Estado.SANTA_CATARINA, Estado.fromSigla("SC"));
		Assert.assertEquals(Estado.SANTA_CATARINA, Estado.fromSigla("sc"));
		Assert.assertEquals(Estado.SAO_PAULO, Estado.fromSigla("SP"));
		Assert.assertEquals(Estado.SAO_PAULO, Estado.fromSigla("sp"));
		Assert.assertEquals(Estado.SERGIPE, Estado.fromSigla("SE"));
		Assert.assertEquals(Estado.SERGIPE, Estado.fromSigla("SE"));
		Assert.assertEquals(Estado.TOCANTINS, Estado.fromSigla("TO"));
		Assert.assertEquals(Estado.TOCANTINS, Estado.fromSigla("to"));
	}

}
