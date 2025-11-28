package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0696xb implements uo {
    @Override // io.appmetrica.analytics.impl.uo
    public final so a(String str) {
        if (str == null) {
            return new so(this, false, "key is null");
        }
        if (str.startsWith("appmetrica")) {
            return new so(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new so(this, false, "key length more then 200 characters");
        }
        return new so(this, true, "");
    }
}
