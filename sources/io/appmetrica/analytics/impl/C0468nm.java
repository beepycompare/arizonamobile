package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0468nm extends MessageNano {
    public static volatile C0468nm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0443mm[] f974a;

    public C0468nm() {
        a();
    }

    public static C0468nm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0468nm[0];
                }
            }
        }
        return b;
    }

    public final C0468nm a() {
        this.f974a = C0443mm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0443mm[] c0443mmArr = this.f974a;
        if (c0443mmArr != null && c0443mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0443mm[] c0443mmArr2 = this.f974a;
                if (i >= c0443mmArr2.length) {
                    break;
                }
                C0443mm c0443mm = c0443mmArr2[i];
                if (c0443mm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0443mm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0443mm[] c0443mmArr = this.f974a;
        if (c0443mmArr != null && c0443mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0443mm[] c0443mmArr2 = this.f974a;
                if (i >= c0443mmArr2.length) {
                    break;
                }
                C0443mm c0443mm = c0443mmArr2[i];
                if (c0443mm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0443mm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0468nm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0443mm[] c0443mmArr = this.f974a;
                int length = c0443mmArr == null ? 0 : c0443mmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0443mm[] c0443mmArr2 = new C0443mm[i];
                if (length != 0) {
                    System.arraycopy(c0443mmArr, 0, c0443mmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0443mm c0443mm = new C0443mm();
                    c0443mmArr2[length] = c0443mm;
                    codedInputByteBufferNano.readMessage(c0443mm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0443mm c0443mm2 = new C0443mm();
                c0443mmArr2[length] = c0443mm2;
                codedInputByteBufferNano.readMessage(c0443mm2);
                this.f974a = c0443mmArr2;
            }
        }
        return this;
    }

    public static C0468nm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0468nm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0468nm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0468nm) MessageNano.mergeFrom(new C0468nm(), bArr);
    }
}
