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
public final class C0457nl extends MessageNano {
    public static volatile C0457nl[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0483ol[] f1125a;

    public C0457nl() {
        a();
    }

    public static C0457nl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0457nl[0];
                }
            }
        }
        return b;
    }

    public final C0457nl a() {
        this.f1125a = C0483ol.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0483ol[] c0483olArr = this.f1125a;
        if (c0483olArr != null && c0483olArr.length > 0) {
            int i = 0;
            while (true) {
                C0483ol[] c0483olArr2 = this.f1125a;
                if (i >= c0483olArr2.length) {
                    break;
                }
                C0483ol c0483ol = c0483olArr2[i];
                if (c0483ol != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0483ol) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0483ol[] c0483olArr = this.f1125a;
        if (c0483olArr != null && c0483olArr.length > 0) {
            int i = 0;
            while (true) {
                C0483ol[] c0483olArr2 = this.f1125a;
                if (i >= c0483olArr2.length) {
                    break;
                }
                C0483ol c0483ol = c0483olArr2[i];
                if (c0483ol != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0483ol);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0457nl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0483ol[] c0483olArr = this.f1125a;
                int length = c0483olArr == null ? 0 : c0483olArr.length;
                int i = repeatedFieldArrayLength + length;
                C0483ol[] c0483olArr2 = new C0483ol[i];
                if (length != 0) {
                    System.arraycopy(c0483olArr, 0, c0483olArr2, 0, length);
                }
                while (length < i - 1) {
                    C0483ol c0483ol = new C0483ol();
                    c0483olArr2[length] = c0483ol;
                    codedInputByteBufferNano.readMessage(c0483ol);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0483ol c0483ol2 = new C0483ol();
                c0483olArr2[length] = c0483ol2;
                codedInputByteBufferNano.readMessage(c0483ol2);
                this.f1125a = c0483olArr2;
            }
        }
        return this;
    }

    public static C0457nl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0457nl().mergeFrom(codedInputByteBufferNano);
    }

    public static C0457nl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0457nl) MessageNano.mergeFrom(new C0457nl(), bArr);
    }
}
