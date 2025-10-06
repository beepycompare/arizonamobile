package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* loaded from: classes4.dex */
public final class Eg implements InterfaceC0483ob {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f429a;
    public final InstallReferrerClient b;

    public Eg(Context context, ICommonExecutor iCommonExecutor) {
        this.f429a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(Og og, Throwable th) {
        og.a(th);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0483ob
    public final void a(Og og) throws Throwable {
        this.b.startConnection(new Dg(this, og));
    }

    public final void a(final Og og, final Throwable th) {
        this.f429a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Eg$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Eg.b(Og.this, th);
            }
        });
    }
}
