package io.appmetrica.analytics.billing.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingType;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.billinginterface.internal.monitor.DummyBillingMonitor;
import io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentContext;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentLifecycleListener;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import kotlin.text.StringsKt;
/* loaded from: classes3.dex */
public final class m implements ServiceModuleReporterComponentLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f218a;
    public B b;
    public BillingMonitor c;

    public m(ServiceContext serviceContext, B b) {
        this.f218a = serviceContext;
        this.b = b;
    }

    public final void a(B b) {
        BillingConfig billingConfig;
        BillingMonitor billingMonitor = this.c;
        if (billingMonitor != null) {
            if (b != null) {
                A a2 = b.b;
                billingConfig = new BillingConfig(a2.f208a, a2.b);
            } else {
                billingConfig = null;
            }
            billingMonitor.onBillingConfigChanged(billingConfig);
        }
        this.b = b;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceModuleReporterComponentLifecycleListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMainReporterCreated(ServiceModuleReporterComponentContext serviceModuleReporterComponentContext) {
        String str;
        BillingType billingType;
        BillingMonitor billingLibraryMonitor;
        BillingMonitor billingMonitor;
        Field field;
        if (!serviceModuleReporterComponentContext.getConfig().isRevenueAutoTrackingEnabled()) {
            return;
        }
        Context context = this.f218a.getContext();
        IHandlerExecutor defaultExecutor = this.f218a.getExecutorProvider().getDefaultExecutor();
        Executor uiExecutor = this.f218a.getExecutorProvider().getUiExecutor();
        try {
            Class<?> findClass = ReflectionUtils.findClass("com.android.billingclient.BuildConfig");
            str = (String) ((findClass == null || (field = findClass.getField("VERSION_NAME")) == null) ? null : field.get(null));
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null && !StringsKt.isBlank(str)) {
            if (StringsKt.startsWith$default(str, "2.", false, 2, (Object) null)) {
                billingType = BillingType.NONE;
            } else if (StringsKt.startsWith$default(str, "3.", false, 2, (Object) null)) {
                billingType = BillingType.NONE;
            } else if (StringsKt.startsWith$default(str, "4.", false, 2, (Object) null)) {
                billingType = BillingType.NONE;
            } else if (StringsKt.startsWith$default(str, "5.", false, 2, (Object) null)) {
                billingType = BillingType.LIBRARY_V6;
            } else if (StringsKt.startsWith$default(str, "6.", false, 2, (Object) null)) {
                billingType = BillingType.LIBRARY_V6;
            } else if (StringsKt.startsWith$default(str, "7.", false, 2, (Object) null)) {
                billingType = BillingType.LIBRARY_V6;
            } else {
                billingType = StringsKt.startsWith$default(str, "8.", false, 2, (Object) null) ? BillingType.LIBRARY_V8 : BillingType.LIBRARY_V8;
            }
        } else {
            billingType = BillingType.NONE;
        }
        k kVar = new k(this.f218a.getServiceStorageProvider().createBinaryStateStorageFactory("auto_inapp_collecting_info_data", new e(), new C0098b(null, 1, null)).create(this.f218a.getContext()));
        j jVar = new j(serviceModuleReporterComponentContext.getReporter(), this.f218a.getExecutorProvider().getReportRunnableExecutor(), null, 4, null);
        int i = l.f217a[billingType.ordinal()];
        if (i == 1) {
            billingLibraryMonitor = new BillingLibraryMonitor(context, defaultExecutor, uiExecutor, kVar, jVar, null, null, 96, null);
        } else if (i != 2) {
            billingMonitor = new DummyBillingMonitor();
            this.c = billingMonitor;
            a(this.b);
            if (this.f218a.getApplicationStateProvider().registerStickyObserver(new ApplicationStateObserver() { // from class: io.appmetrica.analytics.billing.impl.m$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver
                public final void onApplicationStateChanged(ApplicationState applicationState) {
                    m.a(m.this, applicationState);
                }
            }) != ApplicationState.VISIBLE) {
                try {
                    BillingMonitor billingMonitor2 = this.c;
                    if (billingMonitor2 != null) {
                        billingMonitor2.onSessionResumed();
                        return;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            }
            return;
        } else {
            billingLibraryMonitor = new io.appmetrica.analytics.billingv8.internal.BillingLibraryMonitor(context, defaultExecutor, uiExecutor, kVar, jVar, null, null, 96, null);
        }
        billingMonitor = billingLibraryMonitor;
        this.c = billingMonitor;
        a(this.b);
        if (this.f218a.getApplicationStateProvider().registerStickyObserver(new ApplicationStateObserver() { // from class: io.appmetrica.analytics.billing.impl.m$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateObserver
            public final void onApplicationStateChanged(ApplicationState applicationState) {
                m.a(m.this, applicationState);
            }
        }) != ApplicationState.VISIBLE) {
        }
    }

    public static final void a(m mVar, ApplicationState applicationState) {
        mVar.getClass();
        if (applicationState == ApplicationState.VISIBLE) {
            try {
                BillingMonitor billingMonitor = mVar.c;
                if (billingMonitor != null) {
                    billingMonitor.onSessionResumed();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
