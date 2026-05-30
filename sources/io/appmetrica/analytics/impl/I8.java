package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class I8 extends MessageNano {
    public static volatile I8[] d;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f591a;
    public byte[] b;
    public J8 c;

    public I8() {
        a();
    }

    public static I8[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new I8[0];
                }
            }
        }
        return d;
    }

    public final I8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f591a = bArr;
        this.b = bArr;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f591a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f591a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        J8 j8 = this.c;
        return j8 != null ? CodedOutputByteBufferNano.computeMessageSize(3, j8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f591a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f591a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        J8 j8 = this.c;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(3, j8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final I8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f591a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new J8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static I8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new I8().mergeFrom(codedInputByteBufferNano);
    }

    public static I8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (I8) MessageNano.mergeFrom(new I8(), bArr);
    }
}
