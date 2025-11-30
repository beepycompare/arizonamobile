package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class H2 implements to {
    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Object obj) {
        C0281go[] c0281goArr = ((C0358jo) obj).f963a;
        if (c0281goArr != null && c0281goArr.length != 0) {
            return new ro(this, true, "");
        }
        return new ro(this, false, "attributes list is empty");
    }
}
