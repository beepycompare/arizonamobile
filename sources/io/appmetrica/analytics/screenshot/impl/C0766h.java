package io.appmetrica.analytics.screenshot.impl;

import android.os.Bundle;
import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
/* renamed from: io.appmetrica.analytics.screenshot.impl.h  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0766h implements BundleToServiceConfigConverter {
    @Override // io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter
    /* renamed from: a */
    public final D fromBundle(Bundle bundle) {
        bundle.setClassLoader(D.class.getClassLoader());
        D d = (D) bundle.getParcelable("config");
        return d == null ? new D(new j0()) : d;
    }
}
