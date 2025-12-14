package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.zh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0751zh extends AbstractC0299hh {
    public C0751zh(F6 f6) {
        super(f6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0299hh, io.appmetrica.analytics.impl.InterfaceC0324ih
    public final boolean a(Boolean bool) {
        return !this.f1022a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
