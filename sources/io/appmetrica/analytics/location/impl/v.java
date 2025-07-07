package io.appmetrica.analytics.location.impl;

import android.content.Context;
import android.location.LocationListener;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
/* loaded from: classes4.dex */
public final class v implements LastKnownLocationExtractorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final String f1196a;
    public final s b;
    public final String c;

    public v(String str, s sVar, String str2) {
        this.f1196a = str;
        this.b = sVar;
        this.c = str2;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider
    /* renamed from: a */
    public final u getExtractor(Context context, PermissionExtractor permissionExtractor, IHandlerExecutor iHandlerExecutor, LocationListener locationListener) {
        return new u(context, this.b.a(permissionExtractor), locationListener, this.f1196a);
    }

    @Override // io.appmetrica.analytics.locationapi.internal.Identifiable
    public final String getIdentifier() {
        return this.c;
    }
}
