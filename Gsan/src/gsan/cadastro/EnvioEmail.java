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
package gsan.cadastro;



import gsan.seguranca.acesso.Funcionalidade;

import java.io.Serializable;


import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class EnvioEmail implements Serializable {

    /** identifier field */
    private Integer id;

    /** persistent field */
    private String emailRemetente;

    /** persistent field */
    private String emailReceptor;

    /** persistent field */
    private String tituloMensagem;

    /** persistent field */
    private String corpoMensagem;

    /** persistent field */
    private Date ultimaAlteracao;

    /** persistent field */
    private Funcionalidade funcionalidade;
    public final static Integer SPC_SERASA = 38;
    public final static Integer SPC_SERASA_MOV_RETORNO = 39;
    public final static Integer SUSPENDER_IMOVEL_EM_PROGRAMA_ESPECIAL_EMAIL = 40;
    public final static Integer GERAR_INTEGRACAO_PARA_CONTABILIDADE = 41;
    public final static Integer REGISTRAR_MOVIMENTO_CARTAO_CREDITO = 42;
    public final static Integer REGISTRAR_MOVIMENTO_CARTAO_CREDITO_COM_ERRO = 43;
    public final static Integer ENVIO_EMAIL_CONTA_PARA_CLIENTE = 44;
    public final static Integer INSERIR_CADASTRO_EMAIL_CLIENTE = 45;
    public final static Integer INSERIR_SOLICITACAO_ACESSO = 46;
    public final static Integer GERAR_TXT_OS_PRESTADORA_SERVICO = 48;
    public final static Integer PROCESSAR_ARQUIVO_TXT_ENCERRAMENTO_OS_COBRANCA = 49;
    public final static Integer PROCESSAR_ARQUIVO_TXT_ENCERRAMENTO_OS_COBRANCA_ERRO = 50;
    public final static Integer ENVIAR_QUESTIONARIO_SATISFACAO_CLIENTE = 51;
    public final static Integer GERAR_TXT_OS_CONTAS_PAGAS_PARCELADAS = 52;
    public final static Integer GERAR_TXT_OS_CONTAS_PAGAS_PARCELADAS_SEM_DADOS = 53;
    public final static Integer GERAR_MOVIMENTO_AUTOMATICO_BANCO_PARCELAMENTO_CLIENTE = 54;
    public final static Integer GERAR_MOVIMENTO_CARTEIRA_17 = 55;
    public final static Integer ENVIAR_EMAIL_COBRANCA_FATURAMENTO = 56;
    
    /** full constructor */
    public EnvioEmail(Integer id, String emailRemetente, String emailReceptor, String tituloMensagem, String corpoMensagem, Date ultimaAlteracao, Funcionalidade funcionalidade) {
        this.id = id;
        this.emailRemetente = emailRemetente;
        this.emailReceptor = emailReceptor;
        this.tituloMensagem = tituloMensagem;
        this.corpoMensagem = corpoMensagem;
        this.ultimaAlteracao = ultimaAlteracao;
        this.funcionalidade = funcionalidade;
    }


    public String getCorpoMensagem() {
		return corpoMensagem;
	}


	public void setCorpoMensagem(String corpoMensagem) {
		this.corpoMensagem = corpoMensagem;
	}


	public String getEmailReceptor() {
		return emailReceptor;
	}


	public void setEmailReceptor(String emailReceptor) {
		this.emailReceptor = emailReceptor;
	}


	public String getEmailRemetente() {
		return emailRemetente;
	}


	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}


	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}


	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTituloMensagem() {
		return tituloMensagem;
	}


	public void setTituloMensagem(String tituloMensagem) {
		this.tituloMensagem = tituloMensagem;
	}


	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}


	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}


	public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}