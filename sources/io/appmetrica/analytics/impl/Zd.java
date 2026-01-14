package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class Zd implements so {

    /* renamed from: a  reason: collision with root package name */
    public final String f887a;

    public Zd(String str) {
        this.f887a = str;
    }

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new qo(this, false, this.f887a + " is empty.");
        }
        return new qo(this, true, "");
    }
}
