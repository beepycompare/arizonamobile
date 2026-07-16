package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.f9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0245f9 extends MessageNano {
    public static volatile C0245f9[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0219e9[] f979a;

    public C0245f9() {
        a();
    }

    public static C0245f9[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0245f9[0];
                }
            }
        }
        return b;
    }

    public final C0245f9 a() {
        this.f979a = C0219e9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0219e9[] c0219e9Arr = this.f979a;
        if (c0219e9Arr != null && c0219e9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0219e9[] c0219e9Arr2 = this.f979a;
                if (i >= c0219e9Arr2.length) {
                    break;
                }
                C0219e9 c0219e9 = c0219e9Arr2[i];
                if (c0219e9 != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0219e9) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0219e9[] c0219e9Arr = this.f979a;
        if (c0219e9Arr != null && c0219e9Arr.length > 0) {
            int i = 0;
            while (true) {
                C0219e9[] c0219e9Arr2 = this.f979a;
                if (i >= c0219e9Arr2.length) {
                    break;
                }
                C0219e9 c0219e9 = c0219e9Arr2[i];
                if (c0219e9 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0219e9);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0245f9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0219e9[] c0219e9Arr = this.f979a;
                int length = c0219e9Arr == null ? 0 : c0219e9Arr.length;
                int i = repeatedFieldArrayLength + length;
                C0219e9[] c0219e9Arr2 = new C0219e9[i];
                if (length != 0) {
                    System.arraycopy(c0219e9Arr, 0, c0219e9Arr2, 0, length);
                }
                while (length < i - 1) {
                    C0219e9 c0219e9 = new C0219e9();
                    c0219e9Arr2[length] = c0219e9;
                    codedInputByteBufferNano.readMessage(c0219e9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0219e9 c0219e92 = new C0219e9();
                c0219e9Arr2[length] = c0219e92;
                codedInputByteBufferNano.readMessage(c0219e92);
                this.f979a = c0219e9Arr2;
            }
        }
        return this;
    }

    public static C0245f9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0245f9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0245f9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0245f9) MessageNano.mergeFrom(new C0245f9(), bArr);
    }
}
