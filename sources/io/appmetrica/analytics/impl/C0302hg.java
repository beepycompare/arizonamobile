package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.hg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0302hg implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0327ig f1028a;
    public final /* synthetic */ InterfaceC0578sg b;

    public C0302hg(C0327ig c0327ig, InterfaceC0578sg interfaceC0578sg) {
        this.f1028a = c0327ig;
        this.b = interfaceC0578sg;
    }

    public static final void a(C0327ig c0327ig, InterfaceC0578sg interfaceC0578sg) {
        try {
            ReferrerDetails installReferrer = c0327ig.b.getInstallReferrer();
            interfaceC0578sg.a(new C0454ng(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0429mg.c));
            c0327ig.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        final C0327ig c0327ig = this.f1028a;
        if (i == 0) {
            ICommonExecutor iCommonExecutor = c0327ig.f1045a;
            final InterfaceC0578sg interfaceC0578sg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.hg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0302hg.a(C0327ig.this, interfaceC0578sg);
                }
            });
            return;
        }
        c0327ig.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
