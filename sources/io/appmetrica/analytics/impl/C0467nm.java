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
public final class C0467nm extends MessageNano {
    public static volatile C0467nm[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0442mm[] f974a;

    public C0467nm() {
        a();
    }

    public static C0467nm[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0467nm[0];
                }
            }
        }
        return b;
    }

    public final C0467nm a() {
        this.f974a = C0442mm.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0442mm[] c0442mmArr = this.f974a;
        if (c0442mmArr != null && c0442mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0442mm[] c0442mmArr2 = this.f974a;
                if (i >= c0442mmArr2.length) {
                    break;
                }
                C0442mm c0442mm = c0442mmArr2[i];
                if (c0442mm != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, c0442mm) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0442mm[] c0442mmArr = this.f974a;
        if (c0442mmArr != null && c0442mmArr.length > 0) {
            int i = 0;
            while (true) {
                C0442mm[] c0442mmArr2 = this.f974a;
                if (i >= c0442mmArr2.length) {
                    break;
                }
                C0442mm c0442mm = c0442mmArr2[i];
                if (c0442mm != null) {
                    codedOutputByteBufferNano.writeMessage(1, c0442mm);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0467nm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C0442mm[] c0442mmArr = this.f974a;
                int length = c0442mmArr == null ? 0 : c0442mmArr.length;
                int i = repeatedFieldArrayLength + length;
                C0442mm[] c0442mmArr2 = new C0442mm[i];
                if (length != 0) {
                    System.arraycopy(c0442mmArr, 0, c0442mmArr2, 0, length);
                }
                while (length < i - 1) {
                    C0442mm c0442mm = new C0442mm();
                    c0442mmArr2[length] = c0442mm;
                    codedInputByteBufferNano.readMessage(c0442mm);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C0442mm c0442mm2 = new C0442mm();
                c0442mmArr2[length] = c0442mm2;
                codedInputByteBufferNano.readMessage(c0442mm2);
                this.f974a = c0442mmArr2;
            }
        }
        return this;
    }

    public static C0467nm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0467nm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0467nm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0467nm) MessageNano.mergeFrom(new C0467nm(), bArr);
    }
}
