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
public final class C0483om extends MessageNano {
    public static volatile C0483om[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0458nm[] f1055a;

    public C0483om() {
        a();
    }

    public static C0483om[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0483om[0];
                }
            }
        }
        return b;
    }

    public final C0483om a() {
        this.f1055a = C0458nm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0458nm[] c0458nmArr = this.f1055a;
        if (c0458nmArr != null && c0458nmArr.length > 0) {
            int i = 0;
            while (true) {
                C0458nm[] c0458nmArr2 = this.f1055a;
                if (i >= c0458nmArr2.length) {
                    break;
                }
                C0458nm c0458nm = c0458nmArr2[i];
                if (c0458nm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0458nm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0458nm[] c0458nmArr = this.f1055a;
        if (c0458nmArr != null && c0458nmArr.length > 0) {
            int i = 0;
            while (true) {
                C0458nm[] c0458nmArr2 = this.f1055a;
                if (i >= c0458nmArr2.length) {
                    break;
                }
                C0458nm c0458nm = c0458nmArr2[i];
                if (c0458nm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0458nm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0483om mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0458nm[] c0458nmArr = this.f1055a;
                int length = c0458nmArr == null ? 0 : c0458nmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0458nm[] c0458nmArr2 = new C0458nm[i];
                if (length != 0) {
                    System.arraycopy(c0458nmArr, 0, c0458nmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0458nm c0458nm = new C0458nm();
                    c0458nmArr2[length] = c0458nm;
                    codedInputByteBufferNano.readMessage(c0458nm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0458nm c0458nm2 = new C0458nm();
                c0458nmArr2[length] = c0458nm2;
                codedInputByteBufferNano.readMessage(c0458nm2);
                this.f1055a = c0458nmArr2;
            }
        }
        return this;
    }

    public static C0483om b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0483om().mergeFrom(codedInputByteBufferNano);
    }

    public static C0483om a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0483om) MessageNano.mergeFrom(new C0483om(), bArr);
    }
}
