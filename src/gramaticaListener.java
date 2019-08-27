// Generated from gramatica.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramaticaParser}.
 */
public interface gramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(gramaticaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(gramaticaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(gramaticaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(gramaticaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(gramaticaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(gramaticaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#attribution}.
	 * @param ctx the parse tree
	 */
	void enterAttribution(gramaticaParser.AttributionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#attribution}.
	 * @param ctx the parse tree
	 */
	void exitAttribution(gramaticaParser.AttributionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(gramaticaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(gramaticaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#if_exp}.
	 * @param ctx the parse tree
	 */
	void enterIf_exp(gramaticaParser.If_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#if_exp}.
	 * @param ctx the parse tree
	 */
	void exitIf_exp(gramaticaParser.If_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(gramaticaParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(gramaticaParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void enterStatement_block(gramaticaParser.Statement_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void exitStatement_block(gramaticaParser.Statement_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#while_exp}.
	 * @param ctx the parse tree
	 */
	void enterWhile_exp(gramaticaParser.While_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#while_exp}.
	 * @param ctx the parse tree
	 */
	void exitWhile_exp(gramaticaParser.While_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(gramaticaParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(gramaticaParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(gramaticaParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(gramaticaParser.ValueContext ctx);
}