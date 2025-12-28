package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.x3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0687x3 extends MessageNano {
    public static volatile C0687x3[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0662w3[] f1291a;

    public C0687x3() {
        a();
    }

    public static C0687x3[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0687x3[0];
                }
            }
        }
        return b;
    }

    public final C0687x3 a() {
        this.f1291a = C0662w3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0662w3[] c0662w3Arr = this.f1291a;
        if (c0662w3Arr != null && c0662w3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0662w3[] c0662w3Arr2 = this.f1291a;
                if (i >= c0662w3Arr2.length) {
                    break;
                }
                C0662w3 c0662w3 = c0662w3Arr2[i];
                if (c0662w3 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0662w3) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0662w3[] c0662w3Arr = this.f1291a;
        if (c0662w3Arr != null && c0662w3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0662w3[] c0662w3Arr2 = this.f1291a;
                if (i >= c0662w3Arr2.length) {
                    break;
                }
                C0662w3 c0662w3 = c0662w3Arr2[i];
                if (c0662w3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0662w3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0687x3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0662w3[] c0662w3Arr = this.f1291a;
                int length = c0662w3Arr == null ? 0 : c0662w3Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0662w3[] c0662w3Arr2 = new C0662w3[i];
                if (length != 0) {
                    System.arraycopy(c0662w3Arr, 0, c0662w3Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0662w3 c0662w3 = new C0662w3();
                    c0662w3Arr2[length] = c0662w3;
                    codedInputByteBufferNano.readMessage(c0662w3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0662w3 c0662w32 = new C0662w3();
                c0662w3Arr2[length] = c0662w32;
                codedInputByteBufferNano.readMessage(c0662w32);
                this.f1291a = c0662w3Arr2;
            }
        }
        return this;
    }

    public static C0687x3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0687x3().mergeFrom(codedInputByteBufferNano);
    }

    public static C0687x3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0687x3) MessageNano.mergeFrom(new C0687x3(), bArr);
    }
}
