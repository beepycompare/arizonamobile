package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.mm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0435mm extends MessageNano {
    public static volatile C0435mm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1123a;
    public C0410lm b;

    public C0435mm() {
        a();
    }

    public static C0435mm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0435mm[0];
                }
            }
        }
        return c;
    }

    public final C0435mm a() {
        this.f1123a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1123a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1123a);
        }
        C0410lm c0410lm = this.b;
        return c0410lm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0410lm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1123a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1123a);
        }
        C0410lm c0410lm = this.b;
        if (c0410lm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0410lm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0435mm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1123a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0410lm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0435mm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0435mm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0435mm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0435mm) MessageNano.mergeFrom(new C0435mm(), bArr);
    }
}
