package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.rm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0564rm extends MessageNano {
    public static volatile C0564rm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1050a;
    public C0540qm b;

    public C0564rm() {
        a();
    }

    public static C0564rm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0564rm[0];
                }
            }
        }
        return c;
    }

    public final C0564rm a() {
        this.f1050a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1050a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1050a);
        }
        C0540qm c0540qm = this.b;
        return c0540qm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0540qm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1050a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1050a);
        }
        C0540qm c0540qm = this.b;
        if (c0540qm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0540qm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0564rm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1050a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0540qm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0564rm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0564rm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0564rm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0564rm) MessageNano.mergeFrom(new C0564rm(), bArr);
    }
}
