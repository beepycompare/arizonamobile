package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;
import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import kotlin.Unit;
/* loaded from: classes5.dex */
public final class wo extends SimpleThreadSafeToggle implements ApplicationStateObserver {
    public wo() {
        super(false, "[VisibleAppStateOnlyTrackingStatusToggle]");
        synchronized (this) {
            a(C0470oa.k().e().registerStickyObserver(this));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(ApplicationState applicationState) {
        updateState(applicationState == ApplicationState.VISIBLE);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver
    public final synchronized void onApplicationStateChanged(ApplicationState applicationState) {
        a(applicationState);
    }
}
