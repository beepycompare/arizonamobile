package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Sf implements so {
    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new qo(this, false, "Invalid quantity value " + num);
        }
        return new qo(this, true, "");
    }
}
