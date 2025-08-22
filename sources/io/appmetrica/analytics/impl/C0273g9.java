package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.g9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0273g9 extends MessageNano {
    public static volatile C0273g9[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0247f9[] f870a;

    public C0273g9() {
        a();
    }

    public static C0273g9[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0273g9[0];
                }
            }
        }
        return b;
    }

    public final C0273g9 a() {
        this.f870a = C0247f9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0247f9[] c0247f9Arr = this.f870a;
        if (c0247f9Arr != null && c0247f9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0247f9[] c0247f9Arr2 = this.f870a;
                if (i >= c0247f9Arr2.length) {
                    break;
                }
                C0247f9 c0247f9 = c0247f9Arr2[i];
                if (c0247f9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0247f9) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0247f9[] c0247f9Arr = this.f870a;
        if (c0247f9Arr != null && c0247f9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0247f9[] c0247f9Arr2 = this.f870a;
                if (i >= c0247f9Arr2.length) {
                    break;
                }
                C0247f9 c0247f9 = c0247f9Arr2[i];
                if (c0247f9 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0247f9);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0273g9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0247f9[] c0247f9Arr = this.f870a;
                int length = c0247f9Arr == null ? 0 : c0247f9Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0247f9[] c0247f9Arr2 = new C0247f9[i];
                if (length != 0) {
                    System.arraycopy(c0247f9Arr, 0, c0247f9Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0247f9 c0247f9 = new C0247f9();
                    c0247f9Arr2[length] = c0247f9;
                    codedInputByteBufferNano.readMessage(c0247f9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0247f9 c0247f92 = new C0247f9();
                c0247f9Arr2[length] = c0247f92;
                codedInputByteBufferNano.readMessage(c0247f92);
                this.f870a = c0247f9Arr2;
            }
        }
        return this;
    }

    public static C0273g9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0273g9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0273g9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0273g9) MessageNano.mergeFrom(new C0273g9(), bArr);
    }
}
