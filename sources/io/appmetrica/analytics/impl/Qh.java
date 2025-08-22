package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public final class Qh extends AbstractC0734yh {
    public Qh(C0116a7 c0116a7) {
        super(c0116a7);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0734yh, io.appmetrica.analytics.impl.InterfaceC0759zh
    public final boolean a(Boolean bool) {
        return !this.f1161a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
