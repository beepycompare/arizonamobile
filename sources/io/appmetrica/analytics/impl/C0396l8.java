package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.l8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0396l8 extends MessageNano {
    public static volatile C0396l8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0371k8[] f1094a;
    public int b;

    public C0396l8() {
        a();
    }

    public static C0396l8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0396l8[0];
                }
            }
        }
        return c;
    }

    public final C0396l8 a() {
        this.f1094a = C0371k8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0371k8[] c0371k8Arr = this.f1094a;
        if (c0371k8Arr != null && c0371k8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0371k8[] c0371k8Arr2 = this.f1094a;
                if (i >= c0371k8Arr2.length) {
                    break;
                }
                C0371k8 c0371k8 = c0371k8Arr2[i];
                if (c0371k8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0371k8);
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? CodedOutputByteBufferNano.computeUInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0371k8[] c0371k8Arr = this.f1094a;
        if (c0371k8Arr != null && c0371k8Arr.length > 0) {
            int i = 0;
            while (true) {
                C0371k8[] c0371k8Arr2 = this.f1094a;
                if (i >= c0371k8Arr2.length) {
                    break;
                }
                C0371k8 c0371k8 = c0371k8Arr2[i];
                if (c0371k8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0371k8);
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
    public final C0396l8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C0371k8[] c0371k8Arr = this.f1094a;
                int length = c0371k8Arr == null ? 0 : c0371k8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0371k8[] c0371k8Arr2 = new C0371k8[i];
                if (length != 0) {
                    System.arraycopy(c0371k8Arr, 0, c0371k8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0371k8 c0371k8 = new C0371k8();
                    c0371k8Arr2[length] = c0371k8;
                    codedInputByteBufferNano.readMessage(c0371k8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0371k8 c0371k82 = new C0371k8();
                c0371k8Arr2[length] = c0371k82;
                codedInputByteBufferNano.readMessage(c0371k82);
                this.f1094a = c0371k8Arr2;
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

    public static C0396l8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0396l8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0396l8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0396l8) MessageNano.mergeFrom(new C0396l8(), bArr);
    }
}
