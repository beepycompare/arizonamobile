package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.ae  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0116ae implements to {

    /* renamed from: a  reason: collision with root package name */
    public final String f799a;

    public C0116ae(String str) {
        this.f799a = str;
    }

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ro(this, false, this.f799a + " is empty.");
        }
        return new ro(this, true, "");
    }
}
