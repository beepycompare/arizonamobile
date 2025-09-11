package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.on  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0494on {

    /* renamed from: a  reason: collision with root package name */
    public final C0671w0 f1025a;
    public final Mo b;
    public final C0444n c;
    public final C0285gl d;
    public final C0193d6 e;
    public final Ca f;

    public C0494on(C0671w0 c0671w0, Mo mo, C0444n c0444n, C0285gl c0285gl, C0193d6 c0193d6, Ca ca) {
        this.f1025a = c0671w0;
        this.b = mo;
        this.c = c0444n;
        this.d = c0285gl;
        this.e = c0193d6;
        this.f = ca;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.on$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0494on.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0494on(C0671w0 c0671w0, Mo mo) {
        this(c0671w0, mo, A4.l().a(), A4.l().o(), A4.l().h(), A4.l().k());
    }
}
