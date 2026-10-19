package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.ic  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0319ic implements InterfaceC0671w2 {

    /* renamed from: a  reason: collision with root package name */
    public final D4 f1036a;

    public C0319ic(D4 d4) {
        this.f1036a = d4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0671w2
    public final Io a(Go go, Io io2) {
        int i = go.b;
        int i2 = this.f1036a.f511a;
        if (i == i2) {
            if (((Io) ((HashMap) go.f573a.get(io2.b)).get(new String(io2.f605a))) != null) {
                ((HashMap) go.f573a.get(io2.b)).put(new String(io2.f605a), io2);
                return io2;
            }
        } else if (i < i2) {
            ((HashMap) go.f573a.get(io2.b)).put(new String(io2.f605a), io2);
            go.b++;
        }
        return io2;
    }
}
