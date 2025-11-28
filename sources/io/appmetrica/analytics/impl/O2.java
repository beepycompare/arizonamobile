package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class O2 implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Object obj) {
        C0307ho[] c0307hoArr = ((C0384ko) obj).f979a;
        if (c0307hoArr != null && c0307hoArr.length != 0) {
            return new so(this, true, "");
        }
        return new so(this, false, "attributes list is empty");
    }
}
