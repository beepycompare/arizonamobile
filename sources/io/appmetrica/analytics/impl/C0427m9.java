package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.m9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0427m9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0376k9 f966a;
    public final C0402l9 b;
    public final IBinaryDataHelper c;

    public C0427m9(Context context, C0398l5 c0398l5) {
        this(new C0402l9(), new C0376k9(), C0649v7.a(context).a(c0398l5));
    }

    public C0427m9(C0402l9 c0402l9, C0376k9 c0376k9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0402l9;
        this.f966a = c0376k9;
        this.c = iBinaryDataHelper;
    }
}
