package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class H2 implements to {
    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Object obj) {
        C0280go[] c0280goArr = ((C0357jo) obj).f1061a;
        if (c0280goArr != null && c0280goArr.length != 0) {
            return new ro(this, true, "");
        }
        return new ro(this, false, "attributes list is empty");
    }
}
