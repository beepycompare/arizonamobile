package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.ig  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0324ig implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0350jg f940a;
    public final /* synthetic */ InterfaceC0601tg b;

    public C0324ig(C0350jg c0350jg, InterfaceC0601tg interfaceC0601tg) {
        this.f940a = c0350jg;
        this.b = interfaceC0601tg;
    }

    public static final void a(C0350jg c0350jg, InterfaceC0601tg interfaceC0601tg) {
        try {
            ReferrerDetails installReferrer = c0350jg.b.getInstallReferrer();
            interfaceC0601tg.a(new C0477og(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0452ng.c));
            c0350jg.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0350jg c0350jg = this.f940a;
            ICommonExecutor iCommonExecutor = c0350jg.f957a;
            final InterfaceC0601tg interfaceC0601tg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.ig$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0324ig.a(C0350jg.this, interfaceC0601tg);
                }
            });
            return;
        }
        this.f940a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
