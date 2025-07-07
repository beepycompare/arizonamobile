package com.androidplot;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.androidplot.R;
import com.androidplot.Series;
import com.androidplot.SeriesRegistry;
import com.androidplot.ui.Anchor;
import com.androidplot.ui.BoxModel;
import com.androidplot.ui.Formatter;
import com.androidplot.ui.HorizontalPositioning;
import com.androidplot.ui.LayoutManager;
import com.androidplot.ui.Resizable;
import com.androidplot.ui.SeriesBundle;
import com.androidplot.ui.SeriesRenderer;
import com.androidplot.ui.Size;
import com.androidplot.ui.SizeMode;
import com.androidplot.ui.TextOrientation;
import com.androidplot.ui.VerticalPositioning;
import com.androidplot.ui.widget.TextLabelWidget;
import com.androidplot.util.AttrUtils;
import com.androidplot.util.DisplayDimensions;
import com.androidplot.util.PixelUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class Plot<SeriesType extends Series, FormatterType extends Formatter, RendererType extends SeriesRenderer, BundleType extends SeriesBundle<SeriesType, FormatterType>, RegistryType extends SeriesRegistry<BundleType, SeriesType, FormatterType>> extends View implements Resizable {
    private static final String BASE_PACKAGE = "com.androidplot.";
    private static final int DEFAULT_TITLE_WIDGET_TEXT_SIZE_SP = 10;
    private static final String TAG = "com.androidplot.Plot";
    private static final String XML_ATTR_PREFIX = "androidplot";
    private Paint backgroundPaint;
    private Paint borderPaint;
    private float borderRadiusX;
    private float borderRadiusY;
    private BorderStyle borderStyle;
    private BoxModel boxModel;
    private DisplayDimensions displayDims;
    private boolean isIdle;
    private boolean keepRunning;
    private LayoutManager layoutManager;
    private final ArrayList<PlotListener> listeners;
    private final BufferedCanvas pingPong;
    private RegistryType registry;
    private RenderMode renderMode;
    private final Object renderSync;
    private Thread renderThread;
    private HashMap<Class<? extends RendererType>, RendererType> renderers;
    private TextLabelWidget title;

    /* loaded from: classes3.dex */
    public enum BorderStyle {
        ROUNDED,
        SQUARE,
        NONE
    }

    /* loaded from: classes3.dex */
    public enum RenderMode {
        USE_MAIN_THREAD,
        USE_BACKGROUND_THREAD
    }

    protected abstract RegistryType getRegistryInstance();

    protected boolean isHwAccelerationSupported() {
        return false;
    }

    protected void onAfterConfig() {
    }

    protected void onPreInit() {
    }

    protected abstract void processAttrs(TypedArray typedArray);

    public DisplayDimensions getDisplayDimensions() {
        return this.displayDims;
    }

    public HashMap<Class<? extends RendererType>, RendererType> getRenderers() {
        return this.renderers;
    }

    public RegistryType getRegistry() {
        return this.registry;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRegistry(RegistryType registrytype) {
        this.registry = registrytype;
        for (BundleType bundletype : registrytype.getSeriesAndFormatterList()) {
            attachSeries(bundletype.getSeries(), bundletype.getFormatter());
        }
    }

    public TextLabelWidget getTitle() {
        return this.title;
    }

    public void setTitle(TextLabelWidget textLabelWidget) {
        this.title = textLabelWidget;
    }

    public void setTitle(String str) {
        getTitle().setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class BufferedCanvas {
        private volatile Bitmap bgBuffer;
        private Canvas canvas;
        private volatile Bitmap fgBuffer;
        private int lastHeight;
        private int lastWidth;

        private BufferedCanvas() {
            this.lastHeight = 0;
            this.lastWidth = 0;
            this.canvas = new Canvas();
        }

        public synchronized void swap() {
            Bitmap bitmap = this.bgBuffer;
            this.bgBuffer = this.fgBuffer;
            this.fgBuffer = bitmap;
        }

        public void resizeToLast() {
            resize(this.lastHeight, this.lastWidth);
        }

        public synchronized void resize(int i, int i2) {
            if (i2 <= 0 || i <= 0) {
                this.bgBuffer = null;
                this.fgBuffer = null;
            } else {
                this.lastHeight = i;
                this.lastWidth = i2;
                try {
                    this.bgBuffer = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                    this.fgBuffer = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                } catch (IllegalArgumentException unused) {
                    throw new IllegalArgumentException("Illegal argument passed to Bitmap.createBitmap.  width: " + i2 + " height: " + i);
                }
            }
        }

        public void recycle() {
            if (this.bgBuffer != null) {
                this.bgBuffer.recycle();
                this.bgBuffer = null;
            }
            if (this.fgBuffer != null) {
                this.fgBuffer.recycle();
                this.fgBuffer = null;
            }
            System.gc();
        }

        public synchronized Canvas getCanvas() {
            if (this.bgBuffer != null) {
                this.canvas.setBitmap(this.bgBuffer);
                return this.canvas;
            }
            return null;
        }

        public Bitmap getBitmap() {
            return this.fgBuffer;
        }
    }

    public Plot(Context context, String str) {
        this(context, str, RenderMode.USE_MAIN_THREAD);
    }

    public Plot(Context context, String str, RenderMode renderMode) {
        super(context);
        this.boxModel = new BoxModel();
        this.borderStyle = BorderStyle.NONE;
        this.borderRadiusX = 15.0f;
        this.borderRadiusY = 15.0f;
        this.displayDims = new DisplayDimensions();
        this.renderMode = RenderMode.USE_MAIN_THREAD;
        this.pingPong = new BufferedCanvas();
        this.renderSync = new Object();
        this.keepRunning = false;
        this.isIdle = true;
        this.listeners = new ArrayList<>();
        this.registry = getRegistryInstance();
        this.renderers = new HashMap<>();
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setColor(Color.rgb(150, 150, 150));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth(1.0f);
        this.borderPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.backgroundPaint = paint2;
        paint2.setColor(-12303292);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        this.renderMode = renderMode;
        init(context, null, 0);
        getTitle().setText(str);
    }

    public Plot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boxModel = new BoxModel();
        this.borderStyle = BorderStyle.NONE;
        this.borderRadiusX = 15.0f;
        this.borderRadiusY = 15.0f;
        this.displayDims = new DisplayDimensions();
        this.renderMode = RenderMode.USE_MAIN_THREAD;
        this.pingPong = new BufferedCanvas();
        this.renderSync = new Object();
        this.keepRunning = false;
        this.isIdle = true;
        this.listeners = new ArrayList<>();
        this.registry = getRegistryInstance();
        this.renderers = new HashMap<>();
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setColor(Color.rgb(150, 150, 150));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth(1.0f);
        this.borderPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.backgroundPaint = paint2;
        paint2.setColor(-12303292);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        init(context, attributeSet, 0);
    }

    public Plot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.boxModel = new BoxModel();
        this.borderStyle = BorderStyle.NONE;
        this.borderRadiusX = 15.0f;
        this.borderRadiusY = 15.0f;
        this.displayDims = new DisplayDimensions();
        this.renderMode = RenderMode.USE_MAIN_THREAD;
        this.pingPong = new BufferedCanvas();
        this.renderSync = new Object();
        this.keepRunning = false;
        this.isIdle = true;
        this.listeners = new ArrayList<>();
        this.registry = getRegistryInstance();
        this.renderers = new HashMap<>();
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setColor(Color.rgb(150, 150, 150));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth(1.0f);
        this.borderPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.backgroundPaint = paint2;
        paint2.setColor(-12303292);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        init(context, attributeSet, i);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
    }

    protected final void init(Context context, AttributeSet attributeSet, int i) {
        PixelUtils.init(context);
        this.layoutManager = new LayoutManager();
        TextLabelWidget textLabelWidget = new TextLabelWidget(this.layoutManager, new Size(25.0f, SizeMode.ABSOLUTE, 100.0f, SizeMode.ABSOLUTE), TextOrientation.HORIZONTAL);
        this.title = textLabelWidget;
        textLabelWidget.position(0.0f, HorizontalPositioning.RELATIVE_TO_CENTER, 0.0f, VerticalPositioning.ABSOLUTE_FROM_TOP, Anchor.TOP_MIDDLE);
        this.title.getLabelPaint().setTextSize(PixelUtils.spToPix(10.0f));
        onPreInit();
        this.layoutManager.moveToTop(this.title);
        if (context != null && attributeSet != null) {
            loadAttrs(attributeSet, i);
        }
        onAfterConfig();
        this.layoutManager.onPostInit();
        if (this.renderMode == RenderMode.USE_BACKGROUND_THREAD) {
            startBackgroundRendering();
        }
    }

    protected void startBackgroundRendering() {
        if (this.renderThread != null) {
            return;
        }
        this.renderThread = new Thread(new Runnable() { // from class: com.androidplot.Plot$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Plot.this.lambda$startBackgroundRendering$0();
            }
        }, "Androidplot renderThread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startBackgroundRendering$0() {
        System.out.println("Thread started with id " + hashCode());
        this.keepRunning = true;
        while (this.keepRunning) {
            this.isIdle = false;
            synchronized (this.pingPong) {
                renderOnCanvas(this.pingPong.getCanvas());
                this.pingPong.swap();
            }
            synchronized (this.renderSync) {
                postInvalidate();
                if (this.keepRunning) {
                    try {
                        this.renderSync.wait();
                    } catch (InterruptedException unused) {
                        this.keepRunning = false;
                    }
                }
            }
        }
        System.out.println("Thread exited with id " + hashCode());
        this.renderThread = null;
        this.pingPong.recycle();
    }

    private void processBaseAttrs(TypedArray typedArray) {
        setMarkupEnabled(typedArray.getBoolean(R.styleable.Plot_markupEnabled, false));
        RenderMode renderMode = RenderMode.values()[typedArray.getInt(R.styleable.Plot_renderMode, getRenderMode().ordinal())];
        if (renderMode != getRenderMode()) {
            setRenderMode(renderMode);
        }
        AttrUtils.configureBoxModelable(typedArray, this.boxModel, R.styleable.Plot_marginTop, R.styleable.Plot_marginBottom, R.styleable.Plot_marginLeft, R.styleable.Plot_marginRight, R.styleable.Plot_paddingTop, R.styleable.Plot_paddingBottom, R.styleable.Plot_paddingLeft, R.styleable.Plot_paddingRight);
        getTitle().setText(typedArray.getString(R.styleable.Plot_title));
        getTitle().getLabelPaint().setTextSize(typedArray.getDimension(R.styleable.Plot_titleTextSize, PixelUtils.spToPix(10.0f)));
        getTitle().getLabelPaint().setColor(typedArray.getColor(R.styleable.Plot_titleTextColor, getTitle().getLabelPaint().getColor()));
        getBackgroundPaint().setColor(typedArray.getColor(R.styleable.Plot_backgroundColor, getBackgroundPaint().getColor()));
        AttrUtils.configureLinePaint(typedArray, getBorderPaint(), R.styleable.Plot_borderColor, R.styleable.Plot_borderThickness);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
        if (r1 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0084, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0086, code lost:
        processBaseAttrs(r1);
        r1.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
        r8 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0095, code lost:
        if (r3 >= r7.getAttributeCount()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        r0 = r7.getAttributeName(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009b, code lost:
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ab, code lost:
        if (r0.toUpperCase().startsWith(com.androidplot.Plot.XML_ATTR_PREFIX.toUpperCase()) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ad, code lost:
        r8.put(r0.substring(com.androidplot.Plot.XML_ATTR_PREFIX.length() + 1), r7.getAttributeValue(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00be, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c1, code lost:
        com.halfhp.fig.Fig.configure(getContext(), r6, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00cf, code lost:
        throw new java.lang.RuntimeException(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[Catch: all -> 0x006f, NoSuchFieldException -> 0x0071, IllegalAccessException -> 0x0084, TRY_LEAVE, TryCatch #7 {IllegalAccessException -> 0x0084, NoSuchFieldException -> 0x0071, blocks: (B:15:0x0056, B:17:0x005e), top: B:50:0x0056, outer: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadAttrs(AttributeSet attributeSet, int i) {
        Field field;
        TypedArray obtainStyledAttributes;
        Field field2;
        if (attributeSet == null) {
            return;
        }
        String replace = getClass().getName().substring(BASE_PACKAGE.length()).replace('.', '_');
        try {
            field = R.styleable.class.getField(replace);
        } catch (NoSuchFieldException unused) {
            Log.d(TAG, "Styleable definition not found for: " + replace);
            field = null;
        }
        int i2 = 0;
        try {
            try {
                if (field != null) {
                    try {
                        obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, (int[]) field.get(null), i, 0);
                        if (obtainStyledAttributes != null) {
                            processAttrs(obtainStyledAttributes);
                            obtainStyledAttributes.recycle();
                        }
                    } catch (IllegalAccessException unused2) {
                    }
                    field2 = R.styleable.class.getField("Plot");
                    if (field2 != null) {
                        obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, (int[]) field2.get(null), i, 0);
                    }
                }
                field2 = R.styleable.class.getField("Plot");
                if (field2 != null) {
                }
            } catch (IllegalAccessException unused3) {
            } catch (NoSuchFieldException unused4) {
                Log.d(TAG, "Styleable definition not found for: Plot");
            }
        } catch (Throwable th) {
            if (obtainStyledAttributes != null) {
                processBaseAttrs(obtainStyledAttributes);
                obtainStyledAttributes.recycle();
            }
            throw th;
        }
        obtainStyledAttributes = null;
    }

    public RenderMode getRenderMode() {
        return this.renderMode;
    }

    public synchronized boolean addListener(PlotListener plotListener) {
        boolean z;
        if (!this.listeners.contains(plotListener)) {
            z = this.listeners.add(plotListener);
        }
        return z;
    }

    public synchronized boolean removeListener(PlotListener plotListener) {
        return this.listeners.remove(plotListener);
    }

    protected ArrayList<PlotListener> getListeners() {
        return this.listeners;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyListenersBeforeDraw(Canvas canvas) {
        Iterator<PlotListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onBeforeDraw(this, canvas);
        }
    }

    protected void notifyListenersAfterDraw(Canvas canvas) {
        Iterator<PlotListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onAfterDraw(this, canvas);
        }
    }

    public synchronized boolean addSeries(FormatterType formattertype, SeriesType... seriestypeArr) {
        for (SeriesType seriestype : seriestypeArr) {
            if (!addSeries((Plot<SeriesType, FormatterType, RendererType, BundleType, RegistryType>) seriestype, (SeriesType) formattertype)) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean addSeries(SeriesType seriestype, FormatterType formattertype) {
        boolean add;
        add = getRegistry().add(seriestype, formattertype);
        attachSeries(seriestype, formattertype);
        return add;
    }

    protected void attachSeries(SeriesType seriestype, FormatterType formattertype) {
        Class<? extends RendererType> cls = (Class<? extends RendererType>) formattertype.getRendererClass();
        if (!getRenderers().containsKey(cls)) {
            getRenderers().put(cls, (RendererType) formattertype.getRendererInstance(this));
        }
        if (seriestype instanceof PlotListener) {
            addListener((PlotListener) seriestype);
        }
    }

    protected SeriesBundle<SeriesType, FormatterType> getSeries(SeriesType seriestype, Class<? extends RendererType> cls) {
        for (SeriesBundle<SeriesType, FormatterType> seriesBundle : getSeries(seriestype)) {
            if (seriesBundle.getFormatter().getRendererClass() == cls) {
                return seriesBundle;
            }
        }
        return null;
    }

    protected List<SeriesBundle<SeriesType, FormatterType>> getSeries(SeriesType seriestype) {
        return getRegistry().get(seriestype);
    }

    public synchronized boolean removeSeries(SeriesType seriestype, Class<? extends RendererType> cls) {
        if (getRegistry().remove(seriestype, cls).size() == 1 && (seriestype instanceof PlotListener)) {
            removeListener((PlotListener) seriestype);
            return true;
        }
        return false;
    }

    public synchronized void removeSeries(SeriesType seriestype) {
        if (seriestype instanceof PlotListener) {
            removeListener((PlotListener) seriestype);
        }
        getRegistry().remove(seriestype);
    }

    public void clear() {
        for (SeriesType seriestype : getRegistry().getSeriesList()) {
            if (seriestype instanceof PlotListener) {
                removeListener((PlotListener) seriestype);
            }
        }
        getRegistry().clear();
    }

    public boolean isEmpty() {
        return getRegistry().isEmpty();
    }

    public FormatterType getFormatter(SeriesType seriestype, Class<? extends RendererType> cls) {
        return getSeries(seriestype, cls).getFormatter();
    }

    /* JADX WARN: Incorrect return type in method signature: <T:TRendererType;>(Ljava/lang/Class<TT;>;)TT; */
    public SeriesRenderer getRenderer(Class cls) {
        return getRenderers().get(cls);
    }

    public List<RendererType> getRendererList() {
        return new ArrayList(getRenderers().values());
    }

    public void setMarkupEnabled(boolean z) {
        this.layoutManager.setMarkupEnabled(z);
    }

    public void redraw() {
        if (this.renderMode == RenderMode.USE_BACKGROUND_THREAD) {
            if (this.renderThread == null || !this.isIdle) {
                return;
            }
            synchronized (this.renderSync) {
                this.renderSync.notify();
            }
        } else if (this.renderMode == RenderMode.USE_MAIN_THREAD) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                invalidate();
            } else {
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("Unsupported Render Mode: " + this.renderMode);
        }
    }

    @Override // com.androidplot.ui.Resizable
    public synchronized void layout(DisplayDimensions displayDimensions) {
        this.displayDims = displayDimensions;
        this.layoutManager.layout(displayDimensions);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        synchronized (this.renderSync) {
            this.keepRunning = false;
            this.renderSync.notify();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.renderMode == RenderMode.USE_BACKGROUND_THREAD && this.renderThread == null) {
            this.pingPong.resizeToLast();
            startBackgroundRendering();
            this.renderThread.start();
        }
    }

    @Override // android.view.View
    protected synchronized void onSizeChanged(int i, int i2, int i3, int i4) {
        PixelUtils.init(getContext());
        if (!isHwAccelerationSupported() && isHardwareAccelerated()) {
            setLayerType(1, null);
        }
        if (this.renderMode == RenderMode.USE_BACKGROUND_THREAD) {
            this.pingPong.resize(i2, i);
        }
        RectF rectF = new RectF(0.0f, 0.0f, i, i2);
        RectF marginatedRect = this.boxModel.getMarginatedRect(rectF);
        layout(new DisplayDimensions(rectF, marginatedRect, this.boxModel.getPaddedRect(marginatedRect)));
        super.onSizeChanged(i, i2, i3, i4);
        Thread thread = this.renderThread;
        if (thread != null && !thread.isAlive()) {
            this.renderThread.start();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.renderMode == RenderMode.USE_BACKGROUND_THREAD) {
            synchronized (this.pingPong) {
                Bitmap bitmap = this.pingPong.getBitmap();
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                }
            }
        } else if (this.renderMode == RenderMode.USE_MAIN_THREAD) {
            renderOnCanvas(canvas);
        } else {
            throw new IllegalArgumentException("Unsupported Render Mode: " + this.renderMode);
        }
    }

    protected synchronized void renderOnCanvas(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        notifyListenersBeforeDraw(canvas);
        try {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            if (this.backgroundPaint != null) {
                drawBackground(canvas, this.displayDims.marginatedRect);
            }
            this.layoutManager.draw(canvas);
            if (getBorderPaint() != null) {
                drawBorder(canvas, this.displayDims.marginatedRect);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception while rendering Plot.", e);
        }
        this.isIdle = true;
        notifyListenersAfterDraw(canvas);
    }

    public void setBorderStyle(BorderStyle borderStyle, Float f, Float f2) {
        if (borderStyle == BorderStyle.ROUNDED) {
            if (f == null || f2 == null) {
                throw new IllegalArgumentException("radiusX and radiusY cannot be null when using BorderStyle.ROUNDED");
            }
            this.borderRadiusX = f.floatValue();
            this.borderRadiusY = f2.floatValue();
        }
        this.borderStyle = borderStyle;
    }

    protected void drawBorder(Canvas canvas, RectF rectF) {
        drawRect(canvas, rectF, this.borderPaint);
    }

    protected void drawBackground(Canvas canvas, RectF rectF) {
        drawRect(canvas, rectF, this.backgroundPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.androidplot.Plot$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$androidplot$Plot$BorderStyle;

        static {
            int[] iArr = new int[BorderStyle.values().length];
            $SwitchMap$com$androidplot$Plot$BorderStyle = iArr;
            try {
                iArr[BorderStyle.ROUNDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$androidplot$Plot$BorderStyle[BorderStyle.SQUARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    protected void drawRect(Canvas canvas, RectF rectF, Paint paint) {
        if (AnonymousClass1.$SwitchMap$com$androidplot$Plot$BorderStyle[this.borderStyle.ordinal()] == 1) {
            canvas.drawRoundRect(rectF, this.borderRadiusX, this.borderRadiusY, paint);
        } else {
            canvas.drawRect(rectF, paint);
        }
    }

    public LayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public void setBackgroundPaint(Paint paint) {
        this.backgroundPaint = paint;
    }

    public void setPlotMargins(float f, float f2, float f3, float f4) {
        setPlotMarginLeft(f);
        setPlotMarginTop(f2);
        setPlotMarginRight(f3);
        setPlotMarginBottom(f4);
    }

    public void setPlotPadding(float f, float f2, float f3, float f4) {
        setPlotPaddingLeft(f);
        setPlotPaddingTop(f2);
        setPlotPaddingRight(f3);
        setPlotPaddingBottom(f4);
    }

    public float getPlotMarginTop() {
        return this.boxModel.getMarginTop();
    }

    public void setPlotMarginTop(float f) {
        this.boxModel.setMarginTop(f);
    }

    public float getPlotMarginBottom() {
        return this.boxModel.getMarginBottom();
    }

    public void setPlotMarginBottom(float f) {
        this.boxModel.setMarginBottom(f);
    }

    public float getPlotMarginLeft() {
        return this.boxModel.getMarginLeft();
    }

    public void setPlotMarginLeft(float f) {
        this.boxModel.setMarginLeft(f);
    }

    public float getPlotMarginRight() {
        return this.boxModel.getMarginRight();
    }

    public void setPlotMarginRight(float f) {
        this.boxModel.setMarginRight(f);
    }

    public float getPlotPaddingTop() {
        return this.boxModel.getPaddingTop();
    }

    public void setPlotPaddingTop(float f) {
        this.boxModel.setPaddingTop(f);
    }

    public float getPlotPaddingBottom() {
        return this.boxModel.getPaddingBottom();
    }

    public void setPlotPaddingBottom(float f) {
        this.boxModel.setPaddingBottom(f);
    }

    public float getPlotPaddingLeft() {
        return this.boxModel.getPaddingLeft();
    }

    public void setPlotPaddingLeft(float f) {
        this.boxModel.setPaddingLeft(f);
    }

    public float getPlotPaddingRight() {
        return this.boxModel.getPaddingRight();
    }

    public void setPlotPaddingRight(float f) {
        this.boxModel.setPaddingRight(f);
    }

    public Paint getBorderPaint() {
        return this.borderPaint;
    }

    public void setBorderPaint(Paint paint) {
        if (paint == null) {
            this.borderPaint = null;
            return;
        }
        Paint paint2 = new Paint(paint);
        this.borderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }
}
