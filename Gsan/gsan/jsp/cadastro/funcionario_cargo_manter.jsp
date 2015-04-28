<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg"%>
<%@ taglib uri="/WEB-INF/gsanLib.tld" prefix="gsan" %>
<%@ page import="gsan.util.ConstantesSistema"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>

<head>


<%@ include file="/jsp/util/titulo.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet"
	href="<bean:message key="caminho.css"/>EstilosCompesa.css"
	type="text/css">
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>/validacao/ManutencaoRegistro.js"></script>
<script language="JavaScript"
	src="<bean:message key="caminho.js"/>util.js"></script>
<script>
<!--
function facilitador(objeto){
    if (objeto.id == "0" || objeto.id == undefined){
        objeto.id = "1";
        marcarTodos();
    }
    else{
        objeto.id = "0";
        desmarcarTodos();
    }
}

function verficarSelecao(objeto){

	if (CheckboxNaoVazio(objeto)){
		if (confirm ("Confirma remo��o?")) {
			document.forms[0].action = "/gsan/removerCargoFuncionarioAction.do"
			document.forms[0].submit();
		 }
	}
 }
-->
</script>


</head>

<body leftmargin="5" topmargin="5">

<html:form action="/removerCargoFuncionarioAction" method="post"
	name="ManutencaoRegistroActionForm"
	type="gsan.gui.ManutencaoRegistroActionForm"
>

	<%@ include file="/jsp/util/cabecalho.jsp"%>
	<%@ include file="/jsp/util/menu.jsp"%>

	<table width="770" border="0" cellspacing="5" cellpadding="0">
		<tr>
			<td width="130" valign="top" class="leftcoltext">
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
			<td width="602" valign="top" class="centercoltext">
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

					<logic:notPresent name="acao" scope="session">
						<td class="parabg">Manter Cargo do Funcion�rio</td>
					</logic:notPresent>

					<td width="11"><img border="0"
						src="<bean:message key="caminho.imagens"/>parahead_right.gif" /></td>
				</tr>
			</table>

			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="7" height="23"><font style="font-size: 10px;"
						color="#000000" face="Verdana, Arial, Helvetica, sans-serif"> <strong>Cargo(s) do(s) funcion�rio(s) cadastrado(s):</strong> </font></td>
				</tr>

				<tr>
					<td colspan="7" bgcolor="#000000" height="2"></td>
				</tr>



				<tr>
					<td>
						<table width="100%" bgcolor="#90c7fc">

							<tr>
								<td width="7%">
								<div align="center"><strong><a
									href="javascript:facilitador(this);" id="0">Todos</a></strong></div>
								</td>
								<td width="7%" align="center" bgcolor="#90c7fc"><strong>C�digo</strong></td>
								<td width="30%" align="center" bgcolor="#90c7fc"><strong>Descri��o</strong></td>
								<td width="15%" align="center" bgcolor="#90c7fc"><strong>Desc. Abrev.</strong></td>	
							</tr>

							<%--Esquema de pagina��o--%>
							<pg:pager isOffset="true" index="half-full" maxIndexPages="10"
							export="currentPageNumber=pageNumber;pageOffset"
							maxPageItems="10" items="${sessionScope.totalRegistros}">
								<pg:param name="pg" />
								<pg:param name="q" />

							<logic:present name="colecaoFuncionarioCargo">
								<% String cor = "#cbe5fe";%>

								<logic:iterate name="colecaoFuncionarioCargo" id="funcionarioCargo">
								<pg:item>
									<%	if (cor.equalsIgnoreCase("#cbe5fe")){	
										cor = "#FFFFFF";%>
										<tr bgcolor="#FFFFFF" height="18">	
									<%} else{	
										cor = "#cbe5fe";%>
										<tr bgcolor="#cbe5fe" height="18">		
									<%}%>
											<td width="7%">
                              					<div align="center">
                                					<input type="checkbox" name="idRegistrosRemocao" value="<bean:write name="funcionarioCargo" property="id"/>"/>
                              					</div>
                            				</td>
                            				<td width="7%" align="center">
                               					
                                   				<bean:write name="funcionarioCargo" property="codigo"/>
                                				
                            				</td>
                            				<td width="30%" align="center">
                            				<html:link page="/exibirAtualizarCargoFuncionarioAction.do"
                                           		paramName="funcionarioCargo"
                                          		paramProperty="id"
                                           		paramId="idRegistroAtualizacao">
                              					 <bean:write name="funcionarioCargo" property="descricao"/>
                              				</html:link>
                            			    </td>
                            				<td width="20%" align="center">
                               					<bean:write name="funcionarioCargo" property="descricaoAbreviada"/>
                            				</td>
                            				
											</td>
										</tr>
									</pg:item>
								</logic:iterate>
							</logic:present>
					</table>
					</td>
				</tr>
			</table>

			<table width="100%">
				<tr>
					<td>
						<gsan:controleAcessoBotao name="Button" value="Remover"
							  onclick="javascript:verficarSelecao(document.ManutencaoRegistroActionForm.idRegistrosRemocao);" url="removerCargoFuncionarioAction.do"/>
					 <input name="button" type="button"
						class="bottonRightCol" value="Voltar Filtro"
						onclick="window.location.href='<html:rewrite page="/exibirFiltrarCargoFuncionarioAction.do?desfazer=N"/>'"
						align="left" style="width: 80px;"></td>
					<td align="right">      
					</td>
					<td align="right">      
					<div align="right"><a
							href="javascript:toggleBox('demodiv',1);">
						<img border="0"
							src="<bean:message key="caminho.imagens"/>print.gif"
							title="Imprimir Cargo do Funcion�rio" /> </a></div>
					</td>	
				</tr>
			</table>
			<table width="100%" border="0">

				<tr>
					<td>
					<div align="center"><strong><%@ include
						file="/jsp/util/indice_pager_novo.jsp"%></strong></div>
					</td>
					</pg:pager>
					<%-- Fim do esquema de pagina��o --%>
				</tr>

			</table>
			</td>
		</tr>
	</table>
	<jsp:include page="/jsp/relatorio/escolher_tipo_relatorio.jsp?relatorio=gerarRelatorioCargoFuncionarioManterAction.do"/>
	<%@ include file="/jsp/util/rodape.jsp"%>
	
</body>
</html:form>
</html:html>