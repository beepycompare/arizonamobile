package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.e9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0229e9 extends MessageNano {
    public static volatile C0229e9[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0204d9[] f828a;

    public C0229e9() {
        a();
    }

    public static C0229e9[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0229e9[0];
                }
            }
        }
        return b;
    }

    public final C0229e9 a() {
        this.f828a = C0204d9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0204d9[] c0204d9Arr = this.f828a;
        if (c0204d9Arr != null && c0204d9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0204d9[] c0204d9Arr2 = this.f828a;
                if (i >= c0204d9Arr2.length) {
                    break;
                }
                C0204d9 c0204d9 = c0204d9Arr2[i];
                if (c0204d9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0204d9) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0204d9[] c0204d9Arr = this.f828a;
        if (c0204d9Arr != null && c0204d9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0204d9[] c0204d9Arr2 = this.f828a;
                if (i >= c0204d9Arr2.length) {
                    break;
                }
                C0204d9 c0204d9 = c0204d9Arr2[i];
                if (c0204d9 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0204d9);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0229e9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0204d9[] c0204d9Arr = this.f828a;
                int length = c0204d9Arr == null ? 0 : c0204d9Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0204d9[] c0204d9Arr2 = new C0204d9[i];
                if (length != 0) {
                    System.arraycopy(c0204d9Arr, 0, c0204d9Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0204d9 c0204d9 = new C0204d9();
                    c0204d9Arr2[length] = c0204d9;
                    codedInputByteBufferNano.readMessage(c0204d9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0204d9 c0204d92 = new C0204d9();
                c0204d9Arr2[length] = c0204d92;
                codedInputByteBufferNano.readMessage(c0204d92);
                this.f828a = c0204d9Arr2;
            }
        }
        return this;
    }

    public static C0229e9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0229e9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0229e9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0229e9) MessageNano.mergeFrom(new C0229e9(), bArr);
    }
}
