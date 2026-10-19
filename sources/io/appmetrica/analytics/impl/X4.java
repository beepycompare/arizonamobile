package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* loaded from: classes5.dex */
public final class X4 implements InterfaceC0469o7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f841a;
    public final String b;

    public X4(C0260g5 c0260g5) {
        String b;
        if (c0260g5.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = c0260g5.b();
        }
        this.f841a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + c0260g5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0469o7
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0469o7
    public final String b() {
        return this.f841a;
    }
}
