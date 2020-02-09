// Generated from C:/Users/TRIUMPHAL/IdeaProjects/PROJET_COMPIL_WS\Expr_arithm.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Expr_arithmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Expr_arithmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(Expr_arithmParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#import_bib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_bib(Expr_arithmParser.Import_bibContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#import_bib_lang}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_bib_lang(Expr_arithmParser.Import_bib_langContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#import_bib_io}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport_bib_io(Expr_arithmParser.Import_bib_ioContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#modificat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModificat(Expr_arithmParser.ModificatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(Expr_arithmParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#ens_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEns_var(Expr_arithmParser.Ens_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(Expr_arithmParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#inst_lecture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst_lecture(Expr_arithmParser.Inst_lectureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#suite_lecture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite_lecture(Expr_arithmParser.Suite_lectureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#quad_read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuad_read(Expr_arithmParser.Quad_readContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_signe_formatage_lecture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_signe_formatage_lecture(Expr_arithmParser.Rout_signe_formatage_lectureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#inst_ecriture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst_ecriture(Expr_arithmParser.Inst_ecritureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#suite_ecriture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite_ecriture(Expr_arithmParser.Suite_ecritureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#suite_ecriture_suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite_ecriture_suite(Expr_arithmParser.Suite_ecriture_suiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_signe_formatage_ecrit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_signe_formatage_ecrit(Expr_arithmParser.Rout_signe_formatage_ecritContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#quad_write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuad_write(Expr_arithmParser.Quad_writeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#debut_chaine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebut_chaine(Expr_arithmParser.Debut_chaineContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#inst_af}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst_af(Expr_arithmParser.Inst_afContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(Expr_arithmParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#exp_s_m}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_s_m(Expr_arithmParser.Exp_s_mContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#exp_d_m}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_d_m(Expr_arithmParser.Exp_d_mContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_som_sous}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_som_sous(Expr_arithmParser.Rout_som_sousContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#routine_div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoutine_div(Expr_arithmParser.Routine_divContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#exp_par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_par(Expr_arithmParser.Exp_parContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#m_d}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitM_d(Expr_arithmParser.M_dContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#chaine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChaine(Expr_arithmParser.ChaineContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#inst_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst_if(Expr_arithmParser.Inst_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_sinon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_sinon(Expr_arithmParser.Rout_sinonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_condition_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_condition_if(Expr_arithmParser.Rout_condition_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#inst_sinon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst_sinon(Expr_arithmParser.Inst_sinonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_if_br}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_if_br(Expr_arithmParser.Rout_if_brContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_fin_sinon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_fin_sinon(Expr_arithmParser.Rout_fin_sinonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#pas_sinon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPas_sinon(Expr_arithmParser.Pas_sinonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(Expr_arithmParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#condition_ou}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_ou(Expr_arithmParser.Condition_ouContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#condition_et}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_et(Expr_arithmParser.Condition_etContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#condition_neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_neg(Expr_arithmParser.Condition_negContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#condition_comparateur}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_comparateur(Expr_arithmParser.Condition_comparateurContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#condition_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_exp(Expr_arithmParser.Condition_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#ici}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIci(Expr_arithmParser.IciContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(Expr_arithmParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#non_neg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_neg(Expr_arithmParser.Non_negContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#ici_et}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIci_et(Expr_arithmParser.Ici_etContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#derier_comp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDerier_comp(Expr_arithmParser.Derier_compContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#non_cmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_cmp(Expr_arithmParser.Non_cmpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_cmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_cmp(Expr_arithmParser.Rout_cmpContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_ou}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_ou(Expr_arithmParser.Rout_ouContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_et}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_et(Expr_arithmParser.Rout_etContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_vrai_ou}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_vrai_ou(Expr_arithmParser.Rout_vrai_ouContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_faux_ou}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_faux_ou(Expr_arithmParser.Rout_faux_ouContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_vrai_et}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_vrai_et(Expr_arithmParser.Rout_vrai_etContext ctx);
	/**
	 * Visit a parse tree produced by {@link Expr_arithmParser#rout_faux_et}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRout_faux_et(Expr_arithmParser.Rout_faux_etContext ctx);
}