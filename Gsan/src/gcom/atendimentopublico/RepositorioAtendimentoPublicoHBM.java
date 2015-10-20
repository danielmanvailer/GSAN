/*
	 * [UC1107] Manter Custo de Pavimento por Repavimentadora
 	 * 
 	 * @author Hugo Leonardo
 	 * @date 27/12/2010
 	 * 
 	 * @param idRepavimentadora, idPavimento, indicadorPavimento: 1-Rua, 2-Cal�ada
 	 * @return boolean
	 */
	public boolean verificaRemoverCustoPavimentoPorRepavimentadora(Integer idRepavimentadora,
			Integer idPavimento, Integer indicadorPavimento)throws ErroRepositorioException{
		
		// Cria uma sess�o com o hibernate
		Session session = HibernateUtil.getSession();

		// Retorno Consulta
		boolean retorno = false;

		// Cria a vari�vel que vai conter o hql
		String consulta = "";

		try {
				
			if(indicadorPavimento == 1){
				consulta +=
						  " SELECT ospv.id "
						+ " FROM OrdemServicoPavimento ospv, UnidadeRepavimentadoraCustoPavimentoRua urr1, UnidadeRepavimentadoraCustoPavimentoRua urr2 "
						+ " INNER JOIN ospv.ordemServico os" 
						+ " WHERE ospv.unidadeRepavimentadora.id = :repavimentadora " 
						+ " AND ((urr1.pavimentoRua.id = ospv.pavimentoRua.id and ospv.pavimentoRuaRetorno is null and urr1.pavimentoRua.id = :pavimento and urr1.unidadeRepavimentadora.id = :repavimentadora) " 
						+ " OR (urr2.pavimentoRua.id = ospv.pavimentoRuaRetorno.id and ospv.pavimentoRuaRetorno is not null and urr2.pavimentoRua.id = :pavimento and urr2.unidadeRepavimentadora.id = :repavimentadora)) "
						+ " AND ( "
						+ " 	( "
						+ " 	os.dataEncerramento >= urr1.dataVigenciaInicial "
						+ " 	AND	os.dataEncerramento <= urr1.dataVigenciaFinal "
						+ " 	AND urr1.dataVigenciaFinal is not null "
						+ " 	AND ospv.pavimentoRuaRetorno is null "
						+ " 	) "
						+ " OR ( "
						+ "  	os.dataEncerramento >= urr1.dataVigenciaInicial"
						+ "  	AND urr1.dataVigenciaFinal is null"
						+ "  	AND ospv.pavimentoRuaRetorno is null"
						+ "  	)"
						+ " OR ( "
						+ "  	os.dataEncerramento >= urr2.dataVigenciaInicial"
						+ "  	AND	os.dataEncerramento <= urr2.dataVigenciaFinal"
						+ " 	AND urr2.dataVigenciaFinal is not null "
						+ "  	AND ospv.pavimentoRuaRetorno is not null"
						+ " 	) "
						+ " OR ( "
						+ " 	os.dataEncerramento >= urr2.dataVigenciaInicial "
						+ " 	AND urr2.dataVigenciaFinal is null "
						+ " 	AND ospv.pavimentoRuaRetorno is not null "
						+ " 	) "
						+ " ) ";	
			}else{
				
				consulta +=
					  " SELECT ospv.id "
					+ " FROM OrdemServicoPavimento ospv, UnidadeRepavimentadoraCustoPavimentoCalcada urr1, UnidadeRepavimentadoraCustoPavimentoCalcada urr2 "
					+ " INNER JOIN ospv.ordemServico os" 
					+ " WHERE ospv.unidadeRepavimentadora.id = :repavimentadora " 
					+ " AND ((urr1.pavimentoCalcada.id = ospv.pavimentoCalcada.id and ospv.pavimentoCalcadaRetorno is null and urr1.pavimentoCalcada.id = :pavimento and urr1.unidadeRepavimentadora.id = :repavimentadora) " 
					+ " OR (urr2.pavimentoCalcada.id = ospv.pavimentoCalcadaRetorno.id and ospv.pavimentoCalcadaRetorno is not null and urr2.pavimentoCalcada.id = :pavimento and urr2.unidadeRepavimentadora.id = :repavimentadora)) "
					+ " AND ( "
					+ " 	( "
					+ " 	os.dataEncerramento >= urr1.dataVigenciaInicial "
					+ " 	AND	os.dataEncerramento <= urr1.dataVigenciaFinal "
					+ " 	AND urr1.dataVigenciaFinal is not null "
					+ " 	AND ospv.pavimentoCalcadaRetorno is null "
					+ " 	) "
					+ " OR ( "
					+ "  	os.dataEncerramento >= urr1.dataVigenciaInicial"
					+ "  	AND urr1.dataVigenciaFinal is null"
					+ "  	AND ospv.pavimentoCalcadaRetorno is null"
					+ "  	)"
					+ " OR ( "
					+ "  	os.dataEncerramento >= urr2.dataVigenciaInicial"
					+ "  	AND	os.dataEncerramento <= urr2.dataVigenciaFinal"
					+ " 	AND urr2.dataVigenciaFinal is not null "
					+ "  	AND ospv.pavimentoCalcadaRetorno is not null"
					+ " 	) "
					+ " OR ( "
					+ " 	os.dataEncerramento >= urr2.dataVigenciaInicial "
					+ " 	AND urr2.dataVigenciaFinal is null "
					+ " 	AND ospv.pavimentoCalcadaRetorno is not null "
					+ " 	) "
					+ " ) ";
				
			}
			
			Integer idRetorno = (Integer) session.createQuery(consulta)
				.setInteger("repavimentadora", idRepavimentadora)
				.setInteger("pavimento", idPavimento)
				.setMaxResults(1).uniqueResult();
			
			if(idRetorno != null){
				retorno = true;
			}

			// Erro no hibernate
		} catch (HibernateException e) {
			// Levanta a exce��o para a pr�xima camada
			throw new ErroRepositorioException(e, "Erro no Hibernate");
		} finally {
			// Fecha a sess�o com o hibernate
			HibernateUtil.closeSession(session);
		}

		return retorno;
	}
	
	/**
	 * [UC1107] Manter Custo de Pavimento por Repavimentadora
 	 * 
 	 * @author Hugo Leonardo
 	 * @date 28/12/2010
 	 * 
 	 * @param id, idRepavimentadora, idPavimento, dataInicio, dataFinal, indicadorPavimento: 1-Rua, 2-Cal�ada
 	 * @return Integer
 	 * 
 	 * @see Caso retorne resultado: return 0.
 	 * 
 	 * @see Caso o indicadorPavimento = 1 e dataFinal = null: return 1.
	 * @see Caso o indicadorPavimento = 1 e dataFinal != null: return 2.
	 * 
	 * @see Caso o indicadorPavimento = 2 e dataFinal = null: return 3.
	 * @see Caso o indicadorPavimento = 2 e dataFinal != null: return 4.
	 */
	public Integer verificaAtualizarCustoPavimentoPorRepavimentadora(Integer idAtualizacao, 
			Integer idRepavimentadora, Integer idPavimento, Date dataInicio, 
			Date dataFinal, Integer indicadorPavimento, Integer tipo)
		throws ErroRepositorioException{
		
		// Cria uma sess�o com o hibernate
		Session session = HibernateUtil.getSession();

		// Retorno Consulta
		Integer retorno = 0;
		Integer idRetorno = null;

		// Cria a vari�vel que vai conter o hql
		String consulta = "";

		try {
				
			if(indicadorPavimento == 1){
				consulta +=
						  " select urr1.id "
						+ " from UnidadeRepavimentadoraCustoPavimentoRua urr1 "
						+ " where urr1.unidadeRepavimentadora.id = :repavimentadora "
						+ " and urr1.pavimentoRua.id = :pavimento "
						+ " and urr1.id <> :idAtu and ( ";
						
				if(tipo == 1){
					
					consulta += " urr1.dataVigenciaFinal is null and "
							 + "  coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) >= :dtInicio and "
							 + "  urr1.dataVigenciaInicial <= :dtFinal and ";
							
					consulta = Util.removerUltimosCaracteres(consulta, 4) + ")";
				}else{
						
					consulta += 
							  " urr1.dataVigenciaFinal is not null and "
							+ " 	coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) >= :dtInicio and "
							+ " 	urr1.dataVigenciaInicial <= :dtFinal "
							+ " or ( urr1.dataVigenciaFinal is null " 
							+ "      or coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) >= :dtInicio ) "
							+ " and urr1.dataVigenciaInicial <= :dtFinal) ";
				}

			}else{
				
				consulta +=
					  " select urr1.id "
					+ " from UnidadeRepavimentadoraCustoPavimentoCalcada urr1 "
					+ " where urr1.unidadeRepavimentadora.id = :repavimentadora "
					+ " and urr1.pavimentoCalcada.id = :pavimento "
					+ " and urr1.id <> :idAtu and ( ";
				
				if(tipo == 1 ){
					
					consulta += " urr1.dataVigenciaFinal is null and "
							 +  " coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) >= :dtInicio and "
							 +  " urr1.dataVigenciaInicial <= :dtFinal and ";
							 
					consulta = Util.removerUltimosCaracteres(consulta, 4) + ")";
					
				}else{
					consulta += 
							  " urr1.dataVigenciaFinal is not null and "
							+ " 	coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) >= :dtInicio and "
							+ "     urr1.dataVigenciaInicial <= :dtFinal "
							+ " or ( urr1.dataVigenciaFinal is null "
							+ "      or coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) >= :dtInicio ) "
							+ " and	urr1.dataVigenciaInicial <= :dtFinal) ";
				}
				
			}
			
			if(indicadorPavimento == 1){
				if(tipo == 1 ){
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", dataInicio)
						.setDate("dtFinal", dataFinal)
						.setMaxResults(1).uniqueResult();
				
					if(idRetorno != null){
						retorno = 1;
					}
				}else{
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", dataInicio)
						.setDate("dtFinal", dataFinal)
						.setMaxResults(1).uniqueResult();
					
					if(idRetorno != null){
						retorno = 2;
					}
				}
			}else{
				if(tipo == 1){
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", dataInicio)
						.setDate("dtFinal", dataFinal)
						.setMaxResults(1).uniqueResult();
			
					if(idRetorno != null){
						retorno = 3;
					}
				}else{
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", dataInicio)
						.setDate("dtFinal", dataFinal)
						.setMaxResults(1).uniqueResult();
					
					if(idRetorno != null){
						retorno = 4;
					}
				}
			}

			// Erro no hibernate
		} catch (HibernateException e) {
			// Levanta a exce��o para a pr�xima camada
			throw new ErroRepositorioException(e, "Erro no Hibernate");
		} finally {
			// Fecha a sess�o com o hibernate
			HibernateUtil.closeSession(session);
		}

		return retorno;
	}
	
	/**
	 * [UC1107] Manter Custo de Pavimento por Repavimentadora
 	 * 
 	 * 		[FS0010] Verificar se existem dias sem valor
 	 * 
 	 * @author Hugo Leonardo
 	 * @date 11/01/2011
 	 * 
 	 * @param id, idRepavimentadora, idPavimento, dataInicio, dataFinal, indicadorPavimento: 1-Rua, 2-Cal�ada
 	 * @return Integer
	 * 
	 * VerificarExistenciDiasSemValor
	 */
	public Integer verificarExistenciDiasSemValorCustoPavimentoPorRepavimentadora(Integer idAtualizacao, 
			Integer idRepavimentadora, Integer idPavimento, Date dataInicio, 
			Date dataFinal, Integer indicadorPavimento, Integer tipo) throws ErroRepositorioException{
		
		// Cria uma sess�o com o hibernate
		Session session = HibernateUtil.getSession();

		// Retorno Consulta
		Integer retorno = 0;
		Integer idRetorno = null;

		// Cria a vari�vel que vai conter o hql
		String consulta = "";

		try {
				
			if(indicadorPavimento == 1){
				
				if(tipo == 1 ){
					
					consulta +=" select urr1.id "
							 + " from UnidadeRepavimentadoraCustoPavimentoRua urr1 "
							 + " where urr1.unidadeRepavimentadora.id = :repavimentadora "
							 + " and urr1.pavimentoRua.id = :pavimento "
							 + " and urr1.id <> :idAtu "
							 + " and ( " 
							 + " 	urr1.id =( "
							 + " 			select r.id "
							 + " 			from UnidadeRepavimentadoraCustoPavimentoRua r "
							 + " 			where r.unidadeRepavimentadora.id = :repavimentadora "
							 + " 			and r.pavimentoRua.id = :pavimento "
							 + " 			and r.id <> :idAtu "
							 + " 			and r.dataVigenciaFinal = ( "
							 + " 						select max(r2.dataVigenciaFinal) "
							 + " 						from UnidadeRepavimentadoraCustoPavimentoRua r2 "
							 + " 						where r2.unidadeRepavimentadora.id = :repavimentadora "
							 + " 						and r2.pavimentoRua.id = :pavimento " 
							 + " 						and r2.id <> :idAtu "
							 + " 						and coalesce(r2.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) = :dtInicio "
							 + " 			) "
							 + " 	) " 
							 + " ) "
							 + " and coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) = :dtInicio ";
					
				}else if(tipo == 2 ){
					
					consulta +=" select urr1.id "
							 + " from UnidadeRepavimentadoraCustoPavimentoRua urr1 "
							 + " where urr1.unidadeRepavimentadora.id = :repavimentadora "
							 + " and urr1.pavimentoRua.id = :pavimento "
							 + " and urr1.id <> :idAtu "
							 + " and ( " 
							 + " 	urr1.id = ( "
							 + " 			select r3.id "
							 + " 			from UnidadeRepavimentadoraCustoPavimentoRua r3 "
							 + " 			where r3.unidadeRepavimentadora.id = :repavimentadora "
							 + " 			and r3.pavimentoRua.id = :pavimento "
							 + " 			and r3.id <> :idAtu "
							 + " 			and r3.dataVigenciaInicial = ( "
							 + " 						select max(r4.dataVigenciaInicial) "
							 + " 						from UnidadeRepavimentadoraCustoPavimentoRua r4 "
							 + " 						where r4.unidadeRepavimentadora.id = :repavimentadora "
							 + " 						and r4.pavimentoRua.id = :pavimento " 
							 + " 						and r4.id <> :idAtu "
							 + " 						and coalesce(r4.dataVigenciaInicial, to_date('9999-12-31','YYYY/MM/DD')) = :dtFinal "
							 + " 			) "
							 + " 	) " 
							 + "    and urr1.dataVigenciaInicial = :dtFinal "
							 + " ) ";
					
				}else{
					
					consulta +=" select urr1.id "
							 + " from UnidadeRepavimentadoraCustoPavimentoRua urr1 "
							 + " where urr1.unidadeRepavimentadora.id = :repavimentadora "
							 + " and urr1.pavimentoRua.id = :pavimento "
							 + " and urr1.id <> :idAtu "
							 + " and urr1.dataVigenciaInicial > :dtInicio ";
				}
				
			}else{
				
				if(tipo == 1 ){
					
					consulta +=" select urr1.id "
							 + " from UnidadeRepavimentadoraCustoPavimentoCalcada urr1 "
							 + " where urr1.unidadeRepavimentadora.id = :repavimentadora "
							 + " and urr1.pavimentoCalcada.id = :pavimento "
							 + " and urr1.id <> :idAtu "
							 + " and ( " 
							 + " 	urr1.id = ( "
							 + " 			select r.id "
							 + " 			from UnidadeRepavimentadoraCustoPavimentoCalcada r "
							 + " 			where r.unidadeRepavimentadora.id = :repavimentadora "
							 + " 			and r.pavimentoCalcada.id = :pavimento "
							 + " 			and r.id <> :idAtu "
							 + " 			and r.dataVigenciaFinal = ( "
							 + " 						select max(r2.dataVigenciaFinal) "
							 + " 						from UnidadeRepavimentadoraCustoPavimentoCalcada r2 "
							 + " 						where r2.unidadeRepavimentadora.id = :repavimentadora "
							 + " 						and r2.pavimentoCalcada.id = :pavimento " 
							 + " 						and r2.id <> :idAtu "
							 + " 						and coalesce(r2.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) = :dtInicio "
							 + " 			) "
							 + " 	) "
							 + " ) "
							 + " and coalesce(urr1.dataVigenciaFinal, to_date('9999-12-31','YYYY/MM/DD')) = :dtInicio ";
					
				}else if(tipo == 2 ){
					
					consulta +=" select urr1.id "
							 + " from UnidadeRepavimentadoraCustoPavimentoCalcada urr1 "
							 + " where urr1.unidadeRepavimentadora.id = :repavimentadora "
							 + " and urr1.pavimentoCalcada.id = :pavimento "
							 + " and urr1.id <> :idAtu "
							 + " and ( " 
							 + " 	urr1.id = ( "
							 + " 			select r.id "
							 + " 			from UnidadeRepavimentadoraCustoPavimentoCalcada r "
							 + " 			where r.unidadeRepavimentadora.id = :repavimentadora "
							 + " 			and r.pavimentoCalcada.id = :pavimento "
							 + " 			and r.id <> :idAtu "
							 + " 			and r.dataVigenciaInicial = ( "
							 + " 						select max(r2.dataVigenciaInicial) "
							 + " 						from UnidadeRepavimentadoraCustoPavimentoCalcada r2 "
							 + " 						where r2.unidadeRepavimentadora.id = :repavimentadora "
							 + " 						and r2.pavimentoCalcada.id = :pavimento " 
							 + " 						and r2.id <> :idAtu "
							 + " 						and coalesce(r2.dataVigenciaInicial, to_date('9999-12-31','YYYY/MM/DD')) = :dtFinal "
							 + " 			) "
							 + " 	) "
							 + " 	and urr1.dataVigenciaInicial = :dtFinal "
							 + " ) ";
					
				}else{
					
					consulta +=" select urr1.id "
							 + " from UnidadeRepavimentadoraCustoPavimentoCalcada urr1 "
							 + " where urr1.unidadeRepavimentadora.id = :repavimentadora "
							 + " and urr1.pavimentoCalcada.id = :pavimento "
							 + " and urr1.id <> :idAtu "
							 + " and urr1.dataVigenciaInicial > :dtInicio ";
					
				}
			}
			
			if(indicadorPavimento == 1){
				
				if(tipo == 1 ){
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", dataInicio)
						.setMaxResults(1).uniqueResult();
				
					if(idRetorno == null){
						retorno = 1;
					}else{
						retorno = 0;
					}
				}else if(tipo == 2 ){
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtFinal", dataFinal)
						.setMaxResults(1).uniqueResult();
					
					if(idRetorno == null){
						retorno = 2;
					}else{
						retorno = 0;
					}
				}else{
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", Util.adicionarNumeroDiasDeUmaData(dataInicio, 0))
						.setMaxResults(1).uniqueResult();
				
					if(idRetorno == null){
						retorno = 0;
					}else{
						retorno = 3;
					}
				}
				
			}else{
				
				if(tipo == 1 ){
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", dataInicio)
						.setMaxResults(1).uniqueResult();
			
					if(idRetorno == null){
						retorno = 4;
					}else{
						retorno = 0;
					}
				}else if(tipo == 2 ){
					
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtFinal", dataFinal)
						.setMaxResults(1).uniqueResult();
					
					if(idRetorno != null){
						retorno = 5;
					}else{
						retorno = 0;
					}
				}else{
					idRetorno = (Integer) session.createQuery(consulta)
						.setInteger("idAtu", idAtualizacao)
						.setInteger("repavimentadora", idRepavimentadora)
						.setInteger("pavimento", idPavimento)
						.setDate("dtInicio", Util.adicionarNumeroDiasDeUmaData(dataInicio, -1))
						.setMaxResults(1).uniqueResult();
				
					if(idRetorno == null){
						retorno = 0;
					}else{
						retorno = 6;
					}
				}
			}

			// Erro no hibernate
		} catch (HibernateException e) {
			// Levanta a exce��o para a pr�xima camada
			throw new ErroRepositorioException(e, "Erro no Hibernate");
		} finally {
			// Fecha a sess�o com o hibernate
			HibernateUtil.closeSession(session);
		}

		return retorno;
	}
