package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.ng  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0452ng implements Va {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f1026a;
    public final InstallReferrerClient b;

    public C0452ng(Context context, ICommonExecutor iCommonExecutor) {
        this.f1026a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(InterfaceC0701xg interfaceC0701xg, Throwable th) {
        interfaceC0701xg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(InterfaceC0701xg interfaceC0701xg) throws Throwable {
        this.b.startConnection(new C0427mg(this, interfaceC0701xg));
    }

    public final void a(final InterfaceC0701xg interfaceC0701xg, final Throwable th) {
        this.f1026a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.ng$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0452ng.b(InterfaceC0701xg.this, th);
            }
        });
    }
}
