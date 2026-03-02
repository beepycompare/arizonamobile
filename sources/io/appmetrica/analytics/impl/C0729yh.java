package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.yh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0729yh extends AbstractC0277gh {
    public C0729yh(E6 e6) {
        super(e6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gh, io.appmetrica.analytics.impl.InterfaceC0303hh
    public final boolean a(Boolean bool) {
        return !this.f1014a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
