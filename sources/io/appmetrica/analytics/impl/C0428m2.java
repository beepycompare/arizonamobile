package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* renamed from: io.appmetrica.analytics.impl.m2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0428m2 implements InterfaceC0521pk, ApplicationStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f931a = new HashSet();
    public final HashSet b = new HashSet();
    public volatile ApplicationState c = ApplicationState.UNKNOWN;
    public final CopyOnWriteArraySet d = new CopyOnWriteArraySet();

    public final void a(int i) {
        this.f931a.remove(Integer.valueOf(i));
        a();
    }

    public final void b(int i) {
        this.b.add(Integer.valueOf(i));
        this.f931a.remove(Integer.valueOf(i));
        a();
    }

    public final void c(int i) {
        this.f931a.add(Integer.valueOf(i));
        this.b.remove(Integer.valueOf(i));
        a();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateProvider
    public final ApplicationState getCurrentState() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0521pk
    public final void onCreate() {
        a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0521pk
    public final void onDestroy() {
        if (this.c == ApplicationState.VISIBLE) {
            this.c = ApplicationState.BACKGROUND;
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateProvider
    public final ApplicationState registerStickyObserver(ApplicationStateObserver applicationStateObserver) {
        if (applicationStateObserver != null) {
            this.d.add(applicationStateObserver);
        }
        return this.c;
    }

    public final void a() {
        ApplicationState applicationState = ApplicationState.UNKNOWN;
        if (!this.f931a.isEmpty()) {
            applicationState = ApplicationState.VISIBLE;
        } else if (!this.b.isEmpty()) {
            applicationState = ApplicationState.BACKGROUND;
        }
        if (this.c != applicationState) {
            this.c = applicationState;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((ApplicationStateObserver) it.next()).onApplicationStateChanged(this.c);
            }
        }
    }
}
