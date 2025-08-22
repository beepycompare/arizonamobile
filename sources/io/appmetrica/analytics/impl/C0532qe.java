package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.qe  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0532qe implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1026a;

    public C0532qe(String str) {
        this.f1026a = str;
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new so(this, false, this.f1026a + " is empty.");
        }
        return new so(this, true, "");
    }
}
