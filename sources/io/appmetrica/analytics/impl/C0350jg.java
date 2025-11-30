package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0350jg implements Pa {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f957a;
    public final InstallReferrerClient b;

    public C0350jg(Context context, ICommonExecutor iCommonExecutor) {
        this.f957a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(InterfaceC0601tg interfaceC0601tg, Throwable th) {
        interfaceC0601tg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(InterfaceC0601tg interfaceC0601tg) throws Throwable {
        this.b.startConnection(new C0324ig(this, interfaceC0601tg));
    }

    public final void a(final InterfaceC0601tg interfaceC0601tg, final Throwable th) {
        this.f957a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.jg$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0350jg.b(InterfaceC0601tg.this, th);
            }
        });
    }
}
