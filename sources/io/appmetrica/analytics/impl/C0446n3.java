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
public final class C0446n3 implements InterfaceC0515pm {

    /* renamed from: a  reason: collision with root package name */
    public BillingMonitor f978a;
    public final Context b;
    public final Executor c;
    public final Executor d;
    public final BillingType e;
    public final BillingInfoStorage f;
    public final BillingInfoSender g;
    public final ApplicationStateProvider h;
    public final C0396l3 i;

    public C0446n3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender) {
        this(context, executor, executor2, billingType, billingInfoStorage, billingInfoSender, Ka.j().d(), new C0396l3());
    }

    public final void a(C0389km c0389km, Boolean bool) {
        BillingMonitor billingLibraryMonitor;
        BillingMonitor billingMonitor;
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
                int i = AbstractC0370k3.f934a[billingType.ordinal()];
                if (i == 1) {
                    billingLibraryMonitor = new BillingLibraryMonitor(context, executor, executor2, billingInfoStorage, billingInfoSender, null, null, 96, null);
                } else if (i != 2) {
                    billingMonitor = new C0526q8();
                    this.f978a = billingMonitor;
                } else {
                    billingLibraryMonitor = new io.appmetrica.analytics.billingv8.internal.BillingLibraryMonitor(context, executor, executor2, billingInfoStorage, billingInfoSender, null, null, 96, null);
                }
                billingMonitor = billingLibraryMonitor;
                this.f978a = billingMonitor;
            }
            billingMonitor.onBillingConfigChanged(c0389km.x);
            if (this.h.registerStickyObserver(new C0421m3(this)) == ApplicationState.VISIBLE) {
                try {
                    BillingMonitor billingMonitor2 = this.f978a;
                    if (billingMonitor2 != null) {
                        billingMonitor2.onSessionResumed();
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0515pm
    public final synchronized void a(C0389km c0389km) {
        BillingMonitor billingMonitor;
        synchronized (this) {
            billingMonitor = this.f978a;
        }
        if (billingMonitor != null) {
            billingMonitor.onBillingConfigChanged(c0389km.x);
        }
    }
}
