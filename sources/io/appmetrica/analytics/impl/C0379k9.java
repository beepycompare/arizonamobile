package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.k9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0379k9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0330i9 f924a;
    public final C0354j9 b;
    public final IBinaryDataHelper c;

    public C0379k9(Context context, C0400l5 c0400l5) {
        this(new C0354j9(), new C0330i9(), C0626u7.a(context).a(c0400l5));
    }

    public C0379k9(C0354j9 c0354j9, C0330i9 c0330i9, IBinaryDataHelper iBinaryDataHelper) {
        this.b = c0354j9;
        this.f924a = c0330i9;
        this.c = iBinaryDataHelper;
    }
}
