package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.im  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0330im {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f939a;
    public final yo b;

    public C0330im(ProtobufStateStorage protobufStateStorage, yo yoVar) {
        this.f939a = protobufStateStorage;
        this.b = yoVar;
    }

    public C0330im(Context context) {
        this(((Vm) Tm.a(C0458nm.class)).create(context), C0620ua.k().D().a());
    }
}
