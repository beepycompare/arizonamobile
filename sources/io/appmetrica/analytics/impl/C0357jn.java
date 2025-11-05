package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
/* renamed from: io.appmetrica.analytics.impl.jn  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0357jn {

    /* renamed from: a  reason: collision with root package name */
    public final C0685x0 f960a;
    public final Io b;
    public final C0460o c;
    public final C0149bl d;
    public final L5 e;
    public final C0344ja f;

    public C0357jn(C0685x0 c0685x0, Io io2, C0460o c0460o, C0149bl c0149bl, L5 l5, C0344ja c0344ja) {
        this.f960a = c0685x0;
        this.b = io2;
        this.c = c0460o;
        this.d = c0149bl;
        this.e = l5;
        this.f = c0344ja;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.jn$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C0357jn.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C0357jn(C0685x0 c0685x0, Io io2) {
        this(c0685x0, io2, C0338j4.l().a(), C0338j4.l().o(), C0338j4.l().h(), C0338j4.l().k());
    }
}
