package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class I8 extends MessageNano {
    public static volatile I8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0725y8 f493a;
    public C0725y8[] b;

    public I8() {
        a();
    }

    public static I8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new I8[0];
                }
            }
        }
        return c;
    }

    public final I8 a() {
        this.f493a = null;
        this.b = C0725y8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0725y8 c0725y8 = this.f493a;
        if (c0725y8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0725y8);
        }
        C0725y8[] c0725y8Arr = this.b;
        if (c0725y8Arr != null && c0725y8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0725y8[] c0725y8Arr2 = this.b;
                if (i >= c0725y8Arr2.length) {
                    break;
                }
                C0725y8 c0725y82 = c0725y8Arr2[i];
                if (c0725y82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0725y82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0725y8 c0725y8 = this.f493a;
        if (c0725y8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0725y8);
        }
        C0725y8[] c0725y8Arr = this.b;
        if (c0725y8Arr != null && c0725y8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0725y8[] c0725y8Arr2 = this.b;
                if (i >= c0725y8Arr2.length) {
                    break;
                }
                C0725y8 c0725y82 = c0725y8Arr2[i];
                if (c0725y82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0725y82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final I8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f493a == null) {
                    this.f493a = new C0725y8();
                }
                codedInputByteBufferNano.readMessage(this.f493a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0725y8[] c0725y8Arr = this.b;
                int length = c0725y8Arr == null ? 0 : c0725y8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0725y8[] c0725y8Arr2 = new C0725y8[i];
                if (length != 0) {
                    System.arraycopy(c0725y8Arr, 0, c0725y8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0725y8 c0725y8 = new C0725y8();
                    c0725y8Arr2[length] = c0725y8;
                    codedInputByteBufferNano.readMessage(c0725y8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0725y8 c0725y82 = new C0725y8();
                c0725y8Arr2[length] = c0725y82;
                codedInputByteBufferNano.readMessage(c0725y82);
                this.b = c0725y8Arr2;
            }
        }
        return this;
    }

    public static I8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new I8().mergeFrom(codedInputByteBufferNano);
    }

    public static I8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (I8) MessageNano.mergeFrom(new I8(), bArr);
    }
}
