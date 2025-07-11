package io.appmetrica.analytics.location.impl;

import android.content.Context;
import android.location.LocationListener;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.gpllibrary.internal.GplLibraryWrapper;
import io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class b implements LastKnownLocationExtractor {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1182a;
    public final PermissionResolutionStrategy b;
    public final LocationListener c;
    public final IHandlerExecutor d;
    public final d e = new d();

    public b(Context context, PermissionResolutionStrategy permissionResolutionStrategy, LocationListener locationListener, IHandlerExecutor iHandlerExecutor) {
        this.f1182a = context;
        this.b = permissionResolutionStrategy;
        this.c = locationListener;
        this.d = iHandlerExecutor;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractor
    public final void updateLastKnownLocation() {
        IGplLibraryWrapper gplLibraryWrapper;
        if (this.b.hasNecessaryPermissions(this.f1182a)) {
            try {
                d dVar = this.e;
                Context context = this.f1182a;
                LocationListener locationListener = this.c;
                IHandlerExecutor iHandlerExecutor = this.d;
                dVar.getClass();
                if (ReflectionUtils.detectClassExists("com.google.android.gms.location.LocationRequest")) {
                    try {
                        gplLibraryWrapper = new GplLibraryWrapper(context, locationListener, iHandlerExecutor.getLooper(), iHandlerExecutor, TimeUnit.SECONDS.toMillis(1L));
                    } catch (Throwable unused) {
                    }
                    gplLibraryWrapper.updateLastKnownLocation();
                }
                gplLibraryWrapper = new a();
                gplLibraryWrapper.updateLastKnownLocation();
            } catch (Throwable unused2) {
            }
        }
    }
}
