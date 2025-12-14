package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class P extends MessageNano {
    public static volatile P[] c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1444a;
    public long b;

    public P() {
        a();
    }

    public static P[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new P[0];
                }
            }
        }
        return c;
    }

    public final P a() {
        this.f1444a = true;
        this.b = 1L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f1444a;
        if (!z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.b;
        return j != 1 ? CodedOutputByteBufferNano.computeInt64Size(2, j) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f1444a;
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
    public final P mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1444a = codedInputByteBufferNano.readBool();
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

    public static P b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new P().mergeFrom(codedInputByteBufferNano);
    }

    public static P a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (P) MessageNano.mergeFrom(new P(), bArr);
    }
}
