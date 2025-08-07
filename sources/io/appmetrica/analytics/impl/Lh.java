package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Lh extends AbstractC0612th {
    public Lh(Z6 z6) {
        super(z6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0612th, io.appmetrica.analytics.impl.InterfaceC0637uh
    public final boolean a(Boolean bool) {
        return !this.f1067a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
