package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class O3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile O3[] g;

    /* renamed from: a  reason: collision with root package name */
    public L3 f698a;
    public L3[] b;

    public O3() {
        a();
    }

    public static O3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new O3[0];
                }
            }
        }
        return g;
    }

    public final O3 a() {
        this.f698a = null;
        this.b = L3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        L3 l3 = this.f698a;
        if (l3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, l3);
        }
        L3[] l3Arr = this.b;
        if (l3Arr != null && l3Arr.length > 0) {
            int i = 0;
            while (true) {
                L3[] l3Arr2 = this.b;
                if (i >= l3Arr2.length) {
                    break;
                }
                L3 l32 = l3Arr2[i];
                if (l32 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, l32) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        L3 l3 = this.f698a;
        if (l3 != null) {
            codedOutputByteBufferNano.writeMessage(1, l3);
        }
        L3[] l3Arr = this.b;
        if (l3Arr != null && l3Arr.length > 0) {
            int i = 0;
            while (true) {
                L3[] l3Arr2 = this.b;
                if (i >= l3Arr2.length) {
                    break;
                }
                L3 l32 = l3Arr2[i];
                if (l32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, l32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final O3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f698a == null) {
                    this.f698a = new L3();
                }
                codedInputByteBufferNano.readMessage(this.f698a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                L3[] l3Arr = this.b;
                int length = l3Arr == null ? 0 : l3Arr.length;
                int i = repeatedFieldArrayLength + length;
                L3[] l3Arr2 = new L3[i];
                if (length != 0) {
                    System.arraycopy(l3Arr, 0, l3Arr2, 0, length);
                }
                while (length < i - 1) {
                    L3 l3 = new L3();
                    l3Arr2[length] = l3;
                    codedInputByteBufferNano.readMessage(l3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                L3 l32 = new L3();
                l3Arr2[length] = l32;
                codedInputByteBufferNano.readMessage(l32);
                this.b = l3Arr2;
            }
        }
        return this;
    }

    public static O3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new O3().mergeFrom(codedInputByteBufferNano);
    }

    public static O3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (O3) MessageNano.mergeFrom(new O3(), bArr);
    }
}
