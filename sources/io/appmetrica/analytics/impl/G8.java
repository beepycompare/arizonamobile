package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class G8 extends MessageNano {
    public static volatile G8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0677w8 f450a;
    public C0677w8[] b;

    public G8() {
        a();
    }

    public static G8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new G8[0];
                }
            }
        }
        return c;
    }

    public final G8 a() {
        this.f450a = null;
        this.b = C0677w8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0677w8 c0677w8 = this.f450a;
        if (c0677w8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0677w8);
        }
        C0677w8[] c0677w8Arr = this.b;
        if (c0677w8Arr != null && c0677w8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0677w8[] c0677w8Arr2 = this.b;
                if (i >= c0677w8Arr2.length) {
                    break;
                }
                C0677w8 c0677w82 = c0677w8Arr2[i];
                if (c0677w82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0677w82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0677w8 c0677w8 = this.f450a;
        if (c0677w8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0677w8);
        }
        C0677w8[] c0677w8Arr = this.b;
        if (c0677w8Arr != null && c0677w8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0677w8[] c0677w8Arr2 = this.b;
                if (i >= c0677w8Arr2.length) {
                    break;
                }
                C0677w8 c0677w82 = c0677w8Arr2[i];
                if (c0677w82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0677w82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final G8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f450a == null) {
                    this.f450a = new C0677w8();
                }
                codedInputByteBufferNano.readMessage(this.f450a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0677w8[] c0677w8Arr = this.b;
                int length = c0677w8Arr == null ? 0 : c0677w8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0677w8[] c0677w8Arr2 = new C0677w8[i];
                if (length != 0) {
                    System.arraycopy(c0677w8Arr, 0, c0677w8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0677w8 c0677w8 = new C0677w8();
                    c0677w8Arr2[length] = c0677w8;
                    codedInputByteBufferNano.readMessage(c0677w8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0677w8 c0677w82 = new C0677w8();
                c0677w8Arr2[length] = c0677w82;
                codedInputByteBufferNano.readMessage(c0677w82);
                this.b = c0677w8Arr2;
            }
        }
        return this;
    }

    public static G8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new G8().mergeFrom(codedInputByteBufferNano);
    }

    public static G8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (G8) MessageNano.mergeFrom(new G8(), bArr);
    }
}
