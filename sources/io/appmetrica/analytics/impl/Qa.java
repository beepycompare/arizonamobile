package io.appmetrica.analytics.impl;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
/* loaded from: classes5.dex */
public final class Qa implements Hg {

    /* renamed from: a  reason: collision with root package name */
    public final Context f729a;
    public final ICommonExecutor b;
    public final String c = Constants.REFERRER_API_GOOGLE;

    public Qa(Context context, ICommonExecutor iCommonExecutor) {
        this.f729a = context;
        this.b = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final String a() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.impl.Hg
    public final void a(Dg dg) {
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            Pa pa = new Pa(this.b);
            try {
                InstallReferrerClient build = InstallReferrerClient.newBuilder(this.f729a).build();
                build.startConnection(new Oa(pa, build, dg));
                return;
            } catch (Throwable th) {
                C0541qk c0541qk = Oj.f706a;
                c0541qk.getClass();
                c0541qk.a(new Pj("Failed to get referrer from Google Play referrer library", th));
                dg.a(new Jg("Failed to get referrer from Google Play referrer library", th));
                return;
            }
        }
        dg.a(new Jg("Google Play Install Referrer library is not detected", null, 2, null));
    }
}
