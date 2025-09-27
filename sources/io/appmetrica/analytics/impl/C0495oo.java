package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.oo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0495oo extends MessageNano {
    public static volatile C0495oo[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0417lo[] f1027a;

    public C0495oo() {
        a();
    }

    public static C0495oo[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0495oo[0];
                }
            }
        }
        return b;
    }

    public final C0495oo a() {
        this.f1027a = C0417lo.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0417lo[] c0417loArr = this.f1027a;
        if (c0417loArr != null && c0417loArr.length > 0) {
            int i = 0;
            while (true) {
                C0417lo[] c0417loArr2 = this.f1027a;
                if (i >= c0417loArr2.length) {
                    break;
                }
                C0417lo c0417lo = c0417loArr2[i];
                if (c0417lo != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0417lo) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0417lo[] c0417loArr = this.f1027a;
        if (c0417loArr != null && c0417loArr.length > 0) {
            int i = 0;
            while (true) {
                C0417lo[] c0417loArr2 = this.f1027a;
                if (i >= c0417loArr2.length) {
                    break;
                }
                C0417lo c0417lo = c0417loArr2[i];
                if (c0417lo != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0417lo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0495oo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0417lo[] c0417loArr = this.f1027a;
                int length = c0417loArr == null ? 0 : c0417loArr.length;
                int i = repeatedFieldArrayLength + length;
                C0417lo[] c0417loArr2 = new C0417lo[i];
                if (length != 0) {
                    System.arraycopy(c0417loArr, 0, c0417loArr2, 0, length);
                }
                while (length < i - 1) {
                    C0417lo c0417lo = new C0417lo();
                    c0417loArr2[length] = c0417lo;
                    codedInputByteBufferNano.readMessage(c0417lo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0417lo c0417lo2 = new C0417lo();
                c0417loArr2[length] = c0417lo2;
                codedInputByteBufferNano.readMessage(c0417lo2);
                this.f1027a = c0417loArr2;
            }
        }
        return this;
    }

    public static C0495oo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0495oo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0495oo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0495oo) MessageNano.mergeFrom(new C0495oo(), bArr);
    }
}
