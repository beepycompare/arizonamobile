package io.appmetrica.analytics.impl;

import android.text.TextUtils;
/* renamed from: io.appmetrica.analytics.impl.ue  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0635ue implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final String f1111a;

    public C0635ue(String str) {
        this.f1111a = str;
    }

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new wo(this, false, this.f1111a + " is empty.");
        }
        return new wo(this, true, "");
    }
}
