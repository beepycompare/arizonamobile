package io.appmetrica.analytics.impl;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;
/* loaded from: classes5.dex */
public final class Oa implements InstallReferrerStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final InstallReferrerClient f700a;
    public final Dg b;
    public final /* synthetic */ Pa c;

    public Oa(Pa pa, InstallReferrerClient installReferrerClient, Dg dg) {
        this.c = pa;
        this.f700a = installReferrerClient;
        this.b = dg;
    }

    public static void a(int i) {
        if (i == 3) {
            C0541qk c0541qk = Oj.f706a;
            IllegalStateException illegalStateException = new IllegalStateException("Developer error");
            c0541qk.getClass();
            c0541qk.a(new Pj("Failed to get referrer via Google Play referrer library", illegalStateException));
        } else if (i != 4) {
        } else {
            C0541qk c0541qk2 = Oj.f706a;
            IllegalStateException illegalStateException2 = new IllegalStateException("Permission error");
            c0541qk2.getClass();
            c0541qk2.a(new Pj("Failed to get referrer via Google Play referrer library", illegalStateException2));
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerServiceDisconnected() {
    }

    @Override // com.android.installreferrer.api.InstallReferrerStateListener
    public final void onInstallReferrerSetupFinished(final int i) {
        this.c.f715a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Oa$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Oa.a(Oa.this, i);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:3:0x0002, B:5:0x0008, B:19:0x005a, B:6:0x0021, B:17:0x004d, B:18:0x0055, B:9:0x002a, B:11:0x0030, B:14:0x0037), top: B:34:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055 A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:3:0x0002, B:5:0x0008, B:19:0x005a, B:6:0x0021, B:17:0x004d, B:18:0x0055, B:9:0x002a, B:11:0x0030, B:14:0x0037), top: B:34:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Oa oa, int i) {
        Object m9896constructorimpl;
        String installReferrer;
        Bg bg;
        Object kg;
        try {
            Result.Companion companion = Result.Companion;
            if (i != 0) {
                oa.getClass();
                a(i);
                kg = new Jg("The connection returned an error code " + i, null, 2, null);
            } else {
                ReferrerDetails installReferrer2 = oa.f700a.getInstallReferrer();
                if (installReferrer2 != null && (installReferrer = installReferrer2.getInstallReferrer()) != null && !StringsKt.isBlank(installReferrer)) {
                    bg = new Bg(installReferrer2.getInstallReferrer(), installReferrer2.getReferrerClickTimestampSeconds(), installReferrer2.getInstallBeginTimestampSeconds(), 2);
                    if (bg != null) {
                        kg = new Jg("Referrer is null", null, 2, null);
                    } else {
                        kg = new Kg(bg);
                    }
                }
                bg = null;
                if (bg != null) {
                }
            }
            m9896constructorimpl = Result.m9896constructorimpl(kg);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9896constructorimpl = Result.m9896constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9899exceptionOrNullimpl = Result.m9899exceptionOrNullimpl(m9896constructorimpl);
        if (m9899exceptionOrNullimpl != null) {
            C0541qk c0541qk = Oj.f706a;
            c0541qk.getClass();
            c0541qk.a(new Pj("Failed to get referrer via Google Play referrer library", m9899exceptionOrNullimpl));
            m9896constructorimpl = new Jg("Failed to get referrer via Google Play referrer library", m9899exceptionOrNullimpl);
        }
        Lg lg = (Lg) m9896constructorimpl;
        try {
            oa.f700a.endConnection();
        } catch (Throwable unused) {
        }
        oa.b.a(lg);
    }
}
