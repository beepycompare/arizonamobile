package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.ig  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0323ig implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0349jg f1023a;
    public final /* synthetic */ InterfaceC0600tg b;

    public C0323ig(C0349jg c0349jg, InterfaceC0600tg interfaceC0600tg) {
        this.f1023a = c0349jg;
        this.b = interfaceC0600tg;
    }

    public static final void a(C0349jg c0349jg, InterfaceC0600tg interfaceC0600tg) {
        try {
            ReferrerDetails installReferrer = c0349jg.b.getInstallReferrer();
            interfaceC0600tg.a(new C0476og(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0451ng.c));
            c0349jg.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0349jg c0349jg = this.f1023a;
            ICommonExecutor iCommonExecutor = c0349jg.f1040a;
            final InterfaceC0600tg interfaceC0600tg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.ig$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0323ig.a(C0349jg.this, interfaceC0600tg);
                }
            });
            return;
        }
        this.f1023a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
