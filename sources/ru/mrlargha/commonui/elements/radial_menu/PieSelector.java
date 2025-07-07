package ru.mrlargha.commonui.elements.radial_menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView;
/* compiled from: PieSelector.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002klB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0014J\u0018\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0014J(\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0014J\u0010\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020NH\u0016J\u0014\u0010O\u001a\u00020A2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QJ\u0014\u0010S\u001a\u00020A2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020U0QJ\u0018\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020\u0015H\u0002J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\u0007H\u0002J\u0018\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0013H\u0002J.\u0010b\u001a\u00020A2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020`0Q2\u0006\u0010d\u001a\u00020\u00152\u0006\u0010a\u001a\u00020\u00132\u0006\u0010B\u001a\u00020CH\u0002J\u001e\u0010e\u001a\u00020\u00072\f\u0010c\u001a\b\u0012\u0004\u0012\u00020`0Q2\u0006\u0010a\u001a\u00020\u0013H\u0002J\u0018\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0015H\u0002J\u0018\u0010f\u001a\u00020!2\u0006\u0010g\u001a\u00020W2\u0006\u0010h\u001a\u00020WH\u0002J\f\u0010i\u001a\u00020\u0015*\u00020\u0015H\u0002J\u0014\u0010j\u001a\u00020\u0007*\u00020W2\u0006\u0010h\u001a\u00020WH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u000e\u0010-\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010=\u001a\f\u0012\b\u0012\u00060?R\u00020\u00000>X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/PieSelector;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sectorBackgroundColor", "innerCircleColor", "cancelSectorBackgroundColor", "selectionArcColor", "statusOnArcColor", "statusOffArcColor", "dotsDrawable", "Landroid/graphics/drawable/Drawable;", "emptyPaint", "Landroid/graphics/Paint;", "innerRadiusRatio", "", "selectorArcMultiplier", "", "bitmapDistanceMultiplier", "bitmapDimensionMultiplier", "captionMultiplier", "titleMultiplier", "centerBitmapDimensionMultiplier", "paddingInCenter", "sectorBitmapSize", "centerBitmapSize", "viewRect", "Landroid/graphics/Rect;", "selectorArcRect", "innerArcRect", "spaceAngle", "isInSelectingMode", "", "isCenterSelected", "_innerRadius", "get_innerRadius", "()I", "_outerRadius", "get_outerRadius", "sectorPaint", "innerCirclePaint", "cancelSectorPaint", "sectorBackgroundPaint", "cancelSectorBackgroundPaint", "selectionArcPaint", "statusOnArcPaint", "statusOffArcPaint", "titlePaint", "captionPaint", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lru/mrlargha/commonui/elements/radial_menu/PieSelector$SectorSelectedLister;", "getListener", "()Lru/mrlargha/commonui/elements/radial_menu/PieSelector$SectorSelectedLister;", "setListener", "(Lru/mrlargha/commonui/elements/radial_menu/PieSelector$SectorSelectedLister;)V", "sectors", "", "Lru/mrlargha/commonui/elements/radial_menu/PieSelector$Sector;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setSectorsList", "newSectors", "", "Lru/mrlargha/commonui/elements/radial_menu/SectorData;", "updateSectorsList", "updateSectorData", "Lru/mrlargha/commonui/elements/radial_menu/UpdateSectorData;", "polarToDec", "Landroid/graphics/Point;", "radius", "angle", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", TypedValues.Custom.S_DIMENSION, "getTextHeight", "text", "", "paint", "drawTextLinesCentered", "lines", "y", "getStringListHeight", "Rect", "p1", "p2", "toRad", "distanceTo", "SectorSelectedLister", "Sector", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PieSelector extends View {
    private final double bitmapDimensionMultiplier;
    private final float bitmapDistanceMultiplier;
    private final int cancelSectorBackgroundColor;
    private final Paint cancelSectorBackgroundPaint;
    private final Paint cancelSectorPaint;
    private final float captionMultiplier;
    private final Paint captionPaint;
    private final float centerBitmapDimensionMultiplier;
    private int centerBitmapSize;
    private final Drawable dotsDrawable;
    private final Paint emptyPaint;
    private final Rect innerArcRect;
    private final int innerCircleColor;
    private final Paint innerCirclePaint;
    private final float innerRadiusRatio;
    private boolean isCenterSelected;
    private boolean isInSelectingMode;
    private SectorSelectedLister listener;
    private float paddingInCenter;
    private final int sectorBackgroundColor;
    private final Paint sectorBackgroundPaint;
    private int sectorBitmapSize;
    private final Paint sectorPaint;
    private final List<Sector> sectors;
    private final int selectionArcColor;
    private final Paint selectionArcPaint;
    private final double selectorArcMultiplier;
    private Rect selectorArcRect;
    private final float spaceAngle;
    private final int statusOffArcColor;
    private final Paint statusOffArcPaint;
    private final int statusOnArcColor;
    private final Paint statusOnArcPaint;
    private final float titleMultiplier;
    private final Paint titlePaint;
    private Rect viewRect;

    /* compiled from: PieSelector.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/PieSelector$SectorSelectedLister;", "", "onSectorSelected", "", "data", "Lru/mrlargha/commonui/elements/radial_menu/SectorData;", "onCanceled", "onCenterClicked", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface SectorSelectedLister {
        void onCanceled();

        void onCenterClicked();

        void onSectorSelected(SectorData sectorData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PieSelector(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PieSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PieSelector(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PieSelector(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int parseColor = Color.parseColor("#99000000");
        this.sectorBackgroundColor = parseColor;
        int parseColor2 = Color.parseColor("#7D000000");
        this.innerCircleColor = parseColor2;
        int parseColor3 = Color.parseColor("#BF000000");
        this.cancelSectorBackgroundColor = parseColor3;
        int parseColor4 = Color.parseColor("#CC224D74");
        this.selectionArcColor = parseColor4;
        int parseColor5 = Color.parseColor("#7BB83E");
        this.statusOnArcColor = parseColor5;
        int parseColor6 = Color.parseColor("#E25252");
        this.statusOffArcColor = parseColor6;
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.dots);
        Intrinsics.checkNotNull(drawable);
        this.dotsDrawable = drawable;
        this.emptyPaint = new Paint();
        this.innerRadiusRatio = 0.27f;
        this.selectorArcMultiplier = 0.12d;
        this.bitmapDistanceMultiplier = 0.5f;
        this.bitmapDimensionMultiplier = 0.4d;
        this.captionMultiplier = 0.6f;
        this.titleMultiplier = 5.0f;
        this.centerBitmapDimensionMultiplier = 1.2f;
        this.paddingInCenter = 10.0f;
        this.sectorBitmapSize = 100;
        this.centerBitmapSize = 100;
        this.viewRect = new Rect(0, 0, getWidth(), getHeight());
        this.selectorArcRect = new Rect();
        this.innerArcRect = new Rect();
        this.spaceAngle = 2.0f;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(parseColor);
        this.sectorPaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(parseColor2);
        this.innerCirclePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(parseColor3);
        this.cancelSectorPaint = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        paint4.setColor(parseColor);
        this.sectorBackgroundPaint = paint4;
        Paint paint5 = new Paint();
        paint5.setAntiAlias(true);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setColor(parseColor3);
        this.cancelSectorBackgroundPaint = paint5;
        Paint paint6 = new Paint();
        paint6.setAntiAlias(true);
        paint6.setStyle(Paint.Style.FILL);
        paint6.setColor(parseColor4);
        this.selectionArcPaint = paint6;
        Paint paint7 = new Paint();
        paint7.setAntiAlias(true);
        paint7.setStyle(Paint.Style.FILL);
        paint7.setColor(parseColor5);
        this.statusOnArcPaint = paint7;
        Paint paint8 = new Paint();
        paint8.setAntiAlias(true);
        paint8.setStyle(Paint.Style.FILL);
        paint8.setColor(parseColor6);
        this.statusOffArcPaint = paint8;
        Paint paint9 = new Paint();
        paint9.setColor(-1);
        paint9.setTextSize(10.0f);
        paint9.setAntiAlias(true);
        this.titlePaint = paint9;
        Paint paint10 = new Paint();
        paint10.setColor(Color.parseColor("#40FFFFFF"));
        paint10.setTextSize(10.0f);
        paint10.setAntiAlias(true);
        this.captionPaint = paint10;
        this.sectors = new ArrayList();
        setSectorsList(CollectionsKt.listOf((Object[]) new SectorData[]{new SectorData(0, R.drawable.bag_bg, "Приветствовать 1", "Нажмите для\nиспользования 1", null, 0, 48, null), new SectorData(1, R.drawable.bag_bg, "Приветствовать 2", "Нажмите для\nиспользования 2", null, 0, 48, null), new SectorData(2, R.drawable.bag_bg, "Приветствовать 3", "Нажмите для\nиспользования 3", null, 0, 48, null), new SectorData(3, R.drawable.bag_bg, "Приветствовать 4", "Нажмите для\nиспользования 4", null, 0, 48, null), new SectorData(4, R.drawable.bag_bg, "Приветствовать 5", "Нажмите для\nиспользования 5", null, 0, 48, null), new SectorData(5, R.drawable.bag_bg, "Приветствовать 6", "Нажмите для\nиспользования 6", null, 0, 48, null), new SectorData(6, R.drawable.bag_bg, "Приветствовать 7", "Нажмите для\nиспользования 7", null, 0, 48, null), new SectorData(7, R.drawable.bag_bg, "Приветствовать 8", "Нажмите для\nиспользования 8", null, 0, 48, null)}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int get_innerRadius() {
        return (int) (Math.min(this.viewRect.right, this.viewRect.bottom) * this.innerRadiusRatio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int get_outerRadius() {
        return (Math.min(this.viewRect.right, this.viewRect.bottom) - (get_innerRadius() * 2)) / 2;
    }

    public final SectorSelectedLister getListener() {
        return this.listener;
    }

    public final void setListener(SectorSelectedLister sectorSelectedLister) {
        this.listener = sectorSelectedLister;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PieSelector.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00070$¢\u0006\u0002\b%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lru/mrlargha/commonui/elements/radial_menu/PieSelector$Sector;", "", "startAngle", "", "sweepAngle", "sectorData", "Lru/mrlargha/commonui/elements/radial_menu/SectorData;", NotificationCompat.CATEGORY_STATUS, "", "isCancelSector", "", "<init>", "(Lru/mrlargha/commonui/elements/radial_menu/PieSelector;FFLru/mrlargha/commonui/elements/radial_menu/SectorData;IZ)V", "getStartAngle", "()F", "getSweepAngle", "getSectorData", "()Lru/mrlargha/commonui/elements/radial_menu/SectorData;", "getStatus", "()I", "setStatus", "(I)V", "()Z", "sectorPath", "Landroid/graphics/Path;", "selectorPath", "statusPath", "resizedBitmap", "Landroid/graphics/Bitmap;", "bitmapPoint", "Landroid/graphics/PointF;", "selected", "getSelected", "setSelected", "(Z)V", "sectorDrawable", "Landroid/graphics/drawable/Drawable;", "Lorg/jspecify/annotations/Nullable;", "getSectorDrawable", "()Landroid/graphics/drawable/Drawable;", "updateGeometry", "", "draw", "canvas", "Landroid/graphics/Canvas;", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Sector {
        private PointF bitmapPoint;
        private final boolean isCancelSector;
        private Bitmap resizedBitmap;
        private final SectorData sectorData;
        private final Drawable sectorDrawable;
        private final Path sectorPath;
        private boolean selected;
        private final Path selectorPath;
        private final float startAngle;
        private int status;
        private final Path statusPath;
        private final float sweepAngle;
        final /* synthetic */ PieSelector this$0;

        public Sector(PieSelector pieSelector, float f, float f2, SectorData sectorData, int i, boolean z) {
            Intrinsics.checkNotNullParameter(sectorData, "sectorData");
            this.this$0 = pieSelector;
            this.startAngle = f;
            this.sweepAngle = f2;
            this.sectorData = sectorData;
            this.status = i;
            this.isCancelSector = z;
            this.sectorPath = new Path();
            this.selectorPath = new Path();
            this.statusPath = new Path();
            this.bitmapPoint = new PointF(0.0f, 0.0f);
            Drawable drawable = ContextCompat.getDrawable(pieSelector.getContext(), sectorData.getImageResourceId());
            Intrinsics.checkNotNull(drawable);
            this.sectorDrawable = drawable;
            updateGeometry();
        }

        public /* synthetic */ Sector(PieSelector pieSelector, float f, float f2, SectorData sectorData, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(pieSelector, f, f2, sectorData, i, (i2 & 16) != 0 ? false : z);
        }

        public final float getStartAngle() {
            return this.startAngle;
        }

        public final float getSweepAngle() {
            return this.sweepAngle;
        }

        public final SectorData getSectorData() {
            return this.sectorData;
        }

        public final int getStatus() {
            return this.status;
        }

        public final void setStatus(int i) {
            this.status = i;
        }

        public final boolean isCancelSector() {
            return this.isCancelSector;
        }

        public final boolean getSelected() {
            return this.selected;
        }

        public final void setSelected(boolean z) {
            this.selected = z;
        }

        public final Drawable getSectorDrawable() {
            return this.sectorDrawable;
        }

        public final void updateGeometry() {
            this.sectorPath.reset();
            this.selectorPath.reset();
            PieSelector pieSelector = this.this$0;
            Point polarToDec = pieSelector.polarToDec(pieSelector.get_innerRadius(), this.startAngle);
            PieSelector pieSelector2 = this.this$0;
            pieSelector2.polarToDec(pieSelector2.get_innerRadius(), this.startAngle + this.sweepAngle);
            PieSelector pieSelector3 = this.this$0;
            pieSelector3.polarToDec(pieSelector3.get_innerRadius() + this.this$0.get_outerRadius(), this.startAngle);
            PieSelector pieSelector4 = this.this$0;
            Point polarToDec2 = pieSelector4.polarToDec(pieSelector4.get_innerRadius() + this.this$0.get_outerRadius(), this.startAngle + this.sweepAngle);
            PieSelector pieSelector5 = this.this$0;
            pieSelector5.polarToDec((float) (pieSelector5.get_innerRadius() + (this.this$0.selectorArcMultiplier * this.this$0.get_innerRadius())), this.startAngle);
            PieSelector pieSelector6 = this.this$0;
            Point polarToDec3 = pieSelector6.polarToDec((float) (pieSelector6.get_innerRadius() + (this.this$0.selectorArcMultiplier * this.this$0.get_innerRadius())), this.startAngle + this.sweepAngle);
            this.sectorPath.arcTo(new RectF(this.this$0.innerArcRect), this.startAngle, this.sweepAngle);
            this.sectorPath.lineTo(polarToDec2.x, polarToDec2.y);
            Path path = this.sectorPath;
            RectF rectF = new RectF(this.this$0.viewRect);
            float f = this.startAngle;
            float f2 = this.sweepAngle;
            path.arcTo(rectF, f + f2, -f2);
            this.sectorPath.lineTo(polarToDec.x, polarToDec.y);
            this.selectorPath.arcTo(new RectF(this.this$0.innerArcRect), this.startAngle, this.sweepAngle);
            this.selectorPath.lineTo(polarToDec2.x, polarToDec2.y);
            Path path2 = this.selectorPath;
            RectF rectF2 = new RectF(this.this$0.viewRect);
            float f3 = this.startAngle;
            float f4 = this.sweepAngle;
            path2.arcTo(rectF2, f3 + f4, -f4);
            this.selectorPath.lineTo(polarToDec.x, polarToDec.y);
            this.statusPath.arcTo(new RectF(this.this$0.innerArcRect), this.startAngle, this.sweepAngle);
            this.statusPath.lineTo(polarToDec3.x, polarToDec3.y);
            Path path3 = this.statusPath;
            RectF rectF3 = new RectF(this.this$0.selectorArcRect);
            float f5 = this.startAngle;
            float f6 = this.sweepAngle;
            path3.arcTo(rectF3, f5 + f6, -f6);
            this.statusPath.lineTo(polarToDec.x, polarToDec.y);
            Drawable drawable = this.sectorDrawable;
            PieSelector pieSelector7 = this.this$0;
            this.resizedBitmap = pieSelector7.drawableToBitmap(drawable, pieSelector7.sectorBitmapSize);
            PieSelector pieSelector8 = this.this$0;
            this.bitmapPoint = new PointF(pieSelector8.polarToDec(pieSelector8.get_innerRadius() + (this.this$0.get_outerRadius() * this.this$0.bitmapDistanceMultiplier), this.startAngle + (this.sweepAngle / 2)));
        }

        public final void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.drawPath(this.sectorPath, this.isCancelSector ? this.this$0.cancelSectorBackgroundPaint : this.this$0.sectorBackgroundPaint);
            canvas.drawPath(this.sectorPath, this.isCancelSector ? this.this$0.cancelSectorPaint : this.this$0.sectorPaint);
            if (this.selected && this.this$0.isInSelectingMode) {
                canvas.drawPath(this.sectorPath, this.this$0.selectionArcPaint);
            }
            int i = this.status;
            if (i == 1) {
                canvas.drawPath(this.statusPath, this.this$0.statusOnArcPaint);
            } else if (i == 2) {
                canvas.drawPath(this.statusPath, this.this$0.statusOffArcPaint);
            }
            Bitmap bitmap = this.resizedBitmap;
            if (bitmap != null) {
                PieSelector pieSelector = this.this$0;
                canvas.drawBitmap(bitmap, this.bitmapPoint.x - (pieSelector.sectorBitmapSize / 2), this.bitmapPoint.y - (pieSelector.sectorBitmapSize / 2), new Paint());
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawCircle(this.viewRect.exactCenterX(), this.viewRect.exactCenterY(), get_innerRadius(), this.innerCirclePaint);
        int i = -1;
        for (Sector sector : this.sectors) {
            sector.draw(canvas);
            if (sector.getSelected()) {
                i = this.sectors.indexOf(sector);
            }
        }
        if (i < 0) {
            canvas.drawBitmap(drawableToBitmap(this.dotsDrawable, this.centerBitmapSize), this.viewRect.exactCenterX() - (this.centerBitmapSize / 2), this.viewRect.exactCenterY() - this.centerBitmapSize, this.emptyPaint);
            drawTextLinesCentered(CollectionsKt.listOf((Object[]) new String[]{"Меню", "действий"}), this.viewRect.exactCenterY() + this.paddingInCenter, this.titlePaint, canvas);
            return;
        }
        Sector sector2 = this.sectors.get(i);
        canvas.drawBitmap(drawableToBitmap(sector2.getSectorDrawable(), this.centerBitmapSize), this.viewRect.exactCenterX() - (this.centerBitmapSize / 2), (this.viewRect.exactCenterY() - this.centerBitmapSize) - (this.paddingInCenter * 4), this.emptyPaint);
        SectorData sectorData = sector2.getSectorData();
        List<String> split$default = StringsKt.split$default((CharSequence) sectorData.getTitle(), new String[]{"\n"}, false, 0, 6, (Object) null);
        drawTextLinesCentered(split$default, this.viewRect.exactCenterY() + this.paddingInCenter, this.titlePaint, canvas);
        drawTextLinesCentered(StringsKt.split$default((CharSequence) sectorData.getCaption(), new String[]{"\n"}, false, 0, 6, (Object) null), this.viewRect.exactCenterY() + (this.paddingInCenter * 2) + getStringListHeight(split$default, this.titlePaint), this.captionPaint, canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(i, i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect rect = new Rect(0, 0, i, i2);
        this.viewRect = rect;
        this.innerArcRect.set(rect.centerX() - get_innerRadius(), this.viewRect.centerY() - get_innerRadius(), this.viewRect.centerX() + get_innerRadius(), this.viewRect.centerY() + get_innerRadius());
        this.selectorArcRect.set((int) ((this.viewRect.centerX() - get_innerRadius()) - (this.selectorArcMultiplier * get_innerRadius())), (int) ((this.viewRect.centerY() - get_innerRadius()) - (this.selectorArcMultiplier * get_innerRadius())), (int) (this.viewRect.centerX() + get_innerRadius() + (this.selectorArcMultiplier * get_innerRadius())), (int) (this.viewRect.centerY() + get_innerRadius() + (this.selectorArcMultiplier * get_innerRadius())));
        int abs = ((int) Math.abs(get_outerRadius() * this.bitmapDimensionMultiplier)) + 1;
        this.sectorBitmapSize = abs;
        this.centerBitmapSize = MathKt.roundToInt(abs * this.centerBitmapDimensionMultiplier);
        this.titlePaint.setTextSize(get_innerRadius() / this.titleMultiplier);
        this.captionPaint.setTextSize(this.titlePaint.getTextSize() * this.captionMultiplier);
        for (Sector sector : this.sectors) {
            sector.updateGeometry();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Point point = new Point((int) (event.getX() - (this.viewRect.width() / 2)), (int) ((-event.getY()) + (this.viewRect.height() / 2)));
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.isInSelectingMode = true;
        } else if (actionMasked == 1) {
            this.isInSelectingMode = false;
            if (this.isCenterSelected) {
                SectorSelectedLister sectorSelectedLister = this.listener;
                if (sectorSelectedLister != null) {
                    sectorSelectedLister.onCenterClicked();
                }
            } else {
                for (Sector sector : this.sectors) {
                    if (sector.getSelected()) {
                        if (sector.isCancelSector()) {
                            SectorSelectedLister sectorSelectedLister2 = this.listener;
                            if (sectorSelectedLister2 != null) {
                                sectorSelectedLister2.onCanceled();
                            }
                        } else {
                            SectorSelectedLister sectorSelectedLister3 = this.listener;
                            if (sectorSelectedLister3 != null) {
                                sectorSelectedLister3.onSectorSelected(sector.getSectorData());
                            }
                        }
                    }
                }
            }
            performClick();
            invalidate();
        } else if (actionMasked == 2) {
            double hypot = Math.hypot(point.x, point.y);
            double degrees = Math.toDegrees(Math.atan2(point.y, point.x));
            double abs = degrees > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? ((double) RouletteView.PREMIUM_ROULETTE_WIDTH) - degrees : Math.abs(degrees);
            this.isCenterSelected = hypot < ((double) get_innerRadius());
            for (Sector sector2 : this.sectors) {
                sector2.setSelected(abs >= ((double) sector2.getStartAngle()) && abs <= ((double) ((sector2.getStartAngle() + sector2.getSweepAngle()) + this.spaceAngle)) && hypot > ((double) get_innerRadius()));
            }
            invalidate();
        }
        return true;
    }

    public final void setSectorsList(List<SectorData> newSectors) {
        Intrinsics.checkNotNullParameter(newSectors, "newSectors");
        this.sectors.clear();
        int size = newSectors.size();
        float f = RouletteView.PREMIUM_ROULETTE_WIDTH / (size + 1);
        float f2 = this.spaceAngle;
        float f3 = f - f2;
        this.sectors.add(new Sector(this, 0.0f, f3, new SectorData(-1, R.drawable.pie_cancel_new, "Отмена", "Отменить выбор", null, 0, 48, null), 0, true));
        float f4 = f3 + f2;
        for (int i = 0; i < size; i++) {
            this.sectors.add(new Sector(this, f4, f3, newSectors.get(i), 0, false, 16, null));
            f4 += this.spaceAngle + f3;
        }
        invalidate();
    }

    public final void updateSectorsList(List<UpdateSectorData> updateSectorData) {
        Intrinsics.checkNotNullParameter(updateSectorData, "updateSectorData");
        for (UpdateSectorData updateSectorData2 : updateSectorData) {
            for (Sector sector : this.sectors) {
                if (sector.getSectorData().getSectorId() == updateSectorData2.getSectorId()) {
                    sector.setStatus(updateSectorData2.getStatus());
                }
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point polarToDec(float f, float f2) {
        return new Point(Math.abs(MathKt.roundToInt(((float) Math.cos(toRad(f2))) * f) + (this.viewRect.right / 2)), Math.abs(MathKt.roundToInt(f * ((float) Math.sin(toRad(f2)))) + (this.viewRect.bottom / 2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap drawableToBitmap(Drawable drawable, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        float max = i / Math.max(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.setBounds(0, 0, MathKt.roundToInt(drawable.getIntrinsicWidth() * max), MathKt.roundToInt(drawable.getIntrinsicHeight() * max));
        drawable.draw(canvas);
        return createBitmap;
    }

    private final int getTextHeight(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    private final void drawTextLinesCentered(List<String> list, float f, Paint paint, Canvas canvas) {
        Integer num;
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (String str : list2) {
            arrayList.add(Integer.valueOf(getTextHeight(str, paint)));
        }
        float intValue = ((Integer) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) arrayList)) != null ? num.intValue() : 20.0f;
        int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            float f2 = 2;
            canvas.drawText(str2, this.viewRect.exactCenterX() - (paint.measureText(str2) / f2), ((this.paddingInCenter + intValue) * i) + f + (intValue / f2), paint);
            i = i2;
        }
    }

    private final int getStringListHeight(List<String> list, Paint paint) {
        int i = 0;
        for (String str : list) {
            i += getTextHeight(str, paint) + ((int) this.paddingInCenter);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Point polarToDec(int i, float f) {
        return polarToDec(i, f);
    }

    private final Rect Rect(Point point, Point point2) {
        return new Rect(point.x, point.y, point2.x, point2.y);
    }

    private final float toRad(float f) {
        return (float) Math.toRadians(f);
    }

    private final int distanceTo(Point point, Point point2) {
        return MathKt.roundToInt(Math.hypot(point.x - point2.x, point.y - point2.y));
    }
}
