package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class N8 extends MessageNano {
    public static volatile N8[] c;

    /* renamed from: a  reason: collision with root package name */
    public J8 f576a;
    public M8 b;

    public N8() {
        a();
    }

    public static N8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new N8[0];
                }
            }
        }
        return c;
    }

    public final N8 a() {
        this.f576a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        J8 j8 = this.f576a;
        if (j8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, j8);
        }
        M8 m8 = this.b;
        return m8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, m8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        J8 j8 = this.f576a;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(1, j8);
        }
        M8 m8 = this.b;
        if (m8 != null) {
            codedOutputByteBufferNano.writeMessage(2, m8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final N8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f576a == null) {
                    this.f576a = new J8();
                }
                codedInputByteBufferNano.readMessage(this.f576a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new M8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static N8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new N8().mergeFrom(codedInputByteBufferNano);
    }

    public static N8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (N8) MessageNano.mergeFrom(new N8(), bArr);
    }
}
