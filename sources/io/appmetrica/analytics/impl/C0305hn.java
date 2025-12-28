package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.hn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0305hn {

    /* renamed from: a  reason: collision with root package name */
    public final C0734z0 f1027a;
    public final Io b;
    public final C0459o c;
    public final Xk d;
    public final F5 e;
    public final C0189da f;

    public C0305hn(C0734z0 c0734z0, Io io2, C0459o c0459o, Xk xk, F5 f5, C0189da c0189da) {
        this.f1027a = c0734z0;
        this.b = io2;
        this.c = c0459o;
        this.d = xk;
        this.e = f5;
        this.f = c0189da;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.hn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0305hn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0305hn(C0734z0 c0734z0, Io io2) {
        this(c0734z0, io2, C0157c4.l().a(), C0157c4.l().o(), C0157c4.l().h(), C0157c4.l().k());
    }
}
