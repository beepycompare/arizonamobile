package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0230em {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f983a;
    public final wo b;

    public C0230em(ProtobufStateStorage protobufStateStorage, wo woVar) {
        this.f983a = protobufStateStorage;
        this.b = woVar;
    }

    public C0230em(Context context) {
        this(((Rm) Pm.a(C0359jm.class)).create(context), C0448na.k().D().a());
    }
}
