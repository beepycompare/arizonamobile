package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillValue;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
/* compiled from: PlatformAutofillManager.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/autofill/PlatformAutofillManagerImpl;", "Landroidx/compose/ui/autofill/PlatformAutofillManager;", "platformAndroidManager", "Landroid/view/autofill/AutofillManager;", "(Landroid/view/autofill/AutofillManager;)V", "getPlatformAndroidManager", "()Landroid/view/autofill/AutofillManager;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "", "commit", "notifyValueChanged", "view", "Landroid/view/View;", "semanticsId", "", "autofillValue", "Landroid/view/autofill/AutofillValue;", "notifyViewEntered", "bounds", "Landroid/graphics/Rect;", "notifyViewExited", "notifyViewVisibilityChanged", "isVisible", "", "requestAutofill", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformAutofillManagerImpl implements PlatformAutofillManager {
    public static final int $stable = 8;
    private final android.view.autofill.AutofillManager platformAndroidManager;

    public PlatformAutofillManagerImpl(android.view.autofill.AutofillManager autofillManager) {
        this.platformAndroidManager = autofillManager;
    }

    public final android.view.autofill.AutofillManager getPlatformAndroidManager() {
        return this.platformAndroidManager;
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyViewEntered(View view, int i, Rect rect) {
        this.platformAndroidManager.notifyViewEntered(view, i, rect);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyViewExited(View view, int i) {
        this.platformAndroidManager.notifyViewExited(view, i);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyValueChanged(View view, int i, AutofillValue autofillValue) {
        this.platformAndroidManager.notifyValueChanged(view, i, autofillValue);
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void notifyViewVisibilityChanged(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 27) {
            AutofillApi27Helper.INSTANCE.notifyViewVisibilityChanged(view, this.platformAndroidManager, i, z);
        }
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void commit() {
        this.platformAndroidManager.commit();
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void cancel() {
        this.platformAndroidManager.cancel();
    }

    @Override // androidx.compose.ui.autofill.PlatformAutofillManager
    public void requestAutofill(View view, int i, Rect rect) {
        this.platformAndroidManager.requestAutofill(view, i, rect);
    }
}
