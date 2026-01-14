package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.ig  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0328ig implements Oa {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f1046a;
    public final InstallReferrerClient b;

    public C0328ig(Context context, ICommonExecutor iCommonExecutor) {
        this.f1046a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(InterfaceC0579sg interfaceC0579sg, Throwable th) {
        interfaceC0579sg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final void a(InterfaceC0579sg interfaceC0579sg) throws Throwable {
        this.b.startConnection(new C0303hg(this, interfaceC0579sg));
    }

    public final void a(final InterfaceC0579sg interfaceC0579sg, final Throwable th) {
        this.f1046a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.ig$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0328ig.b(InterfaceC0579sg.this, th);
            }
        });
    }
}
