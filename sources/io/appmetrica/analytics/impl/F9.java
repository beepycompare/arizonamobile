package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class F9 extends MessageNano {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static volatile F9[] g;

    /* renamed from: a  reason: collision with root package name */
    public I9 f438a;
    public String b;
    public int c;

    public F9() {
        a();
    }

    public static F9[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new F9[0];
                }
            }
        }
        return g;
    }

    public final F9 a() {
        this.f438a = null;
        this.b = "";
        this.c = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        I9 i9 = this.f438a;
        if (i9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, i9);
        }
        int computeStringSize = CodedOutputByteBufferNano.computeStringSize(2, this.b) + computeSerializedSize;
        int i = this.c;
        return i != 0 ? CodedOutputByteBufferNano.computeInt32Size(5, i) + computeStringSize : computeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        I9 i9 = this.f438a;
        if (i9 != null) {
            codedOutputByteBufferNano.writeMessage(1, i9);
        }
        codedOutputByteBufferNano.writeString(2, this.b);
        int i = this.c;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final F9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f438a == null) {
                    this.f438a = new I9();
                }
                codedInputByteBufferNano.readMessage(this.f438a);
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.c = readInt32;
                }
            }
        }
        return this;
    }

    public static F9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new F9().mergeFrom(codedInputByteBufferNano);
    }

    public static F9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (F9) MessageNano.mergeFrom(new F9(), bArr);
    }
}
