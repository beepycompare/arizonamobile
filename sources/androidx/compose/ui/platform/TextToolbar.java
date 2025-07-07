package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* compiled from: TextToolbar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&JX\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH&Jj\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/TextToolbar;", "", NotificationCompat.CATEGORY_STATUS, "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "onAutofillRequested", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TextToolbar {
    TextToolbarStatus getStatus();

    void hide();

    void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04);

    /* compiled from: TextToolbar.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void showMenu(TextToolbar textToolbar, Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
            TextToolbar.super.showMenu(rect, function0, function02, function03, function04, function05);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showMenu$default(TextToolbar textToolbar, Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        if ((i & 8) != 0) {
            function03 = null;
        }
        if ((i & 16) != 0) {
            function04 = null;
        }
        if ((i & 32) != 0) {
            function05 = null;
        }
        textToolbar.showMenu(rect, function0, function02, function03, function04, function05);
    }

    default void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
        showMenu(rect, function0, function02, function03, function04);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showMenu$default(TextToolbar textToolbar, Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        if ((i & 8) != 0) {
            function03 = null;
        }
        if ((i & 16) != 0) {
            function04 = null;
        }
        textToolbar.showMenu(rect, function0, function02, function03, function04);
    }
}
