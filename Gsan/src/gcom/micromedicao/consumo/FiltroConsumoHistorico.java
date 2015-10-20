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
package gcom.micromedicao.consumo;

import gcom.util.filtro.Filtro;

/**
 * < <Descri��o da Classe>>
 * 
 * @author Administrador
 */
public class FiltroConsumoHistorico extends Filtro {
	private static final long serialVersionUID = 1L;
    /**
     * Constructor for the FiltroCliente object
     * 
     * @param campoOrderBy
     *            Description of the Parameter
     */
    public FiltroConsumoHistorico(String campoOrderBy) {
        this.campoOrderBy = campoOrderBy;
    }

    /**
     * Construtor da classe FiltroAreaConstruidaFaxia
     */
    public FiltroConsumoHistorico() {
    }

    /**
     * Description of the Field
     */
    public final static String ID = "id";

    /**
     * Description of the Field
     */
    public final static String ANO_MES_FATURAMENTO = "referenciaFaturamento";

    /**
     * Description of the Field
     */
    public final static String IMOVEL_ID = "imovel.id";
    
    public final static String IMOVEL_INDICADOR_EXCLUSAO = "imovel.indicadorExclusao";

    public final static String LIGACAO_TIPO_ID = "ligacaoTipo.id";
    
    public final static String ANORMALIDADE_CONSUMO_ID = "consumoAnormalidade.id";
    
    public final static String ANORMALIDADE_CONSUMO = "consumoAnormalidade";
    
    public final static String CONSUMO_FATURADO_MEDIO= "numeroConsumoFaturadoMes";
    
    public final static String CONSUMO_MEDIDO = "consumoMedio"; 
    
    public final static String LOCALIDADE_IMOVEL = "imovel.localidade.id";
    
    public final static String LIGACAO_AGUA_SITUACAO_IMOVEL = "imovel.ligacaoAguaSituacao.id";
    
    public final static String LIGACAO_ESGOTO_SITUACAO_IMOVEL = "imovel.ligacaoEsgotoSituacao.id";
    
    public final static String SETOR_COMERCIAL_IMOVEL = "imovel.setorComercial.id";
    
    public final static String QUADRA_IMOVEL = "imovel.quadra.id";
    
    public final static String INDICADOR_IMOVEL_CONDOMINIO = "imovel.indicadorImovelCondominio";
    
    public final static String PERFIL_IMOVEL = "imovel.imovelPerfil.id";
    
    public final static String IMOVEL_CONDOMINIO_ID = "imovel.imovelCondominio.id";
    
    public final static String CONSUMO_EMPRESA = "imovel.quadra.rota.id";
    
    public final static String CONSUMO_IMOVEL_CONDOMINIO = "consumoImovelCondominio";
    
    public final static String CONSUMO_TIPO = "consumoTipo";
    
    public final static String SOLICITACAO_TIPO_ESPECIFICACAO = "solicitacaoTipoEspecificacao.id";
    
    public final static String CODIGO_SITUACAO = "codigoSituacao";
    
}
