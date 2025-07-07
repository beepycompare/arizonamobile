package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.z2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0752z2 extends MessageNano {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static volatile C0752z2[] f;

    /* renamed from: a  reason: collision with root package name */
    public C0727y2[] f1155a;
    public boolean b;

    public C0752z2() {
        a();
    }

    public static C0752z2[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C0752z2[0];
                }
            }
        }
        return f;
    }

    public final C0752z2 a() {
        this.f1155a = C0727y2.b();
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0727y2[] c0727y2Arr = this.f1155a;
        if (c0727y2Arr != null && c0727y2Arr.length > 0) {
            int i = 0;
            while (true) {
                C0727y2[] c0727y2Arr2 = this.f1155a;
                if (i >= c0727y2Arr2.length) {
                    break;
                }
                C0727y2 c0727y2 = c0727y2Arr2[i];
                if (c0727y2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0727y2);
                }
                i++;
            }
        }
        return CodedOutputByteBufferNano.computeBoolSize(2, this.b) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0727y2[] c0727y2Arr = this.f1155a;
        if (c0727y2Arr != null && c0727y2Arr.length > 0) {
            int i = 0;
            while (true) {
                C0727y2[] c0727y2Arr2 = this.f1155a;
                if (i >= c0727y2Arr2.length) {
                    break;
                }
                C0727y2 c0727y2 = c0727y2Arr2[i];
                if (c0727y2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0727y2);
                }
                i++;
            }
        }
        codedOutputByteBufferNano.writeBool(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0752z2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C0727y2[] c0727y2Arr = this.f1155a;
                int length = c0727y2Arr == null ? 0 : c0727y2Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0727y2[] c0727y2Arr2 = new C0727y2[i];
                if (length != 0) {
                    System.arraycopy(c0727y2Arr, 0, c0727y2Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0727y2 c0727y2 = new C0727y2();
                    c0727y2Arr2[length] = c0727y2;
                    codedInputByteBufferNano.readMessage(c0727y2);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0727y2 c0727y22 = new C0727y2();
                c0727y2Arr2[length] = c0727y22;
                codedInputByteBufferNano.readMessage(c0727y22);
                this.f1155a = c0727y2Arr2;
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static C0752z2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0752z2().mergeFrom(codedInputByteBufferNano);
    }

    public static C0752z2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0752z2) MessageNano.mergeFrom(new C0752z2(), bArr);
    }
}
