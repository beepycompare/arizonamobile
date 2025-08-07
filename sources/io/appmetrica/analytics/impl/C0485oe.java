package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0485oe implements po {

    /* renamed from: a  reason: collision with root package name */
    public final String f986a;

    public C0485oe(String str) {
        this.f986a = str;
    }

    @Override // io.appmetrica.analytics.impl.po
    public final no a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new no(this, false, this.f986a + " is empty.");
        }
        return new no(this, true, "");
    }
}
