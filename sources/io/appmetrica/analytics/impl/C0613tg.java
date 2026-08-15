package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.tg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0613tg implements Vo {
    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new To(this, false, "Invalid quantity value " + num);
        }
        return new To(this, true, "");
    }
}
