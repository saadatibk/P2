import java.util.Set;
import java.util.Stack;
import ast.*;

public class SemanticAnalizer {
   private final Stack<Set<String>> scopes = new Stack<>();

    void visit(ASTNode node){
        if (node instanceof BinaryOpNode){
            visit(((BinaryOpNode)node).left);
            visit(((BinaryOpNode)node).right);
        } else if (node instanceof NumberNode){
    
        } else if (node instanceof VarDecl){
 
        } else if (node instanceof Var){
            String varName = ((Var)node).name;
            if (!isVariableDefined(varName)) {
                throw new ParserException("Unexpected identifier: "+ varName);
            }
        } else if (node instanceof AssignNode){

        } else if (node instanceof BlockNode){

        } else {
            throw new ParserException("Unexpected AST Node:" + node.getClass().getCanonicalName());
        }
    }
    
    private boolean isVariableDefined(String varName){
        for(Set<String> scope: scopes){
            if(scope.contains(varName )) return true;
        }
    }
    



}
