package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Uk extends MessageNano {
    public static volatile Uk[] b;

    /* renamed from: a  reason: collision with root package name */
    public Vk[] f704a;

    public Uk() {
        a();
    }

    public static Uk[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Uk[0];
                }
            }
        }
        return b;
    }

    public final Uk a() {
        this.f704a = Vk.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Vk[] vkArr = this.f704a;
        if (vkArr != null && vkArr.length > 0) {
            int i = 0;
            while (true) {
                Vk[] vkArr2 = this.f704a;
                if (i >= vkArr2.length) {
                    break;
                }
                Vk vk = vkArr2[i];
                if (vk != null) {
                    computeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(1, vk) + computeSerializedSize;
                }
                i++;
            }
        }
        return computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Vk[] vkArr = this.f704a;
        if (vkArr != null && vkArr.length > 0) {
            int i = 0;
            while (true) {
                Vk[] vkArr2 = this.f704a;
                if (i >= vkArr2.length) {
                    break;
                }
                Vk vk = vkArr2[i];
                if (vk != null) {
                    codedOutputByteBufferNano.writeMessage(1, vk);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Uk mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Vk[] vkArr = this.f704a;
                int length = vkArr == null ? 0 : vkArr.length;
                int i = repeatedFieldArrayLength + length;
                Vk[] vkArr2 = new Vk[i];
                if (length != 0) {
                    System.arraycopy(vkArr, 0, vkArr2, 0, length);
                }
                while (length < i - 1) {
                    Vk vk = new Vk();
                    vkArr2[length] = vk;
                    codedInputByteBufferNano.readMessage(vk);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Vk vk2 = new Vk();
                vkArr2[length] = vk2;
                codedInputByteBufferNano.readMessage(vk2);
                this.f704a = vkArr2;
            }
        }
        return this;
    }

    public static Uk b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Uk().mergeFrom(codedInputByteBufferNano);
    }

    public static Uk a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Uk) MessageNano.mergeFrom(new Uk(), bArr);
    }
}
