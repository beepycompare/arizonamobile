package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class G2 implements so {
    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Object obj) {
        C0258fo[] c0258foArr = ((C0335io) obj).f1056a;
        if (c0258foArr != null && c0258foArr.length != 0) {
            return new qo(this, true, "");
        }
        return new qo(this, false, "attributes list is empty");
    }
}
