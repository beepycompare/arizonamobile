package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.on  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0495on {

    /* renamed from: a  reason: collision with root package name */
    public final C0672w0 f1026a;
    public final Mo b;
    public final C0445n c;
    public final C0286gl d;
    public final C0194d6 e;
    public final Ca f;

    public C0495on(C0672w0 c0672w0, Mo mo, C0445n c0445n, C0286gl c0286gl, C0194d6 c0194d6, Ca ca) {
        this.f1026a = c0672w0;
        this.b = mo;
        this.c = c0445n;
        this.d = c0286gl;
        this.e = c0194d6;
        this.f = ca;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.on$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0495on.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0495on(C0672w0 c0672w0, Mo mo) {
        this(c0672w0, mo, A4.l().a(), A4.l().o(), A4.l().h(), A4.l().k());
    }
}
