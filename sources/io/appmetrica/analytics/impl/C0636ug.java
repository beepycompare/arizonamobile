package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0636ug implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0661vg f1085a;
    public final /* synthetic */ Fg b;

    public C0636ug(C0661vg c0661vg, Fg fg) {
        this.f1085a = c0661vg;
        this.b = fg;
    }

    public static final void a(C0661vg c0661vg, Fg fg) {
        try {
            ReferrerDetails installReferrer = c0661vg.b.getInstallReferrer();
            fg.a(new Ag(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0761zg.c));
            c0661vg.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0661vg c0661vg = this.f1085a;
            ICommonExecutor iCommonExecutor = c0661vg.f1102a;
            final Fg fg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.ug$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0636ug.a(C0661vg.this, fg);
                }
            });
            return;
        }
        this.f1085a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
