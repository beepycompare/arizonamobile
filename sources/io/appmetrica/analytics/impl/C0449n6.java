package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.n6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0449n6 extends MessageNano {
    public static volatile C0449n6[] c;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f953a;
    public C0548r6 b;

    public C0449n6() {
        a();
    }

    public static C0449n6[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0449n6[0];
                }
            }
        }
        return c;
    }

    public final C0449n6 a() {
        this.f953a = WireFormatNano.EMPTY_BYTES;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f953a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f953a);
        }
        C0548r6 c0548r6 = this.b;
        return c0548r6 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0548r6) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f953a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f953a);
        }
        C0548r6 c0548r6 = this.b;
        if (c0548r6 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0548r6);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0449n6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f953a = codedInputByteBufferNano.readBytes();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0548r6();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0449n6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0449n6().mergeFrom(codedInputByteBufferNano);
    }

    public static C0449n6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0449n6) MessageNano.mergeFrom(new C0449n6(), bArr);
    }
}
