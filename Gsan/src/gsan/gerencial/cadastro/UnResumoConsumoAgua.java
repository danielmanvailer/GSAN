/*
* Copyright (C) 2007-2007 the GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento
*
* This file is part of GSAN, an integrated service management system for Sanitation
*
* GSAN is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License.
*
* GSAN is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA
*/

/*
* GSAN - Sistema Integrado de Gest�o de Servi�os de Saneamento
* Copyright (C) <2007> 
* Adriano Britto Siqueira
* Alexandre Santos Cabral
* Ana Carolina Alves Breda
* Ana Maria Andrade Cavalcante
* Aryed Lins de Ara�jo
* Bruno Leonardo Rodrigues Barros
* Carlos Elmano Rodrigues Ferreira
* Cl�udio de Andrade Lira
* Denys Guimar�es Guenes Tavares
* Eduardo Breckenfeld da Rosa Borges
* Fab�ola Gomes de Ara�jo
* Fl�vio Leonardo Cavalcanti Cordeiro
* Francisco do Nascimento J�nior
* Homero Sampaio Cavalcanti
* Ivan S�rgio da Silva J�nior
* Jos� Edmar de Siqueira
* Jos� Thiago Ten�rio Lopes
* K�ssia Regina Silvestre de Albuquerque
* Leonardo Luiz Vieira da Silva
* M�rcio Roberto Batista da Silva
* Maria de F�tima Sampaio Leite
* Micaela Maria Coelho de Ara�jo
* Nelson Mendon�a de Carvalho
* Newton Morais e Silva
* Pedro Alexandre Santos da Silva Filho
* Rafael Corr�a Lima e Silva
* Rafael Francisco Pinto
* Rafael Koury Monteiro
* Rafael Palermo de Ara�jo
* Raphael Veras Rossiter
* Roberto Sobreira Barbalho
* Rodrigo Avellar Silveira
* Rosana Carvalho Barbosa
* S�vio Luiz de Andrade Cavalcante
* Tai Mu Shih
* Thiago Augusto Souza do Nascimento
* Tiago Moreno Rodrigues
* Vivianne Barbosa Sousa
*
* Este programa � software livre; voc� pode redistribu�-lo e/ou
* modific�-lo sob os termos de Licen�a P�blica Geral GNU, conforme
* publicada pela Free Software Foundation; vers�o 2 da
* Licen�a.
* Este programa � distribu�do na expectativa de ser �til, mas SEM
* QUALQUER GARANTIA; sem mesmo a garantia impl�cita de
* COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM
* PARTICULAR. Consulte a Licen�a P�blica Geral GNU para obter mais
* detalhes.
* Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
* junto com este programa; se n�o, escreva para Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
* 02111-1307, USA.
*/  
package gsan.gerencial.cadastro;
import gsan.gerencial.atendimentopublico.ligacaoagua.GLigacaoAguaSituacao;
import gsan.gerencial.atendimentopublico.ligacaoesgoto.GLigacaoEsgotoPerfil;
import gsan.gerencial.atendimentopublico.ligacaoesgoto.GLigacaoEsgotoSituacao;
import gsan.gerencial.cadastro.cliente.GClienteTipo;
import gsan.gerencial.cadastro.cliente.GEsferaPoder;
import gsan.gerencial.cadastro.imovel.GCategoria;
import gsan.gerencial.cadastro.imovel.GImovelPerfil;
import gsan.gerencial.cadastro.imovel.GSubcategoria;
import gsan.gerencial.cadastro.localidade.GGerenciaRegional;
import gsan.gerencial.cadastro.localidade.GLocalidade;
import gsan.gerencial.cadastro.localidade.GQuadra;
import gsan.gerencial.cadastro.localidade.GSetorComercial;
import gsan.gerencial.cadastro.localidade.GUnidadeNegocio;
import gsan.gerencial.micromedicao.GRota;
import gsan.gerencial.micromedicao.consumo.GConsumoTipo;

import java.io.Serializable;
//******************************************************************
//Alterado por: Ivan S�rgio
//Data: 19/01/2009
//Alteracao: CRC1012 - Adicionado indicadorLigacaoFaturada.
//******************************************************************
public class UnResumoConsumoAgua implements Serializable {

    /** identifier field */
    private Integer recaId;

    /** persistent field */
    private int referencia;

