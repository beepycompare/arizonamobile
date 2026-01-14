package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0303hg implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0328ig f1029a;
    public final /* synthetic */ InterfaceC0579sg b;

    public C0303hg(C0328ig c0328ig, InterfaceC0579sg interfaceC0579sg) {
        this.f1029a = c0328ig;
        this.b = interfaceC0579sg;
    }

    public static final void a(C0328ig c0328ig, InterfaceC0579sg interfaceC0579sg) {
        try {
            ReferrerDetails installReferrer = c0328ig.b.getInstallReferrer();
            interfaceC0579sg.a(new C0455ng(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0430mg.c));
            c0328ig.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0328ig c0328ig = this.f1029a;
            ICommonExecutor iCommonExecutor = c0328ig.f1046a;
            final InterfaceC0579sg interfaceC0579sg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.hg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0303hg.a(C0328ig.this, interfaceC0579sg);
                }
            });
            return;
        }
        this.f1029a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
