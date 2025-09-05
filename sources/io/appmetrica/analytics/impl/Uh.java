package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Uh extends Ch {
    public Uh(C0194d7 c0194d7) {
        super(c0194d7);
    }

    @Override // io.appmetrica.analytics.impl.Ch, io.appmetrica.analytics.impl.Dh
    public final boolean a(Boolean bool) {
        return !this.f387a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
