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
package gsan.gui.cobranca.spcserasa;

import gsan.cobranca.Negativador;
import gsan.fachada.Fachada;
import gsan.gui.ActionServletException;
import gsan.gui.GcomAction;
import gsan.seguranca.parametrosistema.FiltroParametroSistema;
import gsan.seguranca.parametrosistema.ParametroSistema;
import gsan.spcserasa.FiltroNegativador;
import gsan.util.ConstantesSistema;
import gsan.util.Util;
import gsan.util.filtro.ParametroSimples;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0651] Inserir Comando de Negativa��o
 * Esta caso de uso permite a inclus�o de um novo comando de negativa��o.
 * 
 * @author Ana Maria
 * @date 06/11/2007
 */
public class ExibirInserirComandoNegativacaoTipoComandoAction extends GcomAction {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward retorno = actionMapping.findForward("exibirInserirComandoNegativacaoTipoComando");
		InserirComandoNegativacaoActionForm form = (InserirComandoNegativacaoActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();
		HttpSession sessao = request.getSession(false);

		if (form.getTipo() == null) {
			// Tipo do Comando - exibir com a op��o "Por Crit�rio" selecionada
			form.setTipo("1");
		}

		//Pesquisar Negativador
		Collection colecaoNegativador = (Collection) sessao.getAttribute("colecaoNegativador");
		if (colecaoNegativador == null) {
			FiltroNegativador filtro = new FiltroNegativador();
			filtro.adicionarParametro(new ParametroSimples(FiltroNegativador.INDICADOR_USO, ConstantesSistema.SIM));
			filtro.setCampoOrderBy(FiltroNegativador.CLIENTE);
			filtro.adicionarCaminhoParaCarregamentoEntidade("cliente");
			filtro.setConsultaSemLimites(true);

			colecaoNegativador = fachada.pesquisar(filtro, Negativador.class.getName());

			if (colecaoNegativador == null || colecaoNegativador.isEmpty()) {
				throw new ActionServletException("atencao.entidade_sem_dados_para_selecao", null, "NEGATIVADOR");
			}

			sessao.setAttribute("colecaoNegativador", colecaoNegativador);
		}

		FiltroParametroSistema filtroParametroSistema = new FiltroParametroSistema();
		filtroParametroSistema.adicionarParametro(new ParametroSimples(FiltroParametroSistema.CODIGO_CONSTANTE, ParametroSistema.INDICADOR_NEGATIVACAO_POR_GUIA));
		Collection<?> colecaoParametroSistema = fachada.pesquisar(filtroParametroSistema, ParametroSistema.class.getName());

		if (!colecaoParametroSistema.isEmpty()) {
			ParametroSistema indicadorNegativacaoGuia = (ParametroSistema) Util.retonarObjetoDeColecao(colecaoParametroSistema);
			request.setAttribute("ICNEGATIVACAOPORGUIA", indicadorNegativacaoGuia.getValorParametro());
		} else {
			request.setAttribute("ICNEGATIVACAOPORGUIA", ConstantesSistema.NAO);
		}


		return retorno;
	}

}