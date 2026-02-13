package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Rj extends AbstractC0278gh {
    public Rj(E6 e6) {
        super(e6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0278gh, io.appmetrica.analytics.impl.InterfaceC0304hh
    public final boolean a(Boolean bool) {
        return !this.f1014a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
