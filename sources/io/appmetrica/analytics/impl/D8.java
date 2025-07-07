package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class D8 extends MessageNano {
    public static volatile D8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0608t8 f386a;
    public C0608t8[] b;

    public D8() {
        a();
    }

    public static D8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new D8[0];
                }
            }
        }
        return c;
    }

    public final D8 a() {
        this.f386a = null;
        this.b = C0608t8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0608t8 c0608t8 = this.f386a;
        if (c0608t8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0608t8);
        }
        C0608t8[] c0608t8Arr = this.b;
        if (c0608t8Arr != null && c0608t8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0608t8[] c0608t8Arr2 = this.b;
                if (i >= c0608t8Arr2.length) {
                    break;
                }
                C0608t8 c0608t82 = c0608t8Arr2[i];
                if (c0608t82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0608t82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0608t8 c0608t8 = this.f386a;
        if (c0608t8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0608t8);
        }
        C0608t8[] c0608t8Arr = this.b;
        if (c0608t8Arr != null && c0608t8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0608t8[] c0608t8Arr2 = this.b;
                if (i >= c0608t8Arr2.length) {
                    break;
                }
                C0608t8 c0608t82 = c0608t8Arr2[i];
                if (c0608t82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0608t82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final D8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f386a == null) {
                    this.f386a = new C0608t8();
                }
                codedInputByteBufferNano.readMessage(this.f386a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0608t8[] c0608t8Arr = this.b;
                int length = c0608t8Arr == null ? 0 : c0608t8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0608t8[] c0608t8Arr2 = new C0608t8[i];
                if (length != 0) {
                    System.arraycopy(c0608t8Arr, 0, c0608t8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0608t8 c0608t8 = new C0608t8();
                    c0608t8Arr2[length] = c0608t8;
                    codedInputByteBufferNano.readMessage(c0608t8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0608t8 c0608t82 = new C0608t8();
                c0608t8Arr2[length] = c0608t82;
                codedInputByteBufferNano.readMessage(c0608t82);
                this.b = c0608t8Arr2;
            }
        }
        return this;
    }

    public static D8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new D8().mergeFrom(codedInputByteBufferNano);
    }

    public static D8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (D8) MessageNano.mergeFrom(new D8(), bArr);
    }
}
