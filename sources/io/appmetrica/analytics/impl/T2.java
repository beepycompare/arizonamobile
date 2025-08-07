package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class T2 implements po {
    @Override // io.appmetrica.analytics.impl.po
    public final no a(Object obj) {
        C0193co[] c0193coArr = ((C0270fo) obj).f853a;
        if (c0193coArr != null && c0193coArr.length != 0) {
            return new no(this, true, "");
        }
        return new no(this, false, "attributes list is empty");
    }
}
