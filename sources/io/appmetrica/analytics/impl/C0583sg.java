package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.sg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0583sg implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0608tg f1046a;
    public final /* synthetic */ Dg b;

    public C0583sg(C0608tg c0608tg, Dg dg) {
        this.f1046a = c0608tg;
        this.b = dg;
    }

    public static final void a(C0608tg c0608tg, Dg dg) {
        try {
            ReferrerDetails installReferrer = c0608tg.b.getInstallReferrer();
            dg.a(new C0733yg(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0708xg.c));
            c0608tg.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0608tg c0608tg = this.f1046a;
            ICommonExecutor iCommonExecutor = c0608tg.f1061a;
            final Dg dg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.sg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0583sg.a(C0608tg.this, dg);
                }
            });
            return;
        }
        this.f1046a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
