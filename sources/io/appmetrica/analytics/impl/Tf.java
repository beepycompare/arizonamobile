package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Tf implements to {
    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Object obj) {
        Integer num = (Integer) obj;
        if (num != null && num.intValue() <= 0) {
            return new ro(this, false, "Invalid quantity value " + num);
        }
        return new ro(this, true, "");
    }
}
