package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.w8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0668w8 extends MessageNano {
    public static volatile C0668w8[] e;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1182a;
    public C0394l8 b;
    public byte[] c;
    public C0543r8 d;

    public C0668w8() {
        a();
    }

    public static C0668w8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0668w8[0];
                }
            }
        }
        return e;
    }

    public final C0668w8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f1182a = bArr;
        this.b = null;
        this.c = bArr;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f1182a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f1182a);
        }
        C0394l8 c0394l8 = this.b;
        if (c0394l8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0394l8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        C0543r8 c0543r8 = this.d;
        return c0543r8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0543r8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f1182a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f1182a);
        }
        C0394l8 c0394l8 = this.b;
        if (c0394l8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0394l8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        C0543r8 c0543r8 = this.d;
        if (c0543r8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0543r8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0668w8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1182a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0394l8();
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
                    this.d = new C0543r8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0668w8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0668w8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0668w8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0668w8) MessageNano.mergeFrom(new C0668w8(), bArr);
    }
}
