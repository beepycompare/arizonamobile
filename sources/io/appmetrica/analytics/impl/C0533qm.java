package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.qm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0533qm extends MessageNano {
    public static volatile C0533qm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1080a;
    public C0508pm b;

    public C0533qm() {
        a();
    }

    public static C0533qm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0533qm[0];
                }
            }
        }
        return c;
    }

    public final C0533qm a() {
        this.f1080a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1080a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1080a);
        }
        C0508pm c0508pm = this.b;
        return c0508pm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0508pm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1080a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1080a);
        }
        C0508pm c0508pm = this.b;
        if (c0508pm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0508pm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0533qm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1080a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0508pm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0533qm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0533qm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0533qm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0533qm) MessageNano.mergeFrom(new C0533qm(), bArr);
    }
}
