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
/* renamed from: io.appmetrica.analytics.impl.q3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0525q3 implements InterfaceC0618tm {

    /* renamed from: a  reason: collision with root package name */
    public BillingMonitor f1045a;
    public final Context b;
    public final Executor c;
    public final Executor d;
    public final BillingType e;
    public final BillingInfoStorage f;
    public final BillingInfoSender g;
    public final ApplicationStateProvider h;
    public final C0474o3 i;

    public C0525q3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender) {
        this(context, executor, executor2, billingType, billingInfoStorage, billingInfoSender, Na.j().d(), new C0474o3());
    }

    public final void a(C0493om c0493om, Boolean bool) {
        BillingMonitor billingLibraryMonitor;
        BillingMonitor billingMonitor;
        if (((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue()) {
            synchronized (this) {
                C0474o3 c0474o3 = this.i;
                Context context = this.b;
                Executor executor = this.c;
                Executor executor2 = this.d;
                BillingType billingType = this.e;
                BillingInfoStorage billingInfoStorage = this.f;
                BillingInfoSender billingInfoSender = this.g;
                c0474o3.getClass();
                int i = AbstractC0448n3.f1002a[billingType.ordinal()];
                if (i == 1) {
                    billingLibraryMonitor = new BillingLibraryMonitor(context, executor, executor2, billingInfoStorage, billingInfoSender, null, null, 96, null);
                } else if (i != 2) {
                    billingMonitor = new C0604t8();
                    this.f1045a = billingMonitor;
                } else {
                    billingLibraryMonitor = new io.appmetrica.analytics.billingv8.internal.BillingLibraryMonitor(context, executor, executor2, billingInfoStorage, billingInfoSender, null, null, 96, null);
                }
                billingMonitor = billingLibraryMonitor;
                this.f1045a = billingMonitor;
            }
            billingMonitor.onBillingConfigChanged(c0493om.x);
            if (this.h.registerStickyObserver(new C0500p3(this)) == ApplicationState.VISIBLE) {
                try {
                    BillingMonitor billingMonitor2 = this.f1045a;
                    if (billingMonitor2 != null) {
                        billingMonitor2.onSessionResumed();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0525q3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender, ApplicationStateProvider applicationStateProvider, C0474o3 c0474o3) {
        this.b = context;
        this.c = executor;
        this.d = executor2;
        this.e = billingType;
        this.f = billingInfoStorage;
        this.g = billingInfoSender;
        this.h = applicationStateProvider;
        this.i = c0474o3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0618tm
    public final synchronized void a(C0493om c0493om) {
        BillingMonitor billingMonitor;
        synchronized (this) {
            billingMonitor = this.f1045a;
        }
        if (billingMonitor != null) {
            billingMonitor.onBillingConfigChanged(c0493om.x);
        }
    }
}
