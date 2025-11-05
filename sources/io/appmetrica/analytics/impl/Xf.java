package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Xf implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new so(this, false, "Invalid quantity value " + num);
        }
        return new so(this, true, "");
    }
}
