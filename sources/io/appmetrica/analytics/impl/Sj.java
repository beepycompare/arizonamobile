package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Sj extends AbstractC0300hh {
    public Sj(F6 f6) {
        super(f6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0300hh, io.appmetrica.analytics.impl.InterfaceC0325ih
    public final boolean a(Boolean bool) {
        return !this.f925a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
