package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;
import io.appmetrica.analytics.coreutils.internal.toggle.SimpleThreadSafeToggle;
import kotlin.Unit;
/* loaded from: classes4.dex */
public final class Bo extends SimpleThreadSafeToggle implements ApplicationStateObserver {
    public Bo() {
        super(false, "[VisibleAppStateOnlyTrackingStatusToggle]");
        synchronized (this) {
            a(Na.j().d().registerStickyObserver(this));
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
