package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class V3 extends MessageNano {
    public static volatile V3[] b;

    /* renamed from: a  reason: collision with root package name */
    public U3[] f708a;

    public V3() {
        a();
    }

    public static V3[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new V3[0];
                }
            }
        }
        return b;
    }

    public final V3 a() {
        this.f708a = U3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        U3[] u3Arr = this.f708a;
        if (u3Arr != null && u3Arr.length > 0) {
            int i = 0;
            while (true) {
                U3[] u3Arr2 = this.f708a;
                if (i >= u3Arr2.length) {
                    break;
                }
                U3 u3 = u3Arr2[i];
                if (u3 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, u3) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        U3[] u3Arr = this.f708a;
        if (u3Arr != null && u3Arr.length > 0) {
            int i = 0;
            while (true) {
                U3[] u3Arr2 = this.f708a;
                if (i >= u3Arr2.length) {
                    break;
                }
                U3 u3 = u3Arr2[i];
                if (u3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, u3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final V3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                U3[] u3Arr = this.f708a;
                int length = u3Arr == null ? 0 : u3Arr.length;
                int i = repeatedFieldArrayLength + length;
                U3[] u3Arr2 = new U3[i];
                if (length != 0) {
                    System.arraycopy(u3Arr, 0, u3Arr2, 0, length);
                }
                while (length < i - 1) {
                    U3 u3 = new U3();
                    u3Arr2[length] = u3;
                    codedInputByteBufferNano.readMessage(u3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                U3 u32 = new U3();
                u3Arr2[length] = u32;
                codedInputByteBufferNano.readMessage(u32);
                this.f708a = u3Arr2;
            }
        }
        return this;
    }

    public static V3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new V3().mergeFrom(codedInputByteBufferNano);
    }

    public static V3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (V3) MessageNano.mergeFrom(new V3(), bArr);
    }
}
