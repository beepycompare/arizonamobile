package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Region.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\f\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\f\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\f\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\f\u001a\u0015\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\f\u001a\u0015\u0010\r\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\f\u001a3\u0010\u000e\u001a\u00020\u000f*\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000f0\u0011H\u0086\bø\u0001\u0000\u001a\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016*\u00020\u0002H\u0086\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"contains", "", "Landroid/graphics/Region;", TtmlNode.TAG_P, "Landroid/graphics/Point;", "plus", "r", "Landroid/graphics/Rect;", "minus", "unaryMinus", "not", "or", "and", "xor", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RegionKt {
    public static final boolean contains(Region region, Point p) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(p, "p");
        return region.contains(p.x, p.y);
    }

    public static final Region plus(Region region, Rect r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.union(r);
        return region2;
    }

    public static final Region plus(Region region, Region r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.UNION);
        return region2;
    }

    public static final Region minus(Region region, Rect r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region minus(Region region, Region r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region unaryMinus(Region region) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region and(Region region, Rect r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.INTERSECT);
        return region2;
    }

    public static final Region and(Region region, Region r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.INTERSECT);
        return region2;
    }

    public static final Region xor(Region region, Rect r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.XOR);
        return region2;
    }

    public static final Region xor(Region region, Region r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.XOR);
        return region2;
    }

    public static final void forEach(Region region, Function1<? super Rect, Unit> action) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            }
            action.invoke(rect);
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        return new RegionKt$iterator$1(region);
    }

    public static final Region not(Region region) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region region, Rect r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.union(r);
        return region2;
    }

    public static final Region or(Region region, Region r) {
        Intrinsics.checkNotNullParameter(region, "<this>");
        Intrinsics.checkNotNullParameter(r, "r");
        Region region2 = new Region(region);
        region2.op(r, Region.Op.UNION);
        return region2;
    }
}
