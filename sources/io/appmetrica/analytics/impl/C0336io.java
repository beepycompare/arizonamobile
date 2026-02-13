package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.io  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0336io extends MessageNano {
    public static volatile C0336io[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0259fo[] f1051a;

    public C0336io() {
        a();
    }

    public static C0336io[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0336io[0];
                }
            }
        }
        return b;
    }

    public final C0336io a() {
        this.f1051a = C0259fo.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0259fo[] c0259foArr = this.f1051a;
        if (c0259foArr != null && c0259foArr.length > 0) {
            int i = 0;
            while (true) {
                C0259fo[] c0259foArr2 = this.f1051a;
                if (i >= c0259foArr2.length) {
                    break;
                }
                C0259fo c0259fo = c0259foArr2[i];
                if (c0259fo != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0259fo) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0259fo[] c0259foArr = this.f1051a;
        if (c0259foArr != null && c0259foArr.length > 0) {
            int i = 0;
            while (true) {
                C0259fo[] c0259foArr2 = this.f1051a;
                if (i >= c0259foArr2.length) {
                    break;
                }
                C0259fo c0259fo = c0259foArr2[i];
                if (c0259fo != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0259fo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0336io mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0259fo[] c0259foArr = this.f1051a;
                int length = c0259foArr == null ? 0 : c0259foArr.length;
                int i = repeatedFieldArrayLength + length;
                C0259fo[] c0259foArr2 = new C0259fo[i];
                if (length != 0) {
                    System.arraycopy(c0259foArr, 0, c0259foArr2, 0, length);
                }
                while (length < i - 1) {
                    C0259fo c0259fo = new C0259fo();
                    c0259foArr2[length] = c0259fo;
                    codedInputByteBufferNano.readMessage(c0259fo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0259fo c0259fo2 = new C0259fo();
                c0259foArr2[length] = c0259fo2;
                codedInputByteBufferNano.readMessage(c0259fo2);
                this.f1051a = c0259foArr2;
            }
        }
        return this;
    }

    public static C0336io b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0336io().mergeFrom(codedInputByteBufferNano);
    }

    public static C0336io a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0336io) MessageNano.mergeFrom(new C0336io(), bArr);
    }
}
