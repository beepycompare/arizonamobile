package io.appmetrica.analytics.screenshot.impl;

import android.os.Bundle;
import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.h  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0773h implements BundleToServiceConfigConverter {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter
    /* renamed from: a */
    public final B fromBundle(Bundle bundle) {
        bundle.setClassLoader(B.class.getClassLoader());
        B b = (B) bundle.getParcelable("config");
        return b == null ? new B(new g0()) : b;
    }
}