    /** persistent field */
    private int codigoSetorComercial;

    /** persistent field */
    private int numeroQuadra;

    /** persistent field */
    private int quantidadeEconomias;

    /** persistent field */
    private int consumoAgua;

    /** persistent field */
    private Date ultimaAlteracao;

    /** persistent field */
    private int consumoExcedente;

    /** persistent field */
    private int quantidadeLigacoes;
    
    /** persistent field */
    private int volumeConsumoFaturado;
    private int indicadorLigacaoFaturada;
    /** persistent field */
    private GSubcategoria gerSubcategoria;

    /** persistent field */
    private GClienteTipo gerClienteTipo;

    /** persistent field */
    private GLigacaoAguaSituacao gerLigacaoAguaSituacao;

    /** persistent field */
    private GUnidadeNegocio gerUnidadeNegocio;

    /** persistent field */
    private GLocalidade gerLocalidade;

    /** persistent field */
    private GLocalidade gerLocalidadeElo;

    /** persistent field */
    private GQuadra gerQuadra;

    /** persistent field */
    private GLigacaoEsgotoSituacao gerLigacaoEsgotoSituacao;

    /** persistent field */
    private GLigacaoEsgotoPerfil gerLigacaoEsgotoPerfil;

    /** persistent field */
    private GGerenciaRegional gerGerenciaRegional;

    /** persistent field */
    private GSetorComercial gerSetorComercial;

    /** persistent field */
    private GLigacaoAguaPerfil gerLigacaoAguaPerfil;

    /** persistent field */
    private GEsferaPoder gerEsferaPoder;

    /** persistent field */
    private GCategoria gerCategoria;

    /** persistent field */
    private GImovelPerfil gerImovelPerfil;

    /** persistent field */
    private GRota gerRota;
    
    private short indicadorHidrometro;
    

    protected short getIndicadorHidrometro() {
		return indicadorHidrometro;
	}

	protected void setIndicadorHidrometro(short indicadorHidrometro) {
		this.indicadorHidrometro = indicadorHidrometro;
	}

	/**
	 * @return Retorna o campo indicadorLigacaoFaturada.
	 */
	public int getIndicadorLigacaoFaturada() {
		return indicadorLigacaoFaturada;
	}

	/**
	 * @param indicadorLigacaoFaturada O indicadorLigacaoFaturada a ser setado.
	 */
	public void setIndicadorLigacaoFaturada(int indicadorLigacaoFaturada) {
		this.indicadorLigacaoFaturada = indicadorLigacaoFaturada;
	}

