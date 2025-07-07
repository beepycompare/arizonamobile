package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.b9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0159b9 extends MessageNano {
    public static volatile C0159b9[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0133a9[] f767a;

    public C0159b9() {
        a();
    }

    public static C0159b9[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0159b9[0];
                }
            }
        }
        return b;
    }

    public final C0159b9 a() {
        this.f767a = C0133a9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0133a9[] c0133a9Arr = this.f767a;
        if (c0133a9Arr != null && c0133a9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0133a9[] c0133a9Arr2 = this.f767a;
                if (i >= c0133a9Arr2.length) {
                    break;
                }
                C0133a9 c0133a9 = c0133a9Arr2[i];
                if (c0133a9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0133a9) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0133a9[] c0133a9Arr = this.f767a;
        if (c0133a9Arr != null && c0133a9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0133a9[] c0133a9Arr2 = this.f767a;
                if (i >= c0133a9Arr2.length) {
                    break;
                }
                C0133a9 c0133a9 = c0133a9Arr2[i];
                if (c0133a9 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0133a9);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0159b9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0133a9[] c0133a9Arr = this.f767a;
                int length = c0133a9Arr == null ? 0 : c0133a9Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0133a9[] c0133a9Arr2 = new C0133a9[i];
                if (length != 0) {
                    System.arraycopy(c0133a9Arr, 0, c0133a9Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0133a9 c0133a9 = new C0133a9();
                    c0133a9Arr2[length] = c0133a9;
                    codedInputByteBufferNano.readMessage(c0133a9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0133a9 c0133a92 = new C0133a9();
                c0133a9Arr2[length] = c0133a92;
                codedInputByteBufferNano.readMessage(c0133a92);
                this.f767a = c0133a9Arr2;
            }
        }
        return this;
    }

    public static C0159b9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0159b9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0159b9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0159b9) MessageNano.mergeFrom(new C0159b9(), bArr);
    }
}
