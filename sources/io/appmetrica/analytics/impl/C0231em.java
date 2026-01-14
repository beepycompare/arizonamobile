package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0231em {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f984a;
    public final wo b;

    public C0231em(ProtobufStateStorage protobufStateStorage, wo woVar) {
        this.f984a = protobufStateStorage;
        this.b = woVar;
    }

    public C0231em(Context context) {
        this(((Rm) Pm.a(C0360jm.class)).create(context), C0449na.k().D().a());
    }
}
