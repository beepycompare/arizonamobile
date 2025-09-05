package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.StateSerializer;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import java.io.IOException;
/* loaded from: classes4.dex */
public class Z8 implements StateSerializer {

    /* renamed from: a  reason: collision with root package name */
    public final StateSerializer f766a;
    public final AESEncrypter b;

    public Z8(StateSerializer<Object> stateSerializer, AESEncrypter aESEncrypter) {
        this.f766a = stateSerializer;
        this.b = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return this.f766a.defaultValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final byte[] toByteArray(Object obj) {
        try {
            return this.b.encrypt(this.f766a.toByteArray(obj));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object toState(byte[] bArr) throws IOException {
        try {
            return this.f766a.toState(this.b.decrypt(bArr));
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
