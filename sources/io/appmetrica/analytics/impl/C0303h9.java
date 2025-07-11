package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.h9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0303h9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0253f9 f866a;
    public final C0278g9 b;
    public final IBinaryDataHelper c;

    public C0303h9(Context context, C0398l5 c0398l5) {
        this(new C0278g9(), new C0253f9(), C0549r7.a(context).a(c0398l5));
    }

    public C0303h9(C0278g9 c0278g9, C0253f9 c0253f9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0278g9;
        this.f866a = c0253f9;
        this.c = iBinaryDataHelper;
    }
}
