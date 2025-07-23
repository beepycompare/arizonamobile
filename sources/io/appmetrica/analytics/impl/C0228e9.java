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
public final class C0228e9 extends MessageNano {
    public static volatile C0228e9[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0203d9[] f828a;

    public C0228e9() {
        a();
    }

    public static C0228e9[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0228e9[0];
                }
            }
        }
        return b;
    }

    public final C0228e9 a() {
        this.f828a = C0203d9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0203d9[] c0203d9Arr = this.f828a;
        if (c0203d9Arr != null && c0203d9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0203d9[] c0203d9Arr2 = this.f828a;
                if (i >= c0203d9Arr2.length) {
                    break;
                }
                C0203d9 c0203d9 = c0203d9Arr2[i];
                if (c0203d9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0203d9) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0203d9[] c0203d9Arr = this.f828a;
        if (c0203d9Arr != null && c0203d9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0203d9[] c0203d9Arr2 = this.f828a;
                if (i >= c0203d9Arr2.length) {
                    break;
                }
                C0203d9 c0203d9 = c0203d9Arr2[i];
                if (c0203d9 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0203d9);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0228e9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0203d9[] c0203d9Arr = this.f828a;
                int length = c0203d9Arr == null ? 0 : c0203d9Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0203d9[] c0203d9Arr2 = new C0203d9[i];
                if (length != 0) {
                    System.arraycopy(c0203d9Arr, 0, c0203d9Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0203d9 c0203d9 = new C0203d9();
                    c0203d9Arr2[length] = c0203d9;
                    codedInputByteBufferNano.readMessage(c0203d9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0203d9 c0203d92 = new C0203d9();
                c0203d9Arr2[length] = c0203d92;
                codedInputByteBufferNano.readMessage(c0203d92);
                this.f828a = c0203d9Arr2;
            }
        }
        return this;
    }

    public static C0228e9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0228e9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0228e9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0228e9) MessageNano.mergeFrom(new C0228e9(), bArr);
    }
}
