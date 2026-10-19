package ru.mrlargha.commonui.elements.settingsMenu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.miami.game.core.settings.NativeGraphicsCapabilities;
import com.miami.game.core.settings.SettingsMenuDefaults;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.SettingsLayoutBinding;
import ru.mrlargha.commonui.elements.keyboard.inGameKeyboard.KeyboardKeeper;
import ru.mrlargha.commonui.elements.settingsMenu.model.SettingItemModel;
import ru.mrlargha.commonui.elements.settingsMenu.model.SettingType;
/* compiled from: SettingsMenuScreen.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0002:;B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J&\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0016\u0010%\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0012H\u0002J\u0016\u0010(\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0012H\u0002J\u0016\u0010)\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0012H\u0002J\u0016\u0010*\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0012H\u0002J(\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0005H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0005H\u0002J\u0018\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u0005H\u0016R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/SettingsMenuScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "settingsLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "settingsBinding", "Lru/mrlargha/commonui/databinding/SettingsLayoutBinding;", "settingsAdapter", "Lru/mrlargha/commonui/elements/settingsMenu/SettingsAdapter;", "sharedPref", "Landroid/content/SharedPreferences;", "anisotropyLevels", "", "anisotropyChanged", "", "currPage", "isMenuMap", "isShowControllerSetting", "setVisibility", "", "visible", "restoreSettings", "showSettings", "showMap", "title", "", "icon", "controller_show", "resetSettings", "initNavigationMenu", "saveSettings", "saveMainPageInfo", "value", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingItemModel;", "saveControlPageInfo", "saveSoundPageInfo", "saveGraphicsPageInfo", "setupNavigationLogic", "rootNavItem", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootNavText", "Landroid/widget/TextView;", "rootNavIcon", "Landroid/widget/ImageView;", "page", "setupThemeForNavigationMenu", "initSettingMenu", "onClickLink", TtmlNode.ATTR_ID, "onBackendMessageHandled", "data", "subId", "Companion", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SettingsMenuScreen extends SAMPUIElement {
    private boolean anisotropyChanged;
    private List<Integer> anisotropyLevels;
    private int currPage;
    private boolean isMenuMap;
    private boolean isShowControllerSetting;
    private SettingsAdapter settingsAdapter;
    private final SettingsLayoutBinding settingsBinding;
    private final View settingsLayout;
    private final SharedPreferences sharedPref;
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, List<SettingItemModel>> pagesSettingsMap = new LinkedHashMap();
    private static final int[] msaaSamples = {0, 2, 4, 8};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsMenuScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View settingsLayout = targetActivity.getLayoutInflater().inflate(R.layout.settings_layout, (ViewGroup) null);
        this.settingsLayout = settingsLayout;
        SettingsLayoutBinding bind = SettingsLayoutBinding.bind(settingsLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.settingsBinding = bind;
        this.settingsAdapter = new SettingsAdapter(new Function3() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsMenuScreen.settingsAdapter$lambda$0(SettingsMenuScreen.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (SettingItemModel) obj3);
            }
        }, new Function1() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SettingsMenuScreen.settingsAdapter$lambda$1(SettingsMenuScreen.this, ((Integer) obj).intValue());
            }
        });
        this.sharedPref = SettingsMenuDefaults.prefs(targetActivity);
        this.anisotropyLevels = CollectionsKt.listOf(1);
        this.currPage = R.id.main_page_button;
        this.isMenuMap = true;
        Intrinsics.checkNotNullExpressionValue(settingsLayout, "settingsLayout");
        SAMPUIElement.addViewToConstraintLayout$default(this, settingsLayout, -1, -1, false, 8, null);
        bind.backButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.lambda$0$0(SettingsMenuScreen.this, view);
            }
        });
        bind.resetSettingsButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.this.resetSettings();
            }
        });
        restoreSettings();
        initNavigationMenu();
        initSettingMenu();
        showMap$default(this, null, 0, false, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsAdapter$lambda$0(SettingsMenuScreen settingsMenuScreen, int i, int i2, SettingItemModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        Map<Integer, List<SettingItemModel>> map = pagesSettingsMap;
        if (map.get(Integer.valueOf(i)) != null) {
            List<SettingItemModel> list = map.get(Integer.valueOf(i));
            Intrinsics.checkNotNull(list);
            list.get(i2).setType(model.getType());
        }
        if (i == R.id.graphic_page_button && i2 == 5) {
            settingsMenuScreen.anisotropyChanged = true;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settingsAdapter$lambda$1(SettingsMenuScreen settingsMenuScreen, int i) {
        settingsMenuScreen.onClickLink(i);
        return Unit.INSTANCE;
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void setVisibility(boolean z) {
        SettingsMenuScreen settingsMenuScreen;
        if (z) {
            settingsMenuScreen = this;
            showMap$default(settingsMenuScreen, null, 0, false, 7, null);
        } else {
            settingsMenuScreen = this;
            settingsMenuScreen.settingsAdapter.clear();
        }
        super.setVisibility(z);
    }

    /* compiled from: SettingsMenuScreen.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007H\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/SettingsMenuScreen$Companion;", "", "<init>", "()V", "pagesSettingsMap", "", "", "", "Lru/mrlargha/commonui/elements/settingsMenu/model/SettingItemModel;", "msaaSamples", "", "msaaIndex", "samples", "getSettingsJson", "", "targetActivity", "Landroid/app/Activity;", "restoreSavedSettings", "", "anisotropyLevels", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int msaaIndex(int i) {
            Integer valueOf = Integer.valueOf(ArraysKt.indexOf(SettingsMenuScreen.msaaSamples, i));
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            if (valueOf != null) {
                return valueOf.intValue();
            }
            return 0;
        }

        public final String getSettingsJson(Activity targetActivity) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return SettingsMenuDefaults.toJson(targetActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void restoreSavedSettings(Activity activity, List<Integer> list) {
            String str;
            Activity activity2 = activity;
            SharedPreferences prefs = SettingsMenuDefaults.prefs(activity2);
            float maxVideoFps = SettingsMenuDefaults.maxVideoFps(activity2);
            SettingsMenuScreen.pagesSettingsMap.clear();
            Map map = SettingsMenuScreen.pagesSettingsMap;
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to(Integer.valueOf(R.id.main_page_button), CollectionsKt.listOf((Object[]) new SettingItemModel[]{new SettingItemModel("Размер шрифта в чате", new SettingType.SettingSelector(CollectionsKt.listOf((Object[]) new String[]{"0.5", BuildConfig.VERSION_NAME, "1.5", "2.0"}), prefs.getInt(SettingsMenuDefaults.KEY_CHAT_FONT_SIZE, 1))), new SettingItemModel("Строк чата", new SettingType.SettingSelector(CollectionsKt.listOf((Object[]) new String[]{"5", "8", "10", "12"}), prefs.getInt(SettingsMenuDefaults.KEY_CHAT_COUNTS, 2))), new SettingItemModel("Режим", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Обычный", "Стример"}), prefs.getInt(SettingsMenuDefaults.KEY_GAME_MODE, 0))), new SettingItemModel("Клавиатура", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Системная", "Игровая"}), prefs.getInt(SettingsMenuDefaults.KEY_KEYBOARD_TYPE, 0))), new SettingItemModel("Полный экран", new SettingType.SettingSwitcher(prefs.getBoolean(SettingsMenuDefaults.KEY_FULL_SCREEN, true))), new SettingItemModel("Отображать FPS", new SettingType.SettingSwitcher(prefs.getBoolean(SettingsMenuDefaults.KEY_SHOW_FPS, false))), new SettingItemModel("Время в чате", new SettingType.SettingSwitcher(prefs.getBoolean(SettingsMenuDefaults.KEY_TIME_IN_CHAT, false)))}));
            pairArr[1] = TuplesKt.to(Integer.valueOf(R.id.control_page_button), CollectionsKt.listOf((Object[]) new SettingItemModel[]{new SettingItemModel("Способ управления авто ", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Джойстик", "Кнопки"}), prefs.getInt(SettingsMenuDefaults.KEY_STEERING, 0))), new SettingItemModel("Вид назад", new SettingType.SettingSwitcher(prefs.getBoolean(SettingsMenuDefaults.KEY_BACK_VIEW, true))), new SettingItemModel("Редактировать управление \"Пешком\"", new SettingType.SettingLink(4)), new SettingItemModel("Редактировать управление \"В машине\"", new SettingType.SettingLink(5))}));
            pairArr[2] = TuplesKt.to(Integer.valueOf(R.id.sound_page_button), CollectionsKt.listOf((Object[]) new SettingItemModel[]{new SettingItemModel("Громкость окружающей среды", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_VOLUME_SURROUNDING, 100), 0.0f, 0.0f, 0, 14, null)), new SettingItemModel("Громкость голосового чата", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_VOICE_CHAT_VOLUME, 100), 0.0f, 0.0f, 0, 14, null)), new SettingItemModel("Громкость микрофона", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_MIC_VOLUME, 100), 0.0f, 0.0f, 0, 14, null)), new SettingItemModel("Громкость музыки транспорта", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_VEHICLE_MUSIC_VOLUME, 100), 0.0f, 0.0f, 0, 14, null)), new SettingItemModel("Громкость бумбоксов", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_BOOM_BOX_MUSIC_SOUND, 100), 0.0f, 0.0f, 0, 14, null)), new SettingItemModel("Микрофон", new SettingType.SettingSwitcher(prefs.getBoolean(SettingsMenuDefaults.KEY_MIC_ENABLED, true))), new SettingItemModel("Звуки окружения", new SettingType.SettingSwitcher(prefs.getBoolean(SettingsMenuDefaults.KEY_AMBIENT_SOUNDS, true)))}));
            Integer valueOf = Integer.valueOf(R.id.graphic_page_button);
            SettingItemModel[] settingItemModelArr = new SettingItemModel[12];
            settingItemModelArr[0] = new SettingItemModel("Качество эффектов", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Низкое", "Среднее", "Высокое", "Ультра"}), prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_EFFECTS, 1)));
            settingItemModelArr[1] = new SettingItemModel("Качество теней", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Отключено", "Низкое", "Среднее", "Высокое", "Ультра"}), prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_SHADOWS, 0)));
            settingItemModelArr[2] = new SettingItemModel("Качество транспорта", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Очень низкое", "Низкое", "Среднее", "Высокое"}), prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_VEHICLES, 2)));
            settingItemModelArr[3] = new SettingItemModel("VSync", new SettingType.SettingSwitcher(prefs.getBoolean(SettingsMenuDefaults.KEY_VIDEO_VSYNC, false)));
            String string = activity.getString(R.string.settings_msaa);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            settingItemModelArr[4] = new SettingItemModel(string, new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{activity.getString(R.string.settings_msaa_disabled), activity.getString(R.string.settings_msaa_2x), activity.getString(R.string.settings_msaa_4x), activity.getString(R.string.settings_msaa_8x)}), msaaIndex(prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_MSAA, 1))));
            String string2 = activity.getString(R.string.settings_anisotropy);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            List<Integer> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Number number : list2) {
                int intValue = number.intValue();
                if (intValue == 1) {
                    str = activity.getString(R.string.settings_anisotropy_disabled);
                } else {
                    str = intValue + "x";
                }
                arrayList.add(str);
            }
            settingItemModelArr[5] = new SettingItemModel(string2, new SettingType.SettingTextSwitcher(arrayList, list.indexOf(Integer.valueOf(SettingsMenuDefaults.INSTANCE.effectiveVideoAnisotropy(prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_ANISOTROPY, 2), ((Number) CollectionsKt.last((List<? extends Object>) list)).intValue())))));
            settingItemModelArr[6] = new SettingItemModel("Качество воды", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Низкое", "Среднее", "Высокое"}), prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_WATER_QUALITY, 0)));
            settingItemModelArr[7] = new SettingItemModel("Дальность прорисовки", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_FAR_CLIP, 40), 25.0f, 0.0f, 0, 12, null));
            settingItemModelArr[8] = new SettingItemModel("Яркость", new SettingType.SettingSlider(RangesKt.coerceIn(prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_BRIGHTNESS, 60), 25, 100), 25.0f, 0.0f, 0, 12, null));
            settingItemModelArr[9] = new SettingItemModel("Максимальный ФПС", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_MAX_FPS, 60), 20.0f, maxVideoFps, 0, 8, null));
            settingItemModelArr[10] = new SettingItemModel("Масштаб 3D-сцены", new SettingType.SettingSlider(prefs.getInt(SettingsMenuDefaults.KEY_VIDEO_RENDER_SCALE, 85), 25.0f, 100.0f, 0, 8, null));
            settingItemModelArr[11] = new SettingItemModel("Режим производительности", new SettingType.SettingTextSwitcher(CollectionsKt.listOf((Object[]) new String[]{"Auto", "Perf", "Pinned"}), prefs.getInt(SettingsMenuDefaults.KEY_CPU_MODE, 0)));
            pairArr[3] = TuplesKt.to(valueOf, CollectionsKt.listOf((Object[]) settingItemModelArr));
            map.putAll(MapsKt.mutableMapOf(pairArr));
        }
    }

    private final void restoreSettings() {
        this.anisotropyLevels = SettingsMenuDefaults.INSTANCE.supportedVideoAnisotropyLevels(NativeGraphicsCapabilities.INSTANCE.maxTextureAnisotropy());
        this.anisotropyChanged = false;
        Companion.restoreSavedSettings(getTargetActivity(), this.anisotropyLevels);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(SettingsMenuScreen settingsMenuScreen, View view) {
        if (settingsMenuScreen.isMenuMap) {
            if (settingsMenuScreen.isShowControllerSetting) {
                settingsMenuScreen.showSettings();
                SAMPUIElement.notifyClick$default(settingsMenuScreen, 0, 6, null, 4, null);
                return;
            }
            settingsMenuScreen.setVisibility(false);
            SAMPUIElement.notifyClick$default(settingsMenuScreen, 0, 2, null, 4, null);
            return;
        }
        showMap$default(settingsMenuScreen, null, 0, false, 7, null);
    }

    private final void showSettings() {
        SettingsLayoutBinding settingsLayoutBinding = this.settingsBinding;
        settingsLayoutBinding.saveButton.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), R.drawable.setting_ic_done));
        settingsLayoutBinding.mainSettingsPage.setVisibility(0);
        settingsLayoutBinding.pageName.setText("Настройки игры");
        settingsLayoutBinding.settingsLayout.setBackgroundResource(R.drawable.bg_settings_main_page);
        this.isMenuMap = false;
        restoreSettings();
        setupThemeForNavigationMenu();
        if (this.isShowControllerSetting) {
            Toast.makeText(getTargetActivity(), "Виджеты управления обновлены!", 0).show();
            ConstraintLayout controlPageButton = settingsLayoutBinding.controlPageButton;
            Intrinsics.checkNotNullExpressionValue(controlPageButton, "controlPageButton");
            TextView controlPageButtonTxt = settingsLayoutBinding.controlPageButtonTxt;
            Intrinsics.checkNotNullExpressionValue(controlPageButtonTxt, "controlPageButtonTxt");
            ImageView controlPageButtonIc = settingsLayoutBinding.controlPageButtonIc;
            Intrinsics.checkNotNullExpressionValue(controlPageButtonIc, "controlPageButtonIc");
            setupNavigationLogic(controlPageButton, controlPageButtonTxt, controlPageButtonIc, R.id.control_page_button);
            this.isShowControllerSetting = false;
            return;
        }
        ConstraintLayout mainPageButton = settingsLayoutBinding.mainPageButton;
        Intrinsics.checkNotNullExpressionValue(mainPageButton, "mainPageButton");
        TextView mainPageButtonTxt = settingsLayoutBinding.mainPageButtonTxt;
        Intrinsics.checkNotNullExpressionValue(mainPageButtonTxt, "mainPageButtonTxt");
        ImageView mainPageButtonIc = settingsLayoutBinding.mainPageButtonIc;
        Intrinsics.checkNotNullExpressionValue(mainPageButtonIc, "mainPageButtonIc");
        setupNavigationLogic(mainPageButton, mainPageButtonTxt, mainPageButtonIc, R.id.main_page_button);
    }

    static /* synthetic */ void showMap$default(SettingsMenuScreen settingsMenuScreen, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "Карта";
        }
        if ((i2 & 2) != 0) {
            i = R.drawable.settings_map_button;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        settingsMenuScreen.showMap(str, i, z);
    }

    private final void showMap(String str, int i, boolean z) {
        SettingsLayoutBinding settingsLayoutBinding = this.settingsBinding;
        settingsLayoutBinding.saveButton.setImageDrawable(ContextCompat.getDrawable(getTargetActivity(), i));
        settingsLayoutBinding.mainSettingsPage.setVisibility(8);
        settingsLayoutBinding.pageName.setText(str);
        settingsLayoutBinding.settingsLayout.setBackgroundColor(0);
        this.isMenuMap = true;
        this.isShowControllerSetting = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetSettings() {
        SettingsMenuDefaults.reset(getTargetActivity());
        KeyboardKeeper.INSTANCE.syncFromSettings(getTargetActivity());
        restoreSettings();
        SettingsAdapter settingsAdapter = this.settingsAdapter;
        int i = this.currPage;
        settingsAdapter.setSettings(i, (List) MapsKt.getValue(pagesSettingsMap, Integer.valueOf(i)));
        Toast.makeText(getTargetActivity(), "Настройки сброшены!", 0).show();
        SAMPUIElement.notifyClick$default(this, 0, 8, null, 4, null);
    }

    private final void initNavigationMenu() {
        final SettingsLayoutBinding settingsLayoutBinding = this.settingsBinding;
        settingsLayoutBinding.mainPageButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.initNavigationMenu$lambda$0$0(SettingsMenuScreen.this, settingsLayoutBinding, view);
            }
        });
        settingsLayoutBinding.controlPageButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.initNavigationMenu$lambda$0$1(SettingsMenuScreen.this, settingsLayoutBinding, view);
            }
        });
        settingsLayoutBinding.soundPageButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.initNavigationMenu$lambda$0$2(SettingsMenuScreen.this, settingsLayoutBinding, view);
            }
        });
        settingsLayoutBinding.graphicPageButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.initNavigationMenu$lambda$0$3(SettingsMenuScreen.this, settingsLayoutBinding, view);
            }
        });
        settingsLayoutBinding.exitPageButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.initNavigationMenu$lambda$0$4(SettingsMenuScreen.this, view);
            }
        });
        settingsLayoutBinding.saveButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.settingsMenu.SettingsMenuScreen$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsMenuScreen.initNavigationMenu$lambda$0$5(SettingsMenuScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNavigationMenu$lambda$0$0(SettingsMenuScreen settingsMenuScreen, SettingsLayoutBinding settingsLayoutBinding, View view) {
        settingsMenuScreen.setupThemeForNavigationMenu();
        ConstraintLayout mainPageButton = settingsLayoutBinding.mainPageButton;
        Intrinsics.checkNotNullExpressionValue(mainPageButton, "mainPageButton");
        TextView mainPageButtonTxt = settingsLayoutBinding.mainPageButtonTxt;
        Intrinsics.checkNotNullExpressionValue(mainPageButtonTxt, "mainPageButtonTxt");
        ImageView mainPageButtonIc = settingsLayoutBinding.mainPageButtonIc;
        Intrinsics.checkNotNullExpressionValue(mainPageButtonIc, "mainPageButtonIc");
        settingsMenuScreen.setupNavigationLogic(mainPageButton, mainPageButtonTxt, mainPageButtonIc, R.id.main_page_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNavigationMenu$lambda$0$1(SettingsMenuScreen settingsMenuScreen, SettingsLayoutBinding settingsLayoutBinding, View view) {
        settingsMenuScreen.setupThemeForNavigationMenu();
        ConstraintLayout controlPageButton = settingsLayoutBinding.controlPageButton;
        Intrinsics.checkNotNullExpressionValue(controlPageButton, "controlPageButton");
        TextView controlPageButtonTxt = settingsLayoutBinding.controlPageButtonTxt;
        Intrinsics.checkNotNullExpressionValue(controlPageButtonTxt, "controlPageButtonTxt");
        ImageView controlPageButtonIc = settingsLayoutBinding.controlPageButtonIc;
        Intrinsics.checkNotNullExpressionValue(controlPageButtonIc, "controlPageButtonIc");
        settingsMenuScreen.setupNavigationLogic(controlPageButton, controlPageButtonTxt, controlPageButtonIc, R.id.control_page_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNavigationMenu$lambda$0$2(SettingsMenuScreen settingsMenuScreen, SettingsLayoutBinding settingsLayoutBinding, View view) {
        settingsMenuScreen.setupThemeForNavigationMenu();
        ConstraintLayout soundPageButton = settingsLayoutBinding.soundPageButton;
        Intrinsics.checkNotNullExpressionValue(soundPageButton, "soundPageButton");
        TextView soundPageButtonTxt = settingsLayoutBinding.soundPageButtonTxt;
        Intrinsics.checkNotNullExpressionValue(soundPageButtonTxt, "soundPageButtonTxt");
        ImageView soundPageButtonIc = settingsLayoutBinding.soundPageButtonIc;
        Intrinsics.checkNotNullExpressionValue(soundPageButtonIc, "soundPageButtonIc");
        settingsMenuScreen.setupNavigationLogic(soundPageButton, soundPageButtonTxt, soundPageButtonIc, R.id.sound_page_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNavigationMenu$lambda$0$3(SettingsMenuScreen settingsMenuScreen, SettingsLayoutBinding settingsLayoutBinding, View view) {
        settingsMenuScreen.setupThemeForNavigationMenu();
        ConstraintLayout graphicPageButton = settingsLayoutBinding.graphicPageButton;
        Intrinsics.checkNotNullExpressionValue(graphicPageButton, "graphicPageButton");
        TextView graphicPageButtonTxt = settingsLayoutBinding.graphicPageButtonTxt;
        Intrinsics.checkNotNullExpressionValue(graphicPageButtonTxt, "graphicPageButtonTxt");
        ImageView graphicPageButtonIc = settingsLayoutBinding.graphicPageButtonIc;
        Intrinsics.checkNotNullExpressionValue(graphicPageButtonIc, "graphicPageButtonIc");
        settingsMenuScreen.setupNavigationLogic(graphicPageButton, graphicPageButtonTxt, graphicPageButtonIc, R.id.graphic_page_button);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNavigationMenu$lambda$0$4(SettingsMenuScreen settingsMenuScreen, View view) {
        SAMPUIElement.notifyClick$default(settingsMenuScreen, 0, 3, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initNavigationMenu$lambda$0$5(SettingsMenuScreen settingsMenuScreen, View view) {
        if (settingsMenuScreen.isMenuMap) {
            SAMPUIElement.notifyClick$default(settingsMenuScreen, 0, 7, null, 4, null);
            settingsMenuScreen.showSettings();
            return;
        }
        settingsMenuScreen.saveSettings();
    }

    private final void saveSettings() {
        for (Map.Entry<Integer, List<SettingItemModel>> entry : pagesSettingsMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            List<SettingItemModel> value = entry.getValue();
            if (intValue == R.id.main_page_button) {
                saveMainPageInfo(value);
            } else if (intValue == R.id.control_page_button) {
                saveControlPageInfo(value);
            } else if (intValue == R.id.sound_page_button) {
                saveSoundPageInfo(value);
            } else if (intValue == R.id.graphic_page_button) {
                saveGraphicsPageInfo(value);
            }
        }
        notifyClick(0, 2, Companion.getSettingsJson(getTargetActivity()));
        Toast.makeText(getTargetActivity(), "Настройки сохранены!", 0).show();
        setVisibility(false);
    }

    private final void saveMainPageInfo(List<SettingItemModel> list) {
        SettingType type = list.get(0).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSelector");
        int indexSelect = ((SettingType.SettingSelector) type).getIndexSelect();
        SettingType type2 = list.get(1).getType();
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSelector");
        int indexSelect2 = ((SettingType.SettingSelector) type2).getIndexSelect();
        SettingType type3 = list.get(2).getType();
        Intrinsics.checkNotNull(type3, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect3 = ((SettingType.SettingTextSwitcher) type3).getIndexSelect();
        SettingType type4 = list.get(3).getType();
        Intrinsics.checkNotNull(type4, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect4 = ((SettingType.SettingTextSwitcher) type4).getIndexSelect();
        SettingType type5 = list.get(4).getType();
        Intrinsics.checkNotNull(type5, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSwitcher");
        boolean isSwitched = ((SettingType.SettingSwitcher) type5).isSwitched();
        SettingType type6 = list.get(5).getType();
        Intrinsics.checkNotNull(type6, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSwitcher");
        boolean isSwitched2 = ((SettingType.SettingSwitcher) type6).isSwitched();
        SettingType type7 = list.get(6).getType();
        Intrinsics.checkNotNull(type7, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSwitcher");
        boolean isSwitched3 = ((SettingType.SettingSwitcher) type7).isSwitched();
        SharedPreferences.Editor edit = this.sharedPref.edit();
        edit.putInt(SettingsMenuDefaults.KEY_CHAT_FONT_SIZE, indexSelect);
        edit.putInt(SettingsMenuDefaults.KEY_CHAT_COUNTS, indexSelect2);
        edit.putInt(SettingsMenuDefaults.KEY_GAME_MODE, indexSelect3);
        edit.putInt(SettingsMenuDefaults.KEY_KEYBOARD_TYPE, indexSelect4);
        edit.putBoolean(SettingsMenuDefaults.KEY_FULL_SCREEN, isSwitched);
        edit.putBoolean(SettingsMenuDefaults.KEY_SHOW_FPS, isSwitched2);
        edit.putBoolean(SettingsMenuDefaults.KEY_TIME_IN_CHAT, isSwitched3);
        edit.commit();
        KeyboardKeeper.INSTANCE.syncFromSettings(getTargetActivity());
    }

    private final void saveControlPageInfo(List<SettingItemModel> list) {
        SettingType type = list.get(0).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect = ((SettingType.SettingTextSwitcher) type).getIndexSelect();
        SettingType type2 = list.get(1).getType();
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSwitcher");
        boolean isSwitched = ((SettingType.SettingSwitcher) type2).isSwitched();
        SharedPreferences.Editor edit = this.sharedPref.edit();
        edit.putInt(SettingsMenuDefaults.KEY_STEERING, indexSelect);
        edit.putBoolean(SettingsMenuDefaults.KEY_BACK_VIEW, isSwitched);
        edit.commit();
    }

    private final void saveSoundPageInfo(List<SettingItemModel> list) {
        SettingType type = list.get(0).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value = ((SettingType.SettingSlider) type).getValue();
        SettingType type2 = list.get(1).getType();
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value2 = ((SettingType.SettingSlider) type2).getValue();
        SettingType type3 = list.get(2).getType();
        Intrinsics.checkNotNull(type3, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value3 = ((SettingType.SettingSlider) type3).getValue();
        SettingType type4 = list.get(3).getType();
        Intrinsics.checkNotNull(type4, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value4 = ((SettingType.SettingSlider) type4).getValue();
        SettingType type5 = list.get(4).getType();
        Intrinsics.checkNotNull(type5, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value5 = ((SettingType.SettingSlider) type5).getValue();
        SettingType type6 = list.get(5).getType();
        Intrinsics.checkNotNull(type6, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSwitcher");
        boolean isSwitched = ((SettingType.SettingSwitcher) type6).isSwitched();
        SettingType type7 = list.get(6).getType();
        Intrinsics.checkNotNull(type7, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSwitcher");
        boolean isSwitched2 = ((SettingType.SettingSwitcher) type7).isSwitched();
        SharedPreferences.Editor edit = this.sharedPref.edit();
        edit.putInt(SettingsMenuDefaults.KEY_VOLUME_SURROUNDING, value);
        edit.putInt(SettingsMenuDefaults.KEY_VOICE_CHAT_VOLUME, value2);
        edit.putInt(SettingsMenuDefaults.KEY_MIC_VOLUME, value3);
        edit.putInt(SettingsMenuDefaults.KEY_VEHICLE_MUSIC_VOLUME, value4);
        edit.putInt(SettingsMenuDefaults.KEY_BOOM_BOX_MUSIC_SOUND, value5);
        edit.putBoolean(SettingsMenuDefaults.KEY_MIC_ENABLED, isSwitched);
        edit.putBoolean(SettingsMenuDefaults.KEY_AMBIENT_SOUNDS, isSwitched2);
        edit.commit();
    }

    private final void saveGraphicsPageInfo(List<SettingItemModel> list) {
        SettingType type = list.get(0).getType();
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect = ((SettingType.SettingTextSwitcher) type).getIndexSelect();
        SettingType type2 = list.get(1).getType();
        Intrinsics.checkNotNull(type2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect2 = ((SettingType.SettingTextSwitcher) type2).getIndexSelect();
        SettingType type3 = list.get(2).getType();
        Intrinsics.checkNotNull(type3, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect3 = ((SettingType.SettingTextSwitcher) type3).getIndexSelect();
        SettingType type4 = list.get(3).getType();
        Intrinsics.checkNotNull(type4, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSwitcher");
        boolean isSwitched = ((SettingType.SettingSwitcher) type4).isSwitched();
        SettingType type5 = list.get(4).getType();
        Intrinsics.checkNotNull(type5, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect4 = ((SettingType.SettingTextSwitcher) type5).getIndexSelect();
        int[] iArr = msaaSamples;
        int i = iArr[RangesKt.coerceIn(indexSelect4, (ClosedRange<Integer>) ArraysKt.getIndices(iArr))];
        SettingType type6 = list.get(5).getType();
        Intrinsics.checkNotNull(type6, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int videoAnisotropyToSave = SettingsMenuDefaults.INSTANCE.videoAnisotropyToSave(this.sharedPref.getInt(SettingsMenuDefaults.KEY_VIDEO_ANISOTROPY, 2), this.anisotropyLevels, ((SettingType.SettingTextSwitcher) type6).getIndexSelect(), this.anisotropyChanged);
        SettingType type7 = list.get(6).getType();
        Intrinsics.checkNotNull(type7, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect5 = ((SettingType.SettingTextSwitcher) type7).getIndexSelect();
        SettingType type8 = list.get(7).getType();
        Intrinsics.checkNotNull(type8, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value = ((SettingType.SettingSlider) type8).getValue();
        SettingType type9 = list.get(8).getType();
        Intrinsics.checkNotNull(type9, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int coerceIn = RangesKt.coerceIn(((SettingType.SettingSlider) type9).getValue(), 25, 100);
        SettingType type10 = list.get(9).getType();
        Intrinsics.checkNotNull(type10, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value2 = ((SettingType.SettingSlider) type10).getValue();
        SettingType type11 = list.get(10).getType();
        Intrinsics.checkNotNull(type11, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingSlider");
        int value3 = ((SettingType.SettingSlider) type11).getValue();
        SettingType type12 = list.get(11).getType();
        Intrinsics.checkNotNull(type12, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.settingsMenu.model.SettingType.SettingTextSwitcher");
        int indexSelect6 = ((SettingType.SettingTextSwitcher) type12).getIndexSelect();
        SharedPreferences.Editor edit = this.sharedPref.edit();
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_EFFECTS, indexSelect);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_SHADOWS, indexSelect2);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_VEHICLES, indexSelect3);
        edit.putBoolean(SettingsMenuDefaults.KEY_VIDEO_VSYNC, isSwitched);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_MSAA, i);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_ANISOTROPY, videoAnisotropyToSave);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_WATER_QUALITY, indexSelect5);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_FAR_CLIP, value);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_BRIGHTNESS, coerceIn);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_MAX_FPS, value2);
        edit.putInt(SettingsMenuDefaults.KEY_VIDEO_RENDER_SCALE, value3);
        edit.putInt(SettingsMenuDefaults.KEY_CPU_MODE, indexSelect6);
        edit.commit();
    }

    private final void setupNavigationLogic(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, int i) {
        int color = getTargetActivity().getResources().getColor(R.color.black, getTargetActivity().getTheme());
        int parseColor = Color.parseColor("#000000");
        setupThemeForNavigationMenu();
        constraintLayout.setBackgroundResource(R.drawable.settings_menu_active_button_bg);
        textView.setTextColor(color);
        imageView.setColorFilter(parseColor);
        this.currPage = i;
        this.settingsAdapter.setSettings(i, (List) MapsKt.getValue(pagesSettingsMap, Integer.valueOf(i)));
    }

    private final void setupThemeForNavigationMenu() {
        SettingsLayoutBinding settingsLayoutBinding = this.settingsBinding;
        int color = getTargetActivity().getResources().getColor(R.color.white, getTargetActivity().getTheme());
        int parseColor = Color.parseColor("#3E8BFF");
        settingsLayoutBinding.mainPageButton.setBackgroundResource(R.drawable.settings_menu_inactive_button_bg);
        settingsLayoutBinding.controlPageButton.setBackgroundResource(R.drawable.settings_menu_inactive_button_bg);
        settingsLayoutBinding.soundPageButton.setBackgroundResource(R.drawable.settings_menu_inactive_button_bg);
        settingsLayoutBinding.graphicPageButton.setBackgroundResource(R.drawable.settings_menu_inactive_button_bg);
        settingsLayoutBinding.exitPageButton.setBackgroundResource(R.drawable.settings_menu_inactive_button_bg);
        settingsLayoutBinding.mainPageButtonIc.setColorFilter(parseColor);
        settingsLayoutBinding.controlPageButtonIc.setColorFilter(parseColor);
        settingsLayoutBinding.soundPageButtonIc.setColorFilter(parseColor);
        settingsLayoutBinding.graphicPageButtonIc.setColorFilter(parseColor);
        settingsLayoutBinding.mainPageButtonTxt.setTextColor(color);
        settingsLayoutBinding.controlPageButtonTxt.setTextColor(color);
        settingsLayoutBinding.soundPageButtonTxt.setTextColor(color);
        settingsLayoutBinding.graphicPageButtonTxt.setTextColor(color);
    }

    private final void initSettingMenu() {
        this.settingsBinding.settingsRc.setAdapter(this.settingsAdapter);
        this.settingsAdapter.setSettings(R.id.main_page_button, (List) MapsKt.getValue(pagesSettingsMap, Integer.valueOf(R.id.main_page_button)));
    }

    private final void onClickLink(int i) {
        SAMPUIElement.notifyClick$default(this, 0, i, null, 4, null);
        if (i == 4) {
            showMap("Пешком", R.drawable.setting_ic_done, true);
        } else if (i != 5) {
        } else {
            showMap("В машине", R.drawable.setting_ic_done, true);
        }
    }

    @Override // ru.mrlargha.commonui.core.SAMPUIElement
    public void onBackendMessageHandled(String data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (i == 1) {
            showMap$default(this, null, 0, false, 7, null);
        }
    }

    /* compiled from: SettingsMenuScreen.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/settingsMenu/SettingsMenuScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.SETTINGS);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new SettingsMenuScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
