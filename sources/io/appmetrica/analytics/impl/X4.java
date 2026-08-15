package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* loaded from: classes5.dex */
public final class X4 implements InterfaceC0475o7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f838a;
    public final String b;

    public X4(C0266g5 c0266g5) {
        String b;
        if (c0266g5.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = c0266g5.b();
        }
        this.f838a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + c0266g5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0475o7
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0475o7
    public final String b() {
        return this.f838a;
    }
}
