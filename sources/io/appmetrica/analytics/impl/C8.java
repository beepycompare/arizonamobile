package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class C8 extends MessageNano {
    public static volatile C8[] c;

    /* renamed from: a  reason: collision with root package name */
    public B8[] f369a;
    public int b;

    public C8() {
        a();
    }

    public static C8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C8[0];
                }
            }
        }
        return c;
    }

    public final C8 a() {
        this.f369a = B8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        B8[] b8Arr = this.f369a;
        if (b8Arr != null && b8Arr.length > 0) {
            int i = 0;
            while (true) {
                B8[] b8Arr2 = this.f369a;
                if (i >= b8Arr2.length) {
                    break;
                }
                B8 b8 = b8Arr2[i];
                if (b8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, b8);
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        B8[] b8Arr = this.f369a;
        if (b8Arr != null && b8Arr.length > 0) {
            int i = 0;
            while (true) {
                B8[] b8Arr2 = this.f369a;
                if (i >= b8Arr2.length) {
                    break;
                }
                B8 b8 = b8Arr2[i];
                if (b8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, b8);
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
    public final C8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                B8[] b8Arr = this.f369a;
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
                this.f369a = b8Arr2;
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

    public static C8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C8().mergeFrom(codedInputByteBufferNano);
    }

    public static C8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C8) MessageNano.mergeFrom(new C8(), bArr);
    }
}
