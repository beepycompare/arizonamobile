package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
/* renamed from: io.appmetrica.analytics.impl.vg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0660vg implements InterfaceC0356jb {

    /* renamed from: a  reason: collision with root package name */
    public final ICommonExecutor f1103a;
    public final InstallReferrerClient b;

    public C0660vg(Context context, ICommonExecutor iCommonExecutor) {
        this.f1103a = iCommonExecutor;
        this.b = InstallReferrerClient.newBuilder(context).build();
    }

    public static final void b(Fg fg, Throwable th) {
        fg.a(th);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0356jb
    public final void a(Fg fg) throws Throwable {
        this.b.startConnection(new C0635ug(this, fg));
    }

    public final void a(final Fg fg, final Throwable th) {
        this.f1103a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.vg$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0660vg.b(Fg.this, th);
            }
        });
    }
}
