package androidx.compose.ui.layout;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowInsetsRulers.android.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0002J\u001e\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020)02H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00104\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0018\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\u0006\u00100\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00100\u001a\u00020\u0010H\u0002J\b\u00109\u001a\u00020'H\u0016J\u0010\u0010:\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006<"}, d2 = {"Landroidx/compose/ui/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeView", "Landroidx/compose/ui/platform/AndroidComposeView;", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "getComposeView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "prepared", "", "runningAnimationMask", "", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "insetsValues", "Landroidx/collection/ScatterMap;", "", "Landroidx/compose/ui/layout/WindowWindowInsetsAnimationValues;", "getInsetsValues", "()Landroidx/collection/ScatterMap;", "generation", "Landroidx/compose/runtime/MutableIntState;", "getGeneration", "()Landroidx/compose/runtime/MutableIntState;", "displayCutouts", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/runtime/MutableState;", "Landroid/graphics/Rect;", "getDisplayCutouts", "()Landroidx/collection/MutableObjectList;", "displayCutoutRulers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/ui/layout/RectRulers;", "getDisplayCutoutRulers", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "onPrepare", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onStart", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "updateInsetAnimationInfo", "insetsValue", "onProgress", "insets", "runningAnimations", "", "onEnd", "stopAnimationForRuler", "onApplyWindowInsets", "view", "Landroid/view/View;", "updateInsets", "run", "onViewAttachedToWindow", "onViewDetachedFromWindow", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {
    public static final int $stable = 8;
    private final AndroidComposeView composeView;
    private final SnapshotStateList<RectRulers> displayCutoutRulers;
    private final MutableObjectList<MutableState<Rect>> displayCutouts;
    private final MutableIntState generation;
    private final ScatterMap<Object, WindowWindowInsetsAnimationValues> insetsValues;
    private boolean prepared;
    private int runningAnimationMask;
    private WindowInsetsCompat savedInsets;

    public InsetsListener(AndroidComposeView androidComposeView) {
        super(1);
        this.composeView = androidComposeView;
        MutableScatterMap mutableScatterMap = new MutableScatterMap(9);
        mutableScatterMap.set(WindowInsetsRulers.Companion.getCaptionBar(), new WindowWindowInsetsAnimationValues("caption bar"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getDisplayCutout(), new WindowWindowInsetsAnimationValues("display cutout"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getIme(), new WindowWindowInsetsAnimationValues("ime"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getMandatorySystemGestures(), new WindowWindowInsetsAnimationValues("mandatory system gestures"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getNavigationBars(), new WindowWindowInsetsAnimationValues("navigation bars"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getStatusBars(), new WindowWindowInsetsAnimationValues("status bars"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getSystemGestures(), new WindowWindowInsetsAnimationValues("system gestures"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getTappableElement(), new WindowWindowInsetsAnimationValues("tappable element"));
        mutableScatterMap.set(WindowInsetsRulers.Companion.getWaterfall(), new WindowWindowInsetsAnimationValues("waterfall"));
        this.insetsValues = mutableScatterMap;
        this.generation = SnapshotIntStateKt.mutableIntStateOf(0);
        this.displayCutouts = new MutableObjectList<>(4);
        this.displayCutoutRulers = SnapshotStateKt.mutableStateListOf();
    }

    public final AndroidComposeView getComposeView() {
        return this.composeView;
    }

    public final ScatterMap<Object, WindowWindowInsetsAnimationValues> getInsetsValues() {
        return this.insetsValues;
    }

    public final MutableIntState getGeneration() {
        return this.generation;
    }

    public final MutableObjectList<MutableState<Rect>> getDisplayCutouts() {
        return this.displayCutouts;
    }

    public final SnapshotStateList<RectRulers> getDisplayCutoutRulers() {
        return this.displayCutoutRulers;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.prepared = true;
        super.onPrepare(windowInsetsAnimationCompat);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        IntObjectMap intObjectMap;
        WindowInsetsCompat windowInsetsCompat = this.savedInsets;
        this.prepared = false;
        this.savedInsets = null;
        if (windowInsetsAnimationCompat.getDurationMillis() > 0 && windowInsetsCompat != null) {
            int typeMask = windowInsetsAnimationCompat.getTypeMask();
            this.runningAnimationMask |= typeMask;
            intObjectMap = WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) intObjectMap.get(typeMask);
            if (windowInsetsRulers != null) {
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                Insets insets = windowInsetsCompat.getInsets(typeMask);
                long m7009constructorimpl = ValueInsets.m7009constructorimpl(insets.bottom | (insets.left << 48) | (insets.top << 32) | (insets.right << 16));
                long m7020getCurrenthdzbrEE = windowWindowInsetsAnimationValues2.m7020getCurrenthdzbrEE();
                if (!ValueInsets.m7011equalsimpl0(m7009constructorimpl, m7020getCurrenthdzbrEE)) {
                    windowWindowInsetsAnimationValues2.m7026setSourceValueInsetsYnlvx88(m7020getCurrenthdzbrEE);
                    windowWindowInsetsAnimationValues2.m7027setTargetValueInsetsYnlvx88(m7009constructorimpl);
                    windowWindowInsetsAnimationValues2.setAnimating(true);
                    updateInsetAnimationInfo(windowWindowInsetsAnimationValues2, windowInsetsAnimationCompat);
                    MutableIntState mutableIntState = this.generation;
                    mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
                    Snapshot.Companion.sendApplyNotifications();
                }
            }
        }
        return super.onStart(windowInsetsAnimationCompat, boundsCompat);
    }

    private final void updateInsetAnimationInfo(WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        windowWindowInsetsAnimationValues.setFraction(windowInsetsAnimationCompat.getInterpolatedFraction());
        windowWindowInsetsAnimationValues.setAlpha(windowInsetsAnimationCompat.getAlpha());
        windowWindowInsetsAnimationValues.setDurationMillis(windowInsetsAnimationCompat.getDurationMillis());
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        IntObjectMap intObjectMap;
        this.prepared = false;
        int typeMask = windowInsetsAnimationCompat.getTypeMask();
        this.runningAnimationMask &= ~typeMask;
        this.savedInsets = null;
        intObjectMap = WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
        WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) intObjectMap.get(typeMask);
        if (windowInsetsRulers != null) {
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
            Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
            windowWindowInsetsAnimationValues2.setFraction(0.0f);
            windowWindowInsetsAnimationValues2.setAlpha(1.0f);
            windowWindowInsetsAnimationValues2.setDurationMillis(0L);
            windowWindowInsetsAnimationValues2.setFraction(0.0f);
            stopAnimationForRuler(windowWindowInsetsAnimationValues2);
            MutableIntState mutableIntState = this.generation;
            mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
            Snapshot.Companion.sendApplyNotifications();
        }
        super.onEnd(windowInsetsAnimationCompat);
    }

    private final void stopAnimationForRuler(WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues) {
        windowWindowInsetsAnimationValues.setAnimating(false);
        windowWindowInsetsAnimationValues.m7026setSourceValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
        windowWindowInsetsAnimationValues.m7027setTargetValueInsetsYnlvx88(ValueInsets_androidKt.getUnsetValueInsets());
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        if (this.prepared) {
            this.savedInsets = windowInsetsCompat;
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
                return windowInsetsCompat;
            }
        } else if (this.runningAnimationMask == 0) {
            updateInsets(windowInsetsCompat);
        }
        return windowInsetsCompat;
    }

    private final void updateInsets(WindowInsetsCompat windowInsetsCompat) {
        IntObjectMap intObjectMap;
        char c;
        char c2;
        boolean z;
        char c3;
        boolean z2;
        boolean z3;
        long m7009constructorimpl;
        MutableState<Rect> mutableStateOf$default;
        long[] jArr;
        int[] iArr;
        Object[] objArr;
        long[] jArr2;
        int[] iArr2;
        long j;
        int i;
        char c4;
        Object[] objArr2;
        intObjectMap = WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
        int[] iArr3 = intObjectMap.keys;
        Object[] objArr3 = intObjectMap.values;
        long[] jArr3 = intObjectMap.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i2 = 0;
            z2 = false;
            z3 = false;
            char c5 = 16;
            c = ' ';
            while (true) {
                long j2 = jArr3[i2];
                c2 = '0';
                z = true;
                if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((j2 & 255) < 128) {
                            int i6 = (i2 << 3) + i5;
                            c4 = c5;
                            int i7 = iArr3[i6];
                            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) objArr3[i6];
                            i = i3;
                            Insets insets = windowInsetsCompat.getInsets(i7);
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            long m7009constructorimpl2 = ValueInsets.m7009constructorimpl((insets.left << 48) | (insets.top << 32) | (insets.right << c4) | insets.bottom);
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                            Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
                            WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                            j = j2;
                            if (!ValueInsets.m7011equalsimpl0(m7009constructorimpl2, windowWindowInsetsAnimationValues2.m7020getCurrenthdzbrEE())) {
                                windowWindowInsetsAnimationValues2.m7024setCurrentYnlvx88(m7009constructorimpl2);
                                z2 = true;
                                if (!ValueInsets.m7011equalsimpl0(m7009constructorimpl2, ValueInsets_androidKt.getZeroValueInsets())) {
                                    z3 = true;
                                }
                            }
                            if (i7 != WindowInsetsCompat.Type.ime()) {
                                Insets insetsIgnoringVisibility = windowInsetsCompat.getInsetsIgnoringVisibility(i7);
                                objArr2 = objArr3;
                                long m7009constructorimpl3 = ValueInsets.m7009constructorimpl((insetsIgnoringVisibility.top << 32) | (insetsIgnoringVisibility.left << 48) | (insetsIgnoringVisibility.right << c4) | insetsIgnoringVisibility.bottom);
                                if (!ValueInsets.m7011equalsimpl0(windowWindowInsetsAnimationValues2.m7021getMaximumhdzbrEE(), m7009constructorimpl3)) {
                                    windowWindowInsetsAnimationValues2.m7025setMaximumYnlvx88(m7009constructorimpl3);
                                    z2 = true;
                                    if (!ValueInsets.m7011equalsimpl0(m7009constructorimpl3, ValueInsets_androidKt.getZeroValueInsets())) {
                                        z3 = true;
                                    }
                                }
                            } else {
                                objArr2 = objArr3;
                            }
                            windowWindowInsetsAnimationValues2.setVisible(windowInsetsCompat.isVisible(i7));
                        } else {
                            jArr2 = jArr3;
                            iArr2 = iArr3;
                            j = j2;
                            i = i3;
                            c4 = c5;
                            objArr2 = objArr3;
                        }
                        j2 = j >> i;
                        i5++;
                        objArr3 = objArr2;
                        i3 = i;
                        c5 = c4;
                        jArr3 = jArr2;
                        iArr3 = iArr2;
                    }
                    jArr = jArr3;
                    iArr = iArr3;
                    int i8 = i3;
                    c3 = c5;
                    objArr = objArr3;
                    if (i4 != i8) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                    iArr = iArr3;
                    objArr = objArr3;
                    c3 = c5;
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                objArr3 = objArr;
                c5 = c3;
                jArr3 = jArr;
                iArr3 = iArr;
            }
        } else {
            c = ' ';
            c2 = '0';
            z = true;
            c3 = 16;
            z2 = false;
            z3 = false;
        }
        DisplayCutoutCompat displayCutout = windowInsetsCompat.getDisplayCutout();
        if (displayCutout == null) {
            m7009constructorimpl = ValueInsets_androidKt.getZeroValueInsets();
        } else {
            Insets waterfallInsets = displayCutout.getWaterfallInsets();
            m7009constructorimpl = ValueInsets.m7009constructorimpl((waterfallInsets.left << c2) | (waterfallInsets.top << c) | (waterfallInsets.right << c3) | waterfallInsets.bottom);
        }
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues3 = this.insetsValues.get(WindowInsetsRulers.Companion.getWaterfall());
        Intrinsics.checkNotNull(windowWindowInsetsAnimationValues3);
        WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues4 = windowWindowInsetsAnimationValues3;
        windowWindowInsetsAnimationValues4.setVisible(!ValueInsets.m7011equalsimpl0(m7009constructorimpl, ValueInsets_androidKt.getZeroValueInsets()));
        if (!ValueInsets.m7011equalsimpl0(windowWindowInsetsAnimationValues4.m7020getCurrenthdzbrEE(), m7009constructorimpl)) {
            windowWindowInsetsAnimationValues4.m7024setCurrentYnlvx88(m7009constructorimpl);
            windowWindowInsetsAnimationValues4.m7025setMaximumYnlvx88(m7009constructorimpl);
            z2 = z;
            if (!ValueInsets.m7011equalsimpl0(m7009constructorimpl, ValueInsets_androidKt.getZeroValueInsets())) {
                z3 = z2;
            }
        }
        if (displayCutout == null) {
            if (this.displayCutouts.getSize() > 0) {
                this.displayCutouts.clear();
                this.displayCutoutRulers.clear();
                z2 = z;
            }
        } else {
            List<Rect> boundingRects = displayCutout.getBoundingRects();
            if (boundingRects.size() < this.displayCutouts.getSize()) {
                this.displayCutouts.removeRange(boundingRects.size(), this.displayCutouts.getSize());
                this.displayCutoutRulers.removeRange(boundingRects.size(), this.displayCutoutRulers.size());
                z2 = z;
            } else {
                int size = boundingRects.size() - this.displayCutouts.getSize();
                int i9 = 0;
                while (i9 < size) {
                    MutableObjectList<MutableState<Rect>> mutableObjectList = this.displayCutouts;
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(boundingRects.get(mutableObjectList.getSize()), null, 2, null);
                    mutableObjectList.add(mutableStateOf$default);
                    this.displayCutoutRulers.add(RectRulersKt.RectRulers("display cutout rect " + this.displayCutouts.getSize()));
                    i9++;
                    z2 = z;
                }
            }
            List<Rect> list = boundingRects;
            int size2 = list.size();
            for (int i10 = 0; i10 < size2; i10++) {
                Rect rect = boundingRects.get(i10);
                MutableState<Rect> mutableState = this.displayCutouts.get(i10);
                if (!Intrinsics.areEqual(mutableState.getValue(), rect)) {
                    mutableState.setValue(rect);
                    z2 = z;
                }
            }
            if (!list.isEmpty()) {
                z3 = z;
            }
        }
        if ((z3 || this.generation.getIntValue() != 0) && z2) {
            MutableIntState mutableIntState = this.generation;
            mutableIntState.setIntValue(mutableIntState.getIntValue() + 1);
            Snapshot.Companion.sendApplyNotifications();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prepared) {
            this.runningAnimationMask = 0;
            this.prepared = false;
            WindowInsetsCompat windowInsetsCompat = this.savedInsets;
            if (windowInsetsCompat != null) {
                updateInsets(windowInsetsCompat);
                this.savedInsets = null;
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        ViewParent parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, this);
        ViewCompat.setWindowInsetsAnimationCallback(view, this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        ViewParent parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 != null) {
            view = view2;
        }
        ViewCompat.setOnApplyWindowInsetsListener(view, null);
        ViewCompat.setWindowInsetsAnimationCallback(view, null);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
        IntObjectMap intObjectMap;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            WindowInsetsAnimationCompat windowInsetsAnimationCompat = list.get(i);
            int typeMask = windowInsetsAnimationCompat.getTypeMask();
            intObjectMap = WindowInsetsRulers_androidKt.WindowInsetsTypeMap;
            WindowInsetsRulers windowInsetsRulers = (WindowInsetsRulers) intObjectMap.get(typeMask);
            if (windowInsetsRulers != null) {
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues = this.insetsValues.get(windowInsetsRulers);
                Intrinsics.checkNotNull(windowWindowInsetsAnimationValues);
                WindowWindowInsetsAnimationValues windowWindowInsetsAnimationValues2 = windowWindowInsetsAnimationValues;
                if (windowWindowInsetsAnimationValues2.isAnimating()) {
                    updateInsetAnimationInfo(windowWindowInsetsAnimationValues2, windowInsetsAnimationCompat);
                }
            }
        }
        updateInsets(windowInsetsCompat);
        return windowInsetsCompat;
    }
}
