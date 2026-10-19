package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* loaded from: classes5.dex */
public final class Hn {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f588a;
    public final lp b;
    public final C0461o c;
    public final Bl d;
    public final U5 e;
    public final C0757za f;

    public Hn(B0 b0, lp lpVar, C0461o c0461o, Bl bl, U5 u5, C0757za c0757za) {
        this.f588a = b0;
        this.b = lpVar;
        this.c = c0461o;
        this.d = bl;
        this.e = u5;
        this.f = c0757za;
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
        this(b0, lpVar, C0569s4.l().a(), C0569s4.l().o(), C0569s4.l().h(), C0569s4.l().k());
    }
}
