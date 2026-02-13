package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.w3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0666w3 extends MessageNano {
    public static volatile C0666w3[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0641v3[] f1280a;

    public C0666w3() {
        a();
    }

    public static C0666w3[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0666w3[0];
                }
            }
        }
        return b;
    }

    public final C0666w3 a() {
        this.f1280a = C0641v3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0641v3[] c0641v3Arr = this.f1280a;
        if (c0641v3Arr != null && c0641v3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0641v3[] c0641v3Arr2 = this.f1280a;
                if (i >= c0641v3Arr2.length) {
                    break;
                }
                C0641v3 c0641v3 = c0641v3Arr2[i];
                if (c0641v3 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0641v3) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0641v3[] c0641v3Arr = this.f1280a;
        if (c0641v3Arr != null && c0641v3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0641v3[] c0641v3Arr2 = this.f1280a;
                if (i >= c0641v3Arr2.length) {
                    break;
                }
                C0641v3 c0641v3 = c0641v3Arr2[i];
                if (c0641v3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0641v3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0666w3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0641v3[] c0641v3Arr = this.f1280a;
                int length = c0641v3Arr == null ? 0 : c0641v3Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0641v3[] c0641v3Arr2 = new C0641v3[i];
                if (length != 0) {
                    System.arraycopy(c0641v3Arr, 0, c0641v3Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0641v3 c0641v3 = new C0641v3();
                    c0641v3Arr2[length] = c0641v3;
                    codedInputByteBufferNano.readMessage(c0641v3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0641v3 c0641v32 = new C0641v3();
                c0641v3Arr2[length] = c0641v32;
                codedInputByteBufferNano.readMessage(c0641v32);
                this.f1280a = c0641v3Arr2;
            }
        }
        return this;
    }

    public static C0666w3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0666w3().mergeFrom(codedInputByteBufferNano);
    }

    public static C0666w3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0666w3) MessageNano.mergeFrom(new C0666w3(), bArr);
    }
}
