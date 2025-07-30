package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0635ug implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0660vg f1086a;
    public final /* synthetic */ Fg b;

    public C0635ug(C0660vg c0660vg, Fg fg) {
        this.f1086a = c0660vg;
        this.b = fg;
    }

    public static final void a(C0660vg c0660vg, Fg fg) {
        try {
            ReferrerDetails installReferrer = c0660vg.b.getInstallReferrer();
            fg.a(new Ag(installReferrer.getInstallReferrer(), installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), EnumC0760zg.c));
            c0660vg.b.endConnection();
        } catch (Throwable unused) {
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            final C0660vg c0660vg = this.f1086a;
            ICommonExecutor iCommonExecutor = c0660vg.f1103a;
            final Fg fg = this.b;
            iCommonExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.ug$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0635ug.a(C0660vg.this, fg);
                }
            });
            return;
        }
        this.f1086a.a(this.b, new IllegalStateException("Referrer check failed with error " + i));
    }
}
