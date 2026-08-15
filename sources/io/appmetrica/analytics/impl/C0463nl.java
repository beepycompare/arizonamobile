package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.nl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0463nl extends MessageNano {
    public static volatile C0463nl[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0489ol[] f1122a;

    public C0463nl() {
        a();
    }

    public static C0463nl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0463nl[0];
                }
            }
        }
        return b;
    }

    public final C0463nl a() {
        this.f1122a = C0489ol.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0489ol[] c0489olArr = this.f1122a;
        if (c0489olArr != null && c0489olArr.length > 0) {
            int i = 0;
            while (true) {
                C0489ol[] c0489olArr2 = this.f1122a;
                if (i >= c0489olArr2.length) {
                    break;
                }
                C0489ol c0489ol = c0489olArr2[i];
                if (c0489ol != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0489ol) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0489ol[] c0489olArr = this.f1122a;
        if (c0489olArr != null && c0489olArr.length > 0) {
            int i = 0;
            while (true) {
                C0489ol[] c0489olArr2 = this.f1122a;
                if (i >= c0489olArr2.length) {
                    break;
                }
                C0489ol c0489ol = c0489olArr2[i];
                if (c0489ol != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0489ol);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0463nl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0489ol[] c0489olArr = this.f1122a;
                int length = c0489olArr == null ? 0 : c0489olArr.length;
                int i = repeatedFieldArrayLength + length;
                C0489ol[] c0489olArr2 = new C0489ol[i];
                if (length != 0) {
                    System.arraycopy(c0489olArr, 0, c0489olArr2, 0, length);
                }
                while (length < i - 1) {
                    C0489ol c0489ol = new C0489ol();
                    c0489olArr2[length] = c0489ol;
                    codedInputByteBufferNano.readMessage(c0489ol);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0489ol c0489ol2 = new C0489ol();
                c0489olArr2[length] = c0489ol2;
                codedInputByteBufferNano.readMessage(c0489ol2);
                this.f1122a = c0489olArr2;
            }
        }
        return this;
    }

    public static C0463nl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0463nl().mergeFrom(codedInputByteBufferNano);
    }

    public static C0463nl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0463nl) MessageNano.mergeFrom(new C0463nl(), bArr);
    }
}
