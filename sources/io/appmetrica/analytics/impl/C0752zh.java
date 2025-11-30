package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.zh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0752zh extends AbstractC0300hh {
    public C0752zh(F6 f6) {
        super(f6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0300hh, io.appmetrica.analytics.impl.InterfaceC0325ih
    public final boolean a(Boolean bool) {
        return !this.f925a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
