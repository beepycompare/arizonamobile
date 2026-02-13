package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.c8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0166c8 extends MessageNano {
    public static volatile C0166c8[] c;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f932a;
    public C0269g8 b;

    public C0166c8() {
        a();
    }

    public static C0166c8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0166c8[0];
                }
            }
        }
        return c;
    }

    public final C0166c8 a() {
        this.f932a = WireFormatNano.EMPTY_BYTES;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f932a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f932a);
        }
        C0269g8 c0269g8 = this.b;
        return c0269g8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0269g8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f932a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f932a);
        }
        C0269g8 c0269g8 = this.b;
        if (c0269g8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0269g8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0166c8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f932a = codedInputByteBufferNano.readBytes();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0269g8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0166c8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0166c8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0166c8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0166c8) MessageNano.mergeFrom(new C0166c8(), bArr);
    }
}
