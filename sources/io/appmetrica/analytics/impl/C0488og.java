package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.og  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0488og implements yo {
    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new wo(this, false, "Invalid quantity value " + num);
        }
        return new wo(this, true, "");
    }
}
