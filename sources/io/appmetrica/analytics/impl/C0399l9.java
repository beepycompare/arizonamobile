package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0399l9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0347j9 f1079a;
    public final C0373k9 b;
    public final IBinaryDataHelper c;

    public C0399l9(Context context, C0266g5 c0266g5) {
        this(new C0373k9(), new C0347j9(), Na.k().B().a(context, c0266g5));
    }

    public C0399l9(C0373k9 c0373k9, C0347j9 c0347j9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0373k9;
        this.f1079a = c0347j9;
        this.c = iBinaryDataHelper;
    }
}
