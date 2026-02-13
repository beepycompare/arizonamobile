package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0461nm extends MessageNano {
    public static volatile C0461nm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0436mm[] f1142a;

    public C0461nm() {
        a();
    }

    public static C0461nm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0461nm[0];
                }
            }
        }
        return b;
    }

    public final C0461nm a() {
        this.f1142a = C0436mm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0436mm[] c0436mmArr = this.f1142a;
        if (c0436mmArr != null && c0436mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0436mm[] c0436mmArr2 = this.f1142a;
                if (i >= c0436mmArr2.length) {
                    break;
                }
                C0436mm c0436mm = c0436mmArr2[i];
                if (c0436mm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0436mm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0436mm[] c0436mmArr = this.f1142a;
        if (c0436mmArr != null && c0436mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0436mm[] c0436mmArr2 = this.f1142a;
                if (i >= c0436mmArr2.length) {
                    break;
                }
                C0436mm c0436mm = c0436mmArr2[i];
                if (c0436mm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0436mm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0461nm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0436mm[] c0436mmArr = this.f1142a;
                int length = c0436mmArr == null ? 0 : c0436mmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0436mm[] c0436mmArr2 = new C0436mm[i];
                if (length != 0) {
                    System.arraycopy(c0436mmArr, 0, c0436mmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0436mm c0436mm = new C0436mm();
                    c0436mmArr2[length] = c0436mm;
                    codedInputByteBufferNano.readMessage(c0436mm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0436mm c0436mm2 = new C0436mm();
                c0436mmArr2[length] = c0436mm2;
                codedInputByteBufferNano.readMessage(c0436mm2);
                this.f1142a = c0436mmArr2;
            }
        }
        return this;
    }

    public static C0461nm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0461nm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0461nm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0461nm) MessageNano.mergeFrom(new C0461nm(), bArr);
    }
}
