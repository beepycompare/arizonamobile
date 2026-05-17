package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Rj extends AbstractC0277gh {
    public Rj(E6 e6) {
        super(e6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gh, io.appmetrica.analytics.impl.InterfaceC0303hh
    public final boolean a(Boolean bool) {
        return !this.f1019a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
