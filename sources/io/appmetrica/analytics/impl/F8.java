package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class F8 extends MessageNano {
    public static volatile F8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0657v8 f543a;
    public C0657v8[] b;

    public F8() {
        a();
    }

    public static F8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new F8[0];
                }
            }
        }
        return c;
    }

    public final F8 a() {
        this.f543a = null;
        this.b = C0657v8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0657v8 c0657v8 = this.f543a;
        if (c0657v8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0657v8);
        }
        C0657v8[] c0657v8Arr = this.b;
        if (c0657v8Arr != null && c0657v8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0657v8[] c0657v8Arr2 = this.b;
                if (i >= c0657v8Arr2.length) {
                    break;
                }
                C0657v8 c0657v82 = c0657v8Arr2[i];
                if (c0657v82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0657v82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0657v8 c0657v8 = this.f543a;
        if (c0657v8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0657v8);
        }
        C0657v8[] c0657v8Arr = this.b;
        if (c0657v8Arr != null && c0657v8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0657v8[] c0657v8Arr2 = this.b;
                if (i >= c0657v8Arr2.length) {
                    break;
                }
                C0657v8 c0657v82 = c0657v8Arr2[i];
                if (c0657v82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0657v82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final F8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f543a == null) {
                    this.f543a = new C0657v8();
                }
                codedInputByteBufferNano.readMessage(this.f543a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0657v8[] c0657v8Arr = this.b;
                int length = c0657v8Arr == null ? 0 : c0657v8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0657v8[] c0657v8Arr2 = new C0657v8[i];
                if (length != 0) {
                    System.arraycopy(c0657v8Arr, 0, c0657v8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0657v8 c0657v8 = new C0657v8();
                    c0657v8Arr2[length] = c0657v8;
                    codedInputByteBufferNano.readMessage(c0657v8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0657v8 c0657v82 = new C0657v8();
                c0657v8Arr2[length] = c0657v82;
                codedInputByteBufferNano.readMessage(c0657v82);
                this.b = c0657v8Arr2;
            }
        }
        return this;
    }

    public static F8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new F8().mergeFrom(codedInputByteBufferNano);
    }

    public static F8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (F8) MessageNano.mergeFrom(new F8(), bArr);
    }
}
