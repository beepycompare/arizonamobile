package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.dg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0210dg implements mo {
    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new ko(this, false, "Invalid quantity value " + num);
        }
        return new ko(this, true, "");
    }
}
