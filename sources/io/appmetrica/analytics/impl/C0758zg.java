package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.zg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0758zg implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ag f1181a;
    public final /* synthetic */ Kg b;

    public C0758zg(Ag ag, Kg kg) {
        this.f1181a = ag;
        this.b = kg;
    }

    public static final void a(Ag ag, Kg kg) {
        try {
            ReferrerDetails installReferrer = ag.b.getInstallReferrer();
            kg.a(new Fg(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), Eg.c));
            ag.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final Ag ag = this.f1181a;
            ICommonExecutor iCommonExecutor = ag.f347a;
            final Kg kg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.zg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0758zg.a(Ag.this, kg);
                }
            });
            return;
        }
        this.f1181a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
