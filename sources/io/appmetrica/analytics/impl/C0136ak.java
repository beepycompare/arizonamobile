package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.ak  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0136ak extends AbstractC0559rh {
    public C0136ak(W6 w6) {
        super(w6);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0559rh, io.appmetrica.analytics.impl.InterfaceC0584sh
    public final boolean a(Boolean bool) {
        return !this.f1028a.isRestrictedForSdk() && ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
