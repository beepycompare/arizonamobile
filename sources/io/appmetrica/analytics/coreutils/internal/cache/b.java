package io.appmetrica.analytics.coreutils.internal.cache;

import io.appmetrica.analytics.coreapi.internal.cache.UpdateConditionsChecker;
import io.appmetrica.analytics.locationapi.internal.ILastKnownUpdater;
/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationDataCacheUpdateScheduler f272a;

    public b(LocationDataCacheUpdateScheduler locationDataCacheUpdateScheduler) {
        this.f272a = locationDataCacheUpdateScheduler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UpdateConditionsChecker updateConditionsChecker;
        a aVar;
        ILastKnownUpdater iLastKnownUpdater;
        updateConditionsChecker = this.f272a.c;
        if (updateConditionsChecker.shouldUpdate()) {
            aVar = this.f272a.d;
            iLastKnownUpdater = aVar.f271a.b;
            iLastKnownUpdater.updateLastKnown();
        }
    }
}
