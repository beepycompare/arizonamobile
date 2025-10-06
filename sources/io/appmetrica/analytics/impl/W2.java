package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W2 implements yo {
    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Object obj) {
        C0418lo[] c0418loArr = ((C0496oo) obj).f1027a;
        if (c0418loArr != null && c0418loArr.length != 0) {
            return new wo(this, true, "");
        }
        return new wo(this, false, "attributes list is empty");
    }
}
