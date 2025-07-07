package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.cn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0199cn {

    /* renamed from: a  reason: collision with root package name */
    public final C0625u0 f789a;
    public final Ao b;
    public final C0450n c;
    public final Uk d;
    public final X5 e;
    public final C0660va f;

    public C0199cn(C0625u0 c0625u0, Ao ao, C0450n c0450n, Uk uk, X5 x5, C0660va c0660va) {
        this.f789a = c0625u0;
        this.b = ao;
        this.c = c0450n;
        this.d = uk;
        this.e = x5;
        this.f = c0660va;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.cn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0199cn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0199cn(C0625u0 c0625u0, Ao ao) {
        this(c0625u0, ao, C0704x4.l().a(), C0704x4.l().o(), C0704x4.l().h(), C0704x4.l().k());
    }
}
