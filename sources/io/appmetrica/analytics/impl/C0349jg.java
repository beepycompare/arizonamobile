package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0349jg implements Pa {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f1040a;
    public final InstallReferrerClient b;

    public C0349jg(Context context, ICommonExecutor iCommonExecutor) {
        this.f1040a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(InterfaceC0600tg interfaceC0600tg, Throwable th) {
        interfaceC0600tg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.Pa
    public final void a(InterfaceC0600tg interfaceC0600tg) throws Throwable {
        this.b.startConnection(new C0323ig(this, interfaceC0600tg));
    }

    public final void a(final InterfaceC0600tg interfaceC0600tg, final Throwable th) {
        this.f1040a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.jg$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0349jg.b(InterfaceC0600tg.this, th);
            }
        });
    }
}
