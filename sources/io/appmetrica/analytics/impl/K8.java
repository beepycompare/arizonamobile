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
public final class K8 extends MessageNano {
    public static volatile K8[] e;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f519a;
    public C0752z8 b;
    public byte[] c;
    public F8 d;

    public K8() {
        a();
    }

    public static K8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new K8[0];
                }
            }
        }
        return e;
    }

    public final K8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f519a = bArr;
        this.b = null;
        this.c = bArr;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f519a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f519a);
        }
        C0752z8 c0752z8 = this.b;
        if (c0752z8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0752z8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        F8 f8 = this.d;
        return f8 != null ? CodedOutputByteBufferNano.computeMessageSize(4, f8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f519a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f519a);
        }
        C0752z8 c0752z8 = this.b;
        if (c0752z8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0752z8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        F8 f8 = this.d;
        if (f8 != null) {
            codedOutputByteBufferNano.writeMessage(4, f8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final K8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f519a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new C0752z8();
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
                    this.d = new F8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static K8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new K8().mergeFrom(codedInputByteBufferNano);
    }

    public static K8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (K8) MessageNano.mergeFrom(new K8(), bArr);
    }
}
