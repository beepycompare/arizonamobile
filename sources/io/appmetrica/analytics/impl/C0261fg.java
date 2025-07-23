package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0261fg implements po {
    @Override // io.appmetrica.analytics.impl.po
    public final no a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new no(this, false, "Invalid quantity value " + num);
        }
        return new no(this, true, "");
    }
}
