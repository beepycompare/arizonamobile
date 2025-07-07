package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.tg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0616tg implements InterfaceC0313hb {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f1060a;
    public final InstallReferrerClient b;

    public C0616tg(Context context, ICommonExecutor iCommonExecutor) {
        this.f1060a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(Dg dg, Throwable th) {
        dg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0313hb
    public final void a(Dg dg) throws Throwable {
        this.b.startConnection(new C0591sg(this, dg));
    }

    public final void a(final Dg dg, final Throwable th) {
        this.f1060a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.tg$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0616tg.b(Dg.this, th);
            }
        });
    }
}
