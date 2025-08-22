package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0383kg implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new so(this, false, "Invalid quantity value " + num);
        }
        return new so(this, true, "");
    }
}
