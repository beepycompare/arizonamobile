package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Q3 extends MessageNano {
    public static volatile Q3[] c;

    /* renamed from: a  reason: collision with root package name */
    public S3 f589a;
    public int b;

    public Q3() {
        a();
    }

    public static Q3[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new Q3[0];
                }
            }
        }
        return c;
    }

    public final Q3 a() {
        this.f589a = null;
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        S3 s3 = this.f589a;
        if (s3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, s3);
        }
        int i = this.b;
        return i != 0 ? CodedOutputByteBufferNano.computeInt32Size(2, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        S3 s3 = this.f589a;
        if (s3 != null) {
            codedOutputByteBufferNano.writeMessage(1, s3);
        }
        int i = this.b;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Q3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f589a == null) {
                    this.f589a = new S3();
                }
                codedInputByteBufferNano.readMessage(this.f589a);
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            }
        }
        return this;
    }

    public static Q3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Q3().mergeFrom(codedInputByteBufferNano);
    }

    public static Q3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Q3) MessageNano.mergeFrom(new Q3(), bArr);
    }
}
