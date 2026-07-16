package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* loaded from: classes5.dex */
public final class Hn {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f585a;
    public final lp b;
    public final C0468o c;
    public final Bl d;
    public final U5 e;
    public final C0764za f;

    public Hn(B0 b0, lp lpVar, C0468o c0468o, Bl bl, U5 u5, C0764za c0764za) {
        this.f585a = b0;
        this.b = lpVar;
        this.c = c0468o;
        this.d = bl;
        this.e = u5;
        this.f = c0764za;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.Hn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return Hn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public Hn(B0 b0, lp lpVar) {
        this(b0, lpVar, C0576s4.l().a(), C0576s4.l().o(), C0576s4.l().h(), C0576s4.l().k());
    }
}
