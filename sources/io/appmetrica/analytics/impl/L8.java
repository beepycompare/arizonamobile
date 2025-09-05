package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class L8 extends MessageNano {
    public static volatile L8[] c;

    /* renamed from: a  reason: collision with root package name */
    public B8 f551a;
    public B8[] b;

    public L8() {
        a();
    }

    public static L8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new L8[0];
                }
            }
        }
        return c;
    }

    public final L8 a() {
        this.f551a = null;
        this.b = B8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        B8 b8 = this.f551a;
        if (b8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, b8);
        }
        B8[] b8Arr = this.b;
        if (b8Arr != null && b8Arr.length > 0) {
            int i = 0;
            while (true) {
                B8[] b8Arr2 = this.b;
                if (i >= b8Arr2.length) {
                    break;
                }
                B8 b82 = b8Arr2[i];
                if (b82 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, b82) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        B8 b8 = this.f551a;
        if (b8 != null) {
            codedOutputByteBufferNano.writeMessage(1, b8);
        }
        B8[] b8Arr = this.b;
        if (b8Arr != null && b8Arr.length > 0) {
            int i = 0;
            while (true) {
                B8[] b8Arr2 = this.b;
                if (i >= b8Arr2.length) {
                    break;
                }
                B8 b82 = b8Arr2[i];
                if (b82 != null) {
                    codedOutputByteBufferNano.writeMessage(2, b82);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final L8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f551a == null) {
                    this.f551a = new B8();
                }
                codedInputByteBufferNano.readMessage(this.f551a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                B8[] b8Arr = this.b;
                int length = b8Arr == null ? 0 : b8Arr.length;
                int i = repeatedFieldArrayLength + length;
                B8[] b8Arr2 = new B8[i];
                if (length != 0) {
                    System.arraycopy(b8Arr, 0, b8Arr2, 0, length);
                }
                while (length < i - 1) {
                    B8 b8 = new B8();
                    b8Arr2[length] = b8;
                    codedInputByteBufferNano.readMessage(b8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                B8 b82 = new B8();
                b8Arr2[length] = b82;
                codedInputByteBufferNano.readMessage(b82);
                this.b = b8Arr2;
            }
        }
        return this;
    }

    public static L8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new L8().mergeFrom(codedInputByteBufferNano);
    }

    public static L8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (L8) MessageNano.mergeFrom(new L8(), bArr);
    }
}
