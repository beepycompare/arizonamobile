package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0398l9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0346j9 f1079a;
    public final C0372k9 b;
    public final IBinaryDataHelper c;

    public C0398l9(Context context, C0265g5 c0265g5) {
        this(new C0372k9(), new C0346j9(), Na.k().B().a(context, c0265g5));
    }

    public C0398l9(C0372k9 c0372k9, C0346j9 c0346j9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0372k9;
        this.f1079a = c0346j9;
        this.c = iBinaryDataHelper;
    }
}
