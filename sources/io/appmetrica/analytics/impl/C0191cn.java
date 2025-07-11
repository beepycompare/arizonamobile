package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.cn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0191cn {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f790a;
    public final Ao b;
    public final C0442n c;
    public final Uk d;
    public final X5 e;
    public final C0652va f;

    public C0191cn(C0617u0 c0617u0, Ao ao, C0442n c0442n, Uk uk, X5 x5, C0652va c0652va) {
        this.f790a = c0617u0;
        this.b = ao;
        this.c = c0442n;
        this.d = uk;
        this.e = x5;
        this.f = c0652va;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.cn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0191cn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0191cn(C0617u0 c0617u0, Ao ao) {
        this(c0617u0, ao, C0696x4.l().a(), C0696x4.l().o(), C0696x4.l().h(), C0696x4.l().k());
    }
}
