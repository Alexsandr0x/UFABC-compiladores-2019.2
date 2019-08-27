import java.util.HashMap;
import java.util.Map;


public class Scope {

    private Scope instance;
    private Map<String, GRValue> variables;

    Scope() {
        this(null);
    }

    Scope(Scope p) {
        instance = p;
        variables = new HashMap<>();
    }

    public void assignParam(String var, GRValue value) {
        variables.put(var, value);
    }

    public void assign(String var, GRValue value) {
        if(resolve(var) != null) {
            // There is already such a variable, re-assign it
            this.reAssign(var, value);
        }
        else {
            // A newly declared variable
            variables.put(var, value);
        }
    }

    private void reAssign(String identifier, GRValue value) {
        if(variables.containsKey(identifier)) {
            // The variable is declared in this scope
            variables.put(identifier, value);
        }
        else if(instance != null) {
            // The variable was not declared in this scope, so let
            // the parent scope re-assign it
            instance.reAssign(identifier, value);
        }
    }

    public GRValue resolve(String var) {
        GRValue value = variables.get(var);
        if(value != null) {
            // The variable resides in this scope
            return value;
        }
        else if(!isGlobalScope()) {
            // Let the parent scope look for the variable
            return instance.resolve(var);
        }
        else {
            // Unknown variable
            return null;
        }
    }

    private boolean isGlobalScope() {
        return instance == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,GRValue> var: variables.entrySet()) {
            sb.append(var.getKey()).append("->").append(var.getValue()).append(",");
        }
        return sb.toString();
    }

    public Scope scope() {
        return instance;
    }


}
