package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.x3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0690x3 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C0690x3[] g;

    /* renamed from: a  reason: collision with root package name */
    public C0615u3 f1297a;
    public C0615u3[] b;

    public C0690x3() {
        a();
    }

    public static C0690x3[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0690x3[0];
                }
            }
        }
        return g;
    }

    public final C0690x3 a() {
        this.f1297a = null;
        this.b = C0615u3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0615u3 c0615u3 = this.f1297a;
        if (c0615u3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0615u3);
        }
        C0615u3[] c0615u3Arr = this.b;
        if (c0615u3Arr != null && c0615u3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0615u3[] c0615u3Arr2 = this.b;
                if (i >= c0615u3Arr2.length) {
                    break;
                }
                C0615u3 c0615u32 = c0615u3Arr2[i];
                if (c0615u32 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(2, c0615u32) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0615u3 c0615u3 = this.f1297a;
        if (c0615u3 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0615u3);
        }
        C0615u3[] c0615u3Arr = this.b;
        if (c0615u3Arr != null && c0615u3Arr.length > 0) {
            int i = 0;
            while (true) {
                C0615u3[] c0615u3Arr2 = this.b;
                if (i >= c0615u3Arr2.length) {
                    break;
                }
                C0615u3 c0615u32 = c0615u3Arr2[i];
                if (c0615u32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c0615u32);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0690x3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1297a == null) {
                    this.f1297a = new C0615u3();
                }
                codedInputByteBufferNano.readMessage(this.f1297a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C0615u3[] c0615u3Arr = this.b;
                int length = c0615u3Arr == null ? 0 : c0615u3Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0615u3[] c0615u3Arr2 = new C0615u3[i];
                if (length != 0) {
                    System.arraycopy(c0615u3Arr, 0, c0615u3Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0615u3 c0615u3 = new C0615u3();
                    c0615u3Arr2[length] = c0615u3;
                    codedInputByteBufferNano.readMessage(c0615u3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0615u3 c0615u32 = new C0615u3();
                c0615u3Arr2[length] = c0615u32;
                codedInputByteBufferNano.readMessage(c0615u32);
                this.b = c0615u3Arr2;
            }
        }
        return this;
    }

    public static C0690x3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0690x3().mergeFrom(codedInputByteBufferNano);
    }

    public static C0690x3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0690x3) MessageNano.mergeFrom(new C0690x3(), bArr);
    }
}
