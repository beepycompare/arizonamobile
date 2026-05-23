package androidx.compose.ui.platform.actionmodecallback;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.arizona.launcher.UpdateActivity;
import kotlin.Metadata;
/* compiled from: FloatingTextActionModeCallback.android.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/FloatingTextActionModeCallback;", "Landroid/view/ActionMode$Callback2;", "callback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "<init>", "(Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;)V", "onActionItemClicked", "", UpdateActivity.UPDATE_MODE, "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onDestroyActionMode", "", "onGetContentRect", "view", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatingTextActionModeCallback extends ActionMode.Callback2 {
    public static final int $stable = 8;
    private final TextActionModeCallback callback;

    public FloatingTextActionModeCallback(TextActionModeCallback textActionModeCallback) {
        this.callback = textActionModeCallback;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.callback.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.callback.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.callback.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.callback.onDestroyActionMode();
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
        androidx.compose.ui.geometry.Rect rect2 = this.callback.getRect();
        if (rect != null) {
            rect.set((int) rect2.getLeft(), (int) rect2.getTop(), (int) rect2.getRight(), (int) rect2.getBottom());
        }
    }
}
