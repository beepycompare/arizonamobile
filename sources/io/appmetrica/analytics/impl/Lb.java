package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Lb implements po {
    @Override // io.appmetrica.analytics.impl.po
    public final no a(String str) {
        if (str == null) {
            return new no(this, false, "key is null");
        }
        if (str.startsWith("appmetrica")) {
            return new no(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new no(this, false, "key length more then 200 characters");
        }
        return new no(this, true, "");
    }
}
