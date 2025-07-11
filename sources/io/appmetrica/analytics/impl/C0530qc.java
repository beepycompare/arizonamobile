package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationListener;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.locationapi.internal.LocationReceiver;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
/* renamed from: io.appmetrica.analytics.impl.qc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0530qc implements LocationReceiverProvider {

    /* renamed from: a  reason: collision with root package name */
    public final String f1006a = "Location receiver stub";

    @Override // io.appmetrica.analytics.locationapi.internal.Identifiable
    public final String getIdentifier() {
        return this.f1006a;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider
    public final LocationReceiver getLocationReceiver(Context context, PermissionExtractor permissionExtractor, IHandlerExecutor iHandlerExecutor, LocationListener locationListener) {
        return new C0554rc();
    }
}
