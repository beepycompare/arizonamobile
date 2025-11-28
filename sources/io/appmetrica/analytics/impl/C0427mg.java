package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0427mg implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0452ng f1009a;
    public final /* synthetic */ InterfaceC0701xg b;

    public C0427mg(C0452ng c0452ng, InterfaceC0701xg interfaceC0701xg) {
        this.f1009a = c0452ng;
        this.b = interfaceC0701xg;
    }

    public static final void a(C0452ng c0452ng, InterfaceC0701xg interfaceC0701xg) {
        try {
            ReferrerDetails installReferrer = c0452ng.b.getInstallReferrer();
            interfaceC0701xg.a(new C0576sg(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0551rg.c));
            c0452ng.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0452ng c0452ng = this.f1009a;
            ICommonExecutor iCommonExecutor = c0452ng.f1026a;
            final InterfaceC0701xg interfaceC0701xg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.mg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0427mg.a(C0452ng.this, interfaceC0701xg);
                }
            });
            return;
        }
        this.f1009a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
