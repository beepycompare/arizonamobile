package io.appmetrica.analytics.coreapi.internal.model;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lio/appmetrica/analytics/coreapi/internal/model/ScreenInfo;", "", "", "component1", "component2", "component3", "", "component4", "width", "height", "dpi", "scaleFactor", "copy", "", "toString", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "getWidth", "()I", "b", "getHeight", "c", "getDpi", "d", "F", "getScaleFactor", "()F", "<init>", "(IIIF)V", "core-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class ScreenInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f247a;
    private final int b;
    private final int c;
    private final float d;

    public ScreenInfo(int i, int i2, int i3, float f) {
        this.f247a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
    }

    public static /* synthetic */ ScreenInfo copy$default(ScreenInfo screenInfo, int i, int i2, int i3, float f, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = screenInfo.f247a;
        }
        if ((i4 & 2) != 0) {
            i2 = screenInfo.b;
        }
        if ((i4 & 4) != 0) {
            i3 = screenInfo.c;
        }
        if ((i4 & 8) != 0) {
            f = screenInfo.d;
        }
        return screenInfo.copy(i, i2, i3, f);
    }

    public final int component1() {
        return this.f247a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final float component4() {
        return this.d;
    }

    public final ScreenInfo copy(int i, int i2, int i3, float f) {
        return new ScreenInfo(i, i2, i3, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ScreenInfo) {
            ScreenInfo screenInfo = (ScreenInfo) obj;
            return this.f247a == screenInfo.f247a && this.b == screenInfo.b && this.c == screenInfo.c && Intrinsics.areEqual((Object) Float.valueOf(this.d), (Object) Float.valueOf(screenInfo.d));
        }
        return false;
    }

    public final int getDpi() {
        return this.c;
    }

    public final int getHeight() {
        return this.b;
    }

    public final float getScaleFactor() {
        return this.d;
    }

    public final int getWidth() {
        return this.f247a;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.b);
        int hashCode2 = Integer.hashCode(this.c);
        return Float.hashCode(this.d) + ((hashCode2 + ((hashCode + (Integer.hashCode(this.f247a) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "ScreenInfo(width=" + this.f247a + ", height=" + this.b + ", dpi=" + this.c + ", scaleFactor=" + this.d + ')';
    }
}
