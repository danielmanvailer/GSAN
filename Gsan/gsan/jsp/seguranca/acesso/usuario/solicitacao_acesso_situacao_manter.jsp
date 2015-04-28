<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg"%>

<%@ page import="gsan.util.ConstantesSistema"%>
<%@ page import="gsan.util.Util"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>

<head>

<%@ include file="/jsp/util/titulo.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet"
	href="<bean:message key="caminho.css"/>EstilosCompesa.css"
	type="text/css">

<script language="JavaScript"
	src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script>
<html:javascript staticJavascript="false"
	formName="InserirSolicitacaoAcessoSituacaoActionForm" />
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>util.js"></script>
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>Calendario.js"></script>
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>validacao/ManutencaoRegistro.js"></script>

<script language="JavaScript">


function facilitador(objeto){
	if (objeto.value == "0"){
		objeto.value = "1";
		marcarTodos();
	}
	else{
		objeto.value = "0";
		desmarcarTodos();
	}
}

function remover(objeto){
	if (CheckboxNaoVazio(objeto)){
		if (confirm ("Confirma remo��o?")) {
			document.forms[0].action = "removerSolicitacaoAcessoSituacaoAction.do"
			document.forms[0].submit();
		 }
	}
}

</script>
</head>

<body leftmargin="5" topmargin="5">
<html:form action="/removerSolicitacaoAcessoSituacaoAction"
	name="ManutencaoRegistroActionForm"
	type="gsan.gui.ManutencaoRegistroActionForm" method="post"
	onsubmit="return CheckboxNaoVazio(document.ManutencaoRegistroActionForm.idRegistrosRemocao) && confirm('Confirma remo��o?')">

	<%@ include file="/jsp/util/cabecalho.jsp"%>
	<%@ include file="/jsp/util/menu.jsp"%>

	<table width="770" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td width="115" valign="top" class="leftcoltext">
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
			<td valign="top" class="centercoltext">
			<table>
				<tr>
					<td></td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="11"><img border="0"
						src="<bean:message key="caminho.imagens"/>parahead_left.gif" /></td>
					<td class="parabg">Manter Situacao Solicitacao Acesso</td>
					<td width="11" valign="top"><img border="0"
						src="<bean:message key="caminho.imagens"/>parahead_right.gif" /></td>
				</tr>
			</table>
			<p>&nbsp;</p>
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td colspan="11"><font color="#000000" style="font-size:10px"
						face="Verdana, Arial, Helvetica, sans-serif"> <strong>Situacao Solicitacao Acesso encontrado(s):</strong> </font></td>
				</tr>
			</table>
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="4" bgcolor="#000000" height="2"></td>
				</tr>
				<tr>
					<td>
					<table width="100%" bgcolor="#99CCFF" border="0">
						<tr bordercolor="#000000">
							<td width="100" bgcolor="#90c7fc" align="center"><strong><a
								href="javascript:facilitador(this);">Todos</a></strong></td>
							<td width="135" bordercolor="#000000" bgcolor="#90c7fc"
								align="center">
							<div align="center" width="135"><strong>C&oacute;digo</strong></div>
							</td>
							<td width="423" bgcolor="#90c7fc" align="center"><strong>Descri��o</strong></td>							
							<td width="225" bgcolor="#90c7fc" align="center"><strong>Indicador de Uso</strong></td>
							<td width="276" bgcolor="#90c7fc" align="center"><strong>Codigo de Situacao</strong></td>
														
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td>
					<table width="100%" bgcolor="#99CCFF">
						<pg:pager isOffset="true" index="half-full" maxIndexPages="10"
							export="currentPageNumber=pageNumber;pageOffset"
							maxPageItems="10" items="${sessionScope.totalRegistros}">
							<pg:param name="pg" />
							<pg:param name="q" />
							<logic:present name="colecaoSolicitacaoAcessoSituacao">
								<%int cont = 0;%>
								<logic:iterate name="colecaoSolicitacaoAcessoSituacao" id="solicitacaoAcessoSituacao"
									scope="request">
									<pg:item>
										<%cont = cont + 1;
			if (cont % 2 == 0) {%>
										<tr bgcolor="#cbe5fe">
											<%} else {%>
										<tr bgcolor="#FFFFFF">
											<%}%>
											<td width="10%">
											<div align="center"><input type="checkbox"
												name="idRegistrosRemocao" value="${solicitacaoAcessoSituacao.id}"></div>
											</td>
											
											<td width="12%" align="center">${solicitacaoAcessoSituacao.id}</td>
											<td width="32%" align="center"><html:link
												page="/exibirAtualizarSolicitacaoAcessoSituacaoAction.do"
												paramName="solicitacaoAcessoSituacao" paramProperty="id"
												paramId="idRegistroAtualizacao">${solicitacaoAcessoSituacao.descricao}
													</html:link></td>

											<html:link href="/gsan/exibirMantersolicitacaoAcessoSituacaoAction.do"
												paramId="codigo" paramProperty="id" paramName="solicitacaoAcessoSituacao">
											</html:link>											
										
										<td width="22%" align="center">
											<logic:equal name='solicitacaoAcessoSituacao' property="indicadorUso" value="1">Ativo</logic:equal>
											<logic:equal name='solicitacaoAcessoSituacao' property="indicadorUso" value="2">Inativo</logic:equal>
										</td>
										
										<td width="22%" align="center">
											<logic:equal name='solicitacaoAcessoSituacao' property="codigoSituacao" value="1">Aguar. Autorizacao</logic:equal>
											<logic:equal name='solicitacaoAcessoSituacao' property="codigoSituacao" value="2">Aguar. Cadastramento</logic:equal> 
											<logic:equal name='solicitacaoAcessoSituacao' property="codigoSituacao" value="3">Concluido</logic:equal>
										</td>
										
										
										</tr>
									</pg:item>
								</logic:iterate>
							</logic:present>
					</table>
					</td>
				</tr>
			</table>
			<table width="100%" border="0">
				<tr>
					<td colspan="2">
					<div align="center"><strong><%@ include
						file="/jsp/util/indice_pager_novo.jsp"%></strong></div>
					</td>
				</tr>
				</pg:pager> 
				<tr>
					<td width="233"><font color="#FF0000"> <input name="Button"
						type="button" class="bottonRightCol" value="Remover" align="left"
						onclick="remover(document.ManutencaoRegistroActionForm.idRegistrosRemocao);" />
					<input name="button" type="button" class="bottonRightCol"
						tabindex="2" value="Voltar Filtro"
						onclick="window.location.href='<html:rewrite page="/exibirFiltrarSolicitacaoAcessoSituacaoAction.do"/>'">
					</font></td>
                    <td align="right" valign="top">
						<a href="javascript:toggleBox('demodiv',1);">
                        	<img align="right" border="0" src="<bean:message key='caminho.imagens'/>print.gif"  title="Imprimir Solicitaco Acesso Situacao"/>
						</a>
					</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>	
		<
		<jsp:include page="/jsp/relatorio/escolher_tipo_relatorio.jsp?relatorio=gerarRelatorioManterSolicitacaoAcessoSituacaoAction.do"/>
<%@ include file="/jsp/util/rodape.jsp"%>
</html:form>
</body>
</html:html>
