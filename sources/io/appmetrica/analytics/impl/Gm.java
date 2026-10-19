package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Gm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f571a;
    public final Zo b;

    public Gm(ProtobufStateStorage protobufStateStorage, Zo zo) {
        this.f571a = protobufStateStorage;
        this.b = zo;
    }

    public Gm(Context context) {
        this(((AbstractC0614tn) C0562rn.a(Lm.class)).create(context), Na.k().D().a());
    }
}
