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
public final class C0464nl extends MessageNano {
    public static volatile C0464nl[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0490ol[] f1119a;

    public C0464nl() {
        a();
    }

    public static C0464nl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0464nl[0];
                }
            }
        }
        return b;
    }

    public final C0464nl a() {
        this.f1119a = C0490ol.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0490ol[] c0490olArr = this.f1119a;
        if (c0490olArr != null && c0490olArr.length > 0) {
            int i = 0;
            while (true) {
                C0490ol[] c0490olArr2 = this.f1119a;
                if (i >= c0490olArr2.length) {
                    break;
                }
                C0490ol c0490ol = c0490olArr2[i];
                if (c0490ol != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0490ol) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0490ol[] c0490olArr = this.f1119a;
        if (c0490olArr != null && c0490olArr.length > 0) {
            int i = 0;
            while (true) {
                C0490ol[] c0490olArr2 = this.f1119a;
                if (i >= c0490olArr2.length) {
                    break;
                }
                C0490ol c0490ol = c0490olArr2[i];
                if (c0490ol != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0490ol);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0464nl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0490ol[] c0490olArr = this.f1119a;
                int length = c0490olArr == null ? 0 : c0490olArr.length;
                int i = repeatedFieldArrayLength + length;
                C0490ol[] c0490olArr2 = new C0490ol[i];
                if (length != 0) {
                    System.arraycopy(c0490olArr, 0, c0490olArr2, 0, length);
                }
                while (length < i - 1) {
                    C0490ol c0490ol = new C0490ol();
                    c0490olArr2[length] = c0490ol;
                    codedInputByteBufferNano.readMessage(c0490ol);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0490ol c0490ol2 = new C0490ol();
                c0490olArr2[length] = c0490ol2;
                codedInputByteBufferNano.readMessage(c0490ol2);
                this.f1119a = c0490olArr2;
            }
        }
        return this;
    }

    public static C0464nl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0464nl().mergeFrom(codedInputByteBufferNano);
    }

    public static C0464nl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0464nl) MessageNano.mergeFrom(new C0464nl(), bArr);
    }
}
