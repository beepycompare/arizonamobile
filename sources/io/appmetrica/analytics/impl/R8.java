package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class R8 extends MessageNano {
    public static volatile R8[] c;

    /* renamed from: a  reason: collision with root package name */
    public M8 f653a;
    public O8 b;

    public R8() {
        a();
    }

    public static R8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new R8[0];
                }
            }
        }
        return c;
    }

    public final R8 a() {
        this.f653a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        M8 m8 = this.f653a;
        if (m8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, m8);
        }
        O8 o8 = this.b;
        return o8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, o8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        M8 m8 = this.f653a;
        if (m8 != null) {
            codedOutputByteBufferNano.writeMessage(1, m8);
        }
        O8 o8 = this.b;
        if (o8 != null) {
            codedOutputByteBufferNano.writeMessage(2, o8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final R8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f653a == null) {
                    this.f653a = new M8();
                }
                codedInputByteBufferNano.readMessage(this.f653a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new O8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static R8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new R8().mergeFrom(codedInputByteBufferNano);
    }

    public static R8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (R8) MessageNano.mergeFrom(new R8(), bArr);
    }
}
