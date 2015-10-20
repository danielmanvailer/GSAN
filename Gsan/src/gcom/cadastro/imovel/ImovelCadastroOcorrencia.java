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
package gcom.cadastro.imovel;

import gcom.interceptor.ControleAlteracao;
import gcom.interceptor.ObjetoTransacao;
import gcom.util.filtro.Filtro;
import gcom.util.filtro.ParametroSimples;

import java.util.Date;


/** @author Hibernate CodeGenerator */
@ControleAlteracao()
public class ImovelCadastroOcorrencia extends ObjetoTransacao {
	
	private static final long serialVersionUID = 1L;
	private static final int ATRIBUTOS_OCORRENCIA_CADASTRO_ANORMALIDADE_IMOVEL = 698;
	// Operacao.OPERACAO_OCORRENCIA_ANORMALIDADE_INSERIR

    /** identifier field */
    private Integer id;

    /** persistent field */
    @ControleAlteracao(funcionalidade={ATRIBUTOS_OCORRENCIA_CADASTRO_ANORMALIDADE_IMOVEL})
    private Date dataOcorrencia;

    /** nullable persistent field */
    private byte[] fotoOcorrencia;

    /** persistent field */
    private Date ultimaAlteracao;

    /** persistent field */
    private gcom.cadastro.imovel.Imovel imovel;

    /** persistent field */
    @ControleAlteracao(value=FiltroImovelCadastroOcorrencia.CADASTRO_OCORRENCIA, funcionalidade={ATRIBUTOS_OCORRENCIA_CADASTRO_ANORMALIDADE_IMOVEL})
    private gcom.cadastro.imovel.CadastroOcorrencia cadastroOcorrencia;

	public ImovelCadastroOcorrencia() {
		super();
	}

	public ImovelCadastroOcorrencia(Integer id, Date dataOcorrencia, byte[] fotoOcorrencia, Date ultimaAlteracao, Imovel imovel, CadastroOcorrencia cadastroOcorrencia) {
		super();
		this.id = id;
		this.dataOcorrencia = dataOcorrencia;
		this.fotoOcorrencia = fotoOcorrencia;
		this.ultimaAlteracao = ultimaAlteracao;
		this.imovel = imovel;
		this.cadastroOcorrencia = cadastroOcorrencia;
	}

	public gcom.cadastro.imovel.CadastroOcorrencia getCadastroOcorrencia() {
		return cadastroOcorrencia;
	}

	public void setCadastroOcorrencia(
			gcom.cadastro.imovel.CadastroOcorrencia cadastroOcorrencia) {
		this.cadastroOcorrencia = cadastroOcorrencia;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public byte[] getFotoOcorrencia() {
		return fotoOcorrencia;
	}

	public void setFotoOcorrencia(byte[] fotoOcorrencia) {
		this.fotoOcorrencia = fotoOcorrencia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public gcom.cadastro.imovel.Imovel getImovel() {
		return imovel;
	}

	public void setImovel(gcom.cadastro.imovel.Imovel imovel) {
		this.imovel = imovel;
	}

	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String[] retornaCamposChavePrimaria(){
		String[] retorno = new String[1];
		retorno[0] = "id";
		return retorno;
	}
	
	public Filtro retornaFiltro(){
		FiltroImovelCadastroOcorrencia filtroImovelCadastroOcorrencia = new FiltroImovelCadastroOcorrencia();
		
		filtroImovelCadastroOcorrencia.adicionarCaminhoParaCarregamentoEntidade("imovel");
		filtroImovelCadastroOcorrencia.adicionarCaminhoParaCarregamentoEntidade("cadastroOcorrencia");
		
		filtroImovelCadastroOcorrencia. adicionarParametro(
				new ParametroSimples(FiltroImovelCadastroOcorrencia.ID, this.getId()));
		
		return filtroImovelCadastroOcorrencia; 
	}
	
	@Override
	public String getDescricaoParaRegistroTransacao(){		
			return cadastroOcorrencia.getId() + " - " + cadastroOcorrencia.getDescricao();
	}
}
