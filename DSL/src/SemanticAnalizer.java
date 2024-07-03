import java.util.*;
import ast.*;

public class SemanticAnalizer {
   private final Stack<Set<String>> scopes = new Stack<>();

    void visit(ASTNode node){
        if (node instanceof BinaryOpNode){
            visit(((BinaryOpNode)node).left);
            visit(((BinaryOpNode)node).right);
        } else if (node instanceof NumberNode){
    
        } else if (node instanceof VarDecl varDeclNode){
           String varName = varDeclNode.varNode.name;
           if (!isVariableDefined(varName)) {
            throw new ParserException("Identifier already defined: "+ varName);
        }
        scopes.peek().add(varName);
        } else if (node instanceof Var){
            String varName = ((Var)node).name;
            if (!isVariableDefined(varName)) {
                throw new ParserException("Unexpected identifier: "+ varName);
            }
        } else if (node instanceof AssignNode assignNode){
            String varName = assignNode.left.name;
            if (!isVariableDefined(varName)) {
                throw new ParserException("Unexpected identifier: "+ varName);
            }
            visit(assignNode.right);
        } else if (node instanceof BlockNode block){
            scopes.push(new HashSet<>());
            for (ASTNode statement : block.statements) {
                visit(statement);
            }
            scopes.pop();


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
