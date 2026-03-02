package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
/* compiled from: JsonStreams.kt */
@JsonFriendModuleApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004J\n\u0010\u0006\u001a\u00020\u0007H¦\u0080\u0004J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0086\u0080\u0004R\u0013\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/json/internal/InternalJsonReaderCodePointImpl;", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "<init>", "()V", "exhausted", "", "nextCodePoint", "", "bufferedChar", "", "Ljava/lang/Character;", "read", "buffer", "", "bufferOffset", "count", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InternalJsonReaderCodePointImpl implements InternalJsonReader {
    private Character bufferedChar;

    public abstract boolean exhausted();

    public abstract int nextCodePoint();

    @Override // kotlinx.serialization.json.internal.InternalJsonReader
    public final int read(char[] buffer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Character ch = this.bufferedChar;
        if (ch != null) {
            Intrinsics.checkNotNull(ch);
            buffer[i] = ch.charValue();
            this.bufferedChar = null;
            i3 = 1;
        } else {
            i3 = 0;
        }
        while (i3 < i2 && !exhausted()) {
            int nextCodePoint = nextCodePoint();
            if (nextCodePoint <= 65535) {
                buffer[i + i3] = (char) nextCodePoint;
                i3++;
            } else {
                char c = (char) ((nextCodePoint & 1023) + Utf8.LOG_SURROGATE_HEADER);
                buffer[i + i3] = (char) ((nextCodePoint >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                int i4 = i3 + 1;
                if (i4 < i2) {
                    buffer[i4 + i] = c;
                    i3 += 2;
                } else {
                    this.bufferedChar = Character.valueOf(c);
                    i3 = i4;
                }
            }
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }
}
