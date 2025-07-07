package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Options.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0016B!\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "<init>", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "getTrie$okio", "()[I", "size", "", "getSize", "()I", "get", FirebaseAnalytics.Param.INDEX, "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    /* compiled from: Options.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\tJT\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0012H\u0002R\u0018\u0010\u0016\u001a\u00020\r*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokio/Options$Companion;", "", "<init>", "()V", "of", "Lokio/Options;", "byteStrings", "", "Lokio/ByteString;", "([Lokio/ByteString;)Lokio/Options;", "buildTrieRecursive", "", "nodeOffset", "", "node", "Lokio/Buffer;", "byteStringOffset", "", "", "fromIndex", "toIndex", "indexes", "intCount", "getIntCount", "(Lokio/Buffer;)J", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ce, code lost:
            continue;
         */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options of(ByteString... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, null);
            }
            List mutableList = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.sort(mutableList);
            int size = mutableList.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add(-1);
            }
            ArrayList arrayList2 = arrayList;
            int length = byteStrings.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                arrayList2.set(CollectionsKt.binarySearch$default(mutableList, byteStrings[i2], 0, 0, 6, (Object) null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((ByteString) mutableList.get(0)).size() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i4 = 0;
            while (i4 < mutableList.size()) {
                ByteString byteString = (ByteString) mutableList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < mutableList.size()) {
                    ByteString byteString2 = (ByteString) mutableList.get(i6);
                    if (byteString2.startsWith(byteString)) {
                        if (byteString2.size() == byteString.size()) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString2).toString());
                        }
                        if (((Number) arrayList2.get(i6)).intValue() > ((Number) arrayList2.get(i4)).intValue()) {
                            mutableList.remove(i6);
                            ((Number) arrayList2.remove(i6)).intValue();
                        } else {
                            i6++;
                        }
                    }
                }
                i4 = i5;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive$default(this, 0L, buffer, 0, mutableList, 0, 0, arrayList2, 53, null);
            int intCount = (int) getIntCount(buffer);
            int[] iArr = new int[intCount];
            for (int i7 = 0; i7 < intCount; i7++) {
                iArr[i7] = buffer.readInt();
            }
            Object[] copyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            return new Options((ByteString[]) copyOf, iArr, null);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j = 0;
            }
            companion.buildTrieRecursive(j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final void buildTrieRecursive(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            long j2;
            int i7 = i;
            if (i2 >= i3) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i8 = i2; i8 < i3; i8++) {
                if (list.get(i8).size() < i7) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            if (i7 == byteString.size()) {
                int i9 = i2 + 1;
                i4 = i9;
                i5 = list2.get(i2).intValue();
                byteString = list.get(i9);
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (byteString.getByte(i7) != byteString2.getByte(i7)) {
                int i10 = 1;
                for (int i11 = i4 + 1; i11 < i3; i11++) {
                    if (list.get(i11 - 1).getByte(i7) != list.get(i11).getByte(i7)) {
                        i10++;
                    }
                }
                long intCount = j + getIntCount(buffer) + 2 + (i10 * 2);
                buffer.writeInt(i10);
                buffer.writeInt(i5);
                for (int i12 = i4; i12 < i3; i12++) {
                    byte b = list.get(i12).getByte(i7);
                    if (i12 == i4 || b != list.get(i12 - 1).getByte(i7)) {
                        buffer.writeInt(b & 255);
                    }
                }
                Buffer buffer2 = new Buffer();
                while (i4 < i3) {
                    byte b2 = list.get(i4).getByte(i7);
                    int i13 = i4 + 1;
                    int i14 = i13;
                    while (true) {
                        if (i14 >= i3) {
                            i6 = i3;
                            break;
                        } else if (b2 != list.get(i14).getByte(i7)) {
                            i6 = i14;
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (i13 == i6 && i7 + 1 == list.get(i4).size()) {
                        buffer.writeInt(list2.get(i4).intValue());
                        j2 = intCount;
                    } else {
                        buffer.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                        j2 = intCount;
                        buildTrieRecursive(j2, buffer2, i7 + 1, list, i4, i6, list2);
                    }
                    intCount = j2;
                    i4 = i6;
                }
                Long.valueOf(buffer.writeAll(buffer2));
                return;
            }
            int min = Math.min(byteString.size(), byteString2.size());
            int i15 = 0;
            for (int i16 = i7; i16 < min && byteString.getByte(i16) == byteString2.getByte(i16); i16++) {
                i15++;
            }
            long intCount2 = j + getIntCount(buffer) + 2 + i15 + 1;
            buffer.writeInt(-i15);
            buffer.writeInt(i5);
            int i17 = i7 + i15;
            while (i7 < i17) {
                buffer.writeInt(byteString.getByte(i7) & 255);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (i17 != list.get(i4).size()) {
                    throw new IllegalStateException("Check failed.");
                }
                buffer.writeInt(list2.get(i4).intValue());
                return;
            }
            Buffer buffer3 = new Buffer();
            buffer.writeInt(((int) (getIntCount(buffer3) + intCount2)) * (-1));
            buildTrieRecursive(intCount2, buffer3, i17, list, i4, i3, list2);
            Long.valueOf(buffer.writeAll(buffer3));
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }
    }
}
