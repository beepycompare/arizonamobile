package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Jh extends AbstractC0567rh {
    public Jh(W6 w6) {
        super(w6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0567rh, io.appmetrica.analytics.impl.InterfaceC0592sh
    public final boolean a(Boolean bool) {
        return !this.f1027a.isRestrictedForReporter() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
