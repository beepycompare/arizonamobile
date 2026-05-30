package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Sh extends Ah {
    public Sh(W6 w6) {
        super(w6);
    }

    @Override // io.appmetrica.analytics.impl.Ah, io.appmetrica.analytics.impl.Bh
    public final boolean a(Boolean bool) {
        return !this.f460a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
