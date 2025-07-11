package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class M extends MessageNano {
    public static volatile M[] c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1279a;
    public long b;

    public M() {
        a();
    }

    public static M[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new M[0];
                }
            }
        }
        return c;
    }

    public final M a() {
        this.f1279a = true;
        this.b = 1L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f1279a;
        if (!z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.b;
        return j != 1 ? CodedOutputByteBufferNano.computeInt64Size(2, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f1279a;
        if (!z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.b;
        if (j != 1) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final M mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1279a = codedInputByteBufferNano.readBool();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readInt64();
            }
        }
        return this;
    }

    public static M b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new M().mergeFrom(codedInputByteBufferNano);
    }

    public static M a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (M) MessageNano.mergeFrom(new M(), bArr);
    }
}
