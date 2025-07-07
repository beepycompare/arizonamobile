package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
/* loaded from: classes4.dex */
public final class JsonPrimitive extends JsonElement {
    private final Object value;

    @Override // com.google.gson.JsonElement
    public JsonPrimitive deepCopy() {
        return this;
    }

    public JsonPrimitive(Boolean bool) {
        this.value = Objects.requireNonNull(bool);
    }

    public JsonPrimitive(Number number) {
        this.value = Objects.requireNonNull(number);
    }

    public JsonPrimitive(String str) {
        this.value = Objects.requireNonNull(str);
    }

    public JsonPrimitive(Character ch) {
        this.value = ((Character) Objects.requireNonNull(ch)).toString();
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((Boolean) this.value).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object obj = this.value;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) this.value);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        Object obj = this.value;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((Boolean) this.value).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object obj = this.value;
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        return NumberLimits.parseBigDecimal(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object obj = this.value;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if (isIntegral(this)) {
            return BigInteger.valueOf(getAsNumber().longValue());
        }
        return NumberLimits.parseBigInteger(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // com.google.gson.JsonElement
    @Deprecated
    public char getAsCharacter() {
        String asString = getAsString();
        if (asString.isEmpty()) {
            throw new UnsupportedOperationException("String value is empty");
        }
        return asString.charAt(0);
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.value;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.value == null) {
            return jsonPrimitive.value == null;
        } else if (isIntegral(this) && isIntegral(jsonPrimitive)) {
            if ((this.value instanceof BigInteger) || (jsonPrimitive.value instanceof BigInteger)) {
                return getAsBigInteger().equals(jsonPrimitive.getAsBigInteger());
            }
            return getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue();
        } else {
            Object obj2 = this.value;
            if (obj2 instanceof Number) {
                Object obj3 = jsonPrimitive.value;
                if (obj3 instanceof Number) {
                    if ((obj2 instanceof BigDecimal) && (obj3 instanceof BigDecimal)) {
                        return getAsBigDecimal().compareTo(jsonPrimitive.getAsBigDecimal()) == 0;
                    }
                    double asDouble = getAsDouble();
                    double asDouble2 = jsonPrimitive.getAsDouble();
                    return asDouble == asDouble2 || (Double.isNaN(asDouble) && Double.isNaN(asDouble2));
                }
            }
            return obj2.equals(jsonPrimitive.value);
        }
    }

    private static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.value;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
