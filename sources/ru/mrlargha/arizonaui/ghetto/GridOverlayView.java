package ru.mrlargha.arizonaui.ghetto;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ru.mrlargha.arizonaui.R;
import ru.mrlargha.arizonaui.ghetto.data.MapData;
import ru.mrlargha.arizonaui.ghetto.data.TerritoryOrderKt;
import ru.mrlargha.arizonaui.ghetto.data.UniqData;
/* compiled from: MapOverlay.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002NOB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fJ*\u00100\u001a\u00020)2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014J\b\u00102\u001a\u00020)H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010'2\u0006\u00104\u001a\u00020\tH\u0002J,\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\b\b\u0002\u00108\u001a\u0002092\b\u00101\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010:\u001a\u00020)2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0002J\u0016\u0010<\u001a\u00020)2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J\u0010\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?H\u0014J`\u0010@\u001a\u00020)2\u0006\u0010>\u001a\u00020?2\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u000209H\u0002J\u0014\u0010L\u001a\u00020'*\u00020\u00032\u0006\u0010M\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010'0&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GridOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "gridSize", "", "paint", "Landroid/graphics/Paint;", "imageView", "Lcom/davemorrissey/labs/subscaleview/SubsamplingScaleImageView;", "cellData", "", "Lru/mrlargha/arizonaui/ghetto/GridOverlayView$Cell;", "uniqueData", "Lru/mrlargha/arizonaui/ghetto/GridOverlayView$UniqueCell;", "_mapData", "", "Lru/mrlargha/arizonaui/ghetto/data/MapData;", "get_mapData", "()Ljava/util/List;", "set_mapData", "(Ljava/util/List;)V", "_uniqueData", "Lru/mrlargha/arizonaui/ghetto/data/UniqData;", "get_uniqueData", "set_uniqueData", "xMargin", "", "yMargin", "cellWidth", "cellHeight", "uniqColor", "strokeColor", "bitmapCache", "", "Landroid/graphics/Bitmap;", "setLinkedImageView", "", "view", "mapCell", "marginX", "marginY", "wight", "height", "setDataAndTryToDraw", "mapData", "calculateCells", "getBitmap", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "calculateCell", FirebaseAnalytics.Param.INDEX, "famColor", "isUniq", "", "setCellData", "data", "setUniqueData", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawCell", "cell", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "visibleRegion", "Landroid/graphics/RectF;", "iv", "halfStroke", "strokeWidth", "isUnique", "drawableToBitmap", "drawableId", "Cell", "UniqueCell", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridOverlayView extends View {
    private List<MapData> _mapData;
    private List<UniqData> _uniqueData;
    private final Map<Integer, Bitmap> bitmapCache;
    private final List<Cell> cellData;
    private float cellHeight;
    private float cellWidth;
    private int gridSize;
    private SubsamplingScaleImageView imageView;
    private final Paint paint;
    private final int strokeColor;
    private final int uniqColor;
    private final List<UniqueCell> uniqueData;
    private float xMargin;
    private float yMargin;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GridOverlayView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gridSize = 12;
        this.paint = new Paint(1);
        this.cellData = new ArrayList();
        this.uniqueData = new ArrayList();
        this._mapData = CollectionsKt.emptyList();
        this._uniqueData = CollectionsKt.emptyList();
        this.cellWidth = 85.0f;
        this.cellHeight = 85.0f;
        this.uniqColor = Color.parseColor("#FFC500");
        this.strokeColor = Color.parseColor("#303030");
        this.bitmapCache = new LinkedHashMap();
    }

    public /* synthetic */ GridOverlayView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* compiled from: MapOverlay.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GridOverlayView$Cell;", "", "row", "", "col", "color", "bitmap", "Landroid/graphics/Bitmap;", "isNotEmpty", "", "isUnique", "useColorStroke", "<init>", "(IIILandroid/graphics/Bitmap;ZZZ)V", "getRow", "()I", "getCol", "getColor", "getBitmap", "()Landroid/graphics/Bitmap;", "()Z", "getUseColorStroke", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Cell {
        private final Bitmap bitmap;
        private final int col;
        private final int color;
        private final boolean isNotEmpty;
        private final boolean isUnique;
        private final int row;
        private final boolean useColorStroke;

        public static /* synthetic */ Cell copy$default(Cell cell, int i, int i2, int i3, Bitmap bitmap, boolean z, boolean z2, boolean z3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = cell.row;
            }
            if ((i4 & 2) != 0) {
                i2 = cell.col;
            }
            if ((i4 & 4) != 0) {
                i3 = cell.color;
            }
            if ((i4 & 8) != 0) {
                bitmap = cell.bitmap;
            }
            if ((i4 & 16) != 0) {
                z = cell.isNotEmpty;
            }
            if ((i4 & 32) != 0) {
                z2 = cell.isUnique;
            }
            if ((i4 & 64) != 0) {
                z3 = cell.useColorStroke;
            }
            boolean z4 = z2;
            boolean z5 = z3;
            boolean z6 = z;
            int i5 = i3;
            return cell.copy(i, i2, i5, bitmap, z6, z4, z5);
        }

        public final int component1() {
            return this.row;
        }

        public final int component2() {
            return this.col;
        }

        public final int component3() {
            return this.color;
        }

        public final Bitmap component4() {
            return this.bitmap;
        }

        public final boolean component5() {
            return this.isNotEmpty;
        }

        public final boolean component6() {
            return this.isUnique;
        }

        public final boolean component7() {
            return this.useColorStroke;
        }

        public final Cell copy(int i, int i2, int i3, Bitmap bitmap, boolean z, boolean z2, boolean z3) {
            return new Cell(i, i2, i3, bitmap, z, z2, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Cell) {
                Cell cell = (Cell) obj;
                return this.row == cell.row && this.col == cell.col && this.color == cell.color && Intrinsics.areEqual(this.bitmap, cell.bitmap) && this.isNotEmpty == cell.isNotEmpty && this.isUnique == cell.isUnique && this.useColorStroke == cell.useColorStroke;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((Integer.hashCode(this.row) * 31) + Integer.hashCode(this.col)) * 31) + Integer.hashCode(this.color)) * 31;
            Bitmap bitmap = this.bitmap;
            return ((((((hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31) + Boolean.hashCode(this.isNotEmpty)) * 31) + Boolean.hashCode(this.isUnique)) * 31) + Boolean.hashCode(this.useColorStroke);
        }

        public String toString() {
            int i = this.row;
            int i2 = this.col;
            int i3 = this.color;
            Bitmap bitmap = this.bitmap;
            boolean z = this.isNotEmpty;
            boolean z2 = this.isUnique;
            return "Cell(row=" + i + ", col=" + i2 + ", color=" + i3 + ", bitmap=" + bitmap + ", isNotEmpty=" + z + ", isUnique=" + z2 + ", useColorStroke=" + this.useColorStroke + ")";
        }

        public Cell(int i, int i2, int i3, Bitmap bitmap, boolean z, boolean z2, boolean z3) {
            this.row = i;
            this.col = i2;
            this.color = i3;
            this.bitmap = bitmap;
            this.isNotEmpty = z;
            this.isUnique = z2;
            this.useColorStroke = z3;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getCol() {
            return this.col;
        }

        public final int getColor() {
            return this.color;
        }

        public final int getRow() {
            return this.row;
        }

        public final boolean getUseColorStroke() {
            return this.useColorStroke;
        }

        public final boolean isNotEmpty() {
            return this.isNotEmpty;
        }

        public final boolean isUnique() {
            return this.isUnique;
        }
    }

    /* compiled from: MapOverlay.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lru/mrlargha/arizonaui/ghetto/GridOverlayView$UniqueCell;", "", "cell", "Lru/mrlargha/arizonaui/ghetto/GridOverlayView$Cell;", "height", "", "wight", "<init>", "(Lru/mrlargha/arizonaui/ghetto/GridOverlayView$Cell;II)V", "getCell", "()Lru/mrlargha/arizonaui/ghetto/GridOverlayView$Cell;", "getHeight", "()I", "getWight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UniqueCell {
        private final Cell cell;
        private final int height;
        private final int wight;

        public static /* synthetic */ UniqueCell copy$default(UniqueCell uniqueCell, Cell cell, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cell = uniqueCell.cell;
            }
            if ((i3 & 2) != 0) {
                i = uniqueCell.height;
            }
            if ((i3 & 4) != 0) {
                i2 = uniqueCell.wight;
            }
            return uniqueCell.copy(cell, i, i2);
        }

        public final Cell component1() {
            return this.cell;
        }

        public final int component2() {
            return this.height;
        }

        public final int component3() {
            return this.wight;
        }

        public final UniqueCell copy(Cell cell, int i, int i2) {
            Intrinsics.checkNotNullParameter(cell, "cell");
            return new UniqueCell(cell, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UniqueCell) {
                UniqueCell uniqueCell = (UniqueCell) obj;
                return Intrinsics.areEqual(this.cell, uniqueCell.cell) && this.height == uniqueCell.height && this.wight == uniqueCell.wight;
            }
            return false;
        }

        public int hashCode() {
            return (((this.cell.hashCode() * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.wight);
        }

        public String toString() {
            Cell cell = this.cell;
            int i = this.height;
            return "UniqueCell(cell=" + cell + ", height=" + i + ", wight=" + this.wight + ")";
        }

        public UniqueCell(Cell cell, int i, int i2) {
            Intrinsics.checkNotNullParameter(cell, "cell");
            this.cell = cell;
            this.height = i;
            this.wight = i2;
        }

        public final Cell getCell() {
            return this.cell;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWight() {
            return this.wight;
        }
    }

    public final List<MapData> get_mapData() {
        return this._mapData;
    }

    public final void set_mapData(List<MapData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this._mapData = list;
    }

    public final List<UniqData> get_uniqueData() {
        return this._uniqueData;
    }

    public final void set_uniqueData(List<UniqData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this._uniqueData = list;
    }

    public final void setLinkedImageView(SubsamplingScaleImageView view, int i, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.imageView = view;
        this.gridSize = i;
        this.xMargin = f;
        this.yMargin = f2;
        this.cellWidth = f3;
        this.cellHeight = f4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setDataAndTryToDraw$default(GridOverlayView gridOverlayView, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            list2 = null;
        }
        gridOverlayView.setDataAndTryToDraw(list, list2);
    }

    public final void setDataAndTryToDraw(List<MapData> list, List<UniqData> list2) {
        if (list2 != null) {
            this._uniqueData = list2;
        }
        if (list != null) {
            this._mapData = list;
        }
        if (this._mapData.isEmpty() || this._uniqueData.isEmpty()) {
            return;
        }
        calculateCells();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    private final void calculateCells() {
        Object obj;
        T t;
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        List<Number> mutableList = CollectionsKt.toMutableList((Collection) TerritoryOrderKt.getTerritoryOrder());
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(mutableList, 10));
        for (Number number : mutableList) {
            int intValue = number.intValue();
            Iterator<T> it = this._uniqueData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((UniqData) obj).getId() == intValue) {
                    break;
                }
            }
            UniqData uniqData = (UniqData) obj;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Iterator<T> it2 = this._mapData.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = 0;
                    break;
                }
                t = it2.next();
                if (((MapData) t).getId() == intValue) {
                    break;
                }
            }
            objectRef.element = t;
            if (uniqData != null) {
                MapData mapData = (MapData) objectRef.element;
                objectRef.element = mapData != null ? MapData.copy$default(mapData, 0, 0, 0L, 0, true, Long.valueOf(uniqData.getBalance()), Integer.valueOf(uniqData.getUkrop()), null, null, 399, null) : 0;
            }
            arrayList2.add((MapData) objectRef.element);
        }
        int i = 0;
        for (Object obj2 : arrayList2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MapData mapData2 = (MapData) obj2;
            arrayList.add(calculateCell(i, mapData2 != null ? mapData2.getFraction_id() : 0, mapData2 != null ? mapData2.isUniq() : false, mapData2));
            i = i2;
        }
        setCellData(arrayList);
    }

    private final Bitmap getBitmap(int i) {
        Bitmap drawableToBitmap;
        if (this.bitmapCache.get(Integer.valueOf(i)) == null) {
            if (i == -2) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                drawableToBitmap = drawableToBitmap(context, R.drawable.ghetto_guns);
            } else if (i == -1) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                drawableToBitmap = drawableToBitmap(context2, R.drawable.ghetto_plant);
            } else if (i != 25) {
                switch (i) {
                    case 11:
                        Context context3 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                        drawableToBitmap = drawableToBitmap(context3, R.drawable.ghetto_resp_ic_1);
                        break;
                    case 12:
                        Context context4 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                        drawableToBitmap = drawableToBitmap(context4, R.drawable.ghetto_resp_ic_5);
                        break;
                    case 13:
                        Context context5 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                        drawableToBitmap = drawableToBitmap(context5, R.drawable.ghetto_resp_ic_4);
                        break;
                    case 14:
                        Context context6 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                        drawableToBitmap = drawableToBitmap(context6, R.drawable.ghetto_resp_ic_2);
                        break;
                    case 15:
                        Context context7 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
                        drawableToBitmap = drawableToBitmap(context7, R.drawable.ghetto_resp_ic_3);
                        break;
                    default:
                        drawableToBitmap = null;
                        break;
                }
            } else {
                Context context8 = getContext();
                Intrinsics.checkNotNullExpressionValue(context8, "getContext(...)");
                drawableToBitmap = drawableToBitmap(context8, R.drawable.ghetto_resp_ic_6);
            }
            this.bitmapCache.put(Integer.valueOf(i), drawableToBitmap);
        }
        return this.bitmapCache.get(Integer.valueOf(i));
    }

    static /* synthetic */ Cell calculateCell$default(GridOverlayView gridOverlayView, int i, int i2, boolean z, MapData mapData, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return gridOverlayView.calculateCell(i, i2, z, mapData);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Cell calculateCell(int i, int i2, boolean z, MapData mapData) {
        int parseColor;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean z3;
        int i3 = this.gridSize;
        int i4 = i / i3;
        int i5 = i % i3;
        if (mapData != null) {
            Boolean drugden = mapData.getDrugden();
            if (drugden != null ? drugden.booleanValue() : false) {
                parseColor = Color.parseColor(ColorsKt.ghettoColors(-2));
                z2 = true;
                if (!z) {
                    bitmap2 = getBitmap(-1);
                } else {
                    bitmap = null;
                    if (mapData != null) {
                        Integer respawn_fraction_id = mapData.getRespawn_fraction_id();
                        if ((respawn_fraction_id != null ? respawn_fraction_id.intValue() : 0) > 10) {
                            Integer respawn_fraction_id2 = mapData.getRespawn_fraction_id();
                            if (respawn_fraction_id2 != null) {
                                bitmap = getBitmap(respawn_fraction_id2.intValue());
                                z3 = true;
                                return new Cell(i4, i5, parseColor, bitmap, true, z, z3);
                            }
                            z3 = z2;
                            return new Cell(i4, i5, parseColor, bitmap, true, z, z3);
                        }
                    }
                    if (mapData != null) {
                        Boolean drugden2 = mapData.getDrugden();
                        if (drugden2 != null ? drugden2.booleanValue() : false) {
                            bitmap2 = getBitmap(-2);
                        }
                    }
                    z3 = z2;
                    return new Cell(i4, i5, parseColor, bitmap, true, z, z3);
                }
                bitmap = bitmap2;
                z3 = z2;
                return new Cell(i4, i5, parseColor, bitmap, true, z, z3);
            }
        }
        parseColor = Color.parseColor(ColorsKt.ghettoColors(i2));
        z2 = false;
        if (!z) {
        }
        bitmap = bitmap2;
        z3 = z2;
        return new Cell(i4, i5, parseColor, bitmap, true, z, z3);
    }

    private final void setCellData(List<Cell> list) {
        this.cellData.clear();
        this.cellData.addAll(list);
        invalidate();
    }

    private final void setUniqueData(List<UniqueCell> list) {
        this.uniqueData.clear();
        this.uniqueData.addAll(list);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        SubsamplingScaleImageView subsamplingScaleImageView = this.imageView;
        if (subsamplingScaleImageView != null && subsamplingScaleImageView.isReady()) {
            subsamplingScaleImageView.getSWidth();
            subsamplingScaleImageView.getSHeight();
            float scale = subsamplingScaleImageView.getScale();
            float width = getWidth();
            float height = getHeight();
            PointF center = subsamplingScaleImageView.getCenter();
            if (center == null) {
                center = new PointF();
            }
            float f = 2.0f * scale;
            float f2 = width / f;
            float f3 = height / f;
            RectF rectF = new RectF(center.x - f2, center.y - f3, center.x + f2, center.y + f3);
            float f4 = scale * 2.0f;
            float f5 = f4 / 2.0f;
            for (Cell cell : this.cellData) {
                if (cell.isNotEmpty()) {
                    float col = (cell.getCol() * this.cellWidth) + this.xMargin;
                    float f6 = this.cellHeight;
                    float row = this.yMargin + (cell.getRow() * f6);
                    drawCell(canvas, cell, col, row, col + this.cellWidth, row + f6, rectF, subsamplingScaleImageView, f5, f4, cell.isUnique());
                }
            }
        }
    }

    private final void drawCell(Canvas canvas, Cell cell, float f, float f2, float f3, float f4, RectF rectF, SubsamplingScaleImageView subsamplingScaleImageView, float f5, float f6, boolean z) {
        int color;
        if (RectF.intersects(rectF, new RectF(f, f2, f3, f4))) {
            PointF sourceToViewCoord = subsamplingScaleImageView.sourceToViewCoord(new PointF(f, f2));
            if (sourceToViewCoord == null) {
                sourceToViewCoord = new PointF();
            }
            PointF sourceToViewCoord2 = subsamplingScaleImageView.sourceToViewCoord(new PointF(f3, f4));
            if (sourceToViewCoord2 == null) {
                sourceToViewCoord2 = new PointF();
            }
            RectF rectF2 = new RectF(sourceToViewCoord.x, sourceToViewCoord.y, sourceToViewCoord2.x, sourceToViewCoord2.y);
            RectF rectF3 = new RectF(rectF2.left + f5, rectF2.top + f5, rectF2.right - f5, rectF2.bottom - f5);
            this.paint.setColor(cell.getColor());
            this.paint.setAlpha(180);
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(rectF2, this.paint);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(f6);
            Paint paint = this.paint;
            if (z) {
                color = this.uniqColor;
            } else {
                color = cell.getUseColorStroke() ? cell.getColor() : this.strokeColor;
            }
            paint.setColor(color);
            this.paint.setAlpha(255);
            canvas.drawRect(rectF3, this.paint);
            Bitmap bitmap = cell.getBitmap();
            if (bitmap != null) {
                float width = (rectF2.width() * 0.65f) / 2.0f;
                float height = (rectF2.height() * 0.65f) / 2.0f;
                canvas.drawBitmap(bitmap, (Rect) null, new RectF(rectF2.centerX() - width, rectF2.centerY() - height, rectF2.centerX() + width, rectF2.centerY() + height), (Paint) null);
            }
        }
    }

    private final Bitmap drawableToBitmap(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        Intrinsics.checkNotNull(drawable);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }
}
