package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.sg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0591sg implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0616tg f1045a;
    public final /* synthetic */ Dg b;

    public C0591sg(C0616tg c0616tg, Dg dg) {
        this.f1045a = c0616tg;
        this.b = dg;
    }

    public static final void a(C0616tg c0616tg, Dg dg) {
        try {
            ReferrerDetails installReferrer = c0616tg.b.getInstallReferrer();
            dg.a(new C0741yg(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0716xg.c));
            c0616tg.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0616tg c0616tg = this.f1045a;
            ICommonExecutor iCommonExecutor = c0616tg.f1060a;
            final Dg dg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.sg$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0591sg.a(C0616tg.this, dg);
                }
            });
            return;
        }
        this.f1045a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
