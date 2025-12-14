package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.wm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0681wm extends MessageNano {
    public static volatile C0681wm[] b;

    /* renamed from: a  reason: collision with root package name */
    public long f1284a;

    public C0681wm() {
        a();
    }

    public static C0681wm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0681wm[0];
                }
            }
        }
        return b;
    }

    public final C0681wm a() {
        this.f1284a = 18000000L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt64Size(1, this.f1284a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt64(1, this.f1284a);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0681wm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.f1284a = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static C0681wm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0681wm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0681wm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0681wm) MessageNano.mergeFrom(new C0681wm(), bArr);
    }
}
