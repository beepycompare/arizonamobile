package com.arizona.launcher;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.arizona.launcher.data.repository.PreferencesRepository;
import com.arizona.launcher.data.repository.settings.SettingsRepository;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "settingsRepository", "Lcom/arizona/launcher/data/repository/settings/SettingsRepository;", "preferencesRepository", "Lcom/arizona/launcher/data/repository/PreferencesRepository;", "<init>", "(Lcom/arizona/launcher/data/repository/settings/SettingsRepository;Lcom/arizona/launcher/data/repository/PreferencesRepository;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getPlayerNick", "", "setNotFirstRun", "", "onCleared", "Companion", "app_arizonaRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";
    private final CompositeDisposable compositeDisposable;
    private final PreferencesRepository preferencesRepository;
    private final SettingsRepository settingsRepository;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public MainViewModel(SettingsRepository settingsRepository, PreferencesRepository preferencesRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(preferencesRepository, "preferencesRepository");
        this.settingsRepository = settingsRepository;
        this.preferencesRepository = preferencesRepository;
        this.compositeDisposable = new CompositeDisposable();
        Log.d(TAG, "ViewModel created");
    }

    public final String getPlayerNick() {
        return this.settingsRepository.getNickname();
    }

    public final void setNotFirstRun() {
        this.preferencesRepository.setNotFirstRun();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.compositeDisposable.clear();
        super.onCleared();
    }

    /* compiled from: MainViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/MainViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_arizonaRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
