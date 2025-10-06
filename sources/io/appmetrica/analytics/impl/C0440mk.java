package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.mk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0440mk extends Ch {
    public C0440mk(C0195d7 c0195d7) {
        super(c0195d7);
    }

    @Override // io.appmetrica.analytics.impl.Ch, io.appmetrica.analytics.impl.Dh
    public final boolean a(Boolean bool) {
        return !this.f392a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
