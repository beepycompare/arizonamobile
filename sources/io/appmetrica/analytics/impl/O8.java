package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class O8 extends MessageNano {
    public static volatile O8[] c;

    /* renamed from: a  reason: collision with root package name */
    public J8 f588a;
    public L8 b;

    public O8() {
        a();
    }

    public static O8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new O8[0];
                }
            }
        }
        return c;
    }

    public final O8 a() {
        this.f588a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        J8 j8 = this.f588a;
        if (j8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, j8);
        }
        L8 l8 = this.b;
        return l8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, l8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        J8 j8 = this.f588a;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(1, j8);
        }
        L8 l8 = this.b;
        if (l8 != null) {
            codedOutputByteBufferNano.writeMessage(2, l8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final O8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f588a == null) {
                    this.f588a = new J8();
                }
                codedInputByteBufferNano.readMessage(this.f588a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new L8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static O8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new O8().mergeFrom(codedInputByteBufferNano);
    }

    public static O8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (O8) MessageNano.mergeFrom(new O8(), bArr);
    }
}
