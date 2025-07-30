package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0268fn {

    /* renamed from: a  reason: collision with root package name */
    public final C0619u0 f853a;
    public final Do b;
    public final C0444n c;
    public final Xk d;
    public final C0122a6 e;
    public final C0704xa f;

    public C0268fn(C0619u0 c0619u0, Do r2, C0444n c0444n, Xk xk, C0122a6 c0122a6, C0704xa c0704xa) {
        this.f853a = c0619u0;
        this.b = r2;
        this.c = c0444n;
        this.d = xk;
        this.e = c0122a6;
        this.f = c0704xa;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.fn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0268fn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0268fn(C0619u0 c0619u0, Do r10) {
        this(c0619u0, r10, C0698x4.l().a(), C0698x4.l().o(), C0698x4.l().h(), C0698x4.l().k());
    }
}
