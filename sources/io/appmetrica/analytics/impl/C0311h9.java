package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.h9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0311h9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0261f9 f865a;
    public final C0286g9 b;
    public final IBinaryDataHelper c;

    public C0311h9(Context context, C0406l5 c0406l5) {
        this(new C0286g9(), new C0261f9(), C0557r7.a(context).a(c0406l5));
    }

    public C0311h9(C0286g9 c0286g9, C0261f9 c0261f9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0286g9;
        this.f865a = c0261f9;
        this.c = iBinaryDataHelper;
    }
}
