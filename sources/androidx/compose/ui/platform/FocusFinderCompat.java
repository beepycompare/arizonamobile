package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.TwoDimensionalFocusSearchKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FocusFinderCompat.android.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JF\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J<\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0005H\u0002JD\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J4\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J4\u0010 \u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat;", "", "<init>", "()V", "cachedFocusedRect", "Landroid/graphics/Rect;", "bestCandidateRect", "otherRect", "userSpecifiedFocusComparator", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "tmpList", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "findNextFocus", "root", "Landroid/view/ViewGroup;", "focused", "direction", "", "findNextFocusFromRect", "focusedRect", "getEffectiveRoot", "findNextUserSpecifiedFocus", "focusables", "findNextFocusInRelativeDirection", "setFocusBottomRight", "", "setFocusTopLeft", "findNextFocusInAbsoluteDirection", "getNextFocusable", "count", "getPreviousFocusable", "isValidId", "", "id", "Companion", "UserSpecifiedFocusComparator", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FocusFinderCompat {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final FocusFinderCompat$Companion$FocusFinderThreadLocal$1 FocusFinderThreadLocal = new ThreadLocal<FocusFinderCompat>() { // from class: androidx.compose.ui.platform.FocusFinderCompat$Companion$FocusFinderThreadLocal$1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public FocusFinderCompat initialValue() {
            return new FocusFinderCompat();
        }
    };
    private final Rect cachedFocusedRect = new Rect();
    private final Rect bestCandidateRect = new Rect();
    private final Rect otherRect = new Rect();
    private final UserSpecifiedFocusComparator userSpecifiedFocusComparator = new UserSpecifiedFocusComparator(new UserSpecifiedFocusComparator.NextFocusGetter() { // from class: androidx.compose.ui.platform.FocusFinderCompat$$ExternalSyntheticLambda0
        @Override // androidx.compose.ui.platform.FocusFinderCompat.UserSpecifiedFocusComparator.NextFocusGetter
        public final View get(View view, View view2) {
            View userSpecifiedFocusComparator$lambda$0;
            userSpecifiedFocusComparator$lambda$0 = FocusFinderCompat.userSpecifiedFocusComparator$lambda$0(FocusFinderCompat.this, view, view2);
            return userSpecifiedFocusComparator$lambda$0;
        }
    });
    private final ArrayList<View> tmpList = new ArrayList<>();

    private final boolean isValidId(int i) {
        return (i == 0 || i == -1) ? false : true;
    }

    /* compiled from: FocusFinderCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$Companion;", "", "<init>", "()V", "FocusFinderThreadLocal", "androidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1", "Landroidx/compose/ui/platform/FocusFinderCompat$Companion$FocusFinderThreadLocal$1;", "instance", "Landroidx/compose/ui/platform/FocusFinderCompat;", "getInstance", "()Landroidx/compose/ui/platform/FocusFinderCompat;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FocusFinderCompat getInstance() {
            FocusFinderCompat focusFinderCompat = FocusFinderCompat.FocusFinderThreadLocal.get();
            Intrinsics.checkNotNull(focusFinderCompat);
            return focusFinderCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View userSpecifiedFocusComparator$lambda$0(FocusFinderCompat focusFinderCompat, View view, View view2) {
        View findUserSetNextFocus;
        if (focusFinderCompat.isValidId(view2.getNextFocusForwardId())) {
            findUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(view2, view, 2);
            return findUserSetNextFocus;
        }
        return null;
    }

    public final View findNextFocus(ViewGroup viewGroup, View view, int i) {
        ViewGroup effectiveRoot = getEffectiveRoot(viewGroup, view);
        View findNextUserSpecifiedFocus = findNextUserSpecifiedFocus(effectiveRoot, view, i);
        if (findNextUserSpecifiedFocus != null) {
            return findNextUserSpecifiedFocus;
        }
        ArrayList<View> arrayList = this.tmpList;
        try {
            arrayList.clear();
            FocusFinderCompat_androidKt.addFocusableViews(effectiveRoot, arrayList, i);
            if (!arrayList.isEmpty()) {
                findNextUserSpecifiedFocus = findNextFocus(effectiveRoot, view, null, i, arrayList);
            }
            return findNextUserSpecifiedFocus;
        } finally {
            arrayList.clear();
        }
    }

    public final View findNextFocusFromRect(ViewGroup viewGroup, Rect rect, int i) {
        this.cachedFocusedRect.set(rect);
        return findNextFocus(viewGroup, this.cachedFocusedRect, i);
    }

    private final ViewGroup getEffectiveRoot(ViewGroup viewGroup, View view) {
        if (view != null && view != viewGroup) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = null;
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                } else if (parent == viewGroup) {
                    if (viewGroup2 == null) {
                        break;
                    }
                    return viewGroup2;
                } else {
                    ViewGroup viewGroup3 = (ViewGroup) parent;
                    if (viewGroup3.getTouchscreenBlocksFocus() && view.getContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen")) {
                        viewGroup2 = viewGroup3;
                    }
                    parent = viewGroup3.getParent();
                }
            }
        }
        return viewGroup;
    }

    private final View findNextUserSpecifiedFocus(ViewGroup viewGroup, View view, int i) {
        View findUserSetNextFocus;
        ViewGroup viewGroup2 = viewGroup;
        findUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(view, viewGroup2, i);
        boolean z = true;
        View view2 = findUserSetNextFocus;
        while (findUserSetNextFocus != null) {
            if (findUserSetNextFocus.isFocusable() && findUserSetNextFocus.getVisibility() == 0 && (!findUserSetNextFocus.isInTouchMode() || findUserSetNextFocus.isFocusableInTouchMode())) {
                return findUserSetNextFocus;
            }
            findUserSetNextFocus = FocusFinderCompat_androidKt.findUserSetNextFocus(findUserSetNextFocus, viewGroup2, i);
            boolean z2 = !z;
            if (!z) {
                view2 = view2 != null ? FocusFinderCompat_androidKt.findUserSetNextFocus(view2, viewGroup2, i) : null;
                if (view2 == findUserSetNextFocus) {
                    break;
                }
            }
            z = z2;
        }
        return null;
    }

    private final View findNextFocus(ViewGroup viewGroup, Rect rect, int i) {
        ViewGroup effectiveRoot = getEffectiveRoot(viewGroup, null);
        ArrayList<View> arrayList = this.tmpList;
        try {
            arrayList.clear();
            FocusFinderCompat_androidKt.addFocusableViews(effectiveRoot, arrayList, i);
            if (arrayList.isEmpty()) {
                return null;
            }
            return findNextFocus(effectiveRoot, null, rect, i, arrayList);
        } finally {
            arrayList.clear();
        }
    }

    private final View findNextFocus(ViewGroup viewGroup, View view, Rect rect, int i, ArrayList<View> arrayList) {
        Rect rect2 = this.cachedFocusedRect;
        if (view != null) {
            view.getFocusedRect(rect2);
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        } else if (rect != null) {
            rect2.set(rect);
        } else if (i != 1) {
            if (i != 2) {
                if (i == 17 || i == 33) {
                    setFocusBottomRight(viewGroup, rect2);
                } else if (i == 66 || i == 130) {
                    setFocusTopLeft(viewGroup, rect2);
                }
            } else if (viewGroup.getLayoutDirection() == 1) {
                setFocusBottomRight(viewGroup, rect2);
            } else {
                setFocusTopLeft(viewGroup, rect2);
            }
        } else if (viewGroup.getLayoutDirection() == 1) {
            setFocusTopLeft(viewGroup, rect2);
        } else {
            setFocusBottomRight(viewGroup, rect2);
        }
        if (i == 1 || i == 2) {
            return findNextFocusInRelativeDirection(arrayList, viewGroup, view, i);
        }
        if (i == 17 || i == 33 || i == 66 || i == 130) {
            return findNextFocusInAbsoluteDirection(viewGroup, view, rect2, arrayList, i);
        }
        throw new IllegalArgumentException("Unknown direction: " + i);
    }

    private final View findNextFocusInRelativeDirection(ArrayList<View> arrayList, ViewGroup viewGroup, View view, int i) {
        ArrayList<View> arrayList2;
        try {
            this.userSpecifiedFocusComparator.setFocusables(arrayList, viewGroup);
            Collections.sort(arrayList, this.userSpecifiedFocusComparator);
            this.userSpecifiedFocusComparator.recycle();
            int size = arrayList.size();
            View view2 = null;
            if (size < 2) {
                return null;
            }
            if (i == 1) {
                arrayList2 = arrayList;
                view2 = getPreviousFocusable(view, arrayList2, size);
            } else if (i == 2) {
                arrayList2 = arrayList;
                view2 = getNextFocusable(view, arrayList2, size);
            } else if (i == 17 || i == 33 || i == 66 || i == 130) {
                arrayList2 = arrayList;
                view2 = findNextFocusInAbsoluteDirection(viewGroup, view, this.cachedFocusedRect, arrayList2, i);
            } else {
                arrayList2 = arrayList;
            }
            return view2 == null ? arrayList2.get(size - 1) : view2;
        } catch (Throwable th) {
            this.userSpecifiedFocusComparator.recycle();
            throw th;
        }
    }

    private final void setFocusBottomRight(ViewGroup viewGroup, Rect rect) {
        int scrollY = viewGroup.getScrollY() + viewGroup.getHeight();
        int scrollX = viewGroup.getScrollX() + viewGroup.getWidth();
        rect.set(scrollX, scrollY, scrollX, scrollY);
    }

    private final void setFocusTopLeft(ViewGroup viewGroup, Rect rect) {
        int scrollY = viewGroup.getScrollY();
        int scrollX = viewGroup.getScrollX();
        rect.set(scrollX, scrollY, scrollX, scrollY);
    }

    private final View findNextFocusInAbsoluteDirection(ViewGroup viewGroup, View view, Rect rect, ArrayList<View> arrayList, int i) {
        this.bestCandidateRect.set(rect);
        if (i == 17) {
            this.bestCandidateRect.offset(rect.width() + 1, 0);
        } else if (i == 33) {
            this.bestCandidateRect.offset(0, rect.height() + 1);
        } else if (i == 66) {
            this.bestCandidateRect.offset((-rect.width()) - 1, 0);
        } else if (i == 130) {
            this.bestCandidateRect.offset(0, (-rect.height()) - 1);
        }
        ArrayList<View> arrayList2 = arrayList;
        int size = arrayList2.size();
        View view2 = null;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = arrayList2.get(i2);
            if (!Intrinsics.areEqual(view3, view) && !Intrinsics.areEqual(view3, viewGroup)) {
                view3.getFocusedRect(this.otherRect);
                viewGroup.offsetDescendantRectToMyCoords(view3, this.otherRect);
                androidx.compose.ui.geometry.Rect composeRect = RectHelper_androidKt.toComposeRect(this.otherRect);
                androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(this.bestCandidateRect);
                androidx.compose.ui.geometry.Rect composeRect3 = RectHelper_androidKt.toComposeRect(rect);
                FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(i);
                if (TwoDimensionalFocusSearchKt.m4984isBetterCandidateI7lrPNg(composeRect, composeRect2, composeRect3, focusDirection != null ? focusDirection.m4918unboximpl() : FocusDirection.Companion.m4923getNextdhqQ8s())) {
                    this.bestCandidateRect.set(this.otherRect);
                    view2 = view3;
                }
            }
        }
        return view2;
    }

    private final View getNextFocusable(View view, ArrayList<View> arrayList, int i) {
        int lastIndexOf;
        int i2;
        if (i < 2) {
            return null;
        }
        if (view != null && (lastIndexOf = arrayList.lastIndexOf(view)) >= 0 && (i2 = lastIndexOf + 1) < i) {
            return arrayList.get(i2);
        }
        return arrayList.get(0);
    }

    private final View getPreviousFocusable(View view, ArrayList<View> arrayList, int i) {
        int indexOf;
        if (i < 2) {
            return null;
        }
        if (view != null && (indexOf = arrayList.indexOf(view)) > 0) {
            return arrayList.get(indexOf - 1);
        }
        return arrayList.get(i - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FocusFinderCompat.android.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0003:\u0001\u001cB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u0012\u001a\u00020\u00112\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0014j\b\u0012\u0004\u0012\u00020\u0002`\u00152\u0006\u0010\u000f\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0002J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator;", "Ljava/util/Comparator;", "Landroid/view/View;", "Lkotlin/Comparator;", "mNextFocusGetter", "Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "<init>", "(Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;)V", "nextFoci", "Landroidx/collection/MutableScatterMap;", "isConnectedTo", "Landroidx/collection/MutableScatterSet;", "headsOfChains", "originalOrdinal", "Landroidx/collection/MutableObjectIntMap;", "root", "recycle", "", "setFocusables", "focusables", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setHeadOfChain", TtmlNode.TAG_HEAD, "compare", "", "first", "second", "NextFocusGetter", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class UserSpecifiedFocusComparator implements Comparator<View> {
        private final NextFocusGetter mNextFocusGetter;
        private View root;
        private final MutableScatterMap<View, View> nextFoci = ScatterMapKt.mutableScatterMapOf();
        private final MutableScatterSet<View> isConnectedTo = ScatterSetKt.mutableScatterSetOf();
        private final MutableScatterMap<View, View> headsOfChains = ScatterMapKt.mutableScatterMapOf();
        private final MutableObjectIntMap<View> originalOrdinal = ObjectIntMapKt.mutableObjectIntMapOf();

        /* compiled from: FocusFinderCompat.android.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/FocusFinderCompat$UserSpecifiedFocusComparator$NextFocusGetter;", "", "get", "Landroid/view/View;", "root", "view", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public interface NextFocusGetter {
            View get(View view, View view2);
        }

        public UserSpecifiedFocusComparator(NextFocusGetter nextFocusGetter) {
            this.mNextFocusGetter = nextFocusGetter;
        }

        public final void recycle() {
            this.root = null;
            this.headsOfChains.clear();
            this.isConnectedTo.clear();
            this.originalOrdinal.clear();
            this.nextFoci.clear();
        }

        public final void setFocusables(ArrayList<View> arrayList, View view) {
            this.root = view;
            ArrayList<View> arrayList2 = arrayList;
            ArrayList<View> arrayList3 = arrayList2;
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                this.originalOrdinal.set(arrayList2.get(i), i);
            }
            int size2 = arrayList3.size() - 1;
            if (size2 >= 0) {
                while (true) {
                    int i2 = size2 - 1;
                    View view2 = arrayList2.get(size2);
                    View view3 = this.mNextFocusGetter.get(view, view2);
                    if (view3 != null && this.originalOrdinal.containsKey(view3)) {
                        this.nextFoci.set(view2, view3);
                        this.isConnectedTo.add(view3);
                    }
                    if (i2 < 0) {
                        break;
                    }
                    size2 = i2;
                }
            }
            int size3 = arrayList3.size() - 1;
            if (size3 < 0) {
                return;
            }
            while (true) {
                int i3 = size3 - 1;
                View view4 = arrayList2.get(size3);
                if (this.nextFoci.get(view4) != null && !this.isConnectedTo.contains(view4)) {
                    setHeadOfChain(view4);
                }
                if (i3 < 0) {
                    return;
                }
                size3 = i3;
            }
        }

        public final void setHeadOfChain(View view) {
            View view2 = view;
            while (view != null) {
                View view3 = this.headsOfChains.get(view);
                if (view3 != null) {
                    if (view3 == view2) {
                        return;
                    }
                    view = view2;
                    view2 = view3;
                }
                this.headsOfChains.set(view, view2);
                view = this.nextFoci.get(view);
            }
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            if (view == view2) {
                return 0;
            }
            if (view == null) {
                return -1;
            }
            if (view2 == null) {
                return 1;
            }
            View view3 = this.headsOfChains.get(view);
            View view4 = this.headsOfChains.get(view2);
            if (view3 == view4 && view3 != null) {
                if (view == view3) {
                    return -1;
                }
                return (view2 == view3 || this.nextFoci.get(view) == null) ? 1 : -1;
            }
            if (view3 != null) {
                view = view3;
            }
            if (view4 != null) {
                view2 = view4;
            }
            if (view3 == null && view4 == null) {
                return 0;
            }
            return this.originalOrdinal.get(view) < this.originalOrdinal.get(view2) ? -1 : 1;
        }
    }
}
