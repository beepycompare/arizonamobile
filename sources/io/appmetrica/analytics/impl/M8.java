package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class M8 extends MessageNano {
    public static volatile M8[] b;

    /* renamed from: a  reason: collision with root package name */
    public L8[] f683a;

    public M8() {
        a();
    }

    public static M8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new M8[0];
                }
            }
        }
        return b;
    }

    public final M8 a() {
        this.f683a = L8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        L8[] l8Arr = this.f683a;
        if (l8Arr != null && l8Arr.length > 0) {
            int i = 0;
            while (true) {
                L8[] l8Arr2 = this.f683a;
                if (i >= l8Arr2.length) {
                    break;
                }
                L8 l8 = l8Arr2[i];
                if (l8 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, l8) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        L8[] l8Arr = this.f683a;
        if (l8Arr != null && l8Arr.length > 0) {
            int i = 0;
            while (true) {
                L8[] l8Arr2 = this.f683a;
                if (i >= l8Arr2.length) {
                    break;
                }
                L8 l8 = l8Arr2[i];
                if (l8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, l8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final M8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                L8[] l8Arr = this.f683a;
                int length = l8Arr == null ? 0 : l8Arr.length;
                int i = repeatedFieldArrayLength + length;
                L8[] l8Arr2 = new L8[i];
                if (length != 0) {
                    System.arraycopy(l8Arr, 0, l8Arr2, 0, length);
                }
                while (length < i - 1) {
                    L8 l8 = new L8();
                    l8Arr2[length] = l8;
                    codedInputByteBufferNano.readMessage(l8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                L8 l82 = new L8();
                l8Arr2[length] = l82;
                codedInputByteBufferNano.readMessage(l82);
                this.f683a = l8Arr2;
            }
        }
        return this;
    }

    public static M8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new M8().mergeFrom(codedInputByteBufferNano);
    }

    public static M8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (M8) MessageNano.mergeFrom(new M8(), bArr);
    }
}
