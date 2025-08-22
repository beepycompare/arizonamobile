package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.kn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0390kn {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f943a;
    public final Io b;
    public final C0442n c;
    public final C0182cl d;
    public final C0115a6 e;
    public final C0752za f;

    public C0390kn(C0617u0 c0617u0, Io io2, C0442n c0442n, C0182cl c0182cl, C0115a6 c0115a6, C0752za c0752za) {
        this.f943a = c0617u0;
        this.b = io2;
        this.c = c0442n;
        this.d = c0182cl;
        this.e = c0115a6;
        this.f = c0752za;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.kn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0390kn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0390kn(C0617u0 c0617u0, Io io2) {
        this(c0617u0, io2, C0696x4.l().a(), C0696x4.l().o(), C0696x4.l().h(), C0696x4.l().k());
    }
}
