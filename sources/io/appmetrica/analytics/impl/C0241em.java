package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.em  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0241em implements InterfaceC0316hm {

    /* renamed from: a  reason: collision with root package name */
    public volatile C0190cm f826a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    @Override // io.appmetrica.analytics.impl.InterfaceC0316hm
    public final void a(C0190cm c0190cm) {
        this.f826a = c0190cm;
        for (InterfaceC0316hm interfaceC0316hm : this.b) {
            interfaceC0316hm.a(c0190cm);
        }
    }

    public final C0190cm b() {
        C0190cm c0190cm = this.f826a;
        if (c0190cm == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startupState");
            return null;
        }
        return c0190cm;
    }

    public final void b(InterfaceC0316hm interfaceC0316hm) {
        this.b.remove(interfaceC0316hm);
    }

    public final void a(InterfaceC0316hm interfaceC0316hm) {
        this.b.add(interfaceC0316hm);
        if (this.f826a != null) {
            C0190cm c0190cm = this.f826a;
            if (c0190cm == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startupState");
                c0190cm = null;
            }
            interfaceC0316hm.a(c0190cm);
        }
    }

    public final void a(Context context) {
        String optStringOrNull;
        ProtobufStateStorage<Object> a2 = Nm.a(C0291gm.class).a(context);
        qo a3 = Ga.j().B().a();
        synchronized (a3) {
            optStringOrNull = JsonUtils.optStringOrNull(a3.f1013a.a(), "device_id");
        }
        a(new C0190cm(optStringOrNull, a3.a(), (C0291gm) a2.read()));
    }
}
