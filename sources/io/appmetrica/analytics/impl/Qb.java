package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Qb implements yo {
    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(String str) {
        if (str == null) {
            return new wo(this, false, "key is null");
        }
        if (str.startsWith("appmetrica")) {
            return new wo(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new wo(this, false, "key length more then 200 characters");
        }
        return new wo(this, true, "");
    }
}
