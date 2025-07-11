package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingType;
import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateProvider;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.n3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0446n3 implements InterfaceC0316hm {

    /* renamed from: a  reason: collision with root package name */
    public BillingMonitor f951a;
    public final Context b;
    public final Executor c;
    public final Executor d;
    public final BillingType e;
    public final BillingInfoStorage f;
    public final BillingInfoSender g;
    public final ApplicationStateProvider h;
    public final C0396l3 i;

    public C0446n3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender) {
        this(context, executor, executor2, billingType, billingInfoStorage, billingInfoSender, Ga.j().d(), new C0396l3());
    }

    public final void a(C0190cm c0190cm, Boolean bool) {
        BillingMonitor c0401l8;
        if (((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue()) {
            synchronized (this) {
                C0396l3 c0396l3 = this.i;
                Context context = this.b;
                Executor executor = this.c;
                Executor executor2 = this.d;
                BillingType billingType = this.e;
                BillingInfoStorage billingInfoStorage = this.f;
                BillingInfoSender billingInfoSender = this.g;
                c0396l3.getClass();
                if (AbstractC0371k3.f901a[billingType.ordinal()] == 1) {
                    c0401l8 = new BillingLibraryMonitor(context, executor, executor2, billingInfoStorage, billingInfoSender, null, null, 96, null);
                } else {
                    c0401l8 = new C0401l8();
                }
                this.f951a = c0401l8;
            }
            c0401l8.onBillingConfigChanged(c0190cm.x);
            if (this.h.registerStickyObserver(new C0421m3(this)) == ApplicationState.VISIBLE) {
                try {
                    BillingMonitor billingMonitor = this.f951a;
                    if (billingMonitor != null) {
                        billingMonitor.onSessionResumed();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0446n3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender, ApplicationStateProvider applicationStateProvider, C0396l3 c0396l3) {
        this.b = context;
        this.c = executor;
        this.d = executor2;
        this.e = billingType;
        this.f = billingInfoStorage;
        this.g = billingInfoSender;
        this.h = applicationStateProvider;
        this.i = c0396l3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0316hm
    public final synchronized void a(C0190cm c0190cm) {
        BillingMonitor billingMonitor;
        synchronized (this) {
            billingMonitor = this.f951a;
        }
        if (billingMonitor != null) {
            billingMonitor.onBillingConfigChanged(c0190cm.x);
        }
    }
}
