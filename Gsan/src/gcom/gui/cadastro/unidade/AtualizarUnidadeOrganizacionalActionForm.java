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
package gcom.gui.cadastro.unidade;

import org.apache.struts.validator.ValidatorActionForm;

/**
 * @author Ana Maria
 * @created 22/11/2006
 */
public class AtualizarUnidadeOrganizacionalActionForm extends ValidatorActionForm {
	private static final long serialVersionUID = 1L;
	private String id;
    private String unidadeTipo;
    private String idLocalidade;
    private String descricaoLocalidade;
    private String gerenciaRegional;
    private String unidadeNegocio;
    private String descricao;
    private String sigla;
    private String idEmpresa;
    private String empresa;
    private String idUnidadeSuperior;
    private String descricaoUnidadeSuperior;
    private String idUnidadeCentralizadora;
    private String idUnidadeRepavimentadora;
    private String unidadeEsgoto;
    private String unidadeAbreRegistro;
    private String unidadeAceita;
    private String meioSolicitacao;
    private String indicadorUso;
    private String codigoUnidadeTipo = "";
    private String idMunicipio;
	private String descricaoMunicipio;
	private String indicadorUnidadeCentralAtendimento;

	public String getCodigoUnidadeTipo() {
		return codigoUnidadeTipo;
	}

	public void setCodigoUnidadeTipo(String codigoUnidadeTipo) {
		this.codigoUnidadeTipo = codigoUnidadeTipo;
	}

	public String getMeioSolicitacao() {
		return meioSolicitacao;
	}

	public void setMeioSolicitacao(String meioSolicitacao) {
		this.meioSolicitacao = meioSolicitacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGerenciaRegional() {
		return gerenciaRegional;
	}

	public void setGerenciaRegional(String gerenciaRegional) {
		this.gerenciaRegional = gerenciaRegional;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getIdLocalidade() {
		return idLocalidade;
	}

	public void setIdLocalidade(String idLocalidade) {
		this.idLocalidade = idLocalidade;
	}

	public String getIdUnidadeCentralizadora() {
		return idUnidadeCentralizadora;
	}

	public void setIdUnidadeCentralizadora(String idUnidadeCentralizadora) {
		this.idUnidadeCentralizadora = idUnidadeCentralizadora;
	}

	public String getIdUnidadeSuperior() {
		return idUnidadeSuperior;
	}

	public void setIdUnidadeSuperior(String idUnidadeSuperior) {
		this.idUnidadeSuperior = idUnidadeSuperior;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getUnidadeTipo() {
		return unidadeTipo;
	}

	public void setUnidadeTipo(String unidadeTipo) {
		this.unidadeTipo = unidadeTipo;
	}

	public String getDescricaoUnidadeSuperior() {
		return descricaoUnidadeSuperior;
	}

	public void setDescricaoUnidadeSuperior(String descricaoUnidadeSuperior) {
		this.descricaoUnidadeSuperior = descricaoUnidadeSuperior;
	}

	public String getDescricaoLocalidade() {
		return descricaoLocalidade;
	}

	public void setDescricaoLocalidade(String descricaoLocalidade) {
		this.descricaoLocalidade = descricaoLocalidade;
	}

	public String getUnidadeAbreRegistro() {
		return unidadeAbreRegistro;
	}

	public void setUnidadeAbreRegistro(String unidadeAbreRegistro) {
		this.unidadeAbreRegistro = unidadeAbreRegistro;
	}

	public String getUnidadeAceita() {
		return unidadeAceita;
	}

	public void setUnidadeAceita(String unidadeAceita) {
		this.unidadeAceita = unidadeAceita;
	}

	public String getUnidadeEsgoto() {
		return unidadeEsgoto;
	}

	public void setUnidadeEsgoto(String unidadeEsgoto) {
		this.unidadeEsgoto = unidadeEsgoto;
	}

/*	public String getUnidadeCentralAtendimento() {
		return unidadeCentralAtendimento;
	}

	public void setUnidadeCentralAtendimento(String unidadeCentralAtendimento) {
		this.unidadeCentralAtendimento = unidadeCentralAtendimento;
	}

	public String getUnidadeTarifaSocial() {
		return unidadeTarifaSocial;
	}

	public void setUnidadeTarifaSocial(String unidadeTarifaSocial) {
		this.unidadeTarifaSocial = unidadeTarifaSocial;
	}
*/
	/**
	 * @return Retorna o campo id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id O id a ser setado.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return Retorna o campo indicadorUso.
	 */
	public String getIndicadorUso() {
		return indicadorUso;
	}

	/**
	 * @param indicadorUso O indicadorUso a ser setado.
	 */
	public void setIndicadorUso(String indicadorUso) {
		this.indicadorUso = indicadorUso;
	}

	/**
	 * @return Retorna o campo empresa.
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa O empresa a ser setado.
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return Retorna o campo idUnidadeRepavimentadora.
	 */
	public String getIdUnidadeRepavimentadora() {
		return idUnidadeRepavimentadora;
	}

	/**
	 * @param idUnidadeRepavimentadora O idUnidadeRepavimentadora a ser setado.
	 */
	public void setIdUnidadeRepavimentadora(String idUnidadeRepavimentadora) {
		this.idUnidadeRepavimentadora = idUnidadeRepavimentadora;
	}

	/**
	 * @return Retorna o campo unidadeNegocio.
	 */
	public String getUnidadeNegocio() {
		return unidadeNegocio;
	}

	/**
	 * @param unidadeNegocio O unidadeNegocio a ser setado.
	 */
	public void setUnidadeNegocio(String unidadeNegocio) {
		this.unidadeNegocio = unidadeNegocio;
	}

	/**
	 * @return Returns the descricaoMunicipio.
	 */
	public String getDescricaoMunicipio() {
		return descricaoMunicipio;
	}

	/**
	 * @param descricaoMunicipio The descricaoMunicipio to set.
	 */
	public void setDescricaoMunicipio(String descricaoMunicipio) {
		this.descricaoMunicipio = descricaoMunicipio;
	}

	/**
	 * @return Returns the idMunicipio.
	 */
	public String getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * @param idMunicipio The idMunicipio to set.
	 */
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getIndicadorUnidadeCentralAtendimento() {
		return indicadorUnidadeCentralAtendimento;
	}

	public void setIndicadorUnidadeCentralAtendimento(String indicadorUnidadeCentralAtendimento) {
		this.indicadorUnidadeCentralAtendimento = indicadorUnidadeCentralAtendimento;
	}	
	
	

}
