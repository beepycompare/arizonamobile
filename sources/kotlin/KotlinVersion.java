package kotlin;

import com.facebook.internal.NativeProtocol;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: KotlinVersion.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0011\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "patch", "<init>", "(III)V", "(II)V", "getMajor", "()I", "getMinor", "getPatch", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "versionOf", "toString", "", "equals", "", "other", "", "hashCode", "compareTo", "isAtLeast", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;
    public static final Companion Companion = new Companion(null);
    public static final KotlinVersion CURRENT = KotlinVersionCurrentValue.get();

    public KotlinVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        this.version = versionOf(i, i2, i3);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public KotlinVersion(int i, int i2) {
        this(i, i2, 0);
    }

    private final int versionOf(int i, int i2, int i3) {
        if (i < 0 || i >= 256 || i2 < 0 || i2 >= 256 || i3 < 0 || i3 >= 256) {
            throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
        }
        return (i << 16) + (i2 << 8) + i3;
    }

    public String toString() {
        return new StringBuilder().append(this.major).append('.').append(this.minor).append('.').append(this.patch).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.version == kotlinVersion.version;
    }

    public int hashCode() {
        return this.version;
    }

    @Override // java.lang.Comparable
    public int compareTo(KotlinVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.version - other.version;
    }

    public final boolean isAtLeast(int i, int i2) {
        int i3 = this.major;
        if (i3 <= i) {
            return i3 == i && this.minor >= i2;
        }
        return true;
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.major;
        if (i4 <= i) {
            if (i4 == i) {
                int i5 = this.minor;
                if (i5 <= i2) {
                    return i5 == i2 && this.patch >= i3;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* compiled from: KotlinVersion.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "", "<init>", "()V", "MAX_COMPONENT_VALUE", "", "CURRENT", "Lkotlin/KotlinVersion;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
