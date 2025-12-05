package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.StateSerializer;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import java.io.IOException;
/* loaded from: classes5.dex */
public class C8 implements StateSerializer {

    /* renamed from: a  reason: collision with root package name */
    public final StateSerializer f509a;
    public final AESEncrypter b;

    public C8(StateSerializer<Object> stateSerializer, AESEncrypter aESEncrypter) {
        this.f509a = stateSerializer;
        this.b = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return this.f509a.defaultValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final byte[] toByteArray(Object obj) {
        try {
            return this.b.encrypt(this.f509a.toByteArray(obj));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object toState(byte[] bArr) throws IOException {
        try {
            return this.f509a.toState(this.b.decrypt(bArr));
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
