package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Sb implements Vo {
    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(String str) {
        if (str == null) {
            return new To(this, false, "key is null");
        }
        if (str.startsWith(Y7.b)) {
            return new To(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new To(this, false, "key length more then 200 characters");
        }
        return new To(this, true, "");
    }
}
