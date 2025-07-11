package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.me  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0432me implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final String f939a;

    public C0432me(String str) {
        this.f939a = str;
    }

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ko(this, false, this.f939a + " is empty.");
        }
        return new ko(this, true, "");
    }
}
