package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* renamed from: io.appmetrica.analytics.impl.c5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0181c5 implements InterfaceC0508p7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f779a;
    public final String b;

    public C0181c5(C0406l5 c0406l5) {
        String b;
        if (c0406l5.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = c0406l5.b();
        }
        this.f779a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + c0406l5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0508p7
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0508p7
    public final String b() {
        return this.f779a;
    }
}
