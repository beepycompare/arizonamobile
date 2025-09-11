package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W2 implements yo {
    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Object obj) {
        C0417lo[] c0417loArr = ((C0495oo) obj).f1026a;
        if (c0417loArr != null && c0417loArr.length != 0) {
            return new wo(this, true, "");
        }
        return new wo(this, false, "attributes list is empty");
    }
}
