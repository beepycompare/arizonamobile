package io.appmetrica.analytics.impl;

import java.util.Arrays;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* renamed from: io.appmetrica.analytics.impl.c5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0166c5 implements InterfaceC0599t7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f805a;
    public final String b;

    public C0166c5(C0398l5 c0398l5) {
        String b;
        if (c0398l5.d()) {
            b = JvmProtoBufUtil.DEFAULT_MODULE_NAME;
        } else {
            b = c0398l5.b();
        }
        this.f805a = String.format("component_%s.db", Arrays.copyOf(new Object[]{b}, 1));
        this.b = "db_metrica_" + c0398l5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0599t7
    public final String a() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0599t7
    public final String b() {
        return this.f805a;
    }
}
