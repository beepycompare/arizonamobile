package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.rk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0566rk extends Ah {
    public C0566rk(W6 w6) {
        super(w6);
    }

    @Override // io.appmetrica.analytics.impl.Ah, io.appmetrica.analytics.impl.Bh
    public final boolean a(Boolean bool) {
        return !this.f462a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
