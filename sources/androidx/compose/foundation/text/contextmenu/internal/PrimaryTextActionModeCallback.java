package androidx.compose.foundation.text.contextmenu.internal;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.arizona.launcher.UpdateActivity;
import kotlin.Metadata;
/* compiled from: AndroidTextContextMenuToolbarProvider.android.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/internal/PrimaryTextActionModeCallback;", "Landroid/view/ActionMode$Callback;", "textActionModeCallback", "Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/internal/TextActionModeCallback;)V", "onCreateActionMode", "", UpdateActivity.UPDATE_MODE, "Landroid/view/ActionMode;", "menu", "Landroid/view/Menu;", "onPrepareActionMode", "onActionItemClicked", "item", "Landroid/view/MenuItem;", "onDestroyActionMode", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class PrimaryTextActionModeCallback implements ActionMode.Callback {
    private final TextActionModeCallback textActionModeCallback;

    public PrimaryTextActionModeCallback(TextActionModeCallback textActionModeCallback) {
        this.textActionModeCallback = textActionModeCallback;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.textActionModeCallback.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.textActionModeCallback.onPrepareActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.textActionModeCallback.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.textActionModeCallback.onDestroyActionMode(actionMode);
    }
}
