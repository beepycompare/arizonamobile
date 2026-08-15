package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
/* loaded from: classes5.dex */
public final class Gm {

    /* renamed from: a  reason: collision with root package name */
    public final ProtobufStateStorage f568a;
    public final Zo b;

    public Gm(ProtobufStateStorage protobufStateStorage, Zo zo) {
        this.f568a = protobufStateStorage;
        this.b = zo;
    }

    public Gm(Context context) {
        this(((AbstractC0620tn) C0568rn.a(Lm.class)).create(context), Na.k().D().a());
    }
}
