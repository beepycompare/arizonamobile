package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.StateSerializer;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import java.io.IOException;
/* loaded from: classes4.dex */
public class U8 implements StateSerializer {

    /* renamed from: a  reason: collision with root package name */
    public final StateSerializer f667a;
    public final AESEncrypter b;

    public U8(StateSerializer<Object> stateSerializer, AESEncrypter aESEncrypter) {
        this.f667a = stateSerializer;
        this.b = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return this.f667a.defaultValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final byte[] toByteArray(Object obj) {
        try {
            return this.b.encrypt(this.f667a.toByteArray(obj));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object toState(byte[] bArr) throws IOException {
        try {
            return this.f667a.toState(this.b.decrypt(bArr));
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
