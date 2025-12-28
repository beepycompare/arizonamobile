package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.om  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0482om extends MessageNano {
    public static volatile C0482om[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0457nm[] f1153a;

    public C0482om() {
        a();
    }

    public static C0482om[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0482om[0];
                }
            }
        }
        return b;
    }

    public final C0482om a() {
        this.f1153a = C0457nm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0457nm[] c0457nmArr = this.f1153a;
        if (c0457nmArr != null && c0457nmArr.length > 0) {
            int i = 0;
            while (true) {
                C0457nm[] c0457nmArr2 = this.f1153a;
                if (i >= c0457nmArr2.length) {
                    break;
                }
                C0457nm c0457nm = c0457nmArr2[i];
                if (c0457nm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0457nm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0457nm[] c0457nmArr = this.f1153a;
        if (c0457nmArr != null && c0457nmArr.length > 0) {
            int i = 0;
            while (true) {
                C0457nm[] c0457nmArr2 = this.f1153a;
                if (i >= c0457nmArr2.length) {
                    break;
                }
                C0457nm c0457nm = c0457nmArr2[i];
                if (c0457nm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0457nm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0482om mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0457nm[] c0457nmArr = this.f1153a;
                int length = c0457nmArr == null ? 0 : c0457nmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0457nm[] c0457nmArr2 = new C0457nm[i];
                if (length != 0) {
                    System.arraycopy(c0457nmArr, 0, c0457nmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0457nm c0457nm = new C0457nm();
                    c0457nmArr2[length] = c0457nm;
                    codedInputByteBufferNano.readMessage(c0457nm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0457nm c0457nm2 = new C0457nm();
                c0457nmArr2[length] = c0457nm2;
                codedInputByteBufferNano.readMessage(c0457nm2);
                this.f1153a = c0457nmArr2;
            }
        }
        return this;
    }

    public static C0482om b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0482om().mergeFrom(codedInputByteBufferNano);
    }

    public static C0482om a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0482om) MessageNano.mergeFrom(new C0482om(), bArr);
    }
}
