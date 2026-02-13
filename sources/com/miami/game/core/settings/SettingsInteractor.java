package com.miami.game.core.settings;

import android.content.Intent;
import android.widget.Toast;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.settings.logs.SaveLogToDownloadsKt;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: SettingsInteractor.kt */
@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/miami/game/core/settings/SettingsInteractor;", "", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "<init>", "(Lcom/miami/game/core/local/repository/common/LocalRepository;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "isTablet", "", "()Z", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/core/settings/SettingState;", "interactorStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInteractorStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "saveSettings", "", "settings", "getSettings", "changeNotifications", "saveLogFile", "Companion", "settings_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsInteractor {
    public static final Companion Companion = new Companion(null);
    public static final String SettingsKey = "SETTINGS";
    private final StateFlow<SettingState> interactorStateFlow;
    private final boolean isTablet;
    private final LocalRepository localRepository;
    private final CoroutineScope scope;
    private final MutableStateFlow<SettingState> stateStore;

    @Inject
    public SettingsInteractor(LocalRepository localRepository) {
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        this.localRepository = localRepository;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        boolean z = localRepository.getContext().getResources().getConfiguration().smallestScreenWidthDp >= 600;
        this.isTablet = z;
        MutableStateFlow<SettingState> MutableStateFlow = StateFlowKt.MutableStateFlow(SettingState.Companion.init(z));
        this.stateStore = MutableStateFlow;
        this.interactorStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        getSettings();
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final StateFlow<SettingState> getInteractorStateFlow() {
        return this.interactorStateFlow;
    }

    public final void saveSettings(SettingState settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SettingsInteractor$saveSettings$1(this, settings, null), 3, null);
    }

    public final void getSettings() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new SettingsInteractor$getSettings$1(this, null), 3, null);
    }

    public final void changeNotifications() {
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", this.localRepository.getContext().getPackageName());
        intent.setFlags(268435456);
        this.localRepository.getContext().startActivity(intent);
    }

    public final void saveLogFile() {
        File externalFilesDir = this.localRepository.getContext().getExternalFilesDir(null);
        File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/logcat/samp.log");
        SaveLogToDownloadsKt.copyToDownloads(this.localRepository.getContext(), file, "arizona_" + System.currentTimeMillis() + "_" + file.getName());
        Toast.makeText(this.localRepository.getContext(), "Логи сохранены в Загрузки", 1).show();
    }

    /* compiled from: SettingsInteractor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/miami/game/core/settings/SettingsInteractor$Companion;", "", "<init>", "()V", "SettingsKey", "", "settings_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
