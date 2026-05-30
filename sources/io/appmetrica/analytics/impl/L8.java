package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class L8 extends MessageNano {
    public static volatile L8[] c;

    /* renamed from: a  reason: collision with root package name */
    public G8 f643a;
    public I8 b;

    public L8() {
        a();
    }

    public static L8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new L8[0];
                }
            }
        }
        return c;
    }

    public final L8 a() {
        this.f643a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        G8 g8 = this.f643a;
        if (g8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, g8);
        }
        I8 i8 = this.b;
        return i8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, i8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        G8 g8 = this.f643a;
        if (g8 != null) {
            codedOutputByteBufferNano.writeMessage(1, g8);
        }
        I8 i8 = this.b;
        if (i8 != null) {
            codedOutputByteBufferNano.writeMessage(2, i8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final L8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f643a == null) {
                    this.f643a = new G8();
                }
                codedInputByteBufferNano.readMessage(this.f643a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new I8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static L8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new L8().mergeFrom(codedInputByteBufferNano);
    }

    public static L8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (L8) MessageNano.mergeFrom(new L8(), bArr);
    }
}
