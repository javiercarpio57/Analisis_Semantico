// Generated from Decaf.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DecafParser}.
 */
public interface DecafListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DecafParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DecafParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DecafParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(DecafParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(DecafParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#vardeclr}.
	 * @param ctx the parse tree
	 */
	void enterVardeclr(DecafParser.VardeclrContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#vardeclr}.
	 * @param ctx the parse tree
	 */
	void exitVardeclr(DecafParser.VardeclrContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#vardeclrs}.
	 * @param ctx the parse tree
	 */
	void enterVardeclrs(DecafParser.VardeclrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#vardeclrs}.
	 * @param ctx the parse tree
	 */
	void exitVardeclrs(DecafParser.VardeclrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#field_declr}.
	 * @param ctx the parse tree
	 */
	void enterField_declr(DecafParser.Field_declrContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#field_declr}.
	 * @param ctx the parse tree
	 */
	void exitField_declr(DecafParser.Field_declrContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#array_id}.
	 * @param ctx the parse tree
	 */
	void enterArray_id(DecafParser.Array_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#array_id}.
	 * @param ctx the parse tree
	 */
	void exitArray_id(DecafParser.Array_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#field_var}.
	 * @param ctx the parse tree
	 */
	void enterField_var(DecafParser.Field_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#field_var}.
	 * @param ctx the parse tree
	 */
	void exitField_var(DecafParser.Field_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#var_id}.
	 * @param ctx the parse tree
	 */
	void enterVar_id(DecafParser.Var_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#var_id}.
	 * @param ctx the parse tree
	 */
	void exitVar_id(DecafParser.Var_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#struct_declr}.
	 * @param ctx the parse tree
	 */
	void enterStruct_declr(DecafParser.Struct_declrContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#struct_declr}.
	 * @param ctx the parse tree
	 */
	void exitStruct_declr(DecafParser.Struct_declrContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#method_declr}.
	 * @param ctx the parse tree
	 */
	void enterMethod_declr(DecafParser.Method_declrContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_declr}.
	 * @param ctx the parse tree
	 */
	void exitMethod_declr(DecafParser.Method_declrContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(DecafParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(DecafParser.Return_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DecafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DecafParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_location}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_location(DecafParser.Statement_locationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_location}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_location(DecafParser.Statement_locationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_methodcall}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_methodcall(DecafParser.Statement_methodcallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_methodcall}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_methodcall(DecafParser.Statement_methodcallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_if}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_if(DecafParser.Statement_ifContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_if}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_if(DecafParser.Statement_ifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_while}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_while(DecafParser.Statement_whileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_while}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_while(DecafParser.Statement_whileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_equal}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_equal(DecafParser.Statement_equalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_equal}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_equal(DecafParser.Statement_equalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_return}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_return(DecafParser.Statement_returnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_return}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_return(DecafParser.Statement_returnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_for}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_for(DecafParser.Statement_forContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_for}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_for(DecafParser.Statement_forContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statement_break}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement_break(DecafParser.Statement_breakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statement_break}
	 * labeled alternative in {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement_break(DecafParser.Statement_breakContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call(DecafParser.Method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_call}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call(DecafParser.Method_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DecafParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DecafParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void enterLocation(DecafParser.LocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#location}.
	 * @param ctx the parse tree
	 */
	void exitLocation(DecafParser.LocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(DecafParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(DecafParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(DecafParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(DecafParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(DecafParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(DecafParser.Bool_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRel_op(DecafParser.Rel_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRel_op(DecafParser.Rel_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEq_op(DecafParser.Eq_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEq_op(DecafParser.Eq_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void enterCond_op(DecafParser.Cond_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#cond_op}.
	 * @param ctx the parse tree
	 */
	void exitCond_op(DecafParser.Cond_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void enterArith_op(DecafParser.Arith_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#arith_op}.
	 * @param ctx the parse tree
	 */
	void exitArith_op(DecafParser.Arith_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(DecafParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(DecafParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void enterAssign_op(DecafParser.Assign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void exitAssign_op(DecafParser.Assign_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 */
	void enterMethod_name(DecafParser.Method_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method_name}.
	 * @param ctx the parse tree
	 */
	void exitMethod_name(DecafParser.Method_nameContext ctx);
}