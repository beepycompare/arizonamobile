package io.appmetrica.analytics.coreutils.internal.cache;

import io.appmetrica.analytics.coreapi.internal.cache.UpdateConditionsChecker;
import io.appmetrica.analytics.locationapi.internal.ILastKnownUpdater;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationDataCacheUpdateScheduler f357a;

    public b(LocationDataCacheUpdateScheduler locationDataCacheUpdateScheduler) {
        this.f357a = locationDataCacheUpdateScheduler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UpdateConditionsChecker updateConditionsChecker;
        a aVar;
        ILastKnownUpdater iLastKnownUpdater;
        updateConditionsChecker = this.f357a.c;
        if (updateConditionsChecker.shouldUpdate()) {
            aVar = this.f357a.d;
            iLastKnownUpdater = aVar.f356a.b;
            iLastKnownUpdater.updateLastKnown();
        }
    }
}
