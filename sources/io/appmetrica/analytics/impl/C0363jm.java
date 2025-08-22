package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0363jm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f928a;
    public final yo b;

    public C0363jm(ProtobufStateStorage protobufStateStorage, yo yoVar) {
        this.f928a = protobufStateStorage;
        this.b = yoVar;
    }

    public C0363jm(Context context) {
        this(Vm.a(C0490om.class).a(context), Ka.j().B().a());
    }
}
