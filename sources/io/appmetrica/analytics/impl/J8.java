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
public final class J8 extends MessageNano {
    public static volatile J8[] e;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f609a;
    public C0736y8 b;
    public byte[] c;
    public E8 d;

    public J8() {
        a();
    }

    public static J8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new J8[0];
                }
            }
        }
        return e;
    }

    public final J8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f609a = bArr;
        this.b = null;
        this.c = bArr;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f609a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f609a);
        }
        C0736y8 c0736y8 = this.b;
        if (c0736y8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0736y8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        E8 e8 = this.d;
        return e8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, e8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f609a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f609a);
        }
        C0736y8 c0736y8 = this.b;
        if (c0736y8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0736y8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        E8 e8 = this.d;
        if (e8 != null) {
            codedOutputByteBufferNano.writeMessage(4, e8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final J8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f609a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0736y8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag == 26) {
                this.c = codedInputByteBufferNano.readBytes();
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new E8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static J8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new J8().mergeFrom(codedInputByteBufferNano);
    }

    public static J8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (J8) MessageNano.mergeFrom(new J8(), bArr);
    }
}
