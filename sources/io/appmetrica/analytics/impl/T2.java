package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class T2 implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Object obj) {
        C0314ho[] c0314hoArr = ((C0391ko) obj).f944a;
        if (c0314hoArr != null && c0314hoArr.length != 0) {
            return new so(this, true, "");
        }
        return new so(this, false, "attributes list is empty");
    }
}
