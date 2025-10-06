package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0507p9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0455n9 f1034a;
    public final C0481o9 b;
    public final IBinaryDataHelper c;

    public C0507p9(Context context, C0477o5 c0477o5) {
        this(new C0481o9(), new C0455n9(), C0729y7.a(context).a(c0477o5));
    }

    public C0507p9(C0481o9 c0481o9, C0455n9 c0455n9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0481o9;
        this.f1034a = c0455n9;
        this.c = iBinaryDataHelper;
    }
}
