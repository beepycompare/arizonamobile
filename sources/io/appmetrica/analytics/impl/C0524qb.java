package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0524qb implements so {
    @Override // io.appmetrica.analytics.impl.so
    public final qo a(String str) {
        if (str == null) {
            return new qo(this, false, "key is null");
        }
        if (str.startsWith(G7.b)) {
            return new qo(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new qo(this, false, "key length more then 200 characters");
        }
        return new qo(this, true, "");
    }
}
