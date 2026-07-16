package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Lo extends MessageNano {
    public static volatile Lo[] b;

    /* renamed from: a  reason: collision with root package name */
    public Io[] f655a;

    public Lo() {
        a();
    }

    public static Lo[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Lo[0];
                }
            }
        }
        return b;
    }

    public final Lo a() {
        this.f655a = Io.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Io[] ioArr = this.f655a;
        if (ioArr != null && ioArr.length > 0) {
            int i = 0;
            while (true) {
                Io[] ioArr2 = this.f655a;
                if (i >= ioArr2.length) {
                    break;
                }
                Io io2 = ioArr2[i];
                if (io2 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, io2) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Io[] ioArr = this.f655a;
        if (ioArr != null && ioArr.length > 0) {
            int i = 0;
            while (true) {
                Io[] ioArr2 = this.f655a;
                if (i >= ioArr2.length) {
                    break;
                }
                Io io2 = ioArr2[i];
                if (io2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, io2);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Lo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Io[] ioArr = this.f655a;
                int length = ioArr == null ? 0 : ioArr.length;
                int i = repeatedFieldArrayLength + length;
                Io[] ioArr2 = new Io[i];
                if (length != 0) {
                    System.arraycopy(ioArr, 0, ioArr2, 0, length);
                }
                while (length < i - 1) {
                    Io io2 = new Io();
                    ioArr2[length] = io2;
                    codedInputByteBufferNano.readMessage(io2);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Io io3 = new Io();
                ioArr2[length] = io3;
                codedInputByteBufferNano.readMessage(io3);
                this.f655a = ioArr2;
            }
        }
        return this;
    }

    public static Lo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Lo().mergeFrom(codedInputByteBufferNano);
    }

    public static Lo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Lo) MessageNano.mergeFrom(new Lo(), bArr);
    }
}
