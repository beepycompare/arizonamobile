package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public final class Dh extends AbstractC0403lh {
    public Dh(L6 l6) {
        super(l6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0403lh, io.appmetrica.analytics.impl.InterfaceC0428mh
    public final boolean a(Boolean bool) {
        return !this.f992a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