	/** full constructor */
    public UnResumoConsumoAgua(
		this.referencia = referencia; 
    /** default constructor */
    public UnResumoConsumoAgua() {
    }

	public int getCodigoSetorComercial() {
		return codigoSetorComercial;
	}

	public void setCodigoSetorComercial(int codigoSetorComercial) {
		this.codigoSetorComercial = codigoSetorComercial;
	}

	public int getConsumoAgua() {
		return consumoAgua;
	}

	public void setConsumoAgua(int consumoAgua) {
		this.consumoAgua = consumoAgua;
	}

	public int getConsumoExcedente() {
		return consumoExcedente;
	}

	public void setConsumoExcedente(int consumoExcedente) {
		this.consumoExcedente = consumoExcedente;
	}

	public GCategoria getGerCategoria() {
		return gerCategoria;
	}

	public void setGerCategoria(GCategoria gerCategoria) {
		this.gerCategoria = gerCategoria;
	}

	public GClienteTipo getGerClienteTipo() {
		return gerClienteTipo;
	}

	public void setGerClienteTipo(GClienteTipo gerClienteTipo) {
		this.gerClienteTipo = gerClienteTipo;
	}

	public GEsferaPoder getGerEsferaPoder() {
		return gerEsferaPoder;
	}

	public void setGerEsferaPoder(GEsferaPoder gerEsferaPoder) {
		this.gerEsferaPoder = gerEsferaPoder;
	}

	public GGerenciaRegional getGerGerenciaRegional() {
		return gerGerenciaRegional;
	}

	public void setGerGerenciaRegional(GGerenciaRegional gerGerenciaRegional) {
		this.gerGerenciaRegional = gerGerenciaRegional;
	}

	public GImovelPerfil getGerImovelPerfil() {
		return gerImovelPerfil;
	}

	public void setGerImovelPerfil(GImovelPerfil gerImovelPerfil) {
		this.gerImovelPerfil = gerImovelPerfil;
	}

	public GLigacaoAguaPerfil getGerLigacaoAguaPerfil() {
		return gerLigacaoAguaPerfil;
	}

	public void setGerLigacaoAguaPerfil(GLigacaoAguaPerfil gerLigacaoAguaPerfil) {
		this.gerLigacaoAguaPerfil = gerLigacaoAguaPerfil;
	}

	public GLigacaoAguaSituacao getGerLigacaoAguaSituacao() {
		return gerLigacaoAguaSituacao;
	}

	public void setGerLigacaoAguaSituacao(
			GLigacaoAguaSituacao gerLigacaoAguaSituacao) {
		this.gerLigacaoAguaSituacao = gerLigacaoAguaSituacao;
	}

	public GLigacaoEsgotoPerfil getGerLigacaoEsgotoPerfil() {
		return gerLigacaoEsgotoPerfil;
	}

	public void setGerLigacaoEsgotoPerfil(
			GLigacaoEsgotoPerfil gerLigacaoEsgotoPerfil) {
		this.gerLigacaoEsgotoPerfil = gerLigacaoEsgotoPerfil;
	}

	public GLigacaoEsgotoSituacao getGerLigacaoEsgotoSituacao() {
		return gerLigacaoEsgotoSituacao;
	}

	public void setGerLigacaoEsgotoSituacao(
			GLigacaoEsgotoSituacao gerLigacaoEsgotoSituacao) {
		this.gerLigacaoEsgotoSituacao = gerLigacaoEsgotoSituacao;
	}

	public GLocalidade getGerLocalidade() {
		return gerLocalidade;
	}

	public void setGerLocalidade(GLocalidade gerLocalidade) {
		this.gerLocalidade = gerLocalidade;
	}

	public GLocalidade getGerLocalidadeElo() {
		return gerLocalidadeElo;
	}

	public void setGerLocalidadeElo(GLocalidade gerLocalidadeElo) {
		this.gerLocalidadeElo = gerLocalidadeElo;
	}

	public GQuadra getGerQuadra() {
		return gerQuadra;
	}

	public void setGerQuadra(GQuadra gerQuadra) {
		this.gerQuadra = gerQuadra;
	}

	public GRota getGerRota() {
		return gerRota;
	}

	public void setGerRota(GRota gerRota) {
		this.gerRota = gerRota;
	}

	public GSetorComercial getGerSetorComercial() {
		return gerSetorComercial;
	}

	public void setGerSetorComercial(GSetorComercial gerSetorComercial) {
		this.gerSetorComercial = gerSetorComercial;
	}

	public GSubcategoria getGerSubcategoria() {
		return gerSubcategoria;
	}

	public void setGerSubcategoria(GSubcategoria gerSubcategoria) {
		this.gerSubcategoria = gerSubcategoria;
	}

	public GUnidadeNegocio getGerUnidadeNegocio() {
		return gerUnidadeNegocio;
	}

	public void setGerUnidadeNegocio(GUnidadeNegocio gerUnidadeNegocio) {
		this.gerUnidadeNegocio = gerUnidadeNegocio;
	}

	public int getNumeroQuadra() {
		return numeroQuadra;
	}

	public void setNumeroQuadra(int numeroQuadra) {
		this.numeroQuadra = numeroQuadra;
	}

	public int getQuantidadeEconomias() {
		return quantidadeEconomias;
	}

	public void setQuantidadeEconomias(int quantidadeEconomias) {
		this.quantidadeEconomias = quantidadeEconomias;
	}

	public int getQuantidadeLigacoes() {
		return quantidadeLigacoes;
	}

	public void setQuantidadeLigacoes(int quantidadeLigacoes) {
		this.quantidadeLigacoes = quantidadeLigacoes;
	}

	public Integer getRecaId() {
		return recaId;
	}

	public void setRecaId(Integer recaId) {
		this.recaId = recaId;
	}

	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
	public int getVolumeConsumoFaturado() {
		return volumeConsumoFaturado;
	}
	public void setVolumeConsumoFaturado(int volumeConsumoFaturado) {
		this.volumeConsumoFaturado = volumeConsumoFaturado;
	}
}