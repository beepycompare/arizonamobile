package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class G8 extends MessageNano {
    public static volatile G8[] d;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f442a;
    public byte[] b;
    public H8 c;

    public G8() {
        a();
    }

    public static G8[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new G8[0];
                }
            }
        }
        return d;
    }

    public final G8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f442a = bArr;
        this.b = bArr;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f442a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f442a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        H8 h8 = this.c;
        return h8 != null ? CodedOutputByteBufferNano.computeMessageSize(3, h8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f442a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f442a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        H8 h8 = this.c;
        if (h8 != null) {
            codedOutputByteBufferNano.writeMessage(3, h8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final G8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f442a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new H8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static G8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new G8().mergeFrom(codedInputByteBufferNano);
    }

    public static G8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (G8) MessageNano.mergeFrom(new G8(), bArr);
    }
}
