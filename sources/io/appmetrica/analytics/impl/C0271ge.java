package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.ge  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0271ge implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final String f895a;

    public C0271ge(String str) {
        this.f895a = str;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new so(this, false, this.f895a + " is empty.");
        }
        return new so(this, true, "");
    }
}
