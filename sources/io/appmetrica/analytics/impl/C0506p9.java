package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0506p9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0454n9 f1029a;
    public final C0480o9 b;
    public final IBinaryDataHelper c;

    public C0506p9(Context context, C0476o5 c0476o5) {
        this(new C0480o9(), new C0454n9(), C0728y7.a(context).a(c0476o5));
    }

    public C0506p9(C0480o9 c0480o9, C0454n9 c0454n9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0480o9;
        this.f1029a = c0454n9;
        this.c = iBinaryDataHelper;
    }
}
