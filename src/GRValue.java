import java.util.List;

public class GRValue implements Comparable<GRValue> {
    public static final GRValue NULL = new GRValue();
    public static final GRValue VOID = new GRValue();

    private Object value;
    private String type = "String";

    private GRValue() {
        // private constructor: only used for NULL and VOID
        value = new Object();
    }

    public String getType() {
        return type;
    }

    GRValue(Object v, String type) {
        this.type = type;
        if(v == null) {
            throw new RuntimeException("v == null");
        }
        value = v;
        // only accept boolean, list, number or string types
        if(!(isBoolean() || isList() || isNumber() || isString())) {
            throw new RuntimeException("invalid data type: " + v + " (" + v.getClass() + ")");
        }
    }

    GRValue(Object v) {
        if(v == null) {
            throw new RuntimeException("v == null");
        }
        value = v;
        // only accept boolean, list, number or string types
        if(!(isBoolean() || isList() || isNumber() || isString())) {
            throw new RuntimeException("invalid data type: " + v + " (" + v.getClass() + ")");
        }
    }

    public Double asDouble() {
        return ((Number)value).doubleValue();
    }

    public String asString() {
        return (String)value;
    }

    @Override
    public int compareTo(GRValue that) {
        if(this.isNumber() && that.isNumber()) {
            if(this.equals(that)) {
                return 0;
            }
            else {
                return this.asDouble().compareTo(that.asDouble());
            }
        }
        else if(this.isString() && that.isString()) {
            return this.asString().compareTo(that.asString());
        }
        else {
            throw new RuntimeException("illegal expression: can't compare `" + this + "` to `" + that + "`");
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    public boolean isNumber() {
        return value instanceof Number;
    }

    public boolean isList() {
        return value instanceof List<?>;
    }

    public boolean isNull() {
        return this == NULL;
    }

    public boolean isVoid() {
        return this == VOID;
    }

    public boolean isString() {
        return value instanceof String;
    }

    @Override
    public String toString() {
        if (type.equals("float")) {
            return value + "f";
        }


        return isNull() ? "NULL" : isVoid() ? "VOID" : String.valueOf(value);
    }
}
