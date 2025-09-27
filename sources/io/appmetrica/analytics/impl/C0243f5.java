package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* renamed from: io.appmetrica.analytics.impl.f5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0243f5 implements InterfaceC0678w7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f873a;
    public final String b;

    public C0243f5(C0476o5 c0476o5) {
        String b;
        if (c0476o5.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = c0476o5.b();
        }
        this.f873a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + c0476o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0678w7
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0678w7
    public final String b() {
        return this.f873a;
    }
}
