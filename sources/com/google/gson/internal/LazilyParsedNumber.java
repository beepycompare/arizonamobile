package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
/* loaded from: classes4.dex */
public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    private BigDecimal asBigDecimal() {
        return NumberLimits.parseBigDecimal(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.value);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.value);
            }
        } catch (NumberFormatException unused2) {
            return asBigDecimal().intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException unused) {
            return asBigDecimal().longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    public String toString() {
        return this.value;
    }

    private Object writeReplace() throws ObjectStreamException {
        return asBigDecimal();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazilyParsedNumber) {
            return this.value.equals(((LazilyParsedNumber) obj).value);
        }
        return false;
    }
}
