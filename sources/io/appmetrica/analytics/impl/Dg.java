package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public final class Dg implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Eg f411a;
    public final /* synthetic */ Og b;

    public Dg(Eg eg, Og og) {
        this.f411a = eg;
        this.b = og;
    }

    public static final void a(Eg eg, Og og) {
        try {
            ReferrerDetails installReferrer = eg.b.getInstallReferrer();
            og.a(new Jg(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), Ig.c));
            eg.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final Eg eg = this.f411a;
            ICommonExecutor iCommonExecutor = eg.f428a;
            final Og og = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Dg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Dg.a(Eg.this, og);
                }
            });
            return;
        }
        this.f411a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
