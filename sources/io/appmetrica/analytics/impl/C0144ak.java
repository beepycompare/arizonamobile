package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0144ak extends AbstractC0567rh {
    public C0144ak(W6 w6) {
        super(w6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0567rh, io.appmetrica.analytics.impl.InterfaceC0592sh
    public final boolean a(Boolean bool) {
        return !this.f1027a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
