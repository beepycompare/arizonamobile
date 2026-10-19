package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0393l9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0341j9 f1082a;
    public final C0367k9 b;
    public final IBinaryDataHelper c;

    public C0393l9(Context context, C0260g5 c0260g5) {
        this(new C0367k9(), new C0341j9(), Na.k().B().a(context, c0260g5));
    }

    public C0393l9(C0367k9 c0367k9, C0341j9 c0341j9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0367k9;
        this.f1082a = c0341j9;
        this.c = iBinaryDataHelper;
    }
}
