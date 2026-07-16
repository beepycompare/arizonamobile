package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class T2 implements Vo {
    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Object obj) {
        Io[] ioArr = ((Lo) obj).f655a;
        if (ioArr != null && ioArr.length != 0) {
            return new To(this, true, "");
        }
        return new To(this, false, "attributes list is empty");
    }
}
