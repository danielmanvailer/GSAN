<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ page import="gsan.util.ConstantesSistema"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>
<head>
<%@ include file="/jsp/util/titulo.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">

<html:javascript formName="InformarSistemaParametrosActionForm" dynamicJavascript="false" staticJavascript="true" />

<script language="JavaScript"
	src="<bean:message key="caminho.js"/>util.js"></script>
<script>

	var bCancel = false;

	function validateInformarSistemaParametrosActionForm(form) {
		if (bCancel){
			return true;
		} else {
			return  validateRequired(form) && 
				validateInteger(form);
		}
		
		//validateCaracterEspecial(form) 
		//&& validateRequired(form)
		//&& validateInteger(form);
	}

	function IntegerValidations () {
		this.aa = new Array("incrementoMaximoConsumo", "Incremento M�ximo de Consumo por economia em Rateio deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));
		//this.ab = new Array("decrementoMaximoConsumo", "Decremento M�ximo de Consumo por economia em Rateio deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));
		this.ac = new Array("diasVencimentoCobranca", "N�mero de Dias entre o Vencimento e o In�cio da Cobran�a deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));
		this.ad = new Array("numeroDiasValidadeExtrato", "N�mero de Dias de Validade do Extrato de D�bito deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));		
		this.ae = new Array("numeroDiasValidadeExtratoPermissaoEspecial", "N�mero de Dias de Validade do Extrato de D�bito para quem possui Permiss�o Especial deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));
		//this.af = new Array("numeroDiasVencimentoEntradaParcelamento", "N�mero de Dias para o Vencimento da Guia de pagamento de Entrada de Parcelamento.", new Function ("varName", " return this[varName];"));	
		this.ag = new Array("numeroDiasEncerrarOsFiscalizacaoDecursoPrazo", "N�mero de dias �teis para que a OS de Fiscaliza��o Seja Encerrada por Decurso de Prazo deve conter apenas n�meros positivos.", new Function ("varName", " return this[varName];"));
		this.ah = new Array("numeroDiasEnvioContaEmpresaCobranca", "N�mero de dias de vencimento para envio das contas para as empresas de cobran�a deve conter apenas n�meros positivos.", new Function ("varName", " return this[varName];"));
		this.ai = new Array("numeroDiaRetiradaContaEmpresaCobraca", "N�mero de dias para retirada das contas das empresas de cobran�a deve conter apenas n�meros positivos.", new Function ("varName", " return this[varName];"));
		this.ac = new Array("quantidadeDiasValidadeCerticaoNegativa", "N�mero de Dias de validade da certid�o negativa de d�bito deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));
		this.aj = new Array("numeroDiasVencContaEntradaParcelamento", "N�mero de Dias �teis para Vencimento das Contas da Entrada de Parcelamento deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));
		this.al = new Array("numeroDiasCancelamentoEntradaParcelamento", "N�mero de Dias �teis para Cancelamento da Entrada de Parcelamento deve somente conter n�meros positivos.", new Function ("varName", " return this[varName];"));		
	}

/*function caracteresespeciais () {
	this.aa = new Array("nomeEstado", "Nome do Estado possui caracteres especiais.", new Function ("varName", " return this[varName];"));
	this.ab = new Array("nomeEmpresa", "Nome da Empresa possui caracteres especiais.", new Function ("varName", " return this[varName];"));
	this.ac = new Array("abreviaturaEmpresa", "Abreviatura da Empresa possui caracteres especiais.", new Function ("varName", " return this[varName];"));
	this.ad = new Array("cnpj", "CNPJ possui caracteres especiais.", new Function ("varName", " return this[varName];"));
}*/

	function required () {
		this.aa = new Array("incrementoMaximoConsumo", "Informe Incremento M�ximo de Consumo por economia em Rateio.", new Function ("varName", " return this[varName];"));
		this.ab = new Array("decrementoMaximoConsumo", "Informe Decremento M�ximo de Consumo por economia em Rateio.", new Function ("varName", " return this[varName];"));
		this.ac = new Array("diasVencimentoCobranca", "Informe N�mero de Dias entre o Vencimento e o In�cio da Cobran�a.", new Function ("varName", " return this[varName];"));
		this.ad = new Array("valorSegundaVia", "Informe o valor da Segunda Via.", new Function ("varName", " return this[varName];"));
		this.ae = new Array("numeroDiasValidadeExtrato", "Informe N�mero de Dias de Validade do Extrato de D�bito.", new Function ("varName", " return this[varName];"));
		this.af = new Array("numeroDiasVencimentoEntradaParcelamento", "Informe N�mero de Dias para o Vencimento da Guia de pagamento de Entrada de Parcelamento.", new Function ("varName", " return this[varName];"));
				
	}




</script>
</head>

<body leftmargin="5" topmargin="5"
	onload="setarFoco('${requestScope.nomeCampo}');">

<html:form action="/informarParametrosSistemaWizardAction" method="post"
	onsubmit="return validateInformarSistemaParametrosActionForm(this);">

	<jsp:include
		page="/jsp/util/wizard/navegacao_abas_wizard_valida_avancar_valida_voltar.jsp?numeroPagina=4" />

	<%@ include file="/jsp/util/cabecalho.jsp"%>
	<%@ include file="/jsp/util/menu.jsp"%>

	<input type="hidden" name="numeroPagina" value="4" />
	<table width="770" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td width="150" valign="top" class="leftcoltext">
			<div align="center">
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>

			<%@ include file="/jsp/util/informacoes_usuario.jsp"%>

			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>

			<%@ include file="/jsp/util/mensagens.jsp"%>

			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			<p align="left">&nbsp;</p>
			</div>
			</td>
			<td width="655" valign="top" class="centercoltext">
			<table height="100%">
				<tr>
					<td></td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="11"><img border="0"
						src="<bean:message key="caminho.imagens"/>parahead_left.gif" /></td>
					<td class="parabg">Informar Par�metros do Sistema</td>
					<td width="11"><img border="0"
						src="<bean:message key="caminho.imagens"/>parahead_right.gif" /></td>
				</tr>
			</table>
			<p>&nbsp;</p>
			<table width="100%" border="0" dwcopytype="CopyTableRow">
				<tr>
					<td>Para informar par�metros do sistema, informe os dados abaixo:
					<td align="right"><a
						href="javascript: abrirPopup('/gsan/help/help.jsp?mapIDHelpSet=clienteInserirAbaNomeTipo', 500, 700);"><span
						style="font-weight: bold"><font color="#3165CE">Ajuda</font></span></a></td>
				</tr>
			</table>

			<table width="100%" border="0">


				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><strong>Par�metros para
					Micromedi��o:</strong></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>Menor Capacidade de Hidr�metro para ser Grande Usu�rio:</strong>
					</td>
					<td>
						<html:select property="codigoMenorCapacidade">
						<html:option value="<%=""+ConstantesSistema.NUMERO_NAO_INFORMADO%>">&nbsp;</html:option>
						<html:options collection="colecaoHidrometroCapacidade"
							labelProperty="descricao" 
							property="id" />
						</html:select>
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Indicador de Gera��o de Faixa Falsa:</strong>
					</td>
					<td><strong> 
						<html:radio property="indicadorGeracaoFaixaFalsa" value="1" /> Sim 
						<html:radio property="indicadorGeracaoFaixaFalsa" value="2" /> N&atilde;o 
						<html:radio property="indicadorGeracaoFaixaFalsa" value="3" /> De acordo com a Rota
						</strong>
					</td>
				</tr>

				<tr>
					<td width="40%">
						<strong>Indicador do Percentual para Gera��o de Faixa Falsa:</strong>
					</td>
					<td>
						<strong> 
						<html:radio property="indicadorPercentualGeracaoFaixaFalsa" value="1" /> Percentual Par�metro 
						<html:radio property="indicadorPercentualGeracaoFaixaFalsa" value="2" /> Percentual da Rota 
						</strong>
					</td>
				</tr>

				<tr>
					<td width="40%" align="left">
						<strong> Percentual de Gera��o de Faixa Falsa:</strong>
					</td>
					<td>
						<html:text property="percentualGeracaoFaixaFalsa"
							size="5" 
							maxlength="5"
							onkeyup="javascript:formataValorMonetario(this, 5);" /> 
					</td>
				</tr>

				<tr>
					<td width="40%">
						<strong>Indicador de Gera��o de Fiscaliza��o de Leitura :</strong>
					</td>
					<td>
						<strong> 
						<html:radio property="indicadorGeracaoFiscalizacaoLeitura" value="1" /> Sim 
						<html:radio property="indicadorGeracaoFiscalizacaoLeitura" value="2" /> N�o 
						<html:radio property="indicadorGeracaoFiscalizacaoLeitura" value="3" /> De acordo com a Rota 
						</strong>
					</td>

				</tr>

				<tr>
					<td width="40%">
						<strong>Indicador do Percentual Gera��o de Fiscaliza��o de Leitura :</strong>
					</td>
					<td>
						<strong> 
						<html:radio property="indicadorPercentualGeracaoFiscalizacaoLeitura" value="1" /> Percentual Par�metro 
						<html:radio property="indicadorPercentualGeracaoFiscalizacaoLeitura" value="2" /> Percentual da Rota 
						</strong>
					</td>
				</tr>

				<tr>
					<td width="40%" align="left">
						<strong>Percentual de Gera��o de Fiscaliza��o de Leitura:</strong>
					</td>
					<td>
						<html:text property="percentualGeracaoFiscalizacaoLeitura" 
							size="5"
							maxlength="5" 
							onkeyup="javascript:formataValorMonetario(this, 5);" />
					</td>
				</tr>

				<tr>
					<td width="40%" align="left">
						<strong>Incremento M�ximo de Consumo por economia em Rateio:</strong>
						<font color="#FF0000">*</font>
					</td>
					<td width="87%">
						<html:text property="incrementoMaximoConsumo"
							size="9" 
							maxlength="9"
								 onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].incrementoMaximoConsumo, 'Incremento Maximo de Consumo');" />  
					</td>
				</tr>

				<tr>
					<td width="40%" align="left">
						<strong>Decremento M�ximo de Consumo por economia em Rateio: </strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<html:text property="decrementoMaximoConsumo"
							size="9" 
							maxlength="9"
							 onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].decrementoMaximoConsumo, 'Decremento Maximo Consumo');" /> 
					</td>
				</tr>

				<tr>
					<td width="40%" align="left">
						<strong>Percentual de Toler�ncia para o Rateio do Consumo: </strong>
					</td>
					<td width="87%">
						<html:text property="percentualToleranciaRateioConsumo" 
							size="5"
							maxlength="5" 
							onkeyup="javascript:formataValorDecimalUmaCasa(this, 3);" />
					</td>
				</tr>
				
				<tr>
					<td width="40%"><strong>Im�vel em Situa��o n�o Faturar Recebe Rateio de �rea Comum?</strong></td>
					<td>
						<strong> 
							<html:radio property="indicadorRateioAreaComumImovelNaoFat" value="1" /> Sim 
							<html:radio property="indicadorRateioAreaComumImovelNaoFat" value="2" /> N�o 
						</strong>
					</td>

				</tr>

				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><strong>Par�metros para Cobran�a:</strong></td>

				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>

				<tr>
					<td width="40%" align="left">
						<strong>N�mero de Dias entre o Vencimento e o In�cio da Cobran�a:</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<html:text maxlength="2" 
							property="diasVencimentoCobranca"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].diasVencimentoCobranca, 'Dias Vencimento Cobranca');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N�mero M�ximo de Meses de San��es:</strong>
					</td>
					<td>
						<html:text maxlength="2" 
							property="numeroMaximoMesesSancoes"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroMaximoMesesSancoes, 'N�mero Maximo de Meses San��es');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>Valor da Segunda Via:</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<html:text maxlength="13" 
							property="valorSegundaVia" 
							size="13" onkeyup="javascript:formataValorMonetario(this, 13);"/>
					</td>
				</tr>	
				
				<tr>
					<td width="40%">
						<strong>Indicador de Cobran�a da Taxa de Extrato :</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong> 
						<html:radio property="indicadorCobrarTaxaExtrato" value="1" /> Sim 
						<html:radio property="indicadorCobrarTaxaExtrato" value="2" /> N&atilde;o 
						</strong>
					</td>
				</tr>

				<tr>
					<td width="40%" align="left">
						<strong>C�digo da Periodicidade da Negativa�&atilde;o:</strong>
					</td>
					<td>
						<html:text maxlength="2" 
							property="codigoPeriodicidadeNegativacao"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].codigoPeriodicidadeNegativacao, 'Codigo Periodicidade Negativacao');" />
					</td>
				</tr>

               <tr>
					<td width="40%" align="left">
						<strong>N�mero de Dias para C�lculo de Adicionais de Impontualidade:</strong>
					</td>
					<td>
						<html:text maxlength="2" 
							property="numeroDiasCalculoAcrescimos"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiasCalculoAcrescimos, 'N�mero Dias para Calculo Acrescimos');" />
					</td>
				</tr>
				
				
				<tr>
					<td width="40%" align="left">
						<strong>N�mero de Dias de Validade do Extrato de D�bito:</strong>
					</td>
					<td>
						<html:text maxlength="2" 
							property="numeroDiasValidadeExtrato"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiasValidadeExtrato, 'N�mero Dias Validade Extrato');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N�mero de Dias de Validade do Extrato de D�bito para quem possui Permiss�o Especial:</strong>
					</td>
					<td>
						<html:text maxlength="2" 
							property="numeroDiasValidadeExtratoPermissaoEspecial"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiasValidadeExtratoPermissaoEspecial, 'N�mero Dias Validade Extrato Permiss�o Especial');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N�mero de Dias para o Vencimento da Guia de pagamento de Entrada de Parcelamento:</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<html:text maxlength="2" 
							property="numeroDiasVencimentoEntradaParcelamento"
							size="2" onkeypress="return isCampoNumerico(event)"
							 />
					</td>
					<!-- onchange="validarCampoNumerico(document.forms[0].numeroDiasVencimentoEntradaParcelamento, 'N�mero Dias Vencimento Entrada Parcelamento');"-->
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>Resolu��o de Diretoria para C�lculo de Descontos para pagamento � vista :</strong>
					</td>
					<td>
						<html:select property="idResolucaoDiretoria">
						<html:option value="<%=""+ConstantesSistema.NUMERO_NAO_INFORMADO%>">&nbsp;</html:option>
							<html:options collection="colecaoResolucaoDiretoria"
							labelProperty="numeroResolucaoDiretoria" 
							property="id" />
						</html:select>
					</td>
				</tr>
				
				
				<tr>
					<td width="40%">
						<strong>Indicador Parcelamento Confirmado :</strong>
					</td>
					<td>
						<strong> 
							<html:radio property="indicadorParcelamentoConfirmado" value="1" /> Sim 
							<html:radio property="indicadorParcelamentoConfirmado" value="2" /> N&atilde;o 
						</strong>
					</td>
				</tr>
				<tr>
					<td width="40%" align="left">
						<strong>N�mero de dias �teis para que a OS de Fiscaliza��o Seja Encerrada por Decurso de Prazo:</strong>
					</td>
					<td>
						<html:text maxlength="3" 
							property="numeroDiasEncerrarOsFiscalizacaoDecursoPrazo"
							size="3" 							
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiasEncerrarOsFiscalizacaoDecursoPrazo, 'N�mero de dias �teis para que a OS de Fiscaliza��o seja encerrada por Decurso de Prazo');" />
							
					</td>
				</tr>
				<!--Erivan Sousa - Criticar Conte�do do Retorno Movimento Negativa��o Confirmado  -->
				<tr>
					<td width="40%">
						<strong>Criticar Conte&uacute;do do Retorno Movimento Negativa&ccedil;&atilde;o Confirmado :</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong> 
							<html:radio property="indicadorCriticarConteudoRetornoMovimentoNegativacao"
							value="<%=ConstantesSistema.SIM.toString()%>" /> Sim 
							<html:radio property="indicadorCriticarConteudoRetornoMovimentoNegativacao"
							value="<%=ConstantesSistema.NAO.toString()%>" /> N&atilde;o 
						</strong>
					</td>
				</tr>
			<tr>
			<td colspan="3"><hr></td>
			</tr>
				<tr>
					<td width="40%">
						<strong>C�lculo juros parcelamento pela tabela price :</strong>
					</td>
					<td>
						<strong> 
							<html:radio property="indicadorTabelaPrice" value="1" /> Sim 
							<html:radio property="indicadorTabelaPrice" value="2" /> N&atilde;o 
						</strong>
					</td>
				</tr>
				
			<tr>
			<td colspan="3"><hr></td>
			</tr>
				<tr>
					<td width="40%">
						<strong>Retirar Contas Vinculadas a Contrato de Parcelamento da Composi��o do D�bito do Im�vel ou do Cliente?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorBloqueioContasContratoParcelDebitos" value="1" /> Sim
							<html:radio property="indicadorBloqueioContasContratoParcelDebitos" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Retirar Guias Vinculadas a Contrato de Parcelamento da Composi��o do D�bito do Im�vel ou do Cliente?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong> 
							<html:radio property="indicadorBloqueioGuiasOuAcresContratoParcelDebito" value="1" /> Sim
							<html:radio property="indicadorBloqueioGuiasOuAcresContratoParcelDebito" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				<tr>
					<td width="40%">
						<strong>Retirar os D�bitos a Cobrar Vinculados ao Contrato de Parcelamento da Composi��o do D�bito do Im�vel ou do Cliente?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong> 
							<html:radio property="indicadorBloqueioDebitoACobrarContratoParcelDebito" value="1" /> Sim
							<html:radio property="indicadorBloqueioDebitoACobrarContratoParcelDebito" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Bloquear Contas Vinculadas a Contrato de Parcelamento na tela de Manter Conta?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong> 
							<html:radio property="indicadorBloqueioContasContratoParcelManterConta" value="1" /> Sim
							<html:radio property="indicadorBloqueioContasContratoParcelManterConta" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Bloquear Guias de Juros ou de Acr�scimos por Impontualidade Vinculadas a Contrato de Parcelamento na tela de Manter Guia?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorBloqueioGuiasOuAcresContratoParcelManterConta" value="1" /> Sim
							<html:radio property="indicadorBloqueioGuiasOuAcresContratoParcelManterConta" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				<tr>
					<td width="40%">
						<strong>Bloquear os D�bitos a Cobrar Vinculados ao Contrato de Parcelamento na tela de Manter D�bitos a Cobrar?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorBloqueioDebitoACobrarContratoParcelManterDebito" value="1" /> Sim
							<html:radio property="indicadorBloqueioDebitoACobrarContratoParcelManterDebito" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Calcular Acr�scimo por Impontualidade para Guias de Pagamento na tela de extrato de d�bito?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorCalcAcresImpontGuiaPagamento" value="1" /> Sim
							<html:radio property="indicadorCalcAcresImpontGuiaPagamento" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Remover Restri��o do Cliente no SPC/SERASA ap�s o pagamento da entrada do parcelamento?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorExcluirNegativacaoAposPgmto" value="1" /> Sim
							<html:radio property="indicadorExcluirNegativacaoAposPgmto" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				
					<tr>
						<td colspan="3"><hr></td>
					</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N�mero M�ximo de Parcelas para os Contratos de Parcelamento por Cliente:</strong>
					</td>
					<td>
						<html:text maxlength="3" 
							property="numeroMaximoParcelasContratosParcelamento"
							size="3" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroMaximoParcelasContratosParcelamento, 'N�mero Maximo Parcelas Contratos Parcelamento');" />
					</td>
				</tr>


				<tr>
					<td width="40%">
						<strong>Indicador para filtro por valor total d�bito para Cobran�a por resultado:</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorTotalDebito" value="1" /> Sim
							<html:radio property="indicadorTotalDebito" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
				<tr>
					<td width="40%">
						<strong>Conta com vencimento alterado excluir da negativa��o?</strong>
						<font color="#FF0000">*</font>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorCanceNegatContaVencAlter" value="1" /> Sim
							<html:radio property="indicadorCanceNegatContaVencAlter" value="2" /> N&atilde;o
						</strong>
					</td>
				</tr>
								
				<tr>
					<td width="40%" align="left">
						<strong>N�mero de dias de vencimento para envio das contas para as empresas de cobran�a:</strong>
					</td>
					<td>
						<html:text maxlength="3" 
							property="numeroDiasEnvioContaEmpresaCobranca"
							size="3" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiasEnvioContaEmpresaCobranca, 'N�mero de dias de vencimento para envio das contas para as empresas de cobran�a ');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N�mero de dias para retirada das contas das empresas de cobran�a:</strong>
					</td>
					<td>
						<html:text maxlength="3" 
							property="numeroDiaRetiradaContaEmpresaCobraca"
							size="3" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiaRetiradaContaEmpresaCobraca, 'N�mero de dias para retirada das contas das empresas de cobran�a');" />
					</td>
				</tr>
				<tr>
					<td width="40%">
						<strong>Incluir contas fora do vencimento para cobran�a?:</strong>
					</td>
					<td>
						<strong> 
							<html:radio property="indicadorIncluirContasForaVenCobranca" value="1" /> Sim 
							<html:radio property="indicadorIncluirContasForaVenCobranca" value="2" /> N&atilde;o 
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N�mero de Dias de validade da certid�o negativa de d�bito:</strong>
						
					</td>
					<td>
						<html:text maxlength="3" 
							property="quantidadeDiasValidadeCerticaoNegativa"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].quantidadeDiasValidadeCerticaoNegativa, 'Quantidade Dias Validade Certi��o Negativa');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N&uacute;mero de dias &uacute;teis para vencimento das contas da entrada de parcelamento:</strong>
						
					</td>
					<td>
						<html:text maxlength="3" 
							property="numeroDiasVencContaEntradaParcelamento"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiasVencContaEntradaParcelamento, 'N�mero de dias �teis para vencimento das contas da entrada de parcelamento');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%" align="left">
						<strong>N&uacute;mero de dias &uacute;teis para cancelamento da entrada de parcelamento:</strong>
						
					</td>
					<td>
						<html:text maxlength="3" 
							property="numeroDiasCancelamentoEntradaParcelamento"
							size="2" 
							onchange="validarCampoNumericoComMensagemLimpandoCampo(document.forms[0].numeroDiasCancelamentoEntradaParcelamento, 'N�mero de dias �teis para Cancelamento da Entrada de Parcelamento');" />
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Indicador para verificar a a��o predecessora para os im�veis do arquivo texto:<font color="red">*</font></strong>
					</td>
					<td><strong> 
						<html:radio property="indicadorAcaoPredecessoraImoveisArquivoTexto" value="1" /> Sim 
						<html:radio property="indicadorAcaoPredecessoraImoveisArquivoTexto" value="2" /> N&atilde;o 
						</strong>
					</td>
				</tr>
				
				<tr>
					<td width="40%">
						<strong>Indicador de Permiss�o de Altera��o de Dados ou V�nculo de Cliente Negativado:<font color="red">*</font></strong>
					</td>
					<td>
						<strong>
							<html:radio property="indicadorPermissaoAlteracaoClienteNegativado" value="1"/>Sim
							<html:radio property="indicadorPermissaoAlteracaoClienteNegativado" value="2"/>N&atilde;o 
						</strong>
					</td>
				</tr>
								
			<p>&nbsp;</p>
				<tr>
					<td></td>
					<td>
						<font color="#FF0000">*</font>Campo obrigat&oacute;rio
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
					<div align="right"><jsp:include
						page="/jsp/util/wizard/navegacao_botoes_wizard_valida_avancar_valida_voltar.jsp?numeroPagina=4" /></div>
					</td>
				</tr>
			</table>
		
			</td>
		</tr>
	</table>

	<%@ include file="/jsp/util/rodape.jsp"%>
</body>
</html:form>
</html:html>
