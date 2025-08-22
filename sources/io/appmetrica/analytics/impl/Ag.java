package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public final class Ag implements InterfaceC0404lb {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f347a;
    public final InstallReferrerClient b;

    public Ag(Context context, ICommonExecutor iCommonExecutor) {
        this.f347a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(Kg kg, Throwable th) {
        kg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb
    public final void a(Kg kg) throws Throwable {
        this.b.startConnection(new C0758zg(this, kg));
    }

    public final void a(final Kg kg, final Throwable th) {
        this.f347a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Ag$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ag.b(Kg.this, th);
            }
        });
    }
}
