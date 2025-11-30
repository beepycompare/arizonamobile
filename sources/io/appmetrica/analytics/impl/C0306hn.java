package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.hn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0306hn {

    /* renamed from: a  reason: collision with root package name */
    public final C0735z0 f929a;
    public final Io b;
    public final C0460o c;
    public final Xk d;
    public final F5 e;
    public final C0190da f;

    public C0306hn(C0735z0 c0735z0, Io io2, C0460o c0460o, Xk xk, F5 f5, C0190da c0190da) {
        this.f929a = c0735z0;
        this.b = io2;
        this.c = c0460o;
        this.d = xk;
        this.e = f5;
        this.f = c0190da;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.hn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0306hn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0306hn(C0735z0 c0735z0, Io io2) {
        this(c0735z0, io2, C0158c4.l().a(), C0158c4.l().o(), C0158c4.l().h(), C0158c4.l().k());
    }
}
