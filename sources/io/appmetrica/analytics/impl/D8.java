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
    public C0600t8 f387a;
    public C0600t8[] b;

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
        this.f387a = null;
        this.b = C0600t8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0600t8 c0600t8 = this.f387a;
        if (c0600t8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0600t8);
        }
        C0600t8[] c0600t8Arr = this.b;
        if (c0600t8Arr != null && c0600t8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0600t8[] c0600t8Arr2 = this.b;
                if (i >= c0600t8Arr2.length) {
                    break;
                }
                C0600t8 c0600t82 = c0600t8Arr2[i];
                if (c0600t82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0600t82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0600t8 c0600t8 = this.f387a;
        if (c0600t8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0600t8);
        }
        C0600t8[] c0600t8Arr = this.b;
        if (c0600t8Arr != null && c0600t8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0600t8[] c0600t8Arr2 = this.b;
                if (i >= c0600t8Arr2.length) {
                    break;
                }
                C0600t8 c0600t82 = c0600t8Arr2[i];
                if (c0600t82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0600t82);
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
                if (this.f387a == null) {
                    this.f387a = new C0600t8();
                }
                codedInputByteBufferNano.readMessage(this.f387a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0600t8[] c0600t8Arr = this.b;
                int length = c0600t8Arr == null ? 0 : c0600t8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0600t8[] c0600t8Arr2 = new C0600t8[i];
                if (length != 0) {
                    System.arraycopy(c0600t8Arr, 0, c0600t8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0600t8 c0600t8 = new C0600t8();
                    c0600t8Arr2[length] = c0600t8;
                    codedInputByteBufferNano.readMessage(c0600t8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0600t8 c0600t82 = new C0600t8();
                c0600t8Arr2[length] = c0600t82;
                codedInputByteBufferNano.readMessage(c0600t82);
                this.b = c0600t8Arr2;
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
