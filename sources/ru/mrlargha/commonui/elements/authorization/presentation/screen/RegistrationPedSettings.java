package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.IBackendNotifier;
import ru.mrlargha.commonui.databinding.BackgroundVideoBinding;
import ru.mrlargha.commonui.databinding.RegistrationPedSettingsBinding;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationInterfaceType;
import ru.mrlargha.commonui.elements.authorization.domain.controller.RegistrationVideoModeType;
import ru.mrlargha.commonui.elements.authorization.domain.registration.RegistrationArizonaPedSettingsData;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController;
import ru.mrlargha.commonui.elements.authorization.presentation.InterfaceManager;
import ru.mrlargha.commonui.utils.StringKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: RegistrationPedSettings.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0015H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0015H\u0002J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020)H\u0002J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0005H\u0002J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\u0015J\u0010\u00103\u001a\u00020)2\u0006\u00104\u001a\u000205H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\u001a\u001a>\u0012\u0004\u0012\u00020\u0015\u00124\u00122\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001c0\u001b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001c0\u001b0\u001b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001c0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/RegistrationPedSettings;", "Lru/mrlargha/commonui/elements/authorization/presentation/InterfaceController;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "getTargetActivity", "()Landroid/app/Activity;", "getBackendID", "()I", "registrationPedSettings", "Landroidx/constraintlayout/widget/ConstraintLayout;", "registrationPedSettingsBinding", "Lru/mrlargha/commonui/databinding/RegistrationPedSettingsBinding;", "videoBinding", "Lru/mrlargha/commonui/databinding/BackgroundVideoBinding;", "notifier", "Lru/mrlargha/commonui/core/IBackendNotifier;", "maleGender", "", "femaleGender", "arizonaSkins", "", "Lkotlin/jvm/internal/EnhancedNullability;", "arizonaClothes", "Lkotlin/Pair;", "", "arizonaMenClothes", "arizonaWomenClothes", "choseSkin", "genders", "rodinaClothes", "rodinaMenClothes", "rodinaWomenClothes", "choseGender", "clotheListPosition", "getGender", "chooseGender", "setTextClothesName", "", "name", "sendDataToChangeSkin", "byteArray", "", "sendData", "skinSelector", TtmlNode.ATTR_ID, "onServerPedSettingsResponse", "data", "setVisible", "visible", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RegistrationPedSettings implements InterfaceController {
    private final Map<String, Pair<Pair<String, List<Integer>>, Pair<String, List<Integer>>>> arizonaClothes;
    private final List<String> arizonaMenClothes;
    private final Map<String, ConstraintLayout> arizonaSkins;
    private final List<String> arizonaWomenClothes;
    private final int backendID;
    private String choseGender;
    private int choseSkin;
    private int clotheListPosition;
    private final String femaleGender;
    private final Map<String, ConstraintLayout> genders;
    private final String maleGender;
    private final IBackendNotifier notifier;
    private final ConstraintLayout registrationPedSettings;
    private final RegistrationPedSettingsBinding registrationPedSettingsBinding;
    private final Map<String, List<Integer>> rodinaClothes;
    private final List<String> rodinaMenClothes;
    private final List<String> rodinaWomenClothes;
    private final Activity targetActivity;
    private final BackgroundVideoBinding videoBinding;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$5(View view) {
    }

    public RegistrationPedSettings(Activity targetActivity, int i) {
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        this.targetActivity = targetActivity;
        this.backendID = i;
        View inflate = targetActivity.getLayoutInflater().inflate(R.layout.registration_ped_settings, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        this.registrationPedSettings = constraintLayout;
        RegistrationPedSettingsBinding bind = RegistrationPedSettingsBinding.bind(constraintLayout);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.registrationPedSettingsBinding = bind;
        InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        BackgroundVideoBinding mainBinding = ((RegistrationVideoBackground) orCreateInterface).getMainBinding();
        this.videoBinding = mainBinding;
        Intrinsics.checkNotNull(targetActivity, "null cannot be cast to non-null type ru.mrlargha.commonui.core.IBackendNotifier");
        this.notifier = (IBackendNotifier) targetActivity;
        String string = targetActivity.getString(R.string.male);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.maleGender = string;
        String string2 = targetActivity.getString(R.string.female);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.femaleGender = string2;
        Map<String, ConstraintLayout> mapOf = MapsKt.mapOf(TuplesKt.to("white", bind.registrationPedSkinWhiteContainer), TuplesKt.to("black", bind.registrationPedSkinBlackContainer));
        this.arizonaSkins = mapOf;
        Map<String, Pair<Pair<String, List<Integer>>, Pair<String, List<Integer>>>> mapOf2 = MapsKt.mapOf(TuplesKt.to("white", new Pair(TuplesKt.to(string, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.skin_3), Integer.valueOf(R.drawable.skin_5), Integer.valueOf(R.drawable.skin_6), Integer.valueOf(R.drawable.skin_7), Integer.valueOf(R.drawable.skin_8)})), TuplesKt.to(string2, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.skin_1), Integer.valueOf(R.drawable.skin_2)})))), TuplesKt.to("black", new Pair(TuplesKt.to(string, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.skin_4), Integer.valueOf(R.drawable.skin_5), Integer.valueOf(R.drawable.skin_6), Integer.valueOf(R.drawable.skin_7), Integer.valueOf(R.drawable.skin_8)})), TuplesKt.to(string2, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.skin_1), Integer.valueOf(R.drawable.skin_2)})))));
        this.arizonaClothes = mapOf2;
        this.arizonaMenClothes = CollectionsKt.listOf((Object[]) new String[]{"Бездомный #1", "Бездомный #2", "Бездомный", "Гражданский", "Деревенщина", "Бездомный", "Бездомный", "Бездомный", "Бездомный", "Бездомный", "Бездомный"});
        this.arizonaWomenClothes = CollectionsKt.listOf((Object[]) new String[]{"Гражданская", "Ночная бабочка", "Бездомная #1", "Бездомная #2", "Бездомная #3"});
        this.genders = MapsKt.mapOf(TuplesKt.to(string, bind.registrationPedMenContainer), TuplesKt.to(string2, bind.registrationPedWomenContainer));
        Map<String, List<Integer>> mapOf3 = MapsKt.mapOf(TuplesKt.to(string, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.skin_male_1), Integer.valueOf(R.drawable.skin_male_2), Integer.valueOf(R.drawable.skin_male_3)})), TuplesKt.to(string2, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.drawable.skin_female_1), Integer.valueOf(R.drawable.skin_female_2), Integer.valueOf(R.drawable.skin_female_3)})));
        this.rodinaClothes = mapOf3;
        this.rodinaMenClothes = CollectionsKt.listOf((Object[]) new String[]{string + " #1", string + " #2", string + " #3"});
        this.rodinaWomenClothes = CollectionsKt.listOf((Object[]) new String[]{string2 + " #1", string2 + " #2", string2 + " #3"});
        this.choseGender = string;
        mainBinding.video.addView(bind.registrationPedSettings, -1, -1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(mainBinding.video);
        constraintSet.connect(bind.registrationPedSettings.getId(), 1, mainBinding.video.getId(), 1);
        constraintSet.connect(bind.registrationPedSettings.getId(), 3, mainBinding.video.getId(), 3);
        constraintSet.connect(bind.registrationPedSettings.getId(), 4, mainBinding.video.getId(), 4);
        constraintSet.applyTo(mainBinding.video);
        InterfaceController orCreateInterface2 = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), targetActivity, i);
        Intrinsics.checkNotNull(orCreateInterface2, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
        ((RegistrationVideoBackground) orCreateInterface2).selectVideoMode(RegistrationVideoModeType.STOP_VIDEO);
        if (!UtilsKt.isArizonaType()) {
            ConstraintLayout registrationPedSkinContainer = bind.registrationPedSkinContainer;
            Intrinsics.checkNotNullExpressionValue(registrationPedSkinContainer, "registrationPedSkinContainer");
            registrationPedSkinContainer.setVisibility(8);
        }
        mapOf2.get(skinSelector(this.choseSkin));
        mapOf3.get(string);
        mapOf3.get(string2);
        for (Map.Entry<String, ConstraintLayout> entry : mapOf.entrySet()) {
            final String key = entry.getKey();
            ConstraintLayout value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "component2(...)");
            value.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RegistrationPedSettings.lambda$0$0(RegistrationPedSettings.this, key, view);
                }
            });
        }
        for (Map.Entry<String, ConstraintLayout> entry2 : this.genders.entrySet()) {
            final String key2 = entry2.getKey();
            ConstraintLayout value2 = entry2.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "component2(...)");
            value2.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RegistrationPedSettings.lambda$1$0(RegistrationPedSettings.this, key2, view);
                }
            });
        }
        this.registrationPedSettingsBinding.registrationPedClothesLeftButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationPedSettings._init_$lambda$2(RegistrationPedSettings.this, view);
            }
        });
        this.registrationPedSettingsBinding.registrationPedClothesRightButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationPedSettings._init_$lambda$3(RegistrationPedSettings.this, view);
            }
        });
        this.registrationPedSettingsBinding.registrationPedStartGameButton.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationPedSettings.this.sendData();
            }
        });
        this.registrationPedSettingsBinding.registrationPedSettings.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationPedSettings$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationPedSettings._init_$lambda$5(view);
            }
        });
    }

    public final int getBackendID() {
        return this.backendID;
    }

    public final Activity getTargetActivity() {
        return this.targetActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$0$0(RegistrationPedSettings registrationPedSettings, String str, View view) {
        registrationPedSettings.clotheListPosition = 0;
        registrationPedSettings.choseSkin = !Intrinsics.areEqual(str, "white") ? 1 : 0;
        byte[] bytes = StringKt.toStringJson(new RegistrationArizonaPedSettingsData(registrationPedSettings.getGender(registrationPedSettings.choseGender), registrationPedSettings.choseSkin, registrationPedSettings.clotheListPosition)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        registrationPedSettings.sendDataToChangeSkin(bytes);
        view.setBackgroundResource(R.drawable.registration_selected_border);
        Map<String, ConstraintLayout> map = registrationPedSettings.arizonaSkins;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ConstraintLayout> entry : map.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object value = entry2.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "component2(...)");
            ((ConstraintLayout) value).setBackgroundResource(R.color.ap_transparent);
        }
        if (Intrinsics.areEqual(registrationPedSettings.choseGender, registrationPedSettings.maleGender)) {
            registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaMenClothes.get(0));
        } else {
            registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaWomenClothes.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void lambda$1$0(RegistrationPedSettings registrationPedSettings, String str, View view) {
        registrationPedSettings.clotheListPosition = 0;
        registrationPedSettings.choseGender = str;
        if (Intrinsics.areEqual(str, registrationPedSettings.maleGender)) {
            if (UtilsKt.isArizonaType()) {
                registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaMenClothes.get(0));
            } else {
                registrationPedSettings.setTextClothesName(registrationPedSettings.rodinaMenClothes.get(0));
            }
        } else if (UtilsKt.isArizonaType()) {
            registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaWomenClothes.get(0));
        } else {
            registrationPedSettings.setTextClothesName(registrationPedSettings.rodinaWomenClothes.get(0));
        }
        byte[] bytes = StringKt.toStringJson(new RegistrationArizonaPedSettingsData(registrationPedSettings.getGender(registrationPedSettings.choseGender), registrationPedSettings.choseSkin, registrationPedSettings.clotheListPosition)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        registrationPedSettings.sendDataToChangeSkin(bytes);
        view.setBackgroundResource(R.drawable.registration_selected_border);
        Map<String, ConstraintLayout> map = registrationPedSettings.genders;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ConstraintLayout> entry : map.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object value = entry2.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "component2(...)");
            ((ConstraintLayout) value).setBackgroundResource(R.color.ap_transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$2(RegistrationPedSettings registrationPedSettings, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(registrationPedSettings.targetActivity, R.anim.bounce));
        String str = registrationPedSettings.choseGender;
        if (Intrinsics.areEqual(str, registrationPedSettings.maleGender)) {
            if (registrationPedSettings.clotheListPosition != 0) {
                if (UtilsKt.isArizonaType()) {
                    registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaMenClothes.get(registrationPedSettings.clotheListPosition - 1));
                } else {
                    registrationPedSettings.setTextClothesName(registrationPedSettings.rodinaMenClothes.get(registrationPedSettings.clotheListPosition - 1));
                }
                registrationPedSettings.clotheListPosition--;
            }
        } else if (Intrinsics.areEqual(str, registrationPedSettings.femaleGender) && registrationPedSettings.clotheListPosition != 0) {
            if (UtilsKt.isArizonaType()) {
                registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaWomenClothes.get(registrationPedSettings.clotheListPosition - 1));
            } else {
                registrationPedSettings.setTextClothesName(registrationPedSettings.rodinaWomenClothes.get(registrationPedSettings.clotheListPosition - 1));
            }
            registrationPedSettings.clotheListPosition--;
        }
        byte[] bytes = StringKt.toStringJson(new RegistrationArizonaPedSettingsData(registrationPedSettings.getGender(registrationPedSettings.choseGender), registrationPedSettings.choseSkin, registrationPedSettings.clotheListPosition)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        registrationPedSettings.sendDataToChangeSkin(bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void _init_$lambda$3(RegistrationPedSettings registrationPedSettings, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(registrationPedSettings.targetActivity, R.anim.bounce));
        String str = registrationPedSettings.choseGender;
        if (Intrinsics.areEqual(str, registrationPedSettings.maleGender)) {
            if (UtilsKt.isArizonaType()) {
                if (registrationPedSettings.clotheListPosition != registrationPedSettings.arizonaMenClothes.size() - 1) {
                    registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaMenClothes.get(registrationPedSettings.clotheListPosition + 1));
                    registrationPedSettings.clotheListPosition++;
                }
            } else if (registrationPedSettings.clotheListPosition != registrationPedSettings.rodinaMenClothes.size() - 1) {
                registrationPedSettings.setTextClothesName(registrationPedSettings.rodinaMenClothes.get(registrationPedSettings.clotheListPosition + 1));
                registrationPedSettings.clotheListPosition++;
            }
        } else if (Intrinsics.areEqual(str, registrationPedSettings.femaleGender)) {
            if (UtilsKt.isArizonaType()) {
                if (registrationPedSettings.clotheListPosition != registrationPedSettings.arizonaWomenClothes.size() - 1) {
                    registrationPedSettings.setTextClothesName(registrationPedSettings.arizonaWomenClothes.get(registrationPedSettings.clotheListPosition + 1));
                    registrationPedSettings.clotheListPosition++;
                }
            } else if (registrationPedSettings.clotheListPosition != registrationPedSettings.rodinaWomenClothes.size() - 1) {
                registrationPedSettings.setTextClothesName(registrationPedSettings.rodinaWomenClothes.get(registrationPedSettings.clotheListPosition + 1));
                registrationPedSettings.clotheListPosition++;
            }
        }
        byte[] bytes = StringKt.toStringJson(new RegistrationArizonaPedSettingsData(registrationPedSettings.getGender(registrationPedSettings.choseGender), registrationPedSettings.choseSkin, registrationPedSettings.clotheListPosition)).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        registrationPedSettings.sendDataToChangeSkin(bytes);
    }

    private final int getGender(String str) {
        return (!Intrinsics.areEqual(str, this.maleGender) && Intrinsics.areEqual(str, this.femaleGender)) ? 1 : 0;
    }

    private final void setTextClothesName(String str) {
        this.registrationPedSettingsBinding.registrationPedClothesName.setText(str);
    }

    private final void sendDataToChangeSkin(byte[] bArr) {
        this.notifier.clickedWrapper(this.backendID, 3, 1, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendData() {
        this.notifier.clickedWrapper(this.backendID, 3, 0);
    }

    private final String skinSelector(int i) {
        if (i != 0) {
            if (i == 1) {
                return "black";
            }
            return "";
        }
        return "white";
    }

    public final void onServerPedSettingsResponse(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(data, "error")) {
            Activity activity = this.targetActivity;
            Toast.makeText(activity, activity.getString(R.string.registration_nickname_taken), 1).show();
            setVisible(false);
            InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.REGISTRATION_INIT.getId(), this.targetActivity, this.backendID).setVisible(true);
            InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.AUTHORIZATION_NEWS.getId(), this.targetActivity, this.backendID).setVisible(false);
        } else if (Intrinsics.areEqual(data, FirebaseAnalytics.Param.SUCCESS)) {
            InterfaceController orCreateInterface = InterfaceManager.Companion.getOrCreateInterface(RegistrationInterfaceType.VIDEO_BACKGROUND.getId(), this.targetActivity, this.backendID);
            Intrinsics.checkNotNull(orCreateInterface, "null cannot be cast to non-null type ru.mrlargha.commonui.elements.authorization.presentation.screen.RegistrationVideoBackground");
            RegistrationVideoBackground registrationVideoBackground = (RegistrationVideoBackground) orCreateInterface;
            registrationVideoBackground.selectVideoMode(RegistrationVideoModeType.VIDEO_HIDE);
            registrationVideoBackground.setVisibility(false);
            setVisible(false);
        }
    }

    @Override // ru.mrlargha.commonui.elements.authorization.presentation.InterfaceController
    public void setVisible(boolean z) {
        this.registrationPedSettingsBinding.registrationPedSettings.setVisibility(z ? 0 : 8);
    }
}
