package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class T2 implements po {
    @Override // io.appmetrica.analytics.impl.po
    public final no a(Object obj) {
        C0192co[] c0192coArr = ((C0269fo) obj).f853a;
        if (c0192coArr != null && c0192coArr.length != 0) {
            return new no(this, true, "");
        }
        return new no(this, false, "attributes list is empty");
    }
}
