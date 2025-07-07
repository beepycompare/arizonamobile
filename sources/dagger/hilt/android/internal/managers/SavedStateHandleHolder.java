package dagger.hilt.android.internal.managers;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import dagger.hilt.android.internal.ThreadUtil;
import dagger.hilt.internal.Preconditions;
/* loaded from: classes4.dex */
public final class SavedStateHandleHolder {
    private CreationExtras extras;
    private SavedStateHandle handle;
    private final boolean nonComponentActivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateHandleHolder(CreationExtras extras) {
        this.nonComponentActivity = extras == null;
        this.extras = extras;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateHandle getSavedStateHandle() {
        ThreadUtil.ensureMainThread();
        Preconditions.checkState(!this.nonComponentActivity, "Activity that does not extend ComponentActivity cannot use SavedStateHandle", new Object[0]);
        SavedStateHandle savedStateHandle = this.handle;
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        Preconditions.checkNotNull(this.extras, "The first access to SavedStateHandle should happen between super.onCreate() and super.onDestroy()");
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.extras);
        mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, Bundle.EMPTY);
        this.extras = mutableCreationExtras;
        SavedStateHandle createSavedStateHandle = SavedStateHandleSupport.createSavedStateHandle(mutableCreationExtras);
        this.handle = createSavedStateHandle;
        this.extras = null;
        return createSavedStateHandle;
    }

    public void clear() {
        this.extras = null;
    }

    public void setExtras(CreationExtras extras) {
        if (this.handle != null) {
            return;
        }
        this.extras = extras;
    }

    public boolean isInvalid() {
        return this.handle == null && this.extras == null;
    }
}
