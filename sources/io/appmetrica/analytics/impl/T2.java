package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class T2 implements mo {
    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Object obj) {
        Zn[] znArr = ((C0200co) obj).f790a;
        if (znArr != null && znArr.length != 0) {
            return new ko(this, true, "");
        }
        return new ko(this, false, "attributes list is empty");
    }
}
