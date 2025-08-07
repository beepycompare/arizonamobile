package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.fn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0269fn {

    /* renamed from: a  reason: collision with root package name */
    public final C0620u0 f852a;
    public final Do b;
    public final C0445n c;
    public final Xk d;
    public final C0123a6 e;
    public final C0705xa f;

    public C0269fn(C0620u0 c0620u0, Do r2, C0445n c0445n, Xk xk, C0123a6 c0123a6, C0705xa c0705xa) {
        this.f852a = c0620u0;
        this.b = r2;
        this.c = c0445n;
        this.d = xk;
        this.e = c0123a6;
        this.f = c0705xa;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.fn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0269fn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0269fn(C0620u0 c0620u0, Do r10) {
        this(c0620u0, r10, C0699x4.l().a(), C0699x4.l().o(), C0699x4.l().h(), C0699x4.l().k());
    }
}
