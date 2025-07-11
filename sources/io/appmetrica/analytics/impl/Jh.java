package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Jh extends AbstractC0559rh {
    public Jh(W6 w6) {
        super(w6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0559rh, io.appmetrica.analytics.impl.InterfaceC0584sh
    public final boolean a(Boolean bool) {
        return !this.f1028a.isRestrictedForReporter() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
