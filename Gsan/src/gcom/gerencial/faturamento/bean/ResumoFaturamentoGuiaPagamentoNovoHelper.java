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
package gcom.gerencial.faturamento.bean;


import java.math.BigDecimal;

/**
 * Classe respons�vel por ajudar o caso de uso [UC0572] Gerar Resumo ReFaturamento Novo
 *
 * @author Fernando Fontelles
 * @date 01/07/2010
 */
public class ResumoFaturamentoGuiaPagamentoNovoHelper {
	private Integer idImovel;
	private Integer idGerenciaRegional;
	private Integer idUnidadeNegocio;
	private Integer idLocalidade;
	private Integer idElo;
	private Integer idSetorComercial;
	private Integer codigoSetorComercial;
	private Integer idPerfilImovel;
	private Integer idEsfera;
	private Integer idTipoClienteResponsavel = 0;
	private Integer idSituacaoLigacaoAgua;
	private Integer idSituacaoLigacaoEsgoto;
	private Integer idCategoria;
	private Integer idSubCategoria;
	private Integer idPerfilLigacaoAgua;
	private Integer idPerfilLigacaoEsgoto;
	private Integer anoMesReferencia;
	private Integer idConta;
	private Integer consumoAgua = 0;
	private Integer consumoEsgoto = 0;
	private BigDecimal valorAgua = new BigDecimal(0);
	private BigDecimal valorEsgoto = new BigDecimal(0);
	private Integer idFinanciamentoTipo;
	private Integer idDocumentoTipo;
	private Integer debitoTipo = 0;
	private Short indicadorHidrometro;
	private Integer consumoTarifa = 0;
	public Integer getLancamentoItemContabil() {
	public Integer getConsumoTarifa() {
	public void setConsumoTarifa(Integer consumoTarifa) {
	public Short getIndicadorHidrometro() {
	public void setIndicadorHidrometro(Short indicadorHidrometro) {
	public Integer getDebitoTipo() {
	public void setDebitoTipo(Integer debitoTipo) {
	public Integer getIdFinanciamentoTipo() {
	public void setIdFinanciamentoTipo(Integer idFinanciamentoTipo) {
	public Integer getConsumoAgua() {
	public void setConsumoAgua(Integer consumoAgua) {
	public Integer getConsumoEsgoto() {
	public void setConsumoEsgoto(Integer consumoEsgoto) {
	public boolean equals(Object obj) {
        if (!(obj instanceof ResumoFaturamentoGuiaPagamentoNovoHelper)) {
        ResumoFaturamentoGuiaPagamentoNovoHelper resumoTemp = (ResumoFaturamentoGuiaPagamentoNovoHelper) obj;
        return new EqualsBuilder()
    }
	public Integer getCodigoSetorComercial() {
	public void setCodigoSetorComercial(Integer codigoSetorComercial) {
	public Integer getIdCategoria() {
	public void setIdCategoria(Integer idCategoria) {
	public Integer getIdEsfera() {
	public void setIdEsfera(Integer idEsfera) {
	public Integer getIdGerenciaRegional() {
	public void setIdGerenciaRegional(Integer idGerenciaRegional) {
	public Integer getIdImovel() {
	public void setIdImovel(Integer idImovel) {
	public Integer getIdLocalidade() {
	public void setIdLocalidade(Integer idLocalidade) {
	public Integer getIdPerfilImovel() {
	public void setIdPerfilImovel(Integer idPerfilImovel) {
	public Integer getIdSetorComercial() {
	public void setIdSetorComercial(Integer idSetorComercial) {
	public Integer getIdSituacaoLigacaoAgua() {
	public void setIdSituacaoLigacaoAgua(Integer idSituacaoLigacaoAgua) {
	public Integer getIdSituacaoLigacaoEsgoto() {
	public void setIdSituacaoLigacaoEsgoto(Integer idSituacaoLigacaoEsgoto) {
	public int hashCode() {
	public ResumoFaturamentoGuiaPagamentoNovoHelper(Integer idImovel,Integer idGerenciaRegional, Integer idUnidadeNegocio, 
		super();
	public ResumoFaturamentoGuiaPagamentoNovoHelper(Integer idImovel,Integer idGerenciaRegional, Integer idUnidadeNegocio,
		super();
	public ResumoFaturamentoGuiaPagamentoNovoHelper(Integer idImovel, Integer idGerenciaRegional, Integer idLocalidade, 
		super();
		if (idEsfera != null && idEsfera.intValue() != 0){
	}
	public Integer getIdUnidadeNegocio() {
	public void setIdUnidadeNegocio(Integer idUnidadeNegocio) {
	public Integer getAnoMesReferencia() {
	public void setAnoMesReferencia(Integer anoMesReferencia) {
	public Integer getIdSubCategoria() {
	public void setIdSubCategoria(Integer idSubCategoria) {
	public BigDecimal getValorAgua() {
	public void setValorAgua(BigDecimal valorAgua) {
	public BigDecimal getValorEsgoto() {
	public void setValorEsgoto(BigDecimal valorEsgoto) {
	public Integer getIdElo() {
	public void setIdElo(Integer idElo) {
	public Integer getIdTipoClienteResponsavel() {
	public void setIdTipoClienteResponsavel(Integer idTipoClienteResponsavel) {
	public Integer getIdPerfilLigacaoAgua() {
	public void setIdPerfilLigacaoAgua(Integer idPerfilLigacaoAgua) {
	public Integer getIdPerfilLigacaoEsgoto() {
	public void setIdPerfilLigacaoEsgoto(Integer idPerfilLigacaoEsgoto) {
	public Integer getIdConta() {
	public void setIdConta(Integer idConta) {
	public Integer getIdDocumentoTipo() {
	}
	public void setIdDocumentoTipo(Integer idDocumentoTipo) {
}