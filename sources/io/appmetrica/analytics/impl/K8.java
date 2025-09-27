package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class K8 extends MessageNano {
    public static volatile K8[] c;

    /* renamed from: a  reason: collision with root package name */
    public J8[] f536a;
    public int b;

    public K8() {
        a();
    }

    public static K8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new K8[0];
                }
            }
        }
        return c;
    }

    public final K8 a() {
        this.f536a = J8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        J8[] j8Arr = this.f536a;
        if (j8Arr != null && j8Arr.length > 0) {
            int i = 0;
            while (true) {
                J8[] j8Arr2 = this.f536a;
                if (i >= j8Arr2.length) {
                    break;
                }
                J8 j8 = j8Arr2[i];
                if (j8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, j8);
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        J8[] j8Arr = this.f536a;
        if (j8Arr != null && j8Arr.length > 0) {
            int i = 0;
            while (true) {
                J8[] j8Arr2 = this.f536a;
                if (i >= j8Arr2.length) {
                    break;
                }
                J8 j8 = j8Arr2[i];
                if (j8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, j8);
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
    public final K8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                J8[] j8Arr = this.f536a;
                int length = j8Arr == null ? 0 : j8Arr.length;
                int i = repeatedFieldArrayLength + length;
                J8[] j8Arr2 = new J8[i];
                if (length != 0) {
                    System.arraycopy(j8Arr, 0, j8Arr2, 0, length);
                }
                while (length < i - 1) {
                    J8 j8 = new J8();
                    j8Arr2[length] = j8;
                    codedInputByteBufferNano.readMessage(j8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                J8 j82 = new J8();
                j8Arr2[length] = j82;
                codedInputByteBufferNano.readMessage(j82);
                this.f536a = j8Arr2;
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

    public static K8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new K8().mergeFrom(codedInputByteBufferNano);
    }

    public static K8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (K8) MessageNano.mergeFrom(new K8(), bArr);
    }
}
