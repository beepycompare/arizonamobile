package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.gn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0283gn {

    /* renamed from: a  reason: collision with root package name */
    public final C0737z0 f1018a;
    public final Ho b;
    public final C0462o c;
    public final Wk d;
    public final E5 e;
    public final C0167ca f;

    public C0283gn(C0737z0 c0737z0, Ho ho, C0462o c0462o, Wk wk, E5 e5, C0167ca c0167ca) {
        this.f1018a = c0737z0;
        this.b = ho;
        this.c = c0462o;
        this.d = wk;
        this.e = e5;
        this.f = c0167ca;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.gn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0283gn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0283gn(C0737z0 c0737z0, Ho ho) {
        this(c0737z0, ho, C0135b4.l().a(), C0135b4.l().o(), C0135b4.l().h(), C0135b4.l().k());
    }
}
