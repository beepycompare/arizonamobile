package com.arizona.launcher;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.arizona.launcher.data.repository.PreferencesRepository;
import com.arizona.launcher.data.repository.settings.SettingsRepository;
import com.arizona.launcher.model.settings.AbstractSetting;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MainViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "settingsRepository", "Lcom/arizona/launcher/data/repository/settings/SettingsRepository;", "preferencesRepository", "Lcom/arizona/launcher/data/repository/PreferencesRepository;", "<init>", "(Lcom/arizona/launcher/data/repository/settings/SettingsRepository;Lcom/arizona/launcher/data/repository/PreferencesRepository;)V", "_settingsLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/arizona/launcher/model/settings/AbstractSetting;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "settingsLiveData", "getSettingsLiveData", "()Landroidx/lifecycle/LiveData;", "getPlayerNick", "", "setNotFirstRun", "", "onCleared", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";
    private final LiveData<List<AbstractSetting>> _settingsLiveData;
    private final CompositeDisposable compositeDisposable;
    private final PreferencesRepository preferencesRepository;
    private final LiveData<List<AbstractSetting>> settingsLiveData;
    private final SettingsRepository settingsRepository;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    @Inject
    public MainViewModel(SettingsRepository settingsRepository, PreferencesRepository preferencesRepository) {
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(preferencesRepository, "preferencesRepository");
        this.settingsRepository = settingsRepository;
        this.preferencesRepository = preferencesRepository;
        MutableLiveData mutableLiveData = new MutableLiveData(settingsRepository.getSettingsList());
        this._settingsLiveData = mutableLiveData;
        this.compositeDisposable = new CompositeDisposable();
        this.settingsLiveData = mutableLiveData;
        Log.d(TAG, "ViewModel created");
    }

    public final LiveData<List<AbstractSetting>> getSettingsLiveData() {
        return this.settingsLiveData;
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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/MainViewModel$Companion;", "", "<init>", "()V", "TAG", "", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
