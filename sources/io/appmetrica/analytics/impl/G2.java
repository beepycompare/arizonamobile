package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class G2 implements so {
    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Object obj) {
        C0259fo[] c0259foArr = ((C0336io) obj).f1051a;
        if (c0259foArr != null && c0259foArr.length != 0) {
            return new qo(this, true, "");
        }
        return new qo(this, false, "attributes list is empty");
    }
}
