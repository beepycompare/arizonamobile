package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.ig  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0327ig implements Oa {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f1045a;
    public final InstallReferrerClient b;

    public C0327ig(Context context, ICommonExecutor iCommonExecutor) {
        this.f1045a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(InterfaceC0578sg interfaceC0578sg, Throwable th) {
        interfaceC0578sg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.Oa
    public final void a(InterfaceC0578sg interfaceC0578sg) throws Throwable {
        this.b.startConnection(new C0302hg(this, interfaceC0578sg));
    }

    public final void a(final InterfaceC0578sg interfaceC0578sg, final Throwable th) {
        this.f1045a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.ig$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0327ig.b(InterfaceC0578sg.this, th);
            }
        });
    }
}
