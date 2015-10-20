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
package gcom.gui.atendimentopublico.ligacaoagua;

import gcom.atendimentopublico.bean.IntegracaoComercialHelper;
import gcom.atendimentopublico.ligacaoagua.FiltroLigacaoAgua;
import gcom.atendimentopublico.ligacaoagua.LigacaoAgua;
import gcom.atendimentopublico.ordemservico.OrdemServico;
import gcom.atendimentopublico.ordemservico.ServicoNaoCobrancaMotivo;
import gcom.cadastro.imovel.FiltroImovel;
import gcom.cadastro.imovel.Imovel;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.micromedicao.hidrometro.Hidrometro;
import gcom.micromedicao.hidrometro.HidrometroInstalacaoHistorico;
import gcom.micromedicao.hidrometro.HidrometroLocalInstalacao;
import gcom.micromedicao.hidrometro.HidrometroProtecao;
import gcom.micromedicao.medicao.MedicaoTipo;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action respons�vel pela realiza��o de efetuar religa��o de �gua com instala��o de hidrometro
 * 
 * @author S�vio Luiz
 * @created 29/01/2008
 */
public class EfetuarReligacaoAguaComInstalacaoHidrometroAction extends GcomAction {

	/**
	 * Description of the Method
	 * 
	 * @param actionMapping
	 *            Description of the Parameter
	 * @param actionForm
	 *            Description of the Parameter
	 * @param httpServletRequest
	 *            Description of the Parameter
	 * @param httpServletResponse
	 *            Description of the Parameter
	 * @return Description of the Return Value
	 */
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {

		// localiza o action no objeto actionmapping
		ActionForward retorno = actionMapping.findForward("telaSucesso");
		HttpSession sessao = httpServletRequest.getSession(false);

		EfetuarReligacaoAguaComInstalacaoHidrometroActionForm efetuarReligacaoAguaComInstalacaoHidrometroActionForm = (EfetuarReligacaoAguaComInstalacaoHidrometroActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();

		// Usuario logado no sistema
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		String ordemServicoId = efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getIdOrdemServico();

		LigacaoAgua ligacaoAgua = this.setDadosLigacaoAgua(efetuarReligacaoAguaComInstalacaoHidrometroActionForm,fachada);
		HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico = new HidrometroInstalacaoHistorico();
		hidrometroInstalacaoHistorico = this.setDadosHidrometroInstalacaoHistorico(
						hidrometroInstalacaoHistorico,efetuarReligacaoAguaComInstalacaoHidrometroActionForm);
		
		Imovel imovel = null;

		if (ordemServicoId != null && !ordemServicoId.equals("")) {

			OrdemServico ordemServico = (OrdemServico) sessao.getAttribute("ordemServico");

			if (ordemServico == null) {
				throw new ActionServletException("atencao.ordem_servico_inexistente", null,"ORDEM DE SERVI�O INEXISTENTE");
			}

			if (sessao.getAttribute("imovel") != null) {
				imovel = (Imovel) sessao.getAttribute("imovel");
				imovel.setUltimaAlteracao(new Date());
				ligacaoAgua.setImovel(imovel);
//				hidrometroInstalacaoHistorico.setImovel(imovel);
				
				//ligacaoAgua.setId(imovel.getId());
				hidrometroInstalacaoHistorico.setLigacaoAgua(ligacaoAgua);
			}

			hidrometroInstalacaoHistorico.setLigacaoAgua(ligacaoAgua);
			
			
			ordemServico = this.setDadosOrdemServico(ordemServico, efetuarReligacaoAguaComInstalacaoHidrometroActionForm);
			
			String qtdParcelas = efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getQuantidadeParcelas();

			IntegracaoComercialHelper integracaoComercialHelper = new IntegracaoComercialHelper();

			integracaoComercialHelper.setLigacaoAgua(ligacaoAgua);
			this.pesquisarImovelPerfil(imovel);
			integracaoComercialHelper.setImovel(imovel);
			integracaoComercialHelper.setOrdemServico(ordemServico);
			integracaoComercialHelper.setQtdParcelas(qtdParcelas);
			integracaoComercialHelper.setHidrometroInstalacaoHistorico(hidrometroInstalacaoHistorico);

			if (efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getVeioEncerrarOS().equalsIgnoreCase("FALSE")) {
				integracaoComercialHelper.setVeioEncerrarOS(Boolean.FALSE);

				fachada.efetuarReligacaoAguaComInstalacaoHidrometro(integracaoComercialHelper, usuario);
			} else {
				integracaoComercialHelper.setVeioEncerrarOS(Boolean.TRUE);
				sessao.setAttribute("integracaoComercialHelper",integracaoComercialHelper);

				if (sessao.getAttribute("semMenu") == null) {
					retorno = actionMapping.findForward("encerrarOrdemServicoAction");
				} else {
					retorno = actionMapping.findForward("encerrarOrdemServicoPopupAction");
				}
				sessao.removeAttribute("caminhoRetornoIntegracaoComercial");
			}
			if (retorno.getName().equalsIgnoreCase("telaSucesso")) {
				// Monta a p�gina de sucesso
				montarPaginaSucesso(httpServletRequest,
						"Religa��o de �gua com Instala��o de Hidr�metro efetuada com Sucesso",
						"Efetuar outra Religa��o de �gua com Instala��o de Hidr�metro",
						"exibirEfetuarReligacaoAguaComInstalacaoHidrometroAction.do?menu=sim");
			}

			return retorno;
		} else {
			throw new ActionServletException("atencao.informe_campo", null,	"Ordem de Servi�o");
		}
	}
	
	private void pesquisarImovelPerfil(Imovel imovel){
		
		FiltroImovel filtroImovel = new FiltroImovel();
		filtroImovel.adicionarParametro(new ParametroSimples(FiltroImovel.ID, imovel.getId()));
		filtroImovel.adicionarCaminhoParaCarregamentoEntidade(FiltroImovel.IMOVEL_PERFIL);
		Collection colecaoImovel = getFachada().pesquisar(filtroImovel, Imovel.class.getName());
		
		if(!Util.isVazioOrNulo(colecaoImovel)){
			Imovel imovelAtualizar = (Imovel) Util.retonarObjetoDeColecao(colecaoImovel);
			imovel.setImovelPerfil(imovelAtualizar.getImovelPerfil());
		}
	}

	// [SB0001] - Gerar Liga��o de �gua
	//
	// M�todo respons�vel por setar os dados da liga��o de �gua
	// de acordo com os dados selecionados pelo usu�rio e pelas exig�ncias do caso de uso
	public LigacaoAgua setDadosLigacaoAgua(EfetuarReligacaoAguaComInstalacaoHidrometroActionForm 
			efetuarReligacaoAguaComInstalacaoHidrometroActionForm,Fachada fachada) {


		FiltroLigacaoAgua filtroLigacaoAgua = new FiltroLigacaoAgua();
		filtroLigacaoAgua.adicionarParametro(new ParametroSimples(
				FiltroLigacaoAgua.ID, efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getMatriculaImovel()));
		Collection colecaoLigacaoAguaBase = fachada.pesquisar(filtroLigacaoAgua,LigacaoAgua.class.getName());
		
		LigacaoAgua ligacaoAgua = (LigacaoAgua) Util
				.retonarObjetoDeColecao(colecaoLigacaoAguaBase);

		if (efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getDataReligacao() != null
				&& !efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getDataReligacao().equals("")) {
			Date data = Util.converteStringParaDate(efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getDataReligacao());
			ligacaoAgua.setDataReligacao(data);
		} else {
			throw new ActionServletException("atencao.informe_campo", null," Data da Religa��o");
		}
		
		return ligacaoAgua;
	}

	// [SB0003] - Atualizar Ordem de Servi�o
	//
	// M�todo respons�vel por setar os dados da ordem de servi�o
	// de acordo com as exig�ncias do caso de uso
	public OrdemServico setDadosOrdemServico(
			OrdemServico ordemServico,
			EfetuarReligacaoAguaComInstalacaoHidrometroActionForm efetuarReligacaoAguaComInstalacaoHidrometroActionForm) {

		String idServicoMotivoNaoCobranca = efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getMotivoNaoCobranca();
		String valorPercentual = efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getPercentualCobranca();

		if (ordemServico != null && efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getIdTipoDebito() != null) {

			ServicoNaoCobrancaMotivo servicoNaoCobrancaMotivo = null;

			ordemServico.setIndicadorComercialAtualizado(new Short("1"));

			if (idServicoMotivoNaoCobranca != null
					&& !idServicoMotivoNaoCobranca.equals(ConstantesSistema.NUMERO_NAO_INFORMADO + "")) {
				servicoNaoCobrancaMotivo = new ServicoNaoCobrancaMotivo();
				servicoNaoCobrancaMotivo.setId(new Integer(idServicoMotivoNaoCobranca));
			}

			ordemServico.setServicoNaoCobrancaMotivo(servicoNaoCobrancaMotivo);

			if (valorPercentual != null) {
				ordemServico.setPercentualCobranca(new BigDecimal(
						efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getPercentualCobranca()));
			}

			ordemServico.setUltimaAlteracao(new Date());

		}

		BigDecimal valorAtual = new BigDecimal(0);
		if (efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getValorDebito() != null) {
			String valorDebito = efetuarReligacaoAguaComInstalacaoHidrometroActionForm
					.getValorDebito().toString().replace(".", "");

			valorDebito = valorDebito.replace(",", ".");

			valorAtual = new BigDecimal(valorDebito);

			ordemServico.setValorAtual(valorAtual);
		}

		return ordemServico;
	}

	// [SB0004] - Gerar Hist�rico de Instala��o do Hidr�metro
	//
	// M�todo respons�vel por setar os dados do hidr�metro instala��o hist�rico
	// de acordo com os dados selecionados pelo usu�rio e pelas exig�ncias do caso de uso
	public HidrometroInstalacaoHistorico setDadosHidrometroInstalacaoHistorico(
			HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico,
			EfetuarReligacaoAguaComInstalacaoHidrometroActionForm efetuarReligacaoAguaComInstalacaoHidrometroActionForm) {

		Fachada fachada = Fachada.getInstancia();

		String numeroHidrometro = efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getNumeroHidrometro();

		if (numeroHidrometro != null) {
			// Pesquisa o Hidr�metro
			Hidrometro hidrometro = fachada.pesquisarHidrometroPeloNumero(numeroHidrometro);
			
//			FiltroHidrometro filtroHidrometro = new FiltroHidrometro();
//			filtroHidrometro.adicionarParametro(new ParametroSimples(
//					FiltroHidrometro.NUMERO_HIDROMETRO, numeroHidrometro));
//			// Realiza a pesquisa do Hidr�metro
//			Collection colecaoHidrometro = fachada.pesquisar(filtroHidrometro,
//					Hidrometro.class.getName());
//
//			// verificar se o n�mero do hidr�metro n�o est� cadastrado
//			if (colecaoHidrometro == null || colecaoHidrometro.isEmpty()) {
//				throw new ActionServletException(
//						"atencao.hidrometro_inexistente");
//			}
//			Iterator iteratorHidrometro = colecaoHidrometro.iterator();
//			Hidrometro hidrometro = (Hidrometro) iteratorHidrometro.next();
			
			if (hidrometro == null) {
				throw new ActionServletException("atencao.hidrometro_inexistente");
			}
			
			fachada.validacaoInstalacaoHidrometro(numeroHidrometro);
			
			hidrometroInstalacaoHistorico.setHidrometro(hidrometro);
		}

		// Data instala��o
		if (efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getDataInstalacao() != null
				&& !efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getDataInstalacao().equals("")) {

			hidrometroInstalacaoHistorico.setDataInstalacao(Util
			.converteStringParaDate(efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getDataInstalacao()));

		}
		
		// Medi��o tipo
		MedicaoTipo medicaoTipo = new MedicaoTipo();
		medicaoTipo.setId(MedicaoTipo.LIGACAO_AGUA);
		hidrometroInstalacaoHistorico.setMedicaoTipo(medicaoTipo);

		// hidr�metro local instala��o
		HidrometroLocalInstalacao hidrometroLocalInstalacao = new HidrometroLocalInstalacao();
		hidrometroLocalInstalacao.setId(Integer.parseInt(
				efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getLocalInstalacao()));
		hidrometroInstalacaoHistorico.setHidrometroLocalInstalacao(hidrometroLocalInstalacao);

		// prote��o
		HidrometroProtecao hidrometroProtecao = new HidrometroProtecao();
		hidrometroProtecao.setId(Integer.parseInt(efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getProtecao()));
		hidrometroInstalacaoHistorico.setHidrometroProtecao(hidrometroProtecao);

		// leitura instala��o
		if (efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getLeituraInstalacao() != null
				&& !efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getLeituraInstalacao().trim().equals("")) {
			hidrometroInstalacaoHistorico.setNumeroLeituraInstalacao(Integer
				.parseInt(efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getLeituraInstalacao()));
		} else {
			hidrometroInstalacaoHistorico.setNumeroLeituraInstalacao(0);
		}

		// cavalete
		hidrometroInstalacaoHistorico.setIndicadorExistenciaCavalete(Short
				.parseShort(efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getSituacaoCavalete()));

		/*
		 * Campos opcionais
		 */

		// data da retirada
		hidrometroInstalacaoHistorico.setDataRetirada(null);
		// leitura retirada
		hidrometroInstalacaoHistorico.setNumeroLeituraRetirada(null);
		// leitura corte
		hidrometroInstalacaoHistorico.setNumeroLeituraCorte(null);
		// leitura supress�o
		hidrometroInstalacaoHistorico.setNumeroLeituraSupressao(null);
		// numero selo
		if (efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getNumeroSelo() != null
				&& !efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getNumeroSelo().equals("")) {
			hidrometroInstalacaoHistorico.setNumeroSelo(efetuarReligacaoAguaComInstalacaoHidrometroActionForm.getNumeroSelo());
		} else {
			hidrometroInstalacaoHistorico.setNumeroSelo(null);
		}
		// tipo de rateio
		hidrometroInstalacaoHistorico.setRateioTipo(null);
		hidrometroInstalacaoHistorico.setDataImplantacaoSistema(new Date());

		// indicador instala��o substitui��o
		hidrometroInstalacaoHistorico.setIndicadorInstalcaoSubstituicao(new Short("1"));

		// data �ltima altera��o
		hidrometroInstalacaoHistorico.setUltimaAlteracao(new Date());

		return hidrometroInstalacaoHistorico;

	}
}
