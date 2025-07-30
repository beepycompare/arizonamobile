package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class M8 extends MessageNano {
    public static volatile M8[] c;

    /* renamed from: a  reason: collision with root package name */
    public H8 f547a;
    public J8 b;

    public M8() {
        a();
    }

    public static M8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new M8[0];
                }
            }
        }
        return c;
    }

    public final M8 a() {
        this.f547a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        H8 h8 = this.f547a;
        if (h8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, h8);
        }
        J8 j8 = this.b;
        return j8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, j8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        H8 h8 = this.f547a;
        if (h8 != null) {
            codedOutputByteBufferNano.writeMessage(1, h8);
        }
        J8 j8 = this.b;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(2, j8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final M8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f547a == null) {
                    this.f547a = new H8();
                }
                codedInputByteBufferNano.readMessage(this.f547a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new J8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static M8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new M8().mergeFrom(codedInputByteBufferNano);
    }

    public static M8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (M8) MessageNano.mergeFrom(new M8(), bArr);
    }
}
