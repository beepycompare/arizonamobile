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
public final class C0335io extends MessageNano {
    public static volatile C0335io[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0258fo[] f1051a;

    public C0335io() {
        a();
    }

    public static C0335io[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0335io[0];
                }
            }
        }
        return b;
    }

    public final C0335io a() {
        this.f1051a = C0258fo.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0258fo[] c0258foArr = this.f1051a;
        if (c0258foArr != null && c0258foArr.length > 0) {
            int i = 0;
            while (true) {
                C0258fo[] c0258foArr2 = this.f1051a;
                if (i >= c0258foArr2.length) {
                    break;
                }
                C0258fo c0258fo = c0258foArr2[i];
                if (c0258fo != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0258fo) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0258fo[] c0258foArr = this.f1051a;
        if (c0258foArr != null && c0258foArr.length > 0) {
            int i = 0;
            while (true) {
                C0258fo[] c0258foArr2 = this.f1051a;
                if (i >= c0258foArr2.length) {
                    break;
                }
                C0258fo c0258fo = c0258foArr2[i];
                if (c0258fo != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0258fo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0335io mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0258fo[] c0258foArr = this.f1051a;
                int length = c0258foArr == null ? 0 : c0258foArr.length;
                int i = repeatedFieldArrayLength + length;
                C0258fo[] c0258foArr2 = new C0258fo[i];
                if (length != 0) {
                    System.arraycopy(c0258foArr, 0, c0258foArr2, 0, length);
                }
                while (length < i - 1) {
                    C0258fo c0258fo = new C0258fo();
                    c0258foArr2[length] = c0258fo;
                    codedInputByteBufferNano.readMessage(c0258fo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0258fo c0258fo2 = new C0258fo();
                c0258foArr2[length] = c0258fo2;
                codedInputByteBufferNano.readMessage(c0258fo2);
                this.f1051a = c0258foArr2;
            }
        }
        return this;
    }

    public static C0335io b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0335io().mergeFrom(codedInputByteBufferNano);
    }

    public static C0335io a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0335io) MessageNano.mergeFrom(new C0335io(), bArr);
    }
}
