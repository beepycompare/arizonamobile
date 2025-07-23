package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class F8 extends MessageNano {
    public static volatile F8[] c;

    /* renamed from: a  reason: collision with root package name */
    public E8[] f433a;
    public int b;

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
        this.f433a = E8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        E8[] e8Arr = this.f433a;
        if (e8Arr != null && e8Arr.length > 0) {
            int i = 0;
            while (true) {
                E8[] e8Arr2 = this.f433a;
                if (i >= e8Arr2.length) {
                    break;
                }
                E8 e8 = e8Arr2[i];
                if (e8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, e8);
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        E8[] e8Arr = this.f433a;
        if (e8Arr != null && e8Arr.length > 0) {
            int i = 0;
            while (true) {
                E8[] e8Arr2 = this.f433a;
                if (i >= e8Arr2.length) {
                    break;
                }
                E8 e8 = e8Arr2[i];
                if (e8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, e8);
                }
                i++;
            }
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                E8[] e8Arr = this.f433a;
                int length = e8Arr == null ? 0 : e8Arr.length;
                int i = repeatedFieldArrayLength + length;
                E8[] e8Arr2 = new E8[i];
                if (length != 0) {
                    System.arraycopy(e8Arr, 0, e8Arr2, 0, length);
                }
                while (length < i - 1) {
                    E8 e8 = new E8();
                    e8Arr2[length] = e8;
                    codedInputByteBufferNano.readMessage(e8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                E8 e82 = new E8();
                e8Arr2[length] = e82;
                codedInputByteBufferNano.readMessage(e82);
                this.f433a = e8Arr2;
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readUInt32();
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
