package dagger.hilt.android.internal.managers;

import androidx.lifecycle.SavedStateHandle;
import dagger.Module;
import dagger.Provides;
@Module
/* loaded from: classes4.dex */
abstract class SavedStateHandleModule {
    SavedStateHandleModule() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public static SavedStateHandle provideSavedStateHandle(SavedStateHandleHolder savedStateHandleHolder) {
        return savedStateHandleHolder.getSavedStateHandle();
    }
}
