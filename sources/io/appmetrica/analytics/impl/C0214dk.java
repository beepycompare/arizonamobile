package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.dk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0214dk extends AbstractC0611th {
    public C0214dk(Z6 z6) {
        super(z6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0611th, io.appmetrica.analytics.impl.InterfaceC0636uh
    public final boolean a(Boolean bool) {
        return !this.f1067a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
