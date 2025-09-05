package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class H8 extends MessageNano {
    public static volatile H8[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f470a;
    public D8 b;

    public H8() {
        a();
    }

    public static H8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new H8[0];
                }
            }
        }
        return c;
    }

    public final H8 a() {
        this.f470a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f470a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        D8 d8 = this.b;
        return d8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, d8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f470a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        D8 d8 = this.b;
        if (d8 != null) {
            codedOutputByteBufferNano.writeMessage(2, d8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final H8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f470a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new D8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static H8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new H8().mergeFrom(codedInputByteBufferNano);
    }

    public static H8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (H8) MessageNano.mergeFrom(new H8(), bArr);
    }
}
