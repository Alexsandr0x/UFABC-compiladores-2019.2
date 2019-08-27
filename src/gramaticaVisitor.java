// Generated from gramatica.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(gramaticaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(gramaticaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(gramaticaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#attribution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribution(gramaticaParser.AttributionContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(gramaticaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#if_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_exp(gramaticaParser.If_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition_block(gramaticaParser.Condition_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#statement_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_block(gramaticaParser.Statement_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#while_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_exp(gramaticaParser.While_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(gramaticaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(gramaticaParser.ValueContext ctx);
}