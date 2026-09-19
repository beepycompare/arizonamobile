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
public final class C0462nl extends MessageNano {
    public static volatile C0462nl[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0488ol[] f1122a;

    public C0462nl() {
        a();
    }

    public static C0462nl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0462nl[0];
                }
            }
        }
        return b;
    }

    public final C0462nl a() {
        this.f1122a = C0488ol.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0488ol[] c0488olArr = this.f1122a;
        if (c0488olArr != null && c0488olArr.length > 0) {
            int i = 0;
            while (true) {
                C0488ol[] c0488olArr2 = this.f1122a;
                if (i >= c0488olArr2.length) {
                    break;
                }
                C0488ol c0488ol = c0488olArr2[i];
                if (c0488ol != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0488ol) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0488ol[] c0488olArr = this.f1122a;
        if (c0488olArr != null && c0488olArr.length > 0) {
            int i = 0;
            while (true) {
                C0488ol[] c0488olArr2 = this.f1122a;
                if (i >= c0488olArr2.length) {
                    break;
                }
                C0488ol c0488ol = c0488olArr2[i];
                if (c0488ol != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0488ol);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0462nl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0488ol[] c0488olArr = this.f1122a;
                int length = c0488olArr == null ? 0 : c0488olArr.length;
                int i = repeatedFieldArrayLength + length;
                C0488ol[] c0488olArr2 = new C0488ol[i];
                if (length != 0) {
                    System.arraycopy(c0488olArr, 0, c0488olArr2, 0, length);
                }
                while (length < i - 1) {
                    C0488ol c0488ol = new C0488ol();
                    c0488olArr2[length] = c0488ol;
                    codedInputByteBufferNano.readMessage(c0488ol);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0488ol c0488ol2 = new C0488ol();
                c0488olArr2[length] = c0488ol2;
                codedInputByteBufferNano.readMessage(c0488ol2);
                this.f1122a = c0488olArr2;
            }
        }
        return this;
    }

    public static C0462nl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0462nl().mergeFrom(codedInputByteBufferNano);
    }

    public static C0462nl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0462nl) MessageNano.mergeFrom(new C0462nl(), bArr);
    }
}
