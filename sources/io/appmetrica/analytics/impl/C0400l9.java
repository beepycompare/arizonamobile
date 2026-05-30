package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.l9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0400l9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0348j9 f1077a;
    public final C0374k9 b;
    public final IBinaryDataHelper c;

    public C0400l9(Context context, C0267g5 c0267g5) {
        this(new C0374k9(), new C0348j9(), Na.k().B().a(context, c0267g5));
    }

    public C0400l9(C0374k9 c0374k9, C0348j9 c0348j9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0374k9;
        this.f1077a = c0348j9;
        this.c = iBinaryDataHelper;
    }
}
