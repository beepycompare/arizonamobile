package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Jb implements mo {
    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(String str) {
        if (str == null) {
            return new ko(this, false, "key is null");
        }
        if (str.startsWith("appmetrica")) {
            return new ko(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new ko(this, false, "key length more then 200 characters");
        }
        return new ko(this, true, "");
    }
}
