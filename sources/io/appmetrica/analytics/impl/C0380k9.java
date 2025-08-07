package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0380k9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0331i9 f924a;
    public final C0355j9 b;
    public final IBinaryDataHelper c;

    public C0380k9(Context context, C0401l5 c0401l5) {
        this(new C0355j9(), new C0331i9(), C0627u7.a(context).a(c0401l5));
    }

    public C0380k9(C0355j9 c0355j9, C0331i9 c0331i9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0355j9;
        this.f924a = c0331i9;
        this.c = iBinaryDataHelper;
    }
}
