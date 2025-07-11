package com.arizona.launcher.data.repository.settings;

import android.content.SharedPreferences;
import com.arizona.game.R;
import com.arizona.launcher.model.settings.AbstractSetting;
import com.arizona.launcher.model.settings.BooleanSetting;
import com.arizona.launcher.model.settings.SelectableValueSetting;
import com.arizona.launcher.model.settings.SettingsConstants;
import com.arizona.launcher.model.settings.StringSetting;
import com.arizona.launcher.model.settings.validation.StringSettingValidator;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.google.android.vending.expansion.downloader.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: SettingsRepository.kt */
@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/data/repository/settings/SettingsRepository;", "", "preferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "getNickname", "", "setNickname", "", "newNick", "getIsFullscreen", "", "settingsList", "", "Lcom/arizona/launcher/model/settings/AbstractSetting;", "getSettingsList", "()Ljava/util/List;", "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsRepository {
    public static final int $stable = 8;
    private final List<AbstractSetting> settingsList;

    @Inject
    public SettingsRepository(SharedPreferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.settingsList = getSettingsList(preferences);
    }

    public final String getNickname() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String substring = StringsKt.replace$default(uuid, Constants.FILENAME_SEQUENCE_SEPARATOR, "", false, 4, (Object) null).substring(0, 12);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return "Player_" + substring;
    }

    public final void setNickname(String newNick) {
        Object obj;
        Intrinsics.checkNotNullParameter(newNick, "newNick");
        Iterator<T> it = this.settingsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((AbstractSetting) obj).getSettingKey(), SettingsConstants.NICKNAME)) {
                break;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.arizona.launcher.model.settings.StringSetting");
        ((StringSetting) obj).setCurrentValue(newNick);
    }

    public final boolean getIsFullscreen() {
        Object obj;
        Iterator<T> it = this.settingsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((AbstractSetting) obj).getSettingKey(), SettingsConstants.USE_FULLSCREEN)) {
                break;
            }
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.arizona.launcher.model.settings.BooleanSetting");
        return ((BooleanSetting) obj).getCurrentValue();
    }

    public final List<AbstractSetting> getSettingsList() {
        return this.settingsList;
    }

    private final List<AbstractSetting> getSettingsList(SharedPreferences sharedPreferences) {
        return CollectionsKt.mutableListOf(new StringSetting("Имя пользователя", "Указывается в игре", "Указывается в игре", sharedPreferences, R.drawable.user_icon_vec, StringSettingValidator.Companion.createByRegexp("")), new BooleanSetting("Полный экран", SettingsConstants.USE_FULLSCREEN, false, sharedPreferences), new BooleanSetting("Отображать FPS", SettingsConstants.SHOW_FPS, false, sharedPreferences), new BooleanSetting("Дата и время в чате", SettingsConstants.CHAT_PRINT_TIMESTAMP, false, sharedPreferences), new BooleanSetting("Режим стримера", SettingsConstants.STREAMER_MODE, false, sharedPreferences), new SelectableValueSetting("Строк чата", SettingsConstants.CHAT_PAGE_SIZE, 1, MapsKt.mapOf(TuplesKt.to(0, "5"), TuplesKt.to(1, "8"), TuplesKt.to(2, "10")), R.drawable.user_icon_vec, sharedPreferences), new SelectableValueSetting("Размер шрифта чата", SettingsConstants.CHAT_FONT_SIZE, 2, MapsKt.mapOf(TuplesKt.to(0, "0.1"), TuplesKt.to(1, "0.5"), TuplesKt.to(2, BuildConfig.VERSION_NAME), TuplesKt.to(3, "1.5"), TuplesKt.to(4, "2.0")), R.drawable.user_icon_vec, sharedPreferences));
    }
}
