package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.gn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0284gn {

    /* renamed from: a  reason: collision with root package name */
    public final C0738z0 f1019a;
    public final Ho b;
    public final C0463o c;
    public final Wk d;
    public final E5 e;
    public final C0168ca f;

    public C0284gn(C0738z0 c0738z0, Ho ho, C0463o c0463o, Wk wk, E5 e5, C0168ca c0168ca) {
        this.f1019a = c0738z0;
        this.b = ho;
        this.c = c0463o;
        this.d = wk;
        this.e = e5;
        this.f = c0168ca;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.gn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0284gn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0284gn(C0738z0 c0738z0, Ho ho) {
        this(c0738z0, ho, C0136b4.l().a(), C0136b4.l().o(), C0136b4.l().h(), C0136b4.l().k());
    }
}
